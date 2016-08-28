package com.hackmty.experience.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hackmty.experience.R;
import com.hackmty.experience.controller.api.Experience;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GenericAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Context mContext;
    public ArrayList<Experience> experiences;

    public GenericAdapter(Context mContext, ArrayList<Experience> experiences) {
        this.mContext = mContext;
        this.experiences = experiences;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ExperienceHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_generic, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return experiences.size();
    }

    class ExperienceHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.drawee) SimpleDraweeView draweeView;
        @Bind(R.id.category) TextView category;
        @Bind(R.id.title) TextView title;

        public ExperienceHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
