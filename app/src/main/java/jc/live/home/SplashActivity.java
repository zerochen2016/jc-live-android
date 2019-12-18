package jc.live.home;


import android.os.Bundle;

import jc.live.R;
import jc.live.base.BaseActivity;
import jc.live.util.ActivityUtil;

/**
 * 启动图
 * @Author JC
 * @Date 2019-12-17
 * @Since 1.0.0
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread myThread = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(3000);//休眠3秒
                    ActivityUtil.startActivity(getApplicationContext(),AdvertismentStartActivity.class);
                    //启动广告
                    finish();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }
}
