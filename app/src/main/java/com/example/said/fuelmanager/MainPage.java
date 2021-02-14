package com.example.said.fuelmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        LinearLayout newfuel=(LinearLayout) findViewById(R.id.newfuel);
        LinearLayout history=(LinearLayout) findViewById(R.id.history);
        LinearLayout statistic=(LinearLayout) findViewById(R.id.statistic);
        LinearLayout voiceAssistant=(LinearLayout) findViewById(R.id.voiceAssistant);
        LinearLayout setting=(LinearLayout) findViewById(R.id.setting);

        newfuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addfuel=new Intent(MainPage.this,NewFuel.class);
                startActivity(addfuel);
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showHistory=new Intent(MainPage.this,History.class);
                startActivity(showHistory);
            }
        });

        statistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showStatistic=new Intent(MainPage.this,Statistic.class);
            }
        });

        voiceAssistant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent assistant=new Intent(MainPage.this,VoiceControl.class);
                startActivity(assistant);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent setting=new Intent(MainPage.this, Settings.class);
                startActivity(setting);
            }
        });
    }
}
