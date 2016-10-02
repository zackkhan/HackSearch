package com.example.zackk.hackumbc;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by tamerbader on 10/2/16.
 */

public class CardHolder extends RecyclerView.ViewHolder {
    ImageView logo;
    ImageView circleDate;
    ImageView circleState;
    TextView hackathonName;
    TextView date;
    TextView state;


    public CardHolder(View itemView) {
        super(itemView);
    }
}
