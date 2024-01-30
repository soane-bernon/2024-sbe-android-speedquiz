package com.bernsoa.speedquiz.modele;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SpeedQuizSqlLite extends SQLiteOpenHelper {

    static String DB_NAME = "SpeedQuiz.db";
    static int DB_VERSION = 1;
    public SpeedQuizSqlLite(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateTable = "CREATE TABLE quiz(idQuiz INTEGER PRIMARY KEY, question TEXT, reponse INTEGER);";
        db.execSQL(sqlCreateTable);
        db.execSQL("INSERT INTO quiz VALUES (null, \"La capitale de l'Australie est Sydney\", 0)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
