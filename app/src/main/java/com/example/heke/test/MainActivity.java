package com.example.heke.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    //    static {
//        System.loadLibrary("mytest");
//    }
//    public native String getStringFromNative();
MyScrollView myScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       TextView jniTestTv = (TextView) findViewById(R.id.jnitest_tv);
//        jniTestTv.setText(getStringFromNative());
//        Log.d("MainActivity",getStringFromNative()+"duabg");
        myScrollView = (MyScrollView) findViewById(R.id.myscrollview);
        jniTestTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) myScrollView.getLayoutParams();
                layoutParams.topMargin =layoutParams.topMargin-100;
                myScrollView.setLayoutParams(layoutParams);
                Log.d(TAG, "onClick: layoutParams.topMargin;"+layoutParams.topMargin);
                Log.d(TAG, "onClick: layoutParams.getY;"+myScrollView.getY());
                Log.d(TAG, "onClick: layoutParams.getY;"+myScrollView.getTop());
//                myScrollView.scrollBy(0,190);
            }
        });
        myScrollView.setOnsroll(new MyScrollView.Onsroll() {
            @Override
            public void scrollDistacke(float distanceY) {

            }
        });

    }


}
