package jc.live.util;

import android.content.Context;
import android.content.Intent;

/**
 * Activity工具类
 * @Author JC
 * @Date 2019-12-17
 * @Since 1.0.0
 */
public class ActivityUtil {

    /**
     * 启动新的Activity
     * @param context 当前Activity
     * @param cls     要启动的Activity的类
     */
    public static void startActivity(Context context , Class cls){
        Intent intent = new Intent();
        intent.setClass(context, cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
        context.startActivity(intent);

    }
}
