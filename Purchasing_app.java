package proj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Purchasing_app {

	static void viewTest (Connection con) {
		
		try {
			Statement stmt = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
			
			String update = "";
			
			update += "CREATE VIEW view1 AS ";
			update += "SELECT * ";
			update += "FROM record; ";

			int i = stmt.executeUpdate(update);
			
			
			String query = "";
			
			query += "SELECT * ";
			query += "FROM view1 ";
			
			ResultSet results = stmt.executeQuery(query);	    
			
			System.out.println("This View is a duplicate of the contents of the current Record table: ");
			System.out.println();
			
		    while (results.next()) {
			    System.out.println(results.getInt(1) + " " + 
		                           results.getString(2) + " " + 
			    		           results.getString(3) + " " +
			    		           results.getString(4) + " " +
			    		           results.getInt(5) + " " +
			    		           results.getInt(6));
			    }

		    System.out.println(); 
		       
		}
		catch (Exception e) { e.printStackTrace(); }	
	}
	
	
	static void query1 (Connection con) {
		
		// Suppose we want to see which records we have in the store...
		
		try {
			Statement stmt = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);


			String query = "";
			
			query += "SELECT artist, title, s_stock ";
			query += "FROM record ";
			query += "WHERE s_stock > 0 ";
			query += "GROUP BY artist, title, s_stock";
				
						
			ResultSet results = stmt.executeQuery(query);	    
		    
			System.out.println("Q1. List all records we currently have in stock in the store");
			System.out.println();
			
		    while (results.next()) {
			    System.out.println(results.getString(1) + ", " + results.getString(2)
			    				+ ". Copies currently in stock: " + results.getInt(3));
			    }

		    System.out.println(); 
		       
		}
		catch (Exception e) { e.printStackTrace(); }	
	}
	
	
	
	
	
	static void query2 (Connection con) {
		
		// Suppose we want to stock up in general...
		
		try {
			Statement stmt = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
			
			String query = "";
			
			query += "SELECT distributor.artist, distributor.title, distributor.name ";
			query += "FROM distributor ";
			query += "JOIN record ";
			query += "ON distributor.title = record.title ";
			query += "WHERE s_stock = 0 ";
			query += "AND d_stock > 0 ";			
			query += "GROUP BY distributor.artist, distributor.title, distributor.name";
						
		    ResultSet results = stmt.executeQuery(query);		    
		    
			System.out.println("Q2. List all records currently available for purchase that we don’t have in stock");
			System.out.println();
		    
		    while (results.next()) {
			    System.out.println(results.getString(1) + ", " + results.getString(2)
			    				+ ". Available at distributor: " + results.getString(3));
			    }

		    System.out.println(); 
		       
		}
		catch (Exception e) { e.printStackTrace(); }	
	}
	
	
	static void query3 (Connection con) {
		
		// Suppose we want to stock up on a certain artist...
		
		String wantedartist = "Adam Beyer";
		
		try {
			Statement stmt = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
			
			String query = "";
			
			query += "SELECT distributor.artist, distributor.title, distributor.name ";
			query += "FROM distributor ";
			query += "JOIN record ";
			query += "ON distributor.title = record.title ";
			query += "WHERE s_stock = 0 ";
			query += "AND d_stock > 0 ";
			query += "AND distributor.artist = '" + wantedartist + "' ";
			query += "GROUP BY distributor.artist, distributor.title, distributor.name";
						
		    ResultSet results = stmt.executeQuery(query);		    
		    
			System.out.println("Q3. List all records by Adam Beyer, currently available for purchase, we don’t have in stock");
			System.out.println();
		    
		    while (results.next()) {
			    System.out.println(results.getString(1) + ", " + results.getString(2)
			    				+ ". Available at distributor: " + results.getString(3));
			    }

		    System.out.println(); 
		       
		}
		catch (Exception e) { e.printStackTrace(); }	
	}	
	
	
	
	static void query4 (Connection con) {
		
		// Suppose we want to stock up on a certain genre...
		
		String wantedgenre = "Techno";
		
		try {
			Statement stmt = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
			
			String query = "";
			
			query += "SELECT distributor.artist, distributor.title, distributor.name ";
			query += "FROM distributor ";
			query += "JOIN record ";
			query += "ON distributor.title = record.title ";
			query += "WHERE s_stock = 0 ";
			query += "AND d_stock > 0 ";
			
			query += "AND distributor.artist in ";
			query += "(SELECT artist ";		
			query += "FROM genre ";		
			query += "WHERE genrename = '" + wantedgenre + "') ";
			
			query += "GROUP BY distributor.artist, distributor.title, distributor.name";
									
		    ResultSet results = stmt.executeQuery(query);		    
		    
			System.out.println("Q4. List all records in the Techno genre, currently available for purchase, we don’t have in stock");
			System.out.println();
		    
		    while (results.next()) {
			    System.out.println(results.getString(1) + ", " + results.getString(2)
			    				+ ". Available at distributor: " + results.getString(3));
			    }

		    System.out.println();

		    System.out.println(); 
		       
		}
		catch (Exception e) { e.printStackTrace(); }	
	}
	
	
	static void query5 (Connection con) {
		
		// Suppose we want to stock up on a certain genre and time period...
		
		String wantedgenre = "Techno";
		int yearmax = 2010;
		int yearmin = 2000;
		
		try {
			Statement stmt = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
			
			String query = "";
			
			query += "SELECT distributor.artist, distributor.title, distributor.name ";
			query += "FROM distributor ";
			query += "JOIN record ";
			query += "ON distributor.title = record.title ";
			query += "WHERE s_stock = 0 ";
			query += "AND d_stock > 0 ";
			query += "AND year <= " + yearmax + " ";
			query += "AND year >= " + yearmin + " ";
			query += "AND distributor.artist in ";
			query += "(SELECT artist ";		
			query += "FROM genre ";		
			query += "WHERE genrename = '" + wantedgenre + "') ";
			
			query += "GROUP BY distributor.artist, distributor.title, distributor.name";
									
		    ResultSet results = stmt.executeQuery(query);		    
		    
			System.out.println("Q5. List all records in the Techno genre released during 2000-2010 ");
			System.out.println("currently available for purchase, we don’t have in stock");
			
			System.out.println();
		    
		    while (results.next()) {
			    System.out.println(results.getString(1) + ", " + results.getString(2)
			    				+ ". Available at distributor: " + results.getString(3));
			    }

		    System.out.println(); 
		       
		}
		catch (Exception e) { e.printStackTrace(); }	
	}
	
	
	
	public static void main(String[] args) throws SQLException {
		
		//Set username etc for mysql database
		String USERNAME = "root";
		String PASSWORD = "root";
		String CONNECT = "jdbc:mysql://localhost/project";
				
		Connection con = null;
		PreparedStatement ps = null;
		
				
		try {
		
			con = DriverManager.getConnection(CONNECT, USERNAME, PASSWORD);
			
			
			
			/**************************************************
			 * 
			 *  Here are queries demonstrating the functionality
			 *  of this purchasing support app.
			 *  
			 *  To use this app in the real world, we would add a
			 *  GUI that lets the user decide the details of each
			 *  query, such as e.g. specifically which artist they
			 *  are interested in seeing available records for, etc,
			 *  as well as functionality for adding new records to
			 *  the inventory (table Record), etc.
			 * 
			 */
			
			//viewTest(con);
		    //query1(con);
			//query2(con);
			//query3(con);
			//query4(con);
			query5(con);

			
		}
		catch (Exception e) { e.printStackTrace(); } 
		finally { if(con != null) con.close(); }		
	}
}
