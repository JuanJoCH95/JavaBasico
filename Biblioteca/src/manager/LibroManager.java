package manager;

import javax.swing.JOptionPane;
import dao.LibroDao;
import entity.LibroDTO;

/**
 * Clase que contiene todos los metodos para gestionar el modulo de libros
 * @author Juan José Cardona Henao
 * @version 1.0
 */
public class LibroManager {
	
	LibroDao libroDao = new LibroDao();
	
	/**
	 * Menú del modulo de libros
	 */
	public void libros() {
		int opcion = 0;
		
		while(opcion != 5) {
			opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción: "
                    + "\n 1. Consultar libro."
                    + "\n 2. Editar libro."
                    + "\n 3. Agregar libro."
                    + "\n 4. Eliminar libro."
                    + "\n 5. Salir."));
			
			switch(opcion) {
				case 1: consultarLibro(); break;
				case 2: editarLibro(); break;
				case 3: insertarLibro(); break;
				case 4: eliminarLibro(); break;
				case 5: break;
                default: JOptionPane.showMessageDialog(null, "Opción no valida, por favor seleccione nuevamente."); break;
			}
		}
	}
	
	/**
	 * Metodo para consultar libros
	 */
	private void consultarLibro() {
		LibroDTO libroDto;
		
		try {
			String nombre = JOptionPane.showInputDialog("Nombre del libro: ");
			libroDto = libroDao.findLibro(nombre);
			
			if(libroDto != null) {
				JOptionPane.showMessageDialog(null, "Resultado: "
						+ "\n Nombre del libro: " + libroDto.getNombre()
						+ "\n Autor: " + libroDto.getAutor()
						+ "\n Genero: " + libroDto.getGenero()
						+ "\n Estado: " + libroDto.getEstado());
			} else {
				JOptionPane.showMessageDialog(null, "El libro que busca no se encuentra registrado en el sistema.");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "¡ERROR! " + ex.getMessage());
		}
	}
	
	/**
	 * Metodo para editar libros
	 */
	private void editarLibro() {
		LibroDTO libroDto;
		
		try {
			String nombre = JOptionPane.showInputDialog("Nombre del libro que desea modificar: ");
			libroDto = libroDao.findLibro(nombre);
			
			if(libroDto == null) {
				JOptionPane.showMessageDialog(null, "'" + nombre + "'" + " no se encuentra registrado en el sistema.");
			} else {
				libroDto.setNombre(JOptionPane.showInputDialog("Nombre: "));
				libroDto.setAutor(JOptionPane.showInputDialog("Autor: "));
				libroDto.setGenero(JOptionPane.showInputDialog("Genero: "));
				
				libroDao.updateLibro(libroDto);
				JOptionPane.showMessageDialog(null, "Datos del libro modificados con exito.");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "¡ERROR! " + ex.getMessage());
		}
	}
	
	/**
	 * Metodo para ingresar libros
	 */
	private void insertarLibro() {
		LibroDTO libroDto = new LibroDTO();
		
		try {
			libroDto.setNombre(JOptionPane.showInputDialog("Nombre del libro: "));
			
			if(libroDao.validateLibro(libroDto.getNombre())) {
				JOptionPane.showMessageDialog(null, "Ese libro ya se encuentra registrado en el sistema.");
			} else {
				libroDto.setAutor(JOptionPane.showInputDialog("Autor: "));
				libroDto.setGenero(JOptionPane.showInputDialog("Genero: "));
				
				libroDao.insertLibro(libroDto);
				JOptionPane.showMessageDialog(null, "Libro registrado con exito.");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "¡ERROR! " + ex.getMessage());
		}
	}
	
	/**
	 * Metodo para eliminar libros
	 */
	private void eliminarLibro() {
		LibroDTO libroDto;
		
		try {
			String nombre = JOptionPane.showInputDialog("Nombre del libro que desea eliminar: ");
			libroDto = libroDao.findLibro(nombre);
			
			if(libroDto == null) {
				JOptionPane.showMessageDialog(null, "'" + nombre + "'" + " no se encuentra registrado en el sistema.");
			} else {
				libroDao.deleteLibro(libroDto.getIdLibro());
				JOptionPane.showMessageDialog(null, "Libro eliminado con exito.");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "¡ERROR! " + ex.getMessage());
		}
	}
}
