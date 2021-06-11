package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.*;
import android.widget.TextView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.moonquizz.controler.controller;

public class SignPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_page);
        this.controller = controller.getInstance(this);
        inscrire();
        retour();
    }

    private controller controller;


    private void inscrire(){
        findViewById(R.id.valider).setOnClickListener(new  View.OnClickListener() {
         public void onClick(View v){
                String nom="";
                String prenom="";
                try {
                    TextView repnom=findViewById(R.id.nom);
                    nom=repnom.getText().toString();
                    TextView repprenom=findViewById(R.id.prenom);
                    prenom=repprenom.getText().toString();
                }catch (Exception e){
                }
                if(nom.equals("") || prenom.equals("")){
                    Toast.makeText(SignPage.this, "Veuillez saisir un Nom et un Prenom", Toast.LENGTH_LONG).show();
                } else{
                    ajout(prenom, nom);
                    Intent intent= new Intent(SignPage.this, ThemePage.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void ajout(String prenom, String nom){
        this.controller.ajoutUtilisateur(prenom, nom, "avatar");

    }

    private void retour(){
        findViewById(R.id.home).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SignPage.this,StartPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}