package amazonia.views;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import amazonia.application.Amazonia;
import amazonia.controllers.LoginController;
import amazonia.controllers.NotificationController;
import amazonia.packages.Notification;
import amazonia.users.Company;

public class NotificationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private NotificationController controller;
	private JTable table;
	SpringLayout layout;

	private JButton back;
	
	public void SetController(NotificationController controller) {
		this.controller = controller;
		this.back.addActionListener(controller);
	}
	
	public NotificationPanel() {
		
		//set layout
		this.layout = new SpringLayout();		
		this.setLayout(layout);
		
		JLabel title = new JLabel("Notifications");
		this.add(title);
		title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, this);
		
		//Button 
		this.back = new JButton("Back");
		this.add(back);
        back.setPreferredSize(new Dimension(130, 28));
		layout.putConstraint(SpringLayout.NORTH, back, 15, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, back, 15, SpringLayout.WEST, this);
		
		//JLabels
		JLabel OrderIDLabel = new JLabel("Order ID");
		this.add(OrderIDLabel);
		layout.putConstraint(SpringLayout.NORTH, OrderIDLabel, 100, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, OrderIDLabel, 100, SpringLayout.WEST, this);
		
		JLabel Line = new JLabel("----------------------------------------------------------------------------------------------------------------------------------------------");
		this.add(Line);
		layout.putConstraint(SpringLayout.NORTH, Line, 120, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, Line, 100, SpringLayout.WEST, this);
		
		JLabel NotificationLabel = new JLabel("Notification");
		this.add(NotificationLabel);
		layout.putConstraint(SpringLayout.NORTH, NotificationLabel, 100, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, NotificationLabel, 450, SpringLayout.WEST, this);
		
	}
	
	//Update Notifications
	public void UpdateNotifications() {
		Amazonia amazonia = Amazonia.getInstance();
		Company company = (Company) amazonia.getCurrentUser();
		 List<JLabel> notifications = new ArrayList<>();
		for(Notification notif : company.getNotifications()) {
			String aux = notif.getOrder().getId() +"                                                               "+ notif.getText();
			notifications.add(new JLabel(aux));
		}

		int margin =140;
		for(JLabel label : notifications){
			this.add(label);
			layout.putConstraint(SpringLayout.NORTH, label, margin, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.WEST, label, 100, SpringLayout.WEST, this);
			margin +=40;
		}
	}
	
	//Button Getters
	public JButton getBackButton() {
		return this.back;
	}
	
	
	
	
	
}
