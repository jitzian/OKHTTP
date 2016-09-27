package examples.android.mac.com.org.okhttp;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import examples.android.mac.com.org.okhttp.model.Person;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getName();
    Button button1;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Do not do strange stuff in the main thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        button1 = (Button)findViewById(R.id.button1);
        textView1 = (TextView)findViewById(R.id.textView1);


    }

    public void clickOKHTTP(View view) {
        /**
         *
         * JSONArray jsonarray = new JSONArray(jsonStr);
         for (int i = 0; i < jsonarray.length(); i++) {
         JSONObject jsonobject = jsonarray.getJSONObject(i);
         String name = jsonobject.getString("name");
         String url = jsonobject.getString("url");
         }
         **/

        //This is how we call OK_HTTP
        Log.d(TAG, "clickOKHTTP");
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://www.mocky.io/v2/57a01bec0f0000c10d0f650f")
                .build();
        Response response = null;

        try {
            response = client.newCall(request).execute();
            String hello = response.body().string();
            Log.d(TAG, "onCreate: " + hello);

            JSONArray jsonArray = new JSONArray(hello);

            for(int i = 0; i < jsonArray.length(); i ++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String name = jsonObject.getString("name");
                Log.d(TAG, "NAME: " + name);

                String age = jsonObject.getString("age");
                Log.d(TAG, "AGE: " + age);

                String grade = jsonObject.getString("grade");
                Log.d(TAG, "grade: " + grade);
            }

//            //Parse JSON to GSON
            Gson gson = new Gson();
            GsonBuilder gsonBuilder = new GsonBuilder();

            Type listType = new TypeToken<List<Person>>(){}.getType();
            List<Person> lstPerson = (List<Person>) gson.fromJson(hello, listType);

            for(int i = 0; i < lstPerson.size(); i ++){
                Log.d(TAG, lstPerson.get(i).getName());
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
