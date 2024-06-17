package carrera;

import javax.swing.JOptionPane;

public class apuesta extends menus {
	
	public void carrera(double recarga, double apuesta, int caballo) {
		
		int resultado = (int) (Math.random()*4+1); //Se genera un numero al azar entre 1 y 4
		validador val = new validador(caballo, resultado, apuesta, recarga);
		
		switch (resultado) {
			case 1: 
				JOptionPane.showMessageDialog(null, "El ganador es ¡Zeus!");
				val.validarApuesta(); break;
			case 2: 
				JOptionPane.showMessageDialog(null, "El ganador es ¡Bucefalus!");
				val.validarApuesta(); break;
			case 3: 
				JOptionPane.showMessageDialog(null, "El ganador es ¡Corredor!");
				val.validarApuesta(); break;
			case 4: 
				JOptionPane.showMessageDialog(null, "El ganador es ¡Texano!");
				val.validarApuesta(); break;
		}
	}
}