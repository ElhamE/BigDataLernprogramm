package com.example.elham.bigdatalernprogramm.praxis;

import java.util.Arrays;

/**
 * Main source code taken from Arvin
 * (https://www.sourcecodester.com/android/12062/android-simple-quiz-app.html).
 */

public class Question {

    private String questions[] = {
            "Der Teil des Big Data-Prozesses, der üblicherweise am aufwändigsten ist, ist die ...",
            "Kommen herkömmliche Datenverwaltungssysteme mit den Big Data-Anforderungen zurecht?",
            "Die aus Big Data-Analyseergebnisse sind stets korrekt",
            "Nach der Datenerhebung erfolgt die ...",
            "Was ist eine Hauptherausforderung bei der Vereinheitlichung von Daten?"
    };

    private String choices[][] = {
            {"Interpretation", "Datenanoymisierung", "Datenvorverarbeitung", "Datensicherheit"},
            {"Immer", "Nie", "Ja, wenn den Speicherplatz vergrößert.", "Nicht ganz, denn dafür sind sie nicht ausgerichtet."},
            {"Ja, da es sich um mathematische Modelle handelt.", "Ja, da die Daten schon vorher von Fehler bereinigt worden sind.", "Nein, auch diese Analysergebnisse müssen verifiziert und validiert werden.", "Nein, da es sich um Stichproben handelt."},
            {"Modellierung", "Datensäuberung", "Analyse", "Datenakquisition"},
            {"die Daten stehen nicht zur Verfügung", "internationale Datenschutzrichtlinien umsetzen", "die relevanten von unwichtign Informationen trennen", "Zusammenführung von Daten aus verschiedenen Quellen"}
    };

    private String correctAnswer[] = {
            "Datenvorverarbeitung",
            "Nicht ganz, denn dafür sind sie nicht ausgerichtet.",
            "Nein, auch diese Analysergebnisse müssen verifiziert und validiert werden.",
            "Datensäuberung",
            "Zusammenführung von Daten aus verschiedenen Quellen"
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
