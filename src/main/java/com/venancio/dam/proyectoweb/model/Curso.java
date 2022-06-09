package com.venancio.dam.proyectoweb.model;

import java.sql.Date;
import java.util.Objects;

public class Curso {

	private long codigoCurso;
	private String curso;
	private Date fechaInicio;
	private Date fechaFin;
	private String horaInicio;
	private String horaFin;
	
	public Curso(long codigoCurso, String curso, Date fechaInicio, Date fechaFin, String horaInicio,
			String horaFin) {
		this.codigoCurso = codigoCurso;
		this.curso = curso;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

	public long getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(long codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoCurso, curso, fechaFin, fechaInicio, horaFin, horaInicio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return codigoCurso == other.codigoCurso && Objects.equals(curso, other.curso)
				&& Objects.equals(fechaFin, other.fechaFin) && Objects.equals(fechaInicio, other.fechaInicio)
				&& Objects.equals(horaFin, other.horaFin) && Objects.equals(horaInicio, other.horaInicio);
	}

	@Override
	public String toString() {
		return "Curso [codigoCurso=" + codigoCurso + ", curso=" + curso + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + "]";
	}
	
	
	
}
