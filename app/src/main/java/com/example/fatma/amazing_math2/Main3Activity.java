package com.example.fatma.amazing_math2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    TextView textTitle;
    int niveau;
    Button commencer;
    private CheckBox add,sub,mul,div;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textTitle = (TextView) findViewById(R.id.title);
        Intent intent= getIntent();
        niveau = intent.getIntExtra("niv",0);

        textTitle.setText(""+niveau);

        final CheckBox ch1 = (CheckBox) findViewById(R.id.checkbox1);
        final CheckBox ch2 = (CheckBox) findViewById(R.id.checkbox2);
        final CheckBox ch3 = (CheckBox) findViewById(R.id.checkbox3);
        final CheckBox ch4 = (CheckBox) findViewById(R.id.checkbox4);
        commencer = (Button) findViewById(R.id.button);

        commencer.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
                if(niveau==1)
                    intent.putExtra("niv", 1);
                else if (niveau==2)
                    intent.putExtra("niv", 2);
                else if(niveau==3)
                    intent.putExtra("niv", 3);

                if (ch1.isChecked()) {
                    intent.putExtra("operation",1);
                }
                else    if (ch2.isChecked()) {
                    intent.putExtra("operation",2);
                }
                else    if (ch3.isChecked()) {
                    intent.putExtra("operation",3);
                }
                else    if (ch4.isChecked()) {
                    intent.putExtra("operation",4);
                }


                startActivity(intent);
            }

        });
    }
}
