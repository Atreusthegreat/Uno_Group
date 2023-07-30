package uno;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Color;

public class GameplayGui extends JFrame {

	private JPanel contentPane;
	private JButton unoRight;
	String[] pids;
	Game game;
	ArrayList<JButton>
	

	/**
	 * Launch the application.
	 */
	public GameplayGUI{ArrayList<String> pIDs){
		
	}

	/**
	 * Create the frame.
	 */
	public GameplayGui() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
        setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 225, 534, 72);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton card01 = new JButton("Player hand");
		card01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(card01);
		
		JButton card02 = new JButton("New button");
		card02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(card02);
		
		JButton card03 = new JButton("New button");
		card03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(card03);
		
		JButton card04 = new JButton("New button");
		card04.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(card04);
		
		JButton card05 = new JButton("New button");
		card05.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(card05);
		
		JButton card06 = new JButton("New button");
		card06.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(card06);
		
		JButton card07 = new JButton("New button");
		card07.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(card07);
		
		JButton card08 = new JButton("New button");
		card08.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(card08);
		
		JButton card09 = new JButton("New button");
		card09.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(card09);
		
		JButton card10 = new JButton("New button");
		card10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(card10);
		
		JButton card11 = new JButton("New button");
		card11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(card11);
		
		JButton card12 = new JButton("New button");
		card12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(card12);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 190, 534, 29);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton playCard = new JButton("PLAY CARD");
		playCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(playCard);
		
		JLabel gameMessages = new JLabel("GAME MESSAGES");
		gameMessages.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(gameMessages);
		
		JButton menu = new JButton("MENU");
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				 menu.setVisible(true);
				 dispose(); 
			}
		});
		panel_1.add(menu);
		
		JButton sayUno = new JButton("SAY \"UNO!\"");
		sayUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sayUno.setOpaque(false);
		panel_1.add(sayUno);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 10, 534, 173);
		contentPane.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		unoRight = new JButton("Uno");
		unoRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		unoRight.setHorizontalTextPosition(SwingConstants.CENTER);
		panel_4.add(unoRight);
		
		JLabel leftPlayerStats = new JLabel("Stats");
		leftPlayerStats.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(leftPlayerStats);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.EAST);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton unoLeft = new JButton("Uno");
		unoLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_5.add(unoLeft);
		
		JLabel rightPlayerStats = new JLabel("Stats");
		rightPlayerStats.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(rightPlayerStats);
		
		JPanel panel_6 = new JPanel();
		panel_6.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_3.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton unoAcross = new JButton("Uno");
		unoAcross.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_6.add(unoAcross);
		
		JLabel topPlayerStats = new JLabel("Stats");
		topPlayerStats.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(topPlayerStats);
		
		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(null);
		
		JButton Drawbtn = new JButton("Draw");
		Drawbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Drawbtn.setBounds(27, 38, 73, 82);
		panel_8.add(Drawbtn);
		
		JLabel Discardpile = new JLabel("Discard");
		Discardpile.setHorizontalAlignment(SwingConstants.CENTER);
		Discardpile.setBounds(131, 37, 73, 82);
		panel_8.add(Discardpile);
	}
	
	
}
