package com.hackmty.experience.ui;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.hackmty.experience.R;
import com.hackmty.experience.controller.api.User;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;
    public ArrayList<User> users;

    public UserAdapter(Context mContext, ArrayList<User> users) {
        this.mContext = mContext;
        this.users = users;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_user, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        UserHolder userHolder = (UserHolder)holder;
        User user = users.get(position);
        userHolder.name.setText(user.name);

        ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithResourceId(user.image).build();
        userHolder.draweeView.setImageURI(imageRequest.getSourceUri());
        GenericDraweeHierarchy hierarchy = userHolder.draweeView.getHierarchy();
        RoundingParams roundingParams = RoundingParams.asCircle();
        roundingParams.setRoundingMethod(RoundingParams.RoundingMethod.OVERLAY_COLOR);
        roundingParams.setOverlayColor(Color.parseColor("#ffffff"));
        hierarchy.setRoundingParams(roundingParams);
        hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.name)
        TextView name;

        @Bind(R.id.drawee)
        SimpleDraweeView draweeView;

        public UserHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
