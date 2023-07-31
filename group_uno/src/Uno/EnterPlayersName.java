package Uno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class EnterPlayersName extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JLabel entername;

	public ArrayList<String> names = new ArrayList<>();
	private JPanel panel;
	private JPanel panel_1;
	private JLabel playerLabels1;
	private JLabel playerLabels2;
	private JLabel playerLabels4;
	private JLabel playerLabels3;
	private JLabel[] playerLabels;
    
	


	/**
	 * Create the frame.
	 */
	public EnterPlayersName() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel);
		
		entername = new JLabel("Enter Name:");
		panel.add(entername);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("add");
		panel.add(btnNewButton);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		playerLabels1 = new JLabel("");
		panel_1.add(playerLabels1);
		
		playerLabels2 = new JLabel("");
		panel_1.add(playerLabels2);
		
		playerLabels3 = new JLabel("");
		panel_1.add(playerLabels3);
		
		playerLabels = new JLabel[4];
        for (int i = 0; i < 4; i++) {
            playerLabels[i] = new JLabel("Player " + (i + 1) + ":");
            panel_1.add(playerLabels[i]);
        }
		
		playerLabels4 = new JLabel("");
		panel_1.add(playerLabels4);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String playerName = textField.getText().trim();
				if (playerName.isEmpty()) {
		            JOptionPane.showMessageDialog(EnterPlayersName.this, "Please enter a name.", "Error", JOptionPane.ERROR_MESSAGE);
			
				}else {
					names.add(playerName);
                    textField.setText(""); // Reset the text field
					
                    
                    int numPlayers = names.size();
                    for (int i = 0; i < numPlayers; i++) {
                        // Update the player name labels
                        playerLabels[i].setText("Player " + (i + 1) + ": " + names.get(i));
                    }
                    
                    if (names.size() == 4) {
                    	UnoGameManager.newGame(names);

                        dispose();
					}
                    
                   
				}
			}
		});
	}

}
