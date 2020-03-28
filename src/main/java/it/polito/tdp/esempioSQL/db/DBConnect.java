package it.polito.tdp.esempioSQL.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 // per la connessione -> visibilita' non public ma solo nel package così nessuno al di fuori del package puo' usarla
class DBConnect {
	 	
	public static Connection getConnection() throws SQLException {

		String jdbcURL= "jdbc:mysql://localhost/babs?user=root&password=root"; 
		return DriverManager.getConnection(jdbcURL); 
	}

}
