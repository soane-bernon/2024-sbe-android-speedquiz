package com.bernsoa.speedquiz.modele;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class SpeedQuizSqlLite extends SQLiteOpenHelper {

    static String DB_NAME = "SpeedQuiz.db";
    static int DB_VERSION = 2;
    public SpeedQuizSqlLite(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE quiz(idQuiz INTEGER PRIMARY KEY, question TEXT, reponse INTEGER);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La capitale de l'Australie est Sydney.\", 0)");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La Terre est plate.\", 0)");
        db.execSQL("INSERT INTO quiz VALUES (null, \"Les éléphants peuvent sauter.\", 0)");
        db.execSQL("INSERT INTO quiz VALUES (null, \"L'eau bout à une température de 100 degrés Celsius.\", 1)");
        db.execSQL("INSERT INTO quiz VALUES (null, \"Le chocolat est toxique pour les chiens.\", 1)");
        db.execSQL("INSERT INTO quiz VALUES (null, \"Les chauves-souris sont aveugles.\", 0)");
        db.execSQL("INSERT INTO quiz VALUES (null, \"Le Canada est le plus grand pays du monde.\", 0)");
        db.execSQL("INSERT INTO quiz VALUES (null, \"Le concombre est un légume.\", 1)");
        db.execSQL("INSERT INTO quiz VALUES (null, \"Les dauphins sont des poissons.\", 0)");
        db.execSQL("INSERT INTO quiz VALUES (null, \"Les tomates sont des fruits.\", 1)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void supprimerBaseDeDonnees(Context context) {
        // Supprimer l'ancienne base de données
        context.deleteDatabase(DB_NAME);
    }
}
