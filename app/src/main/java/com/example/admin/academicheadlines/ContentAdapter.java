package com.example.admin.academicheadlines;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by pxh on 2016/10/23.
 */

public class ContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener
{
    private Context context;
    private ArrayList<Object> list;

    public ContentAdapter(Context context, ArrayList<Object> list)
    {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);

        return new ContentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        if (position > 0) {
            holder.itemView.setOnClickListener(this);
        }
    }

    @Override
    public int getItemCount()
    {
        return 1 + list.size();
    }

    @Override
    public int getItemViewType(int position)
    {
        if (position == 0) {
            return R.layout.content_first;
        }
        return R.layout.content_sec;
    }

    @Override
    public void onClick(View v)
    {
        context.startActivity(new Intent(context, Paper.class));
    }

    static class ContentViewHolder extends RecyclerView.ViewHolder
    {

        public ContentViewHolder(View itemView)
        {
            super(itemView);
        }
    }
}
