package com.kitri.user.login;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kitri.user.dto.UserInfoDto;
import com.kitri.user.join.UserJoin;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.JButton;

public class UserLogin extends JFrame {

	private JPanel contentPane;
	public JTextField pwTf;
	private JPanel EmptyPane;
	private JPanel EmptyPane1;
	private JPanel UserMainComPane;
	public JButton joinBtn;
	private JPanel BottomBackgrounPane;
	private JPanel BackgroundCentPane;
	private JPanel NorthEmptyPane;
	private JPanel BottomEmptyPane1;
	private JPanel WestEmptyPane;
	private JLabel emptyLabel;
	private JLabel emptyLabel1;
	private JPanel EastEmptyPane;
	private JLabel emptyLabel2;
	private JPanel LoginLabePane;
	private JLabel label;
	private JLabel label_1;
	private JPanel LoginInputPane;
	public JTextField idTf;
	public JButton loginBtn;
	private JLabel emptyLabel9;
	private JLabel emptyLabel8;
	private JLabel emptyLabel5;
	private JLabel emptyLabel4;
	private JLabel emptyLabel6;
	private JLabel emptyLabel7;
	private JLabel emptyLabel_1;
	public JTextField mainComNum;
	public UserLoginListener listener;
	
	public UserJoin join;
	public UserInfoDto dto;
	

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
		join = new UserJoin();
		listener = new UserLoginListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(join);
		
		NorthEmptyPane = new JPanel();
		contentPane.add(NorthEmptyPane, BorderLayout.NORTH);
		NorthEmptyPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		emptyLabel =  new JLabel("         ");
		emptyLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		NorthEmptyPane.add(emptyLabel);
		
		BottomEmptyPane1 = new JPanel();
		contentPane.add(BottomEmptyPane1, BorderLayout.SOUTH);
		
		emptyLabel_1 =  new JLabel("         ");
		BottomEmptyPane1.add(emptyLabel_1);
		
		WestEmptyPane = new JPanel();
		contentPane.add(WestEmptyPane, BorderLayout.WEST);
		
		emptyLabel1 =  new JLabel("         ");
		WestEmptyPane.add(emptyLabel1);
		
		EastEmptyPane = new JPanel();
		contentPane.add(EastEmptyPane, BorderLayout.EAST);
		
		emptyLabel2 = new JLabel("         ");
		EastEmptyPane.add(emptyLabel2);
		
		BackgroundCentPane = new JPanel();
		contentPane.add(BackgroundCentPane, BorderLayout.CENTER);
		BackgroundCentPane.setLayout(new BorderLayout(0, 0));
		
		BottomBackgrounPane = new JPanel();
		BackgroundCentPane.add(BottomBackgrounPane, BorderLayout.SOUTH);
		BottomBackgrounPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		LoginLabePane = new JPanel();
		BottomBackgrounPane.add(LoginLabePane);
		LoginLabePane.setLayout(new GridLayout(2, 2, 0, 0));
		
		emptyLabel4 = new JLabel("");
		LoginLabePane.add(emptyLabel4);
		
		label = new JLabel("ID");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		LoginLabePane.add(label);
		
		emptyLabel5 = new JLabel("");
		LoginLabePane.add(emptyLabel5);
		
		label_1 = new JLabel("Password");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		LoginLabePane.add(label_1);
		
		LoginInputPane = new JPanel();
		BottomBackgrounPane.add(LoginInputPane);
		LoginInputPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		idTf = new JTextField();
		LoginInputPane.add(idTf);
		idTf.setColumns(10);
		
		emptyLabel6 = new JLabel("");
		LoginInputPane.add(emptyLabel6);
		
		pwTf = new JTextField();
		pwTf.setColumns(10);
		LoginInputPane.add(pwTf);
		
		emptyLabel7 = new JLabel("");
		LoginInputPane.add(emptyLabel7);
		
		EmptyPane = new JPanel();
		BottomBackgrounPane.add(EmptyPane);
		EmptyPane.setLayout(new GridLayout(1, 2, 0, 0));
		
		emptyLabel8 = new JLabel("");
		EmptyPane.add(emptyLabel8);
		
		joinBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		EmptyPane.add(joinBtn);
		
		
		EmptyPane1 = new JPanel();
		BottomBackgrounPane.add(EmptyPane1);
		EmptyPane1.setLayout(new GridLayout(1, 2, 0, 0));
		
		loginBtn = new JButton("\uB85C\uADF8\uC778");
		EmptyPane1.add(loginBtn);
		
		emptyLabel9 = new JLabel("");
		EmptyPane1.add(emptyLabel9);
		
		UserMainComPane = new JPanel();
		FlowLayout fl_UserMainComPane = (FlowLayout) UserMainComPane.getLayout();
		fl_UserMainComPane.setVgap(50);
		fl_UserMainComPane.setHgap(50);
		BackgroundCentPane.add(UserMainComPane, BorderLayout.WEST);
		
		mainComNum = new JTextField();
		mainComNum.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		mainComNum.setEditable(false);
		mainComNum.setHorizontalAlignment(SwingConstants.CENTER);
		mainComNum.setText("PC1");
		UserMainComPane.add(mainComNum);
		mainComNum.setColumns(10);
		
		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = environment.getDefaultScreenDevice();
		this.setUndecorated(true);
		device.setFullScreenWindow(this);
		   
		joinBtn.addActionListener(listener);
	}

}
