package jc.live.base;

import android.app.Application;

public class AppContext extends Application {

    public static AppContext sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }
}
