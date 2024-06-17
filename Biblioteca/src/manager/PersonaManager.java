package manager;

import javax.swing.JOptionPane;
import dao.PersonaDao;
import entity.PersonaDTO;

/**
 * Clase que contiene todos los metodos para gestionar el modulo de personas o usuarios
 * @author Juan José Cardona Henao
 * @version 1.0
 */
public class PersonaManager {
	
	PersonaDao personaDao = new PersonaDao();
	
	/**
	 * Menú del modulo de personas
	 */
	public void personas() {
		int opcion = 0;
		
		while(opcion != 5) {
			opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción: "
                    + "\n 1. Consultar persona."
                    + "\n 2. Editar persona."
                    + "\n 3. Agregar persona."
                    + "\n 4. Eliminar persona."
                    + "\n 5. Salir."));
			
			switch(opcion) {
				case 1: consultarPersona(); break;
				case 2: editarPersona(); break;
				case 3: insertarPersona(); break;
				case 4: eliminarPersona(); break;
				case 5: break;
                default: JOptionPane.showMessageDialog(null, "Opción no valida, por favor seleccione nuevamente."); break;
			}
		}
	}
	
	/**
	 * Metodo para consultar personas
	 */
	private void consultarPersona() {
		PersonaDTO personaDto;
		
		try {
			Long documento = Long.parseLong(JOptionPane.showInputDialog("Documento de Identidad: "));
			personaDto = personaDao.findPersona(documento);
			
			if(personaDto != null) {
				JOptionPane.showMessageDialog(null, "Resultado: "
						+ "\n Nombre: " + personaDto.getNombre() + " " + personaDto.getApellido()
						+ "\n Documento: " + personaDto.getDocumentoIdentidad()
						+ "\n Telefono: " + personaDto.getTelefono()
						+ "\n Email: " + personaDto.getEmail()
						+ "\n Dirección: " + personaDto.getDireccion()
						+ "\n Ciudad: " + personaDto.getCiudad());
			} else {
				JOptionPane.showMessageDialog(null, "La persona que busca no se encuentra registrada en el sistema.");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "¡ERROR! " + ex.getMessage());
		}
	}
	
	/**
	 * Metodo para editar personas
	 */
	private void editarPersona() {
		PersonaDTO personaDto = new PersonaDTO();
		
		try {
			personaDto.setDocumentoIdentidad(Long.parseLong(JOptionPane.showInputDialog("Documento de Identidad: ")));
			
			if(!personaDao.validatePersona(personaDto.getDocumentoIdentidad())) {
				JOptionPane.showMessageDialog(null, "La persona con numero de documento " + personaDto.getDocumentoIdentidad() + " no se encuentra registrada en el sistema.");
			} else {
				personaDto.setNombre(JOptionPane.showInputDialog("Nombre: "));
				personaDto.setApellido(JOptionPane.showInputDialog("Apellido: "));
				personaDto.setEmail(JOptionPane.showInputDialog("Email: "));
				personaDto.setTelefono(JOptionPane.showInputDialog("Telefono: "));
				personaDto.setDireccion(JOptionPane.showInputDialog("Dirección: "));
				personaDto.setCiudad(JOptionPane.showInputDialog("Ciudad: "));
				
				personaDao.updatePersona(personaDto);
				JOptionPane.showMessageDialog(null, "Datos de la persona modificados con exito.");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "¡ERROR! " + ex.getMessage());
		}
	}
	
	/**
	 * Metodo para ingresar personas
	 */
	private void insertarPersona() {
		PersonaDTO personaDto = new PersonaDTO();
		
		try {
			personaDto.setDocumentoIdentidad(Long.parseLong(JOptionPane.showInputDialog("Documento de Identidad: ")));
			
			if(personaDao.validatePersona(personaDto.getDocumentoIdentidad())) {
				JOptionPane.showMessageDialog(null, "Ya existe una persona en el sistema registrada con el numero de documento " + personaDto.getDocumentoIdentidad());
			} else {
				personaDto.setNombre(JOptionPane.showInputDialog("Nombre: "));
				personaDto.setApellido(JOptionPane.showInputDialog("Apellido: "));
				personaDto.setEmail(JOptionPane.showInputDialog("Email: "));
				personaDto.setTelefono(JOptionPane.showInputDialog("Telefono: "));
				personaDto.setDireccion(JOptionPane.showInputDialog("Dirección: "));
				personaDto.setCiudad(JOptionPane.showInputDialog("Ciudad: "));
				
				personaDao.insertPersona(personaDto);
				JOptionPane.showMessageDialog(null, "Persona registrada con exito.");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "¡ERROR! " + ex.getMessage());
		}
	}
	
	/**
	 * Metodo para eliminar personas
	 */
	private void eliminarPersona() {
		try {
			Long documento = Long.parseLong(JOptionPane.showInputDialog("Documento de Identidad: "));
			
			if(!personaDao.validatePersona(documento)) {
				JOptionPane.showMessageDialog(null, "La persona con numero de documento " + documento + " no está registrada en el sistema.");
			} else {
				personaDao.deletePersona(documento);
				JOptionPane.showMessageDialog(null, "Persona eliminada con exito.");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "¡ERROR! " + ex.getMessage());
		}
	}
}
