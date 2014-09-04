package cs310.tictactoe;

public class TicTacToe {
	
	public Board gameBoard;
	
	public TicTacToe(){
		gameBoard = new Board();
		
		
	}
	

	public void markLocation(int collum,int row, char mark){
		gameBoard.setMarkOnBoard(collum, row, mark);
	}

	
	
	public static void main(String[] args){
		new TicTacToe();
	}


	public char getMarker(int collum, int row) {
		String locationContents = gameBoard.getMarkFromLocation(collum, row);
		if(locationContents=="X")
			return 'X';
		else if(locationContents=="O")
			return 'O';
		else
			return ' ';
	}
}
