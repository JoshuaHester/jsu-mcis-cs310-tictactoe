package cs310.tictactoe;

public class Board {
	public GridMarker[][] grid;
	public Exception OutOfBoundsException;
	
	public enum GridMarker {
		BLANK, O, X;
		public String toString(){
		if(this==O)
			return "O";
		else if(this==X)
			return "X";
		else return " ";
		
		}
		
	}
	
	public Board(){
		grid = new GridMarker[3][3];
		makeBoardBlank();
	}
	
	public void makeBoardBlank(){
		for(int collum=0;collum<3;collum++){
			for(int row=0;row<3;row++){
				this.grid[collum][row]=GridMarker.BLANK;
			}
		}
	}

	public void setMarkOnBoard(int collum, int row, char mark) throws Exception{
			if(collum>2||collum<0||row>2||row<0)
				throw OutOfBoundsException;
			else if(mark=='X'||mark=='x'){
				this.grid[collum][row]=GridMarker.X;
			}
			else{
				this.grid[collum][row]=GridMarker.O;
			}
	}
	
	public GridMarker getMarkFromLocation(int collum, int row) throws Exception{
		if(collum>2||collum<0||row>2||row<0)
			throw OutOfBoundsException;
		else if(this.grid[collum][row]==GridMarker.X)
			return GridMarker.X;
		else if(this.grid[collum][row]==GridMarker.O)
			return GridMarker.O;
		else
			return GridMarker.BLANK;
	}
	
	
	
	
	
}
