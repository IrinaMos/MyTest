import org.json.JSONException;
import org.openqa.selenium.By;

import java.io.IOException;

public class Constants extends MAPAPI {
        public static By INPUT = By.id("searchboxinput");
        public static By ICON = By.id("searchbox-searchbutton");
        public static String expectedText = "32°06'23.4\"N 34°48'42.8\"E";
        public static By GooglePage = By.className("section-hero-header-title");
        public static String val1;

    static {
        val1 = "32.22";//resultsJson.getString("lat");
    }

    public static String val2;

    static {
        val2 = "22.1";//resultsJson.getString("lng");
    }

    public Constants() throws JSONException, IOException {
        }
}
