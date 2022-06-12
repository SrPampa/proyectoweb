package com.venancio.dam.proyectoweb.repository;

import java.util.Set;

import com.venancio.dam.proyectoweb.dao.CursoDAO;
import com.venancio.dam.proyectoweb.dao.FactoryDAO;
import com.venancio.dam.proyectoweb.model.Curso;

public class CursoRepository {

	private CursoDAO dao;

	private static CursoRepository instance;

	public static synchronized CursoRepository getInstance() {
		if (instance == null) {
			instance = new CursoRepository();
		}
		return instance;
	}

	public CursoRepository() {

		dao = FactoryDAO.getFactoryDAO(FactoryDAO.SQL).getCursoDAO();
	}

	public Set<Curso> getCursos() {
		return dao.getCursos();
	}

}
