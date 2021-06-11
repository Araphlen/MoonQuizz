package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.moonquizz.controler.controller;

public class MainActivity extends AppCompatActivity {

    private controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        demarrer();
        this.controller = controller.getInstance(this);
    }

    private void demarrer(){
        findViewById(R.id.start).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,StartPage.class);
                startActivity(intent);
            }
        });
    }
}