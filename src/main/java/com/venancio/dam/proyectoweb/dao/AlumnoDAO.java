package com.venancio.dam.proyectoweb.dao;

import java.util.Set;

import com.venancio.dam.proyectoweb.model.Alumno;

public interface AlumnoDAO {

	public Set<Alumno> getAlumnos();

	public boolean addAlumno(Alumno a);

	public int modificarAlumno(Alumno a, int codigo);

	public boolean deleteAlumno(int cod);
}
