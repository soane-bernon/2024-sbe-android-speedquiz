package com.bernsoa.speedquiz.modele;

import android.database.Cursor;

public class Question {
    private final String intituler;
    private final int reponse;

    /**
     * @return l'intitulé de la question
     */
    public String getIntituler() {
        return intituler;
    }

    /**
     * @return vrai si la réponse est vrai et faux sinon.
     */
    public int isReponse() {
        return reponse;
    }

    /**
     * permet de créer une question
     * @param intituler
     * @param reponse
     */
    public Question(String intituler, int reponse) {
        this.reponse = reponse;
        this.intituler = intituler;
    }

    public Question(Cursor cursor){
        intituler = cursor.getString(cursor.getColumnIndexOrThrow("question"));
        reponse = cursor.getInt(cursor.getColumnIndexOrThrow("reponse"));
    }
}


