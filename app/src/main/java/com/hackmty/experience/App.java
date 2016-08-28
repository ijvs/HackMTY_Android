package com.hackmty.experience;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.drawee.backends.pipeline.Fresco;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(this);
        Fresco.initialize(this);
    }
}
