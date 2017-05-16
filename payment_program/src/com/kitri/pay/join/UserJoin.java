package com.kitri.pay.join;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UserJoin extends JInternalFrame {

    private JPanel BackgroundPane;
    public JTextField joinTf;
    public JTextField joinName;
    public JTextField joinPw;
    public JTextField joinPwCheck;
    public JTextField joinBirth;
    public JTextField joinHomeNumberTf;
    public JTextField joinEmailTf;
    public JTextField joinHpTf;
    public JTextField joinAdressTf;
    public JButton joinConfirmBtn;
    public JButton joinCloseBtn;
    private JPanel BaseInfoLabelPane;
    private JLabel joinIdLabel;
    private JLabel joinNameLabel;
    private JLabel joinPwLabel;
    private JLabel joinPwCheckLabel;
    private JLabel joinBirthLabel;
    private JPanel BaseInfoPane;
    public JTextField joinId;
    public JButton overCheckBtn;
    private JPanel GenderCheckPane;
    private JLabel joinBaseLabel;
    private JLabel joinSubLabel;
    private JPanel SubInfoInputPane;
    private JPanel SubInfoLabelPane1;
    private JLabel joinJobLabel;
    private JLabel joinHpLabel;
    private JPanel SubInfoLabelPane;
    private JLabel joinEmailLabel;
    private JLabel joinHomeNumberLabel;
    private JPanel SubInfoInputPane2;
    private JComboBox jobComboBox;
    private JPanel joinAdressLabelPane;
    private JLabel joinAdressLabel;
    private JPanel JoinAdressPane;
    public JRadioButton maleRadio;
    public JRadioButton femaleRadio;
    private ButtonGroup genderGroup;

    public boolean isMale;

    private UserJoinListenter listener;

    public boolean checkId;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    UserJoin frame = new UserJoin();
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
    public UserJoin() {
	listener = new UserJoinListenter(this);

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 500, 600);
	BackgroundPane = new JPanel();
	BackgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(BackgroundPane);
	BackgroundPane.setLayout(null);

	joinTf = new JTextField();
	joinTf.setEditable(false);
	joinTf.setBounds(17, 25, 444, 50);
	joinTf.setHorizontalAlignment(SwingConstants.CENTER);
	joinTf.setText("\uD68C\uC6D0\uAC00\uC785");
	BackgroundPane.add(joinTf);
	joinTf.setColumns(10);

	joinConfirmBtn = new JButton("\uAC00\uC785\uC694\uCCAD");
	joinConfirmBtn.setBounds(193, 499, 125, 29);
	BackgroundPane.add(joinConfirmBtn);

	joinCloseBtn = new JButton("\uB2EB\uAE30");
	joinCloseBtn.setBounds(335, 499, 125, 29);
	BackgroundPane.add(joinCloseBtn);

	BaseInfoLabelPane = new JPanel();
	BaseInfoLabelPane.setBounds(17, 116, 91, 208);
	BackgroundPane.add(BaseInfoLabelPane);
	BaseInfoLabelPane.setLayout(new GridLayout(0, 1, 0, 0));

	joinIdLabel = new JLabel("* \uC544\uC774\uB514");
	joinIdLabel.setHorizontalAlignment(SwingConstants.LEFT);
	joinIdLabel.setHorizontalTextPosition(SwingConstants.LEFT);
	BaseInfoLabelPane.add(joinIdLabel);

	joinNameLabel = new JLabel("* \uC774\uB984");
	joinNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
	joinNameLabel.setHorizontalTextPosition(SwingConstants.LEFT);
	BaseInfoLabelPane.add(joinNameLabel);

	joinPwLabel = new JLabel("* \uBE44\uBC00\uBC88\uD638");
	joinPwLabel.setHorizontalAlignment(SwingConstants.LEFT);
	joinPwLabel.setHorizontalTextPosition(SwingConstants.LEFT);
	BaseInfoLabelPane.add(joinPwLabel);

	joinPwCheckLabel = new JLabel("* \uBE44\uBC00\uBC88\uD638\uD655\uC778");
	joinPwCheckLabel.setHorizontalAlignment(SwingConstants.LEFT);
	joinPwCheckLabel.setHorizontalTextPosition(SwingConstants.LEFT);
	BaseInfoLabelPane.add(joinPwCheckLabel);

	joinBirthLabel = new JLabel("* \uC0DD\uB144\uC6D4\uC77C");
	joinBirthLabel.setHorizontalAlignment(SwingConstants.LEFT);
	joinBirthLabel.setHorizontalTextPosition(SwingConstants.LEFT);
	BaseInfoLabelPane.add(joinBirthLabel);

	BaseInfoPane = new JPanel();
	BaseInfoPane.setBounds(114, 116, 234, 208);
	BackgroundPane.add(BaseInfoPane);
	BaseInfoPane.setLayout(new GridLayout(5, 0, 5, 5));

	joinId = new JTextField();
	BaseInfoPane.add(joinId);
	joinId.setColumns(10);

	joinName = new JTextField();
	BaseInfoPane.add(joinName);
	joinName.setColumns(10);

	joinPw = new JTextField();
	BaseInfoPane.add(joinPw);
	joinPw.setColumns(10);

	joinPwCheck = new JTextField();
	BaseInfoPane.add(joinPwCheck);
	joinPwCheck.setColumns(10);

	joinBirth = new JTextField();
	joinBirth.setHorizontalAlignment(SwingConstants.LEFT);
	BaseInfoPane.add(joinBirth);
	joinBirth.setColumns(10);

	overCheckBtn = new JButton("\uC911\uBCF5\uD655\uC778");
	overCheckBtn.setBounds(356, 116, 105, 35);
	overCheckBtn.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    }
	});
	BackgroundPane.add(overCheckBtn);

	GenderCheckPane = new JPanel();
	genderGroup = new ButtonGroup();
	GenderCheckPane.setBounds(356, 279, 105, 43);
	BackgroundPane.add(GenderCheckPane);

	maleRadio = new JRadioButton("\uB0A8", true);

	femaleRadio = new JRadioButton("\uC5EC", false);

	genderGroup.add(maleRadio);
	genderGroup.add(femaleRadio);

	GenderCheckPane.add(maleRadio);
	GenderCheckPane.add(femaleRadio);

	joinBaseLabel = new JLabel("\uAE30\uBCF8\uC815\uBCF4");
	joinBaseLabel.setBounds(17, 90, 91, 21);
	joinBaseLabel.setHorizontalAlignment(SwingConstants.LEFT);
	BackgroundPane.add(joinBaseLabel);

	joinSubLabel = new JLabel("\uBD80\uAC00\uC815\uBCF4");
	joinSubLabel.setBounds(17, 339, 91, 21);
	joinSubLabel.setHorizontalAlignment(SwingConstants.LEFT);
	BackgroundPane.add(joinSubLabel);

	SubInfoInputPane = new JPanel();
	SubInfoInputPane.setBounds(91, 367, 144, 74);
	BackgroundPane.add(SubInfoInputPane);
	SubInfoInputPane.setLayout(new GridLayout(0, 1, 0, 0));

	joinEmailTf = new JTextField();
	joinEmailTf.setHorizontalAlignment(SwingConstants.CENTER);
	SubInfoInputPane.add(joinEmailTf);
	joinEmailTf.setColumns(10);

	joinHomeNumberTf = new JTextField();
	joinHomeNumberTf.setHorizontalAlignment(SwingConstants.CENTER);
	SubInfoInputPane.add(joinHomeNumberTf);
	joinHomeNumberTf.setColumns(10);

	SubInfoLabelPane1 = new JPanel();
	SubInfoLabelPane1.setBounds(239, 367, 61, 74);
	BackgroundPane.add(SubInfoLabelPane1);
	SubInfoLabelPane1.setLayout(new GridLayout(0, 1, 5, 5));

	joinJobLabel = new JLabel("\uC9C1\uC5C5");
	joinJobLabel.setHorizontalAlignment(SwingConstants.LEFT);
	SubInfoLabelPane1.add(joinJobLabel);

	joinHpLabel = new JLabel("\uD578\uB4DC\uD3F0");
	joinHpLabel.setHorizontalAlignment(SwingConstants.LEFT);
	SubInfoLabelPane1.add(joinHpLabel);

	SubInfoLabelPane = new JPanel();
	SubInfoLabelPane.setBounds(17, 367, 72, 74);
	BackgroundPane.add(SubInfoLabelPane);
	SubInfoLabelPane.setLayout(new GridLayout(0, 1, 5, 5));

	joinEmailLabel = new JLabel("E-Mail");
	joinEmailLabel.setHorizontalTextPosition(SwingConstants.LEFT);
	joinEmailLabel.setHorizontalAlignment(SwingConstants.LEFT);
	SubInfoLabelPane.add(joinEmailLabel);

	joinHomeNumberLabel = new JLabel("\uC5F0\uB77D\uCC98(\uC9D1)");
	joinHomeNumberLabel.setHorizontalTextPosition(SwingConstants.LEFT);
	joinHomeNumberLabel.setHorizontalAlignment(SwingConstants.LEFT);
	SubInfoLabelPane.add(joinHomeNumberLabel);

	SubInfoInputPane2 = new JPanel();
	SubInfoInputPane2.setBounds(305, 367, 156, 74);
	BackgroundPane.add(SubInfoInputPane2);
	SubInfoInputPane2.setLayout(new GridLayout(0, 1, 5, 5));

	jobComboBox = new JComboBox();
	jobComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	SubInfoInputPane2.add(jobComboBox);

	joinHpTf = new JTextField();
	SubInfoInputPane2.add(joinHpTf);
	joinHpTf.setColumns(10);

	joinAdressLabelPane = new JPanel();
	joinAdressLabelPane.setBounds(17, 443, 72, 35);
	BackgroundPane.add(joinAdressLabelPane);
	joinAdressLabelPane.setLayout(new GridLayout(0, 1, 0, 0));

	joinAdressLabel = new JLabel("\uC8FC\uC18C");
	joinAdressLabelPane.add(joinAdressLabel);

	JoinAdressPane = new JPanel();
	JoinAdressPane.setBounds(91, 443, 370, 35);
	BackgroundPane.add(JoinAdressPane);
	JoinAdressPane.setLayout(new GridLayout(0, 1, 0, 0));

	joinAdressTf = new JTextField();
	JoinAdressPane.add(joinAdressTf);
	joinAdressTf.setColumns(10);

	joinCloseBtn.addActionListener(listener);
	joinConfirmBtn.addActionListener(listener);
	overCheckBtn.addActionListener(listener);
	maleRadio.addActionListener(listener);
	femaleRadio.addActionListener(listener);

	// this.setLocationRelativeTo(null);
    }

    public void checkIdFalseDialog() {
	JOptionPane.showMessageDialog(this, "중복된 아이디입니다.", "아이디중복확인", JOptionPane.WARNING_MESSAGE);

    }

    public void checkIdTrueDialog() {
	JOptionPane.showMessageDialog(this, "사용할 수 있는 아이디입니다.", "아이디중복확인", JOptionPane.WARNING_MESSAGE);

    }

    public void checkIdCheckDialog() {
	JOptionPane.showMessageDialog(this, "아이디 중복확인 해주세요.", "아이디중복확인", JOptionPane.WARNING_MESSAGE);

    }

    public void joinFailDialog() {
	JOptionPane.showMessageDialog(this, "회원가입에 실패했습니다.", "회원가입 실패", JOptionPane.WARNING_MESSAGE);

    }
}