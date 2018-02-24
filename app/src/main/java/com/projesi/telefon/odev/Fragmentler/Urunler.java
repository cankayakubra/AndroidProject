package com.projesi.telefon.odev.Fragmentler;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Request;
import com.projesi.telefon.odev.Adapterler.UrunAdapter;
import com.projesi.telefon.odev.ClassYapilari.UrunClass;
import com.projesi.telefon.odev.DataInterface;
import com.projesi.telefon.odev.GenelKutuphane;
import com.projesi.telefon.odev.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Urunler extends Fragment {


    ListView lv_coinlist;
    GenelKutuphane generalLibrary;
    UrunAdapter adapterMainMenu;
    ArrayList<UrunClass> urunlers;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_urun, container, false);
        setupViews(v);
        setupLibraries();
        setupListview();
        return v;
    }


    void setupViews(View v) {

        lv_coinlist = (ListView)v.findViewById(R.id.lv_coinlist);

    }

    void setupLibraries() {

        generalLibrary = new GenelKutuphane(getActivity());

    }

    void setupListview() {

        String requestURL = "http://ekoldekore.com/urungetir.php";
        generalLibrary.GetData(requestURL, Request.Method.GET, new DataInterface() {
            @Override
            public void cevap(String response) {
                try {
                    urunlers = new ArrayList<>();
                    JSONArray coinJsonarray = new JSONArray(response);
                    JSONArray urunlerarra =(JSONArray) coinJsonarray.get(0);
                    for (int i = 0; i < urunlerarra.length(); i++) {
                        JSONObject coinJson = (JSONObject) urunlerarra.get(i);

                        urunlers.add(new UrunClass(
                                coinJson.getString("sfiyat").replace("null",""),
                                coinJson.getString("adi").replace("null",""),
                                coinJson.getString("resim").replace("null",""),
                                coinJson.getString("aciklama").replace("null","")
                        ));

                    }
                    Log.e("size: ", ""+urunlers.size());

                    adapterMainMenu = new UrunAdapter(urunlers, getActivity());
                    lv_coinlist.setAdapter(adapterMainMenu);

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
