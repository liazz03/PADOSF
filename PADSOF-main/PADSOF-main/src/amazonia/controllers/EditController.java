package amazonia.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import amazonia.application.Amazonia;
import amazonia.views.*;
import amazonia.users.*;

public class EditController implements ActionListener {

	private EditPanel panel;
	private HomeCompanyPanel window;
	private Amazonia amazonia;

	public EditController(EditPanel panel, HomeCompanyPanel window) {
		this.panel = panel;
		this.window = window;
		this.amazonia = Amazonia.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.panel.getBackButton())) {
			this.window.showHomeCompanyPanel();
		}else if(e.getSource().equals(this.panel.getSaveButton())) {
			if(!this.panel.getNewPassword().equals("")) amazonia.getCurrentUser().setPassword(this.panel.getNewPassword());
			if(!this.panel.getName().equals("")) amazonia.getCurrentUser().setName(this.panel.getName());
			if(!this.panel.getCardNumber().equals("")) {
				Company comp = (Company) amazonia.getCurrentUser();
				comp.setCardNumber(this.panel.getCardNumber());
			}
			if(!this.panel.getEmail().equals("")){
				Company comp = (Company) amazonia.getCurrentUser();
				comp.setCardNumber(this.panel.getEmail());
			}
			if(!this.panel.getAdress().equals("")){
				Company comp = (Company) amazonia.getCurrentUser();
				comp.setAddress(this.panel.getAdress());
			}
			if(!this.panel.getZipCode().equals("")){
				Company comp = (Company) amazonia.getCurrentUser();
				if(!comp.setPostalCode(Integer.parseInt(this.panel.getZipCode()))){
					JOptionPane.showMessageDialog(this.panel, "Invalid Zip Code! Zip code not changed!", "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
			JOptionPane.showMessageDialog(this.panel, "Changes made successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
			this.window.showHomeCompanyPanel();
		}
		
	}

}
