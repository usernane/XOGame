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
 * This interface represents an object that is interested on observing player object.
 * When an object implement this interface, it can be added as a listener to 
 * any player object.
 * @author Ibrahim
 */
public interface PlayerListener {
    /**
     * This method is invoked when the player play his turn.
     * @param source the player that did the move.
     * @param x_or_o a character, 'X' or 'O'.
     * @param x the row index on the board.
     * @param y the column index on the board.
     * @return true if the move is valid.
     */
    public boolean play(Player source, char x_or_o, int x, int y);
}
