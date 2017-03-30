package com.example.guillemotf.garderie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    //Récupération des éléments graphiques
    private Button btnDepart;
    private Button btnArrive;
    private Button btnRecap;
    private Button btnValide;
    private TextView libelleTitle;
    private TextView txtNomEleve;
    private Spinner spinnerEleve;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDepart = (Button) findViewById( R.id.btnDepart);
        btnArrive = (Button) findViewById( R.id.btnArrive);
        btnRecap = (Button) findViewById( R.id.btnRecap);
        btnValide = (Button) findViewById( R.id.btnValide);
        libelleTitle = (TextView) findViewById( R.id.libelleTitle);
        txtNomEleve = (TextView) findViewById( R.id.txtNomEleve);

    }
}
