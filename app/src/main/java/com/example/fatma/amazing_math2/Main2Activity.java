package com.example.fatma.amazing_math2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
Button facile,moyen,dificile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        facile = (Button) findViewById(R.id.easybutton);

        facile.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("niv", 1);
                startActivity(intent);

            }

        });

        moyen = (Button) findViewById(R.id.meduimbutton);

        moyen.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("niv", 2);
                startActivity(intent);

            }

        });


        dificile = (Button) findViewById(R.id.hardbutton);

        dificile.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("niv", 3);
                startActivity(intent);
            }

        });
    }
}
