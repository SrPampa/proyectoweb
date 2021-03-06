package com.venancio.dam.proyectoweb.service;

import java.util.Set;

import com.venancio.dam.proyectoweb.model.Alumno;
import com.venancio.dam.proyectoweb.utils.DBConnection;

public class Init {

	public static void main(String[] args) {

		DBConnection.getInstance().getConnection();
		
		Service service = new Service();
		Set<Alumno> alumnos = service.getAlumnos();
		for (Alumno alumno : alumnos) {
			System.out.println(alumno);
		}
		
		Alumno a = new Alumno("Ruth", "a", "f", "2022/10/08");
		service.addAlumno(a);
		DBConnection.getInstance().destroyConnection();
	}
}
