package amazonia.controllers;

import java.awt.event.*;

import javax.swing.JOptionPane;

import amazonia.application.Amazonia;
import amazonia.trucks.Truck;
import amazonia.views.*;
import amazonia.window.*;

public class HomeOperatorController implements ActionListener {

	private HomeOperatorPanel panel;
	private MainWindow window;
	private Amazonia amazonia;
	
	public HomeOperatorController(HomeOperatorPanel panel, MainWindow main) {
		this.panel = panel;
		this.window = main;
		this.amazonia = Amazonia.getInstance();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(this.panel.getAddNewDriverButton())) {
			this.panel.showRegisterDriverPanel();
		}else if(e.getSource().equals(this.panel.getDeliveryPlanButton())) {
			this.panel.showDeliveryPlanPanel();
		}else if(e.getSource().equals(this.panel.getDoDriverAssignmentButton())){
			this.panel.showDoDriverAssignmentPanel();
		}else if(e.getSource().equals(this.panel.getGenerateStatisticButton())){
			this.panel.showGenerateStatisticPanel();
		}else if (e.getSource().equals(this.panel.getSettingsButton())){
			this.panel.showSettingsPanel();
		}else if(e.getSource().equals(this.panel.getLogoutButton())) {
			amazonia.logout();
			this.window.showmainPanel();
		}else if(e.getSource().equals(this.panel.getSetToFixedButton())) {
			if(this.panel.getLicensePlateEnter().equals("")) {
				JOptionPane.showMessageDialog(this.panel, "You must enter a valid License Plate!", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				boolean flag = false;
				for(Truck t : this.amazonia.getTrucks()) {
					if(t.getLicensePlate().equals(this.panel.getLicensePlateEnter())) {
						t.setBroken(false);
						flag = true;
						JOptionPane.showMessageDialog(this.panel, "Truck Set to Fixed", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
				if(!flag) {
					JOptionPane.showMessageDialog(this.panel, "You must enter a valid License Plate!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
	}

}
