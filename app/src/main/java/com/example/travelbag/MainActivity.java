package com.example.travelbag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.travelbag.Adapter.PlaceAdapter;
import com.example.travelbag.Model.Place;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PlaceAdapter.onPlaceClickListener{
    public RecyclerView rv;
    public PlaceAdapter placeAdapter;
    public RecyclerView.LayoutManager layoutManager;
    public List<Place> listPlace = new ArrayList<>();
    public static final String Key_DestinationActivity = "DestinationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rvPlace);

        listPlace.add(new Place("https://www.internasia.com/sites/default/files/news/jakarta_news_image.jpg","Jakarta"));
        listPlace.add(new Place("https://blog.airpaz.com/wp-content/uploads/istana-bogor-1021x563.jpg","Bogor"));
        listPlace.add(new Place("https://www.dw.com/image/44565755_303.jpg","Bandung"));

        placeAdapter = new PlaceAdapter(listPlace);
        placeAdapter.setListener(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setAdapter(placeAdapter);
        rv.setLayoutManager(layoutManager);
    }

    @Override
    public void onClick(View view, int position) {
        Place place = listPlace.get(position);
        Intent i = new Intent(MainActivity.this, DestinationActivity.class);
        String nama = place.getCityName();
        i.putExtra(Key_DestinationActivity, nama);
        Log.d("nama_kota", "ini kota " + nama);
        startActivity(i);
    }
}
