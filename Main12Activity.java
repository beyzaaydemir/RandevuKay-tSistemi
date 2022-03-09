package com.example.asus.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main12Activity extends AppCompatActivity {

    EditText etAd,etSoyad,etKullaniciAdi,etSifre;
    Spinner spinner;
    List<String> list;

    Context context=this;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

        etAd=(EditText)findViewById(R.id.etAd);
        etSoyad=(EditText)findViewById(R.id.etSoyad);
        etKullaniciAdi=(EditText)findViewById(R.id.etKullaniciAdi);
        etSifre=(EditText)findViewById(R.id.etSifre);
        spinner=(Spinner)findViewById(R.id.spinner);

        init();
    }

    public void DishekimiKayit(View v)
    {
        switch (v.getId())
        {
            case R.id.btnKaydet:
                //verileri string olarak tutacak
                String ad=etAd.getText().toString();
                String soyad=etSoyad.getText().toString();
                String kullaniciadi=etKullaniciAdi.getText().toString();
                String sifre=etSifre.getText().toString();
                String klinik=spinner.getSelectedItem().toString();

                try
                {
                    if(ad.isEmpty() || soyad.isEmpty() || kullaniciadi.isEmpty() || sifre.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Alanlar boş geçilmez!", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        DisHekimiBilgiler dhb=new DisHekimiBilgiler(ad,soyad,kullaniciadi,sifre,klinik); //DisHekimiBilgiler türünde bir nesne olşturuluyor
                        VeriTabani db=new VeriTabani(getApplicationContext()); //Veritabanı bağlantısı açıldı

                        long id=db.DishekimiKayitEkle(dhb); //long deger -1 dönmemeli dönerse kayıt işlemi hatalıdır

                        if(id == -1)
                        {
                            Toast.makeText(Main12Activity.this, "Kayıt işlemi hatalı!", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Kayıt işlemi başarılı",Toast.LENGTH_SHORT).show();
                            Intent intentgeri=new Intent(getApplicationContext(),Main2Activity.class);
                            startActivity(intentgeri);
                        }

                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Bilinmeyen Hata!\n" + e.getMessage().toString(),Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnVazgec:
                etAd.getText().clear();
                etSoyad.getText().clear();
                etKullaniciAdi.getText().clear();
                etSifre.getText().clear();

                Intent intentgeri=new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intentgeri);
                break;
        }


    }

    public void init()
    {
        list=new ArrayList<>();

        list.add("Estetik Diş Hekimliği");
        list.add("Ortadonti");
        list.add("İmplantoloji");
        list.add("Protez");
        list.add("Diş Beyazlatma");
        list.add("Endodonti");
        list.add("Dolgu Tedavisi");
        list.add("Perrodontoloji");

        spinner=(Spinner) findViewById(R.id.spinner);
        adapter=new ArrayAdapter<>(context,android.R.layout.simple_spinner_dropdown_item,list);
        spinner.setAdapter(adapter);

    }
}
