package hilos;

import java.util.ArrayList;
import java.util.List;

public class Hilos {
	
	public static void main(String[] args) {
		List<String> listMunicipios = new ArrayList<>();
		listMunicipios.add("Bello");
		listMunicipios.add("Manizales");
		listMunicipios.add("Soacha");
		listMunicipios.add("Barrancabermeja");
		
		for(String municipio : listMunicipios) {
			Thread thread = new Thread(new ProcesarMunicipios(municipio));
			thread.start();
		}
	}
}
