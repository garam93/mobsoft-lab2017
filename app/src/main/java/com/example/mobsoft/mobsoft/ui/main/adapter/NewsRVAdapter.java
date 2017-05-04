package com.example.mobsoft.mobsoft.ui.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobsoft.mobsoft.R;
import com.example.mobsoft.mobsoft.model.News;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Gabtop on 2017.05.04..
 */

public class NewsRVAdapter extends RecyclerView.Adapter<NewsRVAdapter.NewsViewHolder> {

    private List<News> newsList;
    private CardClickListener listener;
    private Context context;

    public NewsRVAdapter(List<News> list, CardClickListener listener, Context context){
        this.newsList = list;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public NewsRVAdapter.NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_main, parent, false);
        return new NewsViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(NewsRVAdapter.NewsViewHolder holder, int position) {
        News news = newsList.get(position);

        holder.titleTV.setText(news.getTitle());
        holder.authorTV.setText(news.getAuthor());
        holder.dateTV.setText(news.getDate());
        Picasso.with(context).load(news.getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardClickListener listener;

        @BindView(R.id.cardImageView)
        ImageView imageView;

        @BindView(R.id.cardViewText)
        TextView titleTV;

        @BindView(R.id.cardViewAuthor)
        TextView authorTV;

        @BindView(R.id.cardViewDate)
        TextView dateTV;

        public NewsViewHolder(View itemView, CardClickListener listener){
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v);
        }
    }
}
