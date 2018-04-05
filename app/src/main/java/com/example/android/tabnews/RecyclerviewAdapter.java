package com.example.android.tabnews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;



public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {
    public ItemClicked itemClicked;
    private Context context;
    private List<Data> mdata = new ArrayList<>();

    public RecyclerviewAdapter(Context context, List<Data> mdata, ItemClicked itemClicked) {
        this.context = context;
        this.mdata = mdata;
        this.itemClicked = itemClicked;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.title.setText(mdata.get(position).getTitle());
        holder.time.setText(mdata.get(position).getTime());
        holder.source.setText(mdata.get(position).getSource());
        Glide.with(context).load(mdata.get(position).getImage()).into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClicked.clickListener(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView source;
        private TextView time;
        private ImageView img;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_view);
            time = itemView.findViewById(R.id.time_view);
            source = itemView.findViewById(R.id.source_view);
            img = itemView.findViewById(R.id.image_view);
        }
    }
}
