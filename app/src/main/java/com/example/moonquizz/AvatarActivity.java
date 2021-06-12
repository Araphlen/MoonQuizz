package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.moonquizz.controler.controller;

public class AvatarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);
        init();
    }

    private controller controller;

    private void init(){
        //On récupère le controller
        this.controller = controller.getInstance(this);
        retour();
        Bundle extras = getIntent().getExtras();
        String page= extras.getString("PAGE");


        LinearLayout layout= findViewById(R.id.layout1);
        //Récupère la liste des 17 avatars
        for(int i =1; i<18;i++){
            //On créer un ImageButton pour chaque avatar
            ImageButton button = new ImageButton(this);
            button.setLayoutParams(new LinearLayout.LayoutParams(200,200));
            button.setScaleType(ImageButton.ScaleType.FIT_CENTER);

            //On récupère l'image de chaque avatar
            String avatar="avatar"+i;
            int id = getResources().getIdentifier(avatar, "drawable", AvatarActivity.this.getPackageName());
            Drawable drawable = getResources().getDrawable(id);
            button.setImageDrawable(drawable);
            button.setOnClickListener(new  View.OnClickListener() {
                public void onClick(View v) {
                    controller.changeAvatar(avatar);

                    //Vérifie sur quelle page il faut renvoyer l'utilisateur
                    if(page.equals("theme")){
                        Intent intent = new Intent(AvatarActivity.this, ThemeActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }else if(page.equals("niveau")){
                        Intent intent = new Intent(AvatarActivity.this, LevelActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    } else if(page.equals("quest")){
                        Intent intent = new Intent(AvatarActivity.this, QuestListActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                    else {
                        Intent intent = new Intent(AvatarActivity.this, MathActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                }
            });
            layout.addView(button);
        }

    }

    private void retour(){
        findViewById(R.id.home).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                AvatarActivity.this.finish();
            }
        });
    }


}