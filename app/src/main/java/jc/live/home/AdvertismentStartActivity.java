package jc.live.home;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import jc.live.R;
import jc.live.base.AppConfig;
import jc.live.base.AppContext;
import jc.live.base.BaseActivity;
import jc.live.login.LoginActivity;
import jc.live.util.ActivityUtil;
import jc.live.util.StringUtil;

/**
 * 启动广告
 * @Author JC
 * @Date 2019-12-17
 * @Since 1.0.0
 */
public class AdvertismentStartActivity extends BaseActivity implements View.OnClickListener{

    private ImageView mAdvertismentStartPhoto;
    private String mAdvertismentStartUrl;
    private CountDownTimer mTimer;
    private TextView mSkip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdvertismentStartPhoto = findViewById(R.id.ad_start);
        mAdvertismentStartPhoto.setOnClickListener(this);
        mSkip = findViewById(R.id.ad_start_skip);
        mSkip.setOnClickListener(this);
        getAdvertismentStart();
        startTimeCount();

    }

    private void startTimeCount() {
        mTimer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mSkip.setText(String.format(getApplication().getResources().getString(R.string.skip_second), millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_advertisment_start;
    }

    private void getAdvertismentStart(){

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ad_start:
                //跳转广告
//                ActivityUtil.forwardBrowser(getApplicationContext(), mAdvertismentStartUrl);
                ActivityUtil.forwardBrowser(getApplicationContext(), "http://www.baidu.com");
                break;
            case R.id.ad_start_skip:
                //登陆页或者主页
                AppConfig appConfig = AppConfig.getInstance();
                if(StringUtil.anyEmpty(appConfig.getUserId(),appConfig.getToken())){
                    ActivityUtil.startActivity(getApplicationContext(), LoginActivity.class);
                }else{
                    ActivityUtil.startActivity(getApplicationContext(),HomeActivity.class);
                }
                break;
            default:
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopTimer();
    }

    private void stopTimer() {
        if(mTimer != null){
            mTimer.cancel();
            mTimer = null;
        }
    }


}
