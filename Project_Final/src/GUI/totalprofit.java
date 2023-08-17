package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import model.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class totalprofit extends JInternalFrame {

	/**
	 * Launch the application.
	

	/**
	 * Create the frame.
	 */
	public totalprofit() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(145, 132, 106, 16);
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		JButton btnNewButton = new JButton("Click");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setText(String.valueOf(Main.libr.totalProfit()));
				lblNewLabel_1.setVisible(true);
			}
		});
		btnNewButton.setBounds(204, 76, 117, 29);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Total profit");
		lblNewLabel.setBounds(71, 81, 91, 16);
		getContentPane().add(lblNewLabel);
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width/2,screenSize.height/2);
	}

}
