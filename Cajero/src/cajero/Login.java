package cajero;

import javax.swing.JOptionPane;

public class Login {
	
	private static final String clave = "Admin01+";
	
	/**
	 * Metodo encargado de realizar el proceso de autenticación para ingresar al cajero
	 * @author Juan José Cardona Henao
	 */
	public boolean login() {
		boolean isUser = false;
		int intentos = 0;
		
		while(intentos != 3) {
			String password = JOptionPane.showInputDialog("Bien venido \nPor favor digite su contraseña");
			
			if(password.equals(clave)) {
				isUser = true;
				intentos = 3;
			} else {
				intentos++;
				
				if(intentos == 3) {
					JOptionPane.showMessageDialog(null, "Lo sentimos, ha excedido el número maximo de intentos. Por favor intente mas tarde.");
				} else {
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta, por favor intente de nuevo.");
				}
			}
		}
		return isUser;
	}
}
