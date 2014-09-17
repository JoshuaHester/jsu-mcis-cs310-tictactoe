package edu.jsu.mcis.TicTacToeGame;
import java.util.*;

import org.junit.Test;

import edu.jsu.mcis.TicTacToeGame.Board.GridMarker;
import junit.framework.TestCase;
import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest extends TestCase {
	
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
	public void testPlacingTicShouldAddCorrectTicToLocation() throws Exception{
		TicTacToe testGame = new TicTacToe();
		testGame.markLocation(0,0,'X');
		testGame.markLocation(0,1,'O');
		assertSame(testGame.getMarker(0,0), "X");
		assertSame(testGame.getMarker(0,1), "O");
		assertSame(testGame.getMarker(0,2), " ");
	}
	
	@Test
	public void testGameShouldBeWinable()throws Exception{
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
	public void testGameShouldBeLosable()throws Exception{
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
	public void testShouldNotBeAbleToOverwriteTics()throws Exception{
		TicTacToe testGame = new TicTacToe();
		testGame.markLocation(0,0,'X');
		testGame.markLocation(0,0,'O');
		assertSame(testGame.getMarker(0,0), "X");
		
	}
	
	@Test
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

	@Test
	public void testPlayerShouldAlternateBetweenMoves(){
		TicTacToe game = new TicTacToe();
		try{
			game.makeMove(0, 1);
			assertSame(game.currentPlayer, TicTacToe.Player.PLAYER_2);
			game.makeMove(2, 1);
			assertSame(game.currentPlayer, TicTacToe.Player.PLAYER_1);
		}catch(Exception e){}
	}
	
	@Test
	public void testGameCanReturnSymbol()throws Exception{
		TicTacToe testGame = new TicTacToe();
		testGame.markLocation(0,0,'X');
		testGame.markLocation(0,1,'X');
		testGame.markLocation(0,2,'X');
		assertSame(testGame.getWinnerSymbol(), "X");
	}
}
