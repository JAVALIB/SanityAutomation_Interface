import java.net.URL;
import java.util.List;
import com.google.gdata.client.spreadsheet.FeedURLFactory;
import com.google.gdata.client.spreadsheet.ListQuery;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.CustomElementCollection;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetFeed;

public class NoAuth {
    public static void main(String[] args) throws Exception{
        String applicationName = "AppName";
        String key = args[0];
        String query = args[1];

        SpreadsheetService service = new SpreadsheetService(applicationName);

        URL url = FeedURLFactory.getDefault().getWorksheetFeedUrl(key, "public", "basic");

        WorksheetFeed feed = service.getFeed(url, WorksheetFeed.class);
        List<WorksheetEntry> worksheetList = feed.getEntries();
        WorksheetEntry worksheetEntry = worksheetList.get(0);

        ListQuery listQuery = new ListQuery(worksheetEntry.getListFeedUrl());
        listQuery.setSpreadsheetQuery( query );

        ListFeed listFeed = service.query( listQuery, ListFeed.class );
        List<ListEntry> list = listFeed.getEntries();
        for( ListEntry listEntry : list )
        {
            System.out.println( "content=[" + listEntry.getPlainTextContent() + "]");
            CustomElementCollection elements = listEntry.getCustomElements();
            System.out.println(
                    " name=" + elements.getValue("name") + 
                    " age="  + elements.getValue("age") );
        }
    }
}