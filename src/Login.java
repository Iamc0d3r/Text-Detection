import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Login implements ActionListener
{
	JFrame jf = new JFrame();
	JLabel jl = new JLabel("EMAIL_ID");
	JLabel jl2 = new JLabel("PASSWORD");
	ImageIcon ii = new ImageIcon("1.png");
	JLabel jl3 = new JLabel("",ii,JLabel.CENTER);
	JTextField jtf = new JTextField();
	JTextField jtf2 = new JTextField();
	JButton jb = new JButton("L O G I N");
	JButton jb2 = new JButton("NEW USER");
	JButton jb3 = new JButton("F O R G E T");
	Login()
	{
		jf.setLayout(null);
		jf.setSize(940,571);
		jf.setVisible(true);
		jf.add(jl);
		jf.add(jl2);
		jf.add(jtf);
		jf.add(jtf2);
		jf.add(jb);
		jf.add(jb2);
		jf.add(jb3);
		jf.add(jl3);
		jl.setBounds(300,100,100,50);
		jl2.setBounds(300,150,100,50);
		jl3.setBounds(0,0,940,571);
		jtf.setBounds(400,109,200,30);
		jtf2.setBounds(400,159,200,30);
		jb.setBounds(350,220,150,30);
		jb2.setBounds(200,270,150,30);
		jb3.setBounds(400,270,150,30);
		jb.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jl.setForeground(Color.green);
		jl2.setForeground(Color.green);
	}
	public void actionPerformed(ActionEvent ae2)
	{
		if(ae2.getSource() == jb2)
		{
			new regi();
		}
		else if(ae2.getSource() == jb3)
		{
			new forget();
		}
		else if(ae2.getSource() == jb)
		{
				
			try 
			{
				String t1 = jtf.getText();
				String t2 = jtf2.getText();
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","root");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select password from register where email = '"+t1+"'");
				while(rs.next())
				{	
					if(rs.getString(1).compareTo(t2) == 0)
					{
						jf.setVisible(false);
						new clients();
					}
					else
					{
						System.out.println("Wrong pasword");
					}
				}
				rs.close();
				st.close();
				con.close();
			}
			catch(Exception e1)
			{
				
			}
		}	
	}
}	