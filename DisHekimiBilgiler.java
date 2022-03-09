package com.example.asus.myapplication;

public class DisHekimiBilgiler {

    private String Ad;
    private String Soyad;
    private String KullaniciAdi;
    private String Sifre;
    private String Klinik;

    public DisHekimiBilgiler()
    {

    }

    public DisHekimiBilgiler(String ad, String soyad, String kullaniciadi, String sifre, String klinik)
    {
        setAd(ad);
        setSoyad(soyad);
        setKullaniciAdi(kullaniciadi);
        setSifre(sifre);
        setKlinik(klinik);

    }
    public void setAd(String ad){Ad=ad;}

    public String getAd() {
        return Ad;
    }

    public void setSoyad(String soyad) {
        Soyad = soyad;
    }

    public String getSoyad() {
        return Soyad;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        KullaniciAdi = kullaniciAdi;
    }

    public String getKullaniciAdi() {
        return KullaniciAdi;
    }

    public void setSifre(String sifre) {
        Sifre = sifre;
    }

    public String getSifre() {
        return Sifre;
    }

    public void setKlinik(String klinik) {
        Klinik = klinik;
    }

    public String getKlinik() {
        return Klinik;
    }
}
