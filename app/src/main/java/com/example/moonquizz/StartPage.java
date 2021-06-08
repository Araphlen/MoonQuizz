package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        inscrire();
        connecter();
    }

    private void connecter(){
        findViewById(R.id.login).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                    Intent intent = new Intent(StartPage.this, LoginPage.class);
                    startActivity(intent);
            }
        });
    }

    private void inscrire(){
        findViewById(R.id.sign).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(StartPage.this, SignPage.class);
                startActivity(intent);
            }
        });
    }
}