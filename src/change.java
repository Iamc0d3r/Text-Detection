import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
class change implements ActionListener
{
	JFrame jf = new JFrame("Change Password");
	JLabel jl = new JLabel("First Name");
	JLabel jl2 = new JLabel("Last Name");
	JLabel jl3 = new JLabel("Contact");
	JLabel jl4 = new JLabel("New Password");
	JLabel jl5= new JLabel("Confirm Password`");
	JTextField jt = new JTextField();
	JTextField jt2 = new JTextField();
	JTextField jt3 = new JTextField();
	JTextField jt4 = new JTextField();
	JTextField jt5 = new JTextField();
	JButton jb = new JButton("CONFIRM");
	
	change()
	{
		jf.setLayout(null);
		jf.setSize(1366,854);
		jf.setVisible(true);
		jf.add(jl);
		jf.add(jl2);
		jf.add(jl3);
		jf.add(jl4);
		jf.add(jl5);
		jf.add(jt);
		jf.add(jt2);
		jf.add(jt3);
		jf.add(jt4);
		jf.add(jt5);
		jf.add(jb);
		jl.setBounds(200,200,100,30);
		jl2.setBounds(200,250,100,30);
		jl3.setBounds(200,300,100,30);
		jl4.setBounds(200,350,100,30);
		jl5.setBounds(200,400,100,30);
		jt.setBounds(320,195,200,30);
		jt2.setBounds(320,245,200,30);
		jt3.setBounds(320,295,200,30);
		jt4.setBounds(320,345,200,30);
		jt5.setBounds(320,395,200,30);
		jb.setBounds(200,450,150,30);
		jb.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource() == jb)
		{
			try 
			{
				String t1 = jt.getText();
				String t2 = jt2.getText();
				String t3 = jt3.getText();
				String t4 = jt4.getText();
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","root");
				Statement st = con.createStatement();
				String g = ("update register set password = '"+t4+"' where fname = '"+t1+"' and lname = '"+t2+"' and contact = '"+t3+"'");
				int c = st.executeUpdate(g);
				st.close();
				con.close();
				jf.setVisible(false);
				new Login();
			}
			catch(Exception e1)
			{
				
			}
		}
	}
}