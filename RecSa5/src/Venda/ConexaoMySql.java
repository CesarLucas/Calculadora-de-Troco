package Venda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoMySql {

	private static String DRIVE = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/sa5r";
	private static String USER = "root";
	private static String PASS = "1234";
	
	public static Connection iniciarConexao() {
		try {
			Class.forName(DRIVE);
			return DriverManager.getConnection(URL, USER, PASS);			
		}
		catch (SQLException | ClassNotFoundException e) {
			throw new  RuntimeException("Erro na Conexão "+ e);
		}
	}
	
	public static void encerrarConexao(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public static void encerrarConexao(Connection connection, PreparedStatement stmt) {
		encerrarConexao(connection);
			try {
				connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	public static void encerrarConexao(Connection connection, PreparedStatement stmt, ResultSet rs) {
		encerrarConexao(connection, stmt);
			try {
				connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
}