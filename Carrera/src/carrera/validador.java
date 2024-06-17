package carrera;

import javax.swing.JOptionPane;

public class validador {
	
	private double total;
	private String gano;
	private int resp1;
	private int resp2;
	private int caballo;
	private int resultado;
	private double valorApuesta;
	private double recarga;
	private double acumulado;
	
	//Constructor vacio
	public validador() {
	}
	
	//Constructor con argumentos
	public validador(int caballo, int resultado, double valorApuesta, double recarga) {
		this.caballo = caballo;
		this.resultado = resultado;
		this.valorApuesta = valorApuesta;
		this.recarga = recarga;
	}
	
	public void validarApuesta() {
		
		if(resultado == caballo) {
			JOptionPane.showMessageDialog(null, "Felicidades ganaste");
			total = valorApuesta * 2;
			acumulado = recarga + total;
			gano = "S";
			validaResultado();
		} else {
			JOptionPane.showMessageDialog(null, "Lo sentimos, perdiste");
			total = recarga - valorApuesta;
			acumulado = recarga - valorApuesta;
			gano = "N";
			validaResultado();
		}
	}
	
	public int validarEntrada(double recarga, double apuesta) {
		
		int respuesta = 1;

		if(apuesta > recarga) {
			JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE. El valor que desea apostar es superior a su saldo recargado, por favor ingrese un nuevo valor.");
			respuesta = 2;
		}
		return respuesta;
	}
	
	public void validaResultado() {
		
		if(gano == "N") {
			if(acumulado == 0) {
				resp1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Señor usuario, usted ya no tiene saldo, recargue si desea apostar nuevamente."
						+ "\n 1. Recargar"
						+ "\n 2. Salir"));
				
				validaRespuesta();
			} else {
				JOptionPane.showMessageDialog(null, "Su saldo es: " + acumulado);
				resp2 = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Desea apostar nuevamente?"
						+ "\n 1. Si"
						+ "\n 2. No"));
				
				validaRespuesta();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Su saldo es: " + acumulado);
			resp2 = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Desea apostar nuevamente?"
					+ "\n 1. Si"
					+ "\n 2. No"));
			
			validaRespuesta();
		}
	}
	
	public void validaRespuesta() {
		
		menus m = new menus(total, acumulado);
		
		if(resp1 == 1) {
			m.menuPrincipal();
		} else if(resp1 == 2) {
			System.exit(0);
		}
		
		if(resp2 == 1) {
			m.menuApuesta();
		} else if(resp2 == 2) {
			System.exit(0);
		}
	}
}