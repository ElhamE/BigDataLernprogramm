package com.example.elham.bigdatalernprogramm.datenschutzquiz;

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

public class Datenschutzquiz extends Fragment implements View.OnClickListener {

    private static final int JOKER_LIMIT = 3;

    Button mButton1, mButton2, mButton3, mButton4, mJokerButton;
    TextView mFrageLoesungText, mRangText;

    private DatenschutzQuestion question = new DatenschutzQuestion();
    private String answer;
    private int answerIndex;
    private int questionIndex;
    private int jokerCounter;

    private int anzahlKorrekterAntworten;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.datenschutzquiz, container, false);
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
        mButton1 = getActivity().findViewById(R.id.antwort1button);
        mButton1.setOnClickListener(this);
        mButton2 = getActivity().findViewById(R.id.antwort2button);
        mButton2.setOnClickListener(this);
        mButton3 = getActivity().findViewById(R.id.antwort3button);
        mButton3.setOnClickListener(this);
        mButton4 = getActivity().findViewById(R.id.antwort4button);
        mButton4.setOnClickListener(this);

        questionIndex = 0;

        mJokerButton = getActivity().findViewById(R.id.joker);
        mJokerButton.setOnClickListener(this);
        mJokerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++jokerCounter;
                final Button[] buttons = {mButton1, mButton2, mButton3, mButton4};
                final Drawable defaultBackground = mButton4.getBackground();

                //disable the joker for this question
                mJokerButton.setEnabled(false);
                //disable two wrong answers
                int[] indexes = question.getTwoIndexesOfWrongAnswers(questionIndex);
                //alternative solution because setEnable(true) leads to an UI bug
                buttons[indexes[0]].setClickable(false);
                buttons[indexes[0]].setBackgroundResource(R.color.colorJoker);
                buttons[indexes[1]].setClickable(false);
                buttons[indexes[1]].setBackgroundResource(R.color.colorJoker);
            }
        });
        mRangText = getActivity().findViewById(R.id.rang);

        mFrageLoesungText = getActivity().findViewById(R.id.frage_loesung);
        NextQuestion(questionIndex);
    }

    private void richtigeAntwort(){
        ++anzahlKorrekterAntworten;
        String loesungssatz = getString(R.string.richtigeAntwort);
        mFrageLoesungText.setText(loesungssatz);
        mFrageLoesungText.setTypeface(null, Typeface.BOLD_ITALIC);
    }

    private void falscheAntwort(){
        String loesungssatz = getString(R.string.falscheAntwort, answer);
        mFrageLoesungText.setText(loesungssatz);
        mFrageLoesungText.setTypeface(null, Typeface.BOLD_ITALIC);
    }

    @Override
    public void onClick(View v) {
        final Button[] buttons = {mButton1, mButton2, mButton3, mButton4};
        //lock the buttons
        for (Button b : buttons) {
            b.setClickable(false);
        }
        final Drawable defaultBackground = v.getBackground();
        switch (v.getId()){
            //Is the clicked button the correct answer
            case R.id.antwort1button:
                if(mButton1.getText().equals(answer)){
                    richtigeAntwort();
                }
                else{
                    falscheAntwort();
                    mButton1.setBackgroundResource(R.color.colorFalse);
                }
                break;

            case R.id.antwort2button:
                if(mButton2.getText().equals(answer)){
                    richtigeAntwort();
                }
                else{
                    falscheAntwort();
                    mButton2.setBackgroundResource(R.color.colorFalse);
                }
                break;

            case R.id.antwort3button:
                if(mButton3.getText().equals(answer)){
                    richtigeAntwort();
                }
                else{
                    falscheAntwort();
                    mButton3.setBackgroundResource(R.color.colorFalse);
                }
                break;

            case R.id.antwort4button:
                if(mButton4.getText().equals(answer)){
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
        mJokerButton.setClickable(false);
        //reset changes and unlock buttons in a different thread
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (Button b : buttons) {
                    b.setBackgroundDrawable(defaultBackground);
                    mFrageLoesungText.setTypeface(null, Typeface.BOLD);
                    b.setClickable(true);
                    mJokerButton.setClickable(true);
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
        //enable the joker if limit is not reached
        if (jokerCounter < JOKER_LIMIT){
            mJokerButton.setEnabled(true);
        }
        mRangText.setText(werteAntwortenAus());
        mFrageLoesungText.setText(question.getQuestion(num));
        mButton1.setText(question.getchoice1(num));
        mButton2.setText(question.getchoice2(num));
        mButton3.setText(question.getchoice3(num));
        mButton4.setText(question.getchoice4(num));
        answer = question.getCorrectAnswer(num);
        answerIndex = question.getCorrectAnswerIndex(num);
    }

    private String werteAntwortenAus() {
        String result = "Dein Rang: ";
        if (anzahlKorrekterAntworten == 15){
            result += "Skynet, bist du's?";
        }
        else if (anzahlKorrekterAntworten >= 10){
            result += "Datenschutzexperte";
        }
        else if (anzahlKorrekterAntworten >= 5){
            result += "Immerhin etwas";
        }
        else if (anzahlKorrekterAntworten > 0){
            result += "Hör auf zu raten!";
        }
        else{
            result += "Hast du schon angefangen?";
        }
        return result;
    }

}
