package archivoplano;

import javax.swing.JOptionPane;

public class ArchivoPlano {

	public static void main(String[] args) {
		Archivos objArchivos = new Archivos();
		String ruta, mensaje;
		int opcion = 0;

		while (opcion != 3) {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(
					"Seleccione una opción: " + "\n 1. Leer archivo. " + "\n 2. Escribir. " + "\n 3. Salir."));

			switch (opcion) {
				case 1:
					ruta = JOptionPane.showInputDialog("Ingrese la ruta donde se encuentra el archivo: ");
					objArchivos.leerArchivo(ruta);
					break;
				case 2:
					ruta = JOptionPane.showInputDialog("Ingrese la ruta donde desea guardar el archivo: ");
					mensaje = JOptionPane.showInputDialog("Ingrese el texto que quiere escribir en el archivo: ");
					objArchivos.escribirArchivo(ruta, mensaje);
					JOptionPane.showMessageDialog(null, "Archivo creado con exito.");
					break;
				case 3:
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opción no valida, por favor seleccione nuevamente.");
					break;
			}
		}
	}
}
