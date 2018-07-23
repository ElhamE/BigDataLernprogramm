package com.example.elham.bigdatalernprogramm.begriffsklaerung;

/**
 * Main source code taken from Arvin
 * (https://www.sourcecodester.com/android/12062/android-simple-quiz-app.html).
 */

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.elham.bigdatalernprogramm.R;

public class TesteWissen extends Fragment implements View.OnClickListener {
    Button mButton1, mButton2, mButton3, mButton4;
    TextView mTextView;

    private Question question = new Question();
    private String answer;
    private int answerIndex;
    private int questionIndex;
    private int correctAnswers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.begriffsklaerungquiz, container, false);
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
        mTextView = getActivity().findViewById(R.id.frage_loesung);
        questionIndex = 0;
        NextQuestion(questionIndex);
    }

    private void richtigeAntwort(){
        ++correctAnswers;
        String loesungssatz = getString(R.string.richtigeAntwort);
        mTextView.setText(loesungssatz);
    }

    private void falscheAntwort(){
        String loesungssatz = getString(R.string.falscheAntwort, answer);
        mTextView.setText(loesungssatz);
    }

    @Override
    public void onClick(View v) {
        final Button[] buttons = {mButton1, mButton2, mButton3, mButton4};
        //lock the buttons
        for (Button b : buttons) {
            b.setClickable(false);
        }
        final Drawable defaultBackground = v.getBackground();

        //Is the clicked button the correct answer
        switch (v.getId()){
            case R.id.antwort1button:
                if(mButton1.getText() == answer){
                    richtigeAntwort();
                }
                else{
                    falscheAntwort();
                    mButton1.setBackgroundResource(R.color.colorFalse);
                }
                break;

            case R.id.antwort2button:
                if(mButton2.getText() == answer){
                    richtigeAntwort();
                }
                else{
                    falscheAntwort();
                    mButton2.setBackgroundResource(R.color.colorFalse);
                }
                break;

            case R.id.antwort3button:
                if(mButton3.getText() == answer){
                    richtigeAntwort();
                }
                else{
                    falscheAntwort();
                    mButton3.setBackgroundResource(R.color.colorFalse);
                }
                break;

            case R.id.antwort4button:
                if(mButton4.getText() == answer){
                    richtigeAntwort();
                }
                else{
                    falscheAntwort();
                    mButton4.setBackgroundResource(R.color.colorFalse);
                }
                break;
        }
        //Show the correct answer and wait
        Button answerButton = buttons[answerIndex];
        answerButton.setBackgroundResource(R.color.colorCorrect);
        //reset changes and unlock buttons in a different thread
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (Button b : buttons) {
                    b.setBackgroundDrawable(defaultBackground);
                    b.setClickable(true);
                }
            }
        }, 3000);
        //wait until the reset ends and continue the quiz
        new CountDownTimer(3000, 500) {

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
            //finish quiz
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage(getString(R.string.quiz_finish, correctAnswers, num));
            builder.setCancelable(true);
            builder.setNeutralButton(
                    getString(R.string.finish),
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            getActivity().onBackPressed();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        else {
            mTextView.setText(question.getQuestion(num));
            mButton1.setText(question.getchoice1(num));
            mButton2.setText(question.getchoice2(num));
            mButton3.setText(question.getchoice3(num));
            mButton4.setText(question.getchoice4(num));
            answer = question.getCorrectAnswer(num);
            answerIndex = question.getCorrectAnswerIndex(num);
        }
    }

}
