package com.example.mobilearchive.http;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.mobilearchive.models.Projet;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Get {
    public static ArrayList<Projet> getAllProjet(String url , RequestQueue queue,ArrayList<Projet> projetArrayList){
        StringRequest request;
        final ArrayList<Projet> responseProjets = new ArrayList<>();
        request = new StringRequest(Request.Method.GET, url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson jsonProjet= new Gson();
                Type projetList= new TypeToken<ArrayList<Projet>>(){}.getType();
                projetArrayList.addAll(jsonProjet.fromJson(response,projetList));
                responseProjets.addAll(projetArrayList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
        return responseProjets;
    }
}
