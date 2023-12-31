package uno;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument.Content;

import uno.GameplayGui;

public class MenuGUI extends JFrame {

	private static final String EXIT_ON_CLOSE = null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGUI frame = new MenuGUI();
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
	public MenuGUI() {
		setDefaultCloseOperation(MenuGUI.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
        setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(157, 10, 151, 243);
		contentPane.add(panel);
		
		alterPlayerName(panel);
		returnToGame(panel);
		newGame(panel);
		saveGame(panel);
		loadGame(panel);
	}
	
	

	public void centerTheWindow(Gameplay gameplay) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (screenSize.width - gameplay.getWidth()) / 2;
            int y = (screenSize.height - gameplay.getHeight()) / 2;
            gameplay.setLocation(x, y);
	}

	public void loadGame(JPanel panel) {
		JButton loadGame = new JButton("Load Game");
		panel.add(loadGame);
		loadGame.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Gameplay gameplay = new Gameplay();
				gameplay.setVisible(true);					
				dispose(); 
			}

		});
	}

	public void saveGame(JPanel panel) {
		JButton saveGame = new JButton("Save Game");
		saveGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});
		panel.add(saveGame);
	}

	public void newGame(JPanel panel) {
		JButton newGame = new JButton("New Game");
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(uno.GameplayGui != null) {
					saveGame(uno.GameplayGUI);
				}
			}
		});
		panel.add(newGame);
	}

	public void returnToGame(JPanel panel) {
		JButton returnToGame = new JButton("Return to Game");
		returnToGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Uno.GameplayGui gameplayGui = new Uno.GameplayGui();
				gameplayGui.setVisible(true);					
				dispose(); 
			}
		});
		panel.add(returnToGame);
	}

	public void alterPlayerName(JPanel panel) {
		panel.setLayout(new GridLayout(0, 1, 0, 0));
	}
}
