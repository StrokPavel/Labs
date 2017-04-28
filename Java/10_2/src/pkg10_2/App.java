package pkg10_2;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class App extends JFrame {

    eHandler handler = new eHandler();
    public Object event;
    public static String s = "";
    public static String[][] mas = new String[100][100];
    //public static String [] mas1 = new String[100];
    JLabel label2, label3, label4, label5,label6;
    JButton b1, b2, b3, b4;
    JTextField t1, t2, t3, t4;
    ArrayList L1 = new ArrayList();
    LinkedList L2 = new LinkedList();
    LinkedList L3 = new LinkedList();
    App(String name) {
        super(name);
        setLayout(null);
        t3 = new JTextField(); 
        t3.setBounds(100, 150, 100, 30); 
	add(t3);
        t4 = new JTextField(); 
        t4.setBounds(300, 150, 100, 30); 
	add(t4);
        t2 = new JTextField("");
        t2.setBounds(100, 240, 300, 30);
        add(t2);
        b1 = new JButton("Результат работы ");
        b1.setBounds(100, 200, 100, 30);
        add(b1);
        b3 = new JButton("Выход ");
        b3.setBounds(100, 50, 250, 50);
        add(b3);
        b1.addActionListener(handler);
        b3.addActionListener(handler);
        setSize(500, 330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public class eHandler extends JFrame implements ActionListener {
        private String work() throws FileNotFoundException, IOException {
            Scanner in = new Scanner(new File("L1.txt"));
            Scanner sc = new Scanner(new File("L2.txt"));
           
            while(in.hasNext()){
            L1.add(in.nextLine());
            t3.setText(L1.toString());
             L1.sort(null);
            }
            while (sc.hasNext()) {
                L2.add(sc.nextLine());
                t4.setText(L2.toString());
                L2.sort(null);
            }
            
            
           L3.addAll(L1);
           L3.addAll(L2);
           L3.sort(null);
            
                s=L3.toString();
            return s;
        }
        @Override
        public void actionPerformed(ActionEvent e)  {
            // TODO Auto-generated method stub
           // try {
            
                if (e.getSource() == b1) {                  
                    try { 
                        t2.setText(work());
                    } catch (IOException ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                if (e.getSource() == b2) {
                    t1.setText(null);
                    

                }
                if (e.getSource() == b3) {
                    System.exit(0);

                }

          //  } catch (Exception ex) {
          //      JOptionPane.showMessageDialog( "enter number");
           // }
        }

        

    }
}
