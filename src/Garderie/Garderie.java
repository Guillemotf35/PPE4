package Garderie;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class Garderie {

	String idRL;
	Double prixTotal = 0.0;
	int nbQuartHeure;
	Double prixQuartHeure = 0.0;
	private ArrayList<Garderie> lesResponsablesLegal = new ArrayList();
	
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

            Scanner sc = new Scanner(System.in);
            System.out.println("saisir le nom du responsable légal : ");
            String responsableLegalSelect = sc.nextLine();
			
			
			String queryResponsableLegal = "SELECT responsable_legal.id,nom, prenom, QF, prixQuartHeure FROM responsable_legal, tarif where responsable_legal.tarif_id=tarif.id and nom='"+responsableLegalSelect+"' ";
			ResultSet rsRL = st.executeQuery(queryResponsableLegal);
			
			while (rsRL.next()){
				idRL = rsRL.getString("id");
				
				System.out.printf("%-20s %-20s %-20s %-20s %-20s \n", rsRL.getString("responsable_legal.id"), rsRL.getString("nom") ,rsRL.getString("prenom") ,rsRL.getString("QF"), rsRL.getString("prixQuartHeure"));			
				prixQuartHeure = rsRL.getDouble("prixQuartHeure");
			
			}
			String queryEnfant = "SELECT enfant.nom, enfant.prenom, heureArriveeMatin , heureDepartSoir , responsable_legal.nom FROM enfant, presence, responsable_legal where enfant.id = presence.enfant_id and responsable_legal.id=enfant.responsable_legal_id and responsable_legal.id = '"+idRL+"' ";
			ResultSet rsE = st.executeQuery(queryEnfant);
			
			while (rsE.next()){
				System.out.printf("%-20s %-20s %-20s %-20s \n", rsE.getString("nom") ,rsE.getString("prenom"), rsE.getString("heureArriveeMatin") ,rsE.getString("heureDepartSoir"));
				nbQuartHeure=(9-rsE.getTime("heureArriveeMatin").getHours())*4;
				nbQuartHeure = nbQuartHeure + (0-rsE.getTime("heureArriveeMatin").getMinutes()/15);
				System.out.println(nbQuartHeure);
				prixTotal = prixTotal + prixQuartHeure*nbQuartHeure ;
			
			}			
			
			System.out.println(prixTotal);

			
//			String queryNbEnfant = "SELECT count(*) as 'nb' FROM enfant, presence WHERE enfant.id=presence.enfant_id and responsable_legal_id ='"+idRL+"' ";
//			ResultSet rsNbE = st.executeQuery(queryNbEnfant);
//			
//			while (rsNbE.next()){
//				System.out.println("nombre d'enfant : ");
//				System.out.printf("%-20s \n", rsNbE.getString("nb"));
//				prixTotal = prixTotal*rsNbE.getInt("nb");
//				System.out.println(prixTotal);
//			}
			
			
			
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
