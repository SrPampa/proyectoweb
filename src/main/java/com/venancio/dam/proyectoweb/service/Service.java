package com.venancio.dam.proyectoweb.service;

import java.util.Set;

import com.venancio.dam.proyectoweb.model.Alumno;
import com.venancio.dam.proyectoweb.model.Curso;
import com.venancio.dam.proyectoweb.model.Evaluacion;
import com.venancio.dam.proyectoweb.repository.AlumnoRepository;
import com.venancio.dam.proyectoweb.repository.CursoRepository;
import com.venancio.dam.proyectoweb.repository.EvaluacionRepository;

public class Service {

	public Set<Evaluacion> mostrarNotas() {
		return EvaluacionRepository.getInstance().mostrarNotas();

	}

	public Set<Alumno> getAlumnos() {
		return AlumnoRepository.getInstance().getAlumnos();
	}

	public Set<Curso> getCursos() {
		return CursoRepository.getInstance().getCursos();
	}

	public Set<Evaluacion> mostrarNotasDeAlumno(int codigo) {
		return EvaluacionRepository.getInstance().mostrarNotasDeAlumno(codigo);
	}

	public boolean addAlumno(Alumno a) {
		return AlumnoRepository.getInstance().addAlumno(a);
	}

	public int updateAlumno(int cod, Alumno a) {
		return AlumnoRepository.getInstance().updateAlumno(cod, a);

	}
	
	public boolean deleteAlumno (int cod) {
		return AlumnoRepository.getInstance().deleteAlumno(cod);
	}
}
