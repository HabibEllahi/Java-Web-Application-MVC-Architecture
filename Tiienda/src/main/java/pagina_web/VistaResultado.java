package pagina_web;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

public class VistaResultado implements Vista{
	private HttpServletRequest request;
	
	//builder para recibir el request de la clase ValidacionFormulario
	public VistaResultado(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void print(PrintWriter pw) {
		Operaciones op = new Operaciones(request);
		String mensaje = op.generaMensaje();
		
		pw.println(Utilidades.DOCTYPE);
		pw.println(Utilidades.headConTitleStyle("Resultado", "estilo.css"));
		pw.println("<body>");
		pw.println("<h1>Resultado de la operación</h1>");
		pw.println("<h3>"+ mensaje + "</h3>");
		pw.println(Utilidades.FIN);
	}
}
