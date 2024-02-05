import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIPrototype {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=London&appid=YOUR_API_KEY");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println("Response from API:\n" + response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
