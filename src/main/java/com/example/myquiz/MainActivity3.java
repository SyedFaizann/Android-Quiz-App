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

public class MainActivity3 extends AppCompatActivity{

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
                    new answers(R.string.question_11,R.string.option_11A,R.string.option_11B,R.string.option_11C,R.string.option_11D,R.string.answer_11),
                    new answers(R.string.question_12,R.string.option_12A,R.string.option_12B,R.string.option_12C,R.string.option_12D,R.string.answer_12),
                    new answers(R.string.question_13,R.string.option_13A,R.string.option_13B,R.string.option_13C,R.string.option_13D,R.string.answer_13),
                    new answers(R.string.question_14,R.string.option_14A,R.string.option_14B,R.string.option_14C,R.string.option_14D,R.string.answer_14),
                    new answers(R.string.question_15,R.string.option_15A,R.string.option_15B,R.string.option_15C,R.string.option_15D,R.string.answer_15),
                    new answers(R.string.question_16,R.string.option_16A,R.string.option_16B,R.string.option_16C,R.string.option_16D,R.string.answer_16),
                    new answers(R.string.question_17,R.string.option_17A,R.string.option_17B,R.string.option_17C,R.string.option_17D,R.string.answer_17),
                    new answers(R.string.question_18,R.string.option_18A,R.string.option_18B,R.string.option_18C,R.string.option_18D,R.string.answer_18),
                    new answers(R.string.question_19,R.string.option_19A,R.string.option_19B,R.string.option_19C,R.string.option_19D,R.string.answer_19),
                    new answers(R.string.question_20,R.string.option_20A,R.string.option_20B,R.string.option_20C,R.string.option_20D,R.string.answer_20)

            };
    final int PROGRESS_BAR= (int) Math.ceil(100/questionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

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
                    startActivity(new Intent(MainActivity3.this, MainActivity.class));

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