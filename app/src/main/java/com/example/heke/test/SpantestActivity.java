package com.example.heke.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;

public class SpantestActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView testTestTV;
    private TextView testBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spantest);
        initView();
    }

    private void initView() {

        testTestTV = (TextView) findViewById(R.id.testTestTV);
        testBtn = (TextView) findViewById(R.id.testBtn);
        testBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.testBtn:
                SpannableString spannableString  = new SpannableString("niahoge");
               String string =  spannableString.toString();
               testTestTV.setText(string);
                break;
        }

    }
}
