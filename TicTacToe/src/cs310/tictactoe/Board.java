package cs310.tictactoe;

public class Board {
	public GridMarker[][] grid;
	
	public enum GridMarker {
		BLANK, O, X
	}
	public Board(){
		grid = new GridMarker[3][3];
		for(int collum=0;collum<2;collum++)
		{
			for(int row=0;row<2;row++){
				this.grid[collum][row]=GridMarker.BLANK;
				
			}
			
		}
		
	}
	
	
	
	public void MakeBoardBlank(){
		
		
		
	}

}
