package com.example.recyclerview;

import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    ArrayList<HashMap<String, Object>> item;

    public interface OnItemClickListener {
        void onItemClick();
    }

    private OnItemClickListener listener = null;

    public RecyclerViewAdapter(ArrayList<HashMap<String, Object>> item) {
        this.item = item;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.activity_main,parent,false);
        return new MyViewHolder(itemView);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {

        holder.setItem(item.get(position));

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name, price, store;

        public MyViewHolder(final View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            store = itemView.findViewById(R.id.store);

            itemView.setOnClickListener(new View.OnClickListener(){ @Override
            public void onClick(View v) {
                String mes;
                mes = getAdapterPosition() + "th Item = " + name.getText();
                Toast.makeText(v.getContext(), mes, Toast.LENGTH_SHORT).show(); }
            });

        }
        public void setItem(HashMap<String, Object> result) {
            img.setImageResource((Integer) result.get("img"));
            name.setText((String)result.get("name"));
            price.setText((String)result.get("price"));
            store.setText((String)result.get("store"));
        }
    }
}