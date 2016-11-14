package com.rachedisarfaraz.project4a;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fabButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_hw = (TextView) findViewById(R.id.tv_hello_word);

        //Setup of Fab button
        fabButton = (FloatingActionButton) findViewById(R.id.fab);

        String now = DateUtils.formatDateTime(getApplicationContext(), (new Date()).getTime(), DateFormat.FULL);
        tv_hw.setText(now);

        Button nextAct = (Button) findViewById(R.id.btn_hello_world);

        nextAct.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Next activity", Toast.LENGTH_SHORT).show();
                Intent nextAct =new Intent(MainActivity.this, ListActivity.class);
                startActivity(nextAct);
            }
        });

        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListActivity.class));
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);

        /*String hist = null;

        switch(id) {
            case R.id.action_new :
                hist = getResources().getString(R.string.toast_new);
                break;
            case R.id.action_edit :
                hist = getResources().getString(R.string.toast_edit);
                break;
            case R.id.action_delete :
                hist = getResources().getString(R.string.toast_delete);
                break;
            default:
        }

        Context context = getApplicationContext();
        Toast msg = Toast.makeText(context, hist, Toast.LENGTH_LONG);
        msg.setGravity(Gravity.CENTER, msg.getXOffset() / 2, msg.getYOffset() / 2);
        msg.show();*/
        
        return true;
    }
}
