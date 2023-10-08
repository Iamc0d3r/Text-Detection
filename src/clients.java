import java.awt.EventQueue;
import java.io.*;
import java.net.*;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.TextArea;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class clients {

	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;

	private JFrame jf;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction();
	private final Action action_2 = new SwingAction_1();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	 static TextArea area = new TextArea();
	 static String msgin="";

	/**
	 * Launch the application.
	 */
	 public void connect()
		{
		try
		{
			 msgin = din.readUTF();
				area.setText(area.getText().trim()+"\n Server:\t"+msgin);
		}
		catch(Exception e1)
		{
			
		}
		}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						clients window = new clients();
						window.jf.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public clients() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jf = new JFrame();
		jf.setBackground(Color.WHITE);
		jf.setBounds(100, 100, 698, 493);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		jf.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton jb = new JButton("SEND");
		jb.setBackground(new Color(153, 255, 255));
		jb.setForeground(Color.BLACK);
		jb.setBounds(290, 411, 230, 30);
		panel.add(jb);
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jb)
				{
					try
					{ 
						clients ob = new clients();
						while(!msgin.equals("exit"))
						{	
							 s = new Socket("127.0.0.1",1201);
							 din = new DataInputStream(s.getInputStream());
							 dout = new DataOutputStream(s.getOutputStream());
							ob.connect();	
						}
						String msgout="";
						dout.writeUTF(msgout);
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
				}
					 }
		});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 682, 22);
		panel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("MENU");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("CONNECT");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("See USERS");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("HELP");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("CANVASS OPTIONS");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Show Canvass");
		mntmNewMenuItem_3.setAction(action_2);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == mntmNewMenuItem_3)
				{
					new canvass();
				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Clean Canvass");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Hide Canvass");
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JButton btnNewButton = new JButton("END CHAT");
		btnNewButton.setBackground(new Color(102, 153, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(10, 411, 230, 30);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 153, 255));
		panel_1.setBounds(535, 28, 137, 376);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Connection Settings");
		lblNewLabel_1.setForeground(new Color(153, 0, 0));
		lblNewLabel_1.setBounds(10, 11, 117, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("IP Address");
		lblNewLabel_2.setBounds(10, 169, 117, 14);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(10, 186, 117, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 235, 117, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("PORT");
		lblNewLabel_3.setBounds(10, 217, 46, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("USERS");
		lblNewLabel_4.setBounds(10, 266, 46, 14);
		panel_1.add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 286, 117, 79);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_5 = new JLabel("USERNAME");
		lblNewLabel_5.setBounds(10, 36, 117, 14);
		panel_1.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 53, 117, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("PASSWORD");
		lblNewLabel_6.setBounds(10, 84, 117, 14);
		panel_1.add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("SUBMIT");
		btnNewButton_1.setBounds(20, 135, 89, 23);
		panel_1.add(btnNewButton_1);
		
		
		
		area.setBounds(10, 46, 510, 188);
		panel.add(area);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 104, 117, 20);
		panel_1.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Enter Text Here");
		lblNewLabel.setForeground(new Color(102, 51, 51));
		lblNewLabel.setBackground(new Color(0, 153, 255));
		lblNewLabel.setBounds(20, 240, 114, 14);
		panel.add(lblNewLabel);
		
		JSlider slider = new JSlider();
		slider.setBounds(535, 415, 137, 26);
		panel.add(slider);
		
		JTextField jtf = new JTextField();
		jtf.setBounds(10, 264, 510, 113);
		panel.add(jtf);
		jtf.setColumns(10);
		
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			//putValue(NAME, "SEND");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Show Canvass");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
				{}
			}
		}
	}

