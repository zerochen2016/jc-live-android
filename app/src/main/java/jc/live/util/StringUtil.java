package jc.live.util;

import java.util.Arrays;

/**
 * @Author JC
 * @Date 2019-12-19
 * @Since
 */
public class StringUtil {

    public static boolean isEmpty(String s){
        return (s == null || s.length() <= 0) ? true : false;
    }

    public static boolean anyEmpty(String ...strings){
        for(String s:strings){
            if(isEmpty(s)){
                return true;
            }
        }
        return false;
    }

}
