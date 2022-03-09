package com.example.asus.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.btn_doktor);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();

            }
        });

        Button button2=(Button)findViewById(R.id.btn_sekreter);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(MainActivity.this,Main4Activity.class);
                MainActivity.this.startActivity(intent2);
                MainActivity.this.finish();
            }
        });

        Button button3=(Button)findViewById(R.id.btn_hasta);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(MainActivity.this,Main10Activity.class);
                MainActivity.this.startActivity(intent3);
                MainActivity.this.finish();
            }
        });


    }
}
