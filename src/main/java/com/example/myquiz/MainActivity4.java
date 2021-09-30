package com.example.myquiz;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity4 extends AppCompatActivity{
    CardView optA,optB,optC,optD;
    private TextView optionA,optionB,optionC,optionD;
    private TextView questionnumber,question,score;
    private TextView checkout1,checkout2;
    int currentIndex;
    int sc=0;
    int qn=1;
    ProgressBar progressBar;


    int CurrentQuestion,CurrentOptionA,CurrentOptionB,CurrentOptionC,CurrentOptionD;



    private final answers[] questionBank=new answers[]
            {
                    new answers(R.string.question_21,R.string.option_21A,R.string.option_21B,R.string.option_21C,R.string.option_21D,R.string.answer_21),
                    new answers(R.string.question_22,R.string.option_22A,R.string.option_22B,R.string.option_22C,R.string.option_22D,R.string.answer_22),
                    new answers(R.string.question_23,R.string.option_23A,R.string.option_23B,R.string.option_23C,R.string.option_23D,R.string.answer_23),
                    new answers(R.string.question_24,R.string.option_24A,R.string.option_24B,R.string.option_24C,R.string.option_24D,R.string.answer_24),
                    new answers(R.string.question_25,R.string.option_25A,R.string.option_25B,R.string.option_25C,R.string.option_25D,R.string.answer_25),
                    new answers(R.string.question_26,R.string.option_26A,R.string.option_26B,R.string.option_26C,R.string.option_26D,R.string.answer_26),
                    new answers(R.string.question_27,R.string.option_27A,R.string.option_27B,R.string.option_27C,R.string.option_27D,R.string.answer_27),
                    new answers(R.string.question_28,R.string.option_28A,R.string.option_28B,R.string.option_28C,R.string.option_28D,R.string.answer_28),
                    new answers(R.string.question_29,R.string.option_29A,R.string.option_29B,R.string.option_29C,R.string.option_29D,R.string.answer_29),
                    new answers(R.string.question_30,R.string.option_30A,R.string.option_30B,R.string.option_30C,R.string.option_30D,R.string.answer_30)

            };
    final int PROGRESS_BAR= (int) Math.ceil(100/questionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        optA=findViewById(R.id.quizEasy);
        optB=findViewById(R.id.quizMedium);
        optC=findViewById(R.id.quizHard);
        optD=findViewById(R.id.quizExit);


        optionA=findViewById(R.id.optionA);
        optionB=findViewById(R.id.optionB);
        optionC=findViewById(R.id.optionC);
        optionD=findViewById(R.id.optionD);


        question = findViewById(R.id.question);
        score= findViewById(R.id.score);
        questionnumber=findViewById(R.id.questionNo);

        checkout1=findViewById(R.id.selectoption);
        checkout2=findViewById(R.id.corOption);
        progressBar=findViewById(R.id.progress_bar);


        CurrentQuestion=questionBank[currentIndex].getQuestionid();
        question.setText(CurrentQuestion);
        CurrentOptionA=questionBank[currentIndex].getOptionA();
        optionA.setText(CurrentOptionA);
        CurrentOptionB=questionBank[currentIndex].getOptionB();
        optionB.setText(CurrentOptionB);
        CurrentOptionC=questionBank[currentIndex].getOptionC();
        optionC.setText(CurrentOptionC);
        CurrentOptionD=questionBank[currentIndex].getOptionD();
        optionD.setText(CurrentOptionD);

        optA.setOnClickListener(view -> {
            checkAnswer(CurrentOptionA);
            updateQuestion();

        });
        optB.setOnClickListener(view -> {
            checkAnswer(CurrentOptionB);
            updateQuestion();

        });
        optC.setOnClickListener(view -> {
            checkAnswer(CurrentOptionC);
            updateQuestion();

        });
        optD.setOnClickListener(view -> {
            checkAnswer(CurrentOptionD);
            updateQuestion();

        });





    }

    private void checkAnswer(int userSelection) {


        int correctanswer=questionBank[currentIndex].getAnswerid();

        checkout1.setText(userSelection);
        checkout2.setText(correctanswer);

        String m= checkout1.getText().toString().trim();
        String n= checkout2.getText().toString().trim();

        if(m.equals(n))
        {
            Toast.makeText(getApplicationContext(),"Right",Toast.LENGTH_SHORT).show();
            sc=sc+1;
        }
        else
        {
            Toast.makeText(getApplicationContext(),"WRONG",Toast.LENGTH_SHORT).show();
        }



    }

    @SuppressLint("SetTextI18n")
    private void updateQuestion() {

        currentIndex=(currentIndex+1)%questionBank.length;


        if(currentIndex==0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("Your Score is " + sc + " points");
            alert.setPositiveButton("Go Back", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    startActivity(new Intent(MainActivity4.this, MainActivity.class));

                }
            });

            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    sc = 0;
                    qn = 1;
                    progressBar.setProgress(0);
                    score.setText("Score-" + sc + "/" + questionBank.length);
                    questionnumber.setText("Question" + qn);

                }
            });


            alert.show();

        }
        CurrentQuestion=questionBank[currentIndex].getQuestionid();
        question.setText(CurrentQuestion);
        CurrentOptionA=questionBank[currentIndex].getOptionA();
        optionA.setText(CurrentOptionA);
        CurrentOptionB=questionBank[currentIndex].getOptionB();
        optionB.setText(CurrentOptionB);
        CurrentOptionC=questionBank[currentIndex].getOptionC();
        optionC.setText(CurrentOptionC);
        CurrentOptionD=questionBank[currentIndex].getOptionD();
        optionD.setText(CurrentOptionD);


        qn=qn+1;
        if(qn<=questionBank.length)
        {
            questionnumber.setText("Question"+qn);
        }
        score.setText("Score-"+sc+"/"+questionBank.length);
        progressBar.incrementProgressBy(PROGRESS_BAR);
    }
}