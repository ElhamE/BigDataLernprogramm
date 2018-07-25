package com.example.elham.bigdatalernprogramm.begriffsklaerung;

import java.util.Arrays;

/**
 * Main source code taken from Arvin
 * (https://www.sourcecodester.com/android/12062/android-simple-quiz-app.html).
 */

public class Question {

    private String questions[] = {
            "Das V-Modell ist ÜBERWIEGEND ... orientiert.",
            "Mit Big Data sind Daten gemeint, die ... ",
            "Wann entfalten Daten ihr finanzielles Potenzial?",
            "Welcher relevante Aspekt von Big Data wird durch das V-Modell eher weniger berücksichtigt?",
            "Big Data kann als ein/e ... von Business Intelligence betrachtet werden",
            "Cloud-Computing beschreibt das Bereitstellen von Speicherkapazitäten.",
            "Welcher (salopp formulierter) Zusammenhang besteht zwischen IoT, Cloud-Computing und Big Data?"
    };

    private String choices[][] = {
            {"datenschutz-", "technisch", "mathematisch", "soziologisch"},
            {"enorm, strukturiert & schnell verarbeitbar sind", "enorm, unstrukturiert & schnell verarbeitbar sind", "schnell verhandelbar, heterogen und enorm sind", "schnell verarbeitbar, heterogen und enorm sind"},
            {"bei ihrer Erzeugung", "bei ihrer Erfassung", "bei ihrem Verkauf", "bei ihrer Analyse"},
            {"soziale Auswirkungen", "Umweltschutz", "technische Herausforderungen", "der finanzielle Stellenwert von Daten"},
            {"Konkurrent", "technische Umsetzung", "Erweiterung", "Synonym"},
            {"Ja", "Unter anderem", "Manchmal", "Nein"},
            {"IoT stellt die Daten und Cloud-Computing die Rechner bereit", "IoT stellt die Rechner und Cloud-Computing die Server bereit", "es gibt keinen", "alle sind jeweils für eine bestimmte Art von Daten zuständig"}
};

    private String correctAnswer[] = {
            "technisch",
            "schnell verarbeitbar, heterogen und enorm sind",
            "bei ihrer Analyse",
            "soziale Auswirkungen",
            "Erweiterung",
            "Unter anderem",
            "IoT stellt die Daten und Cloud-Computing die Rechner bereit"
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
