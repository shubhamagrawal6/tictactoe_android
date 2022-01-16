package com.shubhamagrawal.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameDisplay extends AppCompatActivity {

    private TicTacToeBoard ticTacToeBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);

        Button playAgainBTN = findViewById(R.id.playAgainButton);
        Button homeBTN = findViewById(R.id.homeButton);
        TextView playerTurn = findViewById(R.id.playerTurn);

        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);

        String[] playerNames = getIntent().getStringArrayExtra("PLAYER_NAMES");

        if (!playerNames[0].equals("")){
            playerTurn.setText((playerNames[0] + "'s Turn"));
        }
        else{
            playerTurn.setText(("Player 1's Turn"));
        }

        ticTacToeBoard = findViewById(R.id.ticTacToeBoard);
        ticTacToeBoard.setUpGame(playAgainBTN, homeBTN, playerTurn, playerNames);
    }

    public void playAgainButtonClick(View view){
        ticTacToeBoard.resetGame();

        ticTacToeBoard.invalidate();
    }

    public void homeButtonClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}