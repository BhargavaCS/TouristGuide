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
        Intent new_intent=new Intent(this,CommonDisplayActivity.class);
        new_intent.putExtra("Place",place);
        new_intent.putExtra("Clicked","places");
        startActivity(new_intent);
    }

    public void Hotels(View view)
    {
        Intent intent=getIntent();
        String place=intent.getStringExtra("Place");
        Intent new_intent=new Intent(this,CommonDisplayActivity.class);
        new_intent.putExtra("Place",place);
        new_intent.putExtra("Clicked","Hotels");
        startActivity(new_intent);
    }

    public void Restaurants(View view)
    {
        Intent intent=getIntent();
        String place=intent.getStringExtra("Place");
        Intent new_intent=new Intent(this,CommonDisplayActivity.class);
        new_intent.putExtra("Place",place);
        new_intent.putExtra("Clicked","Restaurants");
        startActivity(new_intent);
    }

    public void Temples(View view)
    {
        Intent intent=getIntent();
        String place=intent.getStringExtra("Place");
        Intent new_intent=new Intent(this,CommonDisplayActivity.class);
        new_intent.putExtra("Place",place);
        new_intent.putExtra("Clicked","Temples");
        startActivity(new_intent);
    }

    public void Hospitals(View view)
    {
        Intent intent=getIntent();
        String place=intent.getStringExtra("Place");
        Intent new_intent=new Intent(this,CommonDisplayActivity.class);
        new_intent.putExtra("Place",place);
        new_intent.putExtra("Clicked","Hospitals");
        startActivity(new_intent);
    }

    public void ITCompanies(View view)
    {
        Intent intent=getIntent();
        String place=intent.getStringExtra("Place");
        Intent new_intent=new Intent(this,CommonDisplayActivity.class);
        new_intent.putExtra("Place",place);
        new_intent.putExtra("Clicked","ITCompanies");
        startActivity(new_intent);
    }

}
