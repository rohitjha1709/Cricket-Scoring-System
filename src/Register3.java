import javax.swing.*;
// import javax.swing.border.Border;

// import java.awt.*;
import java.sql.*;
// import java.util.ArrayList;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

// import java.awt.event.ActionListener;
// import java.awt.event.ActionEvent;
// import javax.swing.border.Border; 

public class Register3 implements MouseListener, WindowListener, ActionListener, KeyListener {
    int lastplayerID = 0;
    Connection conn;

    JFrame f11;
    JLabel pid, pname, city, phno, passwd;
    JTextField t1, t2, t3, t4, t5;
    JButton reg, exit, login;

    Register3() {
        System.out.println("Register3 constructor executed");
    }

    public void RegisterA() throws Exception {
        f11 = new JFrame("Registration Form");
        f11.addWindowListener(this);
        pid = new JLabel("Player ID");
        pid.setBounds(50, 100, 100, 30);
        // borderThemAll(pid);

        pname = new JLabel("Player Name");
        pname.setBounds(50, 160, 100, 30);
        // borderThemAll(pname);

        passwd = new JLabel("Password");
        passwd.setBounds(50, 220, 100, 30);
        // borderThemAll(city);

        phno = new JLabel("Phone no");
        phno.setBounds(50, 280, 100, 30);
        // borderThemAll(phno);

        city = new JLabel("City");
        city.setBounds(50, 340, 100, 30);

        t1 = new JTextField("Player ID");
        t1.setBounds(200, 100, 180, 30);
        // t1.addMouseListener(this);

        t2 = new JTextField("Player Name");
        t2.setBounds(200, 160, 180, 30);
        t2.addMouseListener(this);

        t3 = new JTextField("password");
        t3.setBounds(200, 220, 180, 30);
        t3.addMouseListener(this);

        t4 = new JTextField("Phone No");
        t4.setBounds(200, 280, 180, 30);
        t4.addMouseListener(this);
        t4.addKeyListener(this);

        t5 = new JTextField("City");
        t5.setBounds(200, 340, 180, 30);
        t5.addMouseListener(this);

        reg = new JButton("Register");
        reg.setBounds(30, 430, 100, 35);
        reg.addActionListener(this);

        exit = new JButton("Exit");
        exit.setBounds(150, 430, 100, 35);
        exit.addActionListener(this);

        login = new JButton("Already registered?");
        login.setBounds(270, 430, 150, 35);
        login.addActionListener(this);

        JPanel regPanel = new JPanel();
        regPanel.setLayout(null);
        regPanel.setBackground(new Color(150, 150, 150));
        regPanel.setBounds(0, 0, 450, 600);

        regPanel.add(pid);
        regPanel.add(pname);
        regPanel.add(phno);
        regPanel.add(city);
        regPanel.add(t1);
        regPanel.add(t2);
        regPanel.add(t3);
        regPanel.add(t4);
        regPanel.add(reg);
        regPanel.add(exit);
        regPanel.add(passwd);
        regPanel.add(t5);
        regPanel.add(login);
        f11.add(regPanel);

        f11.setSize(450, 600);
        f11.setLayout(null);
        f11.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f11.setVisible(true);
        f11.setLocationRelativeTo(null);
        f11.setResizable(false);

    }

    /*
     * public void borderThemAll(JLabel obj){
     * Border border= BorderFactory.createLineBorder(Color.BLACK);
     * obj.setBorder(border);
     * }
     */

    public void getRows() throws Exception {
        String query = "SELECT COUNT(*) AS rowcount FROM PlayerDetails ";

        String selectPlayerID = "SELECT PlayerID FROM PlayerDetails ORDER BY PlayerID ASC";
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject?" +
                "user=root&password=rohitjha");
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(query);
        rs.next();
        int count = rs.getInt("rowcount");
        System.out.println("My table has " + count + " rows");
        rs.close();
        ResultSet rs2 = st.executeQuery(selectPlayerID);
        while (rs2.next()) {
            lastplayerID = rs2.getInt(1);
        }
        // for(int i = 0; i < count; i++ ){
        // rs2.next();
        // lastplayerID = rs2.getInt(1);
        // }
        System.out.println("Last Player's ID is " + lastplayerID);

        rs2.close();
        st.close();
        conn.close();
    }

    public void register3PlayerDetails(int id, String name, String passwd, String phno, String city) throws Exception {

        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject?" +
                "user=root&password=rohitjha");        
        
        String insertQuery = "INSERT INTO PlayerDetails VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);

        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, passwd);
        preparedStatement.setString(4, phno);
        preparedStatement.setString(5, city);

        int countRowsAffected = preparedStatement.executeUpdate();
        System.out.println(countRowsAffected + " row/s affected");

        conn.close();
        preparedStatement.close();
    }

    public static void main(String[] args) {
        try {
            Register3 obj = new Register3();
            obj.RegisterA();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Integer mouseClickCnt = 0;
    Integer mouseClickCnt2 = 0;
    Integer mouseClickCnt3 = 0;
    Integer mouseClickCnt4 = 0;

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == t2) {
            if (mouseClickCnt == 0) {
                t2.setText("");
                mouseClickCnt += 1;
            }
        }
        if (e.getSource() == t3) {
            if (mouseClickCnt2 == 0) {
                t3.setText("");
                mouseClickCnt2 += 1;
            }
        }
        if (e.getSource() == t4) {
            if (mouseClickCnt3 == 0) {
                t4.setText("");
                mouseClickCnt3 += 1;
            }
        }
        if (e.getSource() == t5) {
            if (mouseClickCnt4 == 0) {
                t5.setText("");
                mouseClickCnt4 += 1;
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowOpened(WindowEvent e) {

        System.out.println("Window Opened");
        try {
            getRows();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        t1.setText("" + (lastplayerID + 1));
        t1.setEnabled(false);
        t1.setFont(new Font("Calibri", Font.BOLD, 14));
        t1.setForeground(Color.BLACK);
    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reg) {
            System.out.println("Wait ...");
            if (!(((t2.getText().trim()).equals("Player Name")) || ((t3.getText().trim()).equals("password"))
                    || ((t4.getText().trim()).equals("Phone No")) || ((t5.getText().trim()).equals("City"))
                    || ((t2.getText().trim()).equals("")) || ((t3.getText().trim()).equals(""))
                    || ((t4.getText().trim()).equals("")) || ((t5.getText().trim()).equals("")))) {
                try {
                    register3PlayerDetails(Integer.parseInt(t1.getText()), t2.getText(), t3.getText(), t4.getText(),
                            t5.getText());
                    System.out.println("Registered Succesfully");
                    // UserLogin3 ob30 = new UserLogin3();
                    // ob30.Userlogin();
                    f11.dispose();
                } catch (Exception e1) {
                    System.out.println("This username already exists, try some other name");
                    t2.setText("");
                    t2.setFocusable(true);
                }

            } else {
                System.out.println("Registration not done ..please fill the form properly");
            }
        }

        if (e.getSource() == exit) {
            f11.dispose();
        }

        if (e.getSource() == login) {
            System.out.println("Ithar issue hai");
            // UserLogin3 ob30 = new UserLogin3();
            try {
                // ob30.Userlogin();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            f11.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == t4) {
            String phoneNumber = t4.getText();
            int length = phoneNumber.length();

            // char c = evt.getKeyChar();
            if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                if (length < 10) {
                    t4.setEditable(true);
                } else {
                    t4.setEditable(false);
                }
            } else {
                if (e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                    t4.setEditable(true);
                } else {
                    t4.setEditable(false);
                }
            }
        }

    }

    @Override

    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}