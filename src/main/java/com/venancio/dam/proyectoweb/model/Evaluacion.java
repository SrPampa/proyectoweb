package com.venancio.dam.proyectoweb.model;

import java.util.Objects;

public class Evaluacion {

	private String nombreAlumno;
	private String apellidosAlumno;
	private String nombreCurso;
	private double notaFinal;
	private String observaciones;

	public Evaluacion(String nombreAlumno, String apellidosAlumno, String nombreCurso, double notaFinal,
			String observaciones) {
		this.nombreAlumno = nombreAlumno;
		this.apellidosAlumno = apellidosAlumno;
		this.nombreCurso = nombreCurso;
		this.notaFinal = notaFinal;
		this.observaciones = observaciones;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getApellidosAlumno() {
		return apellidosAlumno;
	}

	public void setApellidosAlumno(String apellidosAlumno) {
		this.apellidosAlumno = apellidosAlumno;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public double getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(double notaFinal) {
		this.notaFinal = notaFinal;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidosAlumno, nombreAlumno, nombreCurso, notaFinal, observaciones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evaluacion other = (Evaluacion) obj;
		return Objects.equals(apellidosAlumno, other.apellidosAlumno) && Objects.equals(nombreCurso, other.nombreCurso)
				&& Double.doubleToLongBits(notaFinal) == Double.doubleToLongBits(other.notaFinal)
				&& Objects.equals(observaciones, other.observaciones);
	}

	@Override
	public String toString() {
		return "Evaluacion, nombreAlumno=" + nombreAlumno + ", apellidosAlumno=" + apellidosAlumno + ", nombreCurso="
				+ nombreCurso + ", notaFinal=" + notaFinal + ", observaciones=" + observaciones + "]";
	}

}
