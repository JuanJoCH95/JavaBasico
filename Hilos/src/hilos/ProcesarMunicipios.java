package hilos;

import java.util.Random;

public class ProcesarMunicipios implements Runnable {
	
	private String municipio;
	
	public ProcesarMunicipios(String municipio) {
		this.municipio = municipio;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		Thread.currentThread().setName(municipio);
		int tiempoProcesamiento = 0;
		
		try {
			for(int i = 0; i < 10; i++) {
				if(municipio.equals("Bello")) {
					tiempoProcesamiento = 20000;
					Thread.sleep(tiempoProcesamiento);
				} else {
					tiempoProcesamiento = random.nextInt(5000);
					Thread.sleep(tiempoProcesamiento);
				}
				System.out.println("Municipio: " + municipio + ", procesado en: " + tiempoProcesamiento);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
