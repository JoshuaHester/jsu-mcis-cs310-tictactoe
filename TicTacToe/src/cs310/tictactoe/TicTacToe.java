package cs310.tictactoe;

public class TicTacToe {
	
	public Board gameBoard;
	
	public TicTacToe(){
		gameBoard = new Board();
		
		
	}

	public void markLocation(int collum,int row, char mark){
		gameBoard.setMarkOnBoard(collum, row, mark);
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
	
	public String getWinner(){
		if(checkForVictory('X')) 
			return "Player 1";
		else if(checkForVictory('O')) 
			return "Player 2";
		else if(checkForCat())
				return "Cat";
		else return null;
	}
	
	public boolean checkForVictory(char Tic){
		if(getMarker(0, 0)==Tic&&getMarker(0, 1)==Tic&&getMarker(0, 2)==Tic)
			return true;
		else if(getMarker(1, 0)==Tic&&getMarker(1, 1)==Tic&&getMarker(1, 2)==Tic)
			return true;
		else if(getMarker(2, 0)==Tic&&getMarker(2, 1)==Tic&&getMarker(2, 2)==Tic)
			return true;
		else if(getMarker(0, 0)==Tic&&getMarker(1, 0)==Tic&&getMarker(2, 0)==Tic)
			return true;
		else if(getMarker(1, 0)==Tic&&getMarker(1, 1)==Tic&&getMarker(1, 2)==Tic)
			return true;
		else if(getMarker(2, 0)==Tic&&getMarker(2, 1)==Tic&&getMarker(2, 2)==Tic)
			return true;
		else if(getMarker(0, 0)==Tic&&getMarker(1, 1)==Tic&&getMarker(2, 2)==Tic)
			return true;
		else if(getMarker(2, 0)==Tic&&getMarker(1, 1)==Tic&&getMarker(0, 2)==Tic)
			return true;
		else return false;
	}
	
	public boolean checkForCat(){
		int slotCount=0;	
		for(int collum=0;collum<3;collum++){
			for(int row=0;row<3;row++){
				if(getMarker(collum,row)=='X'||getMarker(collum,row)=='O'){
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
