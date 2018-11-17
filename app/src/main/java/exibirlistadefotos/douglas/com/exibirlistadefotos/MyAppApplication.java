package exibirlistadefotos.douglas.com.exibirlistadefotos;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class MyAppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
