/*
 * Copyright 2017 Ibrahim.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import java.util.Scanner;

/**
 * This class contains the main game logic.
 * @author Ibrahim
 */
public class Game implements Runnable{

    /**
     * Player 1.
     */
    private final Player firstPlayer;
    /**
     * Player 2.
     */
    private final Player secondPlayer;
    /**
     * The playground that the two players will play on.
     */
    private final GameBoard gameBoard;

    /**
     * Creates new instance of the game.
     */
    public Game(){
        this.gameBoard = new GameBoard();
        this.firstPlayer = new Player(1);
        this.secondPlayer = new Player(2);
        this.firstPlayer.setChar('X');
        this.secondPlayer.setChar('O');
    }
    /**
     * This place contains the logic of the game.
     */
    @Override
    public void run() {
        while(!this.gameBoard.isGameFinished()){
            Scanner inputReader;
            int rowIndex;
            int columnIndex;
            int turn = this.gameBoard.getTurn();
            
            if(turn == 1){
                System.out.println("It is player 1 turn: ");
            }
            else{
                System.out.println("It is player 2 turn: ");
            }
            
            //reads and validates row index.
            System.out.print("Enter the row index: ");
            inputReader = new Scanner(System.in);
            rowIndex = inputReader.nextInt();
            if(!this.isValidateInput(rowIndex)){
                System.out.println("Invalid Row Index!");
                continue;
            }
            
            //reads and validates column index.
            System.out.print("Enter the column index: ");
            columnIndex = inputReader.nextInt();
            if(!this.isValidateInput(columnIndex)){
                System.out.println("Invalid Column Index!");
                continue;
            }
            
            /*
                when the method 'play() of the class 'Player' is called, 
                the game board is notifyed since it is observing the player.
            */
            if(turn == 1){
                this.firstPlayer.play(rowIndex, columnIndex);
            }
            else{
                this.secondPlayer.play(rowIndex, columnIndex);
            }
            
            System.out.println("The game board after this move:");
            System.out.println(this.gameBoard);
        }
        Player winner = this.gameBoard.getWinner();
        if(winner != null){
            System.out.println("The Winner Is: "+winner);
        }
        else{
            System.out.println("Tie, No Winner.");
        }
    }

    /**
     * Return true if the given row or column index is valid.
     * A row or column index is valid if it is between 0 and 2 inclusive since 
     * the game board size is 3x3.
     * @param x the row or column index.
     * @return true if the given index is valid.
     */
    private boolean isValidateInput(int x){
        return x >= 0 && x < 3;
    }
}