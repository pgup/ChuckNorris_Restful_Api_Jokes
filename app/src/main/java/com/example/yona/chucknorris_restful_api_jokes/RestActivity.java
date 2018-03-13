package com.example.yona.chucknorris_restful_api_jokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;

public class RestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest);
    }
        /*

{
   "type":"success",
   "value":{
      "id":153,
      "joke":"The movie &quot;Delta Force&quot; was extremely hard to make because Chuck had to downplay his abilities. The first few cuts were completely unbelievable.",
      "categories":[

      ]
   }
} */
    public void chuckNorrisClick(View view) {
        /*TextView tv = (TextView) findViewById(R.id.output);
        tv.setText("HIII");*/

        Ion.with(this)
                .load(
                        "http://api.icndb.com/jokes/random")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        // do stuff with the result or error
                    JsonObject value = result.getAsJsonObject("value");
                    String joke = value.get("joke").getAsString();
                        TextView tv = (TextView) findViewById(R.id.output);
                        tv.setText(joke);



                    }
                });
    }
}
