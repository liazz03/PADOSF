package amazonia.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import amazonia.application.Amazonia;
import amazonia.views.*;

public class NotificationController implements ActionListener {
	
	private HomeCompanyPanel window;
	private NotificationPanel panel;
	
	public NotificationController(NotificationPanel panel, HomeCompanyPanel window) {
		this.panel = panel;
		this.window = window;
	}
	
    @Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.panel.getBackButton())) {
			this.window.showHomeCompanyPanel();
		}
	}
    
}

