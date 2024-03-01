package com.bernsoa.speedquiz;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bernsoa.speedquiz.controle.GameManager;
import com.bernsoa.speedquiz.modele.QuestionData;
import com.bernsoa.speedquiz.modele.SpeedQuizSqlLite;
import com.google.android.material.button.MaterialButton;
public class GameActivity extends AppCompatActivity{
    private GameManager gameManager = new GameManager();
    private SpeedQuizSqlLite speedQuizSqlLite = new SpeedQuizSqlLite(this);
    private TextView TV_NamePlayer1;
    private TextView TV_NamePlayer2;
    private MaterialButton BT_ClicPlayer2;
    private TextView TV_QuestionPlayer2;
    private TextView TV_ScorePlayer1;
    private TextView TV_ScorePlayer2;
    private MaterialButton BT_Rejouer;
    private MaterialButton BT_Menu;
    private MaterialButton BT_ClicPlayer1;
    private TextView TV_QuestionPlayer1;
    private RelativeLayout endButtons;
    Runnable questionRunnable=null;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        TV_NamePlayer1 = findViewById(R.id.namePlayer1);
        TV_NamePlayer2 = findViewById(R.id.namePlayer2);
        BT_ClicPlayer2 = findViewById(R.id.clicP2);
        TV_QuestionPlayer2 = findViewById(R.id.questionPlayer2);
        TV_ScorePlayer1 = findViewById(R.id.scoreP1);
        TV_ScorePlayer2 = findViewById(R.id.scoreP2);
        BT_Rejouer = findViewById(R.id.restart);
        BT_Menu = findViewById(R.id.menu);
        BT_ClicPlayer1 = findViewById(R.id.clicP1);
        TV_QuestionPlayer1 = findViewById(R.id.questionPlayer1);
        endButtons = findViewById(R.id.end_buttons);


        Intent gameActivity = getIntent();

        String namePlayer1 = String.valueOf(gameActivity.getStringExtra("Player1"));
        String namePlayer2 = String.valueOf(gameActivity.getStringExtra("Player2"));

        TV_NamePlayer1.setText(namePlayer1);
        TV_NamePlayer2.setText(namePlayer2);


    }

    @Override
    protected void onStart() {
        super.onStart();
        gameManager.setGameActivity(this);
        gameManager.questionData = new QuestionData(this);
        gameManager.startTimer();

        BT_Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        BT_Rejouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

        BT_ClicPlayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameManager.answerQuestion(1);
            }
        });

        BT_ClicPlayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameManager.answerQuestion(2);
            }
        });
    }

    /**
     * Affiche la question passée en paramètre pour les deux joueurs
     * @param question question a afficher
     */
    public void setQuestion(String question) {
        TV_QuestionPlayer1.setText(question);
        TV_QuestionPlayer2.setText(question);
    }

    /**
     * Affiche les score des joueurs
     * @param scoreP1 score du joueur 1
     * @param scoreP2 score du joueur 2
     */
    public void setScores(int scoreP1, int scoreP2){
        TV_ScorePlayer1.setText(String.valueOf(scoreP1));
        TV_ScorePlayer2.setText(String.valueOf(scoreP2));
    }

    public RelativeLayout getEndButtons(){
        return endButtons;
    }
}
