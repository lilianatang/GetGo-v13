package com.macewan.getgo.getgo_now.Containers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.macewan.getgo.getgo_now.R;

import java.util.List;

/**
 * Created by Siham on 2018-03-15.
 *
 *  Fills the RecyclerView in UI with containers filled with
 *  the information entered.
 */

public class ContainerAdapter extends RecyclerView.Adapter<ContainerAdapter.ProductViewHolder>{

    private Context context;
    private OnItemClickListener listener;
    public List<DegreeContainer> containerDegreeList;
    public List<InstitutionContainer> containerInstitutionList;

    public interface OnItemClickListener{
        void onItemClick(View item);
    }

    public ContainerAdapter(Context context, List<DegreeContainer> containerList, List<InstitutionContainer> containerInstitutionList) {
        this.context = context;
        this.containerDegreeList = containerList;
        this.containerInstitutionList = containerInstitutionList;
    }

    //Create Holder for containers
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ProductViewHolder holder;
        if(containerDegreeList != null){
            View view = inflater.inflate(R.layout.general_container, null);
            holder = new ProductViewHolder(view);
        }
        else {
            View view = inflater.inflate(R.layout.degree_container, null);
            holder = new ProductViewHolder(view);
        }
        return holder;
    }

    //Get item name on Click
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ProductViewHolder holder, final int position) {
        if(containerDegreeList != null) {
            DegreeContainer container = containerDegreeList.get(position);
            holder.textViewTitle.setText(container.getTitle());
            holder.textViewDescription.setText(container.getDefinition());
            holder.linearLayout2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Toast.makeText(context,"" + containerDegreeList.get(position).getTitle(), Toast.LENGTH_LONG).show();
                }
            });
        }
        else{
            InstitutionContainer container = containerInstitutionList.get(position);
            holder.textView.setText(container.getName());
            holder.linearLayout.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Toast.makeText(context,"" +containerInstitutionList.get(position).getName(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(containerInstitutionList != null){
        return containerInstitutionList.size();
        }
        else{
            return containerDegreeList.size();
        }
    }

    //Bind the containers on holder
    class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewDescription, textView;
        RelativeLayout linearLayout, linearLayout2;

        @SuppressLint("WrongViewCast")
        public ProductViewHolder(final View itemView) {
            super(itemView);

            if(containerDegreeList != null) {
                textViewTitle = itemView.findViewById(R.id.institution);
                textViewDescription = itemView.findViewById(R.id.description);
                linearLayout2 = (RelativeLayout) itemView.findViewById(R.id.linearLayout2);
            }
            else{
                textView = itemView.findViewById(R.id.textView);
                linearLayout = (RelativeLayout) itemView.findViewById(R.id.linearLayout);
            }
        }
    }
}

