import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.TreeUI;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.awt.event.*;

class StartAMatch3 implements ActionListener {
    JLabel img;
    JScrollPane jp;
    JPanel panel;
    JFrame frame;
    JButton button;
    JButton button1;

    StartAMatch3() {
    }

    public void startmatch() {

        frame = new JFrame("User Homepage");
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(150, 150, 150, 20));
        panel.setBounds(0, 0, 490, 450);

        button = new JButton("START A MATCH");
        button.setFont(new Font("Calibri", Font.BOLD, 14));
        button.setBounds(150, 280, 200, 40);
        button.setOpaque(true);
        button.setBorderPainted(true);
        button.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        button.setBackground(new Color(150, 150, 150, 20));
        button.addActionListener(this);
        panel.add(button);

        // button of highlights
        button1 = new JButton("Highlights");
         button1.setFont(new Font("Calibri", Font.BOLD, 14));
         button1.setBounds(150, 100, 200, 40);
        button1.setOpaque(true);
         button1.setBorderPainted(true);
         button1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
         button1.setBackground(new Color(150, 150, 150, 20));
        button1.addActionListener(this);
        panel.add(button1);
 
        img = new JLabel(new ImageIcon("D:\\Programs\\Java\\JavaProject\\CricketImg1.jpg"));
        jp = new JScrollPane();
        img.add(panel);
        jp.setViewportView(img);
        frame.add(jp);

        frame.setSize(510, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

    }

    // public static void main(String[] args) {
    // new StartAMatch3();
    // }
    @Override
    public void actionPerformed(ActionEvent e)
     {
        if (e.getSource() == button)
         {
            frame.dispose();
            

            AcceptTwoTeams ob011 = new AcceptTwoTeams();
            try 
            {
                ob011.acceeptwoteams2(true);
            } catch (Exception e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            // for button of highlight event
           
                    // System.out.println("hi");
                
                

            

        }
        if (e.getSource() == button1) 
        {
             frame.dispose();
             java.awt.EventQueue.invokeLater(new Runnable()
             {
            public void run() {
            new NewTable().setVisible(true);
            }
            });
        }  
         
           
        

    }
}
