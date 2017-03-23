package Garderie;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Garderie {

	String idRL;
	Double prixTotal = 0.0;
	int nbQuartHeure;
	private ArrayList<Garderie> responsableLegal = new ArrayList();
	
	void loadDriver() throws ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	Connection newConnection() throws SQLException{
		final String url = "jdbc:mysql://localhost/garderie";
		Connection conn = DriverManager.getConnection(url, "root", "");
		return conn;
		
	}
	
	
	public void listPersons() throws SQLException {
		Connection conn = null;
		try {
			conn = newConnection();
			Statement st = conn.createStatement();

			
			String queryEnfant = "SELECT nom, prenom, heureArriveeMatin , heureDepartSoir FROM enfant, presence where enfant.id = presence.enfant_id";
			ResultSet rsE = st.executeQuery(queryEnfant);
			
			while (rsE.next()){
				System.out.printf("%-20s %-20s %-20s %-20s \n", rsE.getString("nom") ,rsE.getString("prenom"), rsE.getString("heureArriveeMatin") ,rsE.getString("heureDepartSoir"));
				nbQuartHeure=(9-rsE.getTime("heureArriveeMatin").getHours())*4;
				nbQuartHeure = nbQuartHeure + (0-rsE.getTime("heureArriveeMatin").getMinutes()/15);
				System.out.println(nbQuartHeure);
			}			
			
			
			String queryResponsableLegal = "SELECT responsable_legal.id,nom, prenom, QF, prixQuartHeure FROM responsable_legal, tarif where responsable_legal.tarif_id=tarif.id";
			ResultSet rsRL = st.executeQuery(queryResponsableLegal);
			
			while (rsRL.next()){
				System.out.printf("%-20s %-20s %-20s %-20s %-20s \n", rsRL.getString("responsable_legal.id"), rsRL.getString("nom") ,rsRL.getString("prenom") ,rsRL.getString("QF"), rsRL.getString("prixQuartHeure"));
				
				idRL = rsRL.getString("id");
				prixTotal = rsRL.getDouble("prixQuartHeure")*nbQuartHeure ;

			}
			
			String queryNbEnfant = "SELECT count(*) as 'nb' FROM enfant, responsable_legal WHERE enfant.responsable_legal_id=responsable_legal.id and responsable_legal.id = '"+idRL+"' ";
			ResultSet rsNbE = st.executeQuery(queryNbEnfant);
			
			while (rsNbE.next()){
				System.out.println("nombre d'enfant : ");
				System.out.printf("%-20s \n", rsNbE.getString("nb"));
				prixTotal = prixTotal*rsNbE.getInt("nb");
				System.out.println(prixTotal);
			}
			
			
			
			//prixQuartHeure*nbQuartHeure*nbEnfants
			//SELECT count(*)
			//FROM enfant, responsable_legal
			//WHERE enfant.responsable_legal_id=responsable_legal.id
			//and responsable_legal.nom = "DUPONT"
			//and responsable_legal.prenom = "Maxime"
		}
		finally
		{
			if (conn != null) conn.close();
		}
	}
	
	
	public static void main(String[] args) {
		Garderie test = new Garderie();
		
		try{
			test.loadDriver();
			test.listPersons();
			
		}
		catch (ClassNotFoundException e){
			System.err.println("Pilote");
		}
		catch (SQLException e){
			System.out.println("SQL"+e.getMessage());
			System.out.println("SQL state"+e.getSQLState());
			System.out.println("Vendor"+e.getErrorCode());
			e.printStackTrace();
		}

	}

}
