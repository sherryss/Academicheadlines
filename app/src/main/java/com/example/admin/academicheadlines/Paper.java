package com.example.admin.academicheadlines;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/10/15 0015.
 */
public class Paper extends AppCompatActivity {
    private TextView paper_download;
    private TextView paper_answer_content;
    private TextView paper_answer_comment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper);


        paper_download=(TextView)findViewById(R.id.paper_download);
        String download="下载地址：<a href=\"https://www.baidu.com/\">点击下载</a>";
        paper_download.setText(Html.fromHtml(download));

        paper_answer_content=(TextView)findViewById(R.id.paper_answer_content);
        paper_answer_content.setClickable(true);
        paper_answer_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Paper.this,Paper_answer.class);
                startActivity(intent);
            }
        });


        paper_answer_comment=(TextView)findViewById(R.id.paper_answer_comment);
        paper_answer_comment.setClickable(true);
        paper_answer_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Paper.this,Paper_answer_comment.class);
                startActivity(intent);
            }
        });


    }

}
