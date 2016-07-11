import java.util.Date;
import java.util.HashMap;

public class SquirrelBook {
    private String title;
    private String publisher;
    private Date ingestDate; // date the collection or item was ingested into the DPLA
    private int count; // number of matches for a query

    public SquirrelBook() {
    }

    public SquirrelBook(HashMap<String, ?> squirrelHashMap) {
        // This must represent something unique to Ethan's weather API, because I don't have any valid references for a "main"
        // This also means that I don't really have a reason to make a secondary HashMap here, I think.

        HashMap<String, ?> mainBlock = (HashMap<String, ?>) squirrelHashMap.get("main");
        this.title = (String) squirrelHashMap.get("title");
        this.publisher = (String)mainBlock.get("publisher"); // This is where I got the most recent error.
        this.ingestDate = (Date)mainBlock.get("ingestDate");
        this.count = (Integer)mainBlock.get("count");
    }

    public String getTitle() {
        return this.title;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public Date getIngestDate() {
        return this.ingestDate;
    }

    public int getCount() {
        return this.count;
    }
}
