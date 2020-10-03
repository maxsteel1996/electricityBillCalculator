package com.monitorelectricitybill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.monitorelectricitybill.model.Data;

import java.util.Collections;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class Recycler_View_Adapter extends RecyclerView.Adapter<MyViewHolder> {

    List<Data> list = Collections.emptyList();
    Context context;

    public Recycler_View_Adapter(List<Data> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        Data dataAtPosition=list.get(position);
        holder.setNote(dataAtPosition.getDescription());
        holder.setType(dataAtPosition.getName());
        holder.setImage(dataAtPosition.getVectorId());
        holder.setPower(String.valueOf(dataAtPosition.getPower()));
        holder.setImage(dataAtPosition.getVectorId());
        holder.setUses(dataAtPosition.getUsesHour(),dataAtPosition.getUsesMinutes(),dataAtPosition.getUsePerDuration());
        //animate(holder);

    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, Data data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Data data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }

}