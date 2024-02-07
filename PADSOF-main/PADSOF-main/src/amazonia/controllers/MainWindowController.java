package amazonia.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import amazonia.window.MainWindow;

public class MainWindowController implements ActionListener {
	
	private MainWindow main;
	
	public MainWindowController(MainWindow window) {
		this.main = window;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.main.getLoginButton())) {
			this.main.ShowLogin();
		}else {
			this.main.ShowRegister();
		}
		
	}

}
