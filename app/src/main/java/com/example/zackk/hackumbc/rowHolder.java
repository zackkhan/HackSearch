package com.example.zackk.hackumbc;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by zackk on 10/2/2016.
 */

public class rowHolder extends RecyclerView.Adapter<rowHolder.ViewHolder> {

    @Override
    public rowHolder.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(rowHolder.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView projectName;
        TextView projectDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            projectName = (TextView) itemView.findViewById(R.id.project_name);
            projectDescription = (TextView) itemView.findViewById(R.id.project_description);
        }
    }
}
