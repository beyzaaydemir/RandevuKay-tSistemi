package com.example.asus.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main10Activity extends AppCompatActivity {
    EditText et_hastaTC, et_hastasifre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        et_hastaTC=(EditText)findViewById(R.id.et_hastaTC);
        et_hastasifre=(EditText)findViewById(R.id.et_hastasifre);
    }

    public void buttontıklat(View v)
    {
        String hastaTC=et_hastaTC.getText().toString();
        String hastasifre=et_hastasifre.getText().toString();

        switch(v.getId())
        {
            case R.id.btn_hastagir:
                if(hastasifre.isEmpty() || hastaTC.isEmpty())
                {
                    Toast.makeText(Main10Activity.this,"Alanlar bos gecilemez!",Toast.LENGTH_SHORT).show();
                }

                VeriTabani db=new VeriTabani(this);
                String hastakontrol=db.hastaKaydiKontrolEt(hastaTC);

                if(hastasifre.equals(hastakontrol))
                {
                    Toast.makeText(Main10Activity.this,"Giriş yapildi....",Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(getApplicationContext(),Main11Activity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Main10Activity.this,"Hatali TC veya sifre!",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_hastakayit:
                Intent intent2=new Intent(getApplicationContext(),Main14Activity.class);
                startActivity(intent2);
                break;
            case R.id.btn_hastatemizle:
                et_hastaTC.getText().clear();
                et_hastasifre.getText().clear();
                break;


        }
    }
}
