import org.quickconnectfamily.json.JSONInputStream;
import java.net.HttpURLConnection;
import java.net.URL; //URL library
import java.util.HashMap;

    // bad server, bad page, bad url, null url, empty url
public class URLConnectionTest {
    @SuppressWarnings("unchecked") //surpress compile warnings about unchecked generic operations
    public static void main(String[] args) {

        try {
            //API key: 86ceb341fce769a0759dfe7dc86b3df7
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?id=5596475&APPID=86ceb341fce769a0759dfe7dc86b3df7"); //weather for Rexburg
            HttpURLConnection link = (HttpURLConnection) url.openConnection(); //open link
            JSONInputStream weatherStream = new JSONInputStream(link.getInputStream());
            HashMap<String, ?> jsonWeather = (HashMap<String, ?>) weatherStream.readObject();
            Weather theWeather = new Weather(jsonWeather); //weather class
            printWeather(theWeather);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printWeather(Weather theWeather) {
        System.out.println();
        System.out.println("City: " + theWeather.getCityName()); //get city name
        System.out.println("Current Temperature: " + convertKelvinToFahrenheit(theWeather.getCurrentTemp())); //get current temp b converting into F
        System.out.println("Low Temperature: " + convertKelvinToFahrenheit(theWeather.getLowTemp())); //get low temp
        System.out.println("High Temperature: " + convertKelvinToFahrenheit(theWeather.getHighTemp())); //get high temp
    }

    private static long convertKelvinToFahrenheit(double kelvin) { //algorithm for kelvin to fahrenheit
        long fahrenheit = (long) Math.round((kelvin - 273.15) * 1.8 + 32);
        return fahrenheit;
    }
}
