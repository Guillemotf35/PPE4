package com.example.guillemotf.ppe4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button btnAct2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAct2 = (Button) findViewById(R.id.buttonAct2);
    }

    public void btnClick(View v){

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, MatinActivity.class);
        startActivity(i);
    }
}
