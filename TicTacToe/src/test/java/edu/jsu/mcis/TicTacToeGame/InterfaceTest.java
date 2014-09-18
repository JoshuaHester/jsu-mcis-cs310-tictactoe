package edu.jsu.mcis.TicTacToeGame;
import org.junit.Test;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import junit.framework.TestCase;

public class InterfaceTest extends TestCase {
	TicTacToe game = new TicTacToe();


	@Test
	public void testGridExists(){
		Interface gui = new Interface(game);
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				assertNotNull(gui.gridSlot[i][j]);
			}
		}
	}
	
	@Test
	public void testMessagesAreDisplayed(){
		Interface gui = new Interface(game);
		assertEquals("X move", gui.message.getText());
		gui.printWinner(TicTacToe.Player.PLAYER_1);
		assertEquals("Player 1 is the winner", gui.message.getText());
		gui.printMessage("Invalid move, try again");
		assertEquals("Invalid move, try again", gui.message.getText());
	
	}
	

}
