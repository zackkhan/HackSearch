package com.example.zackk.hackumbc;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import static android.R.id.list;
import static com.example.zackk.hackumbc.R.id.imageView;
import static com.example.zackk.hackumbc.R.id.profileIcon;

/**
 * Created by tamerbader on 10/2/16.
 */

public class CardHolder extends RecyclerView.Adapter<CardHolder.ViewHolder> {
    public ArrayList<Hackathon> hackathons = null;
    public Context myContext;
    public CardHolder(Context context, ArrayList<Hackathon> hack) {
        myContext = context;
        hackathons = hack;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hackathon_cards, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.hackathonName.setText(hackathons.get(position).hackName);
        holder.date.setText(hackathons.get(position).startDate);
        holder.state.setText(hackathons.get(position).addressRegion + ", USA");
        holder.background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context mContext = view.getContext();
                HackathonListActivity.chosenHackathon = position;
                Intent go = new Intent(mContext, HackathonDetails.class);
            }
        });
        Picasso.with(myContext).load(hackathons.get(position).imageURL).resize(120, 60).into(holder.logo);



    }

    @Override
    public int getItemCount() {
        if(hackathons == null) {
            return 0;
        } else {
            return hackathons.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {ImageView logo;
        ImageView circleDate;
        ImageView circleState;
        ImageButton background;
        TextView hackathonName;
        TextView date;
        TextView state;

        public ViewHolder(View itemView) {
            super(itemView);
            circleDate = (ImageView) itemView.findViewById(R.id.circleDot);
            circleState = (ImageView) itemView.findViewById(R.id.redDot);
            hackathonName = (TextView) itemView.findViewById(R.id.hackathonName);
            date = (TextView) itemView.findViewById(R.id.date);
            state = (TextView) itemView.findViewById(R.id.town);
            background = (ImageButton) itemView.findViewById(R.id.cardBackground);

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
