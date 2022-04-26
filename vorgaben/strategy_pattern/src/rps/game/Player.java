package rps.game;

import rps.strategy.IGameStrategy;

class Player implements IPlayer { 
    private IGameStrategy gameStartegy;
    
    public Player(IGameStrategy gs){
        this.gameStartegy = gs;
    }
    
    public Move nextMove(IGame g){
        return this.gameStartegy.nextMove(g);
    } 
}
