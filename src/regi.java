import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class regi implements ActionListener
{
		JFrame jf = new JFrame("REGISTRATION");
		JLabel jl = new JLabel("First Name -");
		ImageIcon ii = new ImageIcon("login.jpg");
	    JLabel jl7 = new JLabel("",ii,JLabel.CENTER);
		JLabel jl2 = new JLabel("Last Name -");
		JLabel jl3 = new JLabel("D.O.B. -");
		JLabel jl4 = new JLabel("E Mail -");
		JLabel jl5 = new JLabel("Password -");
		JLabel jl8 = new JLabel("Confirm Pass -");
		JLabel jl6 = new JLabel("Contact No. -");
		JTextField jtf = new JTextField();
		JTextField jtf2 = new JTextField();
		JTextField jtf3 = new JTextField();
		JTextField jtf4 = new JTextField();
		JTextField jtf5 = new JTextField();
		JTextField jtf6 = new JTextField();
		JTextField jtf8 = new JTextField();
		JButton jb = new JButton("S U B M I T");
	
	regi()
	{
		jf.setLayout(null);
		jf.setSize(400,550);
		//jf.setUndecorated(true);
		jf.setVisible(true);
		jf.add(jl);
		jf.add(jl2);
		jf.add(jl3);
		jf.add(jl4);
		jf.add(jl5);
		jf.add(jl6);
		jf.add(jl7);
		jf.add(jl8);
		jf.add(jtf);
		jf.add(jtf2);
		jf.add(jtf3);
		jf.add(jtf4);
		jf.add(jtf5);
		jf.add(jtf6);
		jf.add(jtf8);
		jf.add(jb);
		jl.setBounds(20,50,100,40);
		jl2.setBounds(20,100,100,40);
		jl3.setBounds(20,150,100,40);
		jl4.setBounds(20,200,100,40);
		jl5.setBounds(20,250,100,40);
		jl6.setBounds(20,300,100,40);
		jl8.setBounds(20,350,100,40);
		jtf.setBounds(150,50,200,40);
		jtf2.setBounds(150,100,200,40);
		jtf3.setBounds(150,150,200,40);
		jtf4.setBounds(150,200,200,40);
		jtf5.setBounds(150,250,200,40);
		jtf6.setBounds(150,300,200,40);
		jtf8.setBounds(150,350,200,40);
		jb.setBounds(70,450,250,40);
		jb.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String t11 = jtf5.getText();
		String t12 = jtf8.getText();
		if(t11.compareTo(t12) == 0)
		{
		if(ae.getSource() == jb)
		{
			try {
				String t1 = jtf.getText();
				String t2 = jtf2.getText();
				String t3 = jtf3.getText();
				String t4 = jtf4.getText();
				String t5 = jtf5.getText();
				String t6 = jtf6.getText();
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","root");
				Statement st = con.createStatement();
				String g = "insert into register values('"+t1+"','"+t2+"','"+t3+"','"+t4+"','"+t5+"','"+t6+"')";
				int c = st.executeUpdate(g);
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}	
			jf.setVisible(false);
			new Login();
		}
	}
	}
}	
	
