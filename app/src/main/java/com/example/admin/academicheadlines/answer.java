package com.example.admin.academicheadlines;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by lzy on 2016/10/24.
 */
public class answer extends Activity {

    private TextView answer_paper_title;
    private TextView answer_answer_user_name;
    private TextView answer_answer_content;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        bindViews();
        Intent it = getIntent();
        Bundle bd = it.getExtras();
        answer_paper_title.setText(bd.getString("answer_answer_paper_title"));
        answer_answer_user_name.setText(bd.getString("answer_answer_user_name"));
        answer_answer_content.setText(bd.getString("answer_answer_content"));

    }
    private void bindViews()
    {
        answer_paper_title=(TextView)findViewById(R.id.answer_paper_title);
        answer_answer_user_name=(TextView)findViewById(R.id.answer_answer_user_name);
        answer_answer_content=(TextView)findViewById(R.id.answer_answer_content);
    }
}
