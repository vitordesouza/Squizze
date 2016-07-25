package com.catorze.squizze.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.catorze.squizze.R;

/**
 * Created by alexandre on 24/07/16.
 */
public class CategoryRecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView countryName;
    public ImageView countryPhoto;

    public CategoryRecyclerViewHolder(View itemView) {
        super(itemView);
        countryName = (TextView) itemView.findViewById(R.id.country_name);
        countryPhoto = (ImageView) itemView.findViewById(R.id.country_photo);
    }
}
