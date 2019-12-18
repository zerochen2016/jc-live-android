package jc.live.base;

import android.app.Application;

/**
 * AppContext
 * @Author JC
 * @Date 2019-12-17
 * @Since 1.0.0
 */
public class AppContext extends Application {

    public static AppContext sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }
}
