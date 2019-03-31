import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class MAPAPI {

      public static void main(String[] args) throws IOException, JSONException {
 //   protected WebDriver driver;
 //    use OKHttp client to create the connection and retrieve data

     OkHttpClient client = new OkHttpClient();

     Request request = new Request.Builder()

            .url("https://maps.googleapis.com/maps/api/place/textsearch/json?query=lunapark+in+TelAviv&key=AIzaSyCvaxHPvhNwEFx7izIo-fCFEsxW8Xdg2qU")
            .build();

          Response response = client.newCall(request).execute();

          String jsonData = response.body().string();

          // parse JSON

          JSONObject mainJsonObject = new JSONObject(jsonData);


    // get Json object

         JSONObject   resultsJson = mainJsonObject.getJSONObject("location");

    //   JSONObject resJson1 = resultsJson.getJSONObject("lat");
    //   JSONObject resJson2 = resultsJson.getJSONObject("lng");

    // get value

    String val1 = resultsJson.getString("lat");
    String val2 = resultsJson.getString("lng");

}
}


