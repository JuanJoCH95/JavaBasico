package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import db.Conexion;
import entity.LibroDTO;

/**
 * Clase que contiene todos los metodos para realizar las transacciones de libros en la BD del sistema
 * @author Juan José Cardona Henao
 * @version 1.0
 */
public class LibroDao {
	
	private static final String findLibro = "SELECT id_libros, nombre, autor, genero, prestado FROM test.libros WHERE nombre like (?)";
	private static final String insertLibro = "INSERT INTO test.libros(nombre, autor, genero) VALUES(?, ?, ?)";
	private static final String updateLibro = "UPDATE test.libros SET nombre = ?, autor = ?, genero = ? WHERE id_libros = ?";
	private static final String deleteLibro = "DELETE FROM test.libros WHERE id_libros = ?";
	
	/**
	 * Metodo encargado de consultar un libro en la BD
	 * @param nombre
	 * @return libroDto
	 * @throws SQLException
	 */
	public LibroDTO findLibro(String nombre) throws SQLException {
		LibroDTO libroDto = null;
		Connection conn = null;
        ResultSet resultado = null;
        PreparedStatement preparedStm = null;
        int index = 1;
		
        try {
        	conn = Conexion.conectarBD();
            preparedStm = conn.prepareStatement(findLibro);
            preparedStm.setString(index++, nombre + "%");
            resultado = preparedStm.executeQuery();
            
            if(resultado.next()) {
            	libroDto = new LibroDTO();
            	libroDto.setIdLibro(resultado.getLong("id_libros"));
            	libroDto.setNombre(resultado.getString("nombre"));
            	libroDto.setAutor(resultado.getString("autor"));
            	libroDto.setGenero(resultado.getString("genero"));
            	libroDto.setEstado("N".equals(resultado.getString("prestado")) ? "Disponible" : "En prestamo");
            }
		} finally {
			Conexion.closeConnection(resultado, preparedStm, conn);
		}
		return libroDto;
	}
	
	/**
	 * Metodo encargado de modificar un libro en la BD
	 * @param libro
	 * @throws SQLException
	 */
	public void updateLibro(LibroDTO libro) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStm = null;
        int index = 1;
        
        try {
        	conn = Conexion.conectarBD();
        	preparedStm = conn.prepareStatement(updateLibro);
        	preparedStm.setString(index++, libro.getNombre());
        	preparedStm.setString(index++, libro.getAutor());
        	preparedStm.setString(index++, libro.getGenero());
        	preparedStm.setLong(index++, libro.getIdLibro());
        	preparedStm.executeUpdate();
        } finally {
			Conexion.closeConnection(preparedStm, conn);
		}
    }
	
	/**
	 * Metodo encargado de insertar un nuevo libro en la BD
	 * @param libro
	 * @throws SQLException
	 */
	public void insertLibro(LibroDTO libro) throws SQLException {
		Connection conn = null;
        PreparedStatement preparedStm = null;
        int index = 1;
        
        try {
        	conn = Conexion.conectarBD();
        	preparedStm = conn.prepareStatement(insertLibro);
        	preparedStm.setString(index++, libro.getNombre());
        	preparedStm.setString(index++, libro.getAutor());
        	preparedStm.setString(index++, libro.getGenero());
        	preparedStm.executeUpdate();
		} finally {
			Conexion.closeConnection(preparedStm, conn);
		}
	}
	
	/**
	 * Metodo encargado de eliminar un libro en la BD
	 * @param idLibro
	 * @throws SQLException
	 */
	public void deleteLibro(Long idLibro) throws SQLException {
		Connection conn = null;
        PreparedStatement preparedStm = null;
        int index = 1;
        
        try {
        	conn = Conexion.conectarBD();
        	preparedStm = conn.prepareStatement(deleteLibro);
        	preparedStm.setLong(index++, idLibro);
        	preparedStm.executeUpdate();
		} finally {
			Conexion.closeConnection(preparedStm, conn);
		}
	}
	
	/**
	 * Metodo encargado de validar si un libro ya existe o no en la BD
	 * @param nombre
	 * @return libroExiste
	 * @throws SQLException
	 */
    public boolean validateLibro(String nombre) throws SQLException {
    	boolean libroExiste = false;
        Connection conn = null;
        ResultSet resultado = null;
        PreparedStatement preparedStm = null;
        int index = 1;
        
        try {
            conn = Conexion.conectarBD();
            preparedStm = conn.prepareStatement(findLibro);
            preparedStm.setString(index++, nombre + "%");
            resultado = preparedStm.executeQuery();
            
            if(resultado.next()) {
            	libroExiste = true;
            }
        } finally {
        	Conexion.closeConnection(resultado, preparedStm, conn);
        }
        return libroExiste;
    }
}
