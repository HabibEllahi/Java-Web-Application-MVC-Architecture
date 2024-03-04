package pagina_web_modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class Operaciones {
	private String description, tipo;
	private float precio;
	
	//builder
	public Operaciones(String description, String tipo, Float precio) {
		this.description = description;
		this.tipo = tipo;
		this.precio = precio;
	}
		
	public String generaMensaje(){
		//Creamos el mensaje a mostrar
		String msg = "Artículo " + description + " dado de alta en la categoría " +  tipo + " con un precio de " + precio +  " euros";
		//Lo guardamos en el csv
		ficheroCSV(description, tipo, precio);
		return msg;
	}
	
	private void ficheroCSV(String description, String tipo, float precio) {
		//Abrimos/Creamos fichero, especificamos carpeta a elección
		File fichero = new File("/home/habibe/STA/Proyectos-Eclipse/datos.csv");
		try {
			if(!fichero.exists()) {
				fichero.createNewFile();
			}
			//Escribimos los datos en el cvs
			BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true));
			bw.write(numReferenciaAleat() + ", " + tipo + ", " + description + ", " + precio + "\n");
			bw.close();
		}catch(IOException ioe) {
			
		}
	}
	
	private String numReferenciaAleat() {//Generamos numero de referencia aleatorio
		String numero = "";
		Random rndm = new Random();
		for(int i = 0; i < 9; i++) {
			int num = rndm.nextInt(10);//Numero aleatorio entre 0 y 9
			numero  = numero + num;
		}
		return numero;
	}
}
