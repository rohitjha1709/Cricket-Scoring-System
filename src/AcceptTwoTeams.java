import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

class AcceptTwoTeams implements ActionListener, KeyListener {
        int matchesPlayedCnt = 0;
        String inputDialoguePhNo;
        static String team1Name;
        static String team2Name;
        String gameTypeStr;
        static String ballTypeStr;
        static String venueStr;
        String whoWonTheToss;
        JFrame acceptTeamsFrame;
        JButton addTeams;
        JComboBox<String> cb1, cb2;
        JLabel team1, team2, gameType, ballType, venue;
        JTextField venueTextField;
        JRadioButton rb1, rb2, rb3, rb4; // to select game type
        JRadioButton tennisBall, leatherBall; // ball type
        JButton select, TOSS;
        static ArrayList<ArrayList<String>> teamA = new ArrayList<>(); // 2d arraylist
        static ArrayList<String> teamANames = new ArrayList<String>();
        static ArrayList<ArrayList<String>> teamB = new ArrayList<>();
        static ArrayList<String> teamBNames = new ArrayList<String>();

        // AcceptTwoTeams(boolean executeThisConstructor) {
        // System.out.println("accepttwoteams consturctor is executed");
        // }

        public void acceeptwoteams2(boolean executeThisConstructor) throws Exception {

                if (executeThisConstructor) {
                        acceptTeamsFrame = new JFrame("Accepting Two Teams");
                        cb1 = new JComboBox<>();
                        cb2 = new JComboBox<>();
                        team1 = new JLabel("Team A");
                        team2 = new JLabel("Team B");
                        addTeams = new JButton("ADD TEAMS");
                        // boldThemAll(addTeams);
                        addTeams.setBounds(230, 80, 110, 50);
                        addTeams.setOpaque(true);
                        addTeams.setBackground(new Color(200, 200, 200));
                        // addTeams.setEnabled(false);
                       
                        
                        team1.setBounds(20, 50, 150, 30);
                        team2.setBounds(400, 50, 150, 30);
                        cb1.setBounds(20, 80, 150, 30);
                        cb1.setBackground(new Color(200, 200, 200));
                        cb2.setBounds(400, 80, 150, 30);
                        cb2.setBackground(new Color(200, 200, 200));
                        addTeams.addActionListener(this);

                        gameType = new JLabel("Select Game Type");
                        gameType.setBounds(30, 170, 150, 30);
                        borderThemAll(gameType);

                        rb1 = new JRadioButton("5 Overs");
                        rb1.setBounds(30, 210, 100, 30);
                        rb1.setBackground(new Color(200, 200, 200));
                        rb2 = new JRadioButton("T10");
                        rb2.setBounds(150, 210, 100, 30);
                        rb2.setBackground(new Color(200, 200, 200));
                        rb3 = new JRadioButton("T20");
                        rb3.setBounds(270, 210, 100, 30);
                        rb3.setBackground(new Color(200, 200, 200));
                        rb4 = new JRadioButton("ODI");
                        rb4.setBounds(390, 210, 100, 30);
                        rb4.setBackground(new Color(200, 200, 200));
                        ButtonGroup bg = new ButtonGroup();
                        ButtonGroup bg2 = new ButtonGroup();
                        bg.add(rb1);
                        bg.add(rb2);
                        bg.add(rb3);
                        bg.add(rb4);

                        select = new JButton("Submit Details");
                        select.setBounds(410, 390, 150, 30);
                        select.setHorizontalAlignment(JButton.CENTER);
                        select.setOpaque(true);
                        select.setBackground(new Color(200, 200, 200));
                        select.addActionListener(this);

                        ballType = new JLabel("Select Ball Type");
                        ballType.setBounds(30, 280, 150, 30);
                        borderThemAll(ballType);

                        tennisBall = new JRadioButton("Tennis Ball");
                        tennisBall.setBounds(30, 320, 150, 30);
                        tennisBall.setBackground(new Color(200, 200, 200));

                        leatherBall = new JRadioButton("Leather Ball");
                        leatherBall.setBounds(200, 320, 150, 30);
                        leatherBall.setBackground(new Color(200, 200, 200));

                        bg2.add(tennisBall);
                        bg2.add(leatherBall);

                        venue = new JLabel("Select Venue");
                        venue.setBounds(30, 390, 150, 30);
                        borderThemAll(venue);

                        venueTextField = new JTextField("");
                        venueTextField.setBounds(190, 390, 200, 30);
                        venueTextField.setBackground(new Color(200, 200, 200));
                        boldThemAll(venueTextField);

                        TOSS = new JButton("TOSS");
                        TOSS.setBounds(170, 460, 100, 50);
                        TOSS.setEnabled(false);
                        TOSS.setOpaque(true);
                        TOSS.setBackground(new Color(200, 200, 200));
                        TOSS.addActionListener(this);

                        JPanel acceptTeamsPanel = new JPanel();
                        acceptTeamsPanel.setLayout(null);
                        acceptTeamsPanel.setBackground(new Color(150, 150, 150));
                        acceptTeamsPanel.setBounds(0, 0, 600, 600);

                        acceptTeamsPanel.add(addTeams);
                        acceptTeamsPanel.add(team1);
                        acceptTeamsPanel.add(team2);
                        acceptTeamsPanel.add(cb1);
                        acceptTeamsPanel.add(cb2);
                        acceptTeamsPanel.add(gameType);
                        acceptTeamsPanel.add(rb1);
                        acceptTeamsPanel.add(rb2);
                        acceptTeamsPanel.add(rb3);
                        acceptTeamsPanel.add(rb4);
                        acceptTeamsPanel.add(select);
                        acceptTeamsPanel.add(ballType);
                        acceptTeamsPanel.add(tennisBall);
                        acceptTeamsPanel.add(leatherBall);
                        acceptTeamsPanel.add(venue);
                        acceptTeamsPanel.add(venueTextField);
                        acceptTeamsPanel.add(TOSS);
                       
                        acceptTeamsFrame.add(acceptTeamsPanel);

                        System.out.println(whoWonTheToss);

                        acceptTeamsFrame.setSize(600, 600);
                        acceptTeamsFrame.setLayout(null);
                        acceptTeamsFrame.setLocationRelativeTo(null);
                        acceptTeamsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        // f.getContentPane().setBackground(new Color(200,200,200));
                        acceptTeamsFrame.setVisible(true);
                }
        }

        int fontSize = 30;

        public void boldThemAll(JButton obj) {
                obj.setFont(new Font("Calibri", Font.BOLD, fontSize));
        }

        int labelfontSize = 15;

        public void boldThemAll(JLabel obj) {
                obj.setFont(new Font("Calibri", Font.BOLD, labelfontSize));
        }

        int textfontSize = 10;

        public void boldThemAll(JTextField obj) {
                obj.setFont(new Font("Calibri", Font.BOLD, labelfontSize));
        }

        public void borderThemAll(JLabel obj) {
                Border border = BorderFactory.createBevelBorder(1);
                obj.setBorder(border);
        }

        public String InputDialogValidate(String inputValue, int i, String teamName) {

                inputValue = JOptionPane.showInputDialog(acceptTeamsFrame, "Enter PhoneNo of Player " + (i + 1),
                                teamName,
                                JOptionPane.PLAIN_MESSAGE);

                if (inputValue == null || inputValue.isEmpty() || !inputValue.matches("^\\d{10}$")) // regex to validate
                                                                                                    // phno
                {
                        JOptionPane.showMessageDialog(null, "Phone number should be of 10 digits");
                        inputValue = InputDialogValidate(inputValue, i, teamName);
                }

                return inputValue;
        }

        public static void main(String[] args) {
                try {
                        AcceptTwoTeams ob11 = new AcceptTwoTeams();
                        ob11.acceeptwoteams2(true); //false here when linked
                } catch (Exception e) {
                        // TODO: handle exception
                }

        }

        public void createTable(String team1name, String team2name, int matchesPlayed) throws Exception {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject?" +
                                "user=root&password=rohitjha");
                Statement st = conn.createStatement();

                String batsmansTableCreation = "create table " + team1name + "_VS_" + team2name + "_M"
                                + (matchesPlayed + 1)
                                + "T1(SrNo int not null primary key, BatsmanName varchar(50) ,Runs int not null,Balls int not null,StrikeRate varchar(40))";
                String insertBatsman1 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T1 values (1,'a',0,0,'0')";
                String insertBatsman2 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T1 values (2,'b',0,0,'0')";
                String insertBatsman3 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T1 values (3,'c',0,0,'0')";
                String insertBatsman4 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T1 values (4,'d',0,0,'0')";
                String insertBatsman5 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T1 values (5,'e',0,0,'0')";
                String insertBatsman6 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T1 values (6,'f',0,0,'0')";
                String insertBatsman7 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T1 values (7,'g',0,0,'0')";
                String insertBatsman8 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T1 values (8,'h',0,0,'0')";
                String insertBatsman9 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T1 values (9,'i',0,0,'0')";
                String insertBatsman10 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T1 values (10,'j',0,0,'0')";
                String insertBatsman11 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T1 values (11,'k',0,0,'0')";
                String insertBatsman12 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T1 values (12,'l',0,0,'0')";
                String insertBatsman13 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T1 values (13,'m',0,0,'0')";
                String insertBatsman14 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T1 values (14,'n',0,0,'0')";
                String insertBatsman15 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T1 values (15,'o',0,0,'0')";
                String insertBatsman16 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T1 values (16,'p',0,0,'0')";
                String insertBatsman17 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T1 values (17,'q',0,0,'0')";
                String insertBatsman18 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T1 values (18,'r',0,0,'0')";
                String insertBatsman19 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T1 values (19,'s',0,0,'0')";
                String insertBatsman20 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T1 values (20,'t',0,0,'0')";
                String insertBatsman21 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T1 values (21,'u',0,0,'0')";
                String insertBatsman22 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T1 values (22,'v',0,0,'0')";

                String bowlersTableCreation = "create table " + team1name + "_VS_" + team2name + "_M"
                                + (matchesPlayed + 1)
                                + "T2(SrNo int not null primary key, BowlerName varchar(50) ,Balls int not null,Wickets int not null,Runs int not null,Economy varchar(40),Extras int not null)";
                String insertBowler1 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T2 values (1,'a',0,0,0,'0',0)";
                String insertBowler2 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T2 values (2,'b',0,0,0,'0',0)";
                String insertBowler3 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T2 values (3,'c',0,0,0,'0',0)";
                String insertBowler4 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T2 values (4,'d',0,0,0,'0',0)";
                String insertBowler5 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T2 values (5,'e',0,0,0,'0',0)";
                String insertBowler6 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T2 values (6,'f',0,0,0,'0',0)";
                String insertBowler7 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T2 values (7,'g',0,0,0,'0',0)";
                String insertBowler8 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T2 values (8,'h',0,0,0,'0',0)";
                String insertBowler9 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T2 values (9,'i',0,0,0,'0',0)";
                String insertBowler10 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T2 values (10,'j',0,0,0,'0',0)";
                String insertBowler11 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T2 values (11,'k',0,0,0,'0',0)";
                String insertBowler12 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T2 values (12,'l',0,0,0,'0',0)";
                String insertBowler13 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T2 values (13,'m',0,0,0,'0',0)";
                String insertBowler14 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T2 values (14,'n',0,0,0,'0',0)";
                String insertBowler15 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T2 values (15,'o',0,0,0,'0',0)";
                String insertBowler16 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T2 values (16,'p',0,0,0,'0',0)";
                String insertBowler17 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T2 values (17,'q',0,0,0,'0',0)";
                String insertBowler18 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T2 values (18,'r',0,0,0,'0',0)";
                String insertBowler19 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T2 values (19,'s',0,0,0,'0',0)";
                String insertBowler20 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T2 values (20,'t',0,0,0,'0',0)";
                String insertBowler21 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T2 values (21,'u',0,0,0,'0',0)";
                String insertBowler22 = "insert into " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                                + "T2 values (22,'v',0,0,0,'0',0)";

                st.execute(batsmansTableCreation);
                st.execute(bowlersTableCreation);
                st.execute(insertBatsman1);
                st.execute(insertBatsman2);
                st.execute(insertBatsman3);
                st.execute(insertBatsman4);
                st.execute(insertBatsman5);
                st.execute(insertBatsman6);
                st.execute(insertBatsman7);
                st.execute(insertBatsman8);
                st.execute(insertBatsman9);
                st.execute(insertBatsman10);
                st.execute(insertBatsman11);
                st.execute(insertBatsman12);
                st.execute(insertBatsman13);
                st.execute(insertBatsman14);
                st.execute(insertBatsman15);
                st.execute(insertBatsman16);
                st.execute(insertBatsman17);
                st.execute(insertBatsman18);
                st.execute(insertBatsman19);
                st.execute(insertBatsman20);
                st.execute(insertBatsman21);
                st.execute(insertBatsman22);
                System.out.println("Done with Batsmans Table");
                st.execute(insertBowler1);
                st.execute(insertBowler2);
                st.execute(insertBowler3);
                st.execute(insertBowler4);
                st.execute(insertBowler5);
                st.execute(insertBowler6);
                st.execute(insertBowler7);
                st.execute(insertBowler8);
                st.execute(insertBowler9);
                st.execute(insertBowler10);
                st.execute(insertBowler11);
                st.execute(insertBowler12);
                st.execute(insertBowler13);
                st.execute(insertBowler14);
                st.execute(insertBowler15);
                st.execute(insertBowler16);
                st.execute(insertBowler17);
                st.execute(insertBowler18);
                st.execute(insertBowler19);
                st.execute(insertBowler20);
                st.execute(insertBowler21);
                st.execute(insertBowler22);
                System.out.println("Done with Bowlers Table");

                st.close();
                conn.close();
        }

        public void matchesPlayedCount(String team1Name, String team2Name) throws Exception {
                String fetchTables = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_SCHEMA ='JavaProject'";
                ArrayList<String> tableNames = new ArrayList<>();
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject?" +
                                "user=root&password=rohitjha");
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(fetchTables);
                String teamAName = team1Name;
                String teamBName = team2Name;
                while (rs.next()) {
                        // System.out.println(rs.getString(1));
                        String name = rs.getString(1);
                        StringBuffer strbuff = new StringBuffer(name);
                        String rev = strbuff.reverse().toString();
                        int index = rev.indexOf("_");
                        String nameTrimmed = rev.substring(index + 1);
                        StringBuffer againStrBuff = new StringBuffer(nameTrimmed);
                        String revBack = againStrBuff.reverse().toString();
                        // System.out.println(revBack);
                        tableNames.add(revBack);
                }

                int count = 0;
                for (int i = 0; i < tableNames.size(); i++) {
                        if (tableNames.get(i).equals(teamAName + "_vs_" + teamBName)) {
                                count += 1;
                        }
                }
                matchesPlayedCnt = count / 2;
                System.out.println("Count :" + count);
                rs.close();
                st.close();
                conn.close();

        }

        // loop of players
        @Override
        public void actionPerformed(ActionEvent e) {

                if (e.getSource() == addTeams) {
                        team1.setText(JOptionPane.showInputDialog(acceptTeamsFrame, "Enter Team1 Name"));
                        team2.setText(JOptionPane.showInputDialog(acceptTeamsFrame, "Enter Team2 Name"));
                        for (int i = 0; i < 3; i++) {
                                teamA.add(new ArrayList<String>()); // this will give me empty rows [],[],[]...
                                teamB.add(new ArrayList<String>());
                        }

                        JOptionPane.showMessageDialog(acceptTeamsFrame, "Enter Players of " + team1.getText());
                        for (int i = 0; i < 3; i++) {
                                // i is for number player
                                // j will execute for frames of displaying name phone
                                for (int j = 0; j < 2; j++) {
                                        // System.out.print("Enter ["+i+"]["+j+"] value: ");
                                        if (j == 0) {
                                                team1Name = team1.getText();
                                                teamA.get(i).add(JOptionPane.showInputDialog(acceptTeamsFrame,
                                                                "Enter name of Player " + (i + 1), team1.getText(),
                                                                JOptionPane.PLAIN_MESSAGE));
                                                // teamA.get(i).add(JOptionPane.showInputDialog("Enter name of Player
                                                // "+(i+1)));
                                        }

                                        if (j == 1) {
                                                // inputDialoguePhNo =
                                                // JOptionPane.showInputDialog(acceptTeamsFrame,"Enter
                                                // PhoneNo of Player "+(i+1), team1.getText(),
                                                // JOptionPane.PLAIN_MESSAGE);
                                                inputDialoguePhNo = InputDialogValidate(inputDialoguePhNo, i,
                                                                team1Name);
                                                teamA.get(i).add(inputDialoguePhNo);
                                                // teamA.get(i).add(JOptionPane.showInputDialog("Enter PhoneNo of Player
                                                // "+(i+1)));
                                        }

                                }
                        }
                        JOptionPane.showMessageDialog(acceptTeamsFrame, "Enter Players of " + team2.getText());
                        for (int i = 0; i < 3; i++) {
                                for (int j = 0; j < 2; j++) {
                                        // System.out.print("Enter ["+i+"]["+j+"] value: ");
                                        if (j == 0) {
                                                team2Name = team2.getText();
                                                teamB.get(i).add(JOptionPane.showInputDialog(acceptTeamsFrame,
                                                                "Enter name of Player " + (i + 1), team2.getText(),
                                                                JOptionPane.PLAIN_MESSAGE));
                                                // teamB.get(i).add(JOptionPane.showInputDialog("Enter Name of Player
                                                // "+(i+1)));
                                        }
                                        if (j == 1) {
                                                // inputDialoguePhNo =
                                                // JOptionPane.showInputDialog(acceptTeamsFrame,"Enter
                                                // PhoneNo of Player "+(i+1), team2.getText(),
                                                // JOptionPane.PLAIN_MESSAGE);
                                                inputDialoguePhNo = InputDialogValidate(inputDialoguePhNo, i,
                                                                team2Name);
                                                teamB.get(i).add(inputDialoguePhNo);
                                                // teamB.get(i).add(JOptionPane.showInputDialog("Enter PhoneNo of Player
                                                // "+(i+1)));
                                        }
                                }
                        }
                        for (int i = 0; i < teamA.size(); i++) {
                                teamANames.add(teamA.get(i).get(0));
                                cb1.addItem(teamA.get(i).get(0));
                        }

                        for (int i = 0; i < teamB.size(); i++) {
                                teamBNames.add(teamB.get(i).get(0));
                                cb2.addItem(teamB.get(i).get(0));
                        }

                }

                SelectAction: if (e.getSource() == select) {
                        if ((cb1.getItemAt(0) == null) || (cb2.getItemAt(0) == null) ||
                                        (rb1.isSelected() == false && rb2.isSelected() == false
                                                        && rb3.isSelected() == false)
                                        ||
                                        (tennisBall.isSelected() == false && leatherBall.isSelected() == false) ||
                                        (venue.getText() == "")) {
                                // System.out.println("Something's Missing...please select all properly");
                                JOptionPane.showMessageDialog(acceptTeamsFrame,
                                                "Something's Missing...please select all properly",
                                                "FORM INCOMPLETE", JOptionPane.PLAIN_MESSAGE);
                                break SelectAction;
                        } // work-in-progress on this if block

                        if (rb1.isSelected()) {
                                gameTypeStr = "5 Overs";
                                JOptionPane.showMessageDialog(acceptTeamsFrame, "Its a 5 Overs game");
                        }
                        if (rb2.isSelected()) {
                                gameTypeStr = "T10";
                                JOptionPane.showMessageDialog(acceptTeamsFrame, "Its a T10 game");
                        }
                        if (rb3.isSelected()) {
                                gameTypeStr = "T20";
                                JOptionPane.showMessageDialog(acceptTeamsFrame, "Its a T20 game");
                        }
                        if (rb4.isSelected()) {
                                gameTypeStr = "ODI";
                                JOptionPane.showMessageDialog(acceptTeamsFrame, "Its an ODI");
                        }
                        if (tennisBall.isSelected()) {
                                ballTypeStr = "Tennis Ball";
                                JOptionPane.showMessageDialog(acceptTeamsFrame, "Tennis Ball Selected");
                        }
                        if (leatherBall.isSelected()) {
                                ballTypeStr = "Leather Ball";
                                JOptionPane.showMessageDialog(acceptTeamsFrame, "Leather Ball Selected");
                        }
                        venueStr = venueTextField.getText();
                        TOSS.setEnabled(true);
                        // System.out.println("Game Type: "+gameTypeStr);
                        // System.out.println("Ball used: "+ballTypeStr);
                        // System.out.println("Played at: "+venueStr);
                }

                if (e.getSource() == TOSS) {
                        String[] list = { team1.getText(), team2.getText() };
                        String[] batOrfield = { "Bat", "Field" };
                        JComboBox<String> jcb = new JComboBox<>(list);
                        JComboBox<String> jcb2 = new JComboBox<>(batOrfield);
                        // jcb.setEditable(true);
                        JOptionPane.showMessageDialog(null, jcb, "Who won the Toss?", JOptionPane.QUESTION_MESSAGE);
                        JOptionPane.showMessageDialog(null, jcb2, "And elected to ?", JOptionPane.QUESTION_MESSAGE);
                        String tossWonBy = "" + jcb.getSelectedItem();
                        String electedTo = "" + jcb2.getSelectedItem();
                        this.whoWonTheToss = tossWonBy + " won the toss and elected to " + electedTo;
                        JOptionPane.showMessageDialog(acceptTeamsFrame, whoWonTheToss, "TOSS",
                                        JOptionPane.PLAIN_MESSAGE);
                        // System.out.println(tossWonBy);System.out.println(electedTo);
                        System.out.println(whoWonTheToss);

                        try {
                                matchesPlayedCount(team1Name.toLowerCase(), team2Name.toLowerCase());
                                createTable(team1Name.toLowerCase(), team2Name.toLowerCase(), matchesPlayedCnt);

                        } catch (Exception e1) {
                                e1.printStackTrace();
                        }
                      
                        acceptTeamsFrame.dispose();
                  
//                        try {
//                                Thread.sleep(5000);
//                        } catch (InterruptedException e2) {
//                                // TODO Auto-generated catch block
//                                e2.printStackTrace();
//                        }
                           
        Scoring obbb = new Scoring();
                        

        try {
                obbb.Scoringfunc(team1Name, team2Name, tossWonBy, electedTo, gameTypeStr, ballTypeStr,
                                venueStr, teamA, teamB, teamANames, teamBNames, matchesPlayedCnt);
        } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
        }
                       
                }
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
}