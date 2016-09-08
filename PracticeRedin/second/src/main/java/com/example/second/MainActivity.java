package com.example.second;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mFirstValue, mSecondValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstValue = (EditText)findViewById(R.id.firstEdit);
        mSecondValue = (EditText)findViewById(R.id.secondEdit);


        mFirstValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if (!mFirstValue.getText().toString().equals(""))
                        mSecondValue.setEnabled(false);
                    else
                        mSecondValue.setEnabled(true);
                }
            }
        });

        mSecondValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if (!mSecondValue.getText().toString().equals(""))
                        mFirstValue.setEnabled(false);
                    else
                        mFirstValue.setEnabled(true);
                }
            }
        });

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onConvertButtonClick(View view) {
        if(!mFirstValue.getText().toString().equals("")) {
            mSecondValue.setText(String.valueOf(Integer.parseInt(mFirstValue.getText().toString()) * 10));
            mFirstValue.setEnabled(false);
            mSecondValue.setEnabled(false);
        }
        else if(!mSecondValue.getText().toString().equals("")) {
            mFirstValue.setText(String.valueOf(Integer.parseInt(mSecondValue.getText().toString()) / 10));
            mFirstValue.setEnabled(false);
            mSecondValue.setEnabled(false);
        }
    }

    public void onClearButtonClick(View view) {
        mFirstValue.setText("");
        mFirstValue.setEnabled(true);

        mSecondValue.setText("");
        mSecondValue.setEnabled(true);
    }
}
