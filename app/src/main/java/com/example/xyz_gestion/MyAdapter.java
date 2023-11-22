package com.example.xyz_gestion;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<DataClase> dataList;

    public MyAdapter(Context context, List<DataClase> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(dataList.get(position).getDataImage()).into(holder.recImage);
        holder.rectitulo.setText(dataList.get(position).getDataTitulo());
        holder.receditorial.setText(dataList.get(position).getDataEditorial());
        holder.recidioma.setText(dataList.get(position).getDataIdioma());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Detalle.class);
                intent.putExtra("dataImage", dataList.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("dataTitulo", dataList.get(holder.getAdapterPosition()).getDataTitulo());
                intent.putExtra("dataEditorial", dataList.get(holder.getAdapterPosition()).getDataEditorial());
                intent.putExtra("Key",dataList.get(holder.getAdapterPosition()).getKey());
                intent.putExtra("dataIdioma", dataList.get(holder.getAdapterPosition()).getDataIdioma());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void searchDataList(ArrayList<DataClase> searchList){
        dataList = searchList;
        notifyDataSetChanged();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView recImage;
    TextView rectitulo, recidioma, receditorial;
    CardView recCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        recImage = itemView.findViewById(R.id.recImage);
        recCard = itemView.findViewById(R.id.recCard);
        rectitulo = itemView.findViewById(R.id.rec_titulo);
        receditorial = itemView.findViewById(R.id.rec_editorial);
        recidioma = itemView.findViewById(R.id.rec_idioma);
    }
}