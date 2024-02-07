package amazonia.window;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import amazonia.controllers.*;
import amazonia.views.*;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	final static String LOGIN_PANEL = "LOGIN PANEL";
	final static String REGISTER_PANEL = "REGISTER PANEL";
	final static String HOME_COMPANY_PANEL = "COMPANY HOME PANEL";
	final static String HOME_DRIVER_PANEL = "DRIVER HOME PANEL";
	final static String HOME_OPERATOR_PANEL = "OPERATOR HOME PANEL";
	final static String MAIN_PANEL = "MAIN_PANEL";
	
	private JPanel mainPanel;
	private JButton loginButton;
	private JButton registerButton;
	
	private MainWindowController controller;
	
	public MainWindow() {
		super("AMAZONIA");
		super.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		Container container = this.getContentPane();
		container.setLayout(new CardLayout());
		
		//create main panel view and add elements to it
		this.mainPanel = new JPanel();
		SpringLayout layout = new SpringLayout();		
		this.mainPanel.setLayout(layout);
		
		this.loginButton = new JButton("Log-in");
		loginButton.setPreferredSize(new Dimension(145, 35));
		mainPanel.add(loginButton);
		
		layout.putConstraint(SpringLayout.NORTH, loginButton, 130, SpringLayout.NORTH, mainPanel);
		layout.putConstraint(SpringLayout.WEST, loginButton, 320, SpringLayout.WEST, mainPanel);
		
		this.registerButton = new JButton("Register");
		registerButton.setPreferredSize(new Dimension(145, 35));
		mainPanel.add(registerButton);
		
		layout.putConstraint(SpringLayout.NORTH, registerButton, 200, SpringLayout.NORTH, mainPanel);
		layout.putConstraint(SpringLayout.WEST, registerButton, 320, SpringLayout.WEST, mainPanel);

		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("files\\logo.JPG"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(250, 100,
		        Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		JLabel picLabel = new JLabel(imageIcon);
		mainPanel.add(picLabel);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, picLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, picLabel, 10, SpringLayout.NORTH, this);
		this.mainPanel.setBackground(Color.white);

		container.add(mainPanel, MAIN_PANEL);
		
		//create panel views//
		LoginPanel login  = new LoginPanel();
		RegisterPanel register = new RegisterPanel();
		HomeDriverPanel homedriver = new HomeDriverPanel();
		HomeOperatorPanel homeoperator = new HomeOperatorPanel();
		HomeCompanyPanel homecompany = new HomeCompanyPanel();
		
		//create their controllers//
		LoginController loginController = new LoginController(login, this);
		RegisterController registerController = new RegisterController(register, this);
		HomeDriverController homedriverController = new HomeDriverController(homedriver,this);
		HomeOperatorController homeoperatorController = new HomeOperatorController(homeoperator, this);
		HomeCompanyController homecompanyController = new HomeCompanyController(homecompany, this);
		
		login.SetController(loginController);
		register.setController(registerController);
		homecompany.setController(homecompanyController);
		homeoperator.SetController(homeoperatorController);
		homedriver.SetController(homedriverController);
		
		//add frames to container
		container.add(login,LOGIN_PANEL);
		container.add(register, REGISTER_PANEL);
		container.add(homecompany, HOME_COMPANY_PANEL);
		container.add(homedriver, HOME_DRIVER_PANEL);
		container.add(homeoperator,HOME_OPERATOR_PANEL);
		
		//Set controller of MainWindow
		this.controller = new MainWindowController(this);
		
		//Associate Buttons to controller
		this.loginButton.addActionListener(this.controller);
		this.registerButton.addActionListener(this.controller);
		
		//extra
		this.setPreferredSize(new Dimension(800, 450));
		this.pack(); 
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Methods to show each frame
	public void ShowLogin() {
		CardLayout cl = (CardLayout)(this.getContentPane().getLayout());
		cl.show(this.getContentPane(), LOGIN_PANEL);
	}
	
	public void ShowRegister() {
		CardLayout cl = (CardLayout)(this.getContentPane().getLayout());
		cl.show(this.getContentPane(), REGISTER_PANEL);
	}
	
	public void ShowHomeCompany() {
		CardLayout cl = (CardLayout)(this.getContentPane().getLayout());
		cl.show(this.getContentPane(), HOME_COMPANY_PANEL);
	}
	
	public void ShowHomeOperator() {
		CardLayout cl = (CardLayout)(this.getContentPane().getLayout());
		cl.show(this.getContentPane(), HOME_OPERATOR_PANEL);
	}
	
	public void ShowHomeDriver() {
		CardLayout cl = (CardLayout)(this.getContentPane().getLayout());
		cl.show(this.getContentPane(), HOME_DRIVER_PANEL);
	}
	
	public void showmainPanel() {
		CardLayout cl = (CardLayout)(this.getContentPane().getLayout());
		cl.show(this.getContentPane(), MAIN_PANEL);
	}
	
	//Buttons Getters
	public JButton getLoginButton() {
		return this.loginButton;
	}
	
	public JButton getRegisterButton() {
		return this.registerButton;
	}
	
	
	//Tester
	public static void main(String args[]) {
			MainWindow tester = new MainWindow();
			tester.showmainPanel();
	}
}
