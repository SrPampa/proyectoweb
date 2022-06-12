package com.venancio.dam.proyectoweb.dao;

public class SQLFactoryDAO extends FactoryDAO {


	private final String URL = "jdbc:mysql://127.0.0.1:3307/ramirez";
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";


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
