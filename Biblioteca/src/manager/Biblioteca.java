package manager;

import javax.swing.JOptionPane;

/**
 * Este proyecto permite gestionar todo el sistema de una biblioteca
 * @author Juan José Cardona Henao
 * @version 1.0
 */
public class Biblioteca {

	public static void main(String[] args) {
		int opcion = 0;
		PersonaManager objPersona = new PersonaManager();
		LibroManager objLibro = new LibroManager();
		
		try {
			while(opcion != 4) {
				opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción: "
                        + "\n 1. Personas."
                        + "\n 2. Libros."
                        + "\n 3. Prestamos."
                        + "\n 4. Salir."));
				
				switch(opcion) {
					case 1: objPersona.personas(); break;
					case 2: objLibro.libros(); break;
					case 3: JOptionPane.showMessageDialog(null, "Este modulo aún no se encuentra disponible."); break;
					case 4: JOptionPane.showMessageDialog(null, "¡Gracias! Vuelva pronto."); break;
                    default: JOptionPane.showMessageDialog(null, "Opción no valida, por favor seleccione nuevamente."); break;
				}
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "¡ERROR EN EL SISTEMA! " + ex.getMessage());
		}
	}
}
