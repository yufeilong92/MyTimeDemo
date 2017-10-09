package com.example.dell.mydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "测试===";
    private TextView mTvTime;
    private TextView mTvTime2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();
    }

    private void initDate() {
        String nowTime = "2017-09-26 20:04:00";
        long nowMS = TimeUtil.intervalNow(nowTime);
        String timeCha = getStringTimeCha(nowMS);
        mTvTime2.setText(timeCha);

    }

    private void initView() {
        mTvTime = (TextView) findViewById(R.id.tv_time);
        mTvTime2 = (TextView) findViewById(R.id.tv_time2);
    }

    public String getStringTimeCha(long now) {
       String result="";
        long ms = now / 1000;
        BigDecimal decimal = new BigDecimal(ms).setScale(0, BigDecimal.ROUND_HALF_UP);
        long longNow = decimal.longValue();
        long temp = 0;
        Log.e(TAG, "getStringTimeCha: "+longNow );
   /*        long s = longNow;
        long fen = longNow / 60 ;
        long h= longNow / 60 / 60 ;
        long day = longNow /(60*60*24);
        Log.e(TAG, "秒="+s+"分="+fen+"小时="+h+"天="+day );*/
        if (longNow < 60) {
            result = "刚刚";
        } else if ((temp = longNow / 60) < 60) {
            result = temp + "分前";
        } else if ((temp = temp /60) < 24) {
            result = temp + "小时前";
        } else if ((temp=temp /24) < 30) {
            result = temp + "天前";
        }/*else if ((temp=temp/30)<12){
            result=temp+"月前";
        }*/ else {
            temp = temp / 12;
            result = temp + "年前";
        }
       return result;
    }
}
