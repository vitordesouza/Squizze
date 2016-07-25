package com.catorze.squizze.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.catorze.squizze.R;
import com.catorze.squizze.domain.Category;
import com.catorze.squizze.view.activities.QuizMenuActivity;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by alexandre on 24/07/16.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryRecyclerViewHolder> {

    private List<Category> itemList;
    private Context context;

    public CategoryAdapter(Context context, List<Category> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public CategoryRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, null);
        CategoryRecyclerViewHolder rcv = new CategoryRecyclerViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(CategoryRecyclerViewHolder holder, int position) {
        final Category category = itemList.get(position);
        holder.countryName.setText(category.getName());
        Glide.with(context)
                .load(category.getThumbnail())
                .into(holder.countryPhoto);

        holder.countryPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callQuizzesActivity(category);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }


    public void callQuizzesActivity(Category category) {
        Intent i = new Intent(context, QuizMenuActivity.class);
        i.putExtra(QuizMenuActivity.EXTRA_CATEGORY_JSON, new Gson().toJson(category));
        context.startActivity(i);
    }
}
