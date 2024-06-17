package cajero;

import javax.swing.JOptionPane;

public class Login {
	
	private static final String clave = "Admin01+";
	
	/**
	 * Metodo encargado de realizar el proceso de autenticaci�n para ingresar al cajero
	 * @author Juan Jos� Cardona Henao
	 */
	public boolean login() {
		boolean isUser = false;
		int intentos = 0;
		
		while(intentos != 3) {
			String password = JOptionPane.showInputDialog("Bien venido \nPor favor digite su contrase�a");
			
			if(password.equals(clave)) {
				isUser = true;
				intentos = 3;
			} else {
				intentos++;
				
				if(intentos == 3) {
					JOptionPane.showMessageDialog(null, "Lo sentimos, ha excedido el n�mero maximo de intentos. Por favor intente mas tarde.");
				} else {
					JOptionPane.showMessageDialog(null, "Contrase�a incorrecta, por favor intente de nuevo.");
				}
			}
		}
		return isUser;
	}
}
