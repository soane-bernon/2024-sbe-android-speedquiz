package com.bernsoa.speedquiz.controle;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.bernsoa.speedquiz.modele.Question;
import com.bernsoa.speedquiz.modele.QuestionData;
import com.bernsoa.speedquiz.modele.SpeedQuizSqlLite;

import java.util.ArrayList;

public class GameManager {
    /**
     * Déclenche la recherche de question/reponse et stop le callback une fois terminée
     */
    private void startQuestionIteraLive(){

    }

    /**
     * Charge une liste de question depuis la DB.
     * @param context Le contexte de l'application pour passer la query
     * @return Une arraylist charger de Question
     */
    /*
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
    */
}
