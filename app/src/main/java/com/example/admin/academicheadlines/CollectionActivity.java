package com.example.admin.academicheadlines;

import android.content.Intent;
import android.content.pm.PathPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class CollectionActivity extends AppCompatActivity {
    private Button Button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        Button1= (Button) findViewById(R.id.papertitle1);
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CollectionActivity.this,Paper.class);
                startActivity(intent);
            }
        });
    }
}
