package com.abe.sztest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private CircleView circleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CircleView circleView = new CircleView(this, 20);
        setContentView(circleView);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.graph:
                circleView = null;
                circleView = new CircleView(this, 10);
                setContentView(circleView);
                break;

            case R.id.save:
                circleView = null;
                circleView = new CircleView(this, 20);
                setContentView(circleView);
                break;

            case R.id.exit:
                circleView = null;
                circleView = new CircleView(this, 30);
                setContentView(circleView);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
