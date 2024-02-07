package amazonia.controllers;

import javax.swing.*;

import amazonia.application.Amazonia;
import amazonia.views.RegisterPanel;
import amazonia.window.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RegisterController implements ActionListener {
	
	private RegisterPanel panel;
	private MainWindow window;
	private Amazonia amazonia;
    
    public RegisterController(RegisterPanel panel, MainWindow window) {
    	this.panel = panel;
    	this.window = window;
    	this.amazonia = Amazonia.getInstance();
    }

        //ImageIcon image = new ImageIcon("fondo.png");
        //frame.setIconImage(image.getImage());
        //frame.getContentPane().setBackground(new Color(255, 51, 51));
    
    @Override
    public void actionPerformed(ActionEvent e)  {
    	if(e.getSource().equals(this.panel.getBackButton())) {
    		this.window.showmainPanel();
    	}
    	else if(e.getSource().equals(this.panel.getSignUpButton())) {
    		if(this.panel.getName().equals("") || this.panel.getCode().equals("") || this.panel.getEmail().equals("") || 
    				this.panel.getEmail().equals("")|| this.panel.getcardNumber().equals("") || this.panel.getPassword().equals("")) {
    			JOptionPane.showMessageDialog(this.panel, "You must fill all fields!", "Error",
						JOptionPane.ERROR_MESSAGE);
    		}else {
    			try {
    				if(!this.amazonia.registerCompany(this.panel.getName(),this.panel.getPassword(), this.panel.getcardNumber(),
        					Long.parseLong(this.panel.getCode()), this.panel.getEmail(), this.panel.getBilling(), Integer.parseInt(this.panel.getZipCode()))){
    					JOptionPane.showMessageDialog(this.panel, "Error Registering", "Error",
    							JOptionPane.ERROR_MESSAGE);
        			}else {
						JOptionPane.showMessageDialog(this.panel, "You are now registered in the application");
        				this.window.showmainPanel();
        			}
    			}catch (FileNotFoundException e1) {
    				e1.printStackTrace();
    			} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
    			
    		}
    	}
    }
}
