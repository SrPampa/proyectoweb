package com.venancio.dam.proyectoweb.dao;

public abstract class FactoryDAO {

	public static final int SQL = 1;
	public static final int ORACLE = 2;

	public abstract AlumnoDAO getAlumnoDAO();

	public abstract CursoDAO getCursoDAO();

	public abstract EvaluacionDAO getEvaluacionDAO();

	public static FactoryDAO getFactoryDAO(int whichFactory) {
		switch (whichFactory) {
		case 1:
			return new SQLFactoryDAO();
		case 2:
			return new OracleFactoryDAO();
		default:
			return null;
		}
	}
}
