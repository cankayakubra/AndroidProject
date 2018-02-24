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
import com.projesi.telefon.odev.Adapterler.UrunAdapter;
import com.projesi.telefon.odev.ClassYapilari.KatalogClass;
import com.projesi.telefon.odev.ClassYapilari.UrunClass;
import com.projesi.telefon.odev.DataInterface;
import com.projesi.telefon.odev.GenelKutuphane;
import com.projesi.telefon.odev.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Kataloglar extends Fragment {

    public Kataloglar() {

    }

    ListView lv_kategori;
    GenelKutuphane generalLibrary;
    KatalogAdapter adapterMainMenu;
    ArrayList<KatalogClass> katalogClasses;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_kategori, container, false);
        setupViews(v);
        setupLibraries();
        setupListview();
        return v;
    }


    void setupViews(View v) {

        lv_kategori = (ListView)v.findViewById(R.id.lv_kategori);

    }

    void setupLibraries() {

        generalLibrary = new GenelKutuphane(getActivity());

    }

    void setupListview() {

        String requestURL = "http://ekoldekore.com/kategorigetir.php";
        generalLibrary.GetData(requestURL, Request.Method.GET, new DataInterface() {
            @Override
            public void cevap(String response) {
                try {
                    katalogClasses = new ArrayList<>();
                    JSONArray coinJsonarray = new JSONArray(response);
                    JSONArray urunlerarra =(JSONArray) coinJsonarray.get(0);
                    for (int i = 0; i < urunlerarra.length(); i++) {
                        JSONObject coinJson = (JSONObject) urunlerarra.get(i);

                        katalogClasses.add(new KatalogClass(
                                coinJson.getString("adi").replace("null",""),
                                coinJson.getString("description").replace("null",""),
                                coinJson.getString("resim").replace("null","")

                        ));

                    }
                    Log.e("size: ", ""+katalogClasses.size());

                    adapterMainMenu = new KatalogAdapter(katalogClasses, getActivity());
                    lv_kategori.setAdapter(adapterMainMenu);

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
