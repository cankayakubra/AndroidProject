package com.projesi.telefon.odev.ClassYapilari;



public class KatalogClass {
    String ad;
    String aciklama;
    String resim;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    public KatalogClass(String ad, String aciklama, String resim) {

        this.ad = ad;
        this.aciklama = aciklama;
        this.resim = resim;
    }
}
