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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
	import java.awt.BorderLayout;
	import java.awt.Component;
	import java.awt.Color;
	
	public class GameplayGui extends JFrame {
	
		private JPanel contentPane;
		private JButton unoRight;
		String[] pids;
		Game game;
		ArrayList<String> cardId;
		
		
		ArrayList<JButton> cardButton = new ArrayList<JButton>();
		
		
		private JButton btnNewButton_1;
		private JButton btnNewButton_2;
		private JButton btnNewButton_3;
		private JButton btnNewButton_4;
		private JButton btnNewButton_5;
		private JButton btnNewButton_6;
		private JButton btnNewButton_7;
		private JButton btnNewButton_8;
		private JButton btnNewButton_9;
		private JButton btnNewButton_10;
		private JButton btnNewButton_11;
		private JButton btnNewButton_12;
		
		 public GameplayGui(Game game) {
		    }
		
		public static void updatePlayerHand(Player currentPlayer) {
			ArrayList<Card> playerHand = Player.getPlayerHand();

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
			
			btnNewButton_1 = new JButton("New button");
			panel.add(btnNewButton_1);
			
			btnNewButton_2 = new JButton("New button");
			panel.add(btnNewButton_2);
			
			btnNewButton_3 = new JButton("New button");
			panel.add(btnNewButton_3);
			
			btnNewButton_4 = new JButton("New button");
			panel.add(btnNewButton_4);
			
			btnNewButton_5 = new JButton("New button");
			panel.add(btnNewButton_5);
			
			btnNewButton_6 = new JButton("New button");
			panel.add(btnNewButton_6);
			
			btnNewButton_7 = new JButton("New button");
			panel.add(btnNewButton_7);
			
			btnNewButton_8 = new JButton("New button");
			panel.add(btnNewButton_8);
			
			btnNewButton_9 = new JButton("New button");
			panel.add(btnNewButton_9);
			
			btnNewButton_10 = new JButton("New button");
			panel.add(btnNewButton_10);
			
			btnNewButton_11 = new JButton("New button");
			panel.add(btnNewButton_11);
			
			btnNewButton_12 = new JButton("New button");
			panel.add(btnNewButton_12);
			
			JButton btnNewButton = new JButton("New button");
			
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
					MenuGUI menu = new MenuGUI();
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

		protected void getCardInfo(int i) {
			// TODO Auto-generated method stub
			
		}
		
		public void setButtonIcon() {
			String listString = game.getHand(game.getCurrentPlayer()).stream().map(Object::toString).collect(Collectors.joining(","));
			String[] cardNames = listString.split(",");
			cardId = new ArrayList<>(Arrays.asList(cardNames));
			
			for(int i = 0; i < cardId.size(); i++) {
				cardButton.get(i).setText(cardNames.toString());
			}
			
		}
		
		public void populateArrayList() {
			
			cardButton.add(btnNewButton_1);
			cardButton.add(btnNewButton_2);
			cardButton.add(btnNewButton_3);
			cardButton.add(btnNewButton_4);
			cardButton.add(btnNewButton_5);
			cardButton.add(btnNewButton_6);
			cardButton.add(btnNewButton_7);
			cardButton.add(btnNewButton_8);
			cardButton.add(btnNewButton_9);
			cardButton.add(btnNewButton_10);
			cardButton.add(btnNewButton_11);
			cardButton.add(btnNewButton_12);

			
		}
	}
