package jc.live.base;

/**
 * @Author JC
 * @Date 2019-12-20
 * @Since
 */
public class Constant {

    public interface SP_KEY{
        String UID = "UID";
        String TOKEN = "TOKEN";

        String AD_START = "AD_START";
    }

    public interface API_URL{
        String HOST = "http://gateway.chenjinfa.vip/";
        String AD_START = HOST + "api/ad-start";
    }
}
