package com.example.admin.academicheadlines;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;

public class Paper extends  ActionBarActivity {

    private LinkedList<Answer_Class> mData = null;
    private Context mContext;
    private Answer_List mAdapter = null;
    private ListView list_answer;
    private Button btn_add_answer;
    private Button paper_button1;
    private String answer_add_content;
    static int flag=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper);

        TextView paper_download = (TextView) findViewById(R.id.paper_download);
        String download = "下载地址：<a href=\"https://www.baidu.com/\">点击下载</a>";
        paper_download.setText(Html.fromHtml(download));


        mContext = Paper.this;
        list_answer = (ListView) findViewById(R.id.paper_answer);
        btn_add_answer=(Button)findViewById(R.id.btn_add_answer);
        mData = new LinkedList<Answer_Class>();
        for (int i = 1; i <=10; i++){
            mData.add(new Answer_Class(R.drawable.avatar,"USER"+i, "for ICA that allows us to learn highly overcomplete sparse features even on unwhitened data.for ICA that allows us to learn highly overcomplete sparse features even on unwhitened data.for ICA that allows us to learn highly overcomplete sparse features even on unwhitened data.",(10+i)+" 赞同  . ","10"+i+" 评论  . ",i+" 分钟前"));
        }
        mAdapter = new Answer_List((LinkedList<Answer_Class>) mData, mContext);
        list_answer.setAdapter(mAdapter);
        list_answer.setFocusable(false);

        btn_add_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Paper.this,Answer_Add.class);
                startActivityForResult(intent,0x123);

            }
        });
        paper_button1=(Button)findViewById(R.id.paper_button1);
        paper_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Paper.this,ContentActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0x123 && resultCode == 0x123)
        {
            Bundle bd = data.getExtras();
            answer_add_content=bd.getString("answer_content");
            mAdapter.add(0,new Answer_Class(R.drawable.avatar,"USER_Test"+flag, answer_add_content,(10+flag)+" 赞同  . ","10"+flag+" 评论  . ",flag+" 分钟前"));
            flag++;
        }
    }


    public class Answer_List extends BaseAdapter {

        private LinkedList<Answer_Class> mData;
        private Context mContext;

        public Answer_List(LinkedList<Answer_Class> mData, Context mContext) {
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

                convertView = LayoutInflater.from(mContext).inflate(R.layout.paper_answer, null);
                holder.user_avatar = (ImageView) convertView.findViewById(R.id.paper_answer_user_avatar);
                holder.user_Name = (TextView)convertView.findViewById(R.id.paper_answer_user_name);
                holder.answer_content = (TextView) convertView.findViewById(R.id.paper_answer_content);
                holder.answer_agree = (TextView) convertView.findViewById(R.id.paper_answer_agree);
                holder.answer_comment = (TextView) convertView.findViewById(R.id.paper_answer_comment);
                holder.answer_time = (TextView) convertView.findViewById(R.id.paper_answer_time);
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
            holder.answer_content.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if(position==0)
                    {
                        Intent intent = new Intent();
                        intent.setClass(Paper.this,answer.class);
                        startActivity(intent);
                    }
                }
            });

            holder.answer_comment.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if(position==0)
                    {
                        Intent intent = new Intent();
                        intent.setClass(Paper.this,Answer_Comment.class);
                        startActivity(intent);
                    }
                }
            });

            //holder.viewBtn.setOnClickListener(MyListener(position));

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
        public void add(int position,Answer_Class data){
            if (mData == null) {
                mData = new LinkedList<>();
            }
            mData.add(position,data);
            notifyDataSetChanged();
        }
    }




}
