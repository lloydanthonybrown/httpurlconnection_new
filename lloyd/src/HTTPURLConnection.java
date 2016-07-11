import org.quickconnectfamily.json.JSONInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class HTTPURLConnection {
//    @SuppressWarnings("unchecked") //surpress compile warnings about unchecked generic operations
//    https://dp.la/info/developers/codex/policies/#get-a-key
//    my DPLA (Digital Public Library of America) key = 7f1c6a0558d81501cb1c1dc67e4c20bc
//    How do I return just one of the results of my query? I think I can customize the query to just return one.
    public static void main(String[] args) {
        try {
            URL url = new URL("http://api.dp.la/v2/items?q=squirrels+AND+san+diego&api_key=7f1c6a0558d81501cb1c1dc67e4c20bc"); // search for squirrels AND San Diego
            // does this mean I'm casting it, or just specifying the type of connection?
            HttpURLConnection oneSquirrelyConnection = (HttpURLConnection) url.openConnection(); //open connection
            JSONInputStream squirrelStream = new JSONInputStream(oneSquirrelyConnection.getInputStream()); // create JSONInputStream
            // What does the question mark mean in this context? Is it a wildcard character?
            HashMap<String, ?> jsonSquirrel = (HashMap<String, ?>) squirrelStream.readObject();
            SquirrelBook theSquirrelBook = new SquirrelBook(jsonSquirrel); //weather class
            printSquirrelBook(theSquirrelBook);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printSquirrelBook(SquirrelBook theSquirrelBook) {
        System.out.println("Title: " + theSquirrelBook.getTitle());
        System.out.println("Publisher: " + theSquirrelBook.getPublisher());
        System.out.println("Date Adopted Into DPLA: " + theSquirrelBook.getIngestDate());
        System.out.println("Number of Results for Query: " + theSquirrelBook.getCount());
    }
}
