package pagina_web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ValidacionFormulario")
public class ValidacionFormulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		respuestaHtml(response, new VistaError());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VistaResultado vistaRsltd = new VistaResultado(request);//recogemos request para obtener los parametros del POST en la clase VR
		respuestaHtml(response, vistaRsltd);
	}
	
	private void respuestaHtml(HttpServletResponse response, Vista vista) throws IOException{
		response.setContentType("text/html");
		try(PrintWriter out = response.getWriter()){
			vista.print(out);
		}
	}

}