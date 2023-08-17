package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Car;
import model.Department;
import utils.Color;
import utils.Specialization;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AddDepartment extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AddDepartment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Department ID");
		lblNewLabel.setBounds(28, 30, 86, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Specialization");
		lblNewLabel_1.setBounds(28, 67, 86, 26);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(166, 33, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c))|| (c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		
		JComboBox<Specialization> comboBox = new JComboBox<Specialization>();
		comboBox.setBounds(166, 69, 96, 22);
		comboBox.setModel(new DefaultComboBoxModel<>(Specialization.values()));
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(textField.getText().equals("")||comboBox.getSelectedItem().equals(""))
				JOptionPane.showMessageDialog(btnNewButton, "alert", "alert", JOptionPane.ERROR_MESSAGE);
			else {
				if(model.Main.libr.getAllDepartments().containsKey(Integer.parseInt(textField.getText()))) {
					JOptionPane.showMessageDialog(btnNewButton, "Department already exist");
				}
				else {
					Department h1= new Department(Integer.parseInt(textField.getText()),(Specialization)comboBox.getSelectedItem());
					model.Main.libr.getAllDepartments().put(h1.getDepartmentID(), h1);
					JOptionPane.showMessageDialog(btnNewButton, "Department Added");
					
				}
			}
		}
	});
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width/2,screenSize.height/2);
		btnNewButton.setBounds(166, 131, 89, 23);
		contentPane.add(btnNewButton);
		
	}
}
