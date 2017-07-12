/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * An interface that can be implemented by any class that is interested
 * on player actions.
 * @author Ibrahim
 */
public interface PlayerListener {
    /**
     * This method is called when the player is playing his turn. 
     * @param source the player who did initiate the event.
     * @param rowIndex the row index on the game board.
     * @param columnIndex the column index on the game board.
     */
    public void play(Player source, int rowIndex, int columnIndex);
}
