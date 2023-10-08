import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class addd implements ActionListener
{
	JFrame jf = new JFrame();
	ImageIcon i = new ImageIcon("r.png");
	JLabel jl = new JLabel ("",i,JLabel.CENTER);
	JButton jb = new JButton("Add new USER");
	JButton jb2 = new JButton("Login");
	
	addd()
	{
		jf.setLayout(null);
		jf.setSize(350,600);
		jf.setUndecorated(true);
		jf.setVisible(true);
		jf.add(jb);
		jf.add(jb2);
		jf.add(jl);
		jb.setBounds(50,500,250,30);
		jb2.setBounds(50,550,250,30);
		jl.setBounds(0,0,350,600);
		jb.addActionListener(this);
		jb2.addActionListener(this);
	}	
		
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource() == jb)
			{
				jf.setVisible(false);
				new regi();
			}
			else if(ae.getSource() == jb2)
			{
				jf.setVisible(false);
				new Login();
			}
		}
		
	}