package jc.live.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.util.Map;

import jc.live.base.AppContext;

/**
 * SharedPreferences工具类
 * @Author JC
 * @Date 2019-12-17
 * @Since 1.0.0
 */
public class SharedPreferencesUtil {

    private static SharedPreferencesUtil sInstance;
    private SharedPreferences mSharedPreferences;

    private SharedPreferencesUtil() {
        mSharedPreferences = AppContext.getContext().getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE);

    }

    public static SharedPreferencesUtil getInstance() {
        if (sInstance == null) {
            synchronized (SharedPreferencesUtil.class) {
                if (sInstance == null) {
                    sInstance = new SharedPreferencesUtil();
                }
            }
        }
        return sInstance;
    }

    /**
     * 保存一个字符串
     */
    public void setStringValue(String key, String value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * 获取一个字符串
     */
    public String getStringValue(String key) {
        return mSharedPreferences.getString(key, "");
    }

    /**
     * 保存多个字符串
     */
    public void setMultiStringValue(Map<String, String> pairs) {
        if (pairs == null || pairs.size() == 0) {
            return;
        }
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        for (Map.Entry<String, String> entry : pairs.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                editor.putString(key, value);
            }
        }
        editor.apply();
    }

    /**
     * 获取多个字符串
     */
    public String[] getMultiStringValue(String... keys) {
        if (keys == null || keys.length == 0) {
            return null;
        }
        int length = keys.length;
        String[] result = new String[length];
        for (int i = 0; i < length; i++) {
            String temp = "";
            if (!TextUtils.isEmpty(keys[i])) {
                temp = mSharedPreferences.getString(keys[i], "");
            }
            result[i] = temp;
        }
        return result;
    }


    /**
     * 保存一个布尔值
     */
    public void setBooleanValue(String key, boolean value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * 获取一个布尔值
     */
    public boolean getBooleanValue(String key) {
        return mSharedPreferences.getBoolean(key, false);
    }

    /**
     * 保存多个布尔值
     */
    public void setMultiBooleanValue(Map<String, Boolean> pairs) {
        if (pairs == null || pairs.size() == 0) {
            return;
        }
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        for (Map.Entry<String, Boolean> entry : pairs.entrySet()) {
            String key = entry.getKey();
            Boolean value = entry.getValue();
            if (!TextUtils.isEmpty(key)) {
                editor.putBoolean(key, value);
            }
        }
        editor.apply();
    }

    /**
     * 获取多个布尔值
     */
    public boolean[] getMultiBooleanValue(String[] keys) {
        if (keys == null || keys.length == 0) {
            return null;
        }
        int length = keys.length;
        boolean[] result = new boolean[length];
        for (int i = 0; i < length; i++) {
            boolean temp = false;
            if (!TextUtils.isEmpty(keys[i])) {
                temp = mSharedPreferences.getBoolean(keys[i], false);
            }
            result[i] = temp;
        }
        return result;
    }


    public void clear() {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.clear().apply();
    }

    public void removeValue(String... keys) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        for (String key : keys) {
            editor.remove(key);
        }
        editor.apply();
    }

    public void setBean(String key, Object obj) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        String json = new Gson().toJson(obj);
        editor.putString(key, json).apply();
    }

    public <T> T getBeanByGson(String key, Class<T> clazz) {
        String objString = mSharedPreferences.getString(key, "");
        if (!TextUtils.isEmpty(objString)) {
            return new Gson().fromJson(objString, clazz);
        } else {
            return null;
        }
    }
}
