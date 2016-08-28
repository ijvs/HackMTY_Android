package com.hackmty.experience.ui;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.firebase.auth.FirebaseAuth;
import com.hackmty.experience.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SignupActivity extends AppCompatActivity {

    @Bind(R.id.draweeBackground)
    SimpleDraweeView draweeView;

    @Bind(R.id.draweeProfile)
    SimpleDraweeView draweeProfile;

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

            }
        };

        ImageRequest request = ImageRequestBuilder.newBuilderWithResourceId(R.drawable.experience).build();
        draweeView.setImageURI(request.getSourceUri());

        GenericDraweeHierarchy hierarchy = draweeProfile.getHierarchy();
        RoundingParams roundingParams = RoundingParams.asCircle();
        roundingParams.setRoundingMethod(RoundingParams.RoundingMethod.BITMAP_ONLY);
        roundingParams.setBorder(R.color.white, 1.0f);
        hierarchy.setRoundingParams(roundingParams);
        hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);

        request = ImageRequestBuilder.newBuilderWithResourceId(R.drawable.contact).build();
        draweeProfile.setImageURI(request.getSourceUri());

    }


    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}
