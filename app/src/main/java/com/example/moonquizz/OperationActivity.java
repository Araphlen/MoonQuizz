package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.moonquizz.controler.controller;
import com.example.moonquizz.model.operation;

import java.util.ArrayList;

public class OperationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);
        init();
    }
    private controller controller;



    private void init(){
        this.controller = controller.getInstance(this);


        Bundle extras = getIntent().getExtras();
        String page= extras.getString("PAGE");
        String occur= extras.getString("OCCUR");
        int numPage=Integer.parseInt(page);
        afficheQuest(numPage);
        afficheBouton(numPage, occur );
        if(occur.equals("seconde")){
            afficheError(numPage);
        }

    }


    private  void afficheQuest(int page){
        ArrayList<operation> listeOp= controller.getOperation();
       TextView operand1View=findViewById(R.id.operand1);
        TextView operand2View=findViewById(R.id.operand2);
        TextView operatorView=findViewById(R.id.operator);
    operation operation=listeOp.get(page);
    String operand1=Integer.toString(operation.getOperand1());
        String operand2=Integer.toString(operation.getOperand2());
    operand1View.setText(operand1);
    operand2View.setText(operand2);
    operatorView.setText(operation.getOperation());
    if(controller.getTableReponse().size()<page+1){
        float base = 0;
        controller.getTableReponse().add(base);
        EditText reponse =findViewById(R.id.rep);
        reponse.setHint("0");

    } else {
        float val = controller.getTableReponse().get(page);
        String rep= Float.toString(val);
        EditText reponse =findViewById(R.id.rep);
        reponse.setText(rep);
    }

    }

    private void afficheBouton(int page, String occur) {
        LinearLayout boutons = findViewById(R.id.boutons);
        if (page != 0) {
            Button retour = new Button(this);
            retour.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
            retour.setText("Précedent");

            retour.setOnClickListener(new  View.OnClickListener() {
                                    public void onClick(View v) {
                                        EditText reponse=findViewById(R.id.rep);
                                        String srep=reponse.getText().toString();
                                        if(srep.equals("")){
                                            srep="0";
                                        }
                                        float rep=Float.valueOf(srep);
                                        controller.changeRep(page, rep);
                                        Intent intent = new Intent(OperationActivity.this,OperationActivity.class);
                                        String pages = Integer.toString(page-1);
                                        intent.putExtra("PAGE", pages);
                                        intent.putExtra("OCCUR",occur);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent);
                                    }

        });
            boutons.addView(retour);
        }
        TextView intervalle = new TextView(this);
        intervalle.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1.0f));

        boutons.addView(intervalle);

        if (page == 9 ) {
            EditText reponse=findViewById(R.id.rep);
            Button suiv= new Button(this);
            suiv.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
            suiv.setText("Valider");
            suiv.setOnClickListener(new  View.OnClickListener() {
                public void onClick(View v) {
                    String srep=reponse.getText().toString();
                    if(srep.equals("")){
                        srep="0";
                    }
                    float rep=Float.valueOf(srep);

                    controller.changeRep(page, rep);
                    Intent intent = new Intent(OperationActivity.this,ResultatActivity.class);
                    intent.putExtra("OCCUR",occur);
                    startActivity(intent);
                }
            });        boutons.addView(suiv);

        } else {
            EditText reponse=findViewById(R.id.rep);

            Button suiv= new Button(this);
            suiv.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
            suiv.setText("Suivant");

            suiv.setOnClickListener(new  View.OnClickListener() {
                public void onClick(View v) {
                    String srep=reponse.getText().toString();
                    if(srep.equals("")){
                        srep="0";
                    }
                    float rep=Float.valueOf(srep);
                    controller.changeRep(page, rep);
                    Intent intent = new Intent(OperationActivity.this,OperationActivity.class);
                    String pages = Integer.toString(page+1);
                    intent.putExtra("PAGE", pages);
                    intent.putExtra("OCCUR",occur);
                    startActivity(intent);
                }
        });        boutons.addView(suiv);
        }

    }

    private void afficheError(int page){
            ImageView warning = new ImageView(this);
            warning.setLayoutParams(new LinearLayout.LayoutParams(50,50));
        int id = getResources().getIdentifier("warning", "drawable", OperationActivity.this.getPackageName());
        Drawable drawable = getResources().getDrawable(id);
        warning.setImageDrawable(drawable);
            LinearLayout layout= findViewById(R.id.question);
            if(!controller.verifResult(page)){
                layout.addView(warning);
            }
    }

}