package com.bernsoa.speedquiz;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bernsoa.speedquiz.controle.GameManager;
import com.google.android.material.button.MaterialButton;
public class GameActivity extends AppCompatActivity{
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


        Intent gameActivity = getIntent();

        String namePlayer1 = String.valueOf(gameActivity.getStringExtra("Player1"));
        String namePlayer2 = String.valueOf(gameActivity.getStringExtra("Player2"));

        TV_NamePlayer1.setText(namePlayer1);
        TV_NamePlayer2.setText(namePlayer2);


    }

    @Override
    protected void onStart() {
        super.onStart();
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
    }

    /*
    private void startQuestionIterative(){
        handler = new Handler();
        questionRunnable = new Runnable() {
            @Override
            public void run() {
                if ("fin de question ?") {
                    // code fin de partie
                    handler.removeCallbacks(this);
                } else {
                    // code pour poser une question
                    handler.postDelayed(this, 2000);
                }
            }
        };
        handler.postDelayed(questionRunnable, 1000);
    }*/
}

