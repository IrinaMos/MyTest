import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MAPAPI extends GeneralPage{

      public static void main(String[] args) throws IOException, JSONException {
 //   protected WebDriver driver;
 //    use OKHttp client to create the connection and retrieve data

     OkHttpClient client = new OkHttpClient();

     Request request = new Request.Builder()

            .url("https://maps.googleapis.com/maps/api/place/textsearch/json?query=lunapark+in+TelAviv&key=AIzaSyAtJW2okzAbfaeT-yc7AUYa02BMiuxKP34")
            .build();

          Response response = client.newCall(request).execute();

          String jsonData = response.body().string();
          System.out.print(jsonData);
          // parse JSON
          JSONObject mainJsonObject = new JSONObject(jsonData);
          JSONArray array = mainJsonObject.getJSONArray("results");
          JSONObject resultsJson = array.getJSONObject(0);
          JSONObject geometry = resultsJson.getJSONObject("geometry");
          JSONObject location = geometry.getJSONObject("location");


      System.out.print(resultsJson);

    // get value

          double val1 = location.getDouble("lat");
          double val2 = location.getDouble("lng");

}
}


