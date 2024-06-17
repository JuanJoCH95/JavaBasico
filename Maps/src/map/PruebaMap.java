package map;

import java.util.HashMap;

public class PruebaMap {

	public static void main(String[] args) {
		HashMap<String, String> respuesta = new HashMap<String, String>();
		String resultado;
		
		respuesta.put("NOMBRE", "Juan");
		respuesta.put("APELLIDO", "Cardona");
		respuesta.put("DOCUMENTO", "1017231054");
		respuesta.put("PAIS", "Colombia");
		respuesta.put("CUENTA", null);
		respuesta.put("EDAD", "26");
		
		resultado = homologar(respuesta);
		
		System.out.println("El pais es: " + respuesta.get("PAIS"));
		System.out.println(resultado);
	}
	
	private static String homologar(HashMap<String, String> respuesta) {
		String mensaje = null;
		
		try {
			if(respuesta.get("CUENTA") != null && !respuesta.get("CUENTA").equals("s/cuenta")) {
				mensaje = "La cuenta es: " + respuesta.get("CUENTA");
			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage() + " / " + e);
		}
		return mensaje;
	}
}
