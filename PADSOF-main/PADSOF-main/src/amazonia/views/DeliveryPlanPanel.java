package amazonia.views;

import javax.swing.*;
import java.awt.*;
import amazonia.controllers.*;

public class DeliveryPlanPanel extends JPanel {
	
	private DeliveryPlanController controller;
	private static final long serialVersionUID = 1L;
	private JButton back;
	private JButton confirm;

	public void setController(DeliveryPlanController controller) {
		this.controller = controller;
		this.back.addActionListener(controller);
		this.confirm.addActionListener(controller);
	}

	public DeliveryPlanPanel() {

		String[] columnNames = {"Drivers", "Trucks", "Dates"};

		Object[][] data = {
			{"Driver 1", "Truck 1", "Monday 9 AM"},
			{"Driver 2", "Truck 2", "Monday 10 AM"},
			{"Driver 3", "Truck 3", "Monday 1 PM"},
			{"Driver 4", "Truck 4", "Monday 5 PM"}
		};

		SpringLayout layout = new SpringLayout();
        this.setLayout(layout);

		JLabel title = new JLabel("Where are we going?");
    	this.add(title);
    	title.setFont(new Font("Arial", Font.BOLD, 25));
    	layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, this);

		JTable table = new JTable(data, columnNames);
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getRowHeight(50);
		table.setSelectionBackground(Color.CYAN);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		layout.putConstraint(SpringLayout.NORTH, table, 130, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, table, 100, SpringLayout.WEST, this);
		this.add(table);

		this.back = new JButton("Back");
        back.setPreferredSize(new Dimension(130, 28));
        this.add(back);
		layout.putConstraint(SpringLayout.NORTH, back, 15, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, back, 15, SpringLayout.WEST, this);
        
    	this.confirm = new JButton("Confirm routes");
        this.add(confirm);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, confirm, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, confirm, 340, SpringLayout.NORTH, this);
		this.confirm.setBackground(Color.YELLOW);
	}


	public JButton getBackButton() {
		return this.back;
	}

	public JButton getConfirmButton() {
		return this.confirm;
	}
}
