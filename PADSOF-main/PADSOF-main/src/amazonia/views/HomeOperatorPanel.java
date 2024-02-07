package amazonia.views;

import javax.swing.*;

import amazonia.controllers.*;

import java.awt.*;

public class HomeOperatorPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    
	private HomeOperatorController controller;
	
	private JPanel operatorPanel;
	private JLabel mainlabel;
	
	private JButton AddNewDriverButton;
	private JButton GenerateStatisticButton;
	private JButton DeliveryPlanButton;
	private JButton SettingsButton;
	private JButton SetFixedButton;
	private JButton logoutButton;
	private JButton DoDriverAssignmentButton;

	private JTextField LicensePlateEnter;
	
	private SettingsPanel settingsPanel;
	private DeliveryPlanPanel deliveryplanPanel;
	private GenerateStatisticPanel generatestatisticPanel;
	private RegisterDriverPanel registerdriverPanel;
	private DoDriverAssignmentPanel driverassignmentPanel;
	
	
	final static String OPERATOR_PANEL = "OPERATOR PANEL";
	final static String GENERATE_STATISTIC_PANEL = "STATISTICS PANEL";
	final static String DELIVERY_PLAN_PANEL = "DELIVERY PLAN PANEL";
	final static String SETTINGS_PANEL = "SETTINGS PANEL";
	final static String REGISTER_DRIVER_PANEL = "REGISTER DRIVER PANEL";
	final static String DRIVER_ASSIGNMENT_PANEL = "DRIVER ASSIGNMENT PANEL";
	
	
	public void SetController(HomeOperatorController controller) {
		this.controller = controller;
		this.AddNewDriverButton.addActionListener(controller);
		this.SettingsButton.addActionListener(controller);
		this.GenerateStatisticButton.addActionListener(controller);
		this.DeliveryPlanButton.addActionListener(controller);
		this.SetFixedButton.addActionListener(controller);
		this.logoutButton.addActionListener(controller);
		this.DoDriverAssignmentButton.addActionListener(controller);
	}
	
	public HomeOperatorPanel() {
		
		CardLayout card_layout = new CardLayout();
		this.setLayout(card_layout);
		
		//create Spring layout that contains elements
		this.operatorPanel = new JPanel();
		SpringLayout layout = new SpringLayout();		
		this.operatorPanel.setLayout(layout);
		
		//create elements and add them to operatorPanel
		
		//main label
		this.mainlabel = new JLabel("Home Operator");
		this.mainlabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		this.operatorPanel.add(mainlabel);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, mainlabel, 0, SpringLayout.HORIZONTAL_CENTER, operatorPanel);
		layout.putConstraint(SpringLayout.NORTH, mainlabel, 10, SpringLayout.NORTH, operatorPanel);
		
		///buttons
		AddNewDriverButton = new JButton("Add new Driver");
		AddNewDriverButton.setPreferredSize(new Dimension(250, 30));
		operatorPanel.add(AddNewDriverButton);
		
		layout.putConstraint(SpringLayout.NORTH, AddNewDriverButton, 150, SpringLayout.NORTH, mainlabel);
		layout.putConstraint(SpringLayout.WEST, AddNewDriverButton, 70, SpringLayout.WEST, operatorPanel);
		
		GenerateStatisticButton = new JButton("Statistics");
		GenerateStatisticButton.setPreferredSize(new Dimension(145, 30));
		operatorPanel.add(GenerateStatisticButton);
		
		layout.putConstraint(SpringLayout.NORTH, GenerateStatisticButton, 150, SpringLayout.NORTH, mainlabel);
		layout.putConstraint(SpringLayout.WEST, GenerateStatisticButton, 350, SpringLayout.WEST, operatorPanel);
		
		DeliveryPlanButton = new JButton("Driver routes");
		DeliveryPlanButton.setPreferredSize(new Dimension(200, 30));
		operatorPanel.add(DeliveryPlanButton);
		
		layout.putConstraint(SpringLayout.NORTH, DeliveryPlanButton, 150, SpringLayout.NORTH, mainlabel);
		layout.putConstraint(SpringLayout.WEST, DeliveryPlanButton, 525, SpringLayout.WEST, operatorPanel);
		
		SettingsButton = new JButton("Settings");
		SettingsButton.setPreferredSize(new Dimension(145, 30));
		operatorPanel.add(SettingsButton);
		
		layout.putConstraint(SpringLayout.NORTH, SettingsButton, 230, SpringLayout.NORTH, mainlabel);
		layout.putConstraint(SpringLayout.WEST, SettingsButton, 350, SpringLayout.WEST, operatorPanel);
		
		this.LicensePlateEnter = new JTextField(18);
		operatorPanel.add(LicensePlateEnter);
		layout.putConstraint(SpringLayout.NORTH, LicensePlateEnter, 230, SpringLayout.NORTH, mainlabel);
		layout.putConstraint(SpringLayout.WEST, LicensePlateEnter, 525, SpringLayout.WEST, operatorPanel);
		
		SetFixedButton = new JButton("Set to Fixed");
		SetFixedButton.setPreferredSize(new Dimension(200, 30));
		operatorPanel.add(SetFixedButton);
		
		layout.putConstraint(SpringLayout.NORTH, SetFixedButton, 260, SpringLayout.NORTH, mainlabel);
		layout.putConstraint(SpringLayout.WEST, SetFixedButton, 525, SpringLayout.WEST, operatorPanel);
		
		
		DoDriverAssignmentButton = new JButton("New Driver Assignment");
		DoDriverAssignmentButton.setPreferredSize(new Dimension(250, 30));
		operatorPanel.add(DoDriverAssignmentButton);
		
		layout.putConstraint(SpringLayout.NORTH, DoDriverAssignmentButton, 230, SpringLayout.NORTH, mainlabel);
		layout.putConstraint(SpringLayout.WEST, DoDriverAssignmentButton, 70, SpringLayout.WEST, operatorPanel);
		
		logoutButton = new JButton("Log-out");
		logoutButton.setPreferredSize(new Dimension(130, 28));
		operatorPanel.add(logoutButton);
		layout.putConstraint(SpringLayout.NORTH, logoutButton, 15, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, logoutButton, 15, SpringLayout.WEST, this);

		//set main panel size
		this.operatorPanel.setPreferredSize(new Dimension(500, 300));
		this.add(operatorPanel, OPERATOR_PANEL);
		
		//add Views and corresponding controllers
		this.driverassignmentPanel = new DoDriverAssignmentPanel();
		DoDriverAssignmentController driverassignmentController = new DoDriverAssignmentController(driverassignmentPanel,this); 
		this.driverassignmentPanel.setController(driverassignmentController);
		this.add(driverassignmentPanel,DRIVER_ASSIGNMENT_PANEL);
		
		this.settingsPanel = new SettingsPanel();
		SettingsController settingPanelController = new SettingsController(settingsPanel, this);
		this.settingsPanel.setController(settingPanelController);
		this.add(settingsPanel,SETTINGS_PANEL);
		
		this.deliveryplanPanel = new DeliveryPlanPanel();
		DeliveryPlanController deliveryplanController = new DeliveryPlanController(deliveryplanPanel, this);
		this.deliveryplanPanel.setController(deliveryplanController);
		this.add(deliveryplanPanel,DELIVERY_PLAN_PANEL);
		
		this.generatestatisticPanel = new GenerateStatisticPanel();
		GenerateStatisticController generatestatisticController = new GenerateStatisticController(generatestatisticPanel, this);
		this.generatestatisticPanel.setController(generatestatisticController);
		this.add(generatestatisticPanel,GENERATE_STATISTIC_PANEL);
		
		this.registerdriverPanel = new RegisterDriverPanel();
		RegisterDriverController registerdriverController = new RegisterDriverController(registerdriverPanel, this);
		this.registerdriverPanel.setController(registerdriverController);
		this.add(registerdriverPanel,REGISTER_DRIVER_PANEL);
		
	}
	
	public void showHomeOperatorPanel() {
		CardLayout ele = (CardLayout)(this.getLayout());
		ele.show(this, OPERATOR_PANEL);
	}
	
	public void showSettingsPanel() {
		CardLayout ele = (CardLayout)(this.getLayout());
		ele.show(this, SETTINGS_PANEL);
	}
	
	public void showDeliveryPlanPanel() {
		CardLayout ele = (CardLayout)(this.getLayout());
		ele.show(this, DELIVERY_PLAN_PANEL);
	}
	
	public void showGenerateStatisticPanel() {
		CardLayout ele = (CardLayout)(this.getLayout());
		ele.show(this, GENERATE_STATISTIC_PANEL);
	}
	
	public void showRegisterDriverPanel() {
		CardLayout ele = (CardLayout)(this.getLayout());
		ele.show(this, REGISTER_DRIVER_PANEL);
	}
	
	public void showDoDriverAssignmentPanel() {
		CardLayout ele = (CardLayout)(this.getLayout());
		ele.show(this, DRIVER_ASSIGNMENT_PANEL);
	}
	
	//Buttons getters
	public JButton getAddNewDriverButton() {
		return this.AddNewDriverButton;
	}

	public JButton getDoDriverAssignmentButton() {
		return this.DoDriverAssignmentButton;
	}

	public JButton getDeliveryPlanButton() {
		return this.DeliveryPlanButton;
	}

	public JButton getGenerateStatisticButton(){
		return this.GenerateStatisticButton;
	}

	public JButton getSettingsButton(){
		return this.SettingsButton;
	}
	
	public JButton getLogoutButton() {
		return this.logoutButton;
	}
	
	public JButton getSetToFixedButton() {
		return this.SetFixedButton;
	}
	
	//Field getters
	
	public String getLicensePlateEnter() {
		return this.LicensePlateEnter.getText();
	}
}