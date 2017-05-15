package com.kitri.admin.main.managementPanel.RegisterEmployeeFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kitri.admin.main.fixCon.Fix;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class RegisterEmployeeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField empjoinTf;
	private JTextField IdTf;
	private JTextField nameTf;
	private JTextField pwTf;
	private JTextField pwCheckTf;
	private JTextField birthTf;
	private JTextField eMailTf;
	private JTextField hpTf;
	private JTextField phoneTf;
	private JTextField addressTf;
	private JTextField wageTf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterEmployeeFrame frame = new RegisterEmployeeFrame();
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
	public RegisterEmployeeFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 500, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel empjoinPanel = new JPanel();
		empjoinPanel.setLayout(null);
		empjoinPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		empjoinPanel.setBounds(0, 0, 478, 544);
		contentPane.add(empjoinPanel);
		
		empjoinTf = new JTextField();
		empjoinTf.setText("직원등록");
		empjoinTf.setHorizontalAlignment(SwingConstants.CENTER);
		empjoinTf.setEditable(false);
		empjoinTf.setColumns(10);
		empjoinTf.setBounds(17, 25, 444, 50);
		empjoinPanel.add(empjoinTf);
		
		JPanel joinBasicPanel = new JPanel();
		joinBasicPanel.setBounds(17, 116, 91, 208);
		empjoinPanel.add(joinBasicPanel);
		joinBasicPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel IdLabel = new JLabel("* \uC544\uC774\uB514");
		IdLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		IdLabel.setHorizontalAlignment(SwingConstants.LEFT);
		joinBasicPanel.add(IdLabel);
		
		JLabel nameLabel = new JLabel("* \uC774\uB984");
		nameLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		joinBasicPanel.add(nameLabel);
		
		JLabel pwLabel = new JLabel("* \uBE44\uBC00\uBC88\uD638");
		pwLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		pwLabel.setHorizontalAlignment(SwingConstants.LEFT);
		joinBasicPanel.add(pwLabel);
		
		JLabel pwCheckLabel = new JLabel("* \uBE44\uBC00\uBC88\uD638\uD655\uC778");
		pwCheckLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		pwCheckLabel.setHorizontalAlignment(SwingConstants.LEFT);
		joinBasicPanel.add(pwCheckLabel);
		
		JLabel birthLabel = new JLabel("* \uC0DD\uB144\uC6D4\uC77C");
		birthLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		birthLabel.setHorizontalAlignment(SwingConstants.LEFT);
		joinBasicPanel.add(birthLabel);
		
		JPanel joinBasicTfPanel = new JPanel();
		joinBasicTfPanel.setBounds(114, 116, 234, 208);
		empjoinPanel.add(joinBasicTfPanel);
		joinBasicTfPanel.setLayout(new GridLayout(5, 0, 5, 5));
		
		IdTf = new JTextField();
		IdTf.setColumns(10);
		joinBasicTfPanel.add(IdTf);
		
		nameTf = new JTextField();
		nameTf.setColumns(10);
		joinBasicTfPanel.add(nameTf);
		
		pwTf = new JTextField();
		pwTf.setColumns(10);
		joinBasicTfPanel.add(pwTf);
		
		pwCheckTf = new JTextField();
		pwCheckTf.setColumns(10);
		joinBasicTfPanel.add(pwCheckTf);
		
		birthTf = new JTextField();
		birthTf.setHorizontalAlignment(SwingConstants.LEFT);
		birthTf.setColumns(10);
		joinBasicTfPanel.add(birthTf);
		
		JButton checkBut = new JButton("\uC911\uBCF5\uD655\uC778");
		checkBut.setBounds(356, 116, 105, 35);
		empjoinPanel.add(checkBut);
		
		JPanel RadionButPanel = new JPanel();
		RadionButPanel.setBounds(356, 279, 105, 43);
		empjoinPanel.add(RadionButPanel);
		
		JRadioButton manRadionBut = new JRadioButton("\uB0A8");
		RadionButPanel.add(manRadionBut);
		
		JRadioButton womanRadioBut = new JRadioButton("\uC5EC");
		RadionButPanel.add(womanRadioBut);
		
		JLabel infoLabel = new JLabel("\uAE30\uBCF8\uC815\uBCF4");
		infoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		infoLabel.setBounds(17, 90, 91, 21);
		empjoinPanel.add(infoLabel);
		
		JLabel addinfoLabel = new JLabel("\uBD80\uAC00\uC815\uBCF4");
		addinfoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		addinfoLabel.setBounds(17, 339, 91, 21);
		empjoinPanel.add(addinfoLabel);
		
		JPanel subInfoTfPanel = new JPanel();
		subInfoTfPanel.setBounds(91, 367, 144, 74);
		empjoinPanel.add(subInfoTfPanel);
		subInfoTfPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		eMailTf = new JTextField();
		eMailTf.setHorizontalAlignment(SwingConstants.CENTER);
		eMailTf.setColumns(10);
		subInfoTfPanel.add(eMailTf);
		
		hpTf = new JTextField();
		hpTf.setHorizontalAlignment(SwingConstants.CENTER);
		hpTf.setColumns(10);
		subInfoTfPanel.add(hpTf);
		
		JPanel subInfoLabelPanel2 = new JPanel();
		subInfoLabelPanel2.setBounds(239, 367, 61, 74);
		empjoinPanel.add(subInfoLabelPanel2);
		subInfoLabelPanel2.setLayout(new GridLayout(0, 1, 5, 5));
		
		JLabel jobLabel = new JLabel("\uC9C1\uAE09");
		jobLabel.setHorizontalAlignment(SwingConstants.LEFT);
		subInfoLabelPanel2.add(jobLabel);
		
		JLabel phoneLabel = new JLabel("\uD578\uB4DC\uD3F0");
		phoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
		subInfoLabelPanel2.add(phoneLabel);
		
		JPanel subinfoLabelPanel = new JPanel();
		subinfoLabelPanel.setBounds(17, 367, 72, 74);
		empjoinPanel.add(subinfoLabelPanel);
		subinfoLabelPanel.setLayout(new GridLayout(0, 1, 5, 5));
		
		JLabel eMailLabel = new JLabel("E-Mail");
		eMailLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		eMailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		subinfoLabelPanel.add(eMailLabel);
		
		JLabel hpLabel = new JLabel("\uC5F0\uB77D\uCC98(\uC9D1)");
		hpLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		hpLabel.setHorizontalAlignment(SwingConstants.LEFT);
		subinfoLabelPanel.add(hpLabel);
		
		JPanel subInfoCbTfPanel2 = new JPanel();
		subInfoCbTfPanel2.setBounds(305, 367, 156, 74);
		empjoinPanel.add(subInfoCbTfPanel2);
		subInfoCbTfPanel2.setLayout(new GridLayout(0, 1, 5, 5));
		
		JComboBox jobCb = new JComboBox();
		subInfoCbTfPanel2.add(jobCb);
		
		phoneTf = new JTextField();
		phoneTf.setColumns(10);
		subInfoCbTfPanel2.add(phoneTf);
		
		JPanel addressLablePanel = new JPanel();
		addressLablePanel.setBounds(17, 443, 72, 35);
		empjoinPanel.add(addressLablePanel);
		addressLablePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel addressLabel = new JLabel("\uC8FC\uC18C");
		addressLablePanel.add(addressLabel);
		
		JPanel addressTfPanel = new JPanel();
		addressTfPanel.setBounds(91, 443, 370, 35);
		empjoinPanel.add(addressTfPanel);
		addressTfPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		addressTf = new JTextField();
		addressTf.setColumns(10);
		addressTfPanel.add(addressTf);
		
		JLabel hire_dateLabel = new JLabel("\uC785\uC0AC\uC77C");
		hire_dateLabel.setBounds(17, 493, 72, 35);
		empjoinPanel.add(hire_dateLabel);
		
		JPanel hire_datePanel = new JPanel();
		hire_datePanel.setBounds(75, 499, 163, 29);
		empjoinPanel.add(hire_datePanel);
		hire_datePanel.setLayout(new GridLayout(1, 3, 5, 5));
		
		JComboBox hire_yy_cb = new JComboBox();
		hire_datePanel.add(hire_yy_cb);
		
		JComboBox hire_mm_cb = new JComboBox();
		hire_datePanel.add(hire_mm_cb);
		
		JComboBox hire_dd_cb = new JComboBox();
		hire_dd_cb.setLocation(112, 496);
		hire_datePanel.add(hire_dd_cb);
		
		JLabel wageLabel = new JLabel("\uC2DC\uAE09");
		wageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wageLabel.setBounds(228, 493, 72, 35);
		empjoinPanel.add(wageLabel);
		
		wageTf = new JTextField();
		wageTf.setBounds(305, 497, 156, 27);
		empjoinPanel.add(wageTf);
		wageTf.setColumns(10);
		
		JButton joinBut = new JButton("\uAC00\uC785\uC694\uCCAD");
		joinBut.setBounds(194, 566, 125, 29);
		contentPane.add(joinBut);
		
		JButton closeBut = new JButton("\uB2EB\uAE30");
		closeBut.setBounds(336, 565, 125, 29);
		contentPane.add(closeBut);
		
		Fix.FIXFRAME(this);
	}
}