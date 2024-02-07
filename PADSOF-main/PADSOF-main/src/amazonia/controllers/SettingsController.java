package amazonia.controllers;

import amazonia.application.Amazonia;
import amazonia.users.Operator;
import amazonia.views.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class SettingsController implements ActionListener {
    
	private SettingsPanel panel;
	private HomeOperatorPanel window;
	private Amazonia amazonia;
	
	public SettingsController(SettingsPanel panel,HomeOperatorPanel window) {
		this.panel = panel;
		this.window = window;
		this.amazonia= Amazonia.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean flag=false;
		
		if(e.getSource().equals(this.panel.getBackButton())){
			this.window.showHomeOperatorPanel();
		}else if(e.getSource().equals(this.panel.getapply())) {
			
			//Normal Fields
			if(!this.panel.getretriesField().equals("")) {
				Operator.OPprice.setReattempts(Integer.parseInt(this.panel.getretriesField()));
				flag=true;
			}
			
			if(!this.panel.getpercentageField().equals("")) {
				Operator.OPprice.setDiscount(Double.parseDouble(this.panel.getpercentageField()));
				flag=true;
			}
			
			if(!this.panel.getTransportInsurannceField().equals("")) {
				Operator.OPprice.setTransportInsurance(Double.parseDouble(this.panel.getTransportInsurannceField()));
				flag=true;
			}
			
			if(!this.panel.getUrgentPriceField().equals("")) {
				Operator.OPprice.setUrgent(Double.parseDouble(this.panel.getUrgentPriceField()));
				flag=true;
			}
			
			//Combo Boxes
			if(!this.panel.getPriceByTypeField().equals("")) {
				if(this.panel.getPriceByTypeCB().getSelectedIndex()==0) {
					Operator.OPprice.setStandard_1(Double.parseDouble(this.panel.getPriceByTypeField()));
				}else if(this.panel.getPriceByTypeCB().getSelectedIndex()==1) {
					Operator.OPprice.setStandard_1_5(Double.parseDouble(this.panel.getPriceByTypeField()));
				}else if(this.panel.getPriceByTypeCB().getSelectedIndex()==2) {
					Operator.OPprice.setStandard_5(Double.parseDouble(this.panel.getPriceByTypeField()));
				}else if(this.panel.getPriceByTypeCB().getSelectedIndex()==3) {
					Operator.OPprice.setFrozen(Double.parseDouble(this.panel.getPriceByTypeField()));
				}else if(this.panel.getPriceByTypeCB().getSelectedIndex()==4) {
					Operator.OPprice.setRefrigerated(Double.parseDouble(this.panel.getPriceByTypeField()));
				}
				flag=true;
			}
			
			if(!this.panel.getMaxWeightByProductField().equals("")) {
				if(this.panel.getMaxWeightByProductCB().getSelectedIndex()==0) {
					Operator.OPprice.setMaxWeightFragile(Double.parseDouble(this.panel.getMaxWeightByProductField()));
				}else if(this.panel.getMaxWeightByProductCB().getSelectedIndex()==1) {
					Operator.OPprice.setMaxWeightFood(Double.parseDouble(this.panel.getMaxWeightByProductField()));
				}else if(this.panel.getMaxWeightByProductCB().getSelectedIndex()==2) {
					Operator.OPprice.setMaxWeightStandard(Double.parseDouble(this.panel.getMaxWeightByProductField()));
				}
				flag=true;
			}
			
			if(flag) {
				JOptionPane.showMessageDialog(this.panel, "Changes applied");
				System.out.println(Operator.OPprice);
			}else {
				JOptionPane.showMessageDialog(this.panel, "No changes were applied", "Warning",
						JOptionPane.WARNING_MESSAGE);
			}
				
		}
	}
	
}
