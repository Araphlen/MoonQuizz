package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.moonquizz.controler.controler;

public class Niveau extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveau);
        init();
    }

    private controler controler;

    private void init(){
        this.controler= controler.getInstance(this);
        TextView theme=findViewById(R.id.theme);
        theme.setText(controler.getCurrentTheme());
        avatar();
        retour();
        niveau1();
        niveau2();
    }


    private void avatar() {
        String name = controler.getCurrentUser().getAvatar();
        int id = getResources().getIdentifier(name, "drawable", Niveau.this.getPackageName());
        Drawable drawable = getResources().getDrawable(id);
        ImageButton button = findViewById(R.id.avatar);
        button.setImageDrawable(drawable);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Niveau.this, ChangeAvatar.class);
                String page = "niveau";
                intent.putExtra("PAGE", page);
                startActivity(intent);
            }
        });
    }

        private void retour(){
            findViewById(R.id.retour).setOnClickListener(new  View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(Niveau.this,ThemePage.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            });
        }

    private void niveau1(){
        findViewById(R.id.lvl1).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                controler.setCurrentLvl(1);
                Intent intent = new Intent(Niveau.this,ListeQuestion.class);
                startActivity(intent);
            }
        });
    }

    private void niveau2(){
        findViewById(R.id.lvl2).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                controler.setCurrentLvl(2);
                Intent intent = new Intent(Niveau.this,ListeQuestion.class);
                startActivity(intent);
            }
        });
    }





}