package com.example.zackk.hackumbc;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by tamerbader on 10/2/16.
 */

public class ProjectListHolder extends RecyclerView.Adapter<ProjectListHolder.ViewHolder> {
    public ArrayList<Projects> projects;
    public Context myContext;
    public ProjectListHolder(Context context, ArrayList<Projects> project) {
        myContext = context;
        projects = project;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_cards, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.projectName.setText(projects.get(position).getName());
        holder.projectDescription.setText(projects.get(position).getDescription());
        holder.projectLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context mContext = view.getContext();
              //  HackathonListActivity.chosenHackathon = position;
                Intent go = new Intent(mContext, HackathonDetails.class);
                mContext.startActivity(go);
            }
        });


    }

    @Override
    public int getItemCount() {
        if(projects == null) {
            return 0;
        } else {
            return projects.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView projectLogo;
        TextView projectName;
        TextView projectDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            projectLogo = (ImageView) itemView.findViewById(R.id.logoImage);
            projectName = (TextView) itemView.findViewById(R.id.hackName);
            projectDescription = (TextView) itemView.findViewById(R.id.hackDescription);

        }
    }
    private class DownLoadImageTask extends AsyncTask<String,Void,Bitmap>{
        ImageView imageView;

        public DownLoadImageTask(ImageView imageView){
            this.imageView = imageView;
        }

        /*
            doInBackground(Params... params)
                Override this method to perform a computation on a background thread.
         */
        protected Bitmap doInBackground(String...urls){
            String urlOfImage = urls[0];
            Bitmap logo = null;
            try{
                InputStream is = new URL(urlOfImage).openStream();
                /*
                    decodeStream(InputStream is)
                        Decode an input stream into a bitmap.
                 */
                logo = BitmapFactory.decodeStream(is);
            }catch(Exception e){ // Catch the download exception
                e.printStackTrace();
            }
            return logo;
        }

        /*
            onPostExecute(Result result)
                Runs on the UI thread after doInBackground(Params...).
         */
        protected void onPostExecute(Bitmap result){
            if (result == null) {
               // imageView.setImageDrawable();
            } else {
                imageView.setImageBitmap(result);
            }
        }
    }

}
