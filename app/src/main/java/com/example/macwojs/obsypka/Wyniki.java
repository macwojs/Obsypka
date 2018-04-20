package com.example.macwojs.obsypka;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

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
        TextView masa_1 = findViewById(R.id.masa_text);
        masa_1.setText(String.valueOf(param[3]));

        TextView masa_2 = findViewById(R.id.masa1mb_text);
        masa_2.setText(String.valueOf(param[1]));

        TextView obj_1 = findViewById(R.id.obj_text);
        obj_1.setText(String.valueOf(param[2]));

        TextView obj_2 = findViewById(R.id.obj1mb_text);
        obj_2.setText(String.valueOf(param[0]));
    }
}
