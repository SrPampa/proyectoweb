package com.venancio.dam.proyectoweb.repository;

import java.util.Set;

import com.venancio.dam.proyectoweb.dao.AlumnoDAO;
import com.venancio.dam.proyectoweb.dao.FactoryDAO;
import com.venancio.dam.proyectoweb.model.Alumno;

public class AlumnoRepository {

	private AlumnoDAO dao;
	
	private static AlumnoRepository instance;
	
	public static synchronized AlumnoRepository getInstance() {
		if (instance ==null) {
			instance = new AlumnoRepository ();
		}
		return instance;
	}

	public AlumnoRepository() {
		this.dao = FactoryDAO.getFactoryDAO(FactoryDAO.SQL).getAlumnoDAO();
	}

	public Set<Alumno> getAlumnos() {
		return this.dao.getAlumnos();
	}

	public boolean addAlumno(Alumno a) {
		return this.dao.addAlumno(a);
	}

	public int updateAlumno(int cod, Alumno a) {
		return dao.modificarAlumno(a, cod);
	}

	public boolean deleteAlumno(int cod) {
		return dao.deleteAlumno(cod);
	
	}
}
