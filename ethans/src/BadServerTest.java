import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import org.JSONInputStream;

public class BadServerTest {


    @SuppressWarnings("unchecked") //surpress compile warnings about unchecked generic operations
    public static void main(String[] args) {

        try {
            //Nasty Path, connecting to a bad server --MalformedURLException--
            URL url = new URL("?");
            HttpURLConnection link = (HttpURLConnection) url.openConnection(); //bad server
            JSONInputStream weatherStream = new JSONInputStream(link.getInputStream());
            HashMap<String, ?> jsonWeather = (HashMap<String, ?>) weatherStream.readObject();
            Weather theWeather = new Weather(jsonWeather);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}