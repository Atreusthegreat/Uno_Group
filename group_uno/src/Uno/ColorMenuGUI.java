package uno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ColorMenuGUI extends JFrame {

	private JPanel contentPane;
	private JButton yellowbtn;
	private Colors selectedColor;


	/**
	 * Create the frame.
	 */
	public ColorMenuGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 337, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton redbuttonbtn = new JButton("");
		redbuttonbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedColor = Colors.RED;
				setVisible(false);
			}
		});
		redbuttonbtn.setBackground(new Color(255, 0, 0));
		redbuttonbtn.setBounds(0, 0, 164, 164);
		contentPane.add(redbuttonbtn);
		
		JButton bluebtn = new JButton("");
		bluebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedColor = Colors.BLUE;
				setVisible(false);
			}
		});
		bluebtn.setBackground(new Color(0, 0, 255));
		bluebtn.setBounds(165, 164, 164, 164);
		contentPane.add(bluebtn);
		
		yellowbtn = new JButton("");
		yellowbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedColor = Colors.YELLOW;
				setVisible(false);
			}
		});
		yellowbtn.setBackground(new Color(255, 255, 0));
		yellowbtn.setBounds(165, 0, 164, 164);
		contentPane.add(yellowbtn);
		
		JButton greenbtn = new JButton("");
		greenbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedColor = Colors.GREEN;
				setVisible(false);
			}
		});
		greenbtn.setBackground(new Color(0, 255, 0));
		greenbtn.setBounds(0, 164, 164, 164);
		contentPane.add(greenbtn);
	}

	public Colors getSelectedColor() {

		return selectedColor;
	}

}
