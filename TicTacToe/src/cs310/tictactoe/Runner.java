package cs310.tictactoe;

import cs310.tictactoe.Board.GridMarker;

public class Runner {
	public TicTacToe game;
	public TicTacToe.Player player;
	public TicTacToe.Player winner = null;
	public Interface input;
	
	public Runner(){
		game = new TicTacToe();
		player = TicTacToe.Player.PLAYER_1;
		input=new Interface(this);
		runGame(input);
	}

	public void makeMove(int collum, int row) {
		if(player==TicTacToe.Player.PLAYER_1){
			game.placeTic(collum,row,GridMarker.X);
			player=TicTacToe.Player.PLAYER_2;
		}
		else{
			game.placeTic(collum,row,GridMarker.O);
			player=TicTacToe.Player.PLAYER_1;
		}
	}
	
	public TicTacToe.Player checkVictory(){
		return game.getGameWinner();
	}
	
	public void runGame(Interface input){
		while(winner!=TicTacToe.Player.PLAYER_1&&winner!=TicTacToe.Player.PLAYER_2&&winner!=TicTacToe.Player.CAT){
			int collum =input.getCollum();
			int row = input.getRow();
			try {
				if(game.gameBoard.getMarkFromLocation(collum,row)==Board.GridMarker.BLANK)
					makeMove(collum, row);
			} catch (Exception e) {}
			input.printBoard();
			winner=checkVictory();
			
		}
		input.printWinner(winner);
		game.clearBoard();
		player=TicTacToe.Player.PLAYER_1;
	}
	
	public void setWinner(TicTacToe.Player winner){
		this.winner=winner;
	}

}