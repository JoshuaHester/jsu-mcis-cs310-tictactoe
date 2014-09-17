package edu.jsu.mcis.TicTacToeGame;
import org.junit.Test;

import junit.framework.TestCase;

public class BoardTest extends TestCase {

	@Test
	public void testNewBoardShouldBeBlank() throws Exception {
		Board testBoard = new Board();
		for(int collum=0;collum<2;collum++)
		{
			for(int row=0;row<2;row++){
				assertTrue(testBoard.getMarkFromLocation(collum,row).equals(Board.GridMarker.BLANK));  
				
			}
		}
	}
}
