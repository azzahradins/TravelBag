package com.example.travelbag.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelbag.Model.Destination;
import com.example.travelbag.Model.Place;
import com.example.travelbag.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DestinationAdapter extends RecyclerView.Adapter<DestinationAdapter.Holder>{
    private List<Destination> destinationList = new ArrayList<>();

    public DestinationAdapter(List<Destination> destinationList) {
        this.destinationList = destinationList;
    }

    private onDestinationClickListener listener;
    public interface onDestinationClickListener{
        void onClick(View view, int position);
    }

    public void setListener(onDestinationClickListener listener){
        this.listener  = listener;
    }

    @NonNull
    @Override
    public DestinationAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vh = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_destination, parent, false);
        DestinationAdapter.Holder viewer = new DestinationAdapter.Holder(vh);
        return viewer;
    }

    @Override
    public void onBindViewHolder(@NonNull DestinationAdapter.Holder holder, int position) {
        Destination item =  destinationList.get(position);
        holder.tvName.setText(item.getPlaceName());
        holder.tvLocation.setText(item.getPlaceLocation());
    }

    @Override
    public int getItemCount() {
        return destinationList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        public TextView tvName, tvLocation;

        public Holder(@NonNull final View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.destination_name);
            tvLocation = itemView.findViewById(R.id.location);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(view, getAdapterPosition());
                }
            });
        }
    }
}
