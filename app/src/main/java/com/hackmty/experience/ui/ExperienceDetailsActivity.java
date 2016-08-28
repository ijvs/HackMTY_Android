package com.hackmty.experience.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TableLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.hackmty.experience.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ExperienceDetailsActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.drawee)
    SimpleDraweeView draweeView;

    @Bind(R.id.tabs)
    TabLayout tabLayout;

    @Bind(R.id.viewPager)
    ViewPager viewPager;

    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_details);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String res_url = bundle.getString("resource_url");
            if (res_url == null || res_url.equals("")){
                ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithResourceId(bundle.getInt("resource_id")).build();
                draweeView.setImageURI(imageRequest.getSourceUri());
            }else{
                draweeView.setImageURI(res_url);
            }
        }
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }


}
