package com.cgrdev.petagram.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cgrdev.petagram.R;
import com.cgrdev.petagram.pojo.RatedPicture;

import java.util.ArrayList;

public class MiMascotaAdapter extends RecyclerView.Adapter<MiMascotaAdapter.MiMascotaViewHolder>  {

    ArrayList<RatedPicture> ratedPictures;

    public MiMascotaAdapter () {
        this.ratedPictures = new ArrayList<>();
    }

    public MiMascotaAdapter (ArrayList<RatedPicture> ratedPictures){
        this.ratedPictures = ratedPictures;
    }

    @NonNull
    @Override
    public MiMascotaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_mimascota, viewGroup, false);

        return new MiMascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MiMascotaViewHolder miMascotaViewHolder, int i) {

        RatedPicture ratedPicture = ratedPictures.get(i);

        miMascotaViewHolder.imgMascota.setImageResource(ratedPicture.getPictureId());
        miMascotaViewHolder.tvRating.setText(String.valueOf(ratedPicture.getRate()));
    }

    @Override
    public int getItemCount() {
        if (ratedPictures == null) return 0;
        return ratedPictures.size();
    }

    public class MiMascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota;
        private TextView tvRating;

        public MiMascotaViewHolder(@NonNull View v) {
            super(v);

            imgMascota = v.findViewById(R.id.imgMiMascota);
            tvRating = v.findViewById(R.id.tvMiMascotaRating);
        }
    }
}
