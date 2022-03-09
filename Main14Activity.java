package com.example.asus.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main14Activity extends AppCompatActivity {

    EditText ethastaAd,ethastaSoyad,ethastaTC,ethastaSifre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);

        ethastaAd=(EditText)findViewById(R.id.ethastaAd);
        ethastaSoyad=(EditText)findViewById(R.id.ethastaSoyad);
        ethastaTC=(EditText)findViewById(R.id.ethastaTC);
        ethastaSifre=(EditText)findViewById(R.id.ethastaSifre);
    }

    public void HastaKayit(View v)
    {
        switch(v.getId())
        {
            case R.id.btnhastaKaydet:
                String hastaad=ethastaAd.getText().toString();
                String hastasoyad=ethastaSoyad.getText().toString();
                String hastaTC=ethastaTC.getText().toString();
                String hastasifre=ethastaSifre.getText().toString();

                try
                {
                    if(hastaad.isEmpty() || hastasoyad.isEmpty() || hastaTC.isEmpty() || hastasifre.isEmpty())
                    {
                        Toast.makeText(getApplicationContext(),"Alanlar bos gecilemez!",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        hastaBilgiler hb=new hastaBilgiler(hastaad,hastasoyad,hastaTC,hastasifre);
                        VeriTabani db=new VeriTabani(getApplicationContext());

                        long id=db.HastaKayitEkle(hb);

                        if(id == -1)
                        {
                            Toast.makeText(Main14Activity.this,"Kayit islemi hatali!",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Kayit basarili.",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),Main10Activity.class);
                            startActivity(intent);
                        }
                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Bilinmeyen Hata!\n" + e.getMessage().toString(),Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnhastaVazgec:
                ethastaAd.getText().clear();
                ethastaSoyad.getText().clear();
                ethastaTC.getText().clear();
                ethastaSifre.getText().clear();

                Intent intentgeri=new Intent(getApplicationContext(),Main10Activity.class);
                startActivity(intentgeri);
                break;
        }
    }
}
