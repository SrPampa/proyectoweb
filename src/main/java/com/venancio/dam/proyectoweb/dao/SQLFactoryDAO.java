package com.venancio.dam.proyectoweb.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.venancio.dam.proyectoweb.utils.DBConnection;

public class SQLFactoryDAO extends FactoryDAO {


	private final String RUTA = "Ficheros/";
	private final String DELIMITER = "@";


	private String DRIVER;
	private String URL;

	private String IP;
	private String PORT;
	private String BDNAME;
	private String CADENA_CONEXION = URL + IP + PORT + BDNAME;

	public void fillConfig() {
		Path file = Paths.get(RUTA, "conexion.txt");
		try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
			String line = null;
			while (br.readLine() != null) {
				line = br.readLine();
				String[] aux = line.split(DELIMITER);
				switch (aux[0]) {
				case "URL":
					this.URL = aux[1];
					break;
				case "IP":
					this.IP = aux[1];
					break;
				case "PORT":
					this.PORT = aux[1];
					break;
				case "BDNAME":
					this.BDNAME = aux[1];
					break;
				case "DRIVER":
					this.DRIVER = aux[1];
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getCadenaConexion() {
		return CADENA_CONEXION;
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
