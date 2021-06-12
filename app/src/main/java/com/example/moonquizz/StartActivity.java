package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        inscrire();
        connecter();
    }

    //Envoie a la page connexion
    private void connecter(){
        findViewById(R.id.login).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                    Intent intent = new Intent(StartActivity.this, LoginActivity.class);
                    startActivity(intent);
            }
        });
    }
    //Envoie à la page inscrire
    private void inscrire(){
        findViewById(R.id.sign).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, SignActivity.class);
                startActivity(intent);
            }
        });
    }
}