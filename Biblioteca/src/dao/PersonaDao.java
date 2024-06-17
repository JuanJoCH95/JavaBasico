package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import db.Conexion;
import entity.PersonaDTO;

/**
 * Clase que contiene todos los metodos para realizar las transacciones de personas en la BD del sistema
 * @author Juan José Cardona Henao
 * @version 1.0
 */
public class PersonaDao {
	
	private static final String findPersona = "SELECT documento, nombre, apellido, email, telefono, direccion, ciudad FROM test.persona WHERE documento = ?";
	private static final String insertPersona = "INSERT INTO test.persona(documento, nombre, apellido, email, telefono, direccion, ciudad) VALUES(?, ?, ?, ?, ?, ?, ?)";
	private static final String updatePersona = "UPDATE test.persona SET nombre = ?, apellido = ?, email = ?, telefono = ?, direccion = ?, ciudad = ? WHERE documento = ?";
	private static final String deletePersona = "DELETE FROM test.persona WHERE documento = ?";
	
	/**
	 * Metodo encargado de consultar los datos de una persona en la BD
	 * @param documento
	 * @return persona
	 * @throws SQLException
	 */
	public PersonaDTO findPersona(Long documento) throws SQLException {
        PersonaDTO persona = null;
        Connection conn = null;
        ResultSet resultado = null;
        PreparedStatement preparedStm = null;
        int index = 1;
        
        try {
            conn = Conexion.conectarBD();
            preparedStm = conn.prepareStatement(findPersona);
            preparedStm.setLong(index++, documento);
            resultado = preparedStm.executeQuery();
            
            if(resultado.next()) {
            	persona = new PersonaDTO();
            	persona.setDocumentoIdentidad(resultado.getLong("documento"));
            	persona.setNombre(resultado.getString("nombre"));
                persona.setApellido(resultado.getString("apellido"));
                persona.setEmail(resultado.getString("email"));
                persona.setTelefono(resultado.getString("telefono"));
                persona.setDireccion(resultado.getString("direccion"));
                persona.setCiudad(resultado.getString("ciudad"));
            }
        } finally {
        	Conexion.closeConnection(resultado, preparedStm, conn);
        }
        return persona;
    }
	
	/**
	 * Metodo encargado de modificar una persona en la BD
	 * @param persona
	 * @throws SQLException
	 */
	public void updatePersona(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStm = null;
        int index = 1;
        
        try {
        	conn = Conexion.conectarBD();
        	preparedStm = conn.prepareStatement(updatePersona);
        	preparedStm.setString(index++, persona.getNombre());
        	preparedStm.setString(index++, persona.getApellido());
        	preparedStm.setString(index++, persona.getEmail());
        	preparedStm.setString(index++, persona.getTelefono());
        	preparedStm.setString(index++, persona.getDireccion());
        	preparedStm.setString(index++, persona.getCiudad());
        	preparedStm.setLong(index++, persona.getDocumentoIdentidad());
        	preparedStm.executeUpdate();
        } finally {
			Conexion.closeConnection(preparedStm, conn);
		}
    }
	
	/**
	 * Metodo encargado de insertar una nueva persona en la BD
	 * @param persona
	 * @throws SQLException
	 */
	public void insertPersona(PersonaDTO persona) throws SQLException {
		Connection conn = null;
        PreparedStatement preparedStm = null;
        int index = 1;
        
        try {
        	conn = Conexion.conectarBD();
        	preparedStm = conn.prepareStatement(insertPersona);
        	preparedStm.setLong(index++, persona.getDocumentoIdentidad());
        	preparedStm.setString(index++, persona.getNombre());
        	preparedStm.setString(index++, persona.getApellido());
        	preparedStm.setString(index++, persona.getEmail());
        	preparedStm.setString(index++, persona.getTelefono());
        	preparedStm.setString(index++, persona.getDireccion());
        	preparedStm.setString(index++, persona.getCiudad());
        	preparedStm.executeUpdate();
		} finally {
			Conexion.closeConnection(preparedStm, conn);
		}
	}
    
	/**
	 * Metodo encargado de eliminar una persona en la BD
	 * @param documento
	 * @throws SQLException
	 */
    public void deletePersona(Long documento) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStm = null;
        int index = 1;
        
        try {
        	conn = Conexion.conectarBD();
        	preparedStm = conn.prepareStatement(deletePersona);
        	preparedStm.setLong(index++, documento);
        	preparedStm.executeUpdate();
        } finally {
			Conexion.closeConnection(preparedStm, conn);
		}
    }
    
	/**
	 * Metodo encargado de validar si una persona ya existe o no en la BD
	 * @param documento
	 * @return personaExiste
	 * @throws SQLException
	 */
    public boolean validatePersona(Long documento) throws SQLException {
    	boolean personaExiste = false;
        Connection conn = null;
        ResultSet resultado = null;
        PreparedStatement preparedStm = null;
        int index = 1;
        
        try {
            conn = Conexion.conectarBD();
            preparedStm = conn.prepareStatement(findPersona);
            preparedStm.setLong(index++, documento);
            resultado = preparedStm.executeQuery();
            
            if(resultado.next()) {
            	personaExiste = true;
            }
        } finally {
        	Conexion.closeConnection(resultado, preparedStm, conn);
        }
        return personaExiste;
    }
}
