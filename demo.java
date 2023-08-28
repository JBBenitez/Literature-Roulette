import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.lang.Math;
public class demo
{
    public static void main(String[] args)
    {
        int answer = 0;
        String [] genreArray = new String [8];
        Scanner scan = new Scanner(System.in);
        HashMap<String,String> bookGenres = genres.genreDB();
        while (answer!=8)
        {   
            int selections = 0;
            System.out.println("Enter a number to select a genre or quit program");
            for (Map.Entry<String, String> entry: bookGenres.entrySet())
            {
                System.out.println(selections + ": "+ entry.getKey());
                genreArray[selections++] = entry.getKey();
            }
            System.out.println(selections + ": quit");
            answer = scan.nextInt();
            switch(answer)
            {
                case 0: 
                    printBooks(genreArray[0].toLowerCase());
                    break;
                case 1: 
                    printBooks(genreArray[1].toLowerCase());
                    break;
                case 2: 
                    printBooks(genreArray[2].toLowerCase());
                    break;
                case 3: 
                    printBooks(genreArray[3].toLowerCase());
                    break;
                case 4: 
                    printBooks(genreArray[4].toLowerCase());
                    break;
                case 5: 
                    printBooks(genreArray[5].toLowerCase());
                    break;
                case 6: 
                    printBooks(genreArray[6].toLowerCase());
                    break;
                case 7: 
                    printBooks(genreArray[7].toLowerCase());
                    break;
                case 8:
                    System.out.println("exiting");
                    break; 
            }
            System.out.println("\n\n\n\n\n\n\n");
        }
        scan.close();
    }
    public static void printBooks(String genre)
    {
        JSONObject[] works;
        works = (JSONObject[]) bookRandomAndSelect.getRandomBooks(genre);
        System.out.println("Your 5 " + genre.toLowerCase() +" randomized books");
        for( Object workObj: works)
            {
                JSONObject work = (JSONObject) workObj;
                String title = (String) work.get("title");
                System.out.println("Title: " + title);
            }
    }
}