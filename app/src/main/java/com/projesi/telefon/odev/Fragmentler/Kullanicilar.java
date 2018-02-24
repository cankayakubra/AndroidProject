package com.projesi.telefon.odev.Fragmentler;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Request;
import com.projesi.telefon.odev.Adapterler.KatalogAdapter;
import com.projesi.telefon.odev.Adapterler.KullaniciAdapter;
import com.projesi.telefon.odev.ClassYapilari.KatalogClass;
import com.projesi.telefon.odev.ClassYapilari.KullaniciClass;
import com.projesi.telefon.odev.DataInterface;
import com.projesi.telefon.odev.GenelKutuphane;
import com.projesi.telefon.odev.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class Kullanicilar extends Fragment {


    public Kullanicilar() {

    }

    ListView uyelistview;
    GenelKutuphane generalLibrary;
    KullaniciAdapter adapterMainMenu;
    ArrayList<KullaniciClass> kullaniciClasses;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_kullanici, container, false);
        setupViews(v);
        setupLibraries();
        setupListview();
        return v;
    }


    void setupViews(View v) {

        uyelistview = (ListView)v.findViewById(R.id.uyelistview);

    }

    void setupLibraries() {

        generalLibrary = new GenelKutuphane(getActivity());

    }

    void setupListview() {

        String requestURL = "http://ekoldekore.com/uyegetir.php";
        generalLibrary.GetData(requestURL, Request.Method.GET, new DataInterface() {
            @Override
            public void cevap(String response) {
                try {
                    kullaniciClasses = new ArrayList<>();
                    JSONArray coinJsonarray = new JSONArray(response);
                    JSONArray urunlerarra =(JSONArray) coinJsonarray.get(0);
                    for (int i = 0; i < urunlerarra.length(); i++) {
                        JSONObject coinJson = (JSONObject) urunlerarra.get(i);

                        kullaniciClasses.add(new KullaniciClass(
                                coinJson.getString("adsoy").replace("null",""),
                                coinJson.getString("email").replace("null",""),
                                coinJson.getString("resim").replace("null","")

                        ));

                    }
                    Log.e("size: ", ""+kullaniciClasses.size());

                    adapterMainMenu = new KullaniciAdapter(kullaniciClasses, getActivity());
                    uyelistview.setAdapter(adapterMainMenu);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void hata(String error) {

            }
        });
    }


}
