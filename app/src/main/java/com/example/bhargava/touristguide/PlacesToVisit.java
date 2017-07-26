package com.example.bhargava.touristguide;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

public class PlacesToVisit extends AppCompatActivity {
    ArrayList<String>Name=new ArrayList<>();
    ArrayList<String>Address=new ArrayList<>();
    ArrayList<String>Display=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_to_visit);

        String place;
        Intent intent=getIntent();
        place=intent.getStringExtra("Place");
        HashMap<String,String> hm=new HashMap<>();
        String url_s="https://maps.googleapis.com/maps/api/place/textsearch/json?query=places+in+"+place+"&key=AIzaSyDiOuDDV7yRdHk9mvQMP4uenZ05B1KYSbw";
        Log.e("URL1",url_s);
        String json_string=getJSON(url_s);

        try {
            JSONObject json = new JSONObject(json_string);
            JSONArray a=json.getJSONArray("results");
            for(int i=0;i<a.length();i++)
            {
                String temp=a.getString(i);
                JSONObject jo=new JSONObject(temp);
                String name,address;
                name=jo.get("name").toString();
                address=jo.get("formatted_address").toString();
                Display.add((i+1)+". "+name+"\n"+address);
            }
            Log.e("URL",Display.toString());

            try {
                ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Display);
                ListView lv = (ListView) findViewById(R.id.lv);
                lv.setAdapter(adapter);
            } catch (Exception e) {
                Toast.makeText(this, "Not Yet Implemented", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e1){}

    }

    public static String getJSON(String url) {
        HttpsURLConnection con = null;
        try {
            URL u = new URL(url);
            con = (HttpsURLConnection) u.openConnection();

            con.connect();


            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            return sb.toString();


        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }


}
