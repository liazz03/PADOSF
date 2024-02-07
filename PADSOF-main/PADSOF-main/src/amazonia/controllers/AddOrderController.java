package amazonia.controllers;

import amazonia.views.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import amazonia.application.Amazonia;
import amazonia.products.*;
import amazonia.users.*;

public class AddOrderController implements ActionListener {

	private AddOrderPanel panel;
	private HomeCompanyPanel window;
	private Amazonia amazonia;
	private List<Product> products = new ArrayList<Product>();

	public AddOrderController(AddOrderPanel panel, HomeCompanyPanel window) {
		this.panel = panel;
		this.window = window;
		this.amazonia = Amazonia.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(this.panel.getBackButton())) {
			this.window.showHomeCompanyPanel();
		}else if(e.getSource().equals(this.panel.getAddButton())) {
			//Get order fields
			
			//BATCH
			/*
			if(panel.getProductTypeCB().getSelectedIndex()==4){
				this.panel.showBatchPanel();
			}
			*/
			
			if(panel.getWeight().equals("") || panel.getWith()
			.equals("") || panel.getLength().equals("") || panel.getHeights().equals("")||
			panel.getDescription().equals("")) {
				JOptionPane.showMessageDialog(this.panel, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				if(panel.getProductTypeCB().getSelectedIndex()==0) {
					products.add(new RefrigeratedFood(panel.getDescription(), 
							Double.parseDouble(panel.getWeight()), Double.parseDouble(panel.getWith()),
							Double.parseDouble(panel.getLength()), Double.parseDouble(panel.getHeights())));
				}else if(panel.getProductTypeCB().getSelectedIndex()==1) {
					products.add(new StandardProduct(panel.getDescription(), 
							Double.parseDouble(panel.getWeight()), Double.parseDouble(panel.getWith()),
							Double.parseDouble(panel.getLength()), Double.parseDouble(panel.getHeights())));
				}else if(panel.getProductTypeCB().getSelectedIndex()==2) {
					boolean insured = panel.getInsured().isSelected();
					products.add(new Fragile(panel.getDescription(), 
							Double.parseDouble(panel.getWeight()), Double.parseDouble(panel.getWith()),
							Double.parseDouble(panel.getLength()), Double.parseDouble(panel.getHeights()),insured));
				}else if(panel.getProductTypeCB().getSelectedIndex()==3) {
					products.add(new Frozen(panel.getDescription(), 
							Double.parseDouble(panel.getWeight()), Double.parseDouble(panel.getWith()),
							Double.parseDouble(panel.getLength()), Double.parseDouble(panel.getHeights())));
				}else {
					products.add(new StandardFood(panel.getDescription(), 
							Double.parseDouble(panel.getWeight()), Double.parseDouble(panel.getWith()),
							Double.parseDouble(panel.getLength()), Double.parseDouble(panel.getHeights())));
				}
				
				JOptionPane.showMessageDialog(this.panel, "Product Added", "Information", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}else if (e.getSource().equals(this.panel.getHelpButton())) {
			JOptionPane.showMessageDialog(this.panel, "Add->Add a product to the order \nConfirm Order->Place your order", "Help", JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource().equals(this.panel.getConfirmButton())) {
			boolean urgent = panel.getUrgent().isSelected();
			Company comp =(Company)this.amazonia.getCurrentUser();
			if(!comp.placeOrder(products, urgent)) {
				JOptionPane.showMessageDialog(this.panel, "Order could not be placed", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(this.panel, "Order Correctly Placed");
			}
		}
		
		//System.out.println(amazonia.getCurrentUser());
	}

}