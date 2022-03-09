package com.example.asus.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    EditText et_sekreterad,et_sekretersifre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        et_sekreterad=(EditText)findViewById(R.id.et_sekreterad);
        et_sekretersifre=(EditText)findViewById(R.id.et_sekretersifre);
    }

    public void butonadokun(View v)
    {
        String kullaniciadi=et_sekreterad.getText().toString();
        String sifre=et_sekretersifre.getText().toString();

        switch (v.getId())
        {
            case R.id.btn_sekretergir:
                if(sifre.isEmpty() || kullaniciadi.isEmpty())
                {
                    Toast.makeText(Main4Activity.this,"Alanlar boş geçilmez.",Toast.LENGTH_SHORT).show();
                }

                VeriTabani db=new VeriTabani(this);

                String sekreterkontrol=db.SekreterKontrolEt(kullaniciadi);

                if(sifre.equals(sekreterkontrol))
                {
                    Toast.makeText(Main4Activity.this,"Giriş yapıldı.",Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(getApplicationContext(),Main5Activity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Main4Activity.this,"Hatalı kullanıcı adı veya şifre",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_sekreterkayit:
                Intent intent2=new Intent(getApplicationContext(),Main13Activity.class);
                startActivity(intent2);
                break;
            case R.id.btn_sekretertemizle:
                et_sekreterad.getText().clear();
                et_sekretersifre.getText().clear();
                break;
        }
    }
}
