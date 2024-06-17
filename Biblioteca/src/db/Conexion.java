package db;

import java.sql.*;

/**
 * Clase que contiene todos los metodos encargados de gestionar la conexión con la BD del sistema
 * @author Juan José Cardona Henao
 * @version 1.0
 */
public class Conexion {
	
	private static final String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String user = "root";
    private static final String password = "admin";
    
    /**
     * Metodo encargado de realizar la conexion con la BD de MySQL
     * @return
     * @throws SQLException
     */
    public static Connection conectarBD() throws SQLException {
    	Connection conn = DriverManager.getConnection(url, user, password);
    	return conn;
    }
    
    /**
     * Metodo encargado de cerrar la conexión con la BD
     * @param rs
     * @param stm
     * @param conn
     * @throws SQLException
     */
    public static void closeConnection(ResultSet rs, PreparedStatement stm, Connection conn) throws SQLException {
    	rs.close();
    	stm.close();
    	conn.close();
    }
    
    /**
     * Metodo encargado de cerrar la conexión con la BD
     * @param stm
     * @param conn
     * @throws SQLException
     */
    public static void closeConnection(PreparedStatement stm, Connection conn) throws SQLException {
    	stm.close();
    	conn.close();
    }
}
