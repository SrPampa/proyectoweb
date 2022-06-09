package com.venancio.dam.proyectoweb.dao;

public abstract class FactoryDAO {

	public static final int SQL = 1;

	public abstract AlumnoDAO getAlumnoDAO();

	public abstract CursoDAO getCursoDAO();

	public abstract EvaluacionDAO getEvaluacionDAO();

	public static FactoryDAO getFactoryDAO(int whichFactory) {
		if (whichFactory == 1) {
			return new SQLFactoryDAO();
		}
		return null;

	}
}
