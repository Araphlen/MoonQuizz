package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.moonquizz.controler.controller;

public class LostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);
        init();
    }

    private controller controller;

    public void init(){
        //On récupère le controller
        this.controller =this.controller.getInstance(this);
        retour();
        retry();
    }

    //Bouton retrour à la liste des questions
    private void retour(){
        findViewById(R.id.retour).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(LostActivity.this, QuestListActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    //Bouton retry
    private void retry(){
        Bundle extras = getIntent().getExtras();
        String page= extras.getString("PAGE");
        findViewById(R.id.retry).setOnClickListener(new  View.OnClickListener() {
            //On vérifie sur quelle page envoyer
            public void onClick(View v) {
                if(page.equals("VF")){
                    Intent intent = new Intent(LostActivity.this, TrueFalseActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else{
                    Intent intent = new Intent(LostActivity.this, MCQActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }

            }
        });
    }
}