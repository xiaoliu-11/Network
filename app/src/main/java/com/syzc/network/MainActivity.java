package com.syzc.network;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends BaseActivity {
    private TextView mTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv= (TextView) findViewById(R.id.textView);
        //启动时判断网络状态
        boolean netConnect = this.isNetConnect();
        if (netConnect){
            mTv.setVisibility(View.GONE);
        }else {
            mTv.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onNetChange(int netMobile) {
        super.onNetChange(netMobile);
        //网络状态变化时的操作
        if (netMobile==NetUtil.NETWORK_NONE){
            mTv.setVisibility(View.VISIBLE);
        }else {
            mTv.setVisibility(View.GONE);
        }
    }
}
