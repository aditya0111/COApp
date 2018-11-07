package com.companeon.coffeeapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Aditya on 11/6/2018.
 */

public class Main_Fragment extends Fragment{

    RecyclerView mrecyclerView;
    RecyclerView.LayoutManager mlayoutManager;
    ArrayList<String> bev_name ,image_locations,bev_price;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.main_central, container, false);

        mrecyclerView = view.findViewById(R.id.recycler_view);
        mrecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(getContext());
        mrecyclerView.setLayoutManager(mlayoutManager);
        bev_name =new ArrayList<>();
        bev_price =new ArrayList<>();
        image_locations =new ArrayList<>();

            bev_name.add("CAPPUCCINO");
            bev_name.add("ESPRESSO");
            bev_name.add("BLACK COFFEE");
            bev_price.add("100");
        bev_price.add("120");
        bev_price.add("20");
            image_locations.add("");

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainRecyclerAdapter madapter = new MainRecyclerAdapter(bev_name,bev_price,image_locations);
        mrecyclerView.setAdapter(madapter);

    }
}
