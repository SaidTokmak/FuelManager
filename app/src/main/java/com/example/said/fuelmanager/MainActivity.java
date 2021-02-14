package com.example.said.fuelmanager;

import android.content.Intent;
import android.os.Build;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    DatabaseConnection connection=new DatabaseConnection(this);

    Button skip,newUser;
    TextView userInfo;
    String text="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skip=(Button) findViewById(R.id.skip);
        newUser=(Button) findViewById(R.id.newUser);
        userInfo=(TextView) findViewById(R.id.userInfo);

        List<Users> users=connection.getAllUsers();

        if(users.size()!= 0) {
            String use = " " + users.get(0).getName();
            text = text + use;
            userInfo.setText(text);
        }
        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addUser=new Intent(MainActivity.this,NewUser.class);
                startActivity(addUser);
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anasayfa=new Intent(MainActivity.this,MainPage.class);
                startActivity(anasayfa);
            }
        });

    }


}
