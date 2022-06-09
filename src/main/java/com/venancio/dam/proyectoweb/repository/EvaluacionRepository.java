package com.venancio.dam.proyectoweb.repository;

import java.util.Set;

import com.venancio.dam.proyectoweb.dao.SQLEvaluacionDAO;
import com.venancio.dam.proyectoweb.model.Evaluacion;

public class EvaluacionRepository {

	private SQLEvaluacionDAO dao;

	private static EvaluacionRepository instance;

	public static synchronized EvaluacionRepository getInstance() {
		if (instance == null) {
			instance = new EvaluacionRepository();
		}
		return instance;
	}

	public EvaluacionRepository() {
		this.dao = new SQLEvaluacionDAO();
	}

	public Set<Evaluacion> mostrarNotas() {
		return dao.mostrarNotas();
	}

	public Set<Evaluacion> mostrarNotasDeAlumno(int codigo) {
		return dao.mostrarNotasAlumno(codigo);
	}
}
