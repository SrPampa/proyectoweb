package com.venancio.dam.proyectoweb;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import com.venancio.dam.proyectoweb.model.Producto;
import com.venancio.dam.proyectoweb.service.ProductService;



public class FormularioServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    	// Primero invoco al doGet del padre.
    	super.doGet(request, response);
            
        // El siguiente contexto nos va a permitir procesar las plantillas,
        // es decir, nos permite mandar información a la plantilla HTML
        WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
        
        // En este caso mandaríamos a la referencia en la plantilla "today", una fecha
        ctx.setVariable("today", LocalDate.now());
        
        // Al final procesamos la plantilla con la clase TemplateEngine.
        // El nombre de la plantilla es el indicado en el método process.
        // response.getWriter obtiene el objeto PrintWriter, que nos permite escribir la salida.
        TemplateEngine engine = configThymeleaf.getTemplateEngine();
//        engine.process("home", ctx, response.getWriter());
        engine.process("formularios", ctx, response.getWriter());
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	
    	System.out.println("Recibo la info del formulario");
    	
    	request.setCharacterEncoding("UTF-8");
    	
    	
        // Almacenamos los productos recibidos
        ProductService productService = new ProductService();
        
        // El ID autogenerado
        String uniqueID = UUID.randomUUID().toString();
        
        Producto p = new Producto(uniqueID);

        // Obtenemos el valor de varios input
        if(request.getParameter("nombre") != null) {
        	p.setNomProducto(request.getParameter("nombre"));
        }
        
        // Los float se ponen con el punto en la web.
        if(request.getParameter("precio") != null) {
        	p.setPrecio(Float.valueOf(request.getParameter("precio")));
        }
        
        
        // Obtenemos el valor de un radio.
        // No puede ser null porque tiene al menos una opción seleccionada
        p.setDuracion(request.getParameter("duracion"));
        
        // Obtenemos el valor de un select multiple
        String[] tipos = request.getParameterValues("tipo");
        if(tipos != null) {        	
        	p.setTipos(Arrays.asList(tipos));
        }
       
		
        productService.insert(p);
        
        // Recargo la página
        
        // Hay varias opciones
        // Primera
        // Solo válido para ir a una jsp o html -> poco recomendado porque no pasas por el servlet
//        response.sendRedirect("/listado.html");
        
        // Si quieres ir a la misma página -> recomendado
      response.sendRedirect(request.getRequestURI());
        
        // Segunda - no usar con llamada a la misma web porque se ejecuta el doPost por defecto.
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/listado");
//        
//        // Podríamos incluir parámetros:
////        request.setAttribute("usuario",user); 
//
//        dispatcher.forward(request,response);

    }
}
