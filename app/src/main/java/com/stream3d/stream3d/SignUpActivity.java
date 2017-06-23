package com.stream3d.stream3d;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Intent intent = getIntent();
        final Bundle extra = intent.getExtras();

        final EditText name = (EditText) findViewById(R.id.name);
        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);
        final EditText confirmPassword = (EditText) findViewById(R.id.ConfirmPassword);
        Button authUser = (Button) findViewById(R.id.signUpButton);

        authUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //save the data input
                extra.putString("name", name.getText().toString());
                extra.putString("username", username.getText().toString());
                extra.putString("password", password.getText().toString());
                extra.putString("confirmPassword", confirmPassword.getText().toString());
                Intent intent = new Intent(SignUpActivity.this, WelcomeActivity.class);
                intent.putExtras(extra);
                startActivity(intent);
            }
        });


    }
}