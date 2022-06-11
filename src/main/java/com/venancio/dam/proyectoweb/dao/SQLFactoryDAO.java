package com.venancio.dam.proyectoweb.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SQLFactoryDAO extends FactoryDAO {

	/*
	 * Este no es el url, hay que poner el que si es
	 */
	private final String URL = "jdbc:mysql://127.0.0.1:3307/ramirez";
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String USER = "";

	public void obtenerCadenaConexion() {
		Path file = Paths.get("Ficheros/conexion.txt");
		try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)){
			String line = null;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getURL() {
		return URL;
	}

	public String getDriver() {
		return DRIVER;
	}

	public SQLAlumnoDAO getAlumnoDAO() {
		return new SQLAlumnoDAO();
	}

	public SQLCursoDAO getCursoDAO() {
		return new SQLCursoDAO();
	}

	public SQLEvaluacionDAO getEvaluacionDAO() {
		return new SQLEvaluacionDAO();
	}
}
