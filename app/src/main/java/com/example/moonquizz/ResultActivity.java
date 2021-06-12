package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moonquizz.controler.controller;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        init();
    }
    private controller controller;

    public void init(){
        this.controller =this.controller.getInstance(this);
        retour();
        //On récupère le nombre de bonnes réponses
        int nbRes= controller.nbBonneRep();
        String snbRes=Integer.toString(nbRes);
        TextView nbReponse=findViewById(R.id.nbReponse);
        nbReponse.setText(snbRes+" Bonne(s) réponse(s)");
        Bundle extras = getIntent().getExtras();
        String occur= extras.getString("OCCUR");
        //Si l'utilisateur peut se corriger, il peut cliquer sur le bouton
        if(occur.equals("premier")){
            corriger();
            TextView essai=findViewById(R.id.essai);
            essai.setText("Vous avez un essai pour vous corriger");
            //Sinon affiche un message d'erreur
        } else{
            findViewById(R.id.correc).setOnClickListener(new  View.OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(ResultActivity.this, "Vous n'avez plus d'essai disponible", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    //Renvoie a la page Mathematique
    private void retour(){
        findViewById(R.id.retour).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MathActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    //Renvoie à la liste d'opération avec l'occurence 2
    private void corriger(){

        findViewById(R.id.correc).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this,OperationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                String occur="seconde";
                String page="0";
                intent.putExtra("PAGE", page);
                intent.putExtra("OCCUR",occur);
                startActivity(intent);
            }
        });
    }
}