package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.moonquizz.controler.controler;

public class ChangeAvatar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_avatar);
        init();
    }

    private controler controler;

    private void init(){
        this.controler= controler.getInstance(this);
        retour();
        Bundle extras = getIntent().getExtras();
        String page= extras.getString("PAGE");


        LinearLayout layout= findViewById(R.id.layout1);
        for(int i =1; i<18;i++){
            ImageButton button = new ImageButton(this);
            button.setLayoutParams(new LinearLayout.LayoutParams(200,200));

            String avatar="avatar"+i;

            int id = getResources().getIdentifier(avatar, "drawable", ChangeAvatar.this.getPackageName());
            Drawable drawable = getResources().getDrawable(id);
            button.setImageDrawable(drawable);
            button.setOnClickListener(new  View.OnClickListener() {
                public void onClick(View v) {
                    controler.changeAvatar(avatar);
                    if(page.equals("theme")){
                        Intent intent = new Intent(ChangeAvatar.this,ThemePage.class);
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
                ChangeAvatar.this.finish();
            }
        });
    }


}