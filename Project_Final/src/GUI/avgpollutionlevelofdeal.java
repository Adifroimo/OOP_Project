package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;

import model.Deal;
import model.Main;
import utils.Color;
import utils.Gender;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class avgpollutionlevelofdeal extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public avgpollutionlevelofdeal() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(214, 80, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(112, 159, 181, 16);
		lblNewLabel_1.setVisible(false);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Please enter dealID");
		lblNewLabel.setBounds(38, 85, 130, 21);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(btnNewButton, "Please write id!");
				}
				else {
					if((Main.libr.avgPollutionLevelOfDeal( Main.libr.getRealDeal(textField.getText())))==-1) {
						lblNewLabel_1.setText("there is no such deal");
					}
					else {
						lblNewLabel_1.setText(Double.toString(Main.libr.avgPollutionLevelOfDeal( Main.libr.getRealDeal(textField.getText()))));

					}
					lblNewLabel_1.setVisible(true);
				}
					
				
				
			}
		});
		btnNewButton.setBounds(133, 118, 117, 29);
		getContentPane().add(btnNewButton);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width/2,screenSize.height/2);

		
		
	}
}
