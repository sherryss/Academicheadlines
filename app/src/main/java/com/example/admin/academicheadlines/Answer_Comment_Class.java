package com.example.admin.academicheadlines;

/**
 * Created by lzy on 2016/10/25.
 */
public class Answer_Comment_Class {
    private int user_avatar;
    private String user_Name;
    private String answer_content;
    private String answer_agree;
    private String answer_comment;
    private String answer_time;

    public Answer_Comment_Class() {
    }

    public Answer_Comment_Class( int user_avatar,String user_Name, String answer_content,String answer_agree, String answer_comment,String answer_time) {
        this.user_avatar = user_avatar;
        this.user_Name = user_Name;
        this.answer_content = answer_content;
        this.answer_agree=answer_agree;
        this.answer_comment=answer_comment;
        this.answer_time=answer_time;
    }

    public int getuser_avatar() {
        return user_avatar;
    }
    public String getuser_Name() {
        return user_Name;
    }
    public String getanswer_content() {
        return answer_content;
    }
    public String getanswer_agree() {
        return answer_agree;
    }
    public String getanswer_comment() {
        return answer_comment;
    }
    public String getanswer_time() {
        return answer_time;
    }

    public void setuser_avatar(int user_avatar) {
        this.user_avatar = user_avatar;
    }
    public void setuser_Name(String user_Name) {
        this.user_Name = user_Name;
    }
    public void setanswer_content(String answer_content) {
        this.answer_content = answer_content;
    }
    public void setanswer_agree(String answer_agree) {
        this.answer_agree = answer_agree;
    }
    public void setanswer_comment(String answer_comment) {
        this.answer_comment = answer_comment;
    }
    public void setanswer_time(String answer_time) {
        this.answer_time = answer_time;
    }


}
