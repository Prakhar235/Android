package com.pharm.smartprakhar.triviaapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.pharm.smartprakhar.triviaapp.R;
import com.pharm.smartprakhar.triviaapp.Controllers.Game;

import java.util.ArrayList;


public class Adapter_History extends RecyclerView.Adapter<Adapter_History.ViewHolder> {

    private ArrayList<Game> list_names;
    Context context;




    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView gamedetails0;
        private TextView gamedetails1;
        private TextView gamedetails2;
        private TextView gamedetails3;



        public ViewHolder(View itemView) {
            super(itemView);

            gamedetails0 =  itemView.findViewById(R.id.gamedetail0);
            gamedetails1 =  itemView.findViewById(R.id.gamedetail1);
            gamedetails2 =  itemView.findViewById(R.id.gamedetail2);
            gamedetails3 =  itemView.findViewById(R.id.gamedetail3);




        }
    }



    public Adapter_History(ArrayList<Game> list_names, Context context) {


        this.list_names = list_names;

        this.context = context;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_summary, parent, false);

        return new ViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        try
        {
            holder.gamedetails0.setText("GAME"+list_names.get(position).getGameid()+":"+list_names.get(position).getTimestamp());
            holder.gamedetails1.setText("Name:"+list_names.get(position).getName());
            holder.gamedetails2.setText(list_names.get(position).getBestcricketer());
            holder.gamedetails3.setText(list_names.get(position).getFlagcolors());


        }
        catch (Exception e)
        {

        }




    }

    @Override
    public int getItemCount() {
        return list_names.size() ;
    }


}
