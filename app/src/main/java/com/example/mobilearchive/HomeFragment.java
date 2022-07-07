package com.example.mobilearchive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mobilearchive.controllers.NavigationFragment;
import com.example.mobilearchive.controllers.ProjetRecycleAdapter;
import com.example.mobilearchive.models.Projet;
import com.example.mobilearchive.models.StoreData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class HomeFragment extends Fragment implements ProjetRecycleAdapter.gotoDetails{
    private ArrayList<Projet> projetArrayList;
    public RecyclerView recyclerView;
    private SearchView searchView;
    public ProjetRecycleAdapter adapter;
    private Toolbar toolbar;
    private String url;
    private NavigationFragment navigationFragment;
    private RequestQueue queue;
    private String toolbar_name;

     public HomeFragment(NavigationFragment navigationFragment, String toolbar_name, String url) {
         this.navigationFragment = navigationFragment;
         this.toolbar_name = toolbar_name;
         this.url= url;
     }

     public HomeFragment(NavigationFragment navigationFragment) {
         this.navigationFragment = navigationFragment;
     }

     @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home,container,false);
        this.queue= Volley.newRequestQueue(this.getContext());
        projetArrayList= new ArrayList<>();
        toolbar= view.findViewById(R.id.top_toolbar);
        if (this.toolbar_name==null){
            toolbar.setTitle("Home");
        }else {
            toolbar.setTitle(this.toolbar_name);
        }
        recyclerView= view.findViewById(R.id.homelist);
        searchView= view.findViewById(R.id.homesearch);
        getAllRemoteProjet();
        return view;
    }

     @Override
     public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
         super.onViewCreated(view, savedInstanceState);
         openNavigation();
         searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
             @Override
             public boolean onQueryTextSubmit(String query) {
                 return false;
             }

             @Override
             public boolean onQueryTextChange(String newText) {
                 adapter.getFilter().filter(newText);
                 return false;
             }
         });
     }

     private void openNavigation() {
         toolbar.setNavigationOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                     navigationFragment.openLeftNavigation();
             }
         });
     }

     private void getAllRemoteProjet() {
        if (url==null){
            url="http://192.168.43.137:8000/api/projet";
            getAllProjet(url,queue);
        }
    }

    private void setAdapter(ArrayList<Projet> projets) {
        adapter= new ProjetRecycleAdapter(getContext(),projetArrayList,this::go);
        RecyclerView.LayoutManager manager= new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

     @Override
     public void go(Projet projet) {
        StoreData.projetItem =projet;
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer,new ProjetDetailsFragment(navigationFragment))
                .addToBackStack(null)
                .commit();
     }

     public void getAllProjet(String url , RequestQueue queue){
         StringRequest request;
         request = new StringRequest(Request.Method.GET, url,new Response.Listener<String>() {
             @Override
             public void onResponse(String response) {
                 Gson jsonProjet= new Gson();
                 Type projetList= new TypeToken<ArrayList<Projet>>(){}.getType();
                 projetArrayList.addAll(jsonProjet.fromJson(response,projetList));
                 setAdapter(projetArrayList);
             }
         }, new Response.ErrorListener() {
             @Override
             public void onErrorResponse(VolleyError error) {

             }
         });
         queue.add(request);
     }
 }