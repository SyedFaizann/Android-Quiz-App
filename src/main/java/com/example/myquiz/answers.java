package com.example.myquiz;

public class answers {
    private int optionA,optionB,optionC,optionD,questionid,answerid;

    public answers(int ques,int optA,int optB,int optC,int optD,int ans){
        questionid=ques;
        optionA=optA;
        optionB=optB;
        optionC=optC;
        optionD=optD;
        answerid=ans;


    }

    public int getOptionA() {
        return optionA;
    }

    public int getOptionB() {
        return optionB;
    }

    public int getOptionC() {
        return optionC;
    }

    public int getOptionD() {
        return optionD;
    }

    public int getQuestionid() {
        return questionid;
    }

    public int getAnswerid() {
        return answerid;
    }
}
