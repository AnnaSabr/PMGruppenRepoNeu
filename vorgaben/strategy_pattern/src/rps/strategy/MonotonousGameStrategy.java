package rps.strategy;

import rps.game.IGame;
import rps.game.Move;

public class MonotonousGameStrategy implements IGameStrategy{
    private Move move;

    public MonotonousGameStrategy(Move m){
        this.move = m;
    }

    public Move nextMove(IGame g){
        
        return this.move;
    }
}
