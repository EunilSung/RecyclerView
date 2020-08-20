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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    ArrayList<HashMap<String, Object>> item;

    public RecyclerViewAdapter(ArrayList<HashMap<String, Object>> item){
        this.item = item;
    }

    public interface OnItemClickListener
    {
        void onItemClick(View v, int pos);
    }

    public interface OnItemLongClickListener
    {
        void onItemLongClick(View v, int pos);
    }

    // 리스너 객체 참조를 저장하는 변수
    private OnItemClickListener mListener = null;
    private OnItemLongClickListener mLongListener = null;

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        this.mListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener)
    {
        this.mLongListener = listener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.activity_main, parent, false);
        return new RecyclerViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.RecyclerViewHolder holder, int position) {

        holder.setItem(item.get(position));

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name, price, store;

        public RecyclerViewHolder(final View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            store = itemView.findViewById(R.id.store);
            //일반 클릭
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION)
                    {
                        mListener.onItemClick(v, pos);
                    }
                    String mes;
                    mes = getAdapterPosition() + "th Item = " + name.getText();
                    Toast.makeText(v.getContext(), mes, Toast.LENGTH_SHORT).show();
                }
            });
            //롱 클릭
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION)
                    {
                        mLongListener.onItemLongClick(v, pos);
                    }
                    return true;
                }
            });

        }

        public void setItem(HashMap<String, Object> result) {
            img.setImageResource((Integer) result.get("img"));
            name.setText((String) result.get("name"));
            price.setText((String) result.get("price"));
            store.setText((String) result.get("store"));
        }
    }
}