package com.stream3d.stream3d;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                String stringName = name.getText().toString();
                String stringUser = username.getText().toString();
                String stringPassword = password.getText().toString();
                String stringConfirmPassword = confirmPassword.getText().toString();

                if(!stringPassword.equals(stringConfirmPassword))
                {
                    Toast pass = Toast.makeText(SignUpActivity.this, "Passwords don't match!", Toast.LENGTH_SHORT);
                    pass.show();
                }

            }
        });


    }
}