package pagina_web_vista;

import java.io.PrintWriter;

public class VistaError implements Vista{

	@Override
	public void print(PrintWriter pw) {
		pw.println(Utilidades.DOCTYPE);
		pw.println(Utilidades.headConTitleStyle("Error de acceso", "estilo.css"));
		pw.println("<body>");
		pw.println("<h1>Error: esta página solo atiende peticiones POST</h1>");
		pw.println("<form action=\"http://localhost:8080/Tiienda/administrador.html\" method =\"get\">");
		pw.println("<input type=\"submit\" value=\"Volver\" id=\"vuelta\">");
		pw.println("</form>");
		pw.println(Utilidades.FIN);
	}
	
}
