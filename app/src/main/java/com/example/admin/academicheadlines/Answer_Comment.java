package com.example.admin.academicheadlines;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lzy on 2016/10/25.
 */
public class Answer_Comment extends Activity implements View.OnClickListener{

    private List<Answer_Comment_Class> mData = null;
    private Context mContext;
    private Answer_List mAdapter = null;
    private ListView list_answer_comment;
    private ImageButton answer_comment_back;
    private EditText answer_comment_edittext_add;
    private Button answer_comment_button_add;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_comment);
        bindViews();

        mContext = Answer_Comment.this;
        mData = new LinkedList<Answer_Comment_Class>();
        for (int i = 1; i <=10; i++)
        {
            mData.add(new Answer_Comment_Class(R.drawable.avatar,"USER"+i, "for ICA that allows us to learn highly overcomplete sparse features even on unwhitened data.for ICA that allows us to learn highly overcomplete sparse features even on unwhitened data.for ICA that allows us to learn highly overcomplete sparse features even on unwhitened data.",(10+i)+" 赞同  . ", "查看对话  . ",i+" 分钟前"));
        }
        mAdapter = new Answer_List((LinkedList<Answer_Comment_Class>) mData, mContext);
        list_answer_comment.setAdapter(mAdapter);
        list_answer_comment.setFocusable(false);
    }



    private void bindViews()
    {
        list_answer_comment = (ListView) findViewById(R.id.answer_comment);
        answer_comment_back=(ImageButton)findViewById(R.id.answer_comment_back);
        answer_comment_edittext_add=(EditText)findViewById((R.id.answer_comment_edittext_add));
        answer_comment_button_add=(Button)findViewById(R.id.answer_comment_button_add);

        answer_comment_back.setOnClickListener(this);
        answer_comment_button_add.setOnClickListener(this);


    }


    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.answer_comment_back:
                Answer_Comment.this.finish();
                break;
            case R.id.answer_comment_button_add:
                mAdapter.add(0,new Answer_Comment_Class(R.drawable.avatar,"USER_NEW", answer_comment_edittext_add.getText().toString()+" .",10+" 赞同  . ", "查看对话  . ",1+" 分钟前"));
                //输入完成，编辑框置空
                answer_comment_edittext_add.setText("");
                //输入完成键盘收起
                InputMethodManager imm =  (InputMethodManager)getSystemService(mContext.INPUT_METHOD_SERVICE);
                if(imm != null)
                {
                    imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                }

                    break;
        }
    }



    public class Answer_List extends BaseAdapter
    {

        private LinkedList<Answer_Comment_Class> mData;
        private Context mContext;

        public Answer_List(LinkedList<Answer_Comment_Class> mData, Context mContext) {
            this.mData = mData;
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {

                holder=new ViewHolder();

                //可以理解为从vlist获取view  之后把view返回给ListView

                convertView = LayoutInflater.from(mContext).inflate(R.layout.answer_comment_list, null);
                holder.user_avatar = (ImageView) convertView.findViewById(R.id.answer_user_avatar);
                holder.user_Name = (TextView)convertView.findViewById(R.id.answer_user_name);
                holder.answer_content = (TextView) convertView.findViewById(R.id.answer_content);
                holder.answer_agree = (TextView) convertView.findViewById(R.id.answer_agree);
                holder.answer_comment = (TextView) convertView.findViewById(R.id.answer_comment);
                holder.answer_time = (TextView) convertView.findViewById(R.id.answer_time);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }

            holder.user_avatar.setBackgroundResource(mData.get(position).getuser_avatar());
            holder.user_Name.setText(mData.get(position).getuser_Name());
            holder.answer_content.setText(mData.get(position).getanswer_content());
            holder.answer_agree.setText(mData.get(position).getanswer_agree());
            holder.answer_comment.setText(mData.get(position).getanswer_comment());
            holder.answer_time.setText(mData.get(position).getanswer_time());
            //给Button添加单击事件  添加Button之后ListView将失去焦点  需要的直接把Button的焦点去掉



            return convertView;
        }



        //提取出来方便点
        public final class ViewHolder {
            public ImageView user_avatar;
            public TextView user_Name;
            public TextView answer_content;
            public TextView answer_agree;
            public TextView answer_comment;
            public TextView answer_time;
        }

        public void add(int position,Answer_Comment_Class data)
        {
            if (mData == null)
            {
                mData = new LinkedList<>();
            }
            mData.add(position,data);
            notifyDataSetChanged();
        }
    }

}

