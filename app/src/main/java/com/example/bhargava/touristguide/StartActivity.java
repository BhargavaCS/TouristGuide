package com.example.bhargava.touristguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void getDetailsClicked(View view)
    {
        EditText et=(EditText) findViewById(R.id.place);
        String place=et.getText().toString();
        Toast.makeText(this,place+" Is a Beautiful Place", Toast.LENGTH_SHORT).show();
        Intent intent =new Intent(this,MyOptions.class);
        intent.putExtra("Place",place);
        startActivity(intent);
    }

}
