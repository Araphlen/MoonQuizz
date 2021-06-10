package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moonquizz.controler.controler;
import com.example.moonquizz.model.questions;

import java.util.ArrayList;

public class ListeQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_question);
        init();
    }

    private controler controler;

    private void init(){
        this.controler= controler.getInstance(this);
        retour();
        avatar();

        String currentTheme=controler.getCurrentTheme();
        int lvl=controler.getCurrentLvl();
        TextView theme=findViewById(R.id.theme);
        theme.setText(currentTheme);

        TextView niveau=findViewById(R.id.lvl);
        niveau.setText("Niveau "+lvl);

        ArrayList<questions> listeQuest;
        listeQuest = this.controler.recupListeQuest();
        LinearLayout layout= findViewById(R.id.question);


        Boolean valide=true;
        for (int i=0; i<listeQuest.size(); i++){

            //Création du bouton de choix de question
            questions quest=listeQuest.get(i);

            Button Butquestion= new Button(this);
            Butquestion.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
            Butquestion.setText("Question n°"+quest.getNum());
            int id = listeQuest.get(i).getId();
            Butquestion.setTag(id);
            Butquestion.setTextColor(Color.parseColor("#ffffff"));

            //Ajout de la séparation

            TextView separation = new TextView(this);
            separation.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));

            layout.addView(Butquestion);
            layout.addView(separation);

            //Ajout de la fonction au bouton
            if(valide){
                Butquestion.setOnClickListener(new  View.OnClickListener() {
                    public void onClick(View v) {
                        controler.setCurrentQuest(quest);
                        if(quest.getNiveau()==1){
                            Intent intent = new Intent(ListeQuestion.this,VraiFaux.class);
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(ListeQuestion.this,QCM.class);
                            startActivity(intent);
                        }
                    }
                });

                Butquestion.setBackgroundColor(Color.parseColor("#738b28"));
                if(!controler.verifQuest(quest.getId(),controler.getCurrentUser().getId())){
                    valide=false;
                    Butquestion.setBackgroundColor(Color.parseColor("#0000FF"));
                }
            }else{
                Butquestion.setBackgroundColor(Color.parseColor("#8b0000"));
                Butquestion.setOnClickListener(new  View.OnClickListener() {
                    public void onClick(View v) {
                        Toast.makeText(ListeQuestion.this, "Il faut d'abord terminer les questions précédentes", Toast.LENGTH_LONG).show();
                    }
                });

            }
        }



    }


    private void retour(){
        findViewById(R.id.retour).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ListeQuestion.this,Niveau.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void avatar() {
        String name = controler.getCurrentUser().getAvatar();
        int id = getResources().getIdentifier(name, "drawable", ListeQuestion.this.getPackageName());
        Drawable drawable = getResources().getDrawable(id);
        ImageButton button = findViewById(R.id.avatar);
        button.setImageDrawable(drawable);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ListeQuestion.this, ChangeAvatar.class);
                String page = "quest";
                intent.putExtra("PAGE", page);
                startActivity(intent);
            }
        });
    }

}