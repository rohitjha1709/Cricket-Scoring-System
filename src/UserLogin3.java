import javax.swing.*;
// import javax.swing.border.Border;

// import java.awt.*;
import java.sql.*;
// import java.util.ArrayList;

import java.awt.Color;
// import java.awt.Font;
import java.awt.event.*;
 class UserLogin3 extends Register3  {

    String data; 
    JFrame loginframe; JButton loginbutton; JLabel username;JTextField userText;
    JButton exitbutton; JLabel password; JPasswordField passtext;

    UserLogin3() {
      System.out.println("userlogin3 is exctued the constructwer");
    }
    public void Userlogin () throws Exception
    {
        loginframe = new JFrame("LOGIN FORM");

        loginbutton = new JButton("LOGIN");
        username = new JLabel("Enter PlayerName");
        userText = new JTextField();
        exitbutton = new JButton("EXIT");
        password = new JLabel("Enter Password");
        passtext = new JPasswordField();

        
        username.setBounds(30, 50, 150, 30);
        userText.setBounds(190, 50, 150, 30);
        
        password.setBounds(30, 100, 150, 30);
        passtext.setBounds(190, 100, 150, 30);

        loginbutton.setBounds(30, 150, 150, 30);
        exitbutton.setBounds(200, 150, 150, 30);
        
        loginbutton.addActionListener(this);

        exitbutton.addActionListener(this);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(new Color(150,150,150));
        loginPanel.setBounds(0,0,500,300);
        
        

        loginPanel.add(userText);loginPanel.add(username);
        loginPanel.add(password);loginPanel.add(passtext);
        loginPanel.add(loginbutton);loginPanel.add(exitbutton);
        // loginframe.add(userText);loginframe.add(username);

        loginframe.add(loginPanel);

        loginframe.setSize(500, 300);
        loginframe.setLayout(null);
        loginframe.setVisible(true);
        loginframe.setLocationRelativeTo(null);
        loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void checkUser(String playerName,String playerPassword){
        String selectQuery = "SELECT PlayerName, Password from PlayerDetails WHERE PlayerName = '"+playerName+"'";
        String nameData = "";String passwdData = "";
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject?" +
                "user=root&password=rohitjha");
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(selectQuery);
        
                rs.next();
                nameData = rs.getString(1);passwdData = rs.getString(2);
                if(playerName.equals(nameData) && playerPassword.equals(passwdData)){
                    System.out.println("Welcome to the Homepage");
                   StartAMatch3 obn2 = new StartAMatch3();
                   obn2.startmatch();
                    loginframe.dispose();
                } else {
                    System.out.println("Incorrect Username/Password");
                }
                conn.close();
        } catch (SQLException e) {
            System.out.println("User Not registered");   
        }
    }
    
    public static void main(String[] args) {
    //  UserLogin3 obj2  = new UserLogin3();
    Register3 obj11 = new Register3() ;
     try {
         obj11.RegisterA();
        // obj2.Userlogin();
    } catch (Exception e) {
        
        
        e.printStackTrace();
    }
     }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginbutton){
            // data = "Username " + userText.getText();
            // data =  data + ",Password: "+ new String(passtext.getPassword());
            // System.out.println(data);
            checkUser(userText.getText(),new String(passtext.getPassword()));
        }

        if (e.getSource() == exitbutton){
            loginframe.dispose();
        }
        
    }
}
//------------------------------------------------------------------------------------------

//------------------------------------------------------------------------------------------
