package com.example.guillemotf.garderie;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

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


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDepart = (Button) findViewById(R.id.btnDepart);
        btnArrive = (Button) findViewById(R.id.btnArrive);
        btnRecap = (Button) findViewById(R.id.btnRecap);
        btnValide = (Button) findViewById(R.id.btnValide);
        libelleTitle = (TextView) findViewById(R.id.libelleTitle);
        txtNomEleve = (TextView) findViewById(R.id.txtNomEleve);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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

    public void gotoArrive(View arriveView){
        Intent arrivePage = new Intent(MainActivity.this , Arrive.class);
        startActivity (arrivePage);
    }

    public void gotoDepart(View departView){
        Intent departPage = new Intent(MainActivity.this , Depart.class);
        startActivity (departPage);
    }
    public void gotoRecap(View recapView){
        Intent recapPage = new Intent(MainActivity.this , Recap.class);
        startActivity (recapPage);
    }

}
