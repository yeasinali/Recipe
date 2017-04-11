package com.food.recipe.recipe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.food.recipe.recipe.R;
import com.food.recipe.recipe.model.Recipe_model;
import com.food.recipe.recipe.view.MainActivity;

import java.util.List;

public class StaggeredGridViewAdapter extends RecyclerView.Adapter<StaggeredGridViewAdapter.StaggeredGridViewHolder> {

    private List<Recipe_model> itemList;
    private Context context;
    private ClickListener mClickListener;

    public StaggeredGridViewAdapter(Context context, List<Recipe_model> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public StaggeredGridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(context).inflate(R.layout.layout_grid_item,parent,false);
        StaggeredGridViewHolder gridViewHolder = new StaggeredGridViewHolder(layout,mClickListener);
        return gridViewHolder;
    }

    @Override
    public void onBindViewHolder(StaggeredGridViewHolder holder, int position) {
        holder.countryName.setText(itemList.get(position).getName());
        holder.mImageView.setImageResource(itemList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public static interface ClickListener {
        void onClickItem(StaggeredGridViewHolder holder);
    }

    public class StaggeredGridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView countryName;
        public ImageView mImageView;

        public StaggeredGridViewAdapter.ClickListener mClickListener;

        public StaggeredGridViewHolder(View view, StaggeredGridViewAdapter.ClickListener listener) {
            super(view);
            view.setOnClickListener(this);
            countryName = (TextView) view.findViewById(R.id.countryName);
            mImageView = (ImageView) view.findViewById(R.id.imageView);
            mClickListener = listener;
        }

        @Override
        public void onClick(View item) {
            mClickListener.onClickItem(this);
        }


    }
}
