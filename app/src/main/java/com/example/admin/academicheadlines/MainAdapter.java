package com.example.admin.academicheadlines;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by pxh on 2016/10/23.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> implements View.OnClickListener
{
    private ArrayList<Object> list;
    private Context context;

    public MainAdapter(Context context, ArrayList<Object> list)
    {
        this.context = context;
        this.list = list;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        return new MainViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position)
    {
        holder.linearLayout.setOnClickListener(this);
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    @Override
    public void onClick(View v)
    {
        context.startActivity(new Intent(context, ContentActivity.class));
    }

    static class MainViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout linearLayout;
        public MainViewHolder(View itemView)
        {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.layout);
        }
    }
}
