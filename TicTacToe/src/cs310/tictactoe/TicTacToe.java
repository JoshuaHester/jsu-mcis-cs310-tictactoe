package cs310.tictactoe;

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
			else return " ";
			
		}
		
	}
	
	public TicTacToe(){
		gameBoard = new Board();
		
		
	}

	public void markLocation(int collum,int row, char mark){
		if(getTicMark(collum, row)==Board.GridMarker.BLANK)
			try {
				gameBoard.setMarkOnBoard(collum, row, mark);
			} catch (Exception e) {
				
			}
	}
	
	public Board.GridMarker getTicMark(int collum, int row) {
		try {
		if(gameBoard.getMarkFromLocation(collum, row)==Board.GridMarker.X)
			return Board.GridMarker.X;
		
		else if(gameBoard.getMarkFromLocation(collum, row)==Board.GridMarker.O)
			return Board.GridMarker.O;
		} catch (Exception e) {
			
		}
		return Board.GridMarker.BLANK;
		
	}
	
	public String getMarker(int collum, int row){
		return getTicMark(collum, row).toString();
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
	
	
	private boolean checkForVictory(Board.GridMarker Tic){
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
	}
	
	private boolean checkForCat(){
		int slotCount=0;	
		for(int collum=0;collum<3;collum++){
			for(int row=0;row<3;row++){
				if(getTicMark(collum,row)!=Board.GridMarker.BLANK){
					slotCount++;
				}
			}
		}
		if(slotCount==9)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args){
		new TicTacToe();
	}
}
