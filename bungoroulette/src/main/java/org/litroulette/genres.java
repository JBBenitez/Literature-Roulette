package org.litroulette;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;
public class genres {
    public static HashMap<String,String> genreDB() {
        ResultSet rs = null;
        HashMap<String,String> genres = new HashMap<String,String>();
        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Establish a connection to the database
            Connection connection = DriverManager.getConnection("jdbc:sqlite:mydatabase.db");

            // Create a statement
            Statement statement = connection.createStatement();

            String query = "SELECT name,description FROM genres";
            rs = statement.executeQuery(query);
            while(rs.next()) 
            {
                String genreName = rs.getString("name");
                String genreDescription = rs.getString("description");
                genres.put(genreName, genreDescription);
            }

            // Close resources
            statement.close();
            connection.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return genres;
    }

}
