package pagina_web_vista;

import java.io.PrintWriter;

public class VistaResultado implements Vista{
	private String mensaje;
	
	//builder para "recibir" el mensaje
	public VistaResultado(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public void print(PrintWriter pw) {
		pw.println(Utilidades.DOCTYPE);
		pw.println(Utilidades.headConTitleStyle("Resultado", "estilo.css"));
		pw.println("<body>");
		pw.println("<h1>Resultado de la operación</h1>");
		pw.println("<h3>"+ mensaje + "</h3>");
		pw.println("<form action=\"http://localhost:8080/Tiienda/administrador.html\" method =\"get\">");
		pw.println("<input type=\"submit\" value=\"Volver\" id=\"vuelta\">");
		pw.println("</form>");
		pw.println(Utilidades.FIN);
	}
}
