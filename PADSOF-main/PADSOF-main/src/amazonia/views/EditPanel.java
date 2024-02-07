package amazonia.views;

import javax.swing.*;
import amazonia.controllers.*;
import java.awt.*;

public class EditPanel extends JPanel {
    
	private EditController controller;
	private static final long serialVersionUID = 1L;

    private JLabel title;
    private JButton back;
    private JTextField newPassword, oldPassword, name, cardnumber, email, adress, zipcode;
	private JButton save;
	
	public void setController(EditController controller) {
		this.controller = controller;
        this.back.addActionListener(controller);
        this.save.addActionListener(controller);
	}

    public EditPanel() {
        
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        
        JLabel title = new JLabel("Edit your personal information");
    	this.add(title);
    	title.setFont(new Font("Arial", Font.BOLD, 25));
    	layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, this);
        
        JLabel newPasswordLabel = new JLabel("Old Password:");
        this.add(newPasswordLabel);
        layout.putConstraint(SpringLayout.NORTH, newPasswordLabel, 130, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, newPasswordLabel, 100, SpringLayout.WEST, this);
		
		this.oldPassword = new JTextField(20);
		this.add(oldPassword);
		layout.putConstraint(SpringLayout.NORTH, oldPassword, 130, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, oldPassword, 250, SpringLayout.WEST, this);
		
		JLabel oldPasswordLabel = new JLabel("New Password:");
        this.add(oldPasswordLabel);
        layout.putConstraint(SpringLayout.NORTH, oldPasswordLabel, 160, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, oldPasswordLabel, 100, SpringLayout.WEST, this);

        this.newPassword = new JTextField(20);
		this.add(newPassword);
		layout.putConstraint(SpringLayout.NORTH, newPassword, 160, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, newPassword, 250, SpringLayout.WEST, this);
		
        JLabel nameLabel = new JLabel("New name: ");
        this.add(nameLabel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 190, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, nameLabel, 100, SpringLayout.WEST, this);

        this.name = new JTextField(20);
        this.add(this.name);
        layout.putConstraint(SpringLayout.NORTH, this.name, 190, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, this.name, 250, SpringLayout.WEST, this);

        JLabel cardNumberLabel = new JLabel("New Card Number");
        this.add(cardNumberLabel);
        layout.putConstraint(SpringLayout.NORTH, cardNumberLabel, 220, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, cardNumberLabel, 100, SpringLayout.WEST, this);

        this.cardnumber = new JTextField(20);
        this.add(cardnumber);
        layout.putConstraint(SpringLayout.NORTH, cardnumber, 220, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, cardnumber, 250, SpringLayout.WEST, this);

        JLabel emailLabel = new JLabel("New email");
        this.add(emailLabel);
        layout.putConstraint(SpringLayout.NORTH, emailLabel, 250, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, emailLabel, 100, SpringLayout.WEST, this);

        this.email = new JTextField(20);
        this.add(email);
        layout.putConstraint(SpringLayout.NORTH, email, 250, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, email, 250, SpringLayout.WEST, this);

        JLabel adressLabel = new JLabel("New Billing Address");
        this.add(adressLabel);
        layout.putConstraint(SpringLayout.NORTH, adressLabel, 280, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, adressLabel, 100, SpringLayout.WEST, this);

        this.adress = new JTextField(20);
        this.add(adress);
        layout.putConstraint(SpringLayout.NORTH, adress, 280, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, adress, 250, SpringLayout.WEST, this);

        JLabel zipLabel = new JLabel("New Zip Code");
        this.add(zipLabel);
        layout.putConstraint(SpringLayout.NORTH, zipLabel, 310, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, zipLabel, 100, SpringLayout.WEST, this);

        this.zipcode = new JTextField(20);
        this.add(zipcode);
        layout.putConstraint(SpringLayout.NORTH, zipcode, 310, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, zipcode, 250, SpringLayout.WEST, this);

        this.back = new JButton("Back");
        back.setPreferredSize(new Dimension(130, 28));
        this.add(back);
        layout.putConstraint(SpringLayout.NORTH, back, 15, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, back, 15, SpringLayout.WEST, this);
        
        this.save = new JButton("Save changes");
        this.add(save);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, save, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, save, 340, SpringLayout.NORTH, this);
		this.save.setBackground(Color.CYAN);
    }
    
    //Button getters

    public JButton getBackButton() {
    	return this.back;
    }
    
    public JButton getSaveButton() {
    	return this.save;
    }
    
    //Field getters 

    public String getOldPassword() {
    	return this.oldPassword.getText();
    }
    
    public String getNewPassword() {
    	return this.newPassword.getText();
    }

    public String getName(){
        return this.name.getText();

    }

    public String getCardNumber(){
        return this.cardnumber.getText();
    }

    public String getEmail(){
        return this.email.getText();
    }

    public String getAdress(){
        return this.adress.getText();
    }

    public String getZipCode(){
        return this.zipcode.getText();
    }
}