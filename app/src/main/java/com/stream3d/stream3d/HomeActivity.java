package com.stream3d.stream3d;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);

            //Button openGame = (Button) findViewById(R.id.openGame);

            //get the intent
            Intent intent = getIntent();
            Bundle extra = intent.getExtras();

            Button selectionButton = (Button) findViewById(R.id.selectionButton);

            selectionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //save the data input
                    Intent intent = new Intent(HomeActivity.this, WelcomeActivity.class);
                    //intent.putExtras(extra);
                    startActivity(intent);
                }
            });

        }
}
