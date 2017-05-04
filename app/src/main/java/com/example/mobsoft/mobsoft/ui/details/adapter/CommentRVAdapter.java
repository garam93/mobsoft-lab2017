package com.example.mobsoft.mobsoft.ui.details.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobsoft.mobsoft.R;
import com.example.mobsoft.mobsoft.model.Comment;
import com.example.mobsoft.mobsoft.model.News;
import com.example.mobsoft.mobsoft.ui.main.adapter.CardClickListener;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Gabtop on 2017.05.04..
 */

public class CommentRVAdapter extends RecyclerView.Adapter<CommentRVAdapter.CommentViewHolder> {

    private List<Comment> commentList;
    private CommentClickListener listener;
    private Context context;

    public CommentRVAdapter(List<Comment> list, CommentClickListener listener, Context context){
        this.commentList = list;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public CommentRVAdapter.CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_comment, parent, false);
        return new CommentRVAdapter.CommentViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        Comment c = commentList.get(position);

        holder.commentTV.setText(c.getBody());
        //holder.authorTV.setText(c.getUserName());



        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateStr = dt.format(c.getCreationDate());
        holder.dateTV.setText(dateStr);
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    public static class CommentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CommentClickListener listener;

        @BindView(R.id.commentText)
        TextView commentTV;

        @BindView(R.id.commentAuthor)
        TextView authorTV;

        @BindView(R.id.commentDate)
        TextView dateTV;

        public CommentViewHolder(View itemView, CommentClickListener listener){
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