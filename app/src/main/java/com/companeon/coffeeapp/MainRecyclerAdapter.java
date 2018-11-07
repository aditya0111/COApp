package com.companeon.coffeeapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Aditya on 11/5/2018.
 */

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainRecyclerViewHolder> {

    private LayoutInflater inflater;
    ArrayList<String> bev_name,bev_price,image_locations;
    Context context;
    Bitmap bitmap;

    String TAG="Ajkdj";

    public MainRecyclerAdapter(LayoutInflater inflater,Context context) {
        this.inflater = inflater;
        this.context=context;
    }

/*    public NewsFeedAdapter(String name) {
        this.name=name;
    }*/

    public MainRecyclerAdapter(ArrayList<String> bev_name, ArrayList<String> bev_price ,ArrayList<String> image_locations) {
        this.bev_name=bev_name;
        this.bev_price=bev_price;
        this.image_locations=image_locations;
    }



    @Override
    public MainRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.coffee_recycler,parent,false);

        return new MainRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainRecyclerViewHolder holder, final int position) {
        holder.tet1.setText(bev_name.get(position));
        holder.tet2.setText("$"+bev_price.get(position));
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,bev_name.get(position)+"="+bev_price.get(position),Toast.LENGTH_LONG).show();
            }
        });
           /* new GetImageFromURL().execute(String.valueOf(imagelinks.get(position)));
            holder.profile_image.setImageBitmap(bitmap);*/
    }

    @Override
    public int getItemCount() {
        return bev_name.size();
    }

    public class MainRecyclerViewHolder extends RecyclerView.ViewHolder {

        public TextView tet1,tet2;
        Button btn;
        @SuppressLint("ResourceAsColor")
        public MainRecyclerViewHolder(View itemView) {
            super(itemView);
            tet1=itemView.findViewById(R.id.bev_name);
            tet2=itemView.findViewById(R.id.bev_price);
            btn=itemView.findViewById(R.id.button4);
            context=itemView.getContext();
        }
    }
}
