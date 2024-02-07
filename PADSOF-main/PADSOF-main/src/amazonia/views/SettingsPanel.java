package amazonia.views;

import javax.swing.*;
import amazonia.controllers.SettingsController;
import java.awt.*;

public class SettingsPanel extends JPanel {
    
	private SettingsController controller;
	private static final long serialVersionUID = 1L;

    private JLabel title;
    private JButton apply,back;
    private JComboBox<String> PriceByTypeCB, MaxWeightByProductCB;
    private JTextField TransportInsurannceField,retriesField,percentageField,UrgentPriceField, PriceByTypeField, MaxWeightByProductField;
  
    final static String[] PriceByType = {"Standard 0-1 Price", "Standard 1-5 Price", "Standard > 5 Price", "Frozen Price",
    		"Refrigerated"};
    final static String[] MaxWeightByProduct = {"Max Weight Fragile","Max Weight Food","Max Weight Standard"};
	
	public void setController(SettingsController controller) {
		this.controller = controller;
        this.apply.addActionListener(controller);
        this.back.addActionListener(controller);
	}

    public SettingsPanel() {
        
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);

        this.title = new JLabel("SETTINGS");
        title.setFont(new Font("Times New Roman", Font.BOLD, 20));
        this.add(title);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, -20, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, this);
        
        JLabel retriesLabel = new JLabel("Maximum number of retries:");
        retriesField = new JTextField(10);
        this.add(retriesLabel);
        layout.putConstraint(SpringLayout.NORTH, retriesLabel, 100, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, retriesLabel, 40, SpringLayout.WEST, this);

        this.add(retriesField);
        layout.putConstraint(SpringLayout.NORTH, retriesField, 100, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, retriesField, 500, SpringLayout.WEST, this);

        JLabel percentageLabel = new JLabel("Discount percentage applied to orders");
        JLabel percentageLabel2 = new JLabel("with more than 100 products:");
        percentageField = new JTextField(10);
        this.add(percentageLabel);
        this.add(percentageLabel2);
        layout.putConstraint(SpringLayout.NORTH, percentageLabel, 130, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, percentageLabel, 40, SpringLayout.WEST, this);

        //same label in different line
        layout.putConstraint(SpringLayout.NORTH, percentageLabel2, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, percentageLabel2, 40, SpringLayout.WEST, this);

        this.add(percentageField);
        layout.putConstraint(SpringLayout.NORTH, percentageField, 140, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, percentageField, 500, SpringLayout.WEST, this);
		
		//Transport Insurance
		 JLabel TransportInsuranceLabel = new JLabel("Transport Insurance Price:");
	     TransportInsurannceField = new JTextField(10);
	     this.add(TransportInsuranceLabel);
	     layout.putConstraint(SpringLayout.NORTH, TransportInsuranceLabel, 170, SpringLayout.NORTH, this);
		 layout.putConstraint(SpringLayout.WEST, TransportInsuranceLabel, 40, SpringLayout.WEST, this);

	     this.add(TransportInsurannceField);
	     layout.putConstraint(SpringLayout.NORTH, TransportInsurannceField, 170, SpringLayout.NORTH, this);
		 layout.putConstraint(SpringLayout.WEST, TransportInsurannceField, 500, SpringLayout.WEST, this);
		
		//Urgent Price 
		 JLabel UgentPriceLabel = new JLabel("Urgent Order Price:");
		 UrgentPriceField = new JTextField(10);
		 this.add(UgentPriceLabel);
		 layout.putConstraint(SpringLayout.NORTH, UgentPriceLabel, 200, SpringLayout.NORTH, this);
		 layout.putConstraint(SpringLayout.WEST, UgentPriceLabel, 40, SpringLayout.WEST, this);
		 
		 this.add(UrgentPriceField);
	     layout.putConstraint(SpringLayout.NORTH, UrgentPriceField, 200, SpringLayout.NORTH, this);
		 layout.putConstraint(SpringLayout.WEST, UrgentPriceField, 500, SpringLayout.WEST, this);
		 
		//Prices x Type Combo Box
		 this.PriceByTypeCB = new JComboBox<String>(PriceByType);
		 this.PriceByTypeCB.setSelectedIndex(0);
		 this.add(PriceByTypeCB);
		 layout.putConstraint(SpringLayout.NORTH, PriceByTypeCB, 240, SpringLayout.NORTH, this);
		 layout.putConstraint(SpringLayout.WEST, PriceByTypeCB, 40, SpringLayout.WEST, this);
		 
		 this.PriceByTypeField = new JTextField(10);
		 this.add(PriceByTypeField);
		 layout.putConstraint(SpringLayout.NORTH, PriceByTypeField, 240, SpringLayout.NORTH, this);
		 layout.putConstraint(SpringLayout.WEST, PriceByTypeField, 500, SpringLayout.WEST, this);
		 
		//Max Weight x type Combo Box
		 this.MaxWeightByProductCB = new JComboBox<String>(MaxWeightByProduct);
		 this.MaxWeightByProductCB.setSelectedIndex(0);
		 this.add(MaxWeightByProductCB);
		 layout.putConstraint(SpringLayout.NORTH, MaxWeightByProductCB, 290, SpringLayout.NORTH, this);
		 layout.putConstraint(SpringLayout.WEST, MaxWeightByProductCB, 40, SpringLayout.WEST, this);
		 
		 this.MaxWeightByProductField = new JTextField(10);
		 this.add(MaxWeightByProductField);
		 layout.putConstraint(SpringLayout.NORTH, MaxWeightByProductField, 290, SpringLayout.NORTH, this);
		 layout.putConstraint(SpringLayout.WEST, MaxWeightByProductField, 500, SpringLayout.WEST, this);
		 
        // Buttons
        this.apply = new JButton("Apply and save");
        apply.setPreferredSize(new Dimension(150, 28));
        this.add(apply);
        layout.putConstraint(SpringLayout.NORTH, apply, 350, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, apply, 300, SpringLayout.WEST, this);

        this.back = new JButton("Back");
        back.setPreferredSize(new Dimension(130, 28));
        this.add(back);
        layout.putConstraint(SpringLayout.NORTH, back, 15, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, back, 15, SpringLayout.WEST, this);

        this.apply.setBackground(Color.green);
    }

    //buttons getters
    public JButton getapply() {
        return this.apply;
    }

    public JButton getBackButton(){
        return this.back;
    }
    
    //Combo Box getters 
    public JComboBox<String> getPriceByTypeCB() {
    	return this.PriceByTypeCB;
    }
    
    public JComboBox<String> getMaxWeightByProductCB() {
    	return this.MaxWeightByProductCB;
    }
    
    //Field Getters
    public String getTransportInsurannceField() {
    	return this.TransportInsurannceField.getText();
    }
    
    public String getretriesField() {
    	return this.retriesField.getText();
    }
    
    public String getpercentageField() {
    	return this.percentageField.getText();
    }
    
    public String getUrgentPriceField() {
    	return this.UrgentPriceField.getText();
    }
    
    public String getPriceByTypeField() {
    	return this.PriceByTypeField.getText();
    }
    
    public String getMaxWeightByProductField() {
    	return this.MaxWeightByProductField.getText();
    }
}