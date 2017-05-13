package com.kitri.pay.main;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MainView extends JFrame {

    private final int TIME_COUNT = 8;
    private final int POINT_COUNT = 5;
    
    private String[] timeStr = {"1시간", "1시간 30분", "2시간", "2시간30분", "3시간", "4시간", "5시간", "7시간"};
    private String[] pointStr = {"1000P", "3000P", "5000P", "10000P", "15000P"}; 
    
    private JButton[] timeButton;
    private JButton[] pointButton;
    
    private JPanel contentPane;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JButton btnNewButton_4;
    private JButton btnNewButton_5;
    private JButton btnNewButton_6;
    private JButton btnNewButton_7;
    private JButton btnNewButton_8;
    private JButton btnNewButton_9;
    private JButton btnNewButton_10;
    private JButton btnNewButton_11;
    private JButton btnNewButton_12;
    private JButton btnNewButton_13;
    private JButton btnNewButton_14;
    private JPanel timePanel;
    private JPanel pointPanel;
    private JPanel panel_3;
    private JPanel mainPanel;
    private JPanel panel;
    private JLabel lblNewLabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    MainView frame = new MainView();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public MainView() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new BorderLayout(0, 0));
	
	mainPanel = new JPanel();
	contentPane.add(mainPanel, BorderLayout.CENTER);
	mainPanel.setLayout(new GridLayout(1, 3, 40, 0));
	
	timePanel = new JPanel();
	mainPanel.add(timePanel);
	timePanel.setLayout(new GridLayout(4, 2, 20, 20));
	
	btnNewButton = new JButton("New button");
	timePanel.add(btnNewButton);
	
	btnNewButton_1 = new JButton("New button");
	timePanel.add(btnNewButton_1);
	
	btnNewButton_2 = new JButton("New button");
	timePanel.add(btnNewButton_2);
	
	btnNewButton_3 = new JButton("New button");
	timePanel.add(btnNewButton_3);
	
	btnNewButton_4 = new JButton("New button");
	timePanel.add(btnNewButton_4);
	
	btnNewButton_5 = new JButton("New button");
	timePanel.add(btnNewButton_5);
	
	btnNewButton_6 = new JButton("New button");
	timePanel.add(btnNewButton_6);
	
	btnNewButton_7 = new JButton("New button");
	timePanel.add(btnNewButton_7);
	
	pointPanel = new JPanel();
	mainPanel.add(pointPanel);
	pointPanel.setLayout(new GridLayout(4, 2, 20, 20));
	
	btnNewButton_8 = new JButton("New button");
	pointPanel.add(btnNewButton_8);
	
	btnNewButton_9 = new JButton("New button");
	pointPanel.add(btnNewButton_9);
	
	btnNewButton_10 = new JButton("New button");
	pointPanel.add(btnNewButton_10);
	
	btnNewButton_11 = new JButton("New button");
	pointPanel.add(btnNewButton_11);
	
	panel_3 = new JPanel();
	mainPanel.add(panel_3);
	panel_3.setLayout(new GridLayout(3, 1, 20, 20));
	
	btnNewButton_12 = new JButton("New button");
	panel_3.add(btnNewButton_12);
	
	btnNewButton_13 = new JButton("New button");
	panel_3.add(btnNewButton_13);
	
	btnNewButton_14 = new JButton("New button");
	panel_3.add(btnNewButton_14);
	
	panel = new JPanel();
	panel.setMinimumSize(new Dimension(10, 100));
	contentPane.add(panel, BorderLayout.NORTH);
	
	lblNewLabel = new JLabel("New label");
	panel.add(lblNewLabel);

	GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
	GraphicsDevice device = environment.getDefaultScreenDevice();
	this.setUndecorated(true);
	device.setFullScreenWindow(this);

//	if (device.isDisplayChangeSupported()) {
//	    // refreshRate값은 따로 찾아 봐야함
//	    DisplayMode displayMode = new DisplayMode(1024, 768, 32, DisplayMode.REFRESH_RATE_UNKNOWN);
//	    device.setDisplayMode(displayMode);
//	}
    }

}
