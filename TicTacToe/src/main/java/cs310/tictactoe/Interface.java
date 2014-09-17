//package cs310.tictactoe;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Interface extends JPanel implements MouseListener{
	public TicTacToe game;
	private JLabel[][] gridSlot;
	private JLabel message;
	private TicTacToe.Player winner = null;
	JFrame myFrame = new JFrame();
	
	public Interface(TicTacToe game){
		this.game=game;
		
		JFrame ticFrame = new JFrame("Tic Tac Toe");
		ticFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new BorderLayout());
		message = new JLabel("X move");
		
		JPanel gameGrid = new JPanel(new GridLayout(3, 3));
		gridSlot = new JLabel[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				gridSlot[i][j]=new JLabel("_");
				gridSlot[i][j].addMouseListener(this);
				gameGrid.add(gridSlot[i][j]);
			}
		}
		panel.add(message, BorderLayout.NORTH);
		panel.add(gameGrid, BorderLayout.CENTER);
		ticFrame.add(panel);
		ticFrame.pack();
		ticFrame.setVisible(true);
	}
/*	
	public int getCollum() {
		return 0;
	}

	public int getRow() {
		return 0;
	}

	public void printBoard(){
	//	for(int i=0;i<3;i++){
	//		for(int j=0;j<3;j++){
	//			gridSlot[i][j];
	//		}
	//	}
	}
*/
	public void printWinner(TicTacToe.Player winner) {
		message.setText(winner.toString()+" is the winner");
	}
	
	public void printMessage(String s) {
		message.setText(s);
	}
	
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseClicked(MouseEvent e){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){	
				if(e.getSource()==gridSlot[i][j]){
					try{
						game.makeMove(i, j);
						gridSlot[i][j].setText(game.getMarker(i,j));
					}catch(Exception a){
						printMessage("Invalid move, try again");
					}
					winner=game.getGameWinner();
					if(winner==TicTacToe.Player.PLAYER_1||winner==TicTacToe.Player.PLAYER_2||winner==TicTacToe.Player.CAT){
						printWinner(winner);
						game.newGame();
						for(i=0;i<3;i++){
							for(j=0;j<3;j++){	
								gridSlot[i][j].setText("_");
							}
						}		
					}
				}
			}
		}
	}
	
	
	
	
	
	
}




/* 
// old command line based ui 
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
*/
