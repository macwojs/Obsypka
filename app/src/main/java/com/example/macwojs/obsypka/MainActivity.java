package com.example.macwojs.obsypka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    double powFil(){
        double wynik = 0;

        EditText text = findViewById(R.id.sr_fil);
        double sr = Double.valueOf(text.getText().toString());

        Spinner spinner = findViewById(R.id.wyb_jed_fil);
        String jed = spinner.getSelectedItem().toString();

        if (jed.equals("mm")){
            wynik = Math.PI * Math.pow(sr / 2 / 100,2);
        } else if (jed.equals("cm")){
            wynik = Math.PI * Math.pow(sr / 2 / 10,2);
        } else if (jed.equals("dm")){
            wynik = Math.PI * Math.pow(sr / 2,2);
        } else if (jed.equals("m")){
            wynik = Math.PI * Math.pow(sr / 2 * 10,2);
        }

        return wynik;
    }

    public void oblicz(View view){
        Double a = powFil();

        TextView text = findViewById(R.id.proba);
        text.setText(String.valueOf(a));
    }
}
