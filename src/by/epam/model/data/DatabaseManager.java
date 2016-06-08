package by.epam.model.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.epam.exceptions.ConnectionException;

public class DatabaseManager {
	
	public static Connection getConnection() throws ConnectionException {
		final String driver = "org.gjt.mm.mysql.Driver";
		final String url = "jdbc:mysql://localhost/struts_ejb";
		final String user = "jee";
		final String password = "jee";
		
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new ConnectionException(e);
		}
		return connection;
	}
	
	public static void closeResultSet(ResultSet set) {
		if (set != null) {
			try {
				set.close();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	public static void closeStatements(Statement... statements) {
		for (Statement st : statements) {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			}
		}
	}
	
	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
