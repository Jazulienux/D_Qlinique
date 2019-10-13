package com.example.qliniue.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qliniue.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void handleRegistration(View view) {
        Intent i = new Intent(Login.this, Registration.class);
        startActivity(i);
    }

    public void handleApp(View view){
            Intent i = new Intent(Login.this, MainActivity.class);
            startActivity(i);
    }
}
