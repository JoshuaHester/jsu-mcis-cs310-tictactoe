package cs310.tictactoe;

import org.junit.Test;

import cs310.tictactoe.Board.GridMarker;
import junit.framework.TestCase;

public class TicTacToeTest extends TestCase {

	@Test
	public void testNewBoardShouldBeBlank() throws Exception {
		Board testBoard = new Board();
		for(int collum=0;collum<2;collum++)
		{
			for(int row=0;row<2;row++){
				assertTrue(testBoard.getMarkFromLocation(collum,row).equals(GridMarker.BLANK));  
				
			}
		}
	}
	
	
	@Test
	public void testPlacingTicShouldAddCorrectTicToLocation(){
		TicTacToe testGame = new TicTacToe();
		testGame.markLocation(0,0,'X');
		testGame.markLocation(0,1,'O');
		assertSame(testGame.getMarker(0,0), "X");
		assertSame(testGame.getMarker(0,1), "O");
		assertSame(testGame.getMarker(0,2), " ");
	}
	
	@Test
	public void testGameShouldBeWinable(){
		TicTacToe testGame = new TicTacToe();
		testGame.markLocation(0,0,'X');
		testGame.markLocation(0,1,'X');
		testGame.markLocation(0,2,'X');
		assertSame(testGame.getWinner(), "Player 1");
		testGame = new TicTacToe();
		testGame.markLocation(1,0,'O');
		testGame.markLocation(1,1,'O');
		testGame.markLocation(1,2,'O');
		assertSame(testGame.getWinner(), "Player 2");
		
		
		
		
		
		
	}
	
	@Test
	public void testGameShouldBeLosable(){
		TicTacToe testGame = new TicTacToe();
		testGame.markLocation(0,0,'X');
		testGame.markLocation(0,1,'O');
		testGame.markLocation(0,2,'X');
		testGame.markLocation(1,0,'X');
		testGame.markLocation(1,1,'O');
		testGame.markLocation(1,2,'X');
		testGame.markLocation(2,0,'O');
		testGame.markLocation(2,1,'X');
		testGame.markLocation(2,2,'O');
		assertSame(testGame.getWinner(), "Cat");
	}
	
	@Test
	public void testShouldNotBeAbleToOverwriteTics(){
		TicTacToe testGame = new TicTacToe();
		testGame.markLocation(0,0,'X');
		testGame.markLocation(0,0,'O');
		assertSame(testGame.getMarker(0,0), "X");
		
	}

}
