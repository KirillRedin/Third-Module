package com.example.third;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mLayout;
    private Random mRandom = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        switch (item.getItemId()){
            case R.id.addTextView:
                TextView textView = new TextView(this);
                textView.setText(getString(R.string.text) + mRandom.nextInt(255));
                textView.setTextSize(mRandom.nextInt(255)/2);
                textView.setTextColor(Color.rgb(mRandom.nextInt(),mRandom.nextInt(),mRandom.nextInt()));
                textView.setLayoutParams(randomizeParams(params));
                mLayout.addView(textView);
                break;
            case R.id.addButton:
                Button button = new Button(this);
                button.setText(getString(R.string.text) + mRandom.nextInt(255));
                button.setTextSize(mRandom.nextInt(255)/2);
                button.setTextColor(Color.rgb(mRandom.nextInt(),mRandom.nextInt(),mRandom.nextInt()));
                button.setLayoutParams(randomizeParams(params));
                mLayout.addView(button);
                break;
            case R.id.addEditText:
                EditText editText = new EditText(this);
                editText.setText(getString(R.string.text) + mRandom.nextInt(255));
                editText.setTextSize(mRandom.nextInt(255)/2);
                editText.setTextColor(Color.rgb(mRandom.nextInt(),mRandom.nextInt(),mRandom.nextInt()));
                editText.setLayoutParams(randomizeParams(params));
                mLayout.addView(editText);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public RelativeLayout.LayoutParams randomizeParams(RelativeLayout.LayoutParams params){
        params.leftMargin = mRandom.nextInt(255);
        params.rightMargin = mRandom.nextInt(255);
        params.topMargin = mRandom.nextInt(255);
        params.bottomMargin = mRandom.nextInt(255);

        return params;
    }
}
