package amazonia.views;

import java.awt.*;
import javax.swing.*;

import amazonia.controllers.HomeDriverController;

public class HomeDriverPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private HomeDriverController controller;
	
	private JPanel driverPanel;
	private JLabel mainLabel;
	
	//tiene 4 botones esta pantalla + logout
	private JButton setStatusButton;
	private JButton accessDriverAssignmentButton;
	private JButton logoutButton;
	private JButton SetBrokenButton;
	
	 final static String[] status = {"DELIVERED", "NON-DELIVERED"};
	private JComboBox<String> deliveryStatus;
	
	
	private JTextField Order;
	private JTextField setBrokenField;
	
	final static String DRIVER_PANEL = "DRIVER PANEL";
	final static String STATUS_PANEL = "STATUS PANEL";
	final static String ACCESS_ASSIGNMENT_PANEL = "ACCESS PLAN PANEL";
	final static String NOTIFICATIONS_PANEL = "NOTIFICATIONS PANEL";
	
	public void SetController(HomeDriverController controller) {
		this.controller = controller;
		this.setStatusButton.addActionListener(controller);
		this.accessDriverAssignmentButton.addActionListener(controller);
		this.logoutButton.addActionListener(controller);
		this.SetBrokenButton.addActionListener(controller);
	}
	
	public HomeDriverPanel() {
		
		CardLayout card_layout = new CardLayout();
		this.setLayout(card_layout);
		
		//create Spring layout that contains elements
		this.driverPanel = new JPanel();
		SpringLayout layout = new SpringLayout();		
		this.driverPanel.setLayout(layout);
		
		this.mainLabel = new JLabel("Home Driver");
		this.mainLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		this.driverPanel.add(mainLabel);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, mainLabel, 0, SpringLayout.HORIZONTAL_CENTER, driverPanel);
		layout.putConstraint(SpringLayout.NORTH, mainLabel, 10, SpringLayout.NORTH, driverPanel);
		
		//Edit state of delivery
		setStatusButton = new JButton("Edit state of a delivery");
		setStatusButton.setPreferredSize(new Dimension(200, 30));
		driverPanel.add(setStatusButton);
		
		layout.putConstraint(SpringLayout.NORTH, setStatusButton, 250, SpringLayout.NORTH, mainLabel);
		layout.putConstraint(SpringLayout.WEST, setStatusButton, 450, SpringLayout.WEST, driverPanel);
		
		this.deliveryStatus = new JComboBox<String>(status);
		this.deliveryStatus.setSelectedIndex(0);
		this.driverPanel.add(deliveryStatus);
		layout.putConstraint(SpringLayout.NORTH, deliveryStatus, 220, SpringLayout.NORTH, mainLabel);
		layout.putConstraint(SpringLayout.WEST, deliveryStatus, 450, SpringLayout.WEST, driverPanel);
		
		this.Order = new JTextField(7);
		this.driverPanel.add(Order);
		this.Order.setSize(6, 6);
		layout.putConstraint(SpringLayout.NORTH, Order, 220, SpringLayout.NORTH, mainLabel);
		layout.putConstraint(SpringLayout.WEST, Order, 580, SpringLayout.WEST, driverPanel);
		
		//Radio button DELIVERED y NON-DELIVERED
		//this.delivered = new JRadioButton("Delivered");
		//this.add(delivered);
		//layout.putConstraint(SpringLayout.NORTH, delivered, 150, SpringLayout.NORTH, mainLabel);
		//layout.putConstraint(SpringLayout.WEST, delivered, 150, SpringLayout.WEST, driverPanel);

		//this.nonDelivered = new JRadioButton("Non-Delivered");
		//this.add(nonDelivered);
		//layout.putConstraint(SpringLayout.NORTH, nonDelivered, 150, SpringLayout.NORTH, mainLabel);
		//layout.putConstraint(SpringLayout.WEST, nonDelivered, 250, SpringLayout.WEST, driverPanel);

		//ButtonGroup group = new ButtonGroup();
		//group.add(delivered);
		//group.add(nonDelivered);

		//Access DriverAssignment
		accessDriverAssignmentButton = new JButton("Access my Driver Assignment");
		accessDriverAssignmentButton.setPreferredSize(new Dimension(200, 30));
		driverPanel.add(accessDriverAssignmentButton);
		
		layout.putConstraint(SpringLayout.NORTH, accessDriverAssignmentButton, 130, SpringLayout.NORTH, mainLabel);
		layout.putConstraint(SpringLayout.WEST, accessDriverAssignmentButton, 150, SpringLayout.WEST, driverPanel);

		this.SetBrokenButton = new JButton("Report broken Truck");
		SetBrokenButton.setPreferredSize(new Dimension(200, 30));
		driverPanel.add(SetBrokenButton);
		layout.putConstraint(SpringLayout.NORTH, SetBrokenButton, 250, SpringLayout.NORTH, mainLabel);
		layout.putConstraint(SpringLayout.WEST, SetBrokenButton, 150, SpringLayout.WEST, driverPanel);
		
		this.setBrokenField = new JTextField(20);
		driverPanel.add(setBrokenField);
		layout.putConstraint(SpringLayout.NORTH, setBrokenField, 220, SpringLayout.NORTH, mainLabel);
		layout.putConstraint(SpringLayout.WEST, setBrokenField, 150, SpringLayout.WEST, driverPanel);
		
		
		//Logout
		logoutButton = new JButton("Log-out");
		logoutButton.setPreferredSize(new Dimension(130, 28));
		driverPanel.add(logoutButton);
		layout.putConstraint(SpringLayout.NORTH, logoutButton, 15, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, logoutButton, 15, SpringLayout.WEST, this);
		
		//Set main panel size
		this.driverPanel.setPreferredSize(new Dimension(500, 300));
		this.add(driverPanel, DRIVER_PANEL);
	}
	
	//Button Getters
	public JButton getLogoutButton() {
		return this.logoutButton;
	}
	
	public JButton getSetBrokenButton() {
		return this.SetBrokenButton;
	}
	
	public JComboBox<String> getDeliveredStatus() {
		return this.deliveryStatus;
	}
	
	public JButton getEditStateofDeliveryButton() {
		return this.setStatusButton;
	}
	
	
	//Field getters
	public String getBrokenTruckField() {
		return this.setBrokenField.getText();
	}
	
	public String getOrderid() {
		return this.Order.getText();
	}
	
	
}