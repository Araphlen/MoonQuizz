package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moonquizz.controler.controller;

public class ResultatActivity extends AppCompatActivity {

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

        int nbRes= controller.nbBonneRep();
        String snbRes=Integer.toString(nbRes);
        TextView nbReponse=findViewById(R.id.nbReponse);
        nbReponse.setText(snbRes+" Bonne(s) réponse(s)");
        Bundle extras = getIntent().getExtras();
        String occur= extras.getString("OCCUR");
        if(occur.equals("premier")){
            corriger();
            TextView essai=findViewById(R.id.essai);
            essai.setText("Vous avez un essai pour vous corriger");
        } else{
            findViewById(R.id.correc).setOnClickListener(new  View.OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(ResultatActivity.this, "Vous n'avez plus d'essai disponible", Toast.LENGTH_LONG).show();
                }
            });
        }
    }


    private void retour(){
        findViewById(R.id.retour).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ResultatActivity.this,Mathematique.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void corriger(){

        findViewById(R.id.correc).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ResultatActivity.this,OperationActivity.class);
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