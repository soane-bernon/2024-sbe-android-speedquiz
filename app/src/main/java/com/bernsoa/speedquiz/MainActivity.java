package com.bernsoa.speedquiz;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.bernsoa.speedquiz.controle.GameManager;
import com.bernsoa.speedquiz.modele.SpeedQuizSqlLite;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private MaterialToolbar Menu_TopBar;
    private MaterialButton BT_Start_AddPlayer;
    private EditText ET_Start_Player1;
    private EditText ET_Start_Player2;
    private MaterialButton BT_StartGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Menu_TopBar = findViewById(R.id.main_toolbar);
        BT_Start_AddPlayer = findViewById(R.id.btn_startAddPlayer);
        ET_Start_Player1 = findViewById(R.id.startPlayer1ET);
        ET_Start_Player2 = findViewById(R.id.startPlayer2ET);
        BT_StartGame = findViewById(R.id.btn_startNewGame);

        // Désactive les champs texte et le bouton
        ET_Start_Player1.setEnabled(false);
        ET_Start_Player2.setEnabled(false);
        BT_StartGame.setEnabled(false);
    }

    @Override
    protected void onStart() {
        super.onStart();
        BT_Start_AddPlayer.setOnClickListener(v -> {
            if (ET_Start_Player1.getVisibility() == View.VISIBLE) {
                ET_Start_Player2.setEnabled(true);
                ET_Start_Player2.setVisibility(View.VISIBLE);
                BT_StartGame.setEnabled(false);
                BT_StartGame.setVisibility(View.VISIBLE);
            } else {
                ET_Start_Player1.setEnabled(true);
                ET_Start_Player1.setVisibility(View.VISIBLE);
            }
        });

        ET_Start_Player2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                BT_StartGame.setEnabled(!ET_Start_Player2.getText().toString().isEmpty() &&
                                        !ET_Start_Player1.getText().toString().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ET_Start_Player1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                BT_StartGame.setEnabled(!ET_Start_Player2.getText().toString().isEmpty() &&
                                        !ET_Start_Player1.getText().toString().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        BT_StartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GameActivity = new Intent(MainActivity.this, GameActivity.class);
                GameActivity.putExtra("Player1", ET_Start_Player1.getText().toString());
                GameActivity.putExtra("Player2", ET_Start_Player2.getText().toString());
                startActivity(GameActivity);
            }
        });
    }
}
