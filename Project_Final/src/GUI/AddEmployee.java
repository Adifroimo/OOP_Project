package GUI;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Exceptions.PersonAlreadyExistException;
import Exceptions.YearOfBirthNotInRange;

import java.util.Date;  
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import model.Department;
import model.Employee;
import utils.Gender;

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
import javax.swing.JPasswordField;

public class AddEmployee extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AddEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(22, 11, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First name");
		lblNewLabel_1.setBounds(22, 36, 74, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last name");
		lblNewLabel_2.setBounds(22, 61, 74, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number");
		lblNewLabel_3.setBounds(22, 86, 81, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setBounds(22, 111, 74, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("YearOfBirth");
		lblNewLabel_5.setBounds(22, 136, 81, 14);
		contentPane.add(lblNewLabel_5);
		
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
		textField_4.setBounds(113, 133, 96, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(113, 158, 96, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Salary");
		lblNewLabel_6.setBounds(22, 161, 86, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Department");
		lblNewLabel_8.setBounds(239, 11, 81, 14);
		contentPane.add(lblNewLabel_8);
		
		JComboBox<Gender> comboBox = new JComboBox<Gender>();
		comboBox.setBounds(106, 107, 107, 22);
		comboBox.setModel(new DefaultComboBoxModel<>(Gender.values()));
		contentPane.add(comboBox);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(316, 33, 96, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_9 = new JLabel("Password");
		lblNewLabel_9.setBounds(239, 36, 49, 14);
		contentPane.add(lblNewLabel_9);
		
		JComboBox<Integer> comboBox_2 = new JComboBox<Integer>();
		comboBox_2.setBounds(316, 7, 96, 22);
		for(Department dep : model.Main.libr.getAllDepartments().values()) {
			comboBox_2.addItem(dep.getDepartmentID());
		}
		contentPane.add(comboBox_2);
		

	
	
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
			if((Character.isDigit(c))|| (c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE) {
				getToolkit().beep();
				e.consume();
			}
		}
	});
	textField_2.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			if((Character.isDigit(c))|| (c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE) {
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
	
	textField_6.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			if(!(Character.isDigit(c))|| (c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE) {
				getToolkit().beep();
				e.consume();
			}
		}
	});
	
	
	JButton btnNewButton = new JButton("Add");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals("")||String.copyValueOf( passwordField.getPassword()).equals("")||comboBox.getSelectedItem().equals("")||comboBox_2.getSelectedItem()==null||textField_4.getText().equals("")||textField_6.getText().equals(""))
				JOptionPane.showMessageDialog(btnNewButton, "alert", "alert", JOptionPane.ERROR_MESSAGE);
			else if(model.Main.libr.getAllEmployees().containsKey(textField.getText())) {
					JOptionPane.showMessageDialog(btnNewButton, "Employee Exist");
				}
			else if (Integer.parseInt(textField_4.getText())<1900||Integer.parseInt(textField_4.getText())>2022) {
				JOptionPane.showMessageDialog(btnNewButton, "Illegal year of birth");
			}
			else {
				Employee h1= new Employee(textField.getText(),textField_1.getText(), textField_2.getText(),textField_3.getText(),(Gender)comboBox.getSelectedItem(),LocalDateTime.now(),Double.parseDouble(textField_6.getText()),model.Main.libr.getAllDepartments().get(comboBox_2.getSelectedItem()),Integer.parseInt(textField_4.getText()),String.copyValueOf(passwordField.getPassword()));
					try {
						model.Main.libr.addEmployee(h1);
					} catch (PersonAlreadyExistException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (YearOfBirthNotInRange e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(btnNewButton, "Employee Added");
				}
			}
	});
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	pack();
	setSize(screenSize.width/2,screenSize.height/2);
	btnNewButton.setBounds(292, 158, 89, 23);
	contentPane.add(btnNewButton);
	

	}
}
