package com.example.bhargava.touristguide;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;


public class CommonDisplayActivity extends AppCompatActivity {
    ArrayList<String>Name=new ArrayList<>();
    ArrayList<String>Address=new ArrayList<>();
    ArrayList<String>Display=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_to_visit);
        final LinearLayout ll=(LinearLayout)findViewById(R.id.pre_linear);

        String place;
        Intent intent=getIntent();
        place=intent.getStringExtra("Place");
        String query=intent.getStringExtra("Clicked");
        query=query.replaceAll(" ","+");
        HashMap<String,String> hm=new HashMap<>();
        String url_s="https://maps.googleapis.com/maps/api/place/textsearch/json?query="+query+"+in+"+place+"&key=AIzaSyDiOuDDV7yRdHk9mvQMP4uenZ05B1KYSbw";
        Log.e("URL1",url_s);
        Ion.with(this).load(url_s).asJsonObject().setCallback(new FutureCallback<JsonObject>() {
            @Override
            public void onCompleted(Exception e, JsonObject result) {
                try {
                    JSONObject json = new JSONObject(result.toString());
                    JSONArray a=json.getJSONArray("results");
                    for(int i=0;i<a.length();i++)
                    {
                        LinearLayout a1=new LinearLayout(CommonDisplayActivity.this);
                        a1.setOrientation(LinearLayout.VERTICAL);
                        String temp=a.getString(i);
                        JSONObject jo=new JSONObject(temp);
                        String name,address,PHOTO_REFERENCE;
                        name=jo.get("name").toString();
                        JSONArray jarray=jo.getJSONArray("photos");
                        JSONObject joo=jarray.getJSONObject(0);
                        PHOTO_REFERENCE=joo.get("photo_reference").toString();
                        String photo_url="https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference="+PHOTO_REFERENCE+"&sensor=false&key=AIzaSyDiOuDDV7yRdHk9mvQMP4uenZ05B1KYSbw";
                        //Log.e("Photo",photo_url);
                        address=jo.get("formatted_address").toString();
                        TextView tv=new TextView(CommonDisplayActivity.this);
                        tv.setText("\n"+(i+1)+". "+name+"\n");
                        TextView tv2=new TextView(CommonDisplayActivity.this);
                        tv2.setText("\nAddress: "+address+"\n");
                        ImageView iv=new ImageView(CommonDisplayActivity.this);
                        Ion.with(iv).load(photo_url);
                        a1.addView(tv);
                        a1.addView(iv);
                        a1.addView(tv2);
                        View v = new View(CommonDisplayActivity.this);
                        v.setLayoutParams(new LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, 5));
                        v.setBackgroundColor(Color.parseColor("#000000"));
                        a1.addView(v);
                        ll.addView(a1);
                    }
                    //Log.e("URL",Display.toString());
                }
                catch (Exception e1){}
            }
        });

    }

}
