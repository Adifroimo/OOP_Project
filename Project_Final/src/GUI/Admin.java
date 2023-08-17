package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Main;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

public class Admin extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public Admin() {
		
		
		
		Container backtop = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
        
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.RED);
		menuBar.setForeground(Color.BLACK);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Add");
		menuBar.add(mnNewMenu);
		
		JMenu removemntm = new JMenu("Remove");
		menuBar.add(removemntm);
		
		JMenuItem rremove = new JMenuItem("Remove Vehicle");
		removemntm.add(rremove);
		
		rremove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				RemoveVehicle a = new RemoveVehicle();
				setContentPane(a);
				getContentPane().setVisible(true);				
			}
		});
		
		JMenuItem mntmNewMenuItem_18 = new JMenuItem("Remove Employee");
		removemntm.add(mntmNewMenuItem_18);
		
		mntmNewMenuItem_18.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				RemoveEmoployee a = new RemoveEmoployee();
				setContentPane(a);
				getContentPane().setVisible(true);				
			}
		});
		
		JMenuItem mntmNewMenuItem_19 = new JMenuItem("Remove Customer");
		removemntm.add(mntmNewMenuItem_19);
		
		mntmNewMenuItem_19.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				Remove_Customer a = new Remove_Customer();
				setContentPane(a);
				getContentPane().setVisible(true);				
			}
		});
		
		JMenuItem mntmNewMenuItem_20 = new JMenuItem("Remove Department");
		mntmNewMenuItem_20.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				RemoveDepartment a = new RemoveDepartment();
				setContentPane(a);
				getContentPane().setVisible(true);
			}
		});
		removemntm.add(mntmNewMenuItem_20);
		
		JMenuItem mntmNewMenuItem_23 = new JMenuItem("Remove Deal");
		mntmNewMenuItem_23.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				RemoveDeal a = new RemoveDeal();
				setContentPane(a);
				getContentPane().setVisible(true);
			}
		});
		removemntm.add(mntmNewMenuItem_23);
		
		
		
		JMenu mnNewMenu_2 = new JMenu("Quieries");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Vehicle's DataBase");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				GetRealVehicle a = new GetRealVehicle();
				setContentPane(a);
				getContentPane().setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_12);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Employee/Customer DataBase");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				GetRealEC a = new GetRealEC();
				setContentPane(a);
				getContentPane().setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_13);
		
		JMenuItem avgp = new JMenuItem("avgPollutionLevelDeal");
		avgp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				avgpollutionlevelofdeal a = new avgpollutionlevelofdeal();
				setContentPane(a);
				getContentPane().setVisible(true);

			}
		});
		
		JMenuItem mntmNewMenuItem_21 = new JMenuItem("Deal's DataBase");
		mntmNewMenuItem_21.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				getrealDeal a = new getrealDeal();
				setContentPane(a);
				getContentPane().setVisible(true);
			}
		});
		
		mnNewMenu_2.add(mntmNewMenuItem_21);
		JMenuItem mntmNewMenuItem_22 = new JMenuItem("Department's DataBase");
		mntmNewMenuItem_22.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				getrealDepartment a = new getrealDepartment();
				setContentPane(a);
				getContentPane().setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_22);
		mnNewMenu_2.add(avgp);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("totalProfit");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				totalprofit a = new totalprofit();
				setContentPane(a);
				getContentPane().setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_14);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("allEmployees");
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				allemployeesorder a = new allemployeesorder();
				setContentPane(a);
				getContentPane().setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_15);
		
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("allBestsDpManager");
		
		mntmNewMenuItem_16.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				allbestsdp a = new allbestsdp();
				setContentPane(a);
				getContentPane().setVisible(true);

			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_16);
		
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("ProfitPerVehicle");
		
		mntmNewMenuItem_17.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				profitpervehicle a = new profitpervehicle();
				setContentPane(a);
				getContentPane().setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_17);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add Car");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				AddCar a = new AddCar(backtop);
				setContentPane(a);
				getContentPane().setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add Employee");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				AddEmployee a = new AddEmployee();
				setContentPane(a);
				getContentPane().setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Add Customer");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				AddCustomer a = new AddCustomer();
				setContentPane(a);
				getContentPane().setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Add Deal");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				AddDeal a = new AddDeal();
				setContentPane(a);
				getContentPane().setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Add Department");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				AddDepartment a = new AddDepartment();
				setContentPane(a);
				getContentPane().setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Add Department Manager");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				AddDepartmentManager a = new AddDepartmentManager();
				setContentPane(a);
				getContentPane().setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Add HybridCar");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				AddHybridCar a = new AddHybridCar();
				setContentPane(a);
				getContentPane().setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Add HybridMotor");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				AddHybridMotorcycle a = new AddHybridMotorcycle();
				setContentPane(a);
				getContentPane().setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Add Van");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				AddVan a = new AddVan();
				setContentPane(a);
				getContentPane().setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Add VipCustomer");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				AddVipCustomer a = new AddVipCustomer();
				setContentPane(a);
				getContentPane().setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Add Motorcycle");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setVisible(false);
				AddMotorcycle a = new AddMotorcycle();
				setContentPane(a);
				getContentPane().setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_10);
		
		JMenu mnNewMenu_3 = new JMenu("BACK/SAVE");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmback = new JMenuItem("Back");
		mntmback.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SoundEffect sEffect =new SoundEffect();
				sEffect.setFile(this.getClass().getResource("/backs.wav"));
				sEffect.play();
				dispose();
				Admin guiback = new Admin();
				guiback.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmback);
		
		JMenuItem mntmsave = new JMenuItem("Save");
		mntmsave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					SoundEffect sEffect =new SoundEffect();
					sEffect.setFile(this.getClass().getResource("/confirmsound.wav"));
					sEffect.play();
					
					Main.save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu_3.add(mntmsave);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Log out");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SoundEffect sEffect =new SoundEffect();
				sEffect.setFile(this.getClass().getResource("/backs.wav"));
				sEffect.play();
				// TODO Auto-generated method stub
				dispose();
				LogIn frame;
				try {
					frame = new LogIn();
					frame.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hello Admin!");
		lblNewLabel.setBounds(161, 53, 97, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(129, 81, 148, 16);
		contentPane.add(lblNewLabel_1);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime nowDateTime = LocalDateTime.now();
		lblNewLabel_1.setText(dateTimeFormatter.format(nowDateTime));
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnNewButton.setBounds(141, 137, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(54, 6, 411, 238);
		contentPane.add(lblNewLabel_2);
		ImageIcon imageIcon= new ImageIcon(this.getClass().getResource("/im1.png.jpeg"));
		lblNewLabel_2.setIcon(imageIcon);
		
		JLabel label = new JLabel("New label");
		label.setBounds(161, 178, 61, 16);
		contentPane.add(label);
		
		
       

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width/2,screenSize.height/2);
		
	}
	public class SoundEffect{
		Clip clip;
		public void setFile(URL url) {
			try {
//				File file = new File(url);
				AudioInputStream sound = AudioSystem.getAudioInputStream(url);
				clip = AudioSystem.getClip();
				clip.open(sound);
				
			} catch (Exception e) {
				// TODO: handle exception
				clip.start();
			}
		}
		public void play() {
			clip.setFramePosition(0);
			clip.start();
		}
		
	}
}
