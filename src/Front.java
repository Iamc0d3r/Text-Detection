import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class First implements ActionListener
{
	JFrame jf = new JFrame();
	ImageIcon i = new ImageIcon("3.jpg");
	JLabel jl = new JLabel("",i,JLabel.CENTER);
	JButton jb = new JButton();
	
	First()
	{
		jf.setLayout(null);
		jf.setUndecorated(true);
		jf.setSize(350,593);
		jf.setVisible(true);
		jf.add(jl);
		jl.setBounds(0,0,350,593);
		jf.add(jb);
		jb.setBounds(0,0,350,593);
		jb.setOpaque(false);
		jb.addActionListener(this);
	}
	 public static void main (String args[])throws Exception
	{
		new First();
	}
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource() == jb)
		{
			jf.setVisible(false);
			new addd();
		}
	}
}