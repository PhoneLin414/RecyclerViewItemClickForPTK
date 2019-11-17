package com.example.recyclerviewonitemqtyclick;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;
    List<Data> dataList;
    OnItemClick onItemClick;

    public RecyclerAdapter(Context context, List<Data> dataList,OnItemClick onItemClick) {

        this.context = context;
        this.dataList = dataList;
        this.onItemClick = onItemClick;

    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_view,null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerAdapter.ViewHolder holder, int position) {

        holder.txtQty.setText(dataList.get(position).qty+"");

        holder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.txtQty.setText(Integer.parseInt(holder.txtQty.getText().toString()) + 1 +"");
                onItemClick.btnPlusClick(holder.txtQty.getText().toString());
            }
        });


        holder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.txtQty.setText(Integer.parseInt(holder.txtQty.getText().toString()) - 1 + "");
                onItemClick.btnMinusClick(holder.txtQty.getText().toString());
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtQty;
        Button btnPlus;
        Button btnMinus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

             txtQty   = itemView.findViewById(R.id.txtQty);
             btnPlus = itemView.findViewById(R.id.btnPlus);
             btnMinus = itemView.findViewById(R.id.btnMinus);

        }

    }
}
