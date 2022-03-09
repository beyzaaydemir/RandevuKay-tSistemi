package com.example.asus.myapplication;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main15Activity extends AppCompatActivity {

    Button buttonrandevugoruntule;
    EditText editText;
    VeriTabani db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main15);

        editText=(EditText)findViewById(R.id.editText);
        buttonrandevugoruntule=(Button)findViewById(R.id.buttonrandevugoruntule);
        buttonrandevugoruntule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bilgilericek(editText.getText().toString());
            }
        });
    }

    public void bilgilericek(String TC)
    {
        try
        {
            ArrayAdapter<String> arrayAdapter2=new ArrayAdapter<String>(Main15Activity.this,android.R.layout.select_dialog_singlechoice);
            VeriTabani vt=new VeriTabani(Main15Activity.this);
            String[] sutunlar={"randevutc","randevuad","randevusoyad","randevutarih","randevuklinik","randevudoktor"};
            db=new VeriTabani(Main15Activity.this);
            SQLiteDatabase sdb=vt.getReadableDatabase();

            Cursor okunanlar=sdb.rawQuery(" select * from randevu where randevutc like '%"+TC+"%' ",null);

            if(okunanlar != null)
            {
                if(okunanlar.moveToFirst())
                {
                    do{
                        String randevutc=okunanlar.getString(okunanlar.getColumnIndex("randevutc"));
                        String randevuad=okunanlar.getString(okunanlar.getColumnIndex("randevuad"));
                        String randevusoyad=okunanlar.getString(okunanlar.getColumnIndex("randevusoyad"));
                        String randevutarih=okunanlar.getString(okunanlar.getColumnIndex("randevutarih"));
                        String randevuklinik=okunanlar.getString(okunanlar.getColumnIndex("randevuklinik"));
                        String randevudoktor=okunanlar.getString(okunanlar.getColumnIndex("randevudoktor"));

                        arrayAdapter2.add("\n" + randevutc + " \n " + randevuad + " \n " + randevusoyad + " \n " + randevutarih + " \n " + randevuklinik + " \n " + randevudoktor);

                    }while(okunanlar.moveToNext());
                }
                okunanlar.close();
            }
            cekilenlerigoster(arrayAdapter2);
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Bilgiler getirilirken hata oldu. ",Toast.LENGTH_SHORT).show();

        }
    }

    private void cekilenlerigoster(final ArrayAdapter arrayAdapter2)
    {
        AlertDialog.Builder builderSingle=new AlertDialog.Builder(Main15Activity.this);
        builderSingle.setIcon(R.drawable.ic_launcher_background);
        builderSingle.setTitle("Randevularınız");

        builderSingle.setNegativeButton("Çıkış", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builderSingle.setAdapter(arrayAdapter2, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String strName=(String)arrayAdapter2.getItem(i);
                AlertDialog.Builder builderInner=new AlertDialog.Builder(Main15Activity.this);
                builderInner.setCancelable(false);
                builderInner.setMessage(strName);

                builderInner.setTitle("Randevu");
                builderInner.setPositiveButton("Çıkış", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                    }
                });
                builderInner.show();
            }
        });
        builderSingle.show();
    }
}
