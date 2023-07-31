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
import java.awt.event.ActionEvent;

public class EnterPlayersName extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnterPlayersName frame = new EnterPlayersName();
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
	public EnterPlayersName() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		lblNewLabel = new JLabel("Enter Name:");
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String playerName = textField.getText().trim();
				if (playerName.isEmpty()) {
		            JOptionPane.showMessageDialog(EnterPlayersName.this, "Please enter a name.", "Error", JOptionPane.ERROR_MESSAGE);
			
				}else {
					
				}
			}
		});
		contentPane.add(btnNewButton);
	}

}
