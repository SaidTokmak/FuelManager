package com.example.said.fuelmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewUser extends AppCompatActivity {
    DatabaseConnection connection=new DatabaseConnection(this);
    EditText name,mail,info,km;
    Button insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        name= findViewById(R.id.name);
        mail= findViewById(R.id.mail);
        info= findViewById(R.id.info);
        km= findViewById(R.id.km);

        insert= findViewById(R.id.insert);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                connection.addUserData(name.getText().toString(),mail.getText().toString(),info.getText().toString(),Integer.parseInt(km.getText().toString()));

                Intent show=new Intent(NewUser.this,MainPage.class);
                startActivity(show);
            }
        });
    }
}
