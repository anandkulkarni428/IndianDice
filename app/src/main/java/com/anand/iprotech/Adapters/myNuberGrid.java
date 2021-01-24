package com.anand.iprotech.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.anand.iprotech.Actvities.TambolaActivity;
import com.anand.iprotech.R;

import java.util.ArrayList;
import java.util.List;

public class myNuberGrid extends RecyclerView.Adapter<myNuberGrid.ViewHolder> {

    Context context;
    List<Integer>  numList;
    List<Integer> randNumlist;
    int currentPosition = 0;
    Animation animation;

    public myNuberGrid(Context context,List<Integer> randNumlist) {
        this.context = context;
        this.randNumlist = randNumlist;
        numList = new ArrayList<>();

        animation = AnimationUtils.loadAnimation(context.getApplicationContext(),
                R.anim.down_to_up);
    }

    @NonNull
    @Override
    public myNuberGrid.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.rec_rand_num,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myNuberGrid.ViewHolder holder, int position) {

        currentPosition = position;

        for(int i=1;i<91;i++){
            numList.add(i);
        }

        holder.recNotxt.setText((numList.get(position).toString()));




            if (randNumlist.contains(currentPosition +1)){

            holder.recNotxt.setBackground(ResourcesCompat.getDrawable(context.getResources(),R.drawable.text_background,null));
//            holder.recNotxt.startAnimation(animation);
        }else {
            holder.recNotxt.setBackground(ResourcesCompat.getDrawable(context.getResources(),R.drawable.text_background2,null));

        }
            if ( randNumlist.size() == numList.size()){
                TambolaActivity.userRegbtn.setClickable(false);
                TambolaActivity.userRegbtn.setText("Completed");
            }


        if (TambolaActivity.userRegbtn.getText().toString().equals("Completed")) {

            TambolaActivity.resetImg.startAnimation(TambolaActivity.blinkAnimation);


        }


            if ((randNumlist.size() > 0)){
                TambolaActivity.resetImg.setVisibility(View.VISIBLE);
            }



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
