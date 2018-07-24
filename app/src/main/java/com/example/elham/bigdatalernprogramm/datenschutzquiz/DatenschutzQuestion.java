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
            "Was ist \"Datensicherheit\"?",
            "Wann greift der Datenschutz erst?",
            "Was sind personenbezogene Daten?",
            "Welche der folgenden Punkte ist KEINE Verpflichtung für Verantwortliche?",
            "Welche der folgenden Big Data-Verfahren verstößt gegen das Datenschutzrecht?",
            "Betroffene haben nicht das Recht auf ...",
            "Das Datenschutzrecht richtet sich an ...",
            "Verantwortliche müssen Folgendes mit den Betroffenenen besprechen, bevor es zur Verarbeitung personenbezogener Daten kommen kann:",
            "Können anonymisierte Daten datenschutzrechtlich einwandfrei durch Big Data-Verfahren verarbeitet werden?"
    };

    private String choices[][] = {
            {"Ein Synonym für \"Datenschutz\".", "Maßnahmen zum Schutz personenbezogener Daten", "Maßnahmen zum Schutz vor unberechtigtem Datenzugriff", "Gesetze zum Schutz personenbezogener Daten"},
            {"wenn der Betroffene dies ausdrücklich mitteilt", "wenn personenbezogene Daten verarbeitet werden", "immer", "wenn die AGB dies zulässt"},
            {"Daten zur (in)direkten Identifikation von allen Lebewesen dienen", "Daten, die zur (in)direkten Identifikation von Menschen dienen", "Daten, die zum persönlichen Eigentum zählen", "Social-Media-Daten"},
            {"Zweckbindung bei allen Datenanalysen", "die Datenmenge muss dem Zweck angemessen sein", "transparente Verarbeitung für die Betroffenen", "personenbezogenen Daten müssen aktuell und richtig sein"},
            {"Big Data mit künstlicher Intelligenz", "explorative Analysen", "Analysen mit anonymisierten Daten", "zweckgebundene Analysen"},
            {"Widerrufung der Einwilligung zur Datenverarbeitung", "Auskunftsrecht über die Verwendungszwecke", "Anspruch auf Löschung", "einen Anspruch auf Provision am Umsatz"},
            {"Rechtssubjekte, die Daten verarbeiten", "Organisationen, die personenbezogene Daten verarbeiten", "private Unternehmen, die personenbezogene Daten verarbeiten", "Unternehmen und Verwaltungen"},
            {"die Höhe der Provision", "die Höhe des Schadensersatzes", "Benennung des Betroffenen zum Datenschutzbeauftragten", "eine Einwilligung zur Datenverabeitung"},
            {"Jein", "Nein", "das hängt von der Datenmenge ab", "Ja"}
    };

    private String correctAnswer[] = {
            "Maßnahmen zum Schutz vor unberechtigtem Datenzugriff",
            "wenn personenbezogene Daten verarbeitet werden",
            "Daten, die zur (in)direkten Identifikation von Menschen dienen",
            "Zweckbindung bei allen Datenanalysen",
            "explorative Analysen",
            "einen Anspruch auf Provision am Umsatz",
            "Organisationen, die personenbezogene Daten verarbeiten",
            "eine Einwilligung zur Datenverabeitung",
            "Jein",
    };
    //TODO verbessern
    private String wrongAnswers[][] = {
            {"Ein Synonym für \"Datenschutz\".", "Maßnahmen zum Schutz personenbezogener Daten", "Gesetze zum Schutz personenbezogener Daten"},
            {"wenn der Betroffene dies ausdrücklich mitteilt", "immer", "wenn die AGB dies zulässt"},
            {"Daten zur (in)direkten Identifikation von allen Lebewesen dienen", "Daten, die zum persönlichen Eigentum zählen", "Social-Media-Daten"},
            {"die Datenmenge muss dem Zweck angemessen sein", "transparente Verarbeitung für die Betroffenen", "personenbezogenen Daten müssen aktuell und richtig sein"},
            {"Big Data mit künstlicher Intelligenz", "Analysen mit anonymisierten Daten", "zweckgebundene Analysen"},
            {"Widerrufung der Einwilligung zur Datenverarbeitung", "Auskunftsrecht über die Verwendungszwecke", "Anspruch auf Löschung"},
            {"Rechtssubjekte, die Daten verarbeiten", "private Unternehmen, die personenbezogene Daten verarbeiten", "Unternehmen und Verwaltungen"},
            {"die Höhe der Provision", "die Höhe des Schadensersatzes", "Benennung des Betroffenen zum Datenschutzbeauftragten"},
            {"Nein", "das hängt von der Datenmenge ab", "Ja"}
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
