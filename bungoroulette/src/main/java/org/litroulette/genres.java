package org.litroulette;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;
public class genres {
    public static ArrayList<String> genreDB() {
        ResultSet rs = null;
        ArrayList<String> genres = new ArrayList<String>();
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
                genres.add(genreName);
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
