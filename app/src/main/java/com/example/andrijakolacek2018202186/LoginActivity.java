package com.example.andrijakolacek2018202186;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button buttonLogin2 = findViewById(R.id.buttonLogin2);
        buttonLogin2.setOnClickListener(this);

        Button buttonCancel = findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(this);
        buttonCancel.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonLogin2:
                this.doConfirm();
                break;
            case R.id.buttonCancel:
                this.doCancel();
                break;
        }
    }

    private void doConfirm() {
        String username = ((EditText) findViewById(R.id.inputUsername)).getText().toString();
        String password = ((EditText) findViewById(R.id.inputPassword)).getText().toString();

        if (username.matches("test|test@test.com") && password.matches("test")) {
            startActivity(new Intent(this,StocksActivity.class));
        } else if(username.isEmpty() || password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Username and password should not be empty!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Wrong username or password", Toast.LENGTH_SHORT).show();
        }

    }

    private void doCancel() {
        Toast.makeText(getApplicationContext(),"Press and hold to go back",Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onLongClick(View v) {
        finish();
        return false;
    }
}