package com.bernsoa.speedquiz.modele;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
public class QuestionData {


    private ArrayList<Question> listeQuestions = new ArrayList<>();
    public QuestionData(Context context) {
        listeQuestions = initQuestionList(context);
    }

    /**
     * Charge une liste de question depuis la DB.
     * @param context Le contexte de l'application pour passer la query
     * @return Une arraylist charger de Question
     */

    private ArrayList<Question> initQuestionList(Context context){
        ArrayList<Question> listQuestion = new ArrayList<>();
        SpeedQuizSqlLite helper = new SpeedQuizSqlLite(context);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.query(true,"quiz",new String[]{"idQuiz","question","reponse"},null,null,null,null,"idquiz",null);

        while(cursor.moveToNext()){
            listQuestion.add(new Question(cursor));
        }
        cursor.close();
        db.close();

        return listQuestion;
    }

    public ArrayList<Question> getQuestions() {
        return listeQuestions;
    }
}
