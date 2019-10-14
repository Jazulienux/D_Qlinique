package com.example.qliniue.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qliniue.R;

public class Login extends AppCompatActivity {

    public static final String USERNAME_KEY = "username";
    public static final String PASSWORD_KEY = "password";

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.txt_username);
        password = findViewById(R.id.txt_password);
    }

    public void handleRegistration(View view) {
        Intent i = new Intent(Login.this, Registration.class);
        startActivity(i);
    }

    public void handleApp(View view){
            String usernameInput = username.getText().toString();
            String passwordInput = password.getText().toString();

            if(!usernameInput.equals("") && !passwordInput.equals("")){
                Bundle bundle = new Bundle();
                bundle.putString("USERNAME_KEY",usernameInput);
                bundle.putString("PASSWORD_KEY",passwordInput);
                Intent i = new Intent(Login.this, MainActivity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
            else{
                Toast.makeText(this,"Username / Password Tidak Boleh Kosong",Toast.LENGTH_SHORT).show();
            }

    }
}
