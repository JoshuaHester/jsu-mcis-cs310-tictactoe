package cs310.tictactoe;
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
