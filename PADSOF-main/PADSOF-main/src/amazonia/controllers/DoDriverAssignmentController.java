package amazonia.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import amazonia.application.Amazonia;
import amazonia.views.DoDriverAssignmentPanel;
import amazonia.views.HomeOperatorPanel;

public class DoDriverAssignmentController implements ActionListener {
	
	private DoDriverAssignmentPanel panel;
	private HomeOperatorPanel window;
	private Amazonia amazonia;
	
	public DoDriverAssignmentController(DoDriverAssignmentPanel panel, HomeOperatorPanel window) {
		this.panel=panel;
		this.window=window;
		this.amazonia=Amazonia.getInstance();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.panel.getAddButton())) {
			if(this.panel.getNameofDriver().equals("") || this.panel.getLicensePlate().equals("")) {
				JOptionPane.showMessageDialog(this.panel, "You must fill all fields!", "Error",
						JOptionPane.ERROR_MESSAGE);
			}else if(!amazonia.addDriverAssignment(this.panel.getNameofDriver(), this.panel.getLicensePlate())) {
				JOptionPane.showMessageDialog(this.panel, "Error doing driver Assignment", "Error",
						JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(this.panel,"Driver Assignment was done successfully","DRIVER REGISTRATION", JOptionPane.INFORMATION_MESSAGE);
				this.window.showHomeOperatorPanel();
			}
		}else {
			this.window.showHomeOperatorPanel();
		}
		
	}

}
