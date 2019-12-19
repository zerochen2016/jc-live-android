package jc.live.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import java.util.List;

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
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }

    /**
     * 跳转浏览器
     * @param context
     * @param url
     */
    public static void forwardBrowser(Context context, String url){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (isIntentAvailable(context,intent)){
            context.startActivity(intent);
        }
    }

    /**
     * Intent是否有效
     * @param context
     * @param intent
     * @return
     */
    public static boolean isIntentAvailable(Context context, Intent intent) {
        final PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }
}
