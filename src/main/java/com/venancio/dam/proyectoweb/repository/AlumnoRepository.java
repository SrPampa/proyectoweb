package com.venancio.dam.proyectoweb.repository;

import java.util.Set;

import com.venancio.dam.proyectoweb.dao.SQLAlumnoDAO;
import com.venancio.dam.proyectoweb.model.Alumno;

public class AlumnoRepository {

	private SQLAlumnoDAO dao;
	
	private static AlumnoRepository instance;
	
	public static synchronized AlumnoRepository getInstance() {
		if (instance ==null) {
			instance = new AlumnoRepository ();
		}
		return instance;
	}

	public AlumnoRepository() {
		this.dao = new SQLAlumnoDAO();
	}

	public Set<Alumno> getAlumnos() {
		return this.dao.getAlumnos();
	}

	public boolean addAlumno(Alumno a) {
		// TODO Auto-generated method stub
		return this.dao.addAlumno(a);
	}

	public int updateAlumno(int cod, Alumno a) {
		return dao.modificarAlumno(a, cod);
	}

	public boolean deleteAlumno(int cod) {
		return dao.deleteAlumno(cod);
	
	}
}
