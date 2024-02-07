package amazonia.controllers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import amazonia.application.Amazonia;
import amazonia.users.Company;
import amazonia.users.Driver;
import amazonia.users.Operator;
import amazonia.views.*;
import amazonia.window.MainWindow;

public class LoginController implements ActionListener {
	
	private LoginPanel panel;
	private MainWindow window;
	private Amazonia amazonia;
	
	private JRadioButton operator, driver, company;
	private ButtonGroup group;
	
	public LoginController(LoginPanel panel, MainWindow window) {
		this.panel = panel;
		this.window = window;
		this.amazonia = Amazonia.getInstance();
	}
	
	public void actionPerformed(ActionEvent e) {
		//pulsa back
		if(e.getSource().equals(this.panel.getBackButton())) {
			this.window.showmainPanel();

		//pulsa login
		}else if(e.getSource().equals(this.panel.getLoginButton())) {
			//pulsa login con operator seleccionado o con driver seleccionado o con company seleccionado
			if(this.panel.getOperatorSel().isSelected()) {
				if(!Amazonia.getInstance().login(this.panel.getUsername(), this.panel.getPassword())) {
					JOptionPane.showMessageDialog(this.panel, "Incorrect username or password", "Error", JOptionPane.ERROR_MESSAGE);
				}else if(this.amazonia.getCurrentUser() instanceof Operator) {
					this.window.ShowHomeOperator();
				}else{
					JOptionPane.showMessageDialog(this.panel, "Incorrect username or password", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

			else if(this.panel.getDriverSel().isSelected()){
				if(!Amazonia.getInstance().login(this.panel.getUsername(), this.panel.getPassword())) {
					JOptionPane.showMessageDialog(this.panel, "Incorrect username or password", "Error", JOptionPane.ERROR_MESSAGE);
					
				}else if(this.amazonia.getCurrentUser() instanceof Driver){
					this.window.ShowHomeDriver();
				}else {
					JOptionPane.showMessageDialog(this.panel, "Incorrect username or password", "Error", JOptionPane.ERROR_MESSAGE);
				}	
			}

			else if(this.panel.getCompanySel().isSelected()) {
				if(!Amazonia.getInstance().login(this.panel.getUsername(), this.panel.getPassword())) {
					JOptionPane.showMessageDialog(this.panel, "Incorrect username or password", "Error", JOptionPane.ERROR_MESSAGE);
				}else if (this.amazonia.getCurrentUser() instanceof Company) {
					this.window.ShowHomeCompany();
				}else{
					JOptionPane.showMessageDialog(this.panel, "Incorrect username or password", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}	
			//pulsa login sin ningun radio button seleccionado
			}else if(!(this.panel.getOperatorSel().isSelected() || this.panel.getDriverSel().isSelected() || this.panel.getCompanySel().isSelected())) {
				JOptionPane.showMessageDialog(this.panel, "You have to choose one the three possible users");
			}
		}
}

