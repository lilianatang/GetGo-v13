package com.macewan.getgo.getgo_now.UIPages;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Siham on 2018-03-15.
 */

public class ClickHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView degree;
    public TextView institution;
    public IMyViewHolderClicks mListener;

    public ClickHolder(View itemView, IMyViewHolderClicks listener) {
        super(itemView);
    }

    @Override
    public void onClick(View view) {
        if(view instanceof TextView){
            Log.d("onClick", "onClick: " +  mListener.toString());
        }
    }

    public static interface IMyViewHolderClicks{
        public void onPotato(View caller);
    }
}
