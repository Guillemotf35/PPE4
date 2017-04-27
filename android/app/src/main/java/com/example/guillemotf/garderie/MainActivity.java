package com.example.guillemotf.garderie;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.example.guillemotf.garderie.R.layout.activity_arrivee;
import static com.example.guillemotf.garderie.R.layout.activity_depart;
import static com.example.guillemotf.garderie.R.layout.activity_recap;

public class MainActivity extends AppCompatActivity {

    //Récupération des éléments graphiques
    private Button btnDepart;
    private Button btnArrive;
    private Button btnRecap;
    private Button btnValide;
    private TextView libelleTitle;
    private TextView txtNomEleve;
    private Spinner spinnerEleve;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private Intent activity_recap;
    private Intent activity_depart;
    private Intent activity_arrivee;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        btnDepart = (Button) findViewById(R.id.btnDepart);
        btnArrive = (Button) findViewById(R.id.btnArrive);
        btnRecap = (Button) findViewById(R.id.btnRecap);
        btnValide = (Button) findViewById(R.id.btnValide);
        libelleTitle = (TextView) findViewById(R.id.libelleTitle);
        txtNomEleve = (TextView) findViewById(R.id.txtNomEleve);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        setContentView(R.layout.activity_main);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    public void gotoDepartActivity(View view){
        Intent intent = new Intent(this, Depart.class);
        startActivity(intent);
    }

    public void gotoArriveActivity(View view){
        Intent intent = new Intent(this, Arrive.class);
        startActivity(intent);
    }

    public void gotoRecapActivity(View view){
        Intent intent = new Intent(this, Recap.class);
        startActivity(intent);
    }
}
