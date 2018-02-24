package com.projesi.telefon.odev.ClassYapilari;



public class KullaniciClass {
    String adsoy;
    String email;
    String resim;

    public String getAdsoy() {
        return adsoy;
    }

    public void setAdsoy(String adsoy) {
        this.adsoy = adsoy;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    public KullaniciClass(String adsoy, String email, String resim) {

        this.adsoy = adsoy;
        this.email = email;
        this.resim = resim;
    }
}
