package com.example.elham.bigdatalernprogramm.datenschutzquiz;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Main source code taken from Arvin
 * (https://www.sourcecodester.com/android/12062/android-simple-quiz-app.html).
 */

public class DatenschutzQuestion {

    private String questions[] = {
            "Bla Bla?",
            "Bluuuuuuuuuuuuuuuuuuuuuuuuub?",
            "Bluuuuuuuuuuuuuuuuuuuuuuuuub?"
    };

    private String choices[][] = {
            {"B", "C", "D", "A"},
            {"Commercial Applications", "Siemens Applications", "Student Applications", "Social Applications"},
            {"C", "D", "A", "B"},
    };

    private String correctAnswer[] = {
            "C",
            "Commercial Applications",
            "C"
    };
    //TODO verbessern
    private String wrongAnswers[][] = {
            {"A", "B", "D"},
            {"Siemens Applications", "Student Applications", "Social Applications"},
            {"A", "B", "D"}
    };

    public String[] getQuestions(){
        return questions;
    }

    public String getQuestion(int a){
        String question = questions[a];
        return question;
    }

    public String getchoice1(int a){
        String choice = choices[a][0];
        return choice;
    }

    public String getchoice2(int a){
        String choice = choices[a][1];
        return choice;
    }

    public String getchoice3(int a){
        String choice = choices[a][2];
        return choice;
    }

    public String getchoice4(int a){
        String choice = choices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = correctAnswer[a];
        return answer;
    }

    public int[] getTwoIndexesOfWrongAnswers(int question)
    {
        int[] indexes = new int[2];
        List<String> wrongAnswerList = Arrays.asList(wrongAnswers[question]);
        List<String> answerList = Arrays.asList(choices[question]);
        String answer = wrongAnswerList.get(0);
        indexes[0] = answerList.indexOf(answer);
        answer = wrongAnswerList.get(1);
        indexes[1] = answerList.indexOf(answer);
        return indexes;
    }

    public int getCorrectAnswerIndex(int a){
        String answer = getCorrectAnswer(a);
        String[] answers = choices[a];
        int index = Arrays.asList(answers).indexOf(answer);
        return index;
    }
}
