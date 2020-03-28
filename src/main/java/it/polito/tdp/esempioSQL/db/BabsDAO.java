package it.polito.tdp.esempioSQL.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.esempioSQL.model.Station;

//classe usata dal Model LeggiBabs
public class BabsDAO {
	
	
	/**
	 * Per ottenere una lista di Station
	 * @return
	 */
	public List<Station> listaStation(){
		
		List<Station> result= new ArrayList<>(); 
		
		String sql = "SELECT station_id, NAME, dockCount, landmark FROM Station ORDER BY name" ; 
		
		// Ora riporto il codice di collegamento al Database 
	
		//String jdbcURL= "jdbc:mysql://localhost/babs?user=root&password=root"; 
		
		
		try {
			//Connection conn= DriverManager.getConnection(jdbcURL);
			Connection conn= DBConnect.getConnection(); 
  
			PreparedStatement st= conn.prepareStatement(sql); 
			
			ResultSet res= st.executeQuery(); 
			
			while(res.next() ) {
				// analizzo il contenuto della query 
			   // estraggo i vari campi e costruisco un oggetto di tipo Station
				Station s= new Station(res.getInt("station_id"), res.getString("name"), 
						res.getInt("dockCount"), res.getString("landmark"));
				
				result.add(s); 
				
			}
			st.close(); 
			
			conn.close(); 
			
			return result; 
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		return null; // se qualcosa non avesse funzionato
		
		
		
	}
	
	public List<Station> listaStationByLandmark(String landmark){
		// come la lista di tutte el stazioni ma filtrata dal WHERE 
	List<Station> result= new ArrayList<>(); 
		String sql = "SELECT station_id, NAME, dockCount, landmark FROM Station WHERE landmark= ? "
				+ "ORDER BY name" ; 
		
		
		try {
			Connection conn= DBConnect.getConnection();  
           PreparedStatement st= conn.prepareStatement(sql); 
           // riempio la query 
           st.setString(1,  landmark);
			ResultSet res= st.executeQuery(); 
			
			while(res.next() ) {
				// analizzo il contenuto della query 
			   // estraggo i vari campi e costruisco un oggetto di tipo Station
				Station s= new Station(res.getInt("station_id"), res.getString("name"), 
						res.getInt("dockCount"), res.getString("landmark"));
				
				result.add(s); 
				
			}
			st.close(); 
			conn.close(); 
			return result; 
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		return null; // se qualcosa non avesse funzionato
		
		
		
	}

}
