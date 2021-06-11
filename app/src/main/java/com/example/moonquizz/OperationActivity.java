package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.moonquizz.controler.controler;
import com.example.moonquizz.model.operation;

import java.util.ArrayList;

public class OperationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);

    }
    private controler controler;



    private void init(){
        this.controler= controler.getInstance(this);


        Bundle extras = getIntent().getExtras();
        String page= extras.getString("page");
        String occur= extras.getString("occur");
        int numPage=Integer.parseInt(page);
        afficheQuest(numPage);
    }


    private  void afficheQuest(int page){
        ArrayList<operation> listeOp= controler.getOperation();
       TextView operand1View=findViewById(R.id.operand1);
        TextView operand2View=findViewById(R.id.operand2);
        TextView operatorView=findViewById(R.id.operator);
    operation operation=listeOp.get(page);
    operand1View.setText(operation.getOperand1());
    operand2View.setText(operation.getOperand2());
    operatorView.setText(operation.getOperation());
    }

    private void afficheBouton(int page, String occur){
        LinearLayout boutons=findViewById(R.id.boutons);
        if(page!=0){
            Button retour= new Button(this);
            retour.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
            retour.setText("Précedent");

        }
        TextView intervalle= new TextView(this);
        intervalle.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
        boutons.addView(intervalle);

        if(page==9 && occur.equals("premier")){

        } else if(page==9 && occur.equals("second"))
    }

    private void afficheError(){

    }

}