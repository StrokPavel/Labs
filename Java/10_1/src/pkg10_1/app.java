package pkg10_1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class app extends JFrame
{
	JLabel Label1, Label2, Label3, Label4,Label5;
	JButton Button1, Button2;
	JTextField TextField1, TextField2, TextField3,TextField4;
	clic clicB = new clic();
	String s="";
	app(String name)
	{
		super(name);
		
		setLayout(null);


		Label1 = new JLabel("Введите исходные данные");
		Label1.setBounds(110, 5, 200, 15); 
		add(Label1); 

		Label2 = new JLabel("Введите a:");
		Label2.setBounds(15, 30, 100, 15); 
		add(Label2); 
		
		Label3 = new JLabel("Введите b:");
		Label3.setBounds(165, 30, 100, 15); 
		add(Label3); 
		
		Label4 = new JLabel("Введите h:");
		Label4.setBounds(305, 30, 100, 15); 
		add(Label4); 
		
		Button1 = new JButton("Расчитать"); 
		Button1.setBounds(10, 100, 110, 100); 
		add(Button1);
		Button1.addActionListener(clicB);
		
		Button2 = new JButton("Закончить работу"); 
		Button2.setBounds(10, 220, 150, 30); 
		add(Button2);
		Button2.addActionListener(clicB);

		TextField1 = new JTextField(); 
		TextField1.setBounds(5, 50, 100, 30);
		add(TextField1); 

		TextField2 = new JTextField(); 
		TextField2.setBounds(145, 50, 100, 30); 
		add(TextField2);
		
		TextField3 = new JTextField(); 
		TextField3.setBounds(290, 50, 100, 30); 
		add(TextField3); 

                TextField4 = new JTextField();
                TextField4.setBounds(150,160,150,40);
                add(TextField4);
                Label5 = new JLabel("Ответ:");
		Label5.setBounds(150,130,150,40); 
		add(Label5); 
                
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true); 

	}
	
	
	public class clic implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == Button1)
			{
			double a = Integer.parseInt(TextField1.getText());
			double b = Integer.parseInt(TextField2.getText());
			double c = Integer.parseInt(TextField3.getText());
			double k = ((0.2)*Math.PI)*c*(3*Math.pow(a, 2)+3*Math.pow(b, 2)+Math.pow(c, 2));
                        s=String.valueOf(k);
			TextField4.setText(s);
			}
			
			if(e.getSource() == Button2)
			{
				dispose();
			}
		}
		
	}
}
