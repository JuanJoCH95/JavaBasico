package archivoplano;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Formatter;
import javax.swing.JOptionPane;

public class Archivos {
	
	/**
	 * Metodo encargado de leer un archivo plano
	 * @param ruta
	 */
	public void leerArchivo(String ruta) {
		try {
			File archivo = new File(ruta);
	    	
	    	if(archivo.exists()) {
	    		FileReader lector = new FileReader(ruta);
	            BufferedReader br = new BufferedReader(lector);
	            String cadena;

	            while((cadena = br.readLine()) != null) {
	                JOptionPane.showMessageDialog(null, " " + cadena);
	            }
	    	} else {
	    		JOptionPane.showMessageDialog(null, "El archivo no existe o no se encuentra en la ruta ingresada por el usuario.");
	    	}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurrio un error en el sistema: " + e);
		}
	}
	
	/**
	 * Metodo encargado de crear un archivo plano y escribir en el
	 * @param ruta
	 * @param mensaje
	 */
	public void escribirArchivo(String ruta, String mensaje) {
		try {
			Formatter nuevo = new Formatter(ruta);
			File archivo = new File(ruta);
	    	FileWriter escritor = new FileWriter(archivo);
	    	escritor.write(mensaje);
        	escritor.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurrio un error en el sistema: " + e);
		}
	}
}
