package com.example.macwojs.obsypka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * Funkcja inicjująca
     * @param savedInstanceState parametr do zapisu wprowadzonych danych
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Obliczanie powierzchni samego filtra
     * @return szukana powierzchnia
     */
    double powFil() {
        double wynik = 0;

        EditText text = findViewById(R.id.sr_fil);
        double sr = Double.valueOf(text.getText().toString());

        Spinner spinner = findViewById(R.id.wyb_jed_fil);
        String jed = spinner.getSelectedItem().toString();

        switch (jed) {
            case "mm":
                wynik = (Math.PI * Math.pow(sr / 2 / 100, 2));
                break;
            case "cm":
                wynik = (Math.PI * Math.pow(sr / 2 / 10, 2));
                break;
            case "dm":
                wynik = Math.PI * Math.pow(sr / 2, 2);
                break;
            case "m":
                wynik = Math.PI * Math.pow(sr / 2 * 10, 2);
                break;
        }

        return wynik;
    }

    /**
     * Obliczanie powierzchni całego otworu
     * @return szukana powierzchnia
     */
    double powOtw(){
        double wynik = 0;

        EditText text = findViewById(R.id.sr_otw);
        double sr = Double.valueOf(text.getText().toString());

        Spinner spinner = findViewById(R.id.wyb_jed_otw);
        String jed = spinner.getSelectedItem().toString();

        switch (jed) {
            case "mm":
                wynik = (Math.PI * Math.pow(sr / 2 / 100,2));
                break;
            case "cm":
                wynik = (Math.PI * Math.pow(sr / 2 / 10,2));
                break;
            case "dm":
                wynik = Math.PI * Math.pow(sr / 2,2);
                break;
            case "m":
                wynik = Math.PI * Math.pow(sr / 2 * 10,2);
                break;
        }

        return wynik;
    }

    /**
     * Obliczanie objętości materiału który należy wsypać
     * @param pow powierzchnia pierścienia do której wsypuje się materiał
     * @return w pierwszej komórce jest objętość dla 1 metra bieżącego, a w drugiej dla
     *          wybranej ilości
     */
    double[] obj(double pow){
        double v[] = new double[2];
        v[0] = pow * 10;

        EditText text = findViewById(R.id.d_obs);
        double d = Double.valueOf(text.getText().toString());

        Spinner spinner = findViewById(R.id.wyb_jed_obs);
        String jed = spinner.getSelectedItem().toString();

        switch (jed) {
            case "mm":
                v[1] = v[0] * d / 1000;
                break;
            case "cm":
                v[1] = v[0] * d / 100;
                break;
            case "dm":
                v[1] = v[0] * d / 10;
                break;
            case "m":
                v[1] = v[0] * d;
                break;
        }

        return v;
    }

    /**
     * Obliczanie masy materiału który należy wsypać
     * @param obj objętość materaiłu
     * @return w pierwszej komórce jest masa dla 1 metra bieżącego, a w drugiej dla wybranej ilości
     */
    double[] masa(double obj){
        double m[] = new double[2];
        Spinner spinnerMaterial = findViewById(R.id.wyb_mat);
        String mat = spinnerMaterial.getSelectedItem().toString();

        switch (mat) {
            case "Obsybka 1,98t/m3":
                m[0] = obj * 1.98;
                break;
            case "Compactonic 1 t/m3":
                m[0] = obj * 1;
                break;
        }

        EditText text = findViewById(R.id.d_obs);
        double d = Double.valueOf(text.getText().toString());

        Spinner spinner = findViewById(R.id.wyb_jed_obs);
        String jed = spinner.getSelectedItem().toString();

        switch (jed) {
            case "mm":
                m[1] = m[0] * d / 1000;
                break;
            case "cm":
                m[1] = m[0] * d / 100;
                break;
            case "dm":
                m[1] = m[0] * d / 10;
                break;
            case "m":
                m[1] = m[0] * d;
                break;
        }

        return m;
    }

    /**
     * Funkcja wywoływana po naciśnięciu guzika "Oblicz"
     * @param view odwołanie do widoku aplikacji
     */
    public void oblicz(View view){
        //Sprawdzanie czy wszystkie dane zostały wprowadzone
        EditText wpr_sr_otw = findViewById(R.id.sr_otw);
        EditText wpr_sr_fil = findViewById(R.id.sr_fil);
        EditText wpr_d_obs = findViewById(R.id.d_obs);
        String spr_otw = wpr_sr_otw.getText().toString();
        String spr_fil = wpr_sr_fil.getText().toString();
        String spr_obs = wpr_d_obs.getText().toString();
        if (spr_otw.matches("") || spr_fil.matches("") || spr_obs.matches("")) {
            Toast.makeText(this, getString(R.string.wiadomosc), Toast.LENGTH_SHORT).show();
            return;
        }

        //Obliczanie żądanych parametrów
        double powFil = powFil();
        double powOtw = powOtw();
        double pow = powOtw - powFil;
        double v[] = obj(pow);
        double obj1MB = v[0];
        double objX = v[1];
        double m[] = masa(obj1MB);
        double masa1MB = m[0];
        double masaX = m[1];

        String a = obj1MB + "\n" +
                masa1MB + "\n" +
                objX + "\n" +
                masaX + "\n" +
                powFil + "\n" +
                powOtw + "\n";

        TextView text = findViewById(R.id.proba);
        text.setText(String.valueOf(a));
    }
}
