package cs310.tictactoe;


import cs310.tictactoe.Board.GridMarker;
import junit.framework.TestCase;

public class BoardTest extends TestCase {

	
	public void testNewBoardShouldBeBlank() {
		Board testBoard = new Board();
		for(int collum=0;collum<2;collum++)
		{
			for(int row=0;row<2;row++){
				assertTrue(testBoard.grid[collum][row].equals(GridMarker.BLANK));  
				
			}
		}
	}
	
	
	

}