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

import java.util.ArrayList;

/**
 * This class represents an entity that can change the game board.
 * @author Ibrahim
 */
public class Player {
    private final ArrayList<PlayerListener> listeners;
    /**
     * The ID of the player.
     * Each player must have a unique ID.
     */
    private final int playerId;
    /**
     * The character that will be placed on the game board.
     * It can be 'X' or 'O'.
     */
    private Character x_or_o;
    
    /**
     * Creates a new instance of Player.
     * The game board will have two players. Each player must have a unique ID.
     * @param Id the ID of the player.
     */
    public Player(int Id){
        this.listeners = new ArrayList<>();
        this.playerId = Id;
    }
    
    public void addPlayerListener(PlayerListener listener){
        if(listener != null){
            this.listeners.add(listener);
        }
    }
    
    /**
     * Sets the character that the player will use on the game board.
     * It can be 'X' or 'O'.
     * @param x_or_o 
     */
    public void setChar(char x_or_o){
        this.x_or_o = x_or_o;
    }

    /**
     * Place an 'X' or 'O' on the game board.
     * The game board is simply a 3x3 2D array. The first argument represents 
     * the row index. The second argument represents the column index. If 
     * the move that the player does is valid, the method will return true. Else,
     * the method will return false. A move is valid only if the place that the 
     * player is playing on is empty.
     * @param rowIndex the row index.
     * @param colIndex the column index.
     */
    public void play(int rowIndex, int colIndex){
        for(PlayerListener l : this.listeners){
            l.play(this, rowIndex, colIndex);
        }
    }
    /**
     * Return the ID of the player.
     * @return the ID of the player.
     */
    public int getID(){
        return this.playerId;
    }
    /**
     * Returns the character that will be used by the player.
     * @return the character that will be used by the player.
     */
    public Character getChar() {
        return this.x_or_o;
    }
    
    @Override
    public String toString(){
        return "Player "+this.playerId;
    }
}
