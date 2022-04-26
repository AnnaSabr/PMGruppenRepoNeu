
package rps.game;

public interface IGame {

    /**
     * Set the first player.
     *
     * @param p the first player
     */
    void setPlayer1(IPlayer p);

    /**
     * Set the second player.
     *
     * @param p the second player
     */
    void setPlayer2(IPlayer p);

    /**
     * Get the opponents last move.
     *
     * @param p the current player
     * @return the opponents last move
     */
    Move getLastMove(IPlayer p);

    /**
     * Make a move for the current player.
     *
     * 
     */
    void doMove();

    /**
     * Evaluation of the game from the player's point of view.
     *
     * @return the winner of the game or draw
     */
    GameOutcome getGameResult();

    /**
     * Print the game result.
     */
    void printGameResult();
}
