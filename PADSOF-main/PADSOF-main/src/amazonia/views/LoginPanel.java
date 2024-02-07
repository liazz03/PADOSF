package amazonia.views;

import java.awt.*;
import javax.swing.*;

import amazonia.controllers.HomeOperatorController;
import amazonia.controllers.LoginController;

public class LoginPanel extends JPanel {
    
	private static final long serialVersionUID = 1L;
	
	private LoginController controller;
	private JPasswordField password;
	private JTextField username;
	private JButton login;
	private JButton back;
	private JRadioButton operator, driver, company;
	private ButtonGroup group;
	
	
	public void SetController(LoginController controller) {
		this.controller = controller;
		this.login.addActionListener(controller);
		this.back.addActionListener(controller);
		this.operator.addActionListener(controller);
		this.driver.addActionListener(controller);
		this.company.addActionListener(controller);
	}
	
	
	public LoginPanel() {
		
		//set layout
		SpringLayout layout = new SpringLayout();		
		this.setLayout(layout);
		
		JLabel title = new JLabel("LOG IN");
		this.add(title);
		title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, this);
		
		//necessary fields
        JLabel userLabel = new JLabel("Name:");
        this.add(userLabel);
        layout.putConstraint(SpringLayout.NORTH, userLabel, 120, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, userLabel, 220, SpringLayout.WEST, this);
       
        this.username = new JTextField(13);
		this.add(username);
		layout.putConstraint(SpringLayout.NORTH, username, 120, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, username, 360, SpringLayout.WEST, this);
		
        JLabel passwordLabel = new JLabel("Password:");
        this.add(passwordLabel);
        layout.putConstraint(SpringLayout.NORTH, passwordLabel, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, passwordLabel, 220, SpringLayout.WEST, this);
        
        this.password = new JPasswordField(13);
		this.add(password);
		layout.putConstraint(SpringLayout.NORTH, password, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, password, 360, SpringLayout.WEST, this);
		
        //buttons
        this.login = new JButton("Login");
        this.add(login);
        layout.putConstraint(SpringLayout.NORTH, login, 220, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, login, 360, SpringLayout.WEST, this);
		this.login.setBackground(Color.GREEN);
		
		
        this.back = new JButton("Back");
        this.add(back);
        back.setPreferredSize(new Dimension(130, 28));
		layout.putConstraint(SpringLayout.NORTH, back, 15, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, back, 15, SpringLayout.WEST, this);
       
        //Radio Buttons
        this.operator = new JRadioButton("Operator");
		this.add(operator);
		layout.putConstraint(SpringLayout.NORTH, operator, 110, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, operator, 550, SpringLayout.WEST, this);
		
        this.driver = new JRadioButton("Driver");
		this.add(driver);
		layout.putConstraint(SpringLayout.NORTH, driver, 130, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, driver, 550, SpringLayout.WEST, this);
		
        this.company = new JRadioButton("Company");
		this.add(company);
		layout.putConstraint(SpringLayout.NORTH, company, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, company, 550, SpringLayout.WEST, this);
		
        //Radio Buttons
        ButtonGroup group = new ButtonGroup();
        group.add(operator);
        group.add(driver);
        group.add(company);
    }
	
	//Button and Radio BUttons getters
	public JButton getBackButton() {
		return this.back;
	}
	
	public JButton getLoginButton() {
		return this.login;
	}
	
	public JRadioButton getOperatorSel() {
		return this.operator;
	}
	
	public JRadioButton getDriverSel() {
		return this.driver;
	}
	
	public JRadioButton getCompanySel() {
		return this.company;
	}
	
	//Text fields getters
	public String getUsername() {
		return this.username.getText();
	}
	
	public String getPassword() {
		String myPass=String.valueOf(password.getPassword());
		return myPass;
	}
	
	
	
	
	
	
	
}
