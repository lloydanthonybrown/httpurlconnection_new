import org.quickconnectfamily.json.JSONInputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class BadServerTest {
    @SuppressWarnings("unchecked") //surpress compile warnings about unchecked generic operations
    public static void main(String[] args) {
        try {
            //Nasty Path, connecting to a bad server --MalformedURLException-- No protocol.
            // Use a different protocol -ftp, something else
//            Result: ClassCastException. Requires HttpURLConnection type.
            URL url = new URL("ftp://ftp.sillyrabbit.com");
            HttpURLConnection link = (HttpURLConnection) url.openConnection(); //bad server
            JSONInputStream weatherStream = new JSONInputStream(link.getInputStream());
            HashMap<String, ?> jsonWeather = (HashMap<String, ?>) weatherStream.readObject();
            Weather theWeather = new Weather(jsonWeather);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}