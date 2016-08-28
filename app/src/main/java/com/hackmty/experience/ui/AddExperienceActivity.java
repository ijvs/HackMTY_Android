package com.hackmty.experience.ui;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.hackmty.experience.R;
import com.hackmty.experience.controller.api.Experience;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import pl.aprilapps.easyphotopicker.EasyImage;
import pl.aprilapps.easyphotopicker.EasyImageConfig;

public class AddExperienceActivity extends AppCompatActivity {

    @Bind(R.id.input_name)
    EditText editName;

    @Bind(R.id.input_cost)
    EditText editCost;

    @Bind(R.id.input_description)
    EditText editDescription;

    @Bind(R.id.add)
    Button add;

    @Bind(R.id.experience_photo)
    ImageView experience;

    @Bind(R.id.drawee)
    SimpleDraweeView draweeView;

    String filePath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_experience);
        ButterKnife.bind(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("File Path", filePath);
                Intent resultIntent = new Intent();
                Experience experience = new Experience(
                        editName.getText().toString(),
                        editDescription.getText().toString(),
                        Double.parseDouble(editCost.getText().toString()),
                        filePath
                );
                resultIntent.putExtra("experience", new Gson().toJson(experience));
                setResult(RESULT_OK, resultIntent);
                AddExperienceActivity.this.finish();
            }
        });

        experience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EasyImage.openCamera(AddExperienceActivity.this, 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new EasyImage.Callbacks() {
            @Override
            public void onImagePickerError(Exception e, EasyImage.ImageSource imageSource, int i) {

            }

            @Override
            public void onImagePicked(File file, EasyImage.ImageSource imageSource, int i) {
                filePath = file.getPath();
                draweeView.setVisibility(View.VISIBLE);
                draweeView.setImageURI(Uri.fromFile(file));

            }

            @Override
            public void onCanceled(EasyImage.ImageSource imageSource, int i) {
                if (imageSource == EasyImage.ImageSource.CAMERA) {
                    File photoFile = EasyImage.lastlyTakenButCanceledPhoto(AddExperienceActivity.this);
                    if (photoFile != null) photoFile.delete();
                }
            }
        });
    }
}
