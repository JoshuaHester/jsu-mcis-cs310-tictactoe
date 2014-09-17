package cs310.tictactoe;

import java.util.Scanner;
public class Interface {
	public TicTacToe game;
	public Interface(TicTacToe game){
		this.game=game;
	}
	private Scanner keyboard = new Scanner(System.in);
	public int getCollum() {
		int collum = keyboard.nextInt();
		return collum;
	}

	public int getRow() {
		int row= keyboard.nextInt();
		return row;
	}
	
	public void printBoard(){
		System.out.println(game.getMarker(0,0)+"|"+game.getMarker(1,0)+"|"+game.getMarker(2,0));
		System.out.println("-----");
		System.out.println(game.getMarker(0,1)+"|"+game.getMarker(1,1)+"|"+game.getMarker(2,1));
		System.out.println("-----");
		System.out.println(game.getMarker(0,2)+"|"+game.getMarker(1,2)+"|"+game.getMarker(2,2));
	}

	public void printWinner(TicTacToe.Player winner) {
		System.out.println(winner.toString()+" is the winner");
	}
	
	public void printMessage(String s) {
		System.out.println(s);
	}
}
