package amazonia.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import amazonia.application.Amazonia;
import amazonia.views.HomeOperatorPanel;
import amazonia.views.RegisterDriverPanel;


public class RegisterDriverController implements ActionListener {

	private RegisterDriverPanel panel;
	private HomeOperatorPanel window;
	private Amazonia amazonia;
	
	public RegisterDriverController(RegisterDriverPanel panel, HomeOperatorPanel window) {
		this.panel = panel;
		this.window = window;
		this.amazonia = Amazonia.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(this.panel.getcancell())) {
			this.window.showHomeOperatorPanel();
		}else if(e.getSource().equals(this.panel.getadd())) {
			if(this.panel.getusername().equals("") || this.panel.getpassword().equals("") || this.panel.getphonenumber().equals("")) {
				JOptionPane.showMessageDialog(this.panel, "You must fill all fields!", "Error",
						JOptionPane.ERROR_MESSAGE);
			}else if (amazonia.registerDriver(this.panel.getusername(), this.panel.getpassword(), Long.parseLong(this.panel.getphonenumber()))==false){
				JOptionPane.showMessageDialog(this.panel, "Error registering Driver", "Error",
						JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(this.panel,"Driver was registered Successfully","DRIVER REGISTRATION", JOptionPane.INFORMATION_MESSAGE);
				this.window.showHomeOperatorPanel();
			}
		}
	
	}

}
