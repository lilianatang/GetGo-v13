package com.macewan.getgo.getgo_v13.Containers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.getgo.uidesign.ObjectClass.Results;
import com.example.getgo.uidesign.R;

import java.util.List;

/**
 * Created by Siham on 2018-03-19.
 *
 *  Connects data to view of container
 *
 *  needs editing
 */

public abstract class LogicAdapter extends RecyclerView.Adapter<ContainerAdapter.ProductViewHolder>{

    private Context context;
    private ContainerAdapter.OnItemClickListener listener;
    private List<Results> containerResults;

    public LogicAdapter(Context context,List<Results> containerResults) {
        this.containerResults = containerResults;
        this.context = context;
    }

    public interface OnItemClickListener{
        void onItemClick(View item);
    }

    @Override
    public ContainerAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ContainerAdapter.ProductViewHolder holder;
        View view = inflater.inflate(R.layout.logic_container, null);
        holder = null;//this.ProductViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ContainerAdapter.ProductViewHolder holder, int position) {
        Results container = containerResults.get(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
