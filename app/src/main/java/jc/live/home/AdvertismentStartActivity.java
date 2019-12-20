package jc.live.home;


import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;
import jc.live.R;
import jc.live.advertisment.AdvertismentModel;
import jc.live.base.BaseActivity;
import jc.live.base.Constant;
import jc.live.result.JsonResult;
import jc.live.util.ActivityUtil;
import jc.live.util.GsonExtension;
import jc.live.util.SharedPreferencesUtil;

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
    private long mCountTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAdvertismentStart();
        mAdvertismentStartPhoto = findViewById(R.id.ad_start);
        mAdvertismentStartPhoto.setOnClickListener(this);

        AdvertismentModel ad = SharedPreferencesUtil.getInstance().getBeanByGson(Constant.SP_KEY.AD_START,
                AdvertismentModel.class);
        if(ad == null){
            ActivityUtil.forwardHomeOrLogin();
            finish();
        }else{
            loadAdvertismentStart(ad);
        }
        mSkip = findViewById(R.id.ad_start_skip);
        mSkip.setOnClickListener(this);
        startTimeCount();
    }

    private void loadAdvertismentStart(AdvertismentModel ad) {
        mAdvertismentStartUrl = ad.getAdUrl();
        mCountTime = ad.getAdTime() * 1000l;
        Glide.with(this).load(Uri.parse((ad.getAdContent()))).into(mAdvertismentStartPhoto);
    }

    private void startTimeCount() {
        mTimer = new CountDownTimer(mCountTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mSkip.setText(String.format(getApplication().getResources().getString(R.string.skip_second), millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                ActivityUtil.forwardHomeOrLogin();
            }
        }.start();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_advertisment_start;
    }

    private void getAdvertismentStart(){
        new AsyncHttpClient().get(Constant.API_URL.AD_START, new TextHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                if(statusCode == 200){
                    JsonResult jr = GsonExtension.GsonToBean(responseString, JsonResult.class);
                    if(jr.getCode() == 0){
                        AdvertismentModel ad = GsonExtension.GsonToBean(GsonExtension.GsonString(jr.getData()),
                                AdvertismentModel.class);
                        SharedPreferencesUtil.getInstance().setBean(Constant.SP_KEY.AD_START, ad);
                        loadAdvertismentStart(ad);
                    }
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }


        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ad_start:
                //跳转广告
                stopTimer();
                ActivityUtil.forwardBrowser(getApplicationContext(), mAdvertismentStartUrl);
                break;
            case R.id.ad_start_skip:
                //登陆页或者主页
                ActivityUtil.forwardHomeOrLogin();
                finish();
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
