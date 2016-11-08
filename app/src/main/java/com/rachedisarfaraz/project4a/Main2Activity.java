package com.rachedisarfaraz.project4a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.list, new BlankFragment())
                .commit()
        ;
    }
}
