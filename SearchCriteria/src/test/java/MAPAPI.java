import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class MAPAPI {

    //  public static void main(String[] args) throws IOException, JSONException {
    protected WebDriver driver;
    // use OKHttp client to create the connection and retrieve data

    static OkHttpClient client = new OkHttpClient();

    static Request request = new Request.Builder()

            .url("https://maps.googleapis.com/maps/api/place/textsearch/json?query=lunapark+in+TelAviv&key=AIzaSyCvaxHPvhNwEFx7izIo-fCFEsxW8Xdg2qU")
            .build();

    static Response response;

    static {
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String jsonData;

    static {
        try {
            jsonData = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // parse JSON

    static JSONObject mainJsonObject;

    static {
        try {
            mainJsonObject = new JSONObject(jsonData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // get Json object

    static JSONObject resultsJson;

    static {
        try {
            resultsJson = mainJsonObject.getJSONObject("location");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    //   JSONObject resJson1 = resultsJson.getJSONObject("lat");
    //   JSONObject resJson2 = resultsJson.getJSONObject("lng");

    // get value

    String val1 = resultsJson.getString("lat");
    String val2 = resultsJson.getString("lng");
    //        System.out.println(val1);


    public MAPAPI() throws JSONException, IOException {
    }
}


