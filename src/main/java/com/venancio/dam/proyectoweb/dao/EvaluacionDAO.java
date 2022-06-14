package com.venancio.dam.proyectoweb.dao;

import java.util.Set;

import com.venancio.dam.proyectoweb.model.Evaluacion;

public interface EvaluacionDAO {

	public Set<Evaluacion> mostrarNotas();

	public Set<Evaluacion> mostrarNotasAlumno(String codigo);
}
