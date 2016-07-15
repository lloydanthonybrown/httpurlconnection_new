import org.quickconnectfamily.json.JSONInputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class NullURLTest {
    @SuppressWarnings("unchecked") //surpress compile warnings about unchecked generic operations
    public static void main(String[] args) {
        try {
            // Will fail because it has a null for a URL --MalformedURLException-- and NullPointerException
            URL url = new URL(null);
            HttpURLConnection link = (HttpURLConnection) url.openConnection();
            JSONInputStream weatherStream = new JSONInputStream(link.getInputStream());
            HashMap<String, ?> jsonWeather = (HashMap<String, ?>) weatherStream.readObject();
            Weather theWeather = new Weather(jsonWeather);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
