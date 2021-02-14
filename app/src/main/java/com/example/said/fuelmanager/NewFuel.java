package com.example.said.fuelmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewFuel extends AppCompatActivity {

    DatabaseConnection connection=new DatabaseConnection(this);

    EditText liter_price,liter_amount,last_km;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_fuel);

        liter_amount=findViewById(R.id.liter_amount);
        liter_price=findViewById(R.id.liter_price);
        last_km=findViewById(R.id.last_km);

        addButton=findViewById(R.id.add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connection.addNewFuel(Double.parseDouble(liter_price.getText().toString()),Double.parseDouble(liter_amount.getText().toString()),Integer.parseInt(last_km.getText().toString()),1);

                Intent main=new Intent(NewFuel.this,MainActivity.class);
                startActivity(main);
            }
        });
    }
}
