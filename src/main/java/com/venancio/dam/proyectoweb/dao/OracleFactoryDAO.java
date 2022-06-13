package com.venancio.dam.proyectoweb.dao;

public class OracleFactoryDAO extends FactoryDAO {

	private final String URL = "";
	private final String DRIVER = "";
	
	@Override
	public AlumnoDAO getAlumnoDAO() {
		return null;
	}

	@Override
	public CursoDAO getCursoDAO() {
		return null;
	}

	@Override
	public EvaluacionDAO getEvaluacionDAO() {
		return null;
	}

}
