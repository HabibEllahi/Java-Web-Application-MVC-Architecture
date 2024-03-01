package pagina_web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class Operaciones {
	private HttpServletRequest request;
	
	//builder 
	public Operaciones(HttpServletRequest request) {
		this.request = request;
	}
		
	public String generaMensaje(){
		String description = request.getParameter("description");
		String tipo = request.getParameter("tipo");
		String preciio = request.getParameter("precio");//Es un string
		float precio = Float.parseFloat(preciio);// Conversión del precio como un float
	
		//Creamos el mensaje a mostrar
		String msg = "Artículo " + description + " dado de alta en la categoría " +  tipo + " con un precio de " + precio +  " euros";
		ficheroCSV(description, tipo, precio);
		return msg;
	}
	
	private void ficheroCSV(String description, String tipo, float precio) {
		File fichero = new File("datos.csv");
		try {
			if(!fichero.exists()) {
				fichero.createNewFile();
			}
		}catch(IOException ioe) {
			
		}
	}
}
