package com.venancio.dam.proyectoweb.repository;

import java.util.Set;

import com.venancio.dam.proyectoweb.dao.EvaluacionDAO;
import com.venancio.dam.proyectoweb.dao.FactoryDAO;
import com.venancio.dam.proyectoweb.model.Evaluacion;

public class EvaluacionRepository {

	private EvaluacionDAO dao;

	private static EvaluacionRepository instance;

	public static synchronized EvaluacionRepository getInstance() {
		if (instance == null) {
			instance = new EvaluacionRepository();
		}
		return instance;
	}

	public EvaluacionRepository() {
		this.dao = FactoryDAO.getFactoryDAO(FactoryDAO.SQL).getEvaluacionDAO();
	}

	public Set<Evaluacion> mostrarNotas() {
		return dao.mostrarNotas();
	}

	public Set<Evaluacion> mostrarNotasDeAlumno(String codigo) {
		return dao.mostrarNotasAlumno(codigo);
	}
}
