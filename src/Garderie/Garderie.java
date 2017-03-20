package Garderie;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Garderie {

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

			
			String queryEnfant = "SELECT nom, prenom FROM enfant";
			ResultSet rsE = st.executeQuery(queryEnfant);
			
			while (rsE.next()){
				System.out.printf("%-20s %-20s \n", rsE.getString("nom") ,rsE.getString("prenom"));
			}			
			
			
			String queryResponsableLegal = "SELECT nom, prenom FROM responsable_legal";
			ResultSet rsRL = st.executeQuery(queryResponsableLegal);
			
			while (rsRL.next()){
				System.out.printf("%-20s %-20s \n", rsRL.getString("nom") ,rsRL.getString("prenom"));
			}
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
