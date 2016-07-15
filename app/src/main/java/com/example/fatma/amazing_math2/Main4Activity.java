package com.example.fatma.amazing_math2;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;

public class Main4Activity extends AppCompatActivity {
    TextView op, result, sc;
    Button verif;
    int op1, op2, op3,op4,resf;
    int i = 0;
    ImageView img;
    int defrandom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        TextView textTitle = (TextView) findViewById(R.id.text);
        Intent intent= getIntent();

        int operation=intent.getIntExtra("operation",0);
        int  niveau = intent.getIntExtra("niv",0);
        if(niveau==1)
        {
            defrandom=10;
        }
        else  if(niveau==2)
        {
            defrandom=100;
        }
        else  if(niveau==3)
        {
            defrandom=1000;
        }
        textTitle.setText(""+niveau);

        SecureRandom random = new SecureRandom();
        op = (TextView) findViewById(R.id.operation);
        result = (TextView) findViewById(R.id.res);
        op1 = random.nextInt(defrandom) + 1;
        op2 = random.nextInt(defrandom) + 1;
        op3 = random.nextInt(defrandom) + 1;
        op4 = random.nextInt(defrandom) + 1;

        if(operation==1){
            op.setText(String.valueOf(op1) + "+" + String.valueOf(op2) + "=?");
            resf = op1 + op2;}
        else if(operation==2)
        {op.setText(String.valueOf(op1) + "-" + String.valueOf(op2) + "=?");
            resf = op1 - op2;}
        else if(operation==3)
        {op.setText(String.valueOf(op1) + "*" + String.valueOf(op2) + "=?");
            resf = op1 * op2;}
        else if(operation==4)
        {op.setText(String.valueOf(op1) + "/" + String.valueOf(op2) + "=?");
            resf = op1 / op2;}

        result.setText("");
        verif = (Button) findViewById(R.id.button);

        verif.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Context context = getApplicationContext();

                int duration = Toast.LENGTH_SHORT;

                String resstring = result.getText().toString();
                if (resstring.equals("")) {
                    CharSequence text = "Esayer de la résoudre";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {

                    int resint = Integer.parseInt(resstring);

                    if (resint == resf) {
                        sc = (TextView) findViewById(R.id.score);
                        i++;
                        sc.setText(String.valueOf(i));


                        Log.d("Naveen", "Test====");
                        System.out.println("----------------------ghfgjhf-----------------");
                        AlertDialog alertDialog = new AlertDialog.Builder(Main4Activity.this).create();
                        alertDialog.setTitle("correct");
                        alertDialog.setMessage("Bravo!!");
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.win);
                        mp.start();
                        alertDialog.setIcon(R.drawable.thumbsup);
                        result.setText("");

                        alertDialog.show();

                        SecureRandom random = new SecureRandom();
                        op1 = random.nextInt(10) + 1;
                        op2 = random.nextInt(10) + 1;
                        Intent intent= getIntent();

                        int operation=intent.getIntExtra("operation",0);
                       // resf = op1 + op2;

                        //op.setText(String.valueOf(op1) + "+" + String.valueOf(op2) + "=?");
                        if(operation==1){
                            op.setText(String.valueOf(op1) + "+" + String.valueOf(op2) + "=?");
                            resf = op1 + op2;}
                        else if(operation==2)
                        {op.setText(String.valueOf(op1) + "-" + String.valueOf(op2) + "=?");
                            resf = op1 - op2;}
                        else if(operation==3)
                        {op.setText(String.valueOf(op1) + "*" + String.valueOf(op2) + "=?");
                            resf = op1 * op2;}
                        else if(operation==4)
                        {op.setText(String.valueOf(op1) + "/" + String.valueOf(op2) + "=?");
                            resf = op1 / op2;}
                        result.setText("");


                    } else {

                        // Kabloey
                        Log.d("Naveen", "Test====");
                        System.out.println("----------------------ghfgjhf-----------------");
                        AlertDialog alertDialog = new AlertDialog.Builder(Main4Activity.this).create();
                        alertDialog.setTitle("Incorrect");
                        alertDialog.setMessage("réesayer");
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.fail);
                        mp.start();
                        alertDialog.setIcon(R.drawable.thumbsdown);
                        result.setText("");

                        alertDialog.show();

                    }


                }
            }

        });
    }
}
