package jc.live.base;

import jc.live.util.CollectionUtil;
import jc.live.util.SharedPreferencesUtil;
import jc.live.util.StringUtil;

/**
 * @Author JC
 * @Date 2019-12-19
 * @Since
 */
public class AppConfig {

    public static AppConfig sInstance;

    private AppConfig(){};

    static {
        if(sInstance == null){
            sInstance = new AppConfig();
        }
    }

    public static AppConfig getInstance(){
        return sInstance;
    }

    private String mUserId;

    private String mToken;

    public String getUserId() {
        if(StringUtil.anyEmpty(mUserId,mToken)){
            String[] userIdAndToken = SharedPreferencesUtil.getInstance()
                    .getMultiStringValue(new String[]{Constant.SP_KEY.UID, Constant.SP_KEY.TOKEN});
            if(CollectionUtil.arrayEmpty(userIdAndToken)){
                return "";
            }
            if(!StringUtil.isEmpty(userIdAndToken[0]) && !StringUtil.isEmpty(userIdAndToken[1])){
                mUserId = userIdAndToken[0];
                mToken = userIdAndToken[1];
            }
        }
        return mUserId;
    }

    public void setUserId(String userId) {
        mUserId = userId;
    }

    public String getToken() {
        if(StringUtil.anyEmpty(mUserId,mToken)){
            String[] userIdAndToken = SharedPreferencesUtil.getInstance()
                    .getMultiStringValue(new String[]{Constant.SP_KEY.UID, Constant.SP_KEY.TOKEN});
            if(CollectionUtil.arrayEmpty(userIdAndToken)){
                return "";
            }
            if(!StringUtil.isEmpty(userIdAndToken[0]) && !StringUtil.isEmpty(userIdAndToken[1])){
                mUserId = userIdAndToken[0];
                mToken = userIdAndToken[1];
            }
        }
        return mToken;
    }

    public void setToken(String token) {
        mToken = token;
    }
}
