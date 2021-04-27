package com.nguyenhoa.weatherforcast;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Button btn_start_edit = findViewById(R.id.btn_start_edit);

        btn_start_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),VideoEditActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
