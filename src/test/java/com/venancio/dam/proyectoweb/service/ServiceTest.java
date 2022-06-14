package com.venancio.dam.proyectoweb.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.venancio.dam.proyectoweb.model.Alumno;
import com.venancio.dam.proyectoweb.model.Curso;
import com.venancio.dam.proyectoweb.model.Evaluacion;

class ServiceTest {

	private static Set<Evaluacion> evaluaciones = null;
	private static Set<Alumno> alumnos = null;
	private static Set<Curso> cursos = null;
	private static Service servicio = new Service();

	@BeforeAll
	static void setUpBeforeClass() {

		evaluaciones = new HashSet<>();
		alumnos = new HashSet<>();
		cursos = new HashSet<>();
	}

	@AfterAll
	static void tearDownAfterClass() {
		evaluaciones = null;
		alumnos = null;
		cursos = null;
	}

	@BeforeEach
	void setUp() {

		Evaluacion evaluacion = new Evaluacion("nombreAlumno", "apellidosAlumno", "nombreCurso", 5, "observaciones");
		evaluaciones.add(evaluacion);

		Alumno alumno = new Alumno(1, "nombre", "apellidos", "telefono", "fechaNacimiento");
		alumnos.add(alumno);

		Curso curso = new Curso(1, "curso", Date.valueOf("2000-01-01"), Date.valueOf("2000-01-01"), "horaInicio",
				"horaFin");
		cursos.add(curso);

	}

//	@AfterEach
//	void tearDown() {
//	
//	}

	@Test
	void testMostrarNotas() {
		evaluaciones = servicio.mostrarNotas();
		assertFalse(evaluaciones.isEmpty());
	}

	@Test
	void testGetAlumnos() {
		alumnos = servicio.getAlumnos();
		assertTrue(!alumnos.isEmpty());
	}

	@Test
	void testGetCursos() {
		cursos = servicio.getCursos();
		assertFalse(cursos.isEmpty());
	}

	@Test
	void testMostrarNotasDeAlumno() {
		evaluaciones = servicio.mostrarNotasDeAlumno(1);
		assertFalse(evaluaciones.isEmpty());
	}

	@Test
	void testAddAlumno() {
		assertTrue(servicio.addAlumno(new Alumno(1, "nombre", "apellidos", "telefono", "fechaNacimiento")));
	}

	@Test
	void testUpdateAlumno() {
		int recibido = servicio.updateAlumno(1, new Alumno(1, "nombre", "apellidos", "telefono", "fechaNacimiento"));
		assertEquals(recibido, 1);
	}

	@Test
	void testDeleteAlumno() {
		assertTrue(servicio.deleteAlumno(1)); 
	}

}
