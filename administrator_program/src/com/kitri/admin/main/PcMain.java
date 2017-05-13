package com.kitri.admin.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JScrollBar;

public class PcMain extends JFrame {

	private JPanel contentPane;
	
	int topMenuNum = 8;
	
	int comRowNum= 10;
	int comNum = 20;
	int totalCom = comRowNum*comRowNum;
	
	String topMenuTitle[] = {"매장", "고객", "재고", "직원", "통계", "제어", "관리"};
	
//////////////////////////////////////////////////////////////	
//	cards component
	Panel cardPanel = new Panel();
	Panel top = new Panel();
	
	JLabel lblNewLabel = new JLabel("PAN-OPTIC");	
	JButton[] topMenuButton = new JButton[topMenuNum-1];		
	
    private CardLayout cl = new CardLayout();
    StoreJP storeJPanel = new StoreJP();
	JButton btnNewButton = new JButton("\uB9E4\uC7A5");
	CustomerJP customerJPanel = new CustomerJP();
	JButton btnNewButton_1 = new JButton("\uACE0\uAC1D");
	LeftOverJP leftOverJPanel = new LeftOverJP();
	JButton btnNewButton_2 = new JButton("\uC7AC\uACE0");
	EmployeeJP employeeJPanel = new EmployeeJP();
	JButton btnNewButton_3 = new JButton("\uC9C1\uC6D0");
	StatJP statJPanel = new StatJP();
	ControlJP controlJPanel = new ControlJP();
	ManagementJP managementJPanel = new ManagementJP();
	
//////////////////////////////////////////////////////////////	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PcMain frame = new PcMain();
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
	public PcMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(20, 20));
		
		//센터 pc 자리 채우기
		JButton buttonCenter[] = new JButton[comNum];
		JPanel center = new JPanel();
		contentPane.add(center, BorderLayout.CENTER);
		center.setLayout(new GridLayout(comRowNum, comRowNum, 30, 30));
				
		for (int i=0; i<comNum; i++) {
			buttonCenter[i]= new JButton("pc " + (i + 1));
			center.add(buttonCenter[i]);
		}
		
		for (int i=comNum+21; i<=totalCom-comNum+20; i++) {
			JLabel LabelCenter = new JLabel(i+"");
			center.add(LabelCenter);
		}
				
		contentPane.add(cardPanel, BorderLayout.WEST);
		cardPanel.setLayout(new GridLayout(1, 1, 0, 0));
		
		//상단 메뉴
		contentPane.add(top, BorderLayout.NORTH);
		top.setLayout(new GridLayout(1, topMenuNum, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		top.add(lblNewLabel);
		
		int len = topMenuButton.length;
		for (int i = 0; i < len; i++) {
			topMenuButton[i] = new JButton(topMenuTitle[i]);
			top.add(topMenuButton[i]);
		}
		
		
//		left.add(cardPanel);
		cardPanel.setLayout(cl);
		
		cardPanel.add(storeJPanel, topMenuTitle[0]);
//		cardPanel.add(store, "1");
		storeJPanel.add(btnNewButton);
		cardPanel.add(customerJPanel, topMenuTitle[1]);
		customerJPanel.add(btnNewButton_1);
		cardPanel.add(leftOverJPanel, topMenuTitle[2]);
		leftOverJPanel.add(btnNewButton_2);
		cardPanel.add(employeeJPanel, topMenuTitle[3]);
		employeeJPanel.add(btnNewButton_3);
		cardPanel.add(statJPanel, topMenuTitle[4]);
		cardPanel.add(controlJPanel, topMenuTitle[5]);
		cardPanel.add(managementJPanel, topMenuTitle[6]);
		
		topMenuButton[0].addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cl.show(cardPanel, topMenuTitle[0]);
            }
        });
		topMenuButton[1].addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cl.show(cardPanel, topMenuTitle[1]);
            }
        });
		topMenuButton[2].addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cl.show(cardPanel, topMenuTitle[2]);
            }
        });
		topMenuButton[3].addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cl.show(cardPanel, topMenuTitle[3]);
            }
        });
		topMenuButton[4].addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cl.show(cardPanel, topMenuTitle[4]);
            }
        });
		topMenuButton[5].addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cl.show(cardPanel, topMenuTitle[5]);
            }
        });
		topMenuButton[6].addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cl.show(cardPanel, topMenuTitle[6]);
            }
        });
		
//		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		   GraphicsDevice device = environment.getDefaultScreenDevice();
//		   this.setUndecorated(true);
//		   device.setFullScreenWindow(this);
	}
}
