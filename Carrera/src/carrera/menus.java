package carrera;

import javax.swing.JOptionPane;

public class menus {
	
	protected String usuario;
	protected double recarga;
	protected int caballo;
	protected double valorApuesta;
	private double total;
	
	public menus() {
		
	}
	
	public menus(double total, double recarga) {
		this.total = total;
		this.recarga = recarga;
	}
	
	public void menuPrincipal() {
		
		usuario = JOptionPane.showInputDialog("¡Bien venido a Mis Apuestas!"
				+ "\n Ingrese Usuario: ");
		
		recarga = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor a recargar: "));
	}
	
	public void menuApuesta() {

		int x = 0;
		validador val = new validador();
		apuesta ap = new apuesta();
		
		while(x != 1) {
			if(x == 2) {
				total = 0;
			}
			
			caballo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el caballo por el que desea apostar: "
					+ "\n 1. Zeus"
					+ "\n 2. Bucefalus"
					+ "\n 3. Corredor"
					+ "\n 4. Texano"));
			
			valorApuesta = Double.parseDouble(JOptionPane.showInputDialog("¿Cuanto desea apostar?"));
			total = total + valorApuesta;
			x = val.validarEntrada(recarga, total);
		}
		ap.carrera(recarga, valorApuesta, caballo);
	}
}