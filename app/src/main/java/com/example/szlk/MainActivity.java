package com.example.szlk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private Toolbar toolbar;
    private RecyclerView rv;
    private ArrayList<Kelimeler> kelimelerListe;
    private KelimelerAdapter adapter;
    private KelimelerDaoInterface kelimelerDIF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        rv = findViewById(R.id.rv);

        toolbar.setTitle("Sözlük Uygulaması");
        setSupportActionBar(toolbar);

        kelimelerDIF = ApiUtils.getKelimelerDaoInterfeace();

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        tumKelimeler();

    }

    @Override //Arama çubuğu kodu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu,menu);

        MenuItem item = menu.findItem(R.id.action_ara);

        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);
    }

    @Override //Arama çubuğu kodu
    public boolean onQueryTextSubmit(String query) {
        Log.e("Gönderilen Arama",query);
        return false;
    }

    @Override //Arama çubuğu kodu
    public boolean onQueryTextChange(String newText) {
        Log.e("Harf Girdikçe",newText);
        tumKelimelerAra(newText);
        return false;
    }

    public void tumKelimeler() {
        kelimelerDIF.tumKelimelerDıf().enqueue(new Callback<KelimelerCevap>() {
            @Override
            public void onResponse(Call<KelimelerCevap> call, Response<KelimelerCevap> response) {

                List<Kelimeler> ListTemp = response.body().getKelimeler();

                adapter = new KelimelerAdapter(MainActivity.this,ListTemp);

                rv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<KelimelerCevap> call, Throwable t) {

            }
        });
    }

    public void tumKelimelerAra(String aramaKelime) {
        kelimelerDIF.kelimeAra(aramaKelime).enqueue(new Callback<KelimelerCevap>() {
            @Override
            public void onResponse(Call<KelimelerCevap> call, Response<KelimelerCevap> response) {

                List<Kelimeler> ListTemp = response.body().getKelimeler();

                adapter = new KelimelerAdapter(MainActivity.this,ListTemp);

                rv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<KelimelerCevap> call, Throwable t) {

            }
        });
    }
}