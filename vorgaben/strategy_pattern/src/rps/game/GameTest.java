package rps.game;

import rps.strategy.MonotonousGameStrategy;

class GameTest {
    public static void main(String[] args) {
        IPlayer pascal = new Player(new MonotonousGameStrategy(Move.PAPER));
        IPlayer cesar = new Player(new MonotonousGameStrategy(Move.ROCK));
        IGame game = new Game();
        game.setPlayer1(pascal);
        game.setPlayer2(cesar);
        game.doMove();
        game.printGameResult();
    }
}
