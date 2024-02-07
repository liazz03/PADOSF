package amazonia.views;

import javax.swing.*;
import java.awt.*;
import amazonia.controllers.*;

public class BatchPanel extends JPanel {
	
	private BatchController controller;
	private static final long serialVersionUID = 1L;
	private JButton back;
	private JButton add;
    private JButton confirm;
    private JButton help;

    private JTextField  weight, width, length, height, description;
    private JCheckBox yes, insured;
    final static String[] productType = {"Refrigerated", "Standard", "Fragile", 
                                         "Frozen", "Batch", "StandardFood"};
    private JComboBox<String> types;

	public void setController(BatchController controller) {
		this.controller = controller;
		this.back.addActionListener(controller);
		this.add.addActionListener(controller);
        this.confirm.addActionListener(controller);
        this.help.addActionListener(controller);
    }

    public BatchPanel() {
        
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        
        JLabel title = new JLabel("Order a batch");
    	this.add(title);
    	title.setFont(new Font("Arial", Font.BOLD, 25));
    	layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, this);
		 
		JLabel type = new JLabel("Product type:");
        this.add(type);
        layout.putConstraint(SpringLayout.NORTH, type, 100, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, type, 100, SpringLayout.WEST, this);

        this.types = new JComboBox<String>(productType);
		this.types.setSelectedIndex(0);
		this.add(types);
		layout.putConstraint(SpringLayout.NORTH, types, 100, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, types, 250, SpringLayout.WEST, this);

        this.insured = new JCheckBox("Insured (If fragile)");
		insured.setBounds(10,10,150,30);
		this.add(insured);
		layout.putConstraint(SpringLayout.NORTH, insured, 100, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, insured, 400, SpringLayout.WEST, this);
		
        JLabel weightLabel = new JLabel("Product weight: ");
        this.add(weightLabel);
        layout.putConstraint(SpringLayout.NORTH, weightLabel, 130, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, weightLabel, 100, SpringLayout.WEST, this);

        this.weight = new JTextField(20);
        this.add(this.weight);
        layout.putConstraint(SpringLayout.NORTH, this.weight, 130, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, this.weight, 250, SpringLayout.WEST, this);

        JLabel widthLabel = new JLabel("Product width: ");
        this.add(widthLabel);
        layout.putConstraint(SpringLayout.NORTH, widthLabel, 160, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, widthLabel, 100, SpringLayout.WEST, this);

        this.width = new JTextField(20);
        this.add(width);
        layout.putConstraint(SpringLayout.NORTH, width, 160, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, width, 250, SpringLayout.WEST, this);

        JLabel lengthLabel = new JLabel("Product length: ");
        this.add(lengthLabel);
        layout.putConstraint(SpringLayout.NORTH, lengthLabel, 190, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, lengthLabel, 100, SpringLayout.WEST, this);

        this.length = new JTextField(20);
        this.add(length);
        layout.putConstraint(SpringLayout.NORTH, length, 190, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, length, 250, SpringLayout.WEST, this);

        JLabel heightLabel = new JLabel("Product height:");
		this.add(heightLabel);
		layout.putConstraint(SpringLayout.NORTH, heightLabel, 220, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, heightLabel, 100, SpringLayout.WEST, this);

        this.height = new JTextField(20);
		this.add(height);
		layout.putConstraint(SpringLayout.NORTH, height, 220, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, height, 250, SpringLayout.WEST, this);
		
		JLabel description = new JLabel("Product Description:");
		this.add(description);
		layout.putConstraint(SpringLayout.NORTH, description, 250, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, description, 100, SpringLayout.WEST, this);
		
		this.description = new JTextField(20);
		this.add(this.description);
		layout.putConstraint(SpringLayout.NORTH, this.description, 310, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, this.description, 250, SpringLayout.WEST, this);

        this.back = new JButton("Back");
        back.setPreferredSize(new Dimension(130, 28));
        this.add(back);
		layout.putConstraint(SpringLayout.NORTH, back, 15, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, back, 15, SpringLayout.WEST, this);

        this.add = new JButton("Add to batch");
        this.add(add);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, add, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, add, 350, SpringLayout.NORTH, this);
		this.add.setBackground(Color.CYAN);

        this.confirm = new JButton("Confirm order");
        confirm.setPreferredSize(new Dimension(130, 28));
        this.add(confirm);
		layout.putConstraint(SpringLayout.NORTH, confirm, 350, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, confirm, 500, SpringLayout.WEST, this);
        this.add.setBackground(Color.YELLOW);
        
        this.help = new JButton("Help");
        this.add(help);
        layout.putConstraint(SpringLayout.NORTH, help, 15, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, help, 600, SpringLayout.WEST, this);
        
    }
    
    //Button getters
    public JButton getBackButton() {
    	return this.back;
    }
    
    public JButton getAddButton() {
    	return this.add;
    }

    public JButton getConfirmButton() {
    	return this.confirm;
    }
    
    public JButton getHelpButton() {
    	return this.help;
    }
    
    //Field getters 
    public JCheckBox getUrgent() {
    	return this.yes;
    }
    
    public JCheckBox getInsured() {
    	return this.insured;
    }
    
    public JComboBox<String> getProductTypeCB() {
    	return this.types;
    }
    
    public String getWeight() {
    	return this.weight.getText();
    }
    
    public String getWith() {
    	return this.width.getText();
    }
    
    public String getLength() {
    	return this.length.getText();
    }
    
    public String getHeights() {
    	return this.length.getText();
    }
    
    public String getDescription() {
    	return this.description.getText();
    }
}