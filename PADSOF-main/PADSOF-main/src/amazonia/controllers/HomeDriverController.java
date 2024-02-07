package amazonia.controllers;

import java.awt.event.*;

import javax.swing.JOptionPane;

import amazonia.application.Amazonia;
import amazonia.trucks.Truck;
import amazonia.views.*;
import amazonia.window.*;

public class HomeDriverController implements ActionListener{

	private HomeDriverPanel panel;
	private MainWindow window;
	private Amazonia amazonia;

	public HomeDriverController(HomeDriverPanel panel, MainWindow main) {
		this.panel = panel;
		this.window = main;
		this.amazonia = Amazonia.getInstance();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.panel.getLogoutButton())) {
			amazonia.logout();
			this.window.showmainPanel();
		}else if (e.getSource().equals(this.panel.getSetBrokenButton())) {
			
			if(this.panel.getBrokenTruckField().equals("")) {
				JOptionPane.showMessageDialog(this.panel, "You must enter a valid License Plate!", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				boolean flag = false;
				for(Truck t : this.amazonia.getTrucks()) {
					if(t.getLicensePlate().equals(this.panel.getBrokenTruckField())) {
						t.setBroken(true);
						flag = true;
						JOptionPane.showMessageDialog(this.panel, "Truck Set to Broken", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
				if(!flag) {
					JOptionPane.showMessageDialog(this.panel, "You must enter a valid License Plate!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}else if(e.getSource().equals(this.panel.getEditStateofDeliveryButton())){
			if(this.panel.getOrderid().equals("")) {
				JOptionPane.showMessageDialog(this.panel, "You must enter a valid Order ID!", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				if(this.panel.getDeliveredStatus().getSelectedIndex()==0) {
					if(!amazonia.getInstance().setDelivered(Long.parseLong(this.panel.getOrderid()))) {
						JOptionPane.showMessageDialog(this.panel, "Order ID could not be identified", "Error", JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(this.panel, "Order " + this.panel.getOrderid() + " set delivered", "Success", JOptionPane.INFORMATION_MESSAGE);
					}
				}else {
					if(!amazonia.getInstance().setNotDelivered(Long.parseLong(this.panel.getOrderid()))) {
						JOptionPane.showMessageDialog(this.panel, "Order ID could not be identified", "Error", JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(this.panel, "Order " + this.panel.getOrderid() + " set Non Delivered", "Success", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		}

	}
}
