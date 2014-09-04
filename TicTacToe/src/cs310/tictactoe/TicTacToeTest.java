package cs310.tictactoe;

import org.junit.Test;

import junit.framework.TestCase;

public class TicTacToeTest extends TestCase {

	@Test
	public void testPlacingTicShouldAddCorrectTicToLocation(){
		TicTacToe testGame = new TicTacToe();
		testGame.markLocation(0,0,'X');
		testGame.markLocation(0,1,'O');
		assertSame(testGame.getMarker(0,0), 'X');
		assertSame(testGame.getMarker(0,1), 'O');
		assertSame(testGame.getMarker(0,2), ' ');
	}
	
	@Test
	public void testGameShouldBeWinable(){
		TicTacToe testGame = new TicTacToe();
		testGame.markLocation(0,0,'X');
		testGame.markLocation(0,1,'X');
		testGame.markLocation(0,2,'X');
		assertSame(testGame.getWinner(), "Player 1");
	}
	
}
