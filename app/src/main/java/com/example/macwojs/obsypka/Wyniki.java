package com.example.macwojs.obsypka;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Wyniki extends AppCompatActivity {

    /**
     * Funkcja inicjująca
     *
     * @param savedInstanceState parametr do zapisu wprowadzonych danych
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wyniki);


        Bundle b = getIntent().getExtras();
        double[] par = b.getDoubleArray("parametry");
        create(par);
    }

    private void create(double[] param) {
        DecimalFormat round = new DecimalFormat("0.00");

        TextView masa_1 = findViewById(R.id.masa_text);
        masa_1.setText(String.valueOf(round.format(param[3])));

        TextView masa_2 = findViewById(R.id.masa1mb_text);
        masa_2.setText(String.valueOf(round.format(param[1])));

        TextView obj_1 = findViewById(R.id.obj_text);
        obj_1.setText(String.valueOf(round.format(param[2])));

        TextView obj_2 = findViewById(R.id.obj1mb_text);
        obj_2.setText(String.valueOf(round.format(param[0])));
    }
}
