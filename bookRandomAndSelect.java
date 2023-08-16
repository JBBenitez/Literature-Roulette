import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class bookRandomAndSelect {
    public static void main(String[] args)
    {
        String apiKey = "AIzaSyDryGZK74eOZ5yNFgrAJo1AyIqFUkcHB_Q";
        String apiUrl = "https://www.googleapis.com/books/v1/volumes?q=subject:action&key=" + apiKey + "&startIndex=20" +;
        String jsonResponseString = "";
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            try 
            {
                JSONParser parser = new JSONParser();
                JSONObject jsonResponse = (JSONObject) parser.parse(response.toString());
                JSONArray items = (JSONArray) jsonResponse.get("items");
                for(Object item:items)
                {
                    JSONObject bookInfo = (JSONObject) item;
                    JSONObject volumeInfo = (JSONObject) bookInfo.get("volumeInfo");
                    String title = (String) volumeInfo.get("title");
                    System.out.println("Title: " + title);
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
