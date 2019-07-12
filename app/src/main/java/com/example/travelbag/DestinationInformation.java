package com.example.travelbag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DestinationInformation extends AppCompatActivity {
    TextView nama, lokasi, deskripsi, hargaNormal, hargaLiburan;
    ImageView gambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_information);
        gambar = findViewById(R.id.iv_gambar);
        nama = findViewById(R.id.tv_judul);
        lokasi = findViewById(R.id.location);
        deskripsi = findViewById(R.id.desc);
        hargaNormal = findViewById(R.id.price);
        hargaLiburan = findViewById(R.id.priceHoliday);
        //i.putExtra(Key_Detail, new String[]{nama, lokasi, desc, pNormal, pHoliday, image});
        String[] details = getIntent().getStringArrayExtra("Detail");
        assert details != null;
        Picasso.get().load(details[5]).into(gambar);
        nama.setText(details[0]);
        lokasi.setText(details[1]);
        deskripsi.setText(details[2]);
        hargaNormal.setText(details[3]);
        hargaLiburan.setText(details[4]);
    }
}
