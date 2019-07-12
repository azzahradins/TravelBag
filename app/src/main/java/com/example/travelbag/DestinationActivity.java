package com.example.travelbag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travelbag.Adapter.DestinationAdapter;
import com.example.travelbag.Adapter.PlaceAdapter;
import com.example.travelbag.Model.Destination;
import com.example.travelbag.Model.Place;

import java.util.ArrayList;
import java.util.List;

public class DestinationActivity extends AppCompatActivity implements DestinationAdapter.onDestinationClickListener{

    public RecyclerView rv;
    public DestinationAdapter desAdapter;
    public androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager;
    public List<Destination> listDestination = new ArrayList<>();
    public static final String Key_Detail = "Detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);
        TextView tvNamaKota = findViewById(R.id.nama_kota);
        rv = findViewById(R.id.rvDestination);

        String namaKota = getIntent().getStringExtra(MainActivity.Key_DestinationActivity);
        tvNamaKota.setText("Tujuan destinasi perjalanan di Kota " + namaKota);

        if(namaKota.equals("Jakarta")){
            listDestination.add(new Destination("Jakarta","Monas", "Jl. Merdeka Barat", "Monas adalah tugu yang berada di jakarta dengan ketinggian sebesar 120 meter, banyak pengunjung yang tertarik karena emas yang ada di atas tugu tersebut.",
                    "5.000", "10.000", "https://mmc.tirto.id/image/otf/500x0/2018/07/28/ilustrasi-monas-2_ratio-16x9.jpg"));
            listDestination.add(new Destination("Jakarta","Kota Tua", "Jl. Gajah Mada",
                    "Sejarah peninggalan pada masa Belanda, dengan rumah tua yang berdiri megah hingga sekarang. Kota tua merupakan musium yang dapat dikunjungi oleh umum",
                    "20.000", "30.000", "https://cdn0-production-images-kly.akamaized.net/XgamfyyODMAlfLWbLhLodplaWwA=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2775519/original/029916500_1554907722-20190408_144618.jpg"));
            listDestination.add(new Destination("Jakarta","Stasiun MRT", "Kebayoran",
                    "Stasiun kereta cepat yang baru beroperasi di jakarta pada tahun 2019.",
                    "10.000", "TIDAK TERSEDIA",
                    "https://cdn2.tstatic.net/tribunnews/foto/bank/images/melihat-uji-coba-publik-mrt-jakarta_20190312_170541.jpg"));
        }
        else if(namaKota.equals("Bogor")){
            listDestination.add(new Destination("Bogor","Kampung 3 Dimensi", "Jl. Persatuan Selatan", "Lokasi yang cocok untuk mengambil banyak foto. Instagramable.", "35.000", "50.000"
            ,"https://d3p0bla3numw14.cloudfront.net/news-content/img/2017/10/30145302/IMG_6434.jpg"));
            listDestination.add(new Destination("Bogor","Water Park",
                    "Perumahan Bogor Raya", "Merupakan taman bermain air yang dilengkapi dengan fasilias kolam yang bersih dan kamar mandi yang terawat.",
                    "125.000", "200.000", "https://dolanyok.com/wp-content/uploads/JungleLand-Adventure-Theme-Park-Sentul-3_630x405.jpg"));
            listDestination.add(new Destination("Bogor","Stasiun KRL", "Jl. Raya Bogor",
                    "Stasiun dengan tingkat kepadatan 100%, karena Bogor merupakan daerah redensial dari orang yang bekerja di Jakarta.",
                    "3.500", "TIDAK DIKETAHUI", "https://cdn2.tstatic.net/jakarta/foto/bank/images/commuter-line_20180312_120418.jpg"));
        }
        else if(namaKota.equals("Bandung")){
            listDestination.add(new Destination("Bandung","Taman Pintar", "Jl. Utama No 78",
                    "Perpustakaan kota dengan pilihan buku terlengkap dan pusat informasi untuk semua orang",
                    "GRATIS", "TUTUP", "https://www.anekawisata.com/wp-content/uploads/2018/11/Taman-Pintar-Yogyakarta.jpg"));
            listDestination.add(new Destination("Bandung","Factory Outlet", "Jl. Makmur Sejahtera",
                    "Merupakan kompleks yang dipenuhi dengan toko baju, mulai dari kualitas terbaik sampai kualitas biasa. Baju yang ditawarkan memiliki kisaran harga sekitar 120.000 sampai dengan 190.000." +
                            "Dilengkapi juga dengan kawasan kuliner disekitarnya dan pemandangan yang sangat indah dari atas gunung.",
                    "5.000","7.000","https://tempatwisatadibandung.info/wp-content/uploads/Factory-Outlet-Di-Bandung.jpg"));
        }

        desAdapter = new DestinationAdapter(listDestination);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        desAdapter.setListener(this);
        rv.setAdapter(desAdapter);
        rv.setLayoutManager(layoutManager);
    }

    @Override
    public void onClick(View view, int position) {
        Destination dest = listDestination.get(position);
        Intent i = new Intent(DestinationActivity.this, DestinationInformation.class);
        String image = dest.getImage();
        String nama = dest.getPlaceName();
        String lokasi = dest.getPlaceLocation();
        String desc = dest.getDescription();
        String pNormal = dest.getPriceNormal();
        String pHoliday = dest.getPriceHoliday();
        i.putExtra(Key_Detail, new String[]{nama, lokasi, desc, pNormal, pHoliday, image});
        startActivity(i);
    }
}
