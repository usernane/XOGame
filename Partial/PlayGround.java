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


/**
 * The playground is the place where the two players will put 'X' and 'O'.
 * @author Ibrahim
 */
public class PlayGround{
    private final Character [][] gameGrid;
    private final Player firstPlayer;
    private final Player secondPlayer;
    private int turn;
    
    public PlayGround(){
        this.gameGrid = new Character[3][3];
        this.firstPlayer = new Player(1);
        this.firstPlayer.setChar('X');
        this.secondPlayer = new Player(2);
        this.secondPlayer.setChar('O');
        this.turn = 1;
    }


    /**
     * Returns Player 1.
     * @return Player 1.
     */
    public Player getPlayer1(){
        return this.firstPlayer;
    }
    /**
     * Returns Player 2.
     * @return Player 2.
     */
    public Player getPlayer2(){
        return this.secondPlayer;
    }
    /**
     * Checks if the game is finished.
     * The game is finished only if the game board is full or someone has win 
     * the game.
     * @return true if the game is finished.
     */
    public boolean isGameFinished(){
        if(this.getWinner() != null){
            return true;
        }
        for (Character[] charArr : this.gameGrid) {
            for (Character c : charArr) {
                if (c == null) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public Player getWinner(){
        boolean rowsCheck = this.checkRows();
        boolean colCheck = this.checkColumns();
        boolean diagonalsCheck = this.checkDiagonals();
        if(rowsCheck || colCheck || diagonalsCheck){
            if(turn == 2){
                return this.firstPlayer;
            }
            else if(turn == 1){
                return this.secondPlayer;
            }
        }
        return null;
    }
    /**
     * Return the number of the next player to play.
     * It can be only 1 (first player) or 2 (second player).
     * @return the number of the next player to play.
     */
    public int getTurn(){
        return this.turn;
    }

    @Override
    public String toString(){
        String retVal = "";
        for(int i = 0 ; i < this.gameGrid.length ; i++){
            for(int j = 0 ; j < this.gameGrid[i].length ; j++){
                if(this.gameGrid[i][j] != null){
                    if(j + 1 == this.gameGrid[i].length){
                        retVal += this.gameGrid[i][j];
                    }
                    else{
                        retVal += this.gameGrid[i][j]+"|";
                    }
                }
                else{
                    if(j + 1 == this.gameGrid[i].length){
                        retVal += " ";
                    }
                    else{
                        retVal += " |";
                    }
                }
            }
            if(i + 1 != this.gameGrid.length){
                retVal += "\n-----\n";
            }
        }
        return retVal;
    }
    
    //the next set of methods are used to check the 
    //grid after every move a player makes to see if he is the winner.
    
    private boolean checkRows(){
        boolean b = false;
        for(int i = 0 ; i < this.gameGrid.length ; i++){
            b = b || this.checkRow(i);
        }
        return b;
    }
    
    private boolean checkRow(int r){
        Character toCheck = this.gameGrid[r][0];
        if(toCheck != null){
            return toCheck.equals(this.gameGrid[r][1]) && toCheck.equals(this.gameGrid[r][2]);
        }
        return false;
    }
    
    private boolean checkColumns(){
        boolean b = false;
        for(int i = 0 ; i < this.gameGrid[0].length ; i++){
            b = b || this.checkColumn(i);
        }
        return b;
    }
    
    private boolean checkColumn(int c){
        Character toCheck = this.gameGrid[0][c];
        if(toCheck != null){
            return toCheck.equals(this.gameGrid[1][c]) && toCheck.equals(this.gameGrid[2][c]);
        }
        return false;
    }
    
    private boolean checkDiagonals(){
        return this.checkDiagonal(0) || this.checkDiagonal(1);
    }
    
    private boolean checkDiagonal(int d){
        if(d == 0){
            Character toCheck = this.gameGrid[0][0];
            if(toCheck != null){
                return toCheck.equals(this.gameGrid[1][1]) && toCheck.equals(this.gameGrid[2][2]);
            }
        }
        else{
            Character toCheck = this.gameGrid[2][0];
            if(toCheck != null){
                return toCheck.equals(this.gameGrid[1][1]) && toCheck.equals(this.gameGrid[0][2]);
            }
        }
        return false;
    }
    public static void main(String a[]){
        PlayGround p = new PlayGround();
        System.out.println(p);
        System.out.println(p.checkColumns());
    }
}
