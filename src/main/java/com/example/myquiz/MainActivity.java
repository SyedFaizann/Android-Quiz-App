package com.example.myquiz;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

     CardView quizEasy,quizMedium,quizHard,quizExit;

     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quizEasy = findViewById(R.id.quizEasy);
        quizMedium = findViewById(R.id.quizMedium);
        quizHard = findViewById(R.id.quizHard);
        quizExit = findViewById(R.id.quizExit);

        quizEasy.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,MainActivity2.class)));

        quizMedium.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,MainActivity3.class)));

        quizHard.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,MainActivity4.class)));

        quizExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });




    }




}













