package com.venancio.dam.proyectoweb.dao;

import java.util.Set;

import com.venancio.dam.proyectoweb.model.Alumno;

public interface AlumnoDAO {

	public Set<Alumno> getAlumnos();

	public boolean addAlumno(Alumno a);

	public int modificarAlumno(Alumno a, String codigo);

	public boolean deleteAlumno(String cod);
}
