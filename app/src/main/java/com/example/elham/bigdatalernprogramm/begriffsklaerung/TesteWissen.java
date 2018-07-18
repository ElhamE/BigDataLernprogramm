package com.example.elham.bigdatalernprogramm.begriffsklaerung;

/**
 * Main source code taken from Arvin
 * (https://www.sourcecodester.com/android/12062/android-simple-quiz-app.html).
 */

import android.os.Bundle;
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
        switch (v.getId()){
            case R.id.antwort1button:
                if(mButton1.getText() == answer){
                    richtigeAntwort();
                }
                else{
                    falscheAntwort();
                }
                NextQuestion(++questionIndex);
                break;

            case R.id.antwort2button:
                if(mButton2.getText() == answer){
                    richtigeAntwort();
                }
                else{
                    falscheAntwort();
                }
                NextQuestion(++questionIndex);
                break;

            case R.id.antwort3button:
                if(mButton3.getText() == answer){
                    richtigeAntwort();
                }
                else{
                    falscheAntwort();
                }
                NextQuestion(++questionIndex);
                break;

            case R.id.antwort4button:
                if(mButton4.getText() == answer){
                    richtigeAntwort();
                }
                else{
                    falscheAntwort();
                }
                NextQuestion(++questionIndex);
                break;
        }
    }

    private void NextQuestion(int num){
        if (num == question.questions.length){
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
    }

}
