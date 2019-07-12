package com.example.travelbag.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelbag.Model.Place;
import com.example.travelbag.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceHolder>{
    private List<Place> listPlace = new ArrayList<>();

    public PlaceAdapter(List<Place> listPlace) {
        this.listPlace = listPlace;
    }

    private onPlaceClickListener listener;
    public interface onPlaceClickListener{
        void onClick(View view, int position);
    }

    public void setListener(onPlaceClickListener listener){
        this.listener  = listener;
    }

    @NonNull
    @Override
    public PlaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vh = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_city, parent, false);
        PlaceHolder holder = new PlaceHolder(vh);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceHolder holder, int position) {
        Place item =  listPlace.get(position);
        holder.tvPlace.setText(item.getCityName());
        Picasso.get().load(item.getCityImage())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.ivPlace);
    }

    @Override
    public int getItemCount() {
        return listPlace.size();
    }


    public class PlaceHolder extends RecyclerView.ViewHolder {

        public ImageView ivPlace;
        public TextView tvPlace;
        public PlaceHolder(@NonNull View itemView) {
            super(itemView);
            ivPlace = itemView.findViewById(R.id.img_place);
            tvPlace = itemView.findViewById(R.id.tv_place);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    listener.onClick(v, getAdapterPosition());
                }
            });
        }
    }
}
