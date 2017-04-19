package com.corvi.jsonapicallexample;

import android.content.Context;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import static android.R.attr.mode;

public class MainActivity extends AppCompatActivity {

    ArrayList<Model> models;
    CustomAdapter customAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        models = new ArrayList<>();
        listView = (ListView)findViewById(R.id.listView);

        customAdapter = new CustomAdapter(models, MainActivity.this);

        listView.setAdapter(customAdapter);

        new MyAsynckTask().execute();
    }

    class MyAsynckTask extends AsyncTask<String, Void,String>
    {

        @Override
        protected String doInBackground(String... params) {

            String strUrl = "http://lifi.tk/books.json";

            try {
                URL url = new URL(strUrl);

                URLConnection urlConnection = url.openConnection();

                InputStream inputStream = urlConnection.getInputStream();

                StringBuilder stringBuilder = new StringBuilder();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                int ch;
                while((ch=inputStreamReader.read()) != -1)
                {
                    stringBuilder.append((char)ch);
                }
                String result = stringBuilder.toString();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {
                JSONArray jsonArray = new JSONArray(result);
                for(int index=0; index<jsonArray.length(); index++)
                {
                    Model model = new Model();
                    JSONObject jsonObject = jsonArray.getJSONObject(index);
                    model.setBookId(jsonObject.getString("bookId"));
                    model.setName(jsonObject.getString("name"));
                    model.setPrice(jsonObject.getString("price"));
                    model.setBookId(jsonObject.getString("inStock"));
                    models.add(model);


                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            customAdapter.notifyDataSetChanged();
        }
    }
}
