package com.bernsoa.speedquiz.controle;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.bernsoa.speedquiz.GameActivity;
import com.bernsoa.speedquiz.modele.QuestionData;

public class GameManager {
    private int questionsSpeed = 5000;
    public QuestionData questionData;
    private int questionIndex = 0;
    private GameActivity gameActivity;
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private Handler mainHandler = new Handler(Looper.getMainLooper());
    private Runnable nextQuestionRunnable = new Runnable() {
        @Override
        public void run() {
            nextQuestion();
            // Affiche la prochaine question d'après la vitesse de jeu (5000 ms)
            mainHandler.postDelayed(this, questionsSpeed);
        }
    };
    private int startTimer = 5;
    private Runnable startTimerRunnable = new Runnable() {
        @Override
        public void run() {
            startTimer--;
            if (startTimer > 0) {
                gameActivity.setQuestion(String.valueOf(startTimer));
                mainHandler.postDelayed(this, 1000);
            } else {
                startGame();
            }
        }
    };

    /**
     * Démarre un timer de 5 seconde
     */
    public void startTimer() {
        startTimer = 5;
        mainHandler.removeCallbacks(nextQuestionRunnable);
        gameActivity.setQuestion(String.valueOf(startTimer));
        mainHandler.postDelayed(startTimerRunnable, 1000);
    }

    /**
     * Démarre la partie avec la première question
     */
    public void startGame() {
        gameActivity.getEndButtons().setVisibility(View.INVISIBLE);
        gameActivity.setQuestion(questionData.getQuestions().get(0).getIntituler());
        // Affiche la question suivante après la fin du timer
        mainHandler.postDelayed(nextQuestionRunnable, questionsSpeed);

        playerOneScore = 0;
        playerTwoScore = 0;
        gameActivity.setScores(playerOneScore, playerTwoScore);
    }

    /**
     * Affiche la question suivante
     */
    public void nextQuestion() {
        questionIndex++;
        if (questionIndex >= questionData.getQuestions().size()) {
            gameActivity.getEndButtons().setVisibility(View.VISIBLE);
            return;
        }
        gameActivity.setQuestion(questionData.getQuestions().get(questionIndex).getIntituler());
    }

    /**
     * @return 1 si la question est vrai, sinon 0
     */
    public int getCurrentAnswer() {
        return questionData.getQuestions().get(questionIndex).isReponse();
    }

    /**
     * Mets a jour le score du joueur qui a répondu
     * @param player le joueur qui a répondu a la question
     */
    public void answerQuestion(int player) {
        System.out.println(questionData.getQuestions());
        System.out.println(questionData.getQuestions().size());
        if (questionIndex >= questionData.getQuestions().size())
            return;
        int scoreAdder = getCurrentAnswer() == 1 ? 1 : -1;
        playerOneScore += player == 1 ? scoreAdder : 0;
        playerTwoScore += player == 2 ? scoreAdder : 0;
        playerOneScore = Math.max(playerOneScore, 0);
        playerTwoScore = Math.max(playerTwoScore, 0);
        gameActivity.setScores(playerOneScore, playerTwoScore);
        mainHandler.removeCallbacks(nextQuestionRunnable);
        mainHandler.postDelayed(nextQuestionRunnable, questionsSpeed);
        nextQuestion();
    }

    /**
     * Setter pour gameActivity
     * @param gameActivity game activity
     */
    public void setGameActivity(GameActivity gameActivity) {
        this.gameActivity = gameActivity;
    }
}