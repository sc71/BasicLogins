package com.example.basiclogins;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static final int INTENT_CODE = 1;
    public static final String USERNAME_CONST = "username";
    public static final String PASSWORD_CONST = "password";

    private EditText editTextUsername, editTextPassword;
    private TextView textViewNew;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        wireWidgets();
        setListeners();
    }

    private void setListeners() {
        textViewNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("look here", "onClick: ");
                Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);
                intent.putExtra(USERNAME_CONST, editTextUsername.getText().toString());
                intent.putExtra(PASSWORD_CONST, editTextPassword.getText().toString());
                startActivityForResult(intent, INTENT_CODE);
            }
        });
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextUsername.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "enter a username", Toast.LENGTH_SHORT).show();
                }
                else if(editTextPassword.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "enter a password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void wireWidgets() {
        editTextPassword = findViewById(R.id.edittext_login_pass);
        editTextUsername = findViewById(R.id.edittext_login_user);
        textViewNew = findViewById(R.id.textview_text_new_acount);
        buttonLogin = findViewById(R.id.button_login_login);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == INTENT_CODE) {
            if (resultCode == RESULT_OK) {
                editTextUsername.setText(data.getStringExtra(USERNAME_CONST));
                editTextPassword.setText(data.getStringExtra(PASSWORD_CONST));
            }
        }
    }

}
