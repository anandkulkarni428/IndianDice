package com.anand.iprotech.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anand.iprotech.R;

import java.util.ArrayList;
import java.util.List;

public class myNuberDumyGrid extends RecyclerView.Adapter<myNuberDumyGrid.ViewHolder> {

    Context context;
    List<Integer> numList;

    public myNuberDumyGrid(Context context) {
        this.context = context;
        numList = new ArrayList<>();
    }

    @NonNull
    @Override
    public myNuberDumyGrid.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.rec_rand_num,null);
        return new myNuberDumyGrid.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myNuberDumyGrid.ViewHolder holder, int position) {

        for(int i=1;i<91;i++){
            numList.add(i);
        }

        holder.recNotxt.setText((numList.get(position).toString()));
    }

    @Override
    public int getItemCount() {
        return 90;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView recNotxt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recNotxt = itemView.findViewById(R.id.num_txt);
        }
    }
}
