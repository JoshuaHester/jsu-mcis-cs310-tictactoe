//package cs310.tictactoe;

public class TicTacToe {
	
	public Board gameBoard;
	
	public enum Player{
		PLAYER_1, 
		PLAYER_2, 
		CAT;
		public String toString(){
			if(this==PLAYER_1)
				return "Player 1";
			else if(this==PLAYER_2)
				return "Player 2";
			else if(this==CAT)
				return "Cat";
			else return null;
			
		}
		
	}
	
	public Player currentPlayer = Player.PLAYER_1;
	
	public TicTacToe(){
		gameBoard = new Board();
	}

	public void markLocation(int collum,int row, char mark) throws Exception{
		if(mark=='X'||mark=='x')
			placeTic(collum,row, Board.GridMarker.X);
		else
			placeTic(collum,row, Board.GridMarker.O);
	}
	
	public void placeTic(int collum,int row, Board.GridMarker mark) throws Exception{
		if(getTicMark(collum, row)==Board.GridMarker.BLANK)
			gameBoard.setMarkOnBoard(collum, row, mark);
	}
	
	public Board.GridMarker getTicMark(int collum, int row) throws Exception {
		if(gameBoard.getMarkFromLocation(collum, row)==Board.GridMarker.X)
			return Board.GridMarker.X;
		else if(gameBoard.getMarkFromLocation(collum, row)==Board.GridMarker.O)
			return Board.GridMarker.O;
		return Board.GridMarker.BLANK;
	}
	
	public String getMarker(int collum, int row){
		try{
			return getTicMark(collum, row).toString();
		} catch(Exception e){return "Invalid Position";}
	}
	
	public Player getGameWinner(){
		if(checkForVictory(Board.GridMarker.X)) 
			return Player.PLAYER_1;
		else if(checkForVictory(Board.GridMarker.O)) 
			return Player.PLAYER_2;
		else if(checkForCat())
				return Player.CAT;
		else return null;
	}
	
	public String getWinner(){
		return getGameWinner().toString();
	}
	
	public String getWinnerSymbol(){
		if(getGameWinner()==Player.PLAYER_1)
			return "X";
		else if(getGameWinner()==Player.PLAYER_2)
			return "O";
		else if(getGameWinner()==Player.CAT)
			return "X";
		else return null;
	}
	
	private boolean checkForVictory(Board.GridMarker Tic){
		try{
			if(getTicMark(0, 0)==Tic&&getTicMark(0, 1)==Tic&&getTicMark(0, 2)==Tic)
				return true;
			else if(getTicMark(1, 0)==Tic&&getTicMark(1, 1)==Tic&&getTicMark(1, 2)==Tic)
				return true;
			else if(getTicMark(2, 0)==Tic&&getTicMark(2, 1)==Tic&&getTicMark(2, 2)==Tic)
				return true;
			else if(getTicMark(0, 1)==Tic&&getTicMark(1, 1)==Tic&&getTicMark(2, 1)==Tic)
				return true;
			else if(getTicMark(0, 2)==Tic&&getTicMark(1, 2)==Tic&&getTicMark(2, 2)==Tic)
				return true;
			else if(getTicMark(0, 0)==Tic&&getTicMark(1, 0)==Tic&&getTicMark(2, 0)==Tic)
				return true;
			else if(getTicMark(0, 0)==Tic&&getTicMark(1, 1)==Tic&&getTicMark(2, 2)==Tic)
				return true;
			else if(getTicMark(2, 0)==Tic&&getTicMark(1, 1)==Tic&&getTicMark(0, 2)==Tic)
				return true;
			else return false;
			} catch(Exception e){return false;}
	}
	
	private boolean checkForCat(){
		int slotCount=0;	
		for(int collum=0;collum<3;collum++){
			for(int row=0;row<3;row++){
				try{
					if(getTicMark(collum,row)!=Board.GridMarker.BLANK){
						slotCount++;
					}
				} catch (Exception e){}
			}
		}
		if(slotCount==9)
			return true;
		else
			return false;
	}
	
	public void clearBoard() {
		gameBoard.makeBoardBlank();
	}
	
	public void newGame(){
		clearBoard();
		currentPlayer=Player.PLAYER_1;
	}
	
	public void makeMove(int collum, int row) throws Exception{
		if(getTicMark(collum,row)==Board.GridMarker.BLANK){
			if(currentPlayer==TicTacToe.Player.PLAYER_1){
				placeTic(collum,row,Board.GridMarker.X);
				currentPlayer=TicTacToe.Player.PLAYER_2;
			}
			else{
				placeTic(collum,row,Board.GridMarker.O);
				currentPlayer=TicTacToe.Player.PLAYER_1;
			}
		}
		else throw new Exception();
	}
	
	public static void main(String[] args){
		TicTacToe game = new TicTacToe();
		Player player = Player.PLAYER_1;
//		Player winner = null;
		Interface input = new Interface(game);
		/*
		input.printBoard();
		while(winner!=Player.PLAYER_1&&winner!=Player.PLAYER_2&&winner!=Player.CAT){
			int collum =input.getCollum();
			int row = input.getRow();
			try {
				game.makeMove(collum,row);
			} catch (Exception e) {input.printMessage("Invalid move, try again.");}
			input.printBoard();
			winner=game.getGameWinner();
			
		}
		input.printWinner(winner);
		game.clearBoard();
		player=TicTacToe.Player.PLAYER_1;
		*/
	}

	
}
