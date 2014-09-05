package cs310.tictactoe;
import java.util.Scanner;

import cs310.tictactoe.TicTacToe.Player;

public class Interface {
	
	public Runner runner;
	public Interface(Runner runner){
		this.runner=runner;
	}

	public int getCollum() {
		Scanner keyboard = new Scanner(System.in);
		keyboard.close();
		return keyboard.nextInt();
	}

	public int getRow() {
		Scanner keyboard = new Scanner(System.in);
		keyboard.close();
		return keyboard.nextInt();
		
	}
	
	public void printBoard(){
		System.out.println(runner.game.getMarker(0,0)+runner.game.getMarker(1,0)+runner.game.getMarker(2,0));
		System.out.println(runner.game.getMarker(0,1)+runner.game.getMarker(1,1)+runner.game.getMarker(2,1));
		System.out.println(runner.game.getMarker(0,2)+runner.game.getMarker(1,2)+runner.game.getMarker(2,2));
		
		
	}

	public void printWinner(Player winner) {
		System.out.println(winner.toString()+" is the winner");
	}
	
	
	
	
	
	
}
