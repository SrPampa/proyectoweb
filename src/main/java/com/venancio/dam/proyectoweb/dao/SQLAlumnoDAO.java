package com.venancio.dam.proyectoweb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.venancio.dam.proyectoweb.model.Alumno;
import com.venancio.dam.proyectoweb.utils.DBConnection;

public class SQLAlumnoDAO implements AlumnoDAO {

	private static final String SELECT_ALUMNOS = "SELECT * FROM ALUMNOS";
	private static final String INSERT_ALUMNO = "INSERT INTO ALUMNOS (SELECT MAX(CODIGOALUMNO)+1,?,?,?,?)";
	private static final String UPDATE_ALUMNO = "UPDATE ALUMNOS SET NOMBRE=?, APELLIDOS=?, TELEFONO=?, FECHANACIMIENTO=? WHERE CODIGOALUMNO = ?";
	private static final String DELETE_ALUMNO = "DELETE FROM ALUMNOS WHERE CODIGOALUMNO =?";

	public Set<Alumno> getAlumnos() {
		Set<Alumno> alumnos = new HashSet<>();

		try {
			PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(SELECT_ALUMNOS);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Alumno a = new Alumno(rs.getInt("CODIGOALUMNO"), rs.getString("NOMBRE"), rs.getString("APELLIDOS"),
						rs.getString("TELEFONO"), rs.getDate("FECHANACIMIENTO"));
				alumnos.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return alumnos;
	}

	public boolean addAlumno(Alumno a) {
		boolean add = false;
		try {
			PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(INSERT_ALUMNO);

			stmt.setString(1, a.getNombre());
			stmt.setString(2, a.getApellidos());
			stmt.setString(3, a.getTelefono());
			stmt.setDate(4, a.getFechaNacimiento());
			add = stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return add;
	}

	public int modificarAlumno(Alumno a, int codigo) {
		int rows = 0;
		try {
			PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(UPDATE_ALUMNO);

			stmt.setString(1, a.getNombre());
			stmt.setString(2, a.getApellidos());
			stmt.setString(3, a.getTelefono());
			stmt.setDate(4, a.getFechaNacimiento());
			stmt.setInt(5, codigo);
			rows = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	public boolean deleteAlumno(int cod) {
		boolean deleted = false;
		try {
			PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(DELETE_ALUMNO);
			stmt.setInt(1, cod);
			deleted = stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleted;
	}
}
