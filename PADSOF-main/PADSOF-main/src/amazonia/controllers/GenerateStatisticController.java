package amazonia.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Month;

import javax.swing.JOptionPane;

import amazonia.application.Amazonia;
import amazonia.views.GenerateStatisticPanel;
import amazonia.views.HomeOperatorPanel;

public class GenerateStatisticController implements ActionListener{
	
	private GenerateStatisticPanel panel;
	private HomeOperatorPanel window;
	private Amazonia amazonia;
	
	public GenerateStatisticController(GenerateStatisticPanel panel, HomeOperatorPanel window) {
		this.panel=panel;
		this.window=window;
		this.amazonia=Amazonia.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource().equals(this.panel.getbackButton())){
			this.window.showHomeOperatorPanel();
		}else if(e.getSource().equals(this.panel.getcalculateStatsButton())){
			if(this.panel.getStatsComboBox().getSelectedItem().equals("Select an option")){
				JOptionPane.showMessageDialog(this.panel, "You must Select an option!", "Error",
						JOptionPane.ERROR_MESSAGE);
			}else if(this.panel.getStatsComboBox().getSelectedItem().equals("Income per month")){
				JOptionPane.showMessageDialog(this.panel, this.panel.getStatsComboBox().getSelectedItem().toString() + " (" 
				+ this.panel.getMonthsComboBox().getSelectedItem().toString() + "): " 
				+ amazonia.getOperator().getIncomePerMonth((Month) this.panel.getMonthsComboBox().getSelectedItem()));
			}else if(this.panel.getStatsComboBox().getSelectedItem().equals("Average Income per Order per month")){
				JOptionPane.showMessageDialog(this.panel, this.panel.getStatsComboBox().getSelectedItem().toString() + " (" 
				+ this.panel.getMonthsComboBox().getSelectedItem().toString() + "): " 
				+ amazonia.getOperator().getAvgIncomePerOrderPerMonth((Month) this.panel.getMonthsComboBox().getSelectedItem()));
			}else if(this.panel.getStatsComboBox().getSelectedItem().equals("Orders per month")){
				JOptionPane.showMessageDialog(this.panel, this.panel.getStatsComboBox().getSelectedItem().toString() + " (" 
				+ this.panel.getMonthsComboBox().getSelectedItem().toString() + "): " 
				+ amazonia.getOperator().getOrdersPerMonth((Month) this.panel.getMonthsComboBox().getSelectedItem()));
			}else if(this.panel.getStatsComboBox().getSelectedItem().equals("Number of packages per month")){
				JOptionPane.showMessageDialog(this.panel, this.panel.getStatsComboBox().getSelectedItem().toString() + " (" 
				+ this.panel.getMonthsComboBox().getSelectedItem().toString() + "): " 
				+ amazonia.getOperator().getNumPackagesPerMonth((Month) this.panel.getMonthsComboBox().getSelectedItem()));
			}else if(this.panel.getStatsComboBox().getSelectedItem().equals("Number of packages delivered per month")){
				JOptionPane.showMessageDialog(this.panel, this.panel.getStatsComboBox().getSelectedItem().toString() + " (" 
				+ this.panel.getMonthsComboBox().getSelectedItem().toString() + "): " 
				+ amazonia.getOperator().getNumPackagesDelivered((Month) this.panel.getMonthsComboBox().getSelectedItem()));
			}else if(this.panel.getStatsComboBox().getSelectedItem().equals("Number of packages non delivered per month")){
				JOptionPane.showMessageDialog(this.panel, this.panel.getStatsComboBox().getSelectedItem().toString() + " (" 
				+ this.panel.getMonthsComboBox().getSelectedItem().toString() + "): " 
				+ amazonia.getOperator().getNumPackagesNonDelivered((Month) this.panel.getMonthsComboBox().getSelectedItem()));
			}
		}
		
	}
}
