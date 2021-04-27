package com.nguyenhoa.weatherforcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PublishActivity extends AppCompatActivity {
    private CHS_Broad_BroadcastReceiver mCHS_Broad_Receiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        Button btn_start_video = findViewById(R.id.btn_start_video);
        btn_start_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.CHS_Broad_BroadcastReceiver");
        mCHS_Broad_Receiver = new CHS_Broad_BroadcastReceiver();
        //注册广播接收
        registerReceiver(mCHS_Broad_Receiver, filter);
    }

    public class CHS_Broad_BroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String video = intent.getExtras().get("video").toString();
            String image = intent.getExtras().get("image").toString();
            int position =(int) intent.getExtras().get("position");
            Log.e("TAG", "BroadcastReceiver_data：" + video+"=="+image+"=="+position);
        }
    }
}
