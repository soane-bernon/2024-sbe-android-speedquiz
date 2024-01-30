package com.bernsoa.speedquiz.modele;
import java.util.ArrayList;
public class QuestionData {
    private ArrayList<Question> listeQuestions = new ArrayList<>();

    public void fillQuestions () {
        listeQuestions.add(new Question("La Terre est plate.", false));
        listeQuestions.add(new Question("Le soleil tourne autour de la Terre.", false));
        listeQuestions.add(new Question("Les éléphants peuvent sauter.", false));
        listeQuestions.add(new Question("L'eau bout à une température de 100 degrés Celsius.", true));
        listeQuestions.add(new Question("Les humains peuvent respirer sous l'eau sans équipement.", false));
        listeQuestions.add(new Question("Le chocolat est toxique pour les chiens.", true));
        listeQuestions.add(new Question("Les chauves-souris sont aveugles.", false));
        listeQuestions.add(new Question("Le Canada est le plus grand pays du monde.", false));
        listeQuestions.add(new Question("Les humains peuvent survivre sans sommeil.", false));
        listeQuestions.add(new Question("La lune a sa propre lumière.", false));
        listeQuestions.add(new Question("La pizza est originaire d'Italie.", true));
        listeQuestions.add(new Question("Le concombre est un légume.", true));
        listeQuestions.add(new Question("Les dauphins sont des poissons.", false));
        listeQuestions.add(new Question("Les tomates sont des fruits.", true));
        listeQuestions.add(new Question("Les serpents ont des oreilles externes.", false));
    }

    public ArrayList<Question> getListQuestions() {
        return listeQuestions;
    }
}
