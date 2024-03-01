package pagina_web;

import java.io.PrintWriter;

public class VistaError implements Vista{

	@Override
	public void print(PrintWriter pw) {
		pw.println(Utilidades.DOCTYPE);
		pw.println(Utilidades.headConTitleStyle("Error de acceso", "estilo.css"));
		pw.println("<body>");
		pw.println("<h1>Error: esta página solo atiende peticiones POST</h1>");
		pw.println(Utilidades.FIN);
	}
	
}
