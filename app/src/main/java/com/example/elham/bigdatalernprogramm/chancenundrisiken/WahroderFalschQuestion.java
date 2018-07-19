package com.example.elham.bigdatalernprogramm.chancenundrisiken;

import java.util.Arrays;

/**
 * Main source code taken from Arvin
 * (https://www.sourcecodester.com/android/12062/android-simple-quiz-app.html).
 */

public class WahroderFalschQuestion {

    private String questions[] = {
            "Which is a Programming Language?",
            "Programming language COBOL works best for use in?"
    };

    private String choices[][] = {
            {"HTML", "CSS", "Vala", "PHP"},
            {"Siemens Applications", "Student Applications", "Social Applications", "Commercial Applications"}
    };

    private String correctAnswer[] = {
            "PHP",
            "Commercial Applications"
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

    public int getCorrectAnswerIndex(int a){
        String answer = getCorrectAnswer(a);
        String[] answers = choices[a];
        int index = Arrays.asList(answers).indexOf(answer);
        return index;
    }
}
