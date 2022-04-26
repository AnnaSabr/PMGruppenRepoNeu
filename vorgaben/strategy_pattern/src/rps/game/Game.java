package rps.game;

class Game implements IGame {
    private IPlayer player1;
    private int player1Points;
    private Move player1LastMove;
    private IPlayer player2;
    private int player2Points;
    private Move player2LastMove;

    public Game(){
        this.player1Points = 0;
        this.player2Points = 0;
    }
    
    public void setPlayer1(IPlayer p){
        this.player1 = p;
    }

    public void setPlayer2(IPlayer p){
        this.player2 = p;
    }

    public void doMove(){
        Move p1 = this.player1.nextMove(this);
        Move p2 = this.player2.nextMove(this);
        if((p1 == Move.ROCK && p2 == Move.PAPER) || (p1 == Move.PAPER && p2 == Move.SCISSOR) || (p1 == Move.SCISSOR && p2 == Move.ROCK)){
            this.player1Points++;
        }
        else if((p2 == Move.ROCK && p1 == Move.PAPER) || (p2 == Move.PAPER && p1 == Move.SCISSOR) || (p2 == Move.SCISSOR && p1 == Move.ROCK)){
            this.player2Points++;
        }
        this.player1LastMove = p1;
        this.player2LastMove = p2;
    }

    public Move getLastMove(IPlayer p){
        if(p == this.player1){
            return this.player2LastMove;
        }
        else if(p == this.player2){
            return this.player1LastMove;
        }
        else{
            return null;
        }
    }

    public GameOutcome getGameResult(){
        if(player1Points < player2Points){
            return GameOutcome.PLAYER_2;
        }
        else if(player1Points > player2Points){
            return GameOutcome.PLAYER_1;
        }
        else{
            return GameOutcome.DRAW;
        }
    }
    
    public void printGameResult(){
        System.out.println("player1 " + player1Points + " - " + player2Points + " player2");
    }
}
