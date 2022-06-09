package com.venancio.dam.proyectoweb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.venancio.dam.proyectoweb.model.Producto;
import com.venancio.dam.proyectoweb.utils.DBConnection;

public class ProductDAO {
	
	
	private final String INSERT = "INSERT INTO PRODUCTO SELECT MAX(ID) + 1, ?, ? FROM PRODUCTO;";	
	private final String SELECT_PRODUCTOS = "SELECT * FROM PRODUCTO";

	
	public List<Producto> getProducts() {
		
		List<Producto> lista = new ArrayList<>();

		try (PreparedStatement stmt = DBConnection.getInstance().getConnection()
				.prepareStatement(SELECT_PRODUCTOS)) {

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Producto p = new Producto(rs.getString("id"), rs.getString("name"), rs.getDouble("price"));
				lista.add(p);
			}

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}

		return lista;
	}
	
	public boolean setProduct(Producto prod) {		
		boolean result = false;

		try (PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(INSERT)) {

			stmt.setString(1, prod.getNomProducto());
			stmt.setDouble(2, prod.getPrecio());

			System.out.println("Insertando....");

			int row = stmt.executeUpdate();
			
			if(row == 1) {
				result = true;
			}

			System.out.println(result ? "Insertado con éxito" : "No se ha podido insertar...");

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}
		
		
		return result;
	}
	
	
	

	

	
}
