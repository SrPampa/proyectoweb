package com.venancio.dam.proyectoweb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import com.venancio.dam.proyectoweb.model.Producto;
import com.venancio.dam.proyectoweb.service.ProductService;

public class ListadoServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	// Primero invoco al doGet del padre.
    	super.doGet(request, response);

		// El siguiente contexto nos va a permitir procesar las plantillas,
		// es decir, nos permite mandar información a la plantilla HTML
		WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());

		// Vamos a mostrar una serie de productos
		ProductService productService = new ProductService();
		List<Producto> allProducts = productService.findAll();

		ctx.setVariable("prods", allProducts);

		// Al final procesamos la plantilla con la clase TemplateEngine.
		// El nombre de la plantilla es el indicado en el método process.
		// response.getWriter obtiene el objeto PrintWriter, que nos permite escribir la
		// salida.
		TemplateEngine engine = configThymeleaf.getTemplateEngine();
		engine.process("listado", ctx, response.getWriter());
	}

}
