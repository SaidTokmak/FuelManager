package com.example.said.fuelmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class History extends AppCompatActivity {

    DatabaseConnection connection=new DatabaseConnection(this);
    TextView textView;
    String text="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        textView=(TextView) findViewById(R.id.textHistory);

        List<FuelManager> fuelManagers;

        fuelManagers=connection.showAllFuels();
        if(fuelManagers!=null) {
            for (FuelManager f : fuelManagers) {
                String s = "" + f.getFuel_id() + ") " + f.getLiter_price() + " tl " + f.getLiter_amount()+" lt "+f.getLast_km()+" km\n";
                text = text + s;
            }
            textView.setText(text);
        }else{
            textView.setText("Kayıt Bulunumadı!");
        }
    }
}
