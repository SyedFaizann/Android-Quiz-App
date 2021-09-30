package com.example.myquiz;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity2 extends AppCompatActivity{

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
                    new answers(R.string.question_1,R.string.option_1A,R.string.option_1B,R.string.option_1C,R.string.option_1D,R.string.answer_1),
                    new answers(R.string.question_2,R.string.option_2A,R.string.option_2B,R.string.option_2C,R.string.option_2D,R.string.answer_2),
                    new answers(R.string.question_3,R.string.option_3A,R.string.option_3B,R.string.option_3C,R.string.option_3D,R.string.answer_3),
                    new answers(R.string.question_4,R.string.option_4A,R.string.option_4B,R.string.option_4C,R.string.option_4D,R.string.answer_4),
                    new answers(R.string.question_5,R.string.option_5A,R.string.option_5B,R.string.option_5C,R.string.option_5D,R.string.answer_5),
                    new answers(R.string.question_6,R.string.option_6A,R.string.option_6B,R.string.option_6C,R.string.option_6D,R.string.answer_6),
                    new answers(R.string.question_7,R.string.option_7A,R.string.option_7B,R.string.option_7C,R.string.option_7D,R.string.answer_7),
                    new answers(R.string.question_8,R.string.option_8A,R.string.option_8B,R.string.option_8C,R.string.option_8D,R.string.answer_8),
                    new answers(R.string.question_9,R.string.option_9A,R.string.option_9B,R.string.option_9C,R.string.option_9D,R.string.answer_9),
                    new answers(R.string.question_10,R.string.option_10A,R.string.option_10B,R.string.option_10C,R.string.option_10D,R.string.answer_10)

            };
    final int PROGRESS_BAR= (int) Math.ceil(100/questionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


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

        if(currentIndex==0)
        {
            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("Your Score is "+sc+" points");
            alert.setPositiveButton("Go Back", (dialogInterface, i) -> {
                Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);

            });

            alert.setNegativeButton("No", (dialogInterface, i) -> {
                sc=0;
                qn=1;
                progressBar.setProgress(0);
                score.setText("Score-"+sc+"/"+questionBank.length);
                questionnumber.setText("Question"+qn);

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