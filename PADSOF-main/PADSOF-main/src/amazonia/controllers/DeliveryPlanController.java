package amazonia.controllers;

import amazonia.views.*;
import java.awt.event.*;

import javax.swing.JOptionPane;


public class DeliveryPlanController implements ActionListener {

	private DeliveryPlanPanel panel;
	private HomeOperatorPanel window;
	
	public DeliveryPlanController(DeliveryPlanPanel panel, HomeOperatorPanel window) {
		this.panel = panel;
		this.window = window;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.panel.getBackButton())) {
			this.window.showHomeOperatorPanel();
		}
		else if(e.getSource().equals(this.panel.getConfirmButton())) {
			JOptionPane.showMessageDialog(this.panel, "You have confirmed the routes for the delivery plan");
		}
		
	}
}
