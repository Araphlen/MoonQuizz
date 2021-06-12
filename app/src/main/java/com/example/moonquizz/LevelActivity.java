package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.moonquizz.controler.controller;

public class LevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private controller controller;

    private void init(){
        //On récupère le controller
        this.controller = controller.getInstance(this);
        TextView theme=findViewById(R.id.theme);
        theme.setText(controller.getCurrentTheme());
        avatar();
        retour();
        niveau1();
        niveau2();
    }

    //Renvoie au bouton avatar
    private void avatar() {
        //Récupération de l'avatar de l'utilisateur
        String name = controller.getCurrentUser().getAvatar();
        int id = getResources().getIdentifier(name, "drawable", LevelActivity.this.getPackageName());
        Drawable drawable = getResources().getDrawable(id);
        ImageButton button = findViewById(R.id.avatar);
        button.setImageDrawable(drawable);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this, AvatarActivity.class);
                String page = "niveau";
                intent.putExtra("PAGE", page);
                startActivity(intent);
            }
        });
    }

    //Renvoie a la liste des thèmes
        private void retour(){
            findViewById(R.id.retour).setOnClickListener(new  View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(LevelActivity.this, ThemeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            });
        }
//Création du bouton 1
    private void niveau1(){
        findViewById(R.id.lvl1).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                //Selectionne le niveau actuel
                controller.setCurrentLvl(1);
                Intent intent = new Intent(LevelActivity.this, QuestListActivity.class);
                startActivity(intent);
            }
        });
    }
    //Création du bouton 1
    private void niveau2(){
        findViewById(R.id.lvl2).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                //Selectionne le niveau actuel
                controller.setCurrentLvl(2);
                Intent intent = new Intent(LevelActivity.this, QuestListActivity.class);
                startActivity(intent);
            }
        });
    }





}