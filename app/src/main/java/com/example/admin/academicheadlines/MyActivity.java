package com.example.admin.academicheadlines;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MyActivity extends AppCompatActivity {
    private ImageButton login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        login = (ImageButton) findViewById(R.id.Head_portrait);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到登录界面
                Intent intent = new Intent(MyActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
