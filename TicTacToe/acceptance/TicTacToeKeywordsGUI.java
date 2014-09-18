import edu.jsu.mcis.TicTacToeGame.*;
import javax.swing.*;

public class TicTacToeKeywordsGUI {
	private TicTacToe game = new TicTacToe();
		
	
	public void startNewGame(){
		game.newGame();
	}
	
	public void markLocation(int collum, int row){
		try{
			game.makeMove(collum,row);
		}catch(Exception e){}
	}
	
	public String getLocation(int collum, int row){
		try{
			return game.getMarker(collum, row);
		}catch(Exception e){return " ";}
	}
	
	public String getWinner(){
		return game.getWinnerSymbol();
	}
	
	
	
	
	
}