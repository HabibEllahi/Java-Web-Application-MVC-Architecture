package pagina_web_controlador;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pagina_web_modelo.Operaciones;
import pagina_web_vista.Vista;
import pagina_web_vista.VistaError;
import pagina_web_vista.VistaResultado;


@WebServlet("/ValidacionFormulario")
public class ValidacionFormulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		respuestaHtml(response, new VistaError());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String description = request.getParameter("description");
		String tipo = request.getParameter("tipo");
		String preciio = request.getParameter("precio");//Es un string
		float precio = Float.parseFloat(preciio);// Conversión del precio como un float
		
		Operaciones op = new Operaciones(description, tipo, precio);
		String mensaje = op.generaMensaje();
		
		respuestaHtml(response, new VistaResultado(mensaje));
	}
	
	private void respuestaHtml(HttpServletResponse response, Vista vista) throws IOException{
		response.setContentType("text/html");
		try(PrintWriter out = response.getWriter()){
			vista.print(out);
		}
	}

}