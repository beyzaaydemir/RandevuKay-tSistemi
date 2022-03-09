package com.example.asus.myapplication;

public class hastaBilgiler {
    private String hastaAd;
    private String hastaSoyad;
    private String hastaTC;
    private String hastaSifre;

    public hastaBilgiler()
    {

    }

    public hastaBilgiler(String hastaad, String hastasoyad, String hastatc, String hastasifre)
    {
        setHastaAd(hastaad);
        setHastaSoyad(hastasoyad);
        setHastaTC(hastatc);
        setHastaSifre(hastasifre);
    }

    public void setHastaAd(String hastaAd) {
        this.hastaAd = hastaAd;
    }

    public String getHastaAd() {
        return hastaAd;
    }

    public void setHastaSoyad(String hastaSoyad) {
        this.hastaSoyad = hastaSoyad;
    }

    public String getHastaSoyad() {
        return hastaSoyad;
    }

    public void setHastaTC(String hastaTC) {
        this.hastaTC = hastaTC;
    }

    public String getHastaTC() {
        return hastaTC;
    }

    public void setHastaSifre(String hastaSifre) {
        this.hastaSifre = hastaSifre;
    }

    public String getHastaSifre() {
        return hastaSifre;
    }
}
