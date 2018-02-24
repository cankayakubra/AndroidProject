package com.projesi.telefon.odev.ClassYapilari;



public class UrunClass {
    String fiyat;
    String isim;
    String resimlink;
    String aciklama;

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getResimlink() {
        return resimlink;
    }

    public void setResimlink(String resimlink) {
        this.resimlink = resimlink;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public UrunClass(String fiyat, String isim, String resimlink, String aciklama) {

        this.fiyat = fiyat;
        this.isim = isim;
        this.resimlink = resimlink;
        this.aciklama = aciklama;
    }
}
