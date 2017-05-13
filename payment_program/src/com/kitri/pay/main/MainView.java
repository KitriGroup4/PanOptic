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
    private final int FUNCTION_COUNT = 3;

    private String[] timeStr = { "1시간", "1시간 30분", "2시간", "2시간30분", "3시간", "4시간", "5시간", "7시간" };
    private String[] pointStr = { "1000P", "3000P", "5000P", "10000P", "15000P" };
    private String[] functionStr = { "회원가입", "포인트결제", "카드결제" };

    private JButton[] timeButton;
    private JButton[] pointButton;
    private JButton[] functionButton;

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
	
	listener = new MainViewListener(this);

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
	timePanel.setLayout(new BorderLayout(0, 0));

	timeButtonPanel = new JPanel();
	timePanel.add(timeButtonPanel, BorderLayout.CENTER);
	timeButtonPanel.setLayout(new GridLayout(4, 2, 20, 20));

	timeButton = new JButton[TIME_COUNT];
	for (int i = 0; i < TIME_COUNT; i++) {
	    timeButton[i] = new JButton(timeStr[i]);
	    timeButtonPanel.add(timeButton[i]);
	}

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

	pointButton = new JButton[POINT_COUNT];
	for (int i = 0; i < POINT_COUNT; i++) {
	    pointButton[i] = new JButton(pointStr[i]);
	    pointButtonPanel.add(pointButton[i]);
	}

	pointLabelPanel = new JPanel();
	pointPanel.add(pointLabelPanel, BorderLayout.NORTH);

	pointLabel = new JLabel("New label");
	pointLabel.setFont(new Font("굴림", Font.PLAIN, 30));
	pointLabelPanel.add(pointLabel);

	functionPanel = new JPanel();
	mainPanel.add(functionPanel);
	functionPanel.setLayout(new GridLayout(3, 1, 20, 20));

	functionButton = new JButton[FUNCTION_COUNT];
	for (int i = 0; i < FUNCTION_COUNT; i++) {
	    functionButton[i] = new JButton(functionStr[i]);
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

}
