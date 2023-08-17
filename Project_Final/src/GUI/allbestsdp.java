package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import model.DepartmentManager;
import model.Employee;
import model.Main;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class allbestsdp extends JInternalFrame {

	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 */
	public allbestsdp() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(152, 73, 97, 46);
		getContentPane().add(comboBox);
		JButton btnNewButton = new JButton("GetTheBest!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.removeAllItems();

				ArrayList< DepartmentManager> l1= new ArrayList<>();

				l1= Main.libr.AllBestsDepManger();
				for(DepartmentManager ss: l1) {
					comboBox.addItem(ss.getID());
				}
			}
		});
		btnNewButton.setBounds(142, 46, 117, 29);
		getContentPane().add(btnNewButton);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width/2,screenSize.height/2);

		
	}

}
