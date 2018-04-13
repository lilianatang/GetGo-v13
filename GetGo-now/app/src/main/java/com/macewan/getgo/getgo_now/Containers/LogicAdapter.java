package com.macewan.getgo.getgo_now.Containers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.macewan.getgo.getgo_now.R;
import com.macewan.getgo.getgo_now.logic.LogicResults;

import java.util.List;

/**
 * Created by Siham on 2018-03-19.
 *
 *  Connects data to view of container
 *
 *  needs editing
 */

public class LogicAdapter extends RecyclerView.Adapter<LogicAdapter.ProductViewHolder> {

    private Context context;
    private ContainerAdapter.OnItemClickListener listener;
    private List<LogicResults> containerResults;

    public LogicAdapter(Context context,List<LogicResults> containerResults) {
        this.containerResults = containerResults;
        this.context = context;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ProductViewHolder holder;

            View view = inflater.inflate(R.layout.logic_container, null);
            holder = new ProductViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(LogicAdapter.ProductViewHolder holder, final int position) {
        LogicResults container = containerResults.get(position);
        holder.textViewFaculty.setText(container.getFaculty_name());
        holder.textViewInstitution.setText(container.getUniversity_name());
        holder.textViewLogic.setText(container.getResults());
//        holder.linearLayout2.setOnClickListener(new View.OnClickListener(){
          ///  @Override
       ///     public void onClick(View view){
     //           Toast.makeText(context,"" + containerResults.get(position).faculty_name, Toast.LENGTH_LONG).show();
   //         }
  //      });
    }

    @Override
    public int getItemCount() {
        return containerResults.size();
    }


    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView textViewInstitution, textViewFaculty, textViewLogic;
        RelativeLayout linearLayout, linearLayout2;

        @SuppressLint("WrongViewCast")
        public ProductViewHolder(final View itemView) {
            super(itemView);

                textViewInstitution = itemView.findViewById(R.id.institution);
                textViewFaculty = itemView.findViewById(R.id.faculty);
                textViewLogic = itemView.findViewById(R.id.condition1);
                linearLayout2 = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
        }
    }
}
