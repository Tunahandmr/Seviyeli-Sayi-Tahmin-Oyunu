package com.tunahan.sayitahminoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {

    EditText editText;
    TextView textView;
    TextView textView2;
    Button buttonGuess;
    Button buttonRestart;
    int number;
    int hak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        editText = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        buttonGuess = findViewById(R.id.button);
        buttonRestart = findViewById(R.id.button2);
        hak=5;
        buttonRestart.setVisibility(View.INVISIBLE);

    }

    public void guess(View view){
        int a = Integer.parseInt(editText.getText().toString()) ;
        Random random = new Random();
        number = random.nextInt(20);

        if (number==a){
            textView.setText("Tebrikler! Oyunu Bitirdin.");
            buttonGuess.setVisibility(View.INVISIBLE);
            buttonRestart = findViewById(R.id.button2);
            Toast.makeText(getApplicationContext(),"Oyun Bitti!",Toast.LENGTH_LONG).show();
        }else
        {
            textView.setText("yanlış tahmin,tekrar dene!");
        }
        hak--;
        textView2.setText("Kalan Hak: "+ hak);
        if(hak==0){
            buttonGuess.setEnabled(false);
            buttonRestart.setVisibility(View.VISIBLE);
            textView.setText("Hak bitti, yeniden başla!");
        }
    }

    public void restart(View view){

        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}