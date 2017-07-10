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
     * The playground that the two players will play on.
     */
    private final PlayGround playGround;

    /**
     * Creates new instance of the game.
     */
    public Game(){
        this.playGround = new PlayGround();
    }
    /**
     * This place contains the logic of the game.
     */
    @Override
    public void run() {
        while(!this.playGround.isGameFinished()){
            int turn = this.playGround.getTurn();
            if(turn == 1){
                System.out.println("It is player 1 turn: ");
            }
            else{
                System.out.println("It is player 2 turn: ");
            }
            System.out.print("Enter the row index: ");
            Scanner input = new Scanner(System.in);
            int row = input.nextInt();
            if(!this.isValidateInput(row)){
                System.out.println("Invalid Row Index!");
                continue;
            }
            System.out.print("Enter the column index: ");
            int col = input.nextInt();
            if(!this.isValidateInput(col)){
                System.out.println("Invalid Column Index!");
                continue;
            }
            boolean validMove;
            if(turn == 1){
                validMove = this.playGround.getPlayer1().play(row, col);
            }
            else{
                validMove = this.playGround.getPlayer2().play(row, col);
            }
            if(validMove){
                System.out.println("The game board after this move:");
                System.out.println(this.playGround);
            }
            else{
                System.out.println("Invalid move!");
            }
        }
        Player winner = this.playGround.getWinner();
        if(winner != null){
            System.out.println("The Winner Is: "+winner);
        }
        else{
            System.out.println("Tie, No one wins.");
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
