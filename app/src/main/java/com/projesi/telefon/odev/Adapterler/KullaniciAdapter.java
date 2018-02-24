package com.projesi.telefon.odev.Adapterler;



import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.projesi.telefon.odev.ClassYapilari.KatalogClass;
import com.projesi.telefon.odev.ClassYapilari.KullaniciClass;
import com.projesi.telefon.odev.GenelKutuphane;
import com.projesi.telefon.odev.R;

import java.util.ArrayList;

public class KullaniciAdapter extends BaseAdapter {

    ArrayList<KullaniciClass> coinClasses = new ArrayList<>();
    Activity activity;
    LayoutInflater layoutInflater;
    GenelKutuphane generalLibrary;

    public KullaniciAdapter(ArrayList<KullaniciClass> coinClasses, Activity activity) {
        this.coinClasses = coinClasses;
        this.activity = activity;
        layoutInflater = LayoutInflater.from(activity);
        generalLibrary = new GenelKutuphane(activity);
    }

    @Override
    public int getCount() {
        return coinClasses.size();
    }

    @Override
    public KullaniciClass getItem(int i) {
        return coinClasses.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = layoutInflater.inflate(R.layout.coin_row_mainmenu, null);


        ImageView coin_image = (ImageView) v.findViewById(R.id.urun_resim);

        TextView coin_vol = (TextView) v.findViewById(R.id.urun_adi);
        TextView coin_usd = (TextView) v.findViewById(R.id.urun_ack);


        coin_vol.setText(getItem(i).getAdsoy());
        coin_usd.setText("Email: " + getItem(i).getEmail());


        generalLibrary.ImageNET(coin_image, "http://ekoldekore.com/uploads/"+getItem(i).getResim());



        return v;
    }
}

