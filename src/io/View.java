package io;


import java.awt.Dimension;

import javax.swing.JOptionPane;


import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField input;
	private JTextPane output;
	private Controller controller = new Controller();
	private Model model = Model.getModel();
	
	public void Reset(){
		View.this.input.setText(null);
		View.this.output.setText(null);
		model.setGuessesLeft(10);
		model.setCheating();
		model.setSecret();
		System.out.println(model.getSecret());
		System.out.println(model.isCheating());
		
	}
	
	public void Exit(){
		System.exit(EXIT_ON_CLOSE);
	}
	
	
	public void newGame(){
		Object[] options = {"Tak", "Nie"};
		int n = (int)JOptionPane.showOptionDialog(View.this,
				"Czy chcesz zagraæ ponownie?",
				"Nowa Gra",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,  
				options[1]); 
		
		
		if(n==JOptionPane.YES_OPTION){
			Reset();
		}
		if(n==JOptionPane.NO_OPTION){
			Exit();
		}
		
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					View frame = new View();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		input = new JTextField();
		input.setBounds(156, 307, 86, 20);
		contentPane.add(input);
		input.setColumns(10);
		setLocationRelativeTo(null);
		this.setTitle("Mastermind");
		

		output = new JTextPane();
		output.setEditable(false);
	
		JScrollPane scroll = new JScrollPane(output);
	    scroll.setVerticalScrollBarPolicy(
	                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setPreferredSize(new Dimension(250, 155));
	    scroll.setMinimumSize(new Dimension(10, 10));
	    scroll.setBounds(10, 11, 374, 285);
	    contentPane.add(scroll);

	        
		
	       
	        
		JButton btnNewButton = new JButton("Sprawdz");
		btnNewButton.setMargin(new Insets(1,1,1,1));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String eldo = new String(input.getText());
				
				if(View.this.controller.validateInput(eldo)){
					model.checkSecret(eldo);
					
					output.setText("Wpisany szyfr: "+eldo+"\n"+"Iloœæ znaków na dobrych pozycjach: "+model.getBlack()+"\n"+
					"Iloœæ znaków na z³ych pozycjach: "+model.getWhite()+"\n"+"Pozosta³e próby: "+model.getGuessesLeft()+"\n\n"+output.getText()+"\n");
					
					output.setCaretPosition(0);	
					
					if(View.this.model.getGuessesLeft()==0)
					{
						JOptionPane.showMessageDialog(View.this, "Przegrana");
						newGame();
					}
					
					if(View.this.model.getBlack()==4){
						JOptionPane.showMessageDialog(View.this, "Wygrana");
						newGame();
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(View.this, "Wprowadzony szyfr jest nieprawid³owy");
					input.setText("");
				}	
			}
		});
		
		btnNewButton.setBounds(16, 338, 80, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Oszust");
		btnNewButton_1.setBounds(112, 338, 80, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(View.this.model.isCheating()==true)
				{
					JOptionPane.showMessageDialog(View.this, "Z³apa³eœ/aœ mnie!", "Oszust!", JOptionPane.PLAIN_MESSAGE);
					newGame();
				}
				else
				{
					JOptionPane.showMessageDialog(View.this, "Nie tym razem!", "Oszust!", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		contentPane.add(btnNewButton_1);

		
		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.setBounds(208, 338, 80, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				
				
				Object[] options = {"Tak", "Nie"};
				int n = (int)JOptionPane.showOptionDialog(View.this,
						"Czy napewno chcesz zresetowaæ grê?",
						"Reset",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						options,  
						options[1]); 
				
				if(n==JOptionPane.YES_OPTION){
					Reset();
				}
			}
		});
		contentPane.add(btnNewButton_2);	
		
		
		
		
		JButton btnNewButton_3 = new JButton("Koniec");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] options = {"Tak", "Nie"};
				int n = (int)JOptionPane.showOptionDialog(View.this,
						"Czy napewno chcesz wyjœæ z gry?",
						"Koniec",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						options,  
						options[1]); 
				
				
				if(n==JOptionPane.YES_OPTION){
					System.exit(EXIT_ON_CLOSE);
				}
			}
		});
		btnNewButton_3.setBounds(304, 338, 80, 23);
		contentPane.add(btnNewButton_3);
		
		
		

		
	}
}
