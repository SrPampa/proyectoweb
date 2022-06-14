package com.venancio.dam.proyectoweb;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import com.venancio.dam.proyectoweb.model.Alumno;
import com.venancio.dam.proyectoweb.service.Service;

public class DeleteAlumnoServlet extends GenericServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		super.doGet(request, response);

		WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());

		ctx.setVariable("today", LocalDate.now());

		TemplateEngine engine = configThymeleaf.getTemplateEngine();
//	        engine.process("home", ctx, response.getWriter());
		engine.process("delete_alumnos", ctx, response.getWriter());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Recibo la info del formulario");

		request.setCharacterEncoding("UTF-8");

		Service service = new Service();

		String uniqueID = UUID.randomUUID().toString();
		int id = Integer.valueOf(uniqueID);

		Alumno a = new Alumno(id);

		if (request.getParameter("nombre") != null) {
			a.setNombre(request.getParameter("nombre"));
		}

		if (request.getParameter("apellidos") != null) {
			a.setApellidos(request.getParameter("apellidos"));
		}

		if (request.getParameter("telefono") != null) {
			a.setTelefono(request.getParameter("telefono"));
		}

		if (request.getParameter("fechaNacimiento") != null) {
			a.setFechaNacimiento(request.getParameter("fechaNacimiento"));
		}

		service.updateAlumno(id, a);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/mostrar_alumnos");

		dispatcher.forward(request, response);
	}

}
