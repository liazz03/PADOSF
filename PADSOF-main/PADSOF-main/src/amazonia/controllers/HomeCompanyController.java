package amazonia.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazonia.application.Amazonia;
import amazonia.views.*;
import amazonia.window.*;

public class HomeCompanyController implements ActionListener {

	private HomeCompanyPanel panel;
	private MainWindow window;
	private Amazonia amazonia;

	public HomeCompanyController(HomeCompanyPanel panel, MainWindow main) {
		this.panel = panel;
		this.window = main;
		this.amazonia = Amazonia.getInstance();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.panel.getLogoutButton())) {
			this.amazonia.logout();
			this.window.showmainPanel();
		}else if(e.getSource().equals(this.panel.getEditButton())) {
			this.panel.showEditPanel();
		}else if(e.getSource().equals(this.panel.getAddOrderButton())) {
			this.panel.showAddOrderPanel();
		}else if(e.getSource().equals(this.panel.getNotifications())) {
			this.panel.getNotificationPanel().UpdateNotifications();
			this.panel.showNotificationsPanel();
		}
	}

}
