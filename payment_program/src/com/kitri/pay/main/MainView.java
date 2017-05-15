package com.kitri.pay.main;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.kitri.pay.join.UserJoin;

public class MainView extends JFrame {

    public int TIME_COUNT = 8;
    public int POINT_COUNT = 5;
    public int FUNCTION_COUNT = 3;

    public int[] timeMoney = {1000, 1200, 1500, 2000, 2500, 3000, 4000, 5000};
    public int[] pointMoney = {1000, 2500, 4000, 7000, 10000};
    public String[] timeStr = { "1시간  1000원", "1시간 30분  1200원", "2시간  1500원", "2시간30분  2000원", "3시간  2500원",
	    "4시간  3000원", "5시간  4000원", "7시간  5000원" };
    public String[] pointStr = { "1000P  1000원", "3000P  2500원", "5000P  4000원", "10000P  7000원", "15000P  10000원" };
    public String[] functionStr = { "회원가입", "포인트결제", "카드결제" };
    public boolean[] isClickTime;
    public boolean[] isClickPoint;

    private int money;
    

    public JLabel[] timeButton;
    public JLabel[] pointButton;
    public JButton[] functionButton;

    private JPanel contentPane;
    private JPanel timeButtonPanel;
    private JPanel pointButtonPanel;
    private JPanel functionPanel;
    private JPanel mainPanel;
    private JPanel mainLabelPanel;
    private JLabel lblNewLabel;
    private JPanel timePanel;
    private JPanel timeLabelPanel;
    private JLabel timeLabel;
    private JPanel pointPanel;
    private JPanel pointLabelPanel;
    private JLabel pointLabel;

    private MainViewListener listener;
    private JLabel moneyLabel;
    
    private static MainView view;
    
    public UserJoin join;
    private JInternalFrame internalFrame;
    

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
	
	view = this;
	money = 0;

	isClickTime = new boolean[TIME_COUNT];
	isClickPoint = new boolean[POINT_COUNT];

	listener = new MainViewListener(this);

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new BorderLayout(0, 0));
	

	join = new UserJoin();
	contentPane.add(join);

	mainPanel = new JPanel();
	contentPane.add(mainPanel, BorderLayout.CENTER);
	mainPanel.setLayout(new GridLayout(1, 3, 40, 0));

	timePanel = new JPanel();
	mainPanel.add(timePanel);
	timePanel.setLayout(new BorderLayout(0, 0));

	timeButtonPanel = new JPanel();
	timePanel.add(timeButtonPanel, BorderLayout.CENTER);
	timeButtonPanel.setLayout(new GridLayout(4, 2, 20, 20));

	timeButton = new JLabel[TIME_COUNT];
	setButton(timeButton, timeStr, timeButtonPanel, TIME_COUNT);

	timeLabelPanel = new JPanel();
	timePanel.add(timeLabelPanel, BorderLayout.NORTH);

	timeLabel = new JLabel("New label");
	timeLabel.setFont(new Font("굴림", Font.PLAIN, 30));
	timeLabelPanel.add(timeLabel);

	pointPanel = new JPanel();
	mainPanel.add(pointPanel);
	pointPanel.setLayout(new BorderLayout(0, 0));

	pointButtonPanel = new JPanel();
	pointPanel.add(pointButtonPanel);
	pointButtonPanel.setLayout(new GridLayout(4, 2, 20, 20));

	pointButton = new JLabel[POINT_COUNT];
	setButton(pointButton, pointStr, pointButtonPanel, POINT_COUNT);

	pointLabelPanel = new JPanel();
	pointPanel.add(pointLabelPanel, BorderLayout.NORTH);

	pointLabel = new JLabel("New label");
	pointLabel.setForeground(Color.BLACK);
	pointLabel.setFont(new Font("굴림", Font.PLAIN, 30));
	pointLabelPanel.add(pointLabel);

	functionPanel = new JPanel();
	mainPanel.add(functionPanel);
	functionPanel.setLayout(new GridLayout(4, 1, 20, 20));

	moneyLabel = new JLabel(money + "원");
	moneyLabel.setHorizontalAlignment(JLabel.CENTER);
	moneyLabel.setVerticalAlignment(JLabel.CENTER);
	moneyLabel.setFont(new Font("default", Font.BOLD, 40));
	functionPanel.add(moneyLabel);

	functionButton = new JButton[FUNCTION_COUNT];
	for (int i = 0; i < FUNCTION_COUNT; i++) {
	    functionButton[i] = new JButton(functionStr[i]);
	    functionButton[i].addActionListener(listener);
	    functionButton[i].setFont(new Font("굴림", Font.PLAIN, 30));
	    functionPanel.add(functionButton[i]);

	}

	mainLabelPanel = new JPanel();
	mainLabelPanel.setMinimumSize(new Dimension(10, 100));
	contentPane.add(mainLabelPanel, BorderLayout.NORTH);

	lblNewLabel = new JLabel("New label");
	lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 60));
	mainLabelPanel.add(lblNewLabel);

	GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
	GraphicsDevice device = environment.getDefaultScreenDevice();
	this.setUndecorated(true);
	device.setFullScreenWindow(this);
	

	// if (device.isDisplayChangeSupported()) {
	// // refreshRate값은 따로 찾아 봐야함
	// DisplayMode displayMode = new DisplayMode(1024, 768, 32,
	// DisplayMode.REFRESH_RATE_UNKNOWN);
	// device.setDisplayMode(displayMode);
	// }
    }

    private void setButton(JLabel[] label, String[] labelStr, JPanel panel, int count) {

	for (int i = 0; i < count; i++) {
	    label[i] = new JLabel(labelStr[i]);
	    label[i].setHorizontalAlignment(JLabel.CENTER);
	    label[i].setVerticalAlignment(JLabel.CENTER);
	    // timeButton[i].setForeground(Color.BLUE);
	    label[i].setFont(new Font("default", Font.BOLD, 20));
	    label[i].addMouseListener(listener);
	    panel.add(label[i]);
	}

    }

    public int getMoney() {
	return money;
    }

    public void setMoney(int money) {
	this.money = money;

	if (this.money < 0) {
	    this.money = 0;
	}

	moneyLabel.setText(this.money + "원");
    }
    
    public static MainView getInstance(){
	return view;
    }

}
