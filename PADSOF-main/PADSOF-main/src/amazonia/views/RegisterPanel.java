package amazonia.views;

import java.awt.*;

import javax.swing.*;
import amazonia.controllers.RegisterController;

public class RegisterPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private RegisterController controller;
	private JPasswordField password;
	private JTextField name, code, email, billing, cardNumber, ZipCode;
	private JButton back;
	private JButton signup;
	
	public void setController(RegisterController controller) {
		this.controller = controller;
		this.back.addActionListener(controller);
		this.signup.addActionListener(controller);
	}
    
    public RegisterPanel() {

    	SpringLayout layout = new SpringLayout();
    	this.setLayout(layout);
    	
    	JLabel title = new JLabel("REGISTER");
    	this.add(title);
    	title.setFont(new Font("Arial", Font.BOLD, 25));
    	layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, this);

        //ImageIcon image = new ImageIcon("fondo.png");
        //frame.setIconImage(image.getImage());
        //frame.getContentPane().setBackground(new Color(255, 51, 51));
		
		//USERNAME
		JLabel userLabel = new JLabel("Name:");
        this.add(userLabel);
        layout.putConstraint(SpringLayout.NORTH, userLabel, 100, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, userLabel, 180, SpringLayout.WEST, this);
		
		this.name = new JTextField(20);
		this.add(name);
		layout.putConstraint(SpringLayout.NORTH, name, 100, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, name, 360, SpringLayout.WEST, this);
		
		//PASSWORD
		JLabel passwordLabel = new JLabel("Password:");
        this.add(passwordLabel);
        layout.putConstraint(SpringLayout.NORTH, passwordLabel, 130, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, passwordLabel, 180, SpringLayout.WEST, this);
        
        this.password = new JPasswordField(20);
		this.add(password);
		layout.putConstraint(SpringLayout.NORTH, password, 130, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, password, 360, SpringLayout.WEST, this);
		
		//CIF code
		JLabel codeLabel = new JLabel("CIF code:");
        this.add(codeLabel);
        layout.putConstraint(SpringLayout.NORTH, codeLabel, 160, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, codeLabel, 180, SpringLayout.WEST, this);
		
		this.code = new JTextField(20);
		this.add(code);
		layout.putConstraint(SpringLayout.NORTH, code, 160, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, code, 360, SpringLayout.WEST, this);
		
		//Email address
		JLabel emailLabel = new JLabel("Email address:");
        this.add(emailLabel);
        layout.putConstraint(SpringLayout.NORTH, emailLabel, 190, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, emailLabel, 180, SpringLayout.WEST, this);
		
		this.email = new JTextField(20);
		this.add(email);
		layout.putConstraint(SpringLayout.NORTH, email, 190, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, email, 360, SpringLayout.WEST, this);
		
		//Billing address
		JLabel billingLabel = new JLabel("Billing address:");
        this.add(billingLabel);
        layout.putConstraint(SpringLayout.NORTH, billingLabel, 220, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, billingLabel, 180, SpringLayout.WEST, this);
		
		this.billing = new JTextField(20);
		this.add(billing);
		layout.putConstraint(SpringLayout.NORTH, billing, 220, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, billing, 360, SpringLayout.WEST, this);
		
		//Credit card number
		JLabel cardNumberLabel = new JLabel("Credit card number:");
        this.add(cardNumberLabel);
        layout.putConstraint(SpringLayout.NORTH, cardNumberLabel, 250, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, cardNumberLabel, 180, SpringLayout.WEST, this);
		
		this.cardNumber = new JTextField(20);
		this.add(cardNumber);
		layout.putConstraint(SpringLayout.NORTH, cardNumber, 250, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, cardNumber, 360, SpringLayout.WEST, this);
		
		//ZIP CODE
		JLabel ZIPCodeLabel = new JLabel("ZIP Code:");
		this.add(ZIPCodeLabel);
		layout.putConstraint(SpringLayout.NORTH, ZIPCodeLabel, 280, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, ZIPCodeLabel, 180, SpringLayout.WEST, this);
		
		this.ZipCode = new JTextField(20);
		this.add(ZipCode);
		layout.putConstraint(SpringLayout.NORTH, ZipCode, 280, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, ZipCode, 360, SpringLayout.WEST, this);
		
		// BUTTONS
        this.signup = new JButton("Sign-up");
        this.add(signup);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, signup, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, signup, 340, SpringLayout.NORTH, this);
		this.signup.setBackground(Color.CYAN);
		
		this.back = new JButton("Back");
        back.setPreferredSize(new Dimension(130, 28));
        this.add(back);
		layout.putConstraint(SpringLayout.NORTH, back, 15, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, back, 15, SpringLayout.WEST, this);
    }
    
    public JButton getSignUpButton() {
    	return this.signup;
    }
    
    public JButton getBackButton() {
		return this.back;
	}
   
    //getters of fields
    public String getName() {
    	return this.name.getText();
    }
    
    public String getCode() {
    	return this.code.getText();
    }
    
    public String getEmail() {
    	return this.email.getText();
    }
    
    public String getBilling() {
    	return this.billing.getText();
    }
    
    public String getcardNumber() {
    	return this.cardNumber.getText();
    }
    
	public String getPassword() {
		String myPass=String.valueOf(password.getPassword());
		return myPass;
	}
	
	public String getZipCode() {
		return this.ZipCode.getText();
	}
    
    
}




