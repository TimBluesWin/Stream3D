package com.stream3d.stream3d;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Bundle extra = new Bundle();

        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);

        Button sendUser = (Button) findViewById(R.id.loginbutton);
        Button signUser = (Button) findViewById(R.id.signupbutton);

        //Create onclick listener here
        sendUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //save the data input
                extra.putString("username", username.getText().toString());
                extra.putString("password", password.getText().toString());
                Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
                intent.putExtras(extra);
                startActivity(intent);
            }
        });

        signUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                intent.putExtras(extra);
                startActivity(intent);
            }
        });
    }
}