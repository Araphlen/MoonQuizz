package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;
import android.view.*;
import android.widget.TextView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.moonquizz.controler.controler;

public class SignPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_page);
        this.controler= controler.getInstance(this);
    }

    private controler controler;


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
                if(nom == "" || prenom == ""){
                    Toast.makeText(SignPage.this, "Veuillez saisir un Nom et un Prenom", Toast.LENGTH_LONG).show();
                } else{
                    ajout(nom, prenom);
                }
            }
        });
    }

    private void ajout(String nom, String prenom){
        this.controler.ajoutUtilisateur(nom, prenom, "");

    }
}