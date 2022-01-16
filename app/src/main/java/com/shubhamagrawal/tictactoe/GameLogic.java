package com.shubhamagrawal.tictactoe;

import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

public class GameLogic {
    private final int[][] gameBoard;

    private int[] winType = {-1,-1,-1};

    private String[] playerNames = {"Player 1", "Player 2"};
    private Button playAgainBTN;
    private Button homeBTN;
    private TextView playerTurn;

    private int player = 1;
    private int boardFilled = 0;

    GameLogic(){
        this.gameBoard = new int[3][3];

        for(int r=0; r<3; r++){
            for(int c=0; c<3; c++){
                this.gameBoard[r][c] = 0;
            }
        }
    }

    public boolean updateGameBoard(int row, int col) {
        if (this.gameBoard[row-1][col-1] == 0){
            this.gameBoard[row-1][col-1] = player;
            boardFilled++;

            if(player == 1){
                playerTurn.setText((playerNames[1] + "'s Turn"));
            }
            else{
                playerTurn.setText((playerNames[0] + "'s Turn"));
            }

            return true;
        }
        else {
            return false;
        }
    }

    public boolean winnerCheck(){
        boolean isWinner = false;

        for(int r=0; r<3; r++){
            if(gameBoard[r][0] == gameBoard[r][1] && gameBoard[r][0] == gameBoard[r][2]
                    && gameBoard[r][0] != 0){
                isWinner = true;
                this.winType = new int[]{r, 0, 1};
                break;
            }
        }

        for(int c=0; c<3; c++){
            if(gameBoard[0][c] == gameBoard[1][c] && gameBoard[0][c] == gameBoard[2][c]
                    && gameBoard[0][c] != 0){
                isWinner = true;
                this.winType = new int[]{0, c, 2};
                break;
            }
        }

        if(gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2]
                && gameBoard[0][0] != 0){
            isWinner = true;
            this.winType = new int[]{0, 0, 3};
        }

        if(gameBoard[2][0] == gameBoard[1][1] && gameBoard[2][0] == gameBoard[0][2]
                && gameBoard[2][0] != 0){
            isWinner = true;
            this.winType = new int[]{2, 0, 4};
        }

        if (isWinner){
            playAgainBTN.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            playerTurn.setText((playerNames[player-1] + " Wins!!"));
            return true;
        }

        else if (boardFilled == 9){
            playAgainBTN.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            playerTurn.setText(("Tie Game!!"));
            return true;
        }

        return false;
    }

    public void resetGame(){
        for(int r=0; r<3; r++){
            for(int c=0; c<3; c++){
                this.gameBoard[r][c] = 0;
            }
        }

        player = 1;
        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);
        playerTurn.setText((playerNames[0] + "'s Turn"));
        boardFilled = 0;
        this.winType = new int[]{-1, -1, -1};

    }

    public void setPlayAgainBTN(Button playAgainBTN) {
        this.playAgainBTN = playAgainBTN;
    }

    public void setHomeBTN(Button homeBTN) {
        this.homeBTN = homeBTN;
    }

    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;
    }

    public void setPlayerNames(String[] playerNames) {
        if (!playerNames[0].equals("")) {
            this.playerNames[0] = playerNames[0];
        }
        if (!playerNames[1].equals("")){
            this.playerNames[1] = playerNames[1];
        }
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }

    public int getPlayer() {
        return this.player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int[] getWinType(){
        return this.winType;
    }
}
