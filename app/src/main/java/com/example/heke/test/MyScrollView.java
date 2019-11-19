package com.example.heke.test;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ScrollView;



/**
 * Created by heke on 18/7/4.
 */

public class MyScrollView extends ScrollView {
    String TAG ="MyScrollView";
    GestureDetector gestureDetector;
    DefaultGestureListener defaultGestureListener;
    int totalH;
    Context context;
    Onsroll onsroll;
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {


        super(context, attrs);
        defaultGestureListener = new DefaultGestureListener();
        gestureDetector = new GestureDetector(context,defaultGestureListener);
        this.context =context;
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);



    }

    public void setOnsroll(Onsroll onsroll) {
        this.onsroll = onsroll;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        totalH += getMeasuredHeight();

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
       if( gestureDetector.onTouchEvent(ev)) {
           return true;
       }else {
           return super.onTouchEvent(ev);

       }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    private class DefaultGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }
        /**
         * @param e1 The first down motion event that started the scrolling.
         @param e2 The move motion event that triggered the current onScroll.
         @param distanceX The distance along the X axis(轴) that has been scrolled since the last call to onScroll. This is NOT the distance between e1 and e2.
         @param distanceY The distance along the Y axis that has been scrolled since the last call to onScroll. This is NOT the distance between e1 and e2.
         无论是用手拖动view，或者是以抛的动作滚动，都会多次触发 ,这个方法在ACTION_MOVE动作发生时就会触发 参看GestureDetector的onTouchEvent方法源码
          * */
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2,

                                float distanceX, float distanceY) {

            Log.d(TAG, "onScroll: "+getTop());
            Log.d(TAG, "onScrollY: "+getY());
//          int showH = (int) (DensityUtils.getPhoneheight(context)- getTop());
//           if(totalH>showH){
//               onsroll.scrollDistacke(distanceY);
//               return true;
//           }else {
//               return false;
//           }
            return false;

        }
        /**
         * @param e1 第1个ACTION_DOWN MotionEvent 并且只有一个
         * @param e2 最后一个ACTION_MOVE MotionEvent
         * @param velocityX X轴上的移动速度，像素/秒
         * @param velocityY Y轴上的移动速度，像素/秒
         * 这个方法发生在ACTION_UP时才会触发 参看GestureDetector的onTouchEvent方法源码
         *
         * */
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }
        @Override
        public boolean onDown(MotionEvent e) {
            return false;
        }
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            return false;
        }
        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            return false;
        }
        /**
         * 这个方法不同于onSingleTapUp，他是在GestureDetector确信用户在第一次触摸屏幕后，没有紧跟着第二次触摸屏幕，也就是不是“双击”的时候触发
         * */
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            return false;
        }

    }
    public static interface Onsroll{
        void scrollDistacke(float distanceY);
    }

}
