package com.example.elham.bigdatalernprogramm.chancenundrisiken;

import java.util.Arrays;

/**
 * Main source code taken from Arvin
 * (https://www.sourcecodester.com/android/12062/android-simple-quiz-app.html).
 */

public class WahroderFalschQuestion {

    private String questions[] = {
            "Mithilfe von Behörden-, Unternehmens- und Social Media-Daten kann ein \"sozialer Score\" ermittelt werden, der das Verhalten von Bürgern in der Gesellschaft bewertet. \"Brave\" Bürger werden belohnt und \"schlechte\" bestraft.",
            "Die Polizei in Washington D.C. besitzt eine \"Precrime-Abteilung\", die Big Data nutzt, um den Zeitpunkt und die potentiellen Verursacher von schweren Straftaten zu ermitteln und diese in Gewahrsam zu nehmen.",
            "Die Sensordaten von Fahrzeugen werden u.a. verwertet, um Unfälle zu verhindern, Fahrtwege zu optimieren, den Treibstoffverbrauch zu verbessern und die Fahrer zu beurteilen.",
            "Im Zuge der fortgeschrittenen Datenanalysen schreiben einige US-Unternehmen ihren Angestellten vor, ihre Gesundheitsdaten (z.B. Blutzucker- und Körperfettwerte) preiszugeben und bitten diese bei Überschreitung von Grenzwerten zur Kasse.",
            "Patientdaten werden gründlich analysiert, um Profile zu erstellen und spezielle Pflegeoboter damit lernen zu lassen. Diese Roboter ersetzen dann die menschlichen Fachkräfte für die entsprechenden Patienten.",
            "Das israelische Militär hat einen unbemannten Kampfroboter entwickelt, der mittels KI selbst im Eifer des Gefechts Freund von Feind unterscheiden kann. Dafür lernt er kontinuierlich, indem ihm zusätzlich zu seinen Sensordaten Daten von außen zugespeist werden.",
            "Für Wahlkampf- und Marketingzwecke werden Big Data-instrumente verwendet, die eine personalisierte und zielgerichtete Kontaktaufnahme mit Individuen und Gruppen ermöglicht. Dafür werden die gegebenen Daten über eine Person ausgewertet, woraufhin dieser einer \"Kategorie\" zugeordnet wird."
    };

    private String choices[][] = {
            {"So etwas wird bereits geplant.", "Setz' den Aluhut ab!"},
            {"Das hört sich zwar unrealistisch an, aber existiert tatsächlich.", "Das ist doch aus einem Science Fiction-Film geklaut."},
            {"Hört sich plausibel an.", "Das ist illegal."},
            {"Jo", "Humbug!"},
            {"Dies ist eine Maßnahme zur Bekämpfung des Pflegenotstands.", "Schön wär's!"},
            {"Ja, das ist wahr!", "Da kann nicht einmal der Terminator mithalten."},
            {"Das ist ein bewährtes Verfahren.", "...und ich bin der Kaiser von China."}
    };

    private String correctAnswer[] = {
            "So etwas wird bereits geplant.",
            "Das ist doch aus einem Science Fiction-Film geklaut.",
            "Hört sich plausibel an.",
            "Jo",
            "Schön wär's!",
            "Da kann nicht einmal der Terminator mithalten.",
            "Das ist ein bewährtes Verfahren."
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
