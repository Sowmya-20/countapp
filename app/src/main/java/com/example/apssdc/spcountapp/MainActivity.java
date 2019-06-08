package com.example.apssdc.spcountapp;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4;
    TextView text;
    int i;
    private int colourCode;
    SharedPreferences sp;
    private String spFileName="com.example.apssdc.spcountapp";
    private String countKey="countKey";
    private String colourKey="colorKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.black);
        b2=findViewById(R.id.green);
        b3=findViewById(R.id.red);
        b4=findViewById(R.id.blue);
        text=findViewById(R.id.text);
        sp=getSharedPreferences(spFileName,MODE_PRIVATE);
        i=sp.getInt(countKey,i);
        text.setText(String.valueOf(i));
        text.setText(String.valueOf(i));
        colourCode=sp.getInt(colourKey,colourCode);
        if (colourCode!=0)
        {
            text.setBackgroundColor(colourCode);
        }
    }


  /*    public void black(View view) {
        // colourCode=R.color.black;
        text.setBackgroundColor(Color.BLACK);
    }

    public void green(View view) {
        // colourCode= R.color.green;
        text.setBackgroundColor(Color.GREEN);
    }*/

    public void red(View view) {
        colourCode= ((ColorDrawable)view.getBackground()).getColor();
        text.setBackgroundColor(colourCode);
    }

  /*  public void blue(View view) {
        colourCode=getResources().getColor(R.color.blue);
        text.setBackgroundColor(colourCode);
    }*/

    public void count(View view) {
        i++;
        text.setText(String.valueOf(i));
}

    public void reset(View view) {
        i=0;
        text.setText("0");
        colourCode=getResources().getColor(R.color.grey);
        text.setBackgroundColor(colourCode);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor=sp.edit();
        editor.putInt(countKey,i);
        editor.putInt(colourKey,colourCode);
        editor.apply();
    }
}
