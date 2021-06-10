package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moonquizz.controler.controler;
import com.example.moonquizz.model.questions;

import java.util.ArrayList;
import java.util.Random;

public class VraiFaux extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vrai_faux);
        init();
    }


    private controler controler;

    private void init(){
        this.controler= controler.getInstance(this);
        questions quest= controler.getCurrentQuest();
        String enonce = quest.getQuestion();

        TextView theme=findViewById(R.id.question);
        theme.setText(enonce);
        genRep();
    }

    private void genRep(){
        int n=1;
        int id;
        int[] idButton = new int[2];

        idButton[0]=R.id.rep0;
        idButton[1]=R.id.rep1;
        Random random= new Random() ;
        ArrayList<String> listRep;
        listRep=controler.recupListeRep();
        for(int i=0; i<listRep.size(); i++){
            if(n==0){
                id=0;
            } else {
                id = random.nextInt(n);
            }

           String rep=listRep.get(id);

           Button reponse=findViewById(idButton[i]);
           reponse.setText(rep);

           if(rep.equals(controler.getCurrentQuest().getReponse())){
               reponse.setOnClickListener(new  View.OnClickListener() {
                   public void onClick(View v) {
                        controler.valideQuest();
                       Intent intent = new Intent(VraiFaux.this,Gagne.class);
                       startActivity(intent);
                   }
               });
           } else{
               reponse.setOnClickListener(new  View.OnClickListener() {
                   public void onClick(View v) {
                       Intent intent = new Intent(VraiFaux.this,Perdu.class);
                       startActivity(intent);
                   }
               });
           }
        n=n-1;
           listRep.remove(id);
        }
    }
}