package com.example.bhargava.touristguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MyOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_options);
    }

    public void PlacesToVisit(View view)
    {
        Intent intent=getIntent();
        String place=intent.getStringExtra("Place");
        Intent new_intent=new Intent(this,PlacesToVisit.class);
        new_intent.putExtra("Place",place);
        startActivity(new_intent);
    }

    public void Hotels(View view)
    {
        Intent intent=getIntent();
        String place=intent.getStringExtra("Place");
        Intent new_intent=new Intent(this,Hotels.class);
        new_intent.putExtra("Place",place);
        startActivity(new_intent);
    }

    public void Restaurants(View view)
    {
        Intent intent=getIntent();
        String place=intent.getStringExtra("Place");
        Intent new_intent=new Intent(this,Restaurants.class);
        new_intent.putExtra("Place",place);
        startActivity(new_intent);
    }
}
