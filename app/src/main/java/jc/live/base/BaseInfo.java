package jc.live.base;

import jc.live.util.CollectionUtil;
import jc.live.util.SharedPreferencesUtil;
import jc.live.util.StringUtil;

/**
 * @Author JC
 * @Date 2019-12-19
 * @Since
 */
public class BaseInfo {

    public static final String UID = "UID";
    public static final String TOKEN = "TOKEN";

    private String mUserId;

    private String mToken;

    public String getUserId() {
        if(StringUtil.anyEmpty(mUserId,mToken)){
            String[] userIdAndToken = SharedPreferencesUtil.getInstance()
                    .getMultiStringValue(new String[]{BaseInfo.UID, BaseInfo.TOKEN});
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
                    .getMultiStringValue(new String[]{BaseInfo.UID, BaseInfo.TOKEN});
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
