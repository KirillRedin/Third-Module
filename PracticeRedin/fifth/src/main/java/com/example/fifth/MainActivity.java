package com.example.fifth;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random mRandom = new Random();
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView)findViewById(R.id.imageView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.genji:
                mImageView.setImageResource(R.drawable.genji);
                break;
            case R.id.dva:
                mImageView.setImageResource(R.drawable.dva);
                break;
            case R.id.mercy:
                mImageView.setImageResource(R.drawable.mercy);
                break;
            case R.id.mei:
                mImageView.setImageResource(R.drawable.mei);
                break;
            case R.id.reaper:
                mImageView.setImageResource(R.drawable.reaper);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onRandomizeButtonClick(View view) {
        int id = mRandom.nextInt(5);
        switch(id){
            case 0:
                mImageView.setImageResource(R.drawable.dva);
                break;
            case 1:
                mImageView.setImageResource(R.drawable.genji);
                break;
            case 2:
                mImageView.setImageResource(R.drawable.mei);
                break;
            case 3:
                mImageView.setImageResource(R.drawable.mercy);
                break;
            case 4:
                mImageView.setImageResource(R.drawable.reaper);
                break;
        }
    }
}
