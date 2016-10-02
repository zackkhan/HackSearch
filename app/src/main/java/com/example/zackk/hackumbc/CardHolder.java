package com.example.zackk.hackumbc;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.R.id.list;

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
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.hackathonName.setText(hackathons.get(position).hackName);

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
        TextView hackathonName;
        TextView date;
        TextView state;

        public ViewHolder(View itemView) {
            super(itemView);
            circleDate = (ImageView) itemView.findViewById(R.id.circleDot);
            circleState = (ImageView) itemView.findViewById(R.id.redDot);
            hackathonName = (TextView) itemView.findViewById(R.id.hackathonName);
            date = (TextView) itemView.findViewById(R.id.hackathonName);
            state = (TextView) itemView.findViewById(R.id.town);
        }
    }
    public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... strings) {
            return null;
        }
    }

}
