package com.example.elham.bigdatalernprogramm.chancenundrisiken;

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
import android.widget.TextView;

import com.example.elham.bigdatalernprogramm.R;

public class WahroderFalschQuiz extends Fragment implements View.OnClickListener {
    Button mTrueButton, mFalseButton;
    TextView mTextView;

    private WahroderFalschQuestion question = new WahroderFalschQuestion();
    private String answer;
    private int answerIndex;
    private int questionIndex;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.chancen_risiken_quiz, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        //introduction dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(getString(R.string.Datenschutzquiz_introduction));
        builder.setCancelable(true);
        builder.setNeutralButton(
                getString(R.string.startQuiz),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onStart() {
        super.onStart();
        mTrueButton = getActivity().findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(this);
        mFalseButton = getActivity().findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(this);
        mTextView = getActivity().findViewById(R.id.frage_loesung);
        questionIndex = 0;
        NextQuestion(questionIndex);
    }

    private void gibAntwortAus(boolean gewaehlteAntwort){
        String loesungssatz;
        if (gewaehlteAntwort){
            loesungssatz = getString(R.string.richtigeAntwort);
        }
        else {
            loesungssatz = getString(R.string.falscheAntwort);
        }
        mTextView.setText(loesungssatz);
        mTextView.setTypeface(null, Typeface.BOLD_ITALIC);
    }


    @Override
    public void onClick(View v) {
        final Button[] buttons = {mTrueButton, mFalseButton};
        //lock the buttons
        for (Button b : buttons) {
            b.setClickable(false);
        }
        final Drawable defaultBackground = v.getBackground();

        //Is the clicked button the correct answer
        switch (v.getId()){
            case R.id.true_button:
                if(mTrueButton.getText() == answer){
                    gibAntwortAus(true);
                }
                else{
                    gibAntwortAus(false);
                }
                break;

            case R.id.false_button:
                if(mFalseButton.getText() == answer){
                    gibAntwortAus(true);
                }
                else{
                    gibAntwortAus(false);
                }
                break;
        }
        //reset changes and unlock buttons in a different thread
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (Button b : buttons) {
                    b.setClickable(true);
                }
            }
        }, 3000);
        //wait until the reset ends and continue the quiz
        new CountDownTimer(3000, 1000) {

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
        mTrueButton.setText(question.getchoice1(num));
        mFalseButton.setText(question.getchoice2(num));
        answer = question.getCorrectAnswer(num);
        answerIndex = question.getCorrectAnswerIndex(num);
    }

}
