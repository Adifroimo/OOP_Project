package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Employee;
import model.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;


	/**
	 * Create the frame.
	 */
	public LogIn() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("/car4.gif"))));
		
        contentPane.setLayout(new FlowLayout());

     
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setBounds(30, 33, 76, 30);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(30, 90, 63, 30);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(95, 38, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(95, 95, 96, 20);
		add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textField.getText();
				if(user.equals("admin")&&String.copyValueOf(passwordField.getPassword()).equals("admin")){
					JOptionPane.showMessageDialog(btnNewButton,"welcome admin");
					dispose();
					Admin adi = new Admin();
					adi.setVisible(true);
				}
				else {
					if(textField.equals("")||String.copyValueOf( passwordField.getPassword()).equals("")) {
						JOptionPane.showMessageDialog(btnNewButton,"Eror!!!");
					}
					if(!(textField.equals("")||String.copyValueOf( passwordField.getPassword()).equals(""))&&!Main.libr.getAllEmployees().containsKey(textField.getText())) {
						JOptionPane.showMessageDialog(btnNewButton,"User does not exist");
					}
					else {
					for(Employee user1 : Main.libr.getAllEmployees().values()) {
						if(user.equals(user1.getID())) {
							JOptionPane.showMessageDialog(btnNewButton,"Welcome "+user1.getFirstName());
							
							dispose();
							User adi = new User(user1.getFirstName());
							adi.setVisible(true);
						}
					}
					}
				}

			}
		});
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width/3,screenSize.height/3);
		btnNewButton.setBounds(83, 143, 89, 23);
		add(btnNewButton);
		
	}
}
