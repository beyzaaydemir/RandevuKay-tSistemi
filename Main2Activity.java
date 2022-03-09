package com.example.asus.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText et_ad,et_sifre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et_ad=(EditText)findViewById(R.id.et_ad);
        et_sifre=(EditText)findViewById(R.id.et_sifre);

    }

    public void butonaDokunuldu(View v)
    {
        //Kullanıcı adı ve parolayı alıyoruz.
        String kullaniciadi=et_ad.getText().toString();
        String sifre=et_sifre.getText().toString();

        //Buton islevleri tanımlanıyor.

        switch (v.getId())
        {
            case R.id.btn_gir:
                if(sifre.isEmpty() || kullaniciadi.isEmpty())
                {
                    Toast.makeText(Main2Activity.this,"Alanlar bos gecilemez.",Toast.LENGTH_SHORT).show();
                }

                VeriTabani db=new VeriTabani(this);

                //Kullanıcı adı alınıp sifre kontrol edilecek
                String kontrol=db.KaydiKontrolEt(kullaniciadi);

                if(sifre.equals(kontrol))
                {
                    Toast.makeText(Main2Activity.this,"Giriş yapıldı...",Toast.LENGTH_SHORT).show();
                    //şifre doğruysa main3(randevu görüntüleme ekranı) açılacak

                    Intent intent=new Intent(getApplicationContext(),Main3Activity.class);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(Main2Activity.this,"Hatalı kullanıcı adı ve şifre!",Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn_kayit:
                Intent intent2=new Intent(getApplicationContext(),Main12Activity.class);
                startActivity(intent2);
                break;
            case R.id.btn_temizle:
                et_ad.getText().clear();
                et_sifre.getText().clear();
                break;

        }

    }
}
