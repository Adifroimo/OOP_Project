package GUI;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.HybridMotorcycle;
import model.Motorcycle;
import utils.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class AddHybridMotorcycle extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;


	/**
	 * Create the frame.
	 */
	public AddHybridMotorcycle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("YearOfManufac");
		lblNewLabel.setBounds(22, 11, 96, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Price");
		lblNewLabel_1.setBounds(22, 36, 74, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cost of Manu");
		lblNewLabel_2.setBounds(22, 61, 74, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Engine Capacity");
		lblNewLabel_3.setBounds(22, 86, 81, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Pollution Level");
		lblNewLabel_4.setBounds(22, 111, 74, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Is Off Road");
		lblNewLabel_6.setBounds(22, 161, 74, 14);
		contentPane.add(lblNewLabel_6);
		

		textField = new JTextField();
		textField.setBounds(113, 8, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(113, 33, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(113, 58, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(113, 83, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(113, 108, 96, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(295, 158, 89, 23);
		contentPane.add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setBounds(139, 157, 111, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		
		JLabel lblNewLabel_7 = new JLabel("Color");
		lblNewLabel_7.setBounds(24, 186, 79, 14);
		contentPane.add(lblNewLabel_7);
		
		JComboBox<Color> comboBox = new JComboBox<Color>();
		comboBox.setBounds(113, 187, 96, 22);
		comboBox.setModel(new DefaultComboBoxModel<>(Color.values()));
		contentPane.add(comboBox);
		
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c))|| (c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		
		
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c))|| (c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		textField_2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c))|| (c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		textField_3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c))|| (c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		textField_4.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c))|| (c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals("")||comboBox.getSelectedItem().equals("")||textField_4.getText().equals(""))
					JOptionPane.showMessageDialog(btnNewButton, "alert", "alert", JOptionPane.ERROR_MESSAGE);
				else if((Integer.parseInt(textField_4.getText())>15||Integer.parseInt(textField_4.getText())<0)) {
					JOptionPane.showMessageDialog(btnNewButton, "pollutionLevel must be between 0-15", "pollutionLevel must be between 0-15", JOptionPane.ERROR_MESSAGE);
				}
				else if(Integer.parseInt(textField.getText())>2022) {
				JOptionPane.showMessageDialog(btnNewButton, "Invalid Year", "Invalid Year", JOptionPane.ERROR_MESSAGE);
				}
				else {
					
						HybridMotorcycle h1= new HybridMotorcycle(Double.parseDouble(textField_1.getText()),Integer.parseInt(textField_2.getText()),(Color)comboBox.getSelectedItem(),Integer.parseInt(textField.getText()),Double.parseDouble(textField_3.getText()),Integer.parseInt(textField_4.getText()),rdbtnNewRadioButton.isSelected());
						model.Main.libr.getAllVehicleTransportation().put(h1.getLicensePlate(), h1);
						JOptionPane.showMessageDialog(btnNewButton, "MotorCycle Added");
						
					}
				}
			
		});
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width/2,screenSize.height/2);
	}
}
