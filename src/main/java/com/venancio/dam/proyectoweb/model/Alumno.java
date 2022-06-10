package com.venancio.dam.proyectoweb.model;

import java.sql.Date;
import java.util.Objects;

public class Alumno {

	private long codigoAlumno;
	private String nombre;
	private String apellidos;
	private String telefono;
	private Date fechaNacimiento;

	public Alumno(long codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}

	public Alumno(long codigoAlumno, String nombre, String apellidos, String telefono, Date fechaNacimiento) {
		this.codigoAlumno = codigoAlumno;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
	}

	public long getCodigoAlumno() {
		return codigoAlumno;
	}

	public void setCodigoAlumno(long codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, codigoAlumno, fechaNacimiento, nombre, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(apellidos, other.apellidos) && codigoAlumno == other.codigoAlumno
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Alumno [codigoAlumno=" + codigoAlumno + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

}
