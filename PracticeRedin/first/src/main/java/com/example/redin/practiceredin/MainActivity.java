package com.example.redin.practiceredin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView mInfoTextView;
    private EditText mNameText, mEmailText, mPhoneText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInfoTextView = (TextView)findViewById(R.id.infoText);
        mNameText = (EditText)findViewById(R.id.nameText);
        mEmailText = (EditText)findViewById(R.id.emailText);
        mPhoneText = (EditText)findViewById(R.id.phoneText);

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

    public void onClick(View view) {
        if(isValidEmail(mEmailText.getText()) && isValidPhone(mPhoneText.getText())) {
            mInfoTextView.setText(getString(R.string.name) + ": " + mNameText.getText() + "\n" + getString(R.string.email) + ": "
                    + mEmailText.getText() + "\n" + getString(R.string.phone) + ": " + mPhoneText.getText());

            Toast.makeText(getApplicationContext(), mInfoTextView.getText(), Toast.LENGTH_LONG).show();

            mNameText.setText("");
            mEmailText.setText("");
            mPhoneText.setText("");
        }

        else{
            String emailError = "", phoneError = "";

            if(!isValidEmail(mEmailText.getText()))
                emailError = getString(R.string.invalidEmail);

            if(!isValidPhone(mPhoneText.getText()))
                phoneError = getString(R.string.invalidPhone);

            mInfoTextView.setText(emailError + phoneError);

            Toast.makeText(getApplicationContext(), mInfoTextView.getText(), Toast.LENGTH_LONG).show();
        }

    }

    public boolean isValidEmail(CharSequence email){
        if (email == null) {
            return false;
        } else {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
    }

    public boolean isValidPhone(CharSequence number){
        if (number == null) {
            return false;
        } else {
            return Patterns.PHONE.matcher(number).matches();
        }
    }
}
