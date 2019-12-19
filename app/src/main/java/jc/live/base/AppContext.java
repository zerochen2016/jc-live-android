package jc.live.base;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import jc.live.util.CollectionUtil;
import jc.live.util.SharedPreferencesUtil;
import jc.live.util.StringUtil;

/**
 * AppContext
 * @Author JC
 * @Date 2019-12-17
 * @Since 1.0.0
 */
public class AppContext extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        //获取context
        mContext = getApplicationContext();
    }

    /**
     * 读取context
     * @return
     */
    public static Context getContext(){
        return mContext;
    }

}
