package com.example.basiclogins;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.basiclogins.LoginActivity.INTENT_CODE;
import static com.example.basiclogins.LoginActivity.PASSWORD_CONST;
import static com.example.basiclogins.LoginActivity.USERNAME_CONST;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText editTextUser, editTextPass, editTextConfirmPass, editTextEmail, editTextName;
    private Button buttonCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        wireWidgets();
        editTextUser.setText(getIntent().getStringExtra(USERNAME_CONST));
        editTextPass.setText(getIntent().getStringExtra(PASSWORD_CONST));
        buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra(USERNAME_CONST, editTextUser.getText().toString());
                returnIntent.putExtra(PASSWORD_CONST, editTextPass.getText().toString());
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });
    }

    private void wireWidgets() {
        editTextUser = findViewById(R.id.edittext_create_account_username);
        editTextPass = findViewById(R.id.edittext_create_account_password);
        editTextConfirmPass = findViewById(R.id.edittext_create_account_confirm_pass);
        editTextEmail = findViewById(R.id.edittext_create_account_email);
        editTextName = findViewById(R.id.edittext_create_account_name);
        buttonCreateAccount = findViewById(R.id.button_create_account_create);
    }

}
