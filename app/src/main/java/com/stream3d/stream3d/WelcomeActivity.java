package com.stream3d.stream3d;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView nameuser = (TextView) findViewById(R.id.nameuser);

        //get the intent
        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        String username = extra.getString("username");
        String password = extra.getString("password");

        String pass = db.searchPass(username);
        if(pass.equals(password))
        {
            nameuser.setText("Welcome to Stream3D");

            Toast.makeText(WelcomeActivity.this, "Welcome "+ username + " !", Toast.LENGTH_LONG).show();
            //Intent intentHome = new Intent(WelcomeActivity.this, HomeActivity.class);
            //startActivity(intentHome);
        }
        else{
            nameuser.setText("Authentication failed !");

            Snackbar.make(findViewById(android.R.id.content), "Username or Password is Wrong", Snackbar.LENGTH_LONG)
                    .setAction("Return To Login Page", new View.OnClickListener(){
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                    })
                    .setActionTextColor(Color.BLUE)
                    .show();
        }
    }
}
