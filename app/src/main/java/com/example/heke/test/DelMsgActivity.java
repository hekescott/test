package com.example.heke.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DelMsgActivity extends AppCompatActivity implements View.OnClickListener {

//    private MessageDelLayout messageDelLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delmsg);
        findViewById(R.id.close).setOnClickListener(this);
        findViewById(R.id.open).setOnClickListener(this);
//        messageDelLayout = (MessageDelLayout) findViewById(R.id.messageDelLayout);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.close:
//                messageDelLayout.quickClose();
            break;
            case R.id.open:
//                messageDelLayout.quickOpen();
            break;
        }
    }

}
