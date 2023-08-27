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
        JSONObject[] works;
        String genre = "horror";
        works = (JSONObject[]) bookRandomAndSelect.getRandomBooks(genre);
        System.out.println(works.length);
        for( Object workObj: works)
            {
                JSONObject work = (JSONObject) workObj;
                String title = (String) work.get("title");
                System.out.println("Title: " + title);
            }
    }
}