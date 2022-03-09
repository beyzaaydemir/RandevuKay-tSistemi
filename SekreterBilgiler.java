package com.example.asus.myapplication;

public class SekreterBilgiler {
    private String sekreterAd;
    private String sekreterSoyad;
    private String sekreterKullaniciAdi;
    private String sekreterSifre;

    public SekreterBilgiler()
    {

    }

    public SekreterBilgiler(String sekreterad, String sekretersoyad, String sekreterkullaniciadi, String sekretersifre)
    {
        setsekreterAd(sekreterad);
        setsekreterSoyad(sekretersoyad);
        setsekreterKullaniciAdi(sekreterkullaniciadi);
        setsekreterSifre(sekretersifre);
    }

    public void setsekreterAd(String sekreterAd) {
        this.sekreterAd = sekreterAd;
    }
    public String getSekreterAd() {
        return sekreterAd;
    }

    public void setsekreterSoyad(String sekreterSoyad) {
        this.sekreterSoyad = sekreterSoyad;
    }
    public String getSekreterSoyad() {
        return sekreterSoyad;
    }

    public void setsekreterKullaniciAdi(String sekreterKullaniciAdi) {
        this.sekreterKullaniciAdi = sekreterKullaniciAdi;
    }

    public String getSekreterKullaniciAdi() {
        return sekreterKullaniciAdi;
    }

    public void setsekreterSifre(String sekreterSifre) {
        this.sekreterSifre = sekreterSifre;
    }

    public String getSekreterSifre() {
        return sekreterSifre;
    }
}
