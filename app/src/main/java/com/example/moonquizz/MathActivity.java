package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.moonquizz.controler.controller;

public class MathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        init();
    }

    private controller controller;

    private void init() {
        //On récupère le controller
        this.controller = controller.getInstance(this);
        addition();
        soustraction();
        multiplication();
        division();
        retour();
        avatar();
    }

    private void addition(){
        Button add=findViewById(R.id.add);

        add.setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MathActivity.this,OperationActivity.class);
                String pages = "0";
                String occur= "premier";
                //Génération des 10 opérations
                controller.genOp("+");
                intent.putExtra("PAGE", pages);
                intent.putExtra("OCCUR",occur);
                startActivity(intent);
            }

        });
    }

    private void soustraction(){
        Button sous=findViewById(R.id.sous);

        sous.setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MathActivity.this,OperationActivity.class);
                String pages = "0";
                String occur= "premier";
                //Génération des 10 opérations
                controller.genOp("-");
                intent.putExtra("PAGE", pages);
                intent.putExtra("OCCUR",occur);
                startActivity(intent);
            }

        });
    }

    private void multiplication(){
        Button mult=findViewById(R.id.mult);

        mult.setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MathActivity.this,OperationActivity.class);
                String pages = "0";
                String occur= "premier";
                //Génération des 10 opérations
                controller.genOp("*");
                intent.putExtra("PAGE", pages);
                intent.putExtra("OCCUR",occur);
                startActivity(intent);
            }

        });
    }

    private void division(){
        Button div=findViewById(R.id.div);

        div.setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MathActivity.this,OperationActivity.class);
                String pages = "0";
                String occur= "premier";
                //Génération des 10 opérations
                controller.genOp("/");
                intent.putExtra("PAGE", pages);
                intent.putExtra("OCCUR",occur);
                startActivity(intent);
            }

        });
    }

    //Renvoie au bouton avatar
    private void avatar() {
        //Récupération de l'avatar de l'utilisateur
        String name = controller.getCurrentUser().getAvatar();
        int id = getResources().getIdentifier(name, "drawable", MathActivity.this.getPackageName());
        Drawable drawable = getResources().getDrawable(id);
        ImageButton button = findViewById(R.id.avatar);
        button.setImageDrawable(drawable);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MathActivity.this, AvatarActivity.class);
                String page = "math";
                intent.putExtra("PAGE", page);
                startActivity(intent);
            }
        });
    }

    //Renvoie a la liste des theme
    private void retour(){
        findViewById(R.id.retour).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MathActivity.this, ThemeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}