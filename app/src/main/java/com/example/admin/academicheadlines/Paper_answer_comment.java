package com.example.admin.academicheadlines;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/17 0017.
 */
public class Paper_answer_comment extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paper_answer_comment);
    List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
    for (int i = 0; i < 5; i++) {
        Map<String, Object> showitem = new HashMap<String, Object>();
        showitem.put("paper_answer_comment_user_avatar",R.drawable.avatar);
        showitem.put("paper_answer_comment_user_name", "USER"+(i+1));
        showitem.put("paper_answer_comment_content", " for ICA that allows us to learn highly overcomplete sparse features even on unwhitened data.for ICA that allows us to learn highly overcomplete sparse features even on unwhitened data.for ICA that allows us to learn highly overcomplete sparse features even on unwhitened data. ");
        showitem.put("paper_answer_comment_agree",(10+i)+" 赞同 .");
        showitem.put("paper_answer_comment_comment"," 查看对话 .");
        showitem.put("paper_answer_comment_time"," 10-"+(i+1));

        listitem.add(showitem);
    }
    SimpleAdapter myAdapter = new SimpleAdapter(getApplicationContext(), listitem, R.layout.paper_answer_comment_list, new String[]{"paper_answer_comment_user_avatar", "paper_answer_comment_user_name", "paper_answer_comment_content","paper_answer_comment_agree","paper_answer_comment_comment","paper_answer_comment_time"}, new int[]{R.id.paper_answer_comment_user_avatar, R.id.paper_answer_comment_user_name, R.id.paper_answer_comment_content,R.id.paper_answer_comment_agree,R.id.paper_answer_comment_comment,R.id.paper_answer_comment_time});
    ListView listView = (ListView) findViewById(R.id.paper_answer_comment_list);
    listView.setAdapter(myAdapter);
}

}
