package amazonia.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

import amazonia.controllers.*;

public class DoDriverAssignmentPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private DoDriverAssignmentController controller;
	
	//components 
	private JLabel title, TextnameDriver, TextlicensePlate;
	private JTextField nameDriver, licensePlate;
	private JButton add, cancel;
	
	public void setController(DoDriverAssignmentController controller) {
		this.controller=controller;
		this.add.addActionListener(controller);
		this.cancel.addActionListener(controller);
	}
	
	public DoDriverAssignmentPanel() {
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		this.title= new JLabel("New Driver Assignment");
		title.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.add(title);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, title, 20, SpringLayout.NORTH, this);
		
		this.add = new JButton("Add");
		add.setPreferredSize(new Dimension(100, 28));
		this.add(add);
		layout.putConstraint(SpringLayout.NORTH, add, 250, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, add,340, SpringLayout.WEST, this);
		this.add.setBackground(Color.GREEN);
		
		this.cancel = new JButton("Cancel");
		cancel.setPreferredSize(new Dimension(100, 28));
		this.add(cancel);
		layout.putConstraint(SpringLayout.NORTH, cancel, 350, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, cancel,10, SpringLayout.WEST, this);
		
		//Text fields 
		this.nameDriver = new JTextField(35);
		this.add(nameDriver);
		layout.putConstraint(SpringLayout.NORTH, nameDriver, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, nameDriver,250, SpringLayout.WEST, this);
		
		this.licensePlate = new JTextField(35);
		this.add(licensePlate);
		layout.putConstraint(SpringLayout.NORTH, licensePlate, 190, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, licensePlate,250, SpringLayout.WEST, this);
		
		//Text of guidance
		this.TextnameDriver = new JLabel("Name of Driver");
		TextnameDriver.setFont(new Font("Times New Roman", Font.BOLD, 16));
		this.add(TextnameDriver);
		
		layout.putConstraint(SpringLayout.NORTH, TextnameDriver, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, TextnameDriver,40, SpringLayout.WEST, this);
		
		
		this.TextlicensePlate = new JLabel("License Plate");
		this.TextlicensePlate.setFont(new Font("Times New Roman", Font.BOLD, 16));
		this.add(TextlicensePlate);
		
		layout.putConstraint(SpringLayout.NORTH, TextlicensePlate, 190, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, TextlicensePlate,40, SpringLayout.WEST, this);
		
	}
	
	public String getNameofDriver() {
		return this.nameDriver.getText();
	}
	
	public String getLicensePlate() {
		return this.licensePlate.getText();
	}
	
	//button getters
	
	public JButton getAddButton() {
		return this.add;
	}
	
	public JButton getCancelButton() {
		return this.cancel;
	}
	
	
	
}
