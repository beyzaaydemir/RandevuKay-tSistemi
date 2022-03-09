package com.example.asus.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main13Activity extends AppCompatActivity {

    EditText etsekreterAd,etsekreterSoyad,etsekreterKullaniciAdi,etsekreterSifre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);

        etsekreterAd=(EditText)findViewById(R.id.etsekreterKullaniciAdi);
        etsekreterSoyad=(EditText)findViewById(R.id.etsekreterSoyad);
        etsekreterKullaniciAdi=(EditText)findViewById(R.id.etsekreterKullaniciAdi);
        etsekreterSifre=(EditText)findViewById(R.id.etsekreterSifre);
    }

    public void sekreterKayıt(View v)
    {
        switch (v.getId())
        {
            case R.id.btnsekreterKaydet:
                String sekreterad=etsekreterAd.getText().toString();
                String sekretersoyad=etsekreterSoyad.getText().toString();
                String sekreterkullaniciadi=etsekreterKullaniciAdi.getText().toString();
                String sekretersifre=etsekreterSifre.getText().toString();

                try
                {
                    if(sekreterad.isEmpty() || sekretersoyad.isEmpty() || sekreterkullaniciadi.isEmpty() || sekretersifre.isEmpty())
                    {
                        Toast.makeText(getApplicationContext(),"Alanlar boş geçilmez",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        SekreterBilgiler sb=new SekreterBilgiler(sekreterad,sekretersoyad,sekreterkullaniciadi,sekretersifre);
                        VeriTabani db=new VeriTabani(getApplicationContext());
                        long id=db.SekreterKayitEkle(sb);

                        if(id == -1)
                        {
                            Toast.makeText(Main13Activity.this,"Kayıt hatalı",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(Main13Activity.this,"Kayıt başarılı",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),Main4Activity.class);
                            startActivity(intent);
                        }
                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Bilinmeyen Hata!\n" + e.getMessage().toString(),Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnsekreterVazgec:
                etsekreterAd.getText().clear();
                etsekreterSoyad.getText().clear();
                etsekreterKullaniciAdi.getText().clear();
                etsekreterSifre.getText().clear();

                Intent intentgeri=new Intent(getApplicationContext(),Main4Activity.class);
                startActivity(intentgeri);
                break;
        }
    }

}
