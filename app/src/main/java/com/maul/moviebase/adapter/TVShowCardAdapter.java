package com.maul.moviebase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.maul.moviebase.R;
import com.maul.moviebase.modal.TVShow;


import java.util.ArrayList;

public class TVShowCardAdapter extends RecyclerView.Adapter<TVShowCardAdapter.ViewHolder> {

    private ArrayList<TVShow> data = new ArrayList<>();

    public TVShowCardAdapter(Context context) {
    }

    public void setData(ArrayList<TVShow> item){
        data.clear();
        data.addAll(item);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int i) {
        TVShow tvs = data.get(i);

        holder.title.setText(tvs.getOriginalName());
        Glide.with(holder.itemView.getContext())
                .load(tvs.getPosterPath())
                .apply(new RequestOptions().override(202, 253))
                .into(holder.poster);
        holder.released.setText(tvs.getFirstAirDate());
        holder.overview.setText(tvs.getOverview());
        holder.rating.setText(String.valueOf(tvs.getVoteAverage()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title, released, overview, rating;
        private ImageView poster;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tv_title);
            overview = itemView.findViewById(R.id.tv_description);
            released = itemView.findViewById(R.id.tv_released);
            rating = itemView.findViewById(R.id.tv_rating);
            poster = itemView.findViewById(R.id.img_poster);
        }
    }
}