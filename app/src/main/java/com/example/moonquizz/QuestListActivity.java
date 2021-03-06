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

import com.example.moonquizz.controler.controller;
import com.example.moonquizz.model.questions;

import java.util.ArrayList;

public class QuestListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_list);
        init();
    }

    private controller controller;

    private void init(){
        //On récupère le controller
        this.controller = controller.getInstance(this);
        retour();
        avatar();

        String currentTheme= controller.getCurrentTheme();
        int lvl= controller.getCurrentLvl();
        TextView theme=findViewById(R.id.theme);
        theme.setText(currentTheme);

        TextView niveau=findViewById(R.id.lvl);
        niveau.setText("Niveau "+lvl);

        ArrayList<questions> listeQuest;
        listeQuest = this.controller.recupListeQuest();
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
            //Couleur bleu naturelle
            Butquestion.setTextColor(Color.parseColor("#ffffff"));

            //Ajout de la séparation

            TextView separation = new TextView(this);
            separation.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));

            layout.addView(Butquestion);
            layout.addView(separation);

            //Ajout de la fonction au bouton

            //Si la question a été validé
            if(valide){
                Butquestion.setOnClickListener(new  View.OnClickListener() {
                    public void onClick(View v) {
                        //Selectionne de la question actuelle
                        controller.setCurrentQuest(quest);
                        if(quest.getNiveau()==1){
                            Intent intent = new Intent(QuestListActivity.this, TrueFalseActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(QuestListActivity.this, MCQActivity.class);
                            startActivity(intent);
                        }
                    }
                });
                //on met la couleur en vert
                Butquestion.setBackgroundColor(Color.parseColor("#738b28"));

                //Sinon, on laisse la question disponible et on bloque les questions suivantes
                if(!controller.verifQuest(quest.getId(), controller.getCurrentUser().getId())){
                    valide=false;
                    Butquestion.setBackgroundColor(Color.parseColor("#0000FF"));
                }
            }else{
                //Affichage d'un message d'erreur pour lors de la selection, et changement de couleur en rouge
                Butquestion.setBackgroundColor(Color.parseColor("#8b0000"));
                Butquestion.setOnClickListener(new  View.OnClickListener() {
                    public void onClick(View v) {
                        Toast.makeText(QuestListActivity.this, "Il faut d'abord terminer les questions précédentes", Toast.LENGTH_LONG).show();
                    }
                });

            }
        }



    }

    //Bouton retour a la liste des niveau
    private void retour(){
        findViewById(R.id.retour).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(QuestListActivity.this, LevelActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void avatar() {
        String name = controller.getCurrentUser().getAvatar();
        int id = getResources().getIdentifier(name, "drawable", QuestListActivity.this.getPackageName());
        Drawable drawable = getResources().getDrawable(id);
        ImageButton button = findViewById(R.id.avatar);
        button.setImageDrawable(drawable);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(QuestListActivity.this, AvatarActivity.class);
                String page = "quest";
                intent.putExtra("PAGE", page);
                startActivity(intent);
            }
        });
    }

}