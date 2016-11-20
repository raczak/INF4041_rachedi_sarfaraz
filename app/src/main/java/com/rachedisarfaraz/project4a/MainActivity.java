package com.rachedisarfaraz.project4a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

/*
* Class name : MainActivity
* Class of main activity of the project, activity_main.xml
* Methods :
* -onCreate : Define content view. Set components functions.
* -OnCreateOptionsMenu : Define the main menu bye an inflater.
* -OnOptionsItemSelected : Define menu components functions.
*/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_hw = (TextView) findViewById(R.id.tv_hello_word);

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
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_new:
                Toast.makeText(MainActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_edit:
                Toast.makeText(MainActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_delete:
                Toast.makeText(MainActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
