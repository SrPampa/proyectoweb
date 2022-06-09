package com.venancio.dam.proyectoweb;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import com.venancio.dam.proyectoweb.model.Curso;
import com.venancio.dam.proyectoweb.service.Service;

public class MostrarCursosServlet extends GenericServlet {

private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
  
    	super.doGet(request, response);

		WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());

		Service service = new Service();
		Set<Curso> allCursos = service.getCursos();

		ctx.setVariable("cursos", allCursos);

		TemplateEngine engine = configThymeleaf.getTemplateEngine();
		engine.process("mostrar_alumnos", ctx, response.getWriter());
	}

}
