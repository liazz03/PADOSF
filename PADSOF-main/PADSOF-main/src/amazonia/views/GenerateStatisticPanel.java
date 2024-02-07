package amazonia.views;

import javax.swing.*;
import java.awt.*;
import java.time.Month;

import amazonia.controllers.*;

public class GenerateStatisticPanel extends JPanel {
	//tiene q tenner un combobox con los tipos de statistics
	
	private static final long serialVersionUID = 1L;
	private GenerateStatisticController controller;

	private JPanel statisticsPanel;

	private JLabel mainlabel;
	private JLabel sublabel;
	private JButton backButton;
	private JButton calculateStatsButton;
	private JComboBox<String> displayStatsCB;
	private JComboBox<Month> displayMonthsCB;


	final static String GENERATE_STATISTIC_PANEL = "STATISTICS PANEL";
	final static String[] stats = {"Select an option", "Income per month", "Average Income per Order per month", "Orders per month",
	"Number of packages per month", "Number of packages delivered per month",
	"Number of packages non delivered per month"};
	final static Month[] months = {Month.JANUARY, Month.FEBRUARY, Month.MARCH, Month.APRIL, Month.MAY,
	Month.JUNE, Month.JULY, Month.AUGUST, Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER};
	
	public void setController(GenerateStatisticController controller) {
		this.controller = controller;
		this.backButton.addActionListener(controller);
		this.calculateStatsButton.addActionListener(controller);
		this.displayStatsCB.addActionListener(controller);
		this.displayMonthsCB.addActionListener(controller);
	}

	public GenerateStatisticPanel(){

		CardLayout card_layout = new CardLayout();
		this.setLayout(card_layout);

		this.statisticsPanel = new JPanel();
		SpringLayout layout = new SpringLayout();
		this.statisticsPanel.setLayout(layout);

		//main label
		this.mainlabel= new JLabel("Statistics");
		this.mainlabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.statisticsPanel.add(mainlabel);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, mainlabel, 0, SpringLayout.HORIZONTAL_CENTER, statisticsPanel);
		layout.putConstraint(SpringLayout.NORTH, mainlabel, 10, SpringLayout.NORTH, statisticsPanel);

		//sub label
		this.sublabel= new JLabel("Select an option for showing the statistics: ");
		this.sublabel.setFont(new Font("Times New Roman", Font.BOLD, 15));

		this.statisticsPanel.add(sublabel);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, sublabel, 0, SpringLayout.HORIZONTAL_CENTER, statisticsPanel);
		layout.putConstraint(SpringLayout.NORTH, sublabel, 30, SpringLayout.NORTH, statisticsPanel);

		//back button
		this.backButton = new JButton("Back");
		this.backButton.setPreferredSize(new Dimension(130, 28));
		this.statisticsPanel.add(backButton);
		layout.putConstraint(SpringLayout.NORTH, backButton, 15, SpringLayout.NORTH, statisticsPanel);
		layout.putConstraint(SpringLayout.WEST, backButton, 15, SpringLayout.WEST, statisticsPanel);

		//StatsOption
		this.displayStatsCB = new JComboBox<String>(stats);
		this.displayStatsCB.setSelectedIndex(0);
		this.statisticsPanel.add(displayStatsCB);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, displayStatsCB, -160, SpringLayout.HORIZONTAL_CENTER, statisticsPanel);
		layout.putConstraint(SpringLayout.NORTH, displayStatsCB, 80, SpringLayout.NORTH, statisticsPanel);

		//MonthssOption
		this.displayMonthsCB = new JComboBox<Month>(months);
		this.displayMonthsCB.setSelectedIndex(0);
		this.statisticsPanel.add(displayMonthsCB);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, displayMonthsCB, 160, SpringLayout.HORIZONTAL_CENTER, statisticsPanel);
		layout.putConstraint(SpringLayout.NORTH, displayMonthsCB, 80, SpringLayout.NORTH, statisticsPanel);

		//calculatestats button
		this.calculateStatsButton = new JButton("Calculate Statistic");
		this.calculateStatsButton.setPreferredSize(new Dimension(180, 28));
		this.calculateStatsButton.setBackground(Color.GREEN);
		this.statisticsPanel.add(calculateStatsButton);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, calculateStatsButton, 0, SpringLayout.HORIZONTAL_CENTER, statisticsPanel);
		layout.putConstraint(SpringLayout.NORTH, calculateStatsButton, 150, SpringLayout.NORTH, statisticsPanel);

		//set main panel size
		this.statisticsPanel.setPreferredSize(new Dimension(500, 300));
		this.add(statisticsPanel, GENERATE_STATISTIC_PANEL);
		
	}

	public void showGenerateStatisticPanel(){
		CardLayout ele = (CardLayout)(this.getLayout());
		ele.show(this, GENERATE_STATISTIC_PANEL);
	}

	public JComboBox<String> getStatsComboBox(){
		return this.displayStatsCB;
	}

	public JComboBox<Month> getMonthsComboBox(){
		return this.displayMonthsCB;
	}

	public JButton getbackButton() {
		return this.backButton;
	}

	public JButton getcalculateStatsButton(){
		return this.calculateStatsButton;
	}
}