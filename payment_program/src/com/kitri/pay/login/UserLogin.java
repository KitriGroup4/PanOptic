package com.kitri.pay.login;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UserLogin extends JInternalFrame {

    private JPanel BackgroundPane;
    private JPanel LoginContentPane;
    private JPanel LoginLabelPane;
    private JLabel loginIdLable;
    private JLabel loginPwLabel;
    private JPanel LoginInputPane;
    public JTextField loginIdTf;
    public JTextField loginPwTf;
    private JPanel LoginButnPane;
    public JButton closeButton;
    public JButton loginBtn;
    private JLabel LoginTilteLabel;

    private UserLoginListener listener;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    UserLogin frame = new UserLogin();
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
    public UserLogin() {

	listener = new UserLoginListener(this);

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 355, 188);
	BackgroundPane = new JPanel();
	BackgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(BackgroundPane);
	BackgroundPane.setLayout(new BorderLayout(0, 0));

	LoginContentPane = new JPanel();
	BackgroundPane.add(LoginContentPane);
	LoginContentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

	LoginLabelPane = new JPanel();
	LoginContentPane.add(LoginLabelPane);
	LoginLabelPane.setLayout(new GridLayout(2, 0, 0, 0));

	loginIdLable = new JLabel("ID");
	loginIdLable.setHorizontalAlignment(SwingConstants.CENTER);
	LoginLabelPane.add(loginIdLable);

	loginPwLabel = new JLabel("Password");
	loginPwLabel.setHorizontalAlignment(SwingConstants.CENTER);
	LoginLabelPane.add(loginPwLabel);

	LoginInputPane = new JPanel();
	LoginContentPane.add(LoginInputPane);
	LoginInputPane.setLayout(new GridLayout(2, 1, 0, 0));

	loginIdTf = new JTextField();
	LoginInputPane.add(loginIdTf);
	loginIdTf.setColumns(10);

	loginPwTf = new JTextField();
	LoginInputPane.add(loginPwTf);
	loginPwTf.setColumns(10);

	LoginButnPane = new JPanel();
	LoginContentPane.add(LoginButnPane);
	LoginButnPane.setLayout(new GridLayout(1, 2, 0, 0));

	closeButton = new JButton("닫기");
	closeButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    }
	});
	LoginButnPane.add(closeButton);

	loginBtn = new JButton("\uB85C\uADF8\uC778");
	LoginButnPane.add(loginBtn);

	LoginTilteLabel = new JLabel("\uB85C\uADF8\uC778");
	LoginTilteLabel.setHorizontalAlignment(SwingConstants.CENTER);
	LoginTilteLabel.setFont(new Font("굴림", Font.PLAIN, 26));
	BackgroundPane.add(LoginTilteLabel, BorderLayout.NORTH);

	closeButton.addActionListener(listener);
	loginBtn.addActionListener(listener);

    }

    public void loginFailDialog() {
	JOptionPane.showMessageDialog(this, "로그인에 실패했습니다.", "로그인 실패", JOptionPane.WARNING_MESSAGE);

    }
}