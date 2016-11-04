package com.example.admin.academicheadlines.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/**
 * Created by ShaWei on 2016/11/3.
 */

public class SlidingMenu extends HorizontalScrollView {

    private LinearLayout mWapper;
    private ViewGroup mMenu;
    private ViewGroup mContent;
    private int mScreeenWidth;
    private int mMenuWidth;
    private int mMenuRightPadding = 50;
    private boolean once;
    private boolean isopen;

    public SlidingMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);

        mScreeenWidth = outMetrics.widthPixels;

        mMenuRightPadding= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,50,context.getResources().getDisplayMetrics());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(!once){
            mWapper= (LinearLayout) getChildAt(0);
            mMenu= (ViewGroup) mWapper.getChildAt(0);
            mContent= (ViewGroup) mWapper.getChildAt(1);

            mMenuWidth=mMenu.getLayoutParams().width=mScreeenWidth-mMenuRightPadding;
            mContent.getLayoutParams().width=mScreeenWidth;
            once = true;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {


        super.onLayout(changed, l, t, r, b);
        if(changed){
            this.scrollTo(mMenuWidth,0);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action=ev.getAction();
        switch (action){
            case MotionEvent.ACTION_UP:
                int scrollx=getScrollX();
                if(scrollx>=mMenuWidth/2){
                    this.smoothScrollTo(mMenuWidth,0);
                    isopen=false;
                }else{
                    this.smoothScrollTo(0,0);
                    isopen=true;
                }
                return true;
        }
        return super.onTouchEvent(ev);
    }

    public void openMenu(){
        if (isopen)return;
        this.smoothScrollTo(0,0);
        isopen=true;
    }
    public void closeMenu(){
        if (!isopen)return;
        this.smoothScrollTo(mMenuWidth,0);
        isopen=false;

    }
    public void toggle(){
        if (isopen){
            closeMenu();
        }else{
            openMenu();
        }
    }
}
