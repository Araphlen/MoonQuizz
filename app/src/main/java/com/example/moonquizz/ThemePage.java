package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.moonquizz.controler.controler;

import java.lang.reflect.Field;

public class ThemePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_page);
        init();
    }

    private controler controler;

    private void init(){
        this.controler= controler.getInstance(this);
        retour();
        themeGeo();
        themeHist();
        themeAni();
        themeFra();
        themeMyt();
        themeSci();
        avatar();
    }


    private void retour(){
        findViewById(R.id.home).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ThemePage.this,StartPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void avatar()    {
            String name= controler.getCurrentUser().getAvatar();
            int id = getResources().getIdentifier(name, "drawable", ThemePage.this.getPackageName());
            Drawable drawable = getResources().getDrawable(id);
        ImageButton button=findViewById(R.id.avatar);
            button.setImageDrawable(drawable);

        button.setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ThemePage.this,ChangeAvatar.class);
                String page = "theme";
                intent.putExtra("PAGE", page);
                startActivity(intent);
            }
        });
    }

    private void themeGeo(){
        findViewById(R.id.Geographie).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                controler.setCurrentTheme("Geographie");
                Intent intent = new Intent(ThemePage.this,Niveau.class);
                startActivity(intent);
            }
        });
    }
    private void themeHist(){
        findViewById(R.id.Histoire).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                controler.setCurrentTheme("Histoire");
                Intent intent = new Intent(ThemePage.this,Niveau.class);
                startActivity(intent);
            }
        });
    }
    private void themeSci(){
        findViewById(R.id.Science).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                controler.setCurrentTheme("Science");
                Intent intent = new Intent(ThemePage.this,Niveau.class);
                startActivity(intent);
            }
        });
    }
    private void themeAni(){
        findViewById(R.id.Animaux).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                controler.setCurrentTheme("Animaux");
                Intent intent = new Intent(ThemePage.this,Niveau.class);
                startActivity(intent);
            }
        });
    }
    private void themeFra(){
        findViewById(R.id.Francais).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                controler.setCurrentTheme("Francais");
                Intent intent = new Intent(ThemePage.this,Niveau.class);
                startActivity(intent);
            }
        });
    }
    private void themeMyt(){
        findViewById(R.id.Mythologie).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                controler.setCurrentTheme("Mythologie");
                Intent intent = new Intent(ThemePage.this,Niveau.class);
                startActivity(intent);
            }
        });
    }

}