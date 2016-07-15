import org.quickconnectfamily.json.JSONInputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class BadURLTest {
    @SuppressWarnings("unchecked") //surpress compile warnings about unchecked generic operations
    public static void main(String[] args) {
        try {
            //Nasty Path - 401 error for URL (resource doesn't exist on server)
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=cookiesabc"); //bad url
            HttpURLConnection link = (HttpURLConnection) url.openConnection();
            JSONInputStream weatherStream = new JSONInputStream(link.getInputStream());
            HashMap<String, ?> jsonWeather = (HashMap<String, ?>) weatherStream.readObject();
            Weather theWeather = new Weather(jsonWeather);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
