import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.lang.Math;
public class bookRandomAndSelect {
    public static Object[] getRandomBooks(String genre)
    {
        int max = 1000;
        int min = 0;
        int books = 0;
        int range = max - min + 1;
        
        int rand = (int)(Math.random()*range)+min;
        JSONObject[] works = new JSONObject [5];
        String apiUrl = "https://openlibrary.org/subjects/"+genre+".json?details=false";
        int resultsPerPage = 5;  // Number of results per page (Open Library max limit)
        
        try {
            String apiUrlWithPagination = apiUrl + "&limit=" + resultsPerPage + "&offset="+rand;
            URL url = new URL(apiUrlWithPagination);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            Object obj = new JSONParser().parse(response.toString());
            JSONObject jResp = (JSONObject) obj;
            JSONArray jRespArray = (JSONArray) jResp.get("works");
            for( Object workObj: jRespArray )
            {
                JSONObject work = (JSONObject) workObj;
                works[books++] = work;
            }


            // Print the raw JSON response

        } catch (Exception e) {
            e.printStackTrace();
        }
        return works;
    }
}
