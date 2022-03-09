package com.example.asus.myapplication;

public class Randevu {

    private String TC;
    private String ad;
    private String soyad;
    private String tarih;
    private String klinik;
    private String doktor;


    public Randevu()
    {

    }

    public Randevu(String TC,String Ad,String Soyad,String tarih,String Klinik,String Doktor)
    {
        setTC(TC);
        setAd(Ad);
        setSoyad(Soyad);
        setTarih(tarih);
        setKlinik(Klinik);
        setDoktor(Doktor);



    }

    public void setTC(String TC) {
        this.TC = TC;
    }

    public String getTC() {
        return TC;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getAd() {
        return ad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getTarih() {
        return tarih;
    }

    public void setKlinik(String klinik) {
        this.klinik = klinik;
    }

    public String getKlinik() {
        return klinik;
    }

    public void setDoktor(String doktor) {
        this.doktor = doktor;
    }

    public String getDoktor() {
        return doktor;
    }




}
