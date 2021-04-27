package com.nguyenhoa.weatherforcast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class VideoEditActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_edit);

        Button btn_video_finish = findViewById(R.id.btn_video_finish);

        btn_video_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent();
                intent1.setAction("android.intent.action.CHS_Broad_BroadcastReceiver");
                intent1.putExtra("video", "files_video_data");
                intent1.putExtra("image", "file_image_data");
                intent1.putExtra("position", 105);
                sendBroadcast(intent1);
                finish();
            }
        });

    }
}
