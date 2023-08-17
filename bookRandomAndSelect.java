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
        String apiUrl = "https://openlibrary.org/subjects/science_fiction.json?details=false";
        int resultsPerPage = 1;  // Number of results per page (Open Library max limit)

        try {
            String apiUrlWithPagination = apiUrl + "&limit=" + resultsPerPage;
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

            // Print the raw JSON response
            System.out.println(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
