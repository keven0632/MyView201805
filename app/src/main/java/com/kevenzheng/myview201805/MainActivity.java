package com.kevenzheng.myview201805;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kevenzheng.myview201805.view.MyProgressView03;
import com.kevenzheng.myview201805.view.MyTextView001;

public class MainActivity extends AppCompatActivity {

    private MyProgressView03 progressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressView = findViewById(R.id.progressView);
        progressView.setProgress(300);

        MyTextView001 view001=new MyTextView001(this);

    }

}
