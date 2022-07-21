package com.tunahan.sayitahminoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    EditText editText;
    TextView textView;
    TextView textView2;
    Button buttonGuess;
    Button buttonRestart;
    Button buttonNext;
    int number;
    int hak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        buttonGuess = findViewById(R.id.button);
        buttonRestart = findViewById(R.id.button2);
        buttonNext = findViewById(R.id.button3);
        hak=5;
        buttonRestart.setVisibility(View.INVISIBLE);
        buttonNext.setVisibility(View.INVISIBLE);
    }

    public void guess(View view){
        int a = Integer.parseInt(editText.getText().toString()) ;
        Random random = new Random();
        number = random.nextInt(15);

        if (number==a){
            textView.setText("Tebrikler!");
            buttonGuess.setVisibility(View.INVISIBLE);
            buttonRestart = findViewById(R.id.button2);
            buttonNext.setVisibility(View.VISIBLE);
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

    public void next(View view){

        Intent intent = new Intent(getApplicationContext(),MainActivity3.class);
        startActivity(intent);

    }


}