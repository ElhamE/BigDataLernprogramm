package com.example.elham.bigdatalernprogramm.begriffsklaerung;

/**
 * Main source code taken from Arvin
 * (https://www.sourcecodester.com/android/12062/android-simple-quiz-app.html).
 */

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elham.bigdatalernprogramm.R;

public class TesteWissen extends Fragment implements View.OnClickListener {
    Button mButton1, mButton2, mButton3, mButton4;
    TextView mTextView;

    private Question question = new Question();
    private String answer;
    private int answerIndex;
    private int questionIndex;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.quiz, container, false);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        mButton1 = getActivity().findViewById(R.id.antwort1button);
        mButton1.setOnClickListener(this);
        mButton2 = getActivity().findViewById(R.id.antwort2button);
        mButton2.setOnClickListener(this);
        mButton3 = getActivity().findViewById(R.id.antwort3button);
        mButton3.setOnClickListener(this);
        mButton4 = getActivity().findViewById(R.id.antwort4button);
        mButton4.setOnClickListener(this);
        mTextView = getActivity().findViewById(R.id.frage);

        questionIndex = 0;
        NextQuestion(questionIndex);
    }

    public void richtigeAntwort(){
        //TODO Farbe
        Toast.makeText(getActivity(), "Richtig", Toast.LENGTH_SHORT).show();
    }

    public void falscheAntwort(){
        //TODO FARBE
        Toast.makeText(getActivity(), "Falsch", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        final Button[] buttons = {mButton1, mButton2, mButton3, mButton4};
        //lock the buttons
        for (Button b : buttons) {
            b.setClickable(false);
        }

        final int defaultColor = getResources().getColor(R.color.colorDefault);
        final int paddingLeft = mButton1.getPaddingLeft(), paddingRight = mButton1.getPaddingRight(),
                paddingTop = mButton1.getPaddingTop(), paddingBottom = mButton1.getPaddingBottom();

        //Is the clicked button the correct answer
        switch (v.getId()){
            case R.id.antwort1button:
                if(mButton1.getText() == answer){
                    richtigeAntwort();
                }
                else{
                    falscheAntwort();
                    mButton1.setBackgroundColor(Color.RED);
                }
                break;

            case R.id.antwort2button:
                if(mButton2.getText() == answer){
                    richtigeAntwort();
                }
                else{
                    falscheAntwort();
                    mButton2.setBackgroundColor(Color.RED);
                }
                break;

            case R.id.antwort3button:
                if(mButton3.getText() == answer){
                    richtigeAntwort();
                }
                else{
                    falscheAntwort();
                    mButton3.setBackgroundColor(Color.RED);
                }
                break;

            case R.id.antwort4button:
                if(mButton4.getText() == answer){
                    richtigeAntwort();
                }
                else{
                    falscheAntwort();
                    mButton4.setBackgroundColor(Color.RED);
                }
                break;
        }
        //Show the correct answer and wait
        Button answerButton = buttons[answerIndex];
        answerButton.setBackgroundColor(Color.GREEN);
        //reset and unlock buttons in a different Thread
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (Button b : buttons) {
                    b.setClickable(true);
                    b.setBackgroundColor(defaultColor);
                }
            }
        }, 2000);
        //wait until the reset ends and continue the quiz
        new CountDownTimer(2000, 1000) {

            public void onTick(long millisUntilFinished) {
                //do nothing
            }
            public void onFinish() {
                NextQuestion(++questionIndex);
            }
        }.start();
    }




    private void NextQuestion(int num){
        if (num == question.getQuestions().length){
            //TODO AUFHÖREN
            questionIndex  = 0;
            num = 0;
        }
        mTextView.setText(question.getQuestion(num));
        mButton1.setText(question.getchoice1(num));
        mButton2.setText(question.getchoice2(num));
        mButton3.setText(question.getchoice3(num));
        mButton4.setText(question.getchoice4(num));
        answer = question.getCorrectAnswer(num);
        answerIndex = question.getCorrectAnswerIndex(num);
    }

}
