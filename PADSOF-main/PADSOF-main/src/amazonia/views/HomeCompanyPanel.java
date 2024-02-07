
package amazonia.views;

import java.awt.*;
import javax.swing.*;
import amazonia.controllers.*;

public class HomeCompanyPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private HomeCompanyController controller;
	private JPanel companyPanel;
	private JLabel mainLabel;
	
	//tiene 4 botones esta pantalla + logout
	private JButton editButton;
	private JButton invoicesButton;
	private JButton notificationsButton;
	private JButton addOrderButton;
	private JButton logoutButton;

	private EditPanel editPanel;
	private AddOrderPanel addOrderPanel;
	private NotificationPanel notificationPanel;

	final static String COMPANY_PANEL = "COMPANY PANEL";
	final static String EDIT_PANEL = "EDIT INFORMATION PANEL";
	final static String NOTIFICATIONS_PANEL = "NOTIFICATIONS PANEL";
	final static String ADD_ORDER_PANEL = "ADD ORDER PANEL";
	
	public void setController(HomeCompanyController controller) {
		this.controller = controller;
		this.editButton.addActionListener(controller);
		this.invoicesButton.addActionListener(controller);
		this.notificationsButton.addActionListener(controller);
		this.addOrderButton.addActionListener(controller);
		this.logoutButton.addActionListener(controller);
	}
	
	public HomeCompanyPanel() {
		
		CardLayout card_layout = new CardLayout();
		this.setLayout(card_layout);
		
		//create Spring layout that contains elements
		this.companyPanel = new JPanel();
		SpringLayout layout = new SpringLayout();		
		this.companyPanel.setLayout(layout);
		
		this.mainLabel = new JLabel("Home Company");
		this.mainLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		this.companyPanel.add(mainLabel);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, mainLabel, 0, SpringLayout.HORIZONTAL_CENTER, companyPanel);
		layout.putConstraint(SpringLayout.NORTH, mainLabel, 10, SpringLayout.NORTH, companyPanel);
		
		//Edit personal information
		editButton = new JButton("Edit personal information");
		editButton.setPreferredSize(new Dimension(225, 30));
		companyPanel.add(editButton);
		
		layout.putConstraint(SpringLayout.NORTH, editButton, 130, SpringLayout.NORTH, mainLabel);
		layout.putConstraint(SpringLayout.WEST, editButton, 150, SpringLayout.WEST, companyPanel);
		
		//Add order
		addOrderButton = new JButton("Add order");
		addOrderButton.setPreferredSize(new Dimension(225, 30));
		companyPanel.add(addOrderButton);
		
		layout.putConstraint(SpringLayout.NORTH, addOrderButton, 130, SpringLayout.NORTH, mainLabel);
		layout.putConstraint(SpringLayout.WEST, addOrderButton, 450, SpringLayout.WEST, companyPanel);
		
		//Notifications
		notificationsButton = new JButton("Notifications");
		notificationsButton.setPreferredSize(new Dimension(225, 30));
		companyPanel.add(notificationsButton);
		
		layout.putConstraint(SpringLayout.NORTH, notificationsButton, 200, SpringLayout.NORTH, mainLabel);
		layout.putConstraint(SpringLayout.WEST, notificationsButton, 150, SpringLayout.WEST, companyPanel);
		
		//Invoices
		invoicesButton = new JButton("Invoices");
		invoicesButton.setPreferredSize(new Dimension(225, 30));
		companyPanel.add(invoicesButton);
		
		layout.putConstraint(SpringLayout.NORTH, invoicesButton, 200, SpringLayout.NORTH, mainLabel);
		layout.putConstraint(SpringLayout.WEST, invoicesButton, 450, SpringLayout.WEST, companyPanel);
		
		
		//Logout
		logoutButton = new JButton("Log-out");
		logoutButton.setPreferredSize(new Dimension(130, 28));
		companyPanel.add(logoutButton);
		layout.putConstraint(SpringLayout.NORTH, logoutButton, 15, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, logoutButton, 15, SpringLayout.WEST, this);
		
		//Set main panel size
		this.companyPanel.setPreferredSize(new Dimension(500, 300));
		this.add(companyPanel, COMPANY_PANEL);
		
		//Add views and corresponding controllers
		this.editPanel = new EditPanel();
		EditController editController = new EditController(editPanel, this);
		this.editPanel.setController(editController);
		this.add(editPanel, EDIT_PANEL);

		this.addOrderPanel = new AddOrderPanel();
		AddOrderController addOrderController = new AddOrderController(addOrderPanel, this);
		this.addOrderPanel.setController(addOrderController);
		this.add(addOrderPanel, ADD_ORDER_PANEL);

		
		this.notificationPanel = new NotificationPanel();
		NotificationController notificationController = new NotificationController(notificationPanel, this);
		this.notificationPanel.SetController(notificationController);
		this.add(notificationPanel, NOTIFICATIONS_PANEL);
		
	}
	
	
	public void showHomeCompanyPanel() {
		CardLayout ele = (CardLayout)(this.getLayout());
		ele.show(this, COMPANY_PANEL);
	}

	public void showAddOrderPanel() {
		CardLayout ele = (CardLayout)(this.getLayout());
		ele.show(this, ADD_ORDER_PANEL);
	}

	public void showNotificationsPanel() {
		CardLayout ele = (CardLayout)(this.getLayout());
		ele.show(this, NOTIFICATIONS_PANEL);
	}
	
	public void showEditPanel() {
		CardLayout ele = (CardLayout)(this.getLayout());
		ele.show(this, EDIT_PANEL);
	}
	
	//Getter
	public JButton getLogoutButton() {
		return this.logoutButton;
	}
	
	public JButton getEditButton() {
		return this.editButton;
	}

	public JButton getAddOrderButton() {
		return this.addOrderButton;
	}
	
	public JButton getInvoices() {
		return this.invoicesButton;
	}
	
	public JButton getNotifications() {
		return this.notificationsButton;
	}
	
	//Panel getters
	public NotificationPanel getNotificationPanel() {
		return this.notificationPanel;
	}
	
	
}