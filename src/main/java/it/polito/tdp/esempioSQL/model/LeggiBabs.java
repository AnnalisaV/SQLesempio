package it.polito.tdp.esempioSQL.model;

import java.util.List;

import it.polito.tdp.esempioSQL.db.BabsDAO;

/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
*/ // non deve conoscere nulla di jdbc

public class LeggiBabs {
	
	public void run() {
		
		// mi serve un accesso al Database
		BabsDAO dao= new BabsDAO(); 
		
		List<Station> tutteStazioni= dao.listaStation(); 
		
		//le visualizzo
		for (Station s : tutteStazioni) {
			System.out.println(s.getName()); 
		}
		
		System.out.println("\n -----"); 
		List<Station> paloAlto= dao.listaStationByLandmark("Palo Alto"); 
		for (Station s : paloAlto) {
			System.out.println(s.getName()); 
		}
		
		/* 
		//DEFINIZIONE URL DI CONNESSIONE
		String jdbcURL= "jdbc:mysql://localhost/babs?user=root&password=root"; 
		
		// APRO CONNESSIONE : Creo un oggetto di tipo Connection(Interfaccia di java.sql) chiedendolo al DriverManager(classe di java.sql)
		// si usa qst metodo perche' non sappiamo come si chiama davvero la classe che implementa il Driver
		try {
			Connection conn= DriverManager.getConnection(jdbcURL); // un po' come List= new ArrayList() ma 
            // FACTORY ovvero creazione di un oggetto di 
    //una classe senza conoscere il tipo della classe 
    //dunque senza usare il new. Si usa un metodo,
  //fornito da altra classe, che internamente fa 
 //new in quanto consce il tipo di classe effettivo
			
			///// faccio qualcosa 
			
			// Creazione SQL Statement (java.sql)
			//Statement st= conn.createStatement(); semplice ma poco efficiente e poco sicuro (SQL Injection)
			//Esecuzione query
			// la scrivo su Heidi e la copio qui così sono sicura di non commettere errori di sintassi
			String sql= "SELECT name  FROM station"; // query da definire prima dello Statement (qui non parametrica)
			
			// query con template parametrico
			String query= "SELECT name FROM station WHERE landmark= ? "; // no apici intorno a ?
			PreparedStatement st= conn.prepareStatement(query); // gli passo il template 
			
			// definsico i parametri
			st.setString(1,  "Palo Alto"); // sono in Java quindi doppi apici, in SQL invece sono singoli
			
			//ResultSet res = st.executeQuery(sql); // il modo per ottenere il risultato della query, anch'esso Interfaccia, anch'esso tramite Factory
			                                      //.executeUpdate() per operazioni si aggiornamento del db che restituisce il numero (int) di righe modificate
			                                     //.execute() in generale che restituisce un boolean per sapere se l'operazione 'e andata a buon fine o no
			
			ResultSet res= st.executeQuery(); // non passo alcun parametro
			
			while(res.next() ) {//== true)  {
				// vi e' la riga 
				String nomeStazione= res.getString("name"); 
				
				System.out.println(nomeStazione); 
			}
			//st.close(); // ottenuto il risultato, non mi serve piu' quindi lo chiudo se voglio farne poi altre così la connessione puo' essere ancora utilizzata ma la memoria di questa st non viene mantenuta 
			
			//posso sfruttare la connessione per fare una nuova query 
			//Statement st2=conn.createStatement(); 
			
			
			//CHIUSURA CONNESSIONE
			conn.close(); // farlo subito appena la si apre, così il programma non si sovraccarica essendovi un numero limitato di risorse per le connessioni
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		
		*/  // TRASFERITO TUTTO NEL DAO -> DOVE DEVE STARE!!!
		
		
	}
	
	
	public static void main(String args[]) {
		LeggiBabs babs= new LeggiBabs(); 
		babs.run(); 
	}

}
