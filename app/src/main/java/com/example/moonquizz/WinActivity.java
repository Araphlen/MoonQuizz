package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.moonquizz.controler.controller;
import com.example.moonquizz.model.questions;

public class WinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        init();
    }
    private controller controller;

    public void init(){
        //On récupère le controller
        this.controller =this.controller.getInstance(this);
        retour();

        //Vérifie si on arrive à la fin de la liste des questions de ce niveau
        if(controller.nextQuestion()){
            next();
        } else{
            retourLvl();
        }
    }
    //Bouton retour à la liste des question
    private void retour(){
        findViewById(R.id.retour).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(WinActivity.this, QuestListActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    //Bouton question suivante
    private void next(){

        Bundle extras = getIntent().getExtras();
        String page= extras.getString("PAGE");
        findViewById(R.id.suiv).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                //On récupère la question suivante
                questions quest=controller.getCurrentQuest();
                questions next=controller.selectNextQuestion(quest.getMatiere(),quest.getNiveau(),quest.getNum());
                controller.setCurrentQuest(next);
                //On vérifie sur quelle page renvoyer en focntion de la question
                if(page.equals("VF")){
                    Intent intent = new Intent(WinActivity.this, TrueFalseActivity.class);
                    finish();
                    startActivity(intent);
                } else{

                    Intent intent = new Intent(WinActivity.this, MCQActivity.class);
                    finish();
                    startActivity(intent);
                }

            }
        });
    }

    //Renvoie à la liste des niveaux
    private void retourLvl(){

        findViewById(R.id.suiv).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(WinActivity.this, LevelActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Toast.makeText(WinActivity.this, "Vous avez terminé les questions de ce niveau", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }
}