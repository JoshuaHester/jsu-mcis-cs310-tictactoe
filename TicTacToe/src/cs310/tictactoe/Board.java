package cs310.tictactoe;

public class Board {
	public GridMarker[][] grid;
	
	public enum GridMarker {
		BLANK, O, X
	}
	public Board(){
		grid = new GridMarker[3][3];
		makeBoardBlank();
	}
	
	public void makeBoardBlank(){
		for(int collum=0;collum<2;collum++){
			for(int row=0;row<2;row++){
				this.grid[collum][row]=GridMarker.BLANK;
			}
		}
	}

	public void setMarkOnBoard(int collum, int row, char mark){
		if(mark=='X'||mark=='x'){
			this.grid[collum][row]=GridMarker.X;
		}
		else{
			this.grid[collum][row]=GridMarker.O;
		}
		
	}
	
	public String getMarkFromLocation(int collum, int row){
		if(this.grid[collum][row]==GridMarker.X)
			return "X";
		else if(this.grid[collum][row]==GridMarker.O)
			return "O";
		else
			return null;
	}
}
