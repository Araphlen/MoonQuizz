package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.moonquizz.controler.controller;

public class Perdu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perdu);
        init();
    }

    private controller controller;

    public void init(){
        this.controller =this.controller.getInstance(this);
        retour();
        retry();
    }

    private void retour(){
        findViewById(R.id.retour).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Perdu.this,ListeQuestion.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    private void retry(){
        Bundle extras = getIntent().getExtras();
        String page= extras.getString("PAGE");
        findViewById(R.id.retry).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                if(page.equals("VF")){
                    Intent intent = new Intent(Perdu.this,VraiFaux.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else{
                    Intent intent = new Intent(Perdu.this,QCM.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }

            }
        });
    }
}