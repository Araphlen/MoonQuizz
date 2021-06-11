package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.moonquizz.controler.controller;
import com.example.moonquizz.model.questions;

public class Gagne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gagne);
        init();
    }
    private controller controller;

    public void init(){
        this.controller =this.controller.getInstance(this);
        retour();

        if(controller.nextQuestion()){
            next();
        } else{
            retourLvl();
        }
    }

    private void retour(){
        findViewById(R.id.retour).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Gagne.this,ListeQuestion.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void next(){

        Bundle extras = getIntent().getExtras();
        String page= extras.getString("PAGE");
        findViewById(R.id.suiv).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                questions quest=controller.getCurrentQuest();
                questions next=controller.selectNextQuestion(quest.getMatiere(),quest.getNiveau(),quest.getNum());
                controller.setCurrentQuest(next);
                if(page.equals("VF")){
                    Intent intent = new Intent(Gagne.this,VraiFaux.class);
                    finish();
                    startActivity(intent);
                } else{

                    Intent intent = new Intent(Gagne.this,QCM.class);
                    finish();
                    startActivity(intent);
                }

            }
        });
    }
    private void retourLvl(){

        findViewById(R.id.suiv).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Gagne.this,Niveau.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Toast.makeText(Gagne.this, "Vous avez terminé les questions de ce niveau", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }
}