package com.venancio.dam.proyectoweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.venancio.dam.proyectoweb.dao.FactoryDAO;
import com.venancio.dam.proyectoweb.dao.SQLFactoryDAO;

public class DBConnection {

	private final String USER = "root";
	private final String PASS = "";

	private Connection conexion = null;

	// Singleton
	private static DBConnection instance;

	/**
	 * Return a singleton instance
	 */
	public static synchronized DBConnection getInstance() {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}

	private DBConnection() {
		System.out.println("Creando conexión con la BBDD...");
		SQLFactoryDAO fdao = new SQLFactoryDAO();
		// fdao.fillConfig();
		try {
			Class.forName(fdao.getDriver());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			this.conexion = DriverManager.getConnection(fdao.getCadenaConexion(), USER, PASS);
			System.out.println("Conexión con la BBDD establecida con éxito!!");
		} catch (SQLException e) {
			System.err.println("Error al crear la conexión con la BBDD...");
			System.err.printf("Mensaje   : %s %n", e.getMessage());
			System.err.printf("SQL estado: %s %n", e.getSQLState());
			System.err.printf("Cód error : %s %n", e.getErrorCode());
		}
	}

	public Connection getConnection() {
		return conexion;
	}

	public void destroyConnection() {
		try {
			System.out.println("Cerrando conexión con la BBDD...");
			this.conexion.close();
			System.out.println("Conexión con la BBDD cerrada!!");
		} catch (SQLException e) {
			System.err.println("Error al cerrar la conexión con la BBDD...");
			System.err.printf("Mensaje   : %s %n", e.getMessage());
			System.err.printf("SQL estado: %s %n", e.getSQLState());
			System.err.printf("Cód error : %s %n", e.getErrorCode());
		} finally {
			instance = null;
		}

	}
}
