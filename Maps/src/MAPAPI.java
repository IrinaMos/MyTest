import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class MAPAPI {

        public static void main(String[] args) throws IOException, JSONException {

            // use OKHttp client to create the connection and retrieve data

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()

                    .url("https://free.currencyconverterapi.com/api/v6/convert?q=USD_ILS&compact=y&apiKey=58cf369bec8516bbe488")
                    .build();

            Response response = client.newCall(request).execute();

            String jsonData = response.body().string();

            // parse JSON

            JSONObject mainJsonObject = new JSONObject(jsonData);

            // get Json object

            JSONObject resultsJson = mainJsonObject.getJSONObject("USD_ILS");

            // get value

            double val = resultsJson.getDouble("val");

            System.out.println(val);


        }

    }

}
