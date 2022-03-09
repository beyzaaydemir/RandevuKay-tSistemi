package com.example.asus.myapplication;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class VeriTabani extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "disklinik";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLO_NAME = "dishekimi";
    private static final String ROW_ID = "id";
    private static final String ROW_AD = "ad";
    private static final String ROW_SOYAD = "soyad";
    private static final String ROW_KULLANICIADI = "kullaniciad";
    private static final String ROW_SIFRE = "sifre";
    private static final String ROW_KLINIK="klinik";

    private static final String TABLO2_NAME = "sekreter";
    private static  final String SUTUN_ID = "Id";
    private static  final String SUTUN_AD = "Ad";
    private static  final String SUTUN_SOYAD = "Soyad";
    private static  final String SUTUN_KULLANICIADI = "KullanıcıAd";
    private static  final String SUTUN_SIFRE = "Sifre";

    private static final String TABLO3_NAME = "hastalar";
    private static final String ROW_HASTAID = "hastaid";
    private static final String ROW_HASTAAD = "hastaad";
    private static final String ROW_HASTASOYAD = "hastasoyad";
    private static final String ROW_HASTATC = "hastaTC";
    private static final String ROW_HASTASIFRE = "hastasifre";

    private static final String TABLO4_NAME = "randevu";
    private static final String ROW_RANDEVUID = "randevuid";
    private static final String ROW_RANDEVUTC = "randevutc";
    private static final String ROW_RANDEVUAD = "randevuad";
    private static final String ROW_RANDEVUSOYAD = "randevusoyad";
    private static final String ROW_RANDEVUTARIH = "randevutarih";
    private static final String ROW_RANDEVUKLINIK = "randevuklinik";
    private static final String ROW_RANDEVUDOKTOR="randevudoktor";


    public VeriTabani(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    String TABLO = "CREATE TABLE " + TABLO2_NAME +
            "(" + SUTUN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            SUTUN_AD + " TEXT, " +
            SUTUN_SOYAD + " TEXT, " +
            SUTUN_KULLANICIADI + " TEXT, " +
            SUTUN_SIFRE + " TEXT " + ")";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLO_NAME + "("
                + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ROW_AD + " TEXT NOT NULL, "
                + ROW_SOYAD + " TEXT NOT NULL, "
                + ROW_KULLANICIADI + " TEXT NOT NULL, "
                + ROW_SIFRE + " TEXT NOT NULL, "
                + ROW_KLINIK + " TEXT NOT NULL) ");

        db.execSQL(TABLO);

        db.execSQL("CREATE TABLE " + TABLO3_NAME + "("
                + ROW_HASTAID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ROW_HASTAAD + " TEXT NOT NULL, "
                + ROW_HASTASOYAD + " TEXT NOT NULL, "
                + ROW_HASTATC + " TEXT NOT NULL, "
                + ROW_HASTASIFRE + " TEXT NOT NULL) ");

        db.execSQL("CREATE TABLE " + TABLO4_NAME + "("
                + ROW_RANDEVUID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ROW_RANDEVUTC + " TEXT NOT NULL, "
                + ROW_RANDEVUAD + " TEXT NOT NULL, "
                + ROW_RANDEVUSOYAD + " TEXT NOT NULL, "
                + ROW_RANDEVUTARIH + " TEXT NOT NULL, "
                + ROW_RANDEVUKLINIK + " TEXT NOT NULL, "
                + ROW_RANDEVUDOKTOR + " TEXT NOT NULL) ");



    }

    String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLO2_NAME;


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLO_NAME);
        onCreate(db);

        db.execSQL(DROP_USER_TABLE);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLO3_NAME);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLO4_NAME);
        onCreate(db);

    }

    public String KaydiKontrolEt(String gelenad)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLO_NAME,null,ROW_KULLANICIADI+"=?",new String[]{gelenad},null,null,null);

        //Kullanıcı adı yoksa hata verilir.
        if(cursor.getCount()<1)
        {
            cursor.close();
            return "Kayit bulunamadi.";
        }
        cursor.moveToFirst();
        String password=cursor.getString(cursor.getColumnIndex(ROW_SIFRE));
        cursor.close();

        return password;
    }

    public String hastaKaydiKontrolEt(String hastagelenTC)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLO3_NAME,null,ROW_HASTATC+"=?",new String[]{hastagelenTC},null,null,null);

        //Kullanıcı adı yoksa hata verilir.
        if(cursor.getCount()<1)
        {
            cursor.close();
            return "Kayit bulunamadi.";
        }
        cursor.moveToFirst();
        String password2=cursor.getString(cursor.getColumnIndex(ROW_HASTASIFRE));
        cursor.close();

        return password2;
    }

    public  String SekreterKontrolEt(String gelen)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLO2_NAME,null,SUTUN_KULLANICIADI+"=?",new String[]{gelen},null,null,null);

        if(cursor.getCount()<1)
        {
            cursor.close();
            return "Kayit bulunamadi.";
        }
        cursor.moveToFirst();
        String parola=cursor.getString(cursor.getColumnIndex(SUTUN_SIFRE));
        cursor.close();

        return parola;
    }



    public long DishekimiKayitEkle(DisHekimiBilgiler dhb)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        //Content value cv'nin değerleri DisHekimiBilgiler.java kısmındanki propertie kullanımı ile ilgili kısımlara aktarılıyor.
        ContentValues cv=new ContentValues();
        cv.put(ROW_AD,dhb.getAd());
        cv.put(ROW_SOYAD,dhb.getSoyad());
        cv.put(ROW_KULLANICIADI,dhb.getKullaniciAdi());
        cv.put(ROW_SIFRE,dhb.getSifre());
        cv.put(ROW_KLINIK,dhb.getKlinik());

        //insert() geri dönüş tipi long tur.Geriye döndürdüğü değer o satırın id değeridir.
        //eğer hata oluşuyorsa id değeri -1 döner.hata oluşup oluşmadığını bir değişken belirleyek değerinden anlayabiliriz.
        long kontrol=db.insert(TABLO_NAME,null,cv);
        db.close();
        return kontrol;
    }

    public long RandevuOlustur(Randevu rndv)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(ROW_RANDEVUTC,rndv.getTC());
        cv.put(ROW_RANDEVUAD,rndv.getAd());
        cv.put(ROW_RANDEVUSOYAD,rndv.getSoyad());
        cv.put(ROW_RANDEVUTARIH,rndv.getTarih());
        cv.put(ROW_RANDEVUKLINIK,rndv.getKlinik());
        cv.put(ROW_RANDEVUDOKTOR,rndv.getDoktor());

        long randevukontrol=db.insert(TABLO4_NAME,null,cv);
        db.close();
        return randevukontrol;
    }

    public Cursor RandevuListele()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery(" SELECT * FROM " +TABLO4_NAME,null);
        return res;
    }

    public Integer RandevuSil(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLO4_NAME," randevuid=? ",new  String[] {id});
    }

    public Integer HastaRandevuSil(String randevuid)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLO4_NAME," randevuid=? ",new  String[] {randevuid});
    }

    public boolean RandevuGuncelle(String id,String tc, String ad, String soyad, String tarih,String klinik,String doktor)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ROW_RANDEVUID,id);
        contentValues.put(ROW_RANDEVUTC,tc);
        contentValues.put(ROW_RANDEVUAD,ad);
        contentValues.put(ROW_RANDEVUSOYAD,soyad);
        contentValues.put(ROW_RANDEVUTARIH, tarih);
        contentValues.put(ROW_RANDEVUKLINIK,klinik);
        contentValues.put(ROW_RANDEVUDOKTOR, doktor);
        db.update(TABLO4_NAME, contentValues, "randevuid=?", new String[] { id });
        return true;
    }



    public long HastaKayitEkle(hastaBilgiler hb)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(ROW_HASTAAD,hb.getHastaAd());
        cv.put(ROW_HASTASOYAD,hb.getHastaSoyad());
        cv.put(ROW_HASTATC,hb.getHastaTC());
        cv.put(ROW_HASTASIFRE,hb.getHastaSifre());

        long hastakontrol=db.insert(TABLO3_NAME,null,cv);
        db.close();
        return hastakontrol;
    }

    public long SekreterKayitEkle(SekreterBilgiler sb)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(SUTUN_AD,sb.getSekreterAd());
        contentValues.put(SUTUN_SOYAD,sb.getSekreterSoyad());
        contentValues.put(SUTUN_KULLANICIADI,sb.getSekreterKullaniciAdi());
        contentValues.put(SUTUN_SIFRE,sb.getSekreterSifre());

        long sekreterkontrol=db.insert(TABLO2_NAME,null,contentValues);
        db.close();
        return sekreterkontrol;
    }

}

