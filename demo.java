import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;
public class demo
{
    public static void main(String[] args)
    {
        HashMap<String, String> genresMap = genres.genreDB();       
        for(Map.Entry<String, String> entry : genresMap.entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue());
        
    }
}