package com.example.tic_tacgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class twoplayer extends AppCompatActivity {

    boolean ActiveGame = true;
    Button button;
    Dialog dialog;
    int scoreone, scoretwo = 0, counter = 0,r=0;
    boolean turn = true;
    TextView textturn,playerone, playertwo,score;
    int Board[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twoplayer);


        playerone = findViewById(R.id.playerone);
        playertwo = findViewById(R.id.playertwo);
        score=findViewById(R.id.textscore);
        textturn=findViewById(R.id.turn);
        textturn.setText("X Turn");

        dialog = new Dialog(this);
         score.setText(scoreone+" | "+scoretwo);
        Intent intent = getIntent();
        if (intent != null) {
            ArrayList<String> list;
            list = intent.getStringArrayListExtra("names");
            playerone.setText(list.get(0));
            playertwo.setText(list.get(1));
        }

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }


    public int put() {
        if (Board[r] != 0 && Board[r] != -1 && ActiveGame) {
            if (turn)
                Board[r] = 0;
            else
                Board[r] = -1;

            return 1;
        }
        return 0;
    }

    public void Game() {

        if (turn) {
            button.setText("X");
            button.setBackground(getDrawable(android.R.color.holo_orange_dark));
            if (whoWinGame() != 0) {
                ActiveGame = false;
                scoreone++;
                score.setText(scoreone+" | "+scoretwo);
                ShowDialog(1);
            }
            turn = false;
            textturn.setText("O Turn");
            counter++;

        } else {
            button.setText("O");
            button.setBackground(getDrawable(android.R.color.holo_blue_light));
            if (whoWinGame() != 0) {
                ActiveGame = false;
                ShowDialog(2);
                scoretwo++;
                score.setText(scoreone+" | "+scoretwo);

            }
            turn = true;
            textturn.setText("X Turn");
            counter++;
        }

        if (counter == 9)
            ShowDialog(0);

    }

    public void one(View view) {

        button = findViewById(R.id.one);
        r = 0;
        if (put() == 1)
            Game();

    }

    public void two(View view) {

        button = findViewById(R.id.two);
        r = 1;
        if (put() == 1)
            Game();
    }

    public void three(View view) {
        button = findViewById(R.id.three);
        r = 2;
        if (put() == 1)
            Game();
    }

    public void four(View view) {
        button = findViewById(R.id.four);
        r = 3;
        if (put() == 1)
            Game();
    }

    public void five(View view) {

        button = findViewById(R.id.five);
        r = 4;

        if (put() == 1)
            Game();
    }

    public void six(View view) {
        button = findViewById(R.id.six);
        r = 5;
        if (put() == 1)
            Game();
    }

    public void seven(View view) {

        button = findViewById(R.id.seven);
        r = 6;
        if (put() == 1)
            Game();

    }

    public void eight(View view) {

        button = findViewById(R.id.eight);
        r = 7;
        if (put() == 1)
            Game();

    }

    public void nine(View view) {

        button = findViewById(R.id.nine);
        r = 8;
        if (put() == 1)
            Game();

    }

    public int whoWinGame() {

        if (Board[0] == 0 && Board[1] == 0 && Board[2] == 0)// for player one row by row
            return 1;
        if (Board[3] == 0 && Board[4] == 0 && Board[5] == 0)
            return 1;
        if (Board[6] == 0 && Board[7] == 0 && Board[8] == 0)
            return 1;

        if (Board[0] == 0 && Board[3] == 0 && Board[6] == 0)// for player one by column
            return 1;
        if (Board[1] == 0 && Board[4] == 0 && Board[7] == 0)
            return 1;
        if (Board[2] == 0 && Board[5] == 0 && Board[8] == 0)
            return 1;

        if (Board[0] == 0 && Board[4] == 0 && Board[8] == 0)// for player one dia
            return 1;
        if (Board[2] == 0 && Board[4] == 0 && Board[6] == 0)
            return 1;


        if (Board[0] == -1 && Board[1] == -1 && Board[2] == -1)// for player two row by row
            return 2;
        if (Board[3] == -1 && Board[4] == -1 && Board[5] == -1)
            return 2;
        if (Board[6] == -1 && Board[7] == -1 && Board[8] == -1)
            return 2;

        if (Board[0] == -1 && Board[3] == -1 && Board[6] == -1)// for player two by column
            return 2;
        if (Board[1] == -1 && Board[4] == -1 && Board[7] == -1)
            return 2;
        if (Board[2] == -1 && Board[5] == -1 && Board[8] == -1)
            return 2;

        if (Board[0] == -1 && Board[4] == -1 && Board[8] == -1)// for player two dia
            return 2;
        if (Board[2] == -1 && Board[4] == -1 && Board[6] == -1)
            return 2;

        return 0;

    }

    public void ShowDialog(int v) {
        // if v==1 player one win game if v==2 player 2 win game if v==0 game over

        dialog.setContentView(R.layout.showdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView imageView = dialog.findViewById(R.id.imageView);
        TextView text = dialog.findViewById(R.id.winner);

        if (v == 1)
            text.setText(playerone.getText().toString() + " Win Game");


        else if (v == 2)
            text.setText(playertwo.getText().toString() + " Win Game");


        else {
            text.setText("No one Win Game");
            imageView.setImageResource(R.drawable.over);
        }

        Button home = dialog.findViewById(R.id.home);
        Button playAgain = dialog.findViewById(R.id.playagain);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(twoplayer.this, MainActivity.class));
            }
        });
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResetGame();
                dialog.dismiss();

            }
        });
        dialog.show();

    }

    public void ResetGame() {
        counter = 0;
        int index = 0;
        for (int i = 1; i <= 9; i++) {
            Board[index] = i;
            index++;
        }
        ActiveGame = true;
        turn = true;
        textturn.setText("X Turn");

        ResetButton(button = findViewById(R.id.one));
        ResetButton(button = findViewById(R.id.two));
        ResetButton(button = findViewById(R.id.three));
        ResetButton(button = findViewById(R.id.four));
        ResetButton(button = findViewById(R.id.five));
        ResetButton(button = findViewById(R.id.six));
        ResetButton(button = findViewById(R.id.seven));
        ResetButton(button = findViewById(R.id.eight));
        ResetButton(button = findViewById(R.id.nine));
    }

    public void ResetButton(View view) {

        button.setBackground(getDrawable(R.color.white));
        button.setText("");
    }


}