import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class forget implements ActionListener
{
	JFrame jf = new JFrame("Forget Password");
	JLabel jl = new JLabel("Enter DOB");
	JLabel jl2 = new JLabel("Enter Contact No.");
	JLabel jl4 = new JLabel("Enter first name");
	JTextField jt = new JTextField();
	JTextField jt2 = new JTextField();
	JTextField jt3 = new JTextField();
	JButton jb = new JButton("Show Password");
	JButton jb2 = new JButton("Change Password");
	forget()
	{
		jf.setLayout(null);
		jf.setSize(1366,854);
		jf.setVisible(true);
		jf.add(jl);
		jf.add(jl2);
		jf.add(jl4);
		jf.add(jt);
		jf.add(jt2);
		jf.add(jt3);
		jf.add(jb);
		jf.add(jb2);
		jl.setForeground(Color.green);
		jl2.setForeground(Color.green);
		jl.setBounds(200,200,100,30);
		jl2.setBounds(200,250,100,30);
		jl4.setBounds(200,300,100,30);
		jt.setBounds(320,195,200,30);
		jt2.setBounds(320,245,200,30);
		jt3.setBounds(320,295,200,30);
		jb.setBounds(200,370,150,30);
		jb2.setBounds(370,370,150,30);
		jb.addActionListener(this);
		jb2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == jb)
		{
			try 
			{
				String t1 = jt.getText();
				String t2 = jt2.getText();
				String t3 = jt3.getText();
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","root");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select date from register where contact = '"+t2+"' and fname = '"+t3+"'");
				while(rs.next())
				{
					if(rs.getString(1).compareTo(t1) == 0)
					{
						try 
						{
							Class.forName("com.mysql.jdbc.Driver");
							Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","root");
							Statement s = c.createStatement();
							ResultSet r = s.executeQuery("select password from register where date = '"+t1+"' and fname = '"+t3+"'");
							while(r.next())
							{	
								JLabel jl3 = new JLabel(r.getString(1));
								jf.add(jl3);
							 	jl3.setBounds(280,400,150,30);
							}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
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
				e1.printStackTrace();
			}
		}
		else if (ae.getSource() == jb2)
		{
			jf.setVisible(false);
			new change();
		}
	}
}
