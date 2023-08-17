package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Main;

public class getrealDepartment extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public getrealDepartment() {
		setBounds(100, 100, 450, 300);
		setBounds(100, 100, 450, 300);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(154, 43, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Department ID");
		lblNewLabel.setBounds(6, 48, 148, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		lblNewLabel_1.setBounds(6, 101, 420, 153);
		getContentPane().add(lblNewLabel_1);
		
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((!Character.isDigit(c))|| (c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		JButton btnNewButton = new JButton("Show info");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Main.libr.getAllDepartments().containsKey(Integer.parseInt(textField.getText()))) {
					
					lblNewLabel_1.setText(Main.libr .getRealDepartment( Integer.parseInt(textField.getText())).toString());
					
					lblNewLabel_1.setVisible(true);

				}
				else {
					JOptionPane.showMessageDialog(btnNewButton, "Department Not in the system!");

				}
			}
		});
		btnNewButton.setBounds(143, 81, 117, 29);
		getContentPane().add(btnNewButton);
		
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width/2,screenSize.height/2);
	}

}
