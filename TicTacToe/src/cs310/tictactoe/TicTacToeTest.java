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
	public void testNewGameShouldBeBlank() throws Exception {
		TicTacToe testGame = new TicTacToe();
		testGame.markLocation(0,0,'X');
		testGame.markLocation(0,1,'X');
		testGame.markLocation(0,2,'X');
		testGame.clearBoard();
		for(int collum=0;collum<2;collum++)
		{
			for(int row=0;row<2;row++){
				assertTrue(testGame.getTicMark(collum,row).equals(GridMarker.BLANK));  
				
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
		testGame = new TicTacToe();
		testGame.markLocation(2,0,'X');
		testGame.markLocation(2,1,'X');
		testGame.markLocation(2,2,'X');
		assertSame(testGame.getWinner(), "Player 1");
		testGame = new TicTacToe();
		testGame.markLocation(0,0,'O');
		testGame.markLocation(1,0,'O');
		testGame.markLocation(2,0,'O');
		assertSame(testGame.getWinner(), "Player 2");
		testGame = new TicTacToe();
		testGame.markLocation(0,1,'X');
		testGame.markLocation(1,1,'X');
		testGame.markLocation(2,1,'X');
		assertSame(testGame.getWinner(), "Player 1");
		testGame = new TicTacToe();
		testGame.markLocation(0,2,'O');
		testGame.markLocation(1,2,'O');
		testGame.markLocation(2,2,'O');
		assertSame(testGame.getWinner(), "Player 2");
		testGame = new TicTacToe();
		testGame.markLocation(0,0,'X');
		testGame.markLocation(0,2,'O');
		testGame.markLocation(1,1,'X');
		testGame.markLocation(0,1,'O');
		testGame.markLocation(2,2,'X');
		assertSame(testGame.getWinner(), "Player 1");
		testGame = new TicTacToe();
		testGame.markLocation(2,0,'X');
		testGame.markLocation(1,2,'O');
		testGame.markLocation(1,1,'X');
		testGame.markLocation(0,1,'O');
		testGame.markLocation(0,2,'X');
		assertSame(testGame.getWinner(), "Player 1");
		testGame = new TicTacToe();
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
	
	public void testShouldNotBeAbleToExceedBounds(){
		try{
			TicTacToe testGame = new TicTacToe();
			testGame.gameBoard.setMarkOnBoard(0,-1,Board.GridMarker.X);
			fail();
		}catch (Exception e) {}
		try{
			TicTacToe testGame = new TicTacToe();
			testGame.gameBoard.setMarkOnBoard(3,1,Board.GridMarker.X);
			fail();
		}catch (Exception e) {}
	}
/*	
	public void testPlayersShouldAlternateAfterMoves(){
		Runner testGame = new Runner();
		
		assertEquals(TicTacToe.Player.PLAYER_1, testGame.player);
		testGame.makeMove(0,1);
		assertEquals(TicTacToe.Player.PLAYER_2, testGame.player);
		testGame.setWinner(TicTacToe.Player.PLAYER_1);
	}
	
	public void testRunnerShouldPlaceTics(){
		Runner testGame = new Runner();
		testGame.makeMove(0, 0);
		try {
			assertEquals(testGame.game.gameBoard.getMarkFromLocation(0,0), Board.GridMarker.X);
		} catch (Exception e) {}
		
	}
	
*/	
	
}
