package rps.game;

public interface IPlayer {

    /**
     * Calculate the next move
     *
     * @param g the game object
     * @return the calculated move
     */
    Move nextMove(IGame g);
}
