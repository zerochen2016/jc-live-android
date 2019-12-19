package jc.live.util;

/**
 * @Author JC
 * @Date 2019-12-19
 * @Since
 */
public class CollectionUtil {

    public static boolean arrayEmpty(Object[] array){
        if(array == null || array.length <= 0){
            return true;
        }
        return false;
    }
}
