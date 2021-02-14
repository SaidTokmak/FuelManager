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

public class VoiceControl extends AppCompatActivity {
    DatabaseConnection connection=new DatabaseConnection(this);

    private TextToSpeech textToSpeech;
    private SpeechRecognizer speechRecognizer;
    TextView textView;
    Button voiceButton;
    String text="";

    double liter_price=0,liter_amount=0;
    int km=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_control);

        voiceButton= findViewById(R.id.voice_button);
        textView=findViewById(R.id.textVoice);

        voiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,1);
                speechRecognizer.startListening(intent);

            }
        });

        callTextToSpeech();
        callSpeechRecognizer();
    }
    private void callSpeechRecognizer() {
        if(SpeechRecognizer.isRecognitionAvailable(this)){
            speechRecognizer=SpeechRecognizer.createSpeechRecognizer(this);
            speechRecognizer.setRecognitionListener(new RecognitionListener() {
                @Override
                public void onReadyForSpeech(Bundle bundle) {

                }

                @Override
                public void onBeginningOfSpeech() {

                }

                @Override
                public void onRmsChanged(float v) {

                }

                @Override
                public void onBufferReceived(byte[] bytes) {

                }

                @Override
                public void onEndOfSpeech() {

                }

                @Override
                public void onError(int i) {

                }

                @Override
                public void onResults(Bundle bundle) {
                    List<String> results=bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                    processResult(results.get(0));
                }

                @Override
                public void onPartialResults(Bundle bundle) {

                }

                @Override
                public void onEvent(int i, Bundle bundle) {

                }
            });
        }
    }

    private void processResult(String str) {
        str=str.toLowerCase();
        text=text+str;
        if(str.contains("yeni") && str.contains("kayıt")){
            textView.setText(text);
            speak("okey how much liter fuel");
        }
        if(str.contains("litre")){
            speak("okey how much price liter");
            textView.setText(text);
        }
        if(str.contains("lira")){
            textView.setText(text);
            speak("how many kilometer");
        }
        if(str.contains("kilometre")){
            textView.setText(text);
            speak("datas saved");
        }
    }

    private void callTextToSpeech() {
        textToSpeech=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(textToSpeech.getEngines().size()==0) {
                    Toast.makeText(VoiceControl.this, "Your device not supported this features", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    textToSpeech.setLanguage(Locale.ENGLISH);
                    speak("What do you want do ");
                }
            }
        });
    }

    private void speak(String message) {
        if(Build.VERSION.SDK_INT >= 21){
            textToSpeech.speak(message,TextToSpeech.QUEUE_FLUSH,null,null);
        }else{
            textToSpeech.speak(message,TextToSpeech.QUEUE_FLUSH,null);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        textToSpeech.shutdown();
    }
}
