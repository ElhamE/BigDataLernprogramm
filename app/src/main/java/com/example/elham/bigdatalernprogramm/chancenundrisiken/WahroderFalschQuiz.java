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
    private Button mTrueButton, mFalseButton;
    private TextView mTextView;

    private WahroderFalschQuestion question = new WahroderFalschQuestion();
    private String answer;
    private int answerIndex;
    private int questionIndex;
    private int correctAnwers;

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
        builder.setMessage(getString(R.string.wahr_oder_falsch_introduction));
        builder.setCancelable(false);
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
        if (gewaehlteAntwort){
            ++correctAnwers;
        }
        String[] solutionArray = getResources().getStringArray(R.array.auflösung);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(solutionArray[questionIndex]);
        builder.setCancelable(false);
        builder.setNeutralButton(
                getString(R.string.proceed),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        //proceed with the quiz
                        NextQuestion(++questionIndex);
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }


    @Override
    public void onClick(View v) {
        //Is the clicked button the correct answer
        switch (v.getId()){
            case R.id.true_button:
                if(mTrueButton.getText().equals(answer)){
                    gibAntwortAus(true);
                }
                else{
                    gibAntwortAus(false);
                }
                break;

            case R.id.false_button:
                if(mFalseButton.getText().equals(answer)){
                    gibAntwortAus(true);
                }
                else{
                    gibAntwortAus(false);
                }
                break;
        }
    }


    private void NextQuestion(int num){
        if (num == question.getQuestions().length){
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage(getString(R.string.quiz_finish, correctAnwers, question.getQuestions().length));
            builder.setCancelable(false);
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
        else{
            mTextView.setText(question.getQuestion(num));
            mTrueButton.setText(question.getchoice1(num));
            mFalseButton.setText(question.getchoice2(num));
            answer = question.getCorrectAnswer(num);
            answerIndex = question.getCorrectAnswerIndex(num);
        }
    }

}
