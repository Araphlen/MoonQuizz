package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.moonquizz.controler.controller;
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


    private controller controller;

    private void init(){
        this.controller = controller.getInstance(this);
        questions quest= controller.getCurrentQuest();
        String enonce = quest.getQuestion();

        TextView theme=findViewById(R.id.question);
        theme.setText(enonce);
        genRep();
    }

    private void genRep(){
        int n=2;

        int id;
        int[] idButton = new int[2];

        idButton[0]=R.id.rep0;
        idButton[1]=R.id.rep1;
        Random random= new Random() ;
        ArrayList<String> listRep;
        listRep= controller.recupListeRep();
        int size=listRep.size();
        for(int i=0; i<size; i++){
            if(n==0){
                id=0;
            } else {
                id = random.nextInt(n);
            }

           String rep=listRep.get(id);

           Button reponse=findViewById(idButton[i]);
           reponse.setText(rep);

           if(rep.equals(controller.getCurrentQuest().getReponse())){
               reponse.setOnClickListener(new  View.OnClickListener() {
                   public void onClick(View v) {
                        controller.valideQuest();
                       Intent intent = new Intent(VraiFaux.this,Gagne.class);
                       String page = "VF";
                       intent.putExtra("PAGE", page);
                       finish();
                       startActivity(intent);
                   }
               });
           } else{
               reponse.setOnClickListener(new  View.OnClickListener() {
                   public void onClick(View v) {
                       Intent intent = new Intent(VraiFaux.this,Perdu.class);
                       String page = "VF";
                       intent.putExtra("PAGE", page);
                       finish();
                       startActivity(intent);
                   }
               });
           }
        n=n-1;
           listRep.remove(id);
        }
    }
}