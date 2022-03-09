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

public class Main11Activity extends AppCompatActivity {

    EditText editRandevuId,editTCNo,editAd,editSoyad,editTarih;
    Spinner spinner,spinnerdoktor;
    List<String> list;

    Context context=this;
    ArrayAdapter<String> adapter,adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);

        editRandevuId=(EditText)findViewById(R.id.editRandevuId);
        editTCNo=(EditText)findViewById(R.id.editTCNo);
        editAd=(EditText)findViewById(R.id.editAd);
        editSoyad=(EditText)findViewById(R.id.editSoyad);
        editTarih=(EditText)findViewById(R.id.editTarih);
        spinner=(Spinner)findViewById(R.id.spinner);
        spinnerdoktor=(Spinner)findViewById(R.id.spinnerdoktor);


        init();
        init2();
    }

    public void HastaRandevuIslem(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_randevuolustur:
                String TCNo=editTCNo.getText().toString();
                String Ad=editAd.getText().toString();
                String Soyad=editSoyad.getText().toString();
                String Tarih=editTarih.getText().toString();
                String Klinik=spinner.getSelectedItem().toString();
                String Doktor=spinnerdoktor.getSelectedItem().toString();

                try
                {
                    if(TCNo.isEmpty() || Ad.isEmpty() || Soyad.isEmpty() || Tarih.isEmpty())
                    {
                        Toast.makeText(getApplicationContext(),"Alanlar boş geçilemez!",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Randevu rndv=new Randevu(TCNo,Ad,Soyad,Tarih,Klinik,Doktor);
                        VeriTabani db=new VeriTabani(getApplicationContext());

                        long id=db.RandevuOlustur(rndv);
                        if(id == -1)
                        {
                            Toast.makeText(getApplicationContext(),"Randevu oluşturulamadı.",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Randevu oluşturuldu.",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                catch(Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Bilinmeyen hata!\n" + e.getMessage().toString(),Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_randevusil:
                VeriTabani myDb=new VeriTabani(this);
                Integer deletedRows=myDb.HastaRandevuSil(editRandevuId.getText().toString());
                if(deletedRows>0)
                {
                    Toast.makeText(Main11Activity.this,"Kişi silindi.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Main11Activity.this,"Kişi silinemedi.",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_randevuguncelle:
                VeriTabani DB=new VeriTabani(this);
                boolean isUpdate=DB.RandevuGuncelle(editRandevuId.getText().toString(),editTCNo.getText().toString(),editAd.getText().toString(),editSoyad.getText().toString(),editTarih.getText().toString(),spinner.getSelectedItem().toString(),spinnerdoktor.getSelectedItem().toString());
                if(isUpdate==true)
                {
                    Toast.makeText(Main11Activity.this,"Randevunuz güncellendi",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Main11Activity.this,"Randevunuz güncellenemedi.",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_randevugoruntule:
                Intent intent=new Intent(Main11Activity.this,Main15Activity.class);
                Main11Activity.this.startActivity(intent);
                Main11Activity.this.finish();
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

    public void init2()
    {
        list=new ArrayList<>();

        list.add("Sena Yılmaz");
        list.add("Kenan Ay");
        list.add("Serap Yalçın");
        list.add("Ahmet Güneş");
        list.add("Yaren Parlak");
        list.add("Kübra Deniz");
        list.add("Şule Demir");
        list.add("Ali Gün");

        spinnerdoktor=(Spinner) findViewById(R.id.spinnerdoktor);
        adapter2=new ArrayAdapter<>(context,android.R.layout.simple_spinner_dropdown_item,list);
        spinnerdoktor.setAdapter(adapter2);

    }



}
