package amazonia.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

import amazonia.controllers.RegisterDriverController;


public class RegisterDriverPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private RegisterDriverController controller;
	
	//components
	private JLabel title, Textusername, Textpassword, Textphonenumber;
	private JButton add, cancel;
	private JTextField username, phonenumber;
	private JPasswordField password;
	
	public void setController(RegisterDriverController controller) {
		this.controller = controller;
		this.add.addActionListener(controller);
		this.cancel.addActionListener(controller);
	}	
	
	public RegisterDriverPanel() {
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		this.title = new JLabel("Register new Driver");
		title.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.add(title);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, title, 20, SpringLayout.NORTH, this);
		
		//buttons
		this.add = new JButton("Add");
		add.setPreferredSize(new Dimension(100, 28));
		this.add(add);
		layout.putConstraint(SpringLayout.NORTH, add, 280, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, add,340, SpringLayout.WEST, this);
		this.add.setBackground(Color.GREEN);
		
		this.cancel = new JButton("Cancel");
		cancel.setPreferredSize(new Dimension(130, 28));
		this.add(cancel);
		layout.putConstraint(SpringLayout.NORTH, cancel, 350, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, cancel, 10, SpringLayout.WEST, this);
		
		//Text fields
		this.username = new JTextField(35);
		this.add(username);
		layout.putConstraint(SpringLayout.NORTH, username, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, username, 250, SpringLayout.WEST, this);
		
		this.password = new JPasswordField(35);
		this.add(password);
		layout.putConstraint(SpringLayout.NORTH, password, 190, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, password, 250, SpringLayout.WEST, this);
		
		this.phonenumber = new JTextField(35);
		this.add(phonenumber);
		layout.putConstraint(SpringLayout.NORTH, phonenumber, 230, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, phonenumber, 250, SpringLayout.WEST, this);
		
		//Text of guidance
		this.Textusername = new JLabel("Username");
		Textusername.setFont(new Font("Times New Roman", Font.BOLD, 16));
		this.add(Textusername);
		
		layout.putConstraint(SpringLayout.NORTH, Textusername, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, Textusername, 70, SpringLayout.WEST, this);

		this.Textpassword = new JLabel("Password");
		Textpassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		this.add(Textpassword);
		
		layout.putConstraint(SpringLayout.NORTH, Textpassword, 190, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, Textpassword, 70, SpringLayout.WEST, this);
		
		this.Textphonenumber = new JLabel("Phone Number");
		Textphonenumber.setFont(new Font("Times New Roman", Font.BOLD, 16));
		this.add(Textphonenumber);
	
		layout.putConstraint(SpringLayout.NORTH, Textphonenumber, 230, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, Textphonenumber, 70, SpringLayout.WEST, this);
	}
	
	public String getusername() {
		return this.username.getText();
	}
	
	public String getpassword() {
		String myPass = String.valueOf(password.getPassword());
		return myPass;
	}
	
	public String getphonenumber() {
		return this.phonenumber.getText();
	}
	
	//button getters
	public JButton getcancell() {
		return this.cancel;
	}
	
	public JButton getadd() {
		return this.add;
	}
}
