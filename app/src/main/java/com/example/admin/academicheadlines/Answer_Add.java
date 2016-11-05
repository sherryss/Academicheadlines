package com.example.admin.academicheadlines;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by lzy on 2016/11/4.
 */

public class Answer_Add extends Activity {
    private TextView answer_add_submit;
    private TextView answer_add_back;
    private EditText answer_add_content;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_add);
        bindViews();
        answer_add_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = getIntent();
                Bundle bd = new Bundle();
                bd.putString("answer_content",answer_add_content.getText().toString());
                it.putExtras(bd);
                setResult(0x123,it);
                finish();
            }
        });
        answer_add_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Answer_Add.this.finish();
            }
        });
    }
    private void bindViews()
    {
        answer_add_submit=(TextView)findViewById(R.id.answer_add_submit);
        answer_add_back=(TextView)findViewById(R.id.answer_add_back);
        answer_add_content=(EditText)findViewById(R.id.answer_add_content);
    }

}
