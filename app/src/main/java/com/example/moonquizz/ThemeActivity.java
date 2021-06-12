package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.moonquizz.controler.controller;

public class ThemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        init();
    }

    private controller controller;

    private void init(){
        this.controller = controller.getInstance(this);
        retour();
        themeGeo();
        themeHist();
        themeAni();
        themeFra();
        themeMyt();
        themeSci();
        themeMath();
        avatar();
    }

    //Renvoie a la page de base
    private void retour(){
        findViewById(R.id.home).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ThemeActivity.this, StartActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    //Renvoie à la page avatar
    private void avatar()    {
        //Récupère l'avatar actuel de l'utilisateur
            String name= controller.getCurrentUser().getAvatar();
            int id = getResources().getIdentifier(name, "drawable", ThemeActivity.this.getPackageName());
            Drawable drawable = getResources().getDrawable(id);
        ImageButton button=findViewById(R.id.avatar);
            button.setImageDrawable(drawable);

        button.setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ThemeActivity.this, AvatarActivity.class);
                String page = "theme";
                intent.putExtra("PAGE", page);
                startActivity(intent);
            }
        });
    }
//Bouton des différents thèmes
    private void themeGeo(){
        findViewById(R.id.Geographie).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                controller.setCurrentTheme("Geographie");
                Intent intent = new Intent(ThemeActivity.this, LevelActivity.class);
                startActivity(intent);
            }
        });
    }
    private void themeHist(){
        findViewById(R.id.Histoire).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                controller.setCurrentTheme("Histoire");
                Intent intent = new Intent(ThemeActivity.this, LevelActivity.class);
                startActivity(intent);
            }
        });
    }
    private void themeSci(){
        findViewById(R.id.Science).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                controller.setCurrentTheme("Science");
                Intent intent = new Intent(ThemeActivity.this, LevelActivity.class);
                startActivity(intent);
            }
        });
    }
    private void themeAni(){
        findViewById(R.id.Animaux).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                controller.setCurrentTheme("Animaux");
                Intent intent = new Intent(ThemeActivity.this, LevelActivity.class);
                startActivity(intent);
            }
        });
    }
    private void themeFra(){
        findViewById(R.id.Francais).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                controller.setCurrentTheme("Francais");
                Intent intent = new Intent(ThemeActivity.this, LevelActivity.class);
                startActivity(intent);
            }
        });
    }
    private void themeMyt(){
        findViewById(R.id.Mythologie).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                controller.setCurrentTheme("Mythologie");
                Intent intent = new Intent(ThemeActivity.this, LevelActivity.class);
                startActivity(intent);
            }
        });
    }

    private void themeMath(){
        findViewById(R.id.Mathematique).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ThemeActivity.this, MathActivity.class);
                startActivity(intent);
            }
        });
    }

}