package com.venancio.dam.proyectoweb.model;

import java.util.List;

/**
 *
 * @author Fran
 */
public class Producto {
	
	
	private String idProducto;
	private String nomProducto;
	private double precio;
	private String duracion;
	private List<String> tipos;
	
	
	public Producto(String idProducto) {
		this.idProducto = idProducto;
	}

	public Producto(String idProducto, String nomProducto, double precio) {
		this.idProducto = idProducto;
		this.nomProducto = nomProducto;
		this.precio = precio;
	}
	

	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public String getNomProducto() {
		return nomProducto;
	}
	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public List<String> getTipos() {
		return tipos;
	}
	public void setTipos(List<String> tipos) {
		this.tipos = tipos;
	}
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nomProducto=" + nomProducto + ", precio=" + precio
				+ ", duracion=" + duracion + ", tipos=" + tipos + "]";
	}
}
