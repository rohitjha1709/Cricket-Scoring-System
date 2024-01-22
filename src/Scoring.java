import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

class Scoring extends AcceptTwoTeams implements WindowListener, MouseListener {
    int matchesPlayedCnt = 0;
    JFrame f;
    JButton zero, one, two, three, four, five, six, nb, wd, undo, lb, byes, wicket;
    JLabel l, tossWonBy;
    JLabel DisplayRuns, slash, fallOfWickets, oversInt, oversPoint, oversDecimal, oversStr, battingTeamName;
    JLabel currentBowlerLabel;
    JLabel StrikerBatsmanRunsLabel, StrikerBatsmanBallsLabel, NonStrikerBatsmanRunsLabel, NonStrikerBatsmanBallsLabel;
    JRadioButton StrikerBatsman, nonStrikerBatsman;
    JPanel panel;
    JPanel currentBowlerPanel;
    JPanel footer;
    JPanel topPanel;
    JPanel StrikerBatsmanPanel, NonStrikerBatsmanPanel;
    Integer over = 0;
    Integer outs, team1TotalRuns = 0, team2TotalRuns = 0;
    Integer cnt = 0, runsShow = 0, inningsCnt = 0;
    Integer teamAExtras = 0, teamBExtras = 0;
    String previousBatsman, currentBowler, previousBowler, ballType, venue;
    String TossWonByStr, electedTo, Team1Name, Team2Name;
    String gameTypeStr;
    String[] TeamA = new String[11];
    String[] TeamB = new String[11];
    String[] copyOfTeamA = new String[11];
    String[] copyOfTeamB = new String[11];
    String batsman1NameA = "----", batsman2NameA = "----", batsman3NameA = "----", batsman4NameA = "----",
            batsman5NameA = "----", batsman6NameA = "----",
            batsman7NameA = "----", batsman8NameA = "----", batsman9NameA = "----", batsman10NameA = "----",
            batsman11NameA = "----";

    String batsman1NameB = "----", batsman2NameB = "----", batsman3NameB = "----", batsman4NameB = "----",
            batsman5NameB = "----", batsman6NameB = "----",
            batsman7NameB = "----", batsman8NameB = "----", batsman9NameB = "----", batsman10NameB = "----",
            batsman11NameB = "----";

    Integer batsman1runsA = 0, batsman2runsA = 0, batsman3runsA = 0, batsman4runsA = 0, batsman5runsA = 0,
            batsman6runsA = 0,
            batsman7runsA = 0, batsman8runsA = 0, batsman9runsA = 0, batsman10runsA = 0, batsman11runsA = 0;

    Integer batsman1ballsA = 0, batsman2ballsA = 0, batsman3ballsA = 0, batsman4ballsA = 0, batsman5ballsA = 0,
            batsman6ballsA = 0,
            batsman7ballsA = 0, batsman8ballsA = 0, batsman9ballsA = 0, batsman10ballsA = 0, batsman11ballsA = 0;

    String batsman1SrA = "----", batsman2SrA = "----", batsman3SrA = "----", batsman4SrA = "----", batsman5SrA = "----",
            batsman6SrA = "----", batsman7SrA = "----", batsman8SrA = "----", batsman9SrA = "----",
            batsman10SrA = "----", batsman11SrA = "----";

    Integer batsman1runsB = 0, batsman2runsB = 0, batsman3runsB = 0, batsman4runsB = 0, batsman5runsB = 0,
            batsman6runsB = 0,
            batsman7runsB = 0, batsman8runsB = 0, batsman9runsB = 0, batsman10runsB = 0, batsman11runsB = 0;

    Integer batsman1ballsB = 0, batsman2ballsB = 0, batsman3ballsB = 0, batsman4ballsB = 0, batsman5ballsB = 0,
            batsman6ballsB = 0,
            batsman7ballsB = 0, batsman8ballsB = 0, batsman9ballsB = 0, batsman10ballsB = 0, batsman11ballsB = 0;

    String batsman1SrB = "----", batsman2SrB = "----", batsman3SrB = "----", batsman4SrB = "----", batsman5SrB = "----",
            batsman6SrB = "----", batsman7SrB = "----", batsman8SrB = "----", batsman9SrB = "----",
            batsman10SrB = "----", batsman11SrB = "----";

    String bowler1NameA = "----", bowler2NameA = "----", bowler3NameA = "----", bowler4NameA = "----",
            bowler5NameA = "----", bowler6NameA = "----",
            bowler7NameA = "----", bowler8NameA = "----", bowler9NameA = "----", bowler10NameA = "----",
            bowler11NameA = "----";

    String bowler1NameB = "----", bowler2NameB = "----", bowler3NameB = "----", bowler4NameB = "----",
            bowler5NameB = "----", bowler6NameB = "----",
            bowler7NameB = "----", bowler8NameB = "----", bowler9NameB = "----", bowler10NameB = "----",
            bowler11NameB = "----";

    Integer bowler1wicketsA = 0, bowler2wicketsA = 0, bowler3wicketsA = 0, bowler4wicketsA = 0, bowler5wicketsA = 0,
            bowler6wicketsA = 0,
            bowler7wicketsA = 0, bowler8wicketsA = 0, bowler9wicketsA = 0, bowler10wicketsA = 0, bowler11wicketsA = 0;

    Integer bowler1wicketsB = 0, bowler2wicketsB = 0, bowler3wicketsB = 0, bowler4wicketsB = 0, bowler5wicketsB = 0,
            bowler6wicketsB = 0,
            bowler7wicketsB = 0, bowler8wicketsB = 0, bowler9wicketsB = 0, bowler10wicketsB = 0, bowler11wicketsB = 0;

    Integer bowler1runsA = 0, bowler2runsA = 0, bowler3runsA = 0, bowler4runsA = 0, bowler5runsA = 0, bowler6runsA = 0,
            bowler7runsA = 0, bowler8runsA = 0, bowler9runsA = 0, bowler10runsA = 0, bowler11runsA = 0;

    Integer bowler1runsB = 0, bowler2runsB = 0, bowler3runsB = 0, bowler4runsB = 0, bowler5runsB = 0, bowler6runsB = 0,
            bowler7runsB = 0, bowler8runsB = 0, bowler9runsB = 0, bowler10runsB = 0, bowler11runsB = 0;

    Integer bowler1ballsCountA = 0, bowler2ballsCountA = 0, bowler3ballsCountA = 0, bowler4ballsCountA = 0,
            bowler5ballsCountA = 0, bowler6ballsCountA = 0,
            bowler7ballsCountA = 0, bowler8ballsCountA = 0, bowler9ballsCountA = 0, bowler10ballsCountA = 0,
            bowler11ballsCountA = 0;

    Integer bowler1ballsCountB = 0, bowler2ballsCountB = 0, bowler3ballsCountB = 0, bowler4ballsCountB = 0,
            bowler5ballsCountB = 0, bowler6ballsCountB = 0,
            bowler7ballsCountB = 0, bowler8ballsCountB = 0, bowler9ballsCountB = 0, bowler10ballsCountB = 0,
            bowler11ballsCountB = 0;

    Integer bowler1ExtrasA = 0, bowler2ExtrasA = 0, bowler3ExtrasA = 0, bowler4ExtrasA = 0, bowler5ExtrasA = 0,
            bowler6ExtrasA = 0,
            bowler7ExtrasA = 0, bowler8ExtrasA = 0, bowler9ExtrasA = 0, bowler10ExtrasA = 0, bowler11ExtrasA = 0;

    Integer bowler1ExtrasB = 0, bowler2ExtrasB = 0, bowler3ExtrasB = 0, bowler4ExtrasB = 0, bowler5ExtrasB = 0,
            bowler6ExtrasB = 0,
            bowler7ExtrasB = 0, bowler8ExtrasB = 0, bowler9ExtrasB = 0, bowler10ExtrasB = 0, bowler11ExtrasB = 0;

    String bowler1EconomyA = "----", bowler2EconomyA = "----", bowler3EconomyA = "----", bowler4EconomyA = "----",
            bowler5EconomyA = "----",
            bowler6EconomyA = "----", bowler7EconomyA = "----", bowler8EconomyA = "----", bowler9EconomyA = "----",
            bowler10EconomyA = "----", bowler11EconomyA = "----";

    String bowler1EconomyB = "----", bowler2EconomyB = "----", bowler3EconomyB = "----", bowler4EconomyB = "----",
            bowler5EconomyB = "----",
            bowler6EconomyB = "----", bowler7EconomyB = "----", bowler8EconomyB = "----", bowler9EconomyB = "----",
            bowler10EconomyB = "----", bowler11EconomyB = "----";

    ButtonGroup bg;
    ArrayList<ArrayList<String>> teamAWithPhno = new ArrayList<>();
    ArrayList<ArrayList<String>> teamBWithPhno = new ArrayList<>();

    ArrayList<String> teamABatsmans = new ArrayList<String>();
    ArrayList<String> teamBBatsmans = new ArrayList<String>();
    ArrayList<String> teamABowlers = new ArrayList<String>();
    ArrayList<String> teamBBowlers = new ArrayList<String>();

    // Scoring()
    // {
    // super(false);
    // }
    public void Scoringfunc(String team1Name, String team2Name, String tossWonByStr, String electedToStr,
            String GameTypeStr,
            String ballTypeStr, String venueStr,
            ArrayList<ArrayList<String>> TeamAWithPhno,
            ArrayList<ArrayList<String>> TeamBWithPhno, ArrayList<String> teamANames,
            ArrayList<String> teamBNames, Integer MatchesPlayedCount) throws Exception {

        matchesPlayedCnt = MatchesPlayedCount;
        Team1Name = team1Name;
        Team2Name = team2Name;
        TossWonByStr = tossWonByStr;
        electedTo = electedToStr;
        gameTypeStr = GameTypeStr;
        ballType = ballTypeStr;
        venue = venueStr;

        for (int i = 0; i < 3; i++) {
            teamAWithPhno.add(new ArrayList<String>());
        }
        for (int i = 0; i < 3; i++) {
            teamBWithPhno.add(new ArrayList<String>());
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                teamAWithPhno.get(i).add(TeamAWithPhno.get(i).get(j));
                teamBWithPhno.get(i).add(TeamBWithPhno.get(i).get(j));
            }
        }

        for (int i = 0; i < 3; i++) {
            TeamA[i] = (i + 1) + "  " + teamANames.get(i);
            TeamB[i] = (i + 1) + "  " + teamBNames.get(i);
        }

        for (int i = 0; i < TeamA.length; i++) {
            copyOfTeamA[i] = TeamA[i];
            copyOfTeamB[i] = TeamB[i];
        }

        System.out.println(TeamAWithPhno);
        System.out.println(TeamBWithPhno);
        // System.out.println(tossWonByStr);
        // System.out.println(electedToStr);
        // System.out.println(gameTypeStr);System.out.println(ballTypeStr);
        // System.out.println(venueStr);
        System.out.println(teamAWithPhno);
        System.out.println(teamBWithPhno);
        System.out.println(TeamA);
        System.out.println(TeamB);
        System.out.println(copyOfTeamA);
        System.out.println(copyOfTeamB);

        f = new JFrame("Scoring Page");
        f.addWindowListener(this);
        l = new JLabel();
        zero = new JButton("0");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        nb = new JButton("NB");
        wd = new JButton("WD");
        undo = new JButton("UNDO");
        lb = new JButton("LB");
        byes = new JButton("BYE");
        wicket = new JButton("OUT");
        DisplayRuns = new JLabel("0");
        slash = new JLabel("/");
        fallOfWickets = new JLabel("0");
        tossWonBy = new JLabel("");
        oversInt = new JLabel("0");
        oversPoint = new JLabel(".");
        oversDecimal = new JLabel("0");
        oversStr = new JLabel("overs");
        StrikerBatsman = new JRadioButton();
        nonStrikerBatsman = new JRadioButton();
        StrikerBatsmanRunsLabel = new JLabel("0");
        NonStrikerBatsmanRunsLabel = new JLabel("0");
        StrikerBatsmanBallsLabel = new JLabel("(0)");
        NonStrikerBatsmanBallsLabel = new JLabel("(0)");
        // boldThemAll(zero);

        battingTeamName = new JLabel("");
        battingTeamName.setBounds(50, 20, 250, 30);
        battingTeamName.setFont(new Font("Cambria", Font.BOLD, 20));
        battingTeamName.setForeground(Color.WHITE);
        currentBowlerLabel = new JLabel("");
        currentBowlerPanel = new JPanel();
        currentBowlerPanel.setBounds(0, 200, 450, 30);
        currentBowlerPanel.setBackground(new Color(43, 61, 76));
        currentBowlerLabel.setForeground(Color.WHITE);
        currentBowlerPanel.setLayout(null);
        currentBowlerLabel.setBounds(20, 0, 150, 30);
        boldThemAll(currentBowlerLabel);

        currentBowlerLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        currentBowlerLabel.setVerticalAlignment(JLabel.BOTTOM);
        currentBowlerLabel.setHorizontalAlignment(JLabel.LEADING);
        // borderThemAll(currentBowlerLabel);
        currentBowlerPanel.add(currentBowlerLabel);

        topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setBackground(new Color(0, 124, 125));
        topPanel.setBounds(0, 0, 415, 130);
        topPanel.add(battingTeamName);

        f.add(topPanel);

        StrikerBatsmanPanel = new JPanel();
        NonStrikerBatsmanPanel = new JPanel();

        StrikerBatsmanPanel.setBounds(0, 130, 205, 70);
        StrikerBatsmanPanel.setBackground(new Color(0, 82, 84));
        StrikerBatsmanPanel.setLayout(null);
        // StrikerBatsmanPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        StrikerBatsmanPanel.setBorder(BorderFactory.createBevelBorder(0, Color.GRAY, Color.GRAY));
        NonStrikerBatsmanPanel.setBounds(205, 130, 208, 70);
        NonStrikerBatsmanPanel.setBackground(new Color(0, 82, 84));
        NonStrikerBatsmanPanel.setLayout(null);
        // NonStrikerBatsmanPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        NonStrikerBatsmanPanel.setBorder(BorderFactory.createBevelBorder(0, Color.GRAY, Color.GRAY));

        // ImageIcon backgroundImage = new
        // ImageIcon("D:\\Programs\\Java\\JavaProject\\CricketImg8.jpg");
        // Image img = backgroundImage.getImage();
        // Image tempImage = img.getScaledInstance(450, 200, Image.SCALE_SMOOTH);
        // backgroundImage = new ImageIcon(tempImage);
        // JLabel background = new JLabel(backgroundImage);
        // background.setBounds(0, 0, 415, 130);
        // background.add(topPanel);
        // f.add(background);

        DisplayRuns.setBounds(150, 60, 50, 40);
        DisplayRuns.setForeground(Color.white);
        DisplayRuns.setHorizontalAlignment(JLabel.RIGHT);
        boldThemAll(DisplayRuns);
        // borderThemAll(DisplayRuns);
        slash.setBounds(200, 60, 20, 40);
        slash.setForeground(Color.WHITE);
        boldThemAll(slash);
        // borderThemAll(slash);
        fallOfWickets.setBounds(220, 60, 50, 40);
        fallOfWickets.setForeground(Color.WHITE);
        fallOfWickets.setHorizontalAlignment(JLabel.LEADING);
        boldThemAll(fallOfWickets);
        // borderThemAll(fallOfWickets);
        oversInt.setBounds(270, 65, 25, 25);
        oversInt.setForeground(Color.WHITE);
        oversInt.setHorizontalAlignment(JLabel.RIGHT);
        // borderThemAll(oversInt);
        oversPoint.setBounds(295, 65, 5, 25);
        oversPoint.setForeground(Color.WHITE);
        // boldThemAll(oversPoint);
        oversDecimal.setBounds(300, 65, 25, 25);
        oversDecimal.setForeground(Color.WHITE);
        // borderThemAll(oversDecimal);
        oversStr.setBounds(310, 65, 50, 25);
        oversStr.setForeground(Color.WHITE);
        // borderThemAll(oversStr);

        tossWonBy.setBounds(130, 90, 300, 25);
        // borderThemAll(tossWonBy);
        // System.out.println(whoWonTheToss);
        tossWonBy.setText(TossWonByStr + " won the toss and elected to " + electedTo);
        tossWonBy.setForeground(Color.WHITE);

        StrikerBatsman.setBounds(40, 10, 150, 30);
        StrikerBatsman.setText("Ayush");
        StrikerBatsman.setBackground(new Color(0, 82, 84));
        StrikerBatsman.setForeground(Color.WHITE);
        StrikerBatsman.setForeground(Color.WHITE);
        StrikerBatsman.setFont(new Font("Segoe Print", Font.BOLD, 16));
        StrikerBatsman.addActionListener(this);
        StrikerBatsman.addMouseListener(this);
        nonStrikerBatsman.setBounds(40, 10, 150, 30);
        nonStrikerBatsman.setText("Chirag");
        nonStrikerBatsman.setBackground(new Color(0, 82, 84));
        nonStrikerBatsman.setForeground(Color.WHITE);
        nonStrikerBatsman.setFont(new Font("Segoe Print", Font.BOLD, 16));
        nonStrikerBatsman.addActionListener(this);
        nonStrikerBatsman.addMouseListener(this);
        ButtonGroup bg = new ButtonGroup();
        bg.add(StrikerBatsman);
        bg.add(nonStrikerBatsman);

        StrikerBatsmanRunsLabel.setOpaque(true); // if true the component paints every pixel within its bounds
        NonStrikerBatsmanRunsLabel.setOpaque(true);
        StrikerBatsmanBallsLabel.setOpaque(true);
        NonStrikerBatsmanBallsLabel.setOpaque(true);
        StrikerBatsmanRunsLabel.setHorizontalAlignment(JLabel.RIGHT);
        NonStrikerBatsmanRunsLabel.setHorizontalAlignment(JLabel.RIGHT);

        StrikerBatsmanRunsLabel.setBounds(50, 40, 30, 20);
        StrikerBatsmanBallsLabel.setBounds(80, 40, 30, 20);
        StrikerBatsmanBallsLabel.setHorizontalAlignment(JLabel.CENTER);
        NonStrikerBatsmanRunsLabel.setBounds(50, 40, 30, 20);
        NonStrikerBatsmanBallsLabel.setBounds(80, 40, 30, 20);
        NonStrikerBatsmanBallsLabel.setHorizontalAlignment(JLabel.CENTER);

        StrikerBatsmanRunsLabel.setBackground(new Color(0, 82, 84));
        StrikerBatsmanRunsLabel.setForeground(Color.WHITE);
        StrikerBatsmanBallsLabel.setBackground(new Color(0, 82, 84));
        StrikerBatsmanBallsLabel.setForeground(Color.WHITE);
        NonStrikerBatsmanRunsLabel.setBackground(new Color(0, 82, 84));
        NonStrikerBatsmanRunsLabel.setForeground(Color.WHITE);
        NonStrikerBatsmanBallsLabel.setBackground(new Color(0, 82, 84));
        NonStrikerBatsmanBallsLabel.setForeground(Color.WHITE);

        // borderThemAll(StrikerBatsmanRunsLabel);borderThemAll(StrikerBatsmanBallsLabel);
        // borderThemAll(NonStrikerBatsmanRunsLabel);borderThemAll(NonStrikerBatsmanBallsLabel);

        // DisplayRuns.setBackground(new Color(0,255,0));
        // l.setBounds(20, 150, 500, 50);
        // l.setLayout(new FlowLayout());
        // l.setBackground(new Color(150,150,150));
        boldThemAll(l);
        borderThemAll(l);

        zero.setBounds(0, 280, 100, 80);
        zero.setOpaque(true);
        zero.setBorderPainted(true);
        zero.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        boldThemAll(zero);
        zero.setBackground(new Color(245, 245, 245));

        one.setBounds(100, 280, 100, 80);
        one.setOpaque(true);
        one.setBorderPainted(true);
        one.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        boldThemAll(one);
        one.setBackground(new Color(245, 245, 245));

        two.setBounds(200, 280, 100, 80);
        two.setOpaque(true);
        two.setBorderPainted(true);
        two.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        boldThemAll(two);
        two.setBackground(new Color(245, 245, 245));

        three.setBounds(0, 360, 100, 80);
        three.setOpaque(true);
        three.setBorderPainted(true);
        three.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        boldThemAll(three);
        three.setBackground(new Color(245, 245, 245));

        four.setBounds(100, 360, 100, 80);
        four.setOpaque(true);
        four.setBorderPainted(true);
        four.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        boldThemAll(four);
        four.setBackground(new Color(245, 245, 245));

        six.setBounds(200, 360, 100, 80);
        six.setOpaque(true);
        six.setBorderPainted(true);
        six.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        boldThemAll(six);
        six.setBackground(new Color(245, 245, 245));

        wd.setBounds(0, 440, 100, 80);
        wd.setOpaque(true);
        wd.setBorderPainted(true);
        wd.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        boldThemAll(wd);
        wd.setBackground(new Color(245, 245, 245));

        nb.setBounds(100, 440, 100, 80);
        nb.setOpaque(true);
        nb.setBorderPainted(true);
        nb.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        boldThemAll(nb);
        nb.setBackground(new Color(245, 245, 245));

        byes.setBounds(200, 440, 100, 80);
        byes.setOpaque(true);
        byes.setBorderPainted(true);
        byes.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        boldThemAll(byes);
        byes.setBackground(new Color(245, 245, 245));

        undo.setBounds(300, 280, 100, 60);
        undo.setOpaque(true);
        undo.setBorderPainted(true);
        undo.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        boldThemAll(undo);
        undo.setBackground(new Color(245, 245, 245));

        five.setBounds(300, 340, 100, 60);
        five.setOpaque(true);
        five.setBorderPainted(true);
        five.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        boldThemAll(five);
        five.setBackground(new Color(245, 245, 245));

        wicket.setBounds(300, 400, 100, 60);
        wicket.setOpaque(true);
        wicket.setBorderPainted(true);
        wicket.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        wicket.setFont(new Font("Calibri", Font.BOLD, 20));
        // boldThemAll(wicket);
        wicket.setBackground(new Color(245, 245, 245));
        wicket.setForeground(new Color(139, 0, 0));

        lb.setBounds(300, 460, 100, 60);
        lb.setOpaque(true);
        lb.setBorderPainted(true);
        lb.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        boldThemAll(lb);
        lb.setBackground(new Color(245, 245, 245));

        panel = new JPanel();
        l.setForeground(Color.WHITE);
        panel.setBounds(0, 230, 415, 50);
        panel.setBackground(new Color(43, 61, 76)); // same color set as frame color so that the panel will not show any
                                                    // bg color
        panel.setLayout(new FlowLayout(FlowLayout.LEADING));
        // panel.setBorder(BorderFactory.createBevelBorder(1));

        // JScrollPane scrollPane = new JScrollPane(panel);
        // scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        // scrollPane.setBounds(50, 30, 300, 50);
        // //JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
        footer = new JPanel();
        footer.setLayout(null);
        footer.setBounds(0, 520, 415, 130);
        footer.setBackground(new Color(245, 245, 245));

        f.add(zero);
        f.add(one);
        f.add(two);
        f.add(three);
        f.add(four);
        f.add(six);
        f.add(five);
        f.add(nb);
        f.add(wd);
        f.add(byes);
        f.add(undo);
        f.add(wicket);
        f.add(lb);
        panel.add(l);
        f.add(panel);
        topPanel.add(DisplayRuns);
        topPanel.add(slash);
        topPanel.add(fallOfWickets);
        topPanel.add(oversInt);
        topPanel.add(oversPoint);
        topPanel.add(oversDecimal);
        topPanel.add(oversStr);
        topPanel.add(tossWonBy);
        StrikerBatsmanPanel.add(StrikerBatsman);
        NonStrikerBatsmanPanel.add(nonStrikerBatsman);
        // f.add(battingTeamName);
        // f.add(currentBowlerLabel);
        f.add(currentBowlerPanel);
        f.add(footer);
        StrikerBatsmanPanel.add(StrikerBatsmanRunsLabel);
        StrikerBatsmanPanel.add(StrikerBatsmanBallsLabel);
        NonStrikerBatsmanPanel.add(NonStrikerBatsmanRunsLabel);
        NonStrikerBatsmanPanel.add(NonStrikerBatsmanBallsLabel);
        f.add(StrikerBatsmanPanel);
        f.add(NonStrikerBatsmanPanel);
        zero.addActionListener(this);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        six.addActionListener(this);
        five.addActionListener(this);
        nb.addActionListener(this);
        wd.addActionListener(this);
        undo.addActionListener(this);
        byes.addActionListener(this);
        wicket.addActionListener(this);
        lb.addActionListener(this);

        f.setSize(415, 650);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(new Color(200, 200, 200));
        f.setResizable(false);
        f.setVisible(true);

    }

    // bolds labels
    int fontSize = 30;

    public void boldThemAll(JLabel obj) {
        obj.setFont(new Font("Calibri", Font.BOLD, fontSize));
    }

    int buttonFontSize = 20;

    public void boldThemAll(JButton obj) {
        obj.setFont(new Font("Calibri", Font.PLAIN, buttonFontSize));
    }

    public void borderThemAll(JLabel obj) {
        Border border = BorderFactory.createBevelBorder(1);
        obj.setBorder(border);
    }

    public void selectNewBatsman(String[] list, String teamName) {

        JComboBox<String> jcb3 = new JComboBox<>(list);
        JOptionPane.showMessageDialog(f, jcb3, "Select New Batsman (" + teamName + ")", JOptionPane.QUESTION_MESSAGE);
        if (StrikerBatsman.isSelected()) {
            if (!((("" + jcb3.getSelectedItem()).substring(2)).equals(nonStrikerBatsman.getText()))) {
                if (!(("" + jcb3.getSelectedItem()).substring(2).equals(" ----"))) {
                    if (StrikerBatsman.isSelected()) {
                        StrikerBatsman.setText(("" + jcb3.getSelectedItem()).substring(2));
                        StrikerBatsmanRunsLabel.setText("0");
                        StrikerBatsmanBallsLabel.setText("(0)");
                    } else if (nonStrikerBatsman.isSelected()) {
                        nonStrikerBatsman.setText(("" + jcb3.getSelectedItem()).substring(2));
                    }
                } else {
                    JOptionPane.showMessageDialog(f, "This batsman is OUT already", "Batsman cannot be selected",
                            JOptionPane.WARNING_MESSAGE);
                    selectNewBatsman(list, teamName);
                }
            } else {
                JOptionPane.showMessageDialog(f, "This batsman is already playing", "Non-Striker Batsman selected",
                        JOptionPane.WARNING_MESSAGE);
                selectNewBatsman(list, teamName);
            }
        } else if (nonStrikerBatsman.isSelected()) {
            if (!((("" + jcb3.getSelectedItem()).substring(2)).equals(StrikerBatsman.getText()))) {
                if (!(("" + jcb3.getSelectedItem()).substring(2).equals(" ----"))) {
                    if (StrikerBatsman.isSelected()) {
                        StrikerBatsman.setText(("" + jcb3.getSelectedItem()).substring(2));
                    } else if (nonStrikerBatsman.isSelected()) {
                        nonStrikerBatsman.setText(("" + jcb3.getSelectedItem()).substring(2));
                        NonStrikerBatsmanRunsLabel.setText("0");
                        NonStrikerBatsmanBallsLabel.setText("(0)");
                    }
                } else {
                    JOptionPane.showMessageDialog(f, "This batsman is OUT already", "Batsman cannot be selected",
                            JOptionPane.WARNING_MESSAGE);
                    selectNewBatsman(list, teamName);
                }
            } else {
                JOptionPane.showMessageDialog(f, "This batsman is already playing", "Non-Striker Batsman selected",
                        JOptionPane.WARNING_MESSAGE);
                selectNewBatsman(list, teamName);
            }
        }

    }

    public void selectBatsmanAtStart(String[] list, String teamName) {
        JComboBox<String> jcb1 = new JComboBox<>(list);
        JComboBox<String> jcb2 = new JComboBox<>(list);

        JOptionPane.showMessageDialog(f, jcb1, "Select Striker Batsman (" + teamName + ")",
                JOptionPane.QUESTION_MESSAGE);
        StrikerBatsman.setText("" + jcb1.getSelectedItem());
        JOptionPane.showMessageDialog(f, jcb2, "Select Non-Striker Batsman (" + teamName + ")",
                JOptionPane.QUESTION_MESSAGE);
        while (((StrikerBatsman.getText()).equals("" + jcb2.getSelectedItem()))) {
            if ((StrikerBatsman.getText()).equals("" + jcb2.getSelectedItem())) {
                JOptionPane.showMessageDialog(f, "This batsman is already selected as Striker",
                        "Striker batsman selected again", JOptionPane.WARNING_MESSAGE);
                JOptionPane.showMessageDialog(f, jcb2, "Select Non-Striker Batsman Again (" + teamName + ")",
                        JOptionPane.QUESTION_MESSAGE);
            }
        }
        StrikerBatsman.setText(("" + jcb1.getSelectedItem()).substring(2));
        nonStrikerBatsman.setText(("" + jcb2.getSelectedItem()).substring(2));

        if (((battingTeamName.getText().replaceAll("\\s", "")).equals(Team1Name))) {
            batsman1NameA = StrikerBatsman.getText().replaceAll("\\s", "");
            batsman2NameA = nonStrikerBatsman.getText().replaceAll("\\s", "");
            teamABatsmans.add(batsman1NameA);
            teamABatsmans.add(batsman2NameA);
            System.out.println(batsman1NameA);
            System.out.println(batsman2NameA);
        } else if (((battingTeamName.getText().replaceAll("\\s", "")).equals(Team2Name))) {
            batsman1NameB = StrikerBatsman.getText().replaceAll("\\s", "");
            batsman2NameB = nonStrikerBatsman.getText().replaceAll("\\s", "");
            teamBBatsmans.add(batsman1NameB);
            teamBBatsmans.add(batsman2NameB);
            System.out.println(batsman1NameB);
            System.out.println(batsman2NameB);
        }

    }

    public void selectBowler(String[] list, String teamName) {

        JComboBox<String> jcb = new JComboBox<>(list);
        // jcb.setEditable(true);
        previousBowler = currentBowler;
        JOptionPane.showMessageDialog(null, jcb, "Select Bowler (" + teamName + ")", JOptionPane.QUESTION_MESSAGE);
        // jcb.addActionListener(this);
        currentBowler = "" + jcb.getSelectedItem();
        // System.out.println(selected);
        if (!(previousBowler == null)) {
            if (previousBowler.equals(currentBowler)) {
                while (previousBowler.equals(currentBowler)) {
                    JOptionPane.showMessageDialog(f, "Warning..one bowler cannot bowl two consecutive overs",
                            "Same Bowler Continuing", JOptionPane.WARNING_MESSAGE);
                    JOptionPane.showMessageDialog(null, jcb, "Select Bowler Again (" + teamName + ")",
                            JOptionPane.QUESTION_MESSAGE);
                    currentBowler = "" + jcb.getSelectedItem();
                }
            }
        }
        System.out.println("Previous Bowler:" + previousBowler);
        System.out.println("Current Bowler:" + currentBowler);
        currentBowlerLabel.setText(currentBowler.substring(2));

    }

    public void pause(int seconds) {
        try {
            Thread.currentThread();
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void overComplete() {
        OverCompleteAction: if (cnt.equals(6)) {
            over += 1;
            // int howManyOversMatch = 2;
            // if(gameTypeStr.equals("5 Overs")){
            // howManyOversMatch = 4;
            // } else if (gameTypeStr.equals("10 Overs"){
            // howManyOversMatch = 9;
            // } else if(gameTypeStr.equals("20-20")){
            // howManyOversMatch = 19;
            // } else if (gameTypeStr.equals("ODI")){
            // howManyOversMatch = 49;
            // }
            if (over <= 2) {
                JOptionPane.showMessageDialog(f, "That's Over", "Over Complete", JOptionPane.PLAIN_MESSAGE);
                // over+=1;
                oversInt.setText(over.toString());
                System.out.println("Over count:" + over);
                System.out.println("Over complete");
                l.setText("");
                fontSize = 30;
                l.setFont(new Font("Calibri", Font.BOLD, fontSize));
                cnt = 0;
                oversDecimal.setText(cnt.toString());
                switchBatsman();
                if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team1Name)))) {
                    System.out.println(Team2Name + "bowler should be selected");
                    selectBowler(TeamB, Team2Name);
                } else if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team2Name)))) {
                    System.out.println(Team1Name + "bowler should be selected");
                    selectBowler(TeamA, Team1Name);
                }
            } else {
                inningsCnt += 1;
                if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team1Name)))) {
                    team1TotalRuns = runsShow;
                } else if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team2Name)))) {
                    team2TotalRuns = runsShow;
                } else {
                    System.out.println("Something's Wrong");
                }
                if (inningsCnt == 2) {

                    JOptionPane.showMessageDialog(f, "2nd Innings Over");
                    try {
                        calculateMatchSummary(battingTeamName.getText());
                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                    break OverCompleteAction;
                }
                if (inningsCnt == 1) {
                    JOptionPane.showMessageDialog(f, "1st Innings Over");
                    if ((battingTeamName.getText()).equals(Team1Name)) {
                        battingTeamName.setText(Team2Name);
                        tossWonBy.setText(Team2Name + " needs " + (runsShow + 1) + "runs to win the game");
                        clearScoringPage();
                        selectBatsmanAtStart(copyOfTeamB, Team2Name);
                        selectBowler(copyOfTeamA, Team1Name);
                        for (int i = 0; i < copyOfTeamA.length; i++) {
                            TeamA[i] = copyOfTeamA[i];
                        }
                        // break WicketAction;
                    } else if ((battingTeamName.getText()).equals(Team2Name)) {
                        battingTeamName.setText(Team1Name);
                        tossWonBy.setText(Team1Name + " needs " + (runsShow + 1) + "runs to win the game");
                        clearScoringPage();
                        selectBatsmanAtStart(copyOfTeamA, Team1Name);
                        selectBowler(copyOfTeamB, Team2Name);
                        for (int i = 0; i < copyOfTeamB.length; i++) {
                            TeamB[i] = copyOfTeamB[i];
                        }
                        // break WicketAction;
                    }
                }

            }
        }
    }

    public void switchBatsman() {
        if (StrikerBatsman.isSelected()) {
            System.out.println("Striker batsman selected");
            nonStrikerBatsman.setSelected(true);

        } else if (nonStrikerBatsman.isSelected()) {
            System.out.println("NonStriker batsman selected");
            StrikerBatsman.setSelected(true);
        }
    }

    public void clearScoringPage() {
        DisplayRuns.setText("0");
        runsShow = 0;
        previousBowler = "";
        currentBowler = "";
        fallOfWickets.setText("0");
        oversInt.setText("0");
        oversDecimal.setText("0");
        outs = 0;
        over = 0;
        cnt = 0;
        l.setText("");
        StrikerBatsman.setSelected(true);
        StrikerBatsmanRunsLabel.setText("0");
        StrikerBatsmanBallsLabel.setText("(0)");
        NonStrikerBatsmanRunsLabel.setText("0");
        NonStrikerBatsmanBallsLabel.setText("(0)");
    }

    public String calculateStrikeRate(Double Balls, Double Runs) {
        Double sr = (Runs / Balls) * 100;
        return String.format("%.2f", sr);
    }

    public String calculateEconomy(Double Balls, Double Runs) {
        // Double decimalPart = Balls%6;
        Double Overs = Balls / 6;
        Double Economy = Runs / Overs;
        return String.format("%.2f", Economy);
    }

    public void updateTable(String team1name, String team2name, int matchesPlayed) throws Exception {
        System.out.println("Now updating the values");
        String sqlSafeUpdatesOff = "SET SQL_SAFE_UPDATES=0";
        String updateBatsman1 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T1 SET BatsmanName = '" + batsman1NameA + "',Runs = " + batsman1runsA + ",Balls = " + batsman1ballsA
                + ",StrikeRate = '" + batsman1SrA + "' WHERE SrNo = 1";
        String updateBatsman2 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T1 SET BatsmanName = '" + batsman2NameA + "',Runs = " + batsman2runsA + ",Balls = " + batsman2ballsA
                + ",StrikeRate = '" + batsman2SrA + "' WHERE SrNo = 2";
        String updateBatsman3 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T1 SET BatsmanName = '" + batsman3NameA + "',Runs = " + batsman3runsA + ",Balls = " + batsman3ballsA
                + ",StrikeRate = '" + batsman3SrA + "' WHERE SrNo = 3";
        String updateBatsman4 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T1 SET BatsmanName = '" + batsman4NameA + "',Runs = " + batsman4runsA + ",Balls = " + batsman4ballsA
                + ",StrikeRate = '" + batsman4SrA + "' WHERE SrNo = 4";
        String updateBatsman5 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T1 SET BatsmanName = '" + batsman5NameA + "',Runs = " + batsman5runsA + ",Balls = " + batsman5ballsA
                + ",StrikeRate = '" + batsman5SrA + "' WHERE SrNo = 5";
        String updateBatsman6 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T1 SET BatsmanName = '" + batsman6NameA + "',Runs = " + batsman6runsA + ",Balls = " + batsman6ballsA
                + ",StrikeRate = '" + batsman6SrA + "' WHERE SrNo = 6";
        String updateBatsman7 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T1 SET BatsmanName = '" + batsman7NameA + "',Runs = " + batsman7runsA + ",Balls = " + batsman7ballsA
                + ",StrikeRate = '" + batsman7SrA + "' WHERE SrNo = 7";
        String updateBatsman8 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T1 SET BatsmanName = '" + batsman8NameA + "',Runs = " + batsman8runsA + ",Balls = " + batsman8ballsA
                + ",StrikeRate = '" + batsman8SrA + "' WHERE SrNo = 8";
        String updateBatsman9 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T1 SET BatsmanName = '" + batsman9NameA + "',Runs = " + batsman9runsA + ",Balls = " + batsman9ballsA
                + ",StrikeRate = '" + batsman9SrA + "' WHERE SrNo = 9";
        String updateBatsman10 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T1 SET BatsmanName = '" + batsman10NameA + "',Runs = " + batsman10runsA + ",Balls = "
                + batsman10ballsA + ",StrikeRate = '" + batsman10SrA + "' WHERE SrNo = 10";
        String updateBatsman11 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T1 SET BatsmanName = '" + batsman11NameA + "',Runs = " + batsman11runsA + ",Balls = "
                + batsman11ballsA + ",StrikeRate = '" + batsman11SrA + "' WHERE SrNo = 11";
        String updateBatsman12 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T1 SET BatsmanName = '" + batsman1NameB + "',Runs = " + batsman1runsB + ",Balls = " + batsman1ballsB
                + ",StrikeRate = '" + batsman1SrB + "' WHERE SrNo = 12";
        String updateBatsman13 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T1 SET BatsmanName = '" + batsman2NameB + "',Runs = " + batsman2runsB + ",Balls = " + batsman2ballsB
                + ",StrikeRate = '" + batsman2SrB + "' WHERE SrNo = 13";
        String updateBatsman14 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T1 SET BatsmanName = '" + batsman3NameB + "',Runs = " + batsman3runsB + ",Balls = " + batsman3ballsB
                + ",StrikeRate = '" + batsman3SrB + "' WHERE SrNo = 14";
        String updateBatsman15 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T1 SET BatsmanName = '" + batsman4NameB + "',Runs = " + batsman4runsB + ",Balls = " + batsman4ballsB
                + ",StrikeRate = '" + batsman4SrB + "' WHERE SrNo = 15";
        String updateBatsman16 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T1 SET BatsmanName = '" + batsman5NameB + "',Runs = " + batsman5runsB + ",Balls = " + batsman5ballsB
                + ",StrikeRate = '" + batsman5SrB + "' WHERE SrNo = 16";
        String updateBatsman17 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T1 SET BatsmanName = '" + batsman6NameB + "',Runs = " + batsman6runsB + ",Balls = " + batsman6ballsB
                + ",StrikeRate = '" + batsman6SrB + "' WHERE SrNo = 17";
        String updateBatsman18 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T1 SET BatsmanName = '" + batsman7NameB + "',Runs = " + batsman7runsB + ",Balls = " + batsman7ballsB
                + ",StrikeRate = '" + batsman7SrB + "' WHERE SrNo = 18";
        String updateBatsman19 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T1 SET BatsmanName = '" + batsman8NameB + "',Runs = " + batsman8runsB + ",Balls = " + batsman8ballsB
                + ",StrikeRate = '" + batsman8SrB + "' WHERE SrNo = 19";
        String updateBatsman20 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T1 SET BatsmanName = '" + batsman9NameB + "',Runs = " + batsman9runsB + ",Balls = " + batsman9ballsB
                + ",StrikeRate = '" + batsman9SrB + "' WHERE SrNo = 20";
        String updateBatsman21 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T1 SET BatsmanName = '" + batsman10NameB + "',Runs = " + batsman10runsB + ",Balls = "
                + batsman10ballsB + ",StrikeRate = '" + batsman10SrB + "' WHERE SrNo = 21";
        String updateBatsman22 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T1 SET BatsmanName = '" + batsman11NameB + "',Runs = " + batsman11runsB + ",Balls = "
                + batsman11ballsB + ",StrikeRate = '" + batsman11SrB + "' WHERE SrNo = 22";

        String updateBowler1 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T2 SET BowlerName = '" + bowler1NameA + "',Balls = " + bowler1ballsCountA + ",Wickets = "
                + bowler1wicketsA + ",Runs = " + bowler1runsA + ",Economy = '" + bowler1EconomyA + "' WHERE SrNo = 1";
        String updateBowler2 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T2 SET BowlerName = '" + bowler2NameA + "',Balls = " + bowler2ballsCountA + ",Wickets = "
                + bowler2wicketsA + ",Runs = " + bowler2runsA + ",Economy = '" + bowler2EconomyA + "' WHERE SrNo = 2";
        String updateBowler3 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T2 SET BowlerName = '" + bowler3NameA + "',Balls = " + bowler3ballsCountA + ",Wickets = "
                + bowler3wicketsA + ",Runs = " + bowler3runsA + ",Economy = '" + bowler3EconomyA + "' WHERE SrNo = 3";
        String updateBowler4 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T2 SET BowlerName = '" + bowler4NameA + "',Balls = " + bowler4ballsCountA + ",Wickets = "
                + bowler4wicketsA + ",Runs = " + bowler4runsA + ",Economy = '" + bowler4EconomyA + "' WHERE SrNo = 4";
        String updateBowler5 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T2 SET BowlerName = '" + bowler5NameA + "',Balls = " + bowler5ballsCountA + ",Wickets = "
                + bowler5wicketsA + ",Runs = " + bowler5runsA + ",Economy = '" + bowler5EconomyA + "' WHERE SrNo = 5";
        String updateBowler6 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T2 SET BowlerName = '" + bowler6NameA + "',Balls = " + bowler6ballsCountA + ",Wickets = "
                + bowler6wicketsA + ",Runs = " + bowler6runsA + ",Economy = '" + bowler6EconomyA + "' WHERE SrNo = 6";
        String updateBowler7 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T2 SET BowlerName = '" + bowler7NameA + "',Balls = " + bowler7ballsCountA + ",Wickets = "
                + bowler7wicketsA + ",Runs = " + bowler7runsA + ",Economy = '" + bowler7EconomyA + "' WHERE SrNo = 7";
        String updateBowler8 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T2 SET BowlerName = '" + bowler8NameA + "',Balls = " + bowler8ballsCountA + ",Wickets = "
                + bowler8wicketsA + ",Runs = " + bowler8runsA + ",Economy = '" + bowler8EconomyA + "' WHERE SrNo = 8";
        String updateBowler9 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T2 SET BowlerName = '" + bowler9NameA + "',Balls = " + bowler9ballsCountA + ",Wickets = "
                + bowler9wicketsA + ",Runs = " + bowler9runsA + ",Economy = '" + bowler9EconomyA + "' WHERE SrNo = 9";
        String updateBowler10 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T2 SET BowlerName = '" + bowler10NameA + "',Balls = " + bowler10ballsCountA + ",Wickets = "
                + bowler10wicketsA + ",Runs = " + bowler10runsA + ",Economy = '" + bowler10EconomyA
                + "' WHERE SrNo = 10";
        String updateBowler11 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T2 SET BowlerName = '" + bowler11NameA + "',Balls = " + bowler11ballsCountA + ",Wickets = "
                + bowler11wicketsA + ",Runs = " + bowler11runsA + ",Economy = '" + bowler11EconomyA
                + "' WHERE SrNo = 11";
        String updateBowler12 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T2 SET BowlerName = '" + bowler1NameB + "',Balls = " + bowler1ballsCountB + ",Wickets = "
                + bowler1wicketsB + ",Runs = " + bowler1runsB + ",Economy = '" + bowler1EconomyB + "' WHERE SrNo = 12";
        String updateBowler13 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T2 SET BowlerName = '" + bowler2NameB + "',Balls = " + bowler2ballsCountB + ",Wickets = "
                + bowler2wicketsB + ",Runs = " + bowler2runsB + ",Economy = '" + bowler2EconomyB + "' WHERE SrNo = 13";
        String updateBowler14 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T2 SET BowlerName = '" + bowler3NameB + "',Balls = " + bowler3ballsCountB + ",Wickets = "
                + bowler3wicketsB + ",Runs = " + bowler3runsB + ",Economy = '" + bowler3EconomyB + "' WHERE SrNo = 14";
        String updateBowler15 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T2 SET BowlerName = '" + bowler4NameB + "',Balls = " + bowler4ballsCountB + ",Wickets = "
                + bowler4wicketsB + ",Runs = " + bowler4runsB + ",Economy = '" + bowler4EconomyB + "' WHERE SrNo = 15";
        String updateBowler16 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T2 SET BowlerName = '" + bowler5NameB + "',Balls = " + bowler5ballsCountB + ",Wickets = "
                + bowler5wicketsB + ",Runs = " + bowler5runsB + ",Economy = '" + bowler5EconomyB + "' WHERE SrNo = 16";
        String updateBowler17 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T2 SET BowlerName = '" + bowler6NameB + "',Balls = " + bowler6ballsCountB + ",Wickets = "
                + bowler6wicketsB + ",Runs = " + bowler6runsB + ",Economy = '" + bowler6EconomyB + "' WHERE SrNo = 17";
        String updateBowler18 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T2 SET BowlerName = '" + bowler7NameB + "',Balls = " + bowler7ballsCountB + ",Wickets = "
                + bowler7wicketsB + ",Runs = " + bowler7runsB + ",Economy = '" + bowler7EconomyB + "' WHERE SrNo = 18";
        String updateBowler19 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T2 SET BowlerName = '" + bowler8NameB + "',Balls = " + bowler8ballsCountB + ",Wickets = "
                + bowler8wicketsB + ",Runs = " + bowler8runsB + ",Economy = '" + bowler8EconomyB + "' WHERE SrNo = 19";
        String updateBowler20 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T2 SET BowlerName = '" + bowler9NameB + "',Balls = " + bowler9ballsCountB + ",Wickets = "
                + bowler9wicketsB + ",Runs = " + bowler9runsB + ",Economy = '" + bowler9EconomyB + "' WHERE SrNo = 20";
        String updateBowler21 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T2 SET BowlerName = '" + bowler10NameB + "',Balls = " + bowler10ballsCountB + ",Wickets = "
                + bowler10wicketsB + ",Runs = " + bowler10runsB + ",Economy = '" + bowler10EconomyB
                + "' WHERE SrNo = 21";
        String updateBowler22 = "UPDATE " + team1name + "_VS_" + team2name + "_M" + (matchesPlayed + 1)
                + "T2 SET BowlerName = '" + bowler11NameB + "',Balls = " + bowler11ballsCountB + ",Wickets = "
                + bowler11wicketsB + ",Runs = " + bowler11runsB + ",Economy = '" + bowler11EconomyB
                + "' WHERE SrNo = 22";

        String sqlSafeUpdatesOn = "SET SQL_SAFE_UPDATES=1";
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject?" +
                "user=root&password=vinghost@123");
        Statement st = conn.createStatement();
        st.execute(sqlSafeUpdatesOff);
        st.executeUpdate(updateBatsman1);
        st.executeUpdate(updateBatsman2);
        st.executeUpdate(updateBatsman3);
        st.executeUpdate(updateBatsman4);
        st.executeUpdate(updateBatsman5);
        st.executeUpdate(updateBatsman6);
        st.executeUpdate(updateBatsman7);
        st.executeUpdate(updateBatsman8);
        st.executeUpdate(updateBatsman9);
        st.executeUpdate(updateBatsman10);
        st.executeUpdate(updateBatsman11);
        st.executeUpdate(updateBatsman12);
        st.executeUpdate(updateBatsman13);
        st.executeUpdate(updateBatsman14);
        st.executeUpdate(updateBatsman15);
        st.executeUpdate(updateBatsman16);
        st.executeUpdate(updateBatsman17);
        st.executeUpdate(updateBatsman18);
        st.executeUpdate(updateBatsman19);
        st.executeUpdate(updateBatsman20);
        st.executeUpdate(updateBatsman21);
        st.executeUpdate(updateBatsman22);
        st.executeUpdate(updateBowler1);
        st.executeUpdate(updateBowler2);
        st.executeUpdate(updateBowler3);
        st.executeUpdate(updateBowler4);
        st.executeUpdate(updateBowler5);
        st.executeUpdate(updateBowler6);
        st.executeUpdate(updateBowler7);
        st.executeUpdate(updateBowler8);
        st.executeUpdate(updateBowler9);
        st.executeUpdate(updateBowler10);
        st.executeUpdate(updateBowler11);
        st.executeUpdate(updateBowler12);
        st.executeUpdate(updateBowler13);
        st.executeUpdate(updateBowler14);
        st.executeUpdate(updateBowler15);
        st.executeUpdate(updateBowler16);
        st.executeUpdate(updateBowler17);
        st.executeUpdate(updateBowler18);
        st.executeUpdate(updateBowler19);
        st.executeUpdate(updateBowler20);
        st.executeUpdate(updateBowler21);
        st.executeUpdate(updateBowler22);
        st.execute(sqlSafeUpdatesOn);
        conn.close();
        st.close();
    }

    public void calculateMatchSummary(String battingTeamInSecondInnings) throws Exception {

        Integer diff;
        System.out.println(team1TotalRuns);
        System.out.println(team2TotalRuns);

        if (!(batsman1NameA.equals("----"))) {
            batsman1SrA = calculateStrikeRate((double) batsman1ballsA, (double) batsman1runsA);
        }
        if (!(batsman2NameA.equals("----"))) {
            batsman2SrA = calculateStrikeRate((double) batsman2ballsA, (double) batsman2runsA);
        }
        if (!(batsman3NameA.equals("----"))) {
            batsman3SrA = calculateStrikeRate((double) batsman3ballsA, (double) batsman3runsA);
        }
        if (!(batsman4NameA.equals("----"))) {
            batsman4SrA = calculateStrikeRate((double) batsman4ballsA, (double) batsman4runsA);
        }
        if (!(batsman5NameA.equals("----"))) {
            batsman5SrA = calculateStrikeRate((double) batsman5ballsA, (double) batsman5runsA);
        }
        if (!(batsman6NameA.equals("----"))) {
            batsman6SrA = calculateStrikeRate((double) batsman6ballsA, (double) batsman6runsA);
        }
        if (!(batsman7NameA.equals("----"))) {
            batsman7SrA = calculateStrikeRate((double) batsman7ballsA, (double) batsman7runsA);
        }
        if (!(batsman8NameA.equals("----"))) {
            batsman8SrA = calculateStrikeRate((double) batsman8ballsA, (double) batsman8runsA);
        }
        if (!(batsman9NameA.equals("----"))) {
            batsman9SrA = calculateStrikeRate((double) batsman9ballsA, (double) batsman9runsA);
        }
        if (!(batsman10NameA.equals("----"))) {
            batsman10SrA = calculateStrikeRate((double) batsman10ballsA, (double) batsman10runsA);
        }
        if (!(batsman11NameA.equals("----"))) {
            batsman11SrA = calculateStrikeRate((double) batsman11ballsA, (double) batsman11runsA);
        }

        if (!(batsman1NameB.equals("----"))) {
            batsman1SrB = calculateStrikeRate((double) batsman1ballsB, (double) batsman1runsB);
        }
        if (!(batsman2NameB.equals("----"))) {
            batsman2SrB = calculateStrikeRate((double) batsman2ballsB, (double) batsman2runsB);
        }
        if (!(batsman3NameB.equals("----"))) {
            batsman3SrB = calculateStrikeRate((double) batsman3ballsB, (double) batsman3runsB);
        }
        if (!(batsman4NameB.equals("----"))) {
            batsman4SrB = calculateStrikeRate((double) batsman4ballsB, (double) batsman4runsB);
        }
        if (!(batsman5NameB.equals("----"))) {
            batsman5SrB = calculateStrikeRate((double) batsman5ballsB, (double) batsman5runsB);
        }
        if (!(batsman6NameB.equals("----"))) {
            batsman6SrB = calculateStrikeRate((double) batsman6ballsB, (double) batsman6runsB);
        }
        if (!(batsman7NameB.equals("----"))) {
            batsman7SrB = calculateStrikeRate((double) batsman7ballsB, (double) batsman7runsB);
        }
        if (!(batsman8NameB.equals("----"))) {
            batsman8SrB = calculateStrikeRate((double) batsman8ballsB, (double) batsman8runsB);
        }
        if (!(batsman9NameB.equals("----"))) {
            batsman9SrB = calculateStrikeRate((double) batsman9ballsB, (double) batsman9runsB);
        }
        if (!(batsman10NameB.equals("----"))) {
            batsman10SrB = calculateStrikeRate((double) batsman10ballsB, (double) batsman10runsB);
        }
        if (!(batsman11NameB.equals("----"))) {
            batsman11SrB = calculateStrikeRate((double) batsman11ballsB, (double) batsman11runsB);
        }

        if (!(bowler1NameA.equals("----"))) {
            bowler1EconomyA = calculateEconomy((double) bowler1ballsCountA, (double) bowler1runsA);
        }
        if (!(bowler2NameA.equals("----"))) {
            bowler2EconomyA = calculateEconomy((double) bowler2ballsCountA, (double) bowler2runsA);
        }
        if (!(bowler3NameA.equals("----"))) {
            bowler3EconomyA = calculateEconomy((double) bowler3ballsCountA, (double) bowler3runsA);
        }
        if (!(bowler4NameA.equals("----"))) {
            bowler4EconomyA = calculateEconomy((double) bowler4ballsCountA, (double) bowler4runsA);
        }
        if (!(bowler5NameA.equals("----"))) {
            bowler5EconomyA = calculateEconomy((double) bowler5ballsCountA, (double) bowler5runsA);
        }
        if (!(bowler6NameA.equals("----"))) {
            bowler6EconomyA = calculateEconomy((double) bowler6ballsCountA, (double) bowler6runsA);
        }
        if (!(bowler7NameA.equals("----"))) {
            bowler7EconomyA = calculateEconomy((double) bowler7ballsCountA, (double) bowler7runsA);
        }
        if (!(bowler8NameA.equals("----"))) {
            bowler8EconomyA = calculateEconomy((double) bowler8ballsCountA, (double) bowler8runsA);
        }
        if (!(bowler9NameA.equals("----"))) {
            bowler9EconomyA = calculateEconomy((double) bowler9ballsCountA, (double) bowler9runsA);
        }
        if (!(bowler10NameA.equals("----"))) {
            bowler10EconomyA = calculateEconomy((double) bowler10ballsCountA, (double) bowler10runsA);
        }
        if (!(bowler11NameA.equals("----"))) {
            bowler11EconomyA = calculateEconomy((double) bowler11ballsCountA, (double) bowler11runsA);
        }

        if (!(bowler1NameB.equals("----"))) {
            bowler1EconomyB = calculateEconomy((double) bowler1ballsCountB, (double) bowler1runsB);
        }
        if (!(bowler2NameB.equals("----"))) {
            bowler2EconomyB = calculateEconomy((double) bowler2ballsCountB, (double) bowler2runsB);
        }
        if (!(bowler3NameB.equals("----"))) {
            bowler3EconomyB = calculateEconomy((double) bowler3ballsCountB, (double) bowler3runsB);
        }
        if (!(bowler4NameB.equals("----"))) {
            bowler4EconomyB = calculateEconomy((double) bowler4ballsCountB, (double) bowler4runsB);
        }
        if (!(bowler5NameB.equals("----"))) {
            bowler5EconomyB = calculateEconomy((double) bowler5ballsCountB, (double) bowler5runsB);
        }
        if (!(bowler6NameB.equals("----"))) {
            bowler6EconomyB = calculateEconomy((double) bowler6ballsCountB, (double) bowler6runsB);
        }
        if (!(bowler7NameB.equals("----"))) {
            bowler7EconomyB = calculateEconomy((double) bowler7ballsCountB, (double) bowler7runsB);
        }
        if (!(bowler8NameB.equals("----"))) {
            bowler8EconomyB = calculateEconomy((double) bowler8ballsCountB, (double) bowler8runsB);
        }
        if (!(bowler9NameB.equals("----"))) {
            bowler9EconomyB = calculateEconomy((double) bowler9ballsCountB, (double) bowler9runsB);
        }
        if (!(bowler10NameB.equals("----"))) {
            bowler10EconomyB = calculateEconomy((double) bowler10ballsCountB, (double) bowler10runsB);
        }
        if (!(bowler11NameB.equals("----"))) {
            bowler11EconomyB = calculateEconomy((double) bowler11ballsCountB, (double) bowler11runsB);
        }

        System.out.println("Updating Match Summary...");
        // matchesPlayedCount(Team1Name, Team2Name);
        updateTable(Team1Name, Team2Name, matchesPlayedCnt);
        System.out.println("Match Summary Updated");

        System.out.println("Team A Extras before adding bowling extras:" + teamAExtras);
        teamAExtras += (bowler1ExtrasA + bowler2ExtrasA + bowler3ExtrasA + bowler4ExtrasA +
                bowler5ExtrasA + bowler6ExtrasA + bowler7ExtrasA + bowler8ExtrasA + bowler9ExtrasA +
                bowler10ExtrasA + bowler11ExtrasA);

        System.out.println("Team B Extras before adding bowling extras:" + teamBExtras);
        teamBExtras += (bowler1ExtrasB + bowler2ExtrasB + bowler3ExtrasB + bowler4ExtrasB +
                bowler5ExtrasB + bowler6ExtrasB + bowler7ExtrasB + bowler8ExtrasB + bowler9ExtrasB +
                bowler10ExtrasB + bowler11ExtrasB);

        System.out.println("-------------------------- Team A ScoreCard");
        System.out.println("Team A Batsman 1 Name: " + batsman1NameA + " Runs:" + batsman1runsA + " Balls :"
                + batsman1ballsA + " Strike Rate:" + batsman1SrA);
        System.out.println("Team A Batsman 2 Name: " + batsman2NameA + " Runs:" + batsman2runsA + " Balls :"
                + batsman2ballsA + " Strike Rate:" + batsman2SrA);
        System.out.println("Team A Batsman 3 Name: " + batsman3NameA + " Runs:" + batsman3runsA + " Balls :"
                + batsman3ballsA + " Strike Rate:" + batsman3SrA);
        System.out.println("Team A Batsman 4 Name: " + batsman4NameA + " Runs:" + batsman4runsA + " Balls :"
                + batsman4ballsA + " Strike Rate:" + batsman4SrA);
        System.out.println("Team A Batsman 5 Name: " + batsman5NameA + " Runs:" + batsman5runsA + " Balls :"
                + batsman5ballsA + " Strike Rate:" + batsman5SrA);
        System.out.println("Team A Batsman 6 Name: " + batsman6NameA + " Runs:" + batsman6runsA + " Balls :"
                + batsman6ballsA + " Strike Rate:" + batsman6SrA);
        System.out.println("Team A Batsman 7 Name: " + batsman7NameA + " Runs:" + batsman7runsA + " Balls :"
                + batsman7ballsA + " Strike Rate:" + batsman7SrA);
        System.out.println("Team A Batsman 8 Name: " + batsman8NameA + " Runs:" + batsman8runsA + " Balls :"
                + batsman8ballsA + " Strike Rate:" + batsman8SrA);
        System.out.println("Team A Batsman 9 Name: " + batsman9NameA + " Runs:" + batsman9runsA + " Balls :"
                + batsman9ballsA + " Strike Rate:" + batsman9SrA);
        System.out.println("Team A Batsman 10 Name: " + batsman10NameA + " Runs:" + batsman10runsA + " Balls :"
                + batsman10ballsA + " Strike Rate:" + batsman10SrA);
        System.out.println("Team A Batsman 11 Name: " + batsman11NameA + " Runs:" + batsman11runsA + " Balls :"
                + batsman11ballsA + " Strike Rate:" + batsman11SrA);
        System.out.println("-----------------------------");
        System.out.println("Team B Extras: " + teamBExtras);
        System.out.println("-----------------------------");
        System.out.println("Name:" + bowler1NameB + " Runs:" + bowler1runsB + " Balls:" + bowler1ballsCountB
                + " Wickets:" + bowler1wicketsB + " Extras:" + bowler1ExtrasB + " Economy:" + bowler1EconomyB);
        System.out.println("Name:" + bowler2NameB + " Runs:" + bowler2runsB + " Balls:" + bowler2ballsCountB
                + " Wickets:" + bowler2wicketsB + " Extras:" + bowler2ExtrasB + " Economy:" + bowler2EconomyB);
        System.out.println("Name:" + bowler3NameB + " Runs:" + bowler3runsB + " Balls:" + bowler3ballsCountB
                + " Wickets:" + bowler3wicketsB + " Extras:" + bowler3ExtrasB + " Economy:" + bowler3EconomyB);
        System.out.println("Name:" + bowler4NameB + " Runs:" + bowler4runsB + " Balls:" + bowler4ballsCountB
                + " Wickets:" + bowler4wicketsB + " Extras:" + bowler4ExtrasB + " Economy:" + bowler4EconomyB);
        System.out.println("Name:" + bowler5NameB + " Runs:" + bowler5runsB + " Balls:" + bowler5ballsCountB
                + " Wickets:" + bowler5wicketsB + " Extras:" + bowler5ExtrasB + " Economy:" + bowler5EconomyB);
        System.out.println("Name:" + bowler6NameB + " Runs:" + bowler6runsB + " Balls:" + bowler6ballsCountB
                + " Wickets:" + bowler6wicketsB + " Extras:" + bowler6ExtrasB + " Economy:" + bowler6EconomyB);
        System.out.println("Name:" + bowler7NameB + " Runs:" + bowler7runsB + " Balls:" + bowler7ballsCountB
                + " Wickets:" + bowler7wicketsB + " Extras:" + bowler7ExtrasB + " Economy:" + bowler7EconomyB);
        System.out.println("Name:" + bowler8NameB + " Runs:" + bowler8runsB + " Balls:" + bowler8ballsCountB
                + " Wickets:" + bowler8wicketsB + " Extras:" + bowler8ExtrasB + " Economy:" + bowler8EconomyB);
        System.out.println("Name:" + bowler9NameB + " Runs:" + bowler9runsB + " Balls:" + bowler9ballsCountB
                + " Wickets:" + bowler9wicketsB + " Extras:" + bowler9ExtrasB + " Economy:" + bowler9EconomyB);
        System.out.println("Name:" + bowler10NameB + " Runs:" + bowler10runsB + " Balls:" + bowler10ballsCountB
                + " Wickets:" + bowler10wicketsB + " Extras:" + bowler10ExtrasB + " Economy:" + bowler10EconomyB);
        System.out.println("Name:" + bowler11NameB + " Runs:" + bowler11runsB + " Balls:" + bowler11ballsCountB
                + " Wickets:" + bowler11wicketsB + " Extras:" + bowler11ExtrasB + " Economy:" + bowler11EconomyB);
        System.out.println("--------------------------");

        System.out.println("-------------------------- Team B ScoreCard");
        System.out.println("Team B Batsman 1 Name: " + batsman1NameB + " Runs:" + batsman1runsB + " Balls :"
                + batsman1ballsB + " Strike Rate:" + batsman1SrB);
        System.out.println("Team B Batsman 2 Name: " + batsman2NameB + " Runs:" + batsman2runsB + " Balls :"
                + batsman2ballsB + " Strike Rate:" + batsman2SrB);
        System.out.println("Team B Batsman 3 Name: " + batsman3NameB + " Runs:" + batsman3runsB + " Balls :"
                + batsman3ballsB + " Strike Rate:" + batsman3SrB);
        System.out.println("Team B Batsman 4 Name: " + batsman4NameB + " Runs:" + batsman4runsB + " Balls :"
                + batsman4ballsB + " Strike Rate:" + batsman4SrB);
        System.out.println("Team B Batsman 5 Name: " + batsman5NameB + " Runs:" + batsman5runsB + " Balls :"
                + batsman5ballsB + " Strike Rate:" + batsman5SrB);
        System.out.println("Team B Batsman 6 Name: " + batsman6NameB + " Runs:" + batsman6runsB + " Balls :"
                + batsman6ballsB + " Strike Rate:" + batsman6SrB);
        System.out.println("Team B Batsman 7 Name: " + batsman7NameB + " Runs:" + batsman7runsB + " Balls :"
                + batsman7ballsB + " Strike Rate:" + batsman7SrB);
        System.out.println("Team B Batsman 8 Name: " + batsman8NameB + " Runs:" + batsman8runsB + " Balls :"
                + batsman8ballsB + " Strike Rate:" + batsman8SrB);
        System.out.println("Team B Batsman 9 Name: " + batsman9NameB + " Runs:" + batsman9runsB + " Balls :"
                + batsman9ballsB + " Strike Rate:" + batsman9SrB);
        System.out.println("Team B Batsman 10 Name: " + batsman10NameB + " Runs:" + batsman10runsB + " Balls :"
                + batsman10ballsB + " Strike Rate:" + batsman10SrB);
        System.out.println("Team B Batsman 11 Name: " + batsman11NameB + " Runs:" + batsman11runsB + " Balls :"
                + batsman11ballsB + " Strike Rate:" + batsman11SrB);
        System.out.println("--------------------------");
        System.out.println("Team A Extras: " + teamAExtras);
        System.out.println("-----------------------------");
        System.out.println("Name:" + bowler1NameA + " Runs:" + bowler1runsA + " Balls:" + bowler1ballsCountA
                + " Wickets:" + bowler1wicketsA + " Extras:" + bowler1ExtrasA + " Economy:" + bowler1EconomyA);
        System.out.println("Name:" + bowler2NameA + " Runs:" + bowler2runsA + " Balls:" + bowler2ballsCountA
                + " Wickets:" + bowler2wicketsA + " Extras:" + bowler2ExtrasA + " Economy:" + bowler2EconomyA);
        System.out.println("Name:" + bowler3NameA + " Runs:" + bowler3runsA + " Balls:" + bowler3ballsCountA
                + " Wickets:" + bowler3wicketsA + " Extras:" + bowler3ExtrasA + " Economy:" + bowler3EconomyA);
        System.out.println("Name:" + bowler4NameA + " Runs:" + bowler4runsA + " Balls:" + bowler4ballsCountA
                + " Wickets:" + bowler4wicketsA + " Extras:" + bowler4ExtrasA + " Economy:" + bowler4EconomyA);
        System.out.println("Name:" + bowler5NameA + " Runs:" + bowler5runsA + " Balls:" + bowler5ballsCountA
                + " Wickets:" + bowler5wicketsA + " Extras:" + bowler5ExtrasA + " Economy:" + bowler5EconomyA);
        System.out.println("Name:" + bowler6NameA + " Runs:" + bowler6runsA + " Balls:" + bowler6ballsCountA
                + " Wickets:" + bowler6wicketsA + " Extras:" + bowler6ExtrasA + " Economy:" + bowler6EconomyA);
        System.out.println("Name:" + bowler7NameA + " Runs:" + bowler7runsA + " Balls:" + bowler7ballsCountA
                + " Wickets:" + bowler7wicketsA + " Extras:" + bowler7ExtrasA + " Economy:" + bowler7EconomyA);
        System.out.println("Name:" + bowler8NameA + " Runs:" + bowler8runsA + " Balls:" + bowler8ballsCountA
                + " Wickets:" + bowler8wicketsA + " Extras:" + bowler8ExtrasA + " Economy:" + bowler8EconomyA);
        System.out.println("Name:" + bowler9NameA + " Runs:" + bowler9runsA + " Balls:" + bowler9ballsCountA
                + " Wickets:" + bowler9wicketsA + " Extras:" + bowler9ExtrasA + " Economy:" + bowler9EconomyA);
        System.out.println("Name:" + bowler10NameA + " Runs:" + bowler10runsA + " Balls:" + bowler10ballsCountA
                + " Wickets:" + bowler10wicketsA + " Extras:" + bowler10ExtrasA + " Economy:" + bowler10EconomyA);
        System.out.println("Name:" + bowler11NameA + " Runs:" + bowler11runsA + " Balls:" + bowler11ballsCountA
                + " Wickets:" + bowler11wicketsA + " Extras:" + bowler11ExtrasA + " Economy:" + bowler11EconomyA);
        System.out.println("-----------------------------");

        if (battingTeamInSecondInnings.replaceAll("\\s", "").equals(Team1Name)) {
            if (team1TotalRuns > team2TotalRuns) {
                diff = team1TotalRuns - team2TotalRuns;
                System.out.println(Team1Name + " won the match by " + (10 - outs) + " wickets.");
                JOptionPane.showMessageDialog(f, Team1Name + " won the match by " + (10 - outs) + " wickets.",
                        "Match Over", JOptionPane.PLAIN_MESSAGE);
            } else if (team2TotalRuns > team1TotalRuns) {
                diff = team2TotalRuns - team1TotalRuns;
                System.out.println(Team2Name + " won the match by " + (diff) + " runs.");
                JOptionPane.showMessageDialog(f, Team2Name + " won the match by " + (diff) + " runs.", "Match Over",
                        JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(f, "Its a tie", "Match Draw", JOptionPane.PLAIN_MESSAGE);
            }
        } else if (battingTeamInSecondInnings.replaceAll("\\s", "").equals(Team2Name)) {
            if (team1TotalRuns > team2TotalRuns) {
                diff = team1TotalRuns - team2TotalRuns;
                System.out.println(Team1Name + " won the match by " + (diff) + " runs.");
                JOptionPane.showMessageDialog(f, Team1Name + " won the match by " + (diff) + " runs.", "Match Over",
                        JOptionPane.PLAIN_MESSAGE);
            } else if (team2TotalRuns > team1TotalRuns) {
                diff = team2TotalRuns - team1TotalRuns;
                System.out.println(Team2Name + " won the match by " + (10 - outs) + " wickets.");
                JOptionPane.showMessageDialog(f, Team2Name + " won the match by " + (10 - outs) + " wickets.",
                        "Match Over", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(f, "Its a tie", "Match Draw", JOptionPane.PLAIN_MESSAGE);
            }
        }
        f.dispose();
        ScoreCard3 sc3 = new ScoreCard3();
        sc3.scorecard69(team1Name, team2Name, matchesPlayedCnt);
    }

    public void addNewBatsman(String newBatsmanName) {
        if (battingTeamName.getText().replaceAll("\\s", "").equals(Team1Name)) {
            teamABatsmans.add(newBatsmanName);
        } else if (battingTeamName.getText().replaceAll("\\s", "").equals(Team2Name)) {
            teamBBatsmans.add(newBatsmanName);
        }
        System.out.println("Team A");
        System.out.println(teamABatsmans);
        System.out.println("Team B");
        System.out.println(teamBBatsmans);
    }

    public void addBatsmanRuns(String Striker, String NonStriker, Integer runsScoredPerBall, int addBalls) {
        if (battingTeamName.getText().replaceAll("\\s", "").equals(Team1Name)) {
            if (StrikerBatsman.isSelected()) {
                if (teamABatsmans.contains(Striker)) {
                    if (Striker.equals(batsman1NameA)) {
                        System.out.println("Batsman 1 on strike condition");
                        batsman1runsA += runsScoredPerBall;
                        batsman1ballsA += addBalls;
                        StrikerBatsmanRunsLabel.setText(batsman1runsA.toString());
                        StrikerBatsmanBallsLabel.setText("(" + batsman1ballsA + ")");
                    }
                    if (Striker.equals(batsman2NameA)) {
                        System.out.println("Batsman 2 on strike condition");
                        batsman2runsA += runsScoredPerBall;
                        batsman2ballsA += addBalls;
                        StrikerBatsmanRunsLabel.setText(batsman2runsA.toString());
                        StrikerBatsmanBallsLabel.setText("(" + batsman2ballsA + ")");
                    }
                    if (Striker.equals(batsman3NameA)) {
                        System.out.println("Batsman 3 on strike condition");
                        batsman3runsA += runsScoredPerBall;
                        batsman3ballsA += addBalls;
                        StrikerBatsmanRunsLabel.setText(batsman3runsA.toString());
                        StrikerBatsmanBallsLabel.setText("(" + batsman3ballsA + ")");
                    }
                    if (Striker.equals(batsman4NameA)) {
                        System.out.println("Batsman 4 on strike condition");
                        batsman4runsA += runsScoredPerBall;
                        batsman4ballsA += addBalls;
                        StrikerBatsmanRunsLabel.setText(batsman4runsA.toString());
                        StrikerBatsmanBallsLabel.setText("(" + batsman4ballsA + ")");
                    }
                    if (Striker.equals(batsman5NameA)) {
                        System.out.println("Batsman 5 on strike condition");
                        batsman5runsA += runsScoredPerBall;
                        batsman5ballsA += addBalls;
                        StrikerBatsmanRunsLabel.setText(batsman5runsA.toString());
                        StrikerBatsmanBallsLabel.setText("(" + batsman5ballsA + ")");
                    }
                    if (Striker.equals(batsman6NameA)) {
                        System.out.println("Batsman 6 on strike condition");
                        batsman6runsA += runsScoredPerBall;
                        batsman6ballsA += addBalls;
                        StrikerBatsmanRunsLabel.setText(batsman6runsA.toString());
                        StrikerBatsmanBallsLabel.setText("(" + batsman6ballsA + ")");
                    }
                    if (Striker.equals(batsman7NameA)) {
                        System.out.println("Batsman 7 on strike condition");
                        batsman7runsA += runsScoredPerBall;
                        batsman7ballsA += addBalls;
                        StrikerBatsmanRunsLabel.setText(batsman7runsA.toString());
                        StrikerBatsmanBallsLabel.setText("(" + batsman7ballsA + ")");
                    }
                    if (Striker.equals(batsman8NameA)) {
                        System.out.println("Batsman 8 on strike condition");
                        batsman8runsA += runsScoredPerBall;
                        batsman8ballsA += addBalls;
                        StrikerBatsmanRunsLabel.setText(batsman8runsA.toString());
                        StrikerBatsmanBallsLabel.setText("(" + batsman8ballsA + ")");
                    }
                    if (Striker.equals(batsman9NameA)) {
                        System.out.println("Batsman 9 on strike condition");
                        batsman9runsA += runsScoredPerBall;
                        batsman9ballsA += addBalls;
                        StrikerBatsmanRunsLabel.setText(batsman9runsA.toString());
                        StrikerBatsmanBallsLabel.setText("(" + batsman9ballsA + ")");
                    }
                    if (Striker.equals(batsman10NameA)) {
                        System.out.println("Batsman 10 on strike condition");
                        batsman10runsA += runsScoredPerBall;
                        batsman10ballsA += addBalls;
                        StrikerBatsmanRunsLabel.setText(batsman10runsA.toString());
                        StrikerBatsmanBallsLabel.setText("(" + batsman10ballsA + ")");
                    }
                    if (Striker.equals(batsman11NameA)) {
                        System.out.println("Batsman 11 on strike condition");
                        batsman11runsA += runsScoredPerBall;
                        batsman11ballsA += addBalls;
                        StrikerBatsmanRunsLabel.setText(batsman11runsA.toString());
                        StrikerBatsmanBallsLabel.setText("(" + batsman11ballsA + ")");
                    }

                    System.out.println("--------------------------");
                    System.out.println("Team A Batsman 1 Name: " + batsman1NameA + " Runs:" + batsman1runsA + " Balls :"
                            + batsman1ballsA);
                    System.out.println("Team A Batsman 2 Name: " + batsman2NameA + " Runs:" + batsman2runsA + " Balls :"
                            + batsman2ballsA);
                    System.out.println("Team A Batsman 3 Name: " + batsman3NameA + " Runs:" + batsman3runsA + " Balls :"
                            + batsman3ballsA);
                    System.out.println("Team A Batsman 4 Name: " + batsman4NameA + " Runs:" + batsman4runsA + " Balls :"
                            + batsman4ballsA);
                    System.out.println("Team A Batsman 5 Name: " + batsman5NameA + " Runs:" + batsman5runsA + " Balls :"
                            + batsman5ballsA);
                    System.out.println("Team A Batsman 6 Name: " + batsman6NameA + " Runs:" + batsman6runsA + " Balls :"
                            + batsman6ballsA);
                    System.out.println("Team A Batsman 7 Name: " + batsman7NameA + " Runs:" + batsman7runsA + " Balls :"
                            + batsman7ballsA);
                    System.out.println("Team A Batsman 8 Name: " + batsman8NameA + " Runs:" + batsman8runsA + " Balls :"
                            + batsman8ballsA);
                    System.out.println("Team A Batsman 9 Name: " + batsman9NameA + " Runs:" + batsman9runsA + " Balls :"
                            + batsman9ballsA);
                    System.out.println("Team A Batsman 10 Name: " + batsman10NameA + " Runs:" + batsman10runsA
                            + " Balls :" + batsman10ballsA);
                    System.out.println("Team A Batsman 11 Name: " + batsman11NameA + " Runs:" + batsman11runsA
                            + " Balls :" + batsman11ballsA);
                    System.out.println("--------------------------");

                } else {
                    System.out.println("Something's Wrong ...Batsman Missing");
                }
            } else if (nonStrikerBatsman.isSelected()) {
                if (teamABatsmans.contains(NonStriker)) {
                    if (NonStriker.equals(batsman1NameA)) {
                        System.out.println("Batsman 1 on strike condition");
                        batsman1runsA += runsScoredPerBall;
                        batsman1ballsA += addBalls;
                        NonStrikerBatsmanRunsLabel.setText(batsman1runsA.toString());
                        NonStrikerBatsmanBallsLabel.setText("(" + batsman1ballsA + ")");
                    }
                    if (NonStriker.equals(batsman2NameA)) {
                        System.out.println("Batsman 2 on strike condition");
                        batsman2runsA += runsScoredPerBall;
                        batsman2ballsA += addBalls;
                        NonStrikerBatsmanRunsLabel.setText(batsman2runsA.toString());
                        NonStrikerBatsmanBallsLabel.setText("(" + batsman2ballsA + ")");
                    }
                    if (NonStriker.equals(batsman3NameA)) {
                        System.out.println("Batsman 3 on strike condition");
                        batsman3runsA += runsScoredPerBall;
                        batsman3ballsA += addBalls;
                        NonStrikerBatsmanRunsLabel.setText(batsman3runsA.toString());
                        NonStrikerBatsmanBallsLabel.setText("(" + batsman3ballsA + ")");
                    }
                    if (NonStriker.equals(batsman4NameA)) {
                        System.out.println("Batsman 4 on strike condition");
                        batsman4runsA += runsScoredPerBall;
                        batsman4ballsA += addBalls;
                        NonStrikerBatsmanRunsLabel.setText(batsman4runsA.toString());
                        NonStrikerBatsmanBallsLabel.setText("(" + batsman4ballsA + ")");
                    }
                    if (NonStriker.equals(batsman5NameA)) {
                        System.out.println("Batsman 5 on strike condition");
                        batsman5runsA += runsScoredPerBall;
                        batsman5ballsA += addBalls;
                        NonStrikerBatsmanRunsLabel.setText(batsman5runsA.toString());
                        NonStrikerBatsmanBallsLabel.setText("(" + batsman5ballsA + ")");
                    }
                    if (NonStriker.equals(batsman6NameA)) {
                        System.out.println("Batsman 6 on strike condition");
                        batsman6runsA += runsScoredPerBall;
                        batsman6ballsA += addBalls;
                        NonStrikerBatsmanRunsLabel.setText(batsman6runsA.toString());
                        NonStrikerBatsmanBallsLabel.setText("(" + batsman6ballsA + ")");
                    }
                    if (NonStriker.equals(batsman7NameA)) {
                        System.out.println("Batsman 7 on strike condition");
                        batsman7runsA += runsScoredPerBall;
                        batsman7ballsA += addBalls;
                        NonStrikerBatsmanRunsLabel.setText(batsman7runsA.toString());
                        NonStrikerBatsmanBallsLabel.setText("(" + batsman7ballsA + ")");
                    }
                    if (NonStriker.equals(batsman8NameA)) {
                        System.out.println("Batsman 8 on strike condition");
                        batsman8runsA += runsScoredPerBall;
                        batsman8ballsA += addBalls;
                        NonStrikerBatsmanRunsLabel.setText(batsman8runsA.toString());
                        NonStrikerBatsmanBallsLabel.setText("(" + batsman8ballsA + ")");
                    }
                    if (NonStriker.equals(batsman9NameA)) {
                        System.out.println("Batsman 9 on strike condition");
                        batsman9runsA += runsScoredPerBall;
                        batsman9ballsA += addBalls;
                        NonStrikerBatsmanRunsLabel.setText(batsman9runsA.toString());
                        NonStrikerBatsmanBallsLabel.setText("(" + batsman9ballsA + ")");
                    }
                    if (NonStriker.equals(batsman10NameA)) {
                        System.out.println("Batsman 10 on strike condition");
                        batsman10runsA += runsScoredPerBall;
                        batsman10ballsA += addBalls;
                        NonStrikerBatsmanRunsLabel.setText(batsman10runsA.toString());
                        NonStrikerBatsmanBallsLabel.setText("(" + batsman10ballsA + ")");
                    }
                    if (NonStriker.equals(batsman11NameA)) {
                        System.out.println("Batsman 11 on strike condition");
                        batsman11runsA += runsScoredPerBall;
                        batsman11ballsA += addBalls;
                        NonStrikerBatsmanRunsLabel.setText(batsman11runsA.toString());
                        NonStrikerBatsmanBallsLabel.setText("(" + batsman11ballsA + ")");
                    }

                    System.out.println("--------------------------");
                    System.out.println("Team A Batsman 1 Name: " + batsman1NameA + " Runs:" + batsman1runsA + " Balls :"
                            + batsman1ballsA);
                    System.out.println("Team A Batsman 2 Name: " + batsman2NameA + " Runs:" + batsman2runsA + " Balls :"
                            + batsman2ballsA);
                    System.out.println("Team A Batsman 3 Name: " + batsman3NameA + " Runs:" + batsman3runsA + " Balls :"
                            + batsman3ballsA);
                    System.out.println("Team A Batsman 4 Name: " + batsman4NameA + " Runs:" + batsman4runsA + " Balls :"
                            + batsman4ballsA);
                    System.out.println("Team A Batsman 5 Name: " + batsman5NameA + " Runs:" + batsman5runsA + " Balls :"
                            + batsman5ballsA);
                    System.out.println("Team A Batsman 6 Name: " + batsman6NameA + " Runs:" + batsman6runsA + " Balls :"
                            + batsman6ballsA);
                    System.out.println("Team A Batsman 7 Name: " + batsman7NameA + " Runs:" + batsman7runsA + " Balls :"
                            + batsman7ballsA);
                    System.out.println("Team A Batsman 8 Name: " + batsman8NameA + " Runs:" + batsman8runsA + " Balls :"
                            + batsman8ballsA);
                    System.out.println("Team A Batsman 9 Name: " + batsman9NameA + " Runs:" + batsman9runsA + " Balls :"
                            + batsman9ballsA);
                    System.out.println("Team A Batsman 10 Name: " + batsman10NameA + " Runs:" + batsman10runsA
                            + " Balls :" + batsman10ballsA);
                    System.out.println("Team A Batsman 11 Name: " + batsman11NameA + " Runs:" + batsman11runsA
                            + " Balls :" + batsman11ballsA);
                    System.out.println("--------------------------");

                } else {
                    System.out.println("Something's Wrong ...Batsman Missing");
                }
            }
        } else if (battingTeamName.getText().replaceAll("\\s", "").equals(Team2Name)) {
            if (StrikerBatsman.isSelected()) {
                if (teamBBatsmans.contains(Striker)) {
                    if (Striker.equals(batsman1NameB)) {
                        System.out.println("Batsman 1 on strike condition");
                        batsman1runsB += runsScoredPerBall;
                        batsman1ballsB += addBalls;
                        StrikerBatsmanRunsLabel.setText(batsman1runsB.toString());
                        StrikerBatsmanBallsLabel.setText("(" + batsman1ballsB + ")");
                    }
                    if (Striker.equals(batsman2NameB)) {
                        System.out.println("Batsman 2 on strike condition");
                        batsman2runsB += runsScoredPerBall;
                        batsman2ballsB += addBalls;
                        StrikerBatsmanRunsLabel.setText(batsman2runsB.toString());
                        StrikerBatsmanBallsLabel.setText("(" + batsman2ballsB + ")");
                    }
                    if (Striker.equals(batsman3NameB)) {
                        System.out.println("Batsman 3 on strike condition");
                        batsman3runsB += runsScoredPerBall;
                        batsman3ballsB += addBalls;
                        StrikerBatsmanRunsLabel.setText(batsman3runsB.toString());
                        StrikerBatsmanBallsLabel.setText("(" + batsman3ballsB + ")");
                    }
                    if (Striker.equals(batsman4NameB)) {
                        System.out.println("Batsman 4 on strike condition");
                        batsman4runsB += runsScoredPerBall;
                        batsman4ballsB += addBalls;
                        StrikerBatsmanRunsLabel.setText(batsman4runsB.toString());
                        StrikerBatsmanBallsLabel.setText("(" + batsman4ballsB + ")");
                    }
                    if (Striker.equals(batsman5NameB)) {
                        System.out.println("Batsman 5 on strike condition");
                        batsman5runsB += runsScoredPerBall;
                        batsman5ballsB += addBalls;
                        StrikerBatsmanRunsLabel.setText(batsman5runsB.toString());
                        StrikerBatsmanBallsLabel.setText("(" + batsman5ballsB + ")");
                    }
                    if (Striker.equals(batsman6NameB)) {
                        System.out.println("Batsman 6 on strike condition");
                        batsman6runsB += runsScoredPerBall;
                        batsman6ballsB += addBalls;
                        StrikerBatsmanRunsLabel.setText(batsman6runsB.toString());
                        StrikerBatsmanBallsLabel.setText("(" + batsman6ballsB + ")");
                    }
                    if (Striker.equals(batsman7NameB)) {
                        System.out.println("Batsman 7 on strike condition");
                        batsman7runsB += runsScoredPerBall;
                        batsman7ballsB += addBalls;
                        StrikerBatsmanRunsLabel.setText(batsman7runsB.toString());
                        StrikerBatsmanBallsLabel.setText("(" + batsman7ballsB + ")");
                    }
                    if (Striker.equals(batsman8NameB)) {
                        System.out.println("Batsman 8 on strike condition");
                        batsman8runsB += runsScoredPerBall;
                        batsman8ballsB += addBalls;
                        StrikerBatsmanRunsLabel.setText(batsman8runsB.toString());
                        StrikerBatsmanBallsLabel.setText("(" + batsman8ballsB + ")");
                    }
                    if (Striker.equals(batsman9NameB)) {
                        System.out.println("Batsman 9 on strike condition");
                        batsman9runsB += runsScoredPerBall;
                        batsman9ballsB += addBalls;
                        StrikerBatsmanRunsLabel.setText(batsman9runsB.toString());
                        StrikerBatsmanBallsLabel.setText("(" + batsman9ballsB + ")");
                    }
                    if (Striker.equals(batsman10NameB)) {
                        System.out.println("Batsman 10 on strike condition");
                        batsman10runsB += runsScoredPerBall;
                        batsman10ballsB += addBalls;
                        StrikerBatsmanRunsLabel.setText(batsman10runsB.toString());
                        StrikerBatsmanBallsLabel.setText("(" + batsman10ballsB + ")");
                    }
                    if (Striker.equals(batsman11NameB)) {
                        System.out.println("Batsman 11 on strike condition");
                        batsman11runsB += runsScoredPerBall;
                        batsman11ballsB += addBalls;
                        StrikerBatsmanRunsLabel.setText(batsman11runsB.toString());
                        StrikerBatsmanBallsLabel.setText("(" + batsman11ballsB + ")");
                    }

                    System.out.println("--------------------------");
                    System.out.println("Team B Batsman 1 Name: " + batsman1NameB + " Runs:" + batsman1runsB + " Balls :"
                            + batsman1ballsB);
                    System.out.println("Team B Batsman 2 Name: " + batsman2NameB + " Runs:" + batsman2runsB + " Balls :"
                            + batsman2ballsB);
                    System.out.println("Team B Batsman 3 Name: " + batsman3NameB + " Runs:" + batsman3runsB + " Balls :"
                            + batsman3ballsB);
                    System.out.println("Team B Batsman 4 Name: " + batsman4NameB + " Runs:" + batsman4runsB + " Balls :"
                            + batsman4ballsB);
                    System.out.println("Team B Batsman 5 Name: " + batsman5NameB + " Runs:" + batsman5runsB + " Balls :"
                            + batsman5ballsB);
                    System.out.println("Team B Batsman 6 Name: " + batsman6NameB + " Runs:" + batsman6runsB + " Balls :"
                            + batsman6ballsB);
                    System.out.println("Team B Batsman 7 Name: " + batsman7NameB + " Runs:" + batsman7runsB + " Balls :"
                            + batsman7ballsB);
                    System.out.println("Team B Batsman 8 Name: " + batsman8NameB + " Runs:" + batsman8runsB + " Balls :"
                            + batsman8ballsB);
                    System.out.println("Team B Batsman 9 Name: " + batsman9NameB + " Runs:" + batsman9runsB + " Balls :"
                            + batsman9ballsB);
                    System.out.println("Team B Batsman 10 Name: " + batsman10NameB + " Runs:" + batsman10runsB
                            + " Balls :" + batsman10ballsB);
                    System.out.println("Team B Batsman 11 Name: " + batsman11NameB + " Runs:" + batsman11runsB
                            + " Balls :" + batsman11ballsB);
                    System.out.println("--------------------------");

                } else {
                    System.out.println("Something's Wrong ...Batsman Missing");
                }
            } else if (nonStrikerBatsman.isSelected()) {
                if (teamBBatsmans.contains(NonStriker)) {
                    if (NonStriker.equals(batsman1NameB)) {
                        System.out.println("Batsman 1 on strike condition");
                        batsman1runsB += runsScoredPerBall;
                        batsman1ballsB += addBalls;
                        NonStrikerBatsmanRunsLabel.setText(batsman1runsB.toString());
                        NonStrikerBatsmanBallsLabel.setText("(" + batsman1ballsB + ")");
                    }
                    if (NonStriker.equals(batsman2NameB)) {
                        System.out.println("Batsman 2 on strike condition");
                        batsman2runsB += runsScoredPerBall;
                        batsman2ballsB += addBalls;
                        NonStrikerBatsmanRunsLabel.setText(batsman2runsB.toString());
                        NonStrikerBatsmanBallsLabel.setText("(" + batsman2ballsB + ")");
                    }
                    if (NonStriker.equals(batsman3NameB)) {
                        System.out.println("Batsman 3 on strike condition");
                        batsman3runsB += runsScoredPerBall;
                        batsman3ballsB += addBalls;
                        NonStrikerBatsmanRunsLabel.setText(batsman3runsB.toString());
                        NonStrikerBatsmanBallsLabel.setText("(" + batsman3ballsB + ")");
                    }
                    if (NonStriker.equals(batsman4NameB)) {
                        System.out.println("Batsman 4 on strike condition");
                        batsman4runsB += runsScoredPerBall;
                        batsman4ballsB += addBalls;
                        NonStrikerBatsmanRunsLabel.setText(batsman4runsB.toString());
                        NonStrikerBatsmanBallsLabel.setText("(" + batsman4ballsB + ")");
                    }
                    if (NonStriker.equals(batsman5NameB)) {
                        System.out.println("Batsman 5 on strike condition");
                        batsman5runsB += runsScoredPerBall;
                        batsman5ballsB += addBalls;
                        NonStrikerBatsmanRunsLabel.setText(batsman5runsB.toString());
                        NonStrikerBatsmanBallsLabel.setText("(" + batsman5ballsB + ")");
                    }
                    if (NonStriker.equals(batsman6NameB)) {
                        System.out.println("Batsman 6 on strike condition");
                        batsman6runsB += runsScoredPerBall;
                        batsman6ballsB += addBalls;
                        NonStrikerBatsmanRunsLabel.setText(batsman6runsB.toString());
                        NonStrikerBatsmanBallsLabel.setText("(" + batsman6ballsB + ")");
                    }
                    if (NonStriker.equals(batsman7NameB)) {
                        System.out.println("Batsman 7 on strike condition");
                        batsman7runsB += runsScoredPerBall;
                        batsman7ballsB += addBalls;
                        NonStrikerBatsmanRunsLabel.setText(batsman7runsB.toString());
                        NonStrikerBatsmanBallsLabel.setText("(" + batsman7ballsB + ")");
                    }
                    if (NonStriker.equals(batsman8NameB)) {
                        System.out.println("Batsman 8 on strike condition");
                        batsman8runsB += runsScoredPerBall;
                        batsman8ballsB += addBalls;
                        NonStrikerBatsmanRunsLabel.setText(batsman8runsB.toString());
                        NonStrikerBatsmanBallsLabel.setText("(" + batsman8ballsB + ")");
                    }
                    if (NonStriker.equals(batsman9NameB)) {
                        System.out.println("Batsman 9 on strike condition");
                        batsman9runsB += runsScoredPerBall;
                        batsman9ballsB += addBalls;
                        NonStrikerBatsmanRunsLabel.setText(batsman9runsB.toString());
                        NonStrikerBatsmanBallsLabel.setText("(" + batsman9ballsB + ")");
                    }
                    if (NonStriker.equals(batsman10NameB)) {
                        System.out.println("Batsman 10 on strike condition");
                        batsman10runsB += runsScoredPerBall;
                        batsman10ballsB += addBalls;
                        NonStrikerBatsmanRunsLabel.setText(batsman10runsB.toString());
                        NonStrikerBatsmanBallsLabel.setText("(" + batsman10ballsB + ")");
                    }
                    if (NonStriker.equals(batsman11NameB)) {
                        System.out.println("Batsman 11 on strike condition");
                        batsman11runsB += runsScoredPerBall;
                        batsman11ballsB += addBalls;
                        NonStrikerBatsmanRunsLabel.setText(batsman11runsB.toString());
                        NonStrikerBatsmanBallsLabel.setText("(" + batsman11ballsB + ")");
                    }

                    System.out.println("--------------------------");
                    System.out.println("Team B Batsman 1 Name: " + batsman1NameB + " Runs:" + batsman1runsB + " Balls :"
                            + batsman1ballsB);
                    System.out.println("Team B Batsman 2 Name: " + batsman2NameB + " Runs:" + batsman2runsB + " Balls :"
                            + batsman2ballsB);
                    System.out.println("Team B Batsman 3 Name: " + batsman3NameB + " Runs:" + batsman3runsB + " Balls :"
                            + batsman3ballsB);
                    System.out.println("Team B Batsman 4 Name: " + batsman4NameB + " Runs:" + batsman4runsB + " Balls :"
                            + batsman4ballsB);
                    System.out.println("Team B Batsman 5 Name: " + batsman5NameB + " Runs:" + batsman5runsB + " Balls :"
                            + batsman5ballsB);
                    System.out.println("Team B Batsman 6 Name: " + batsman6NameB + " Runs:" + batsman6runsB + " Balls :"
                            + batsman6ballsB);
                    System.out.println("Team B Batsman 7 Name: " + batsman7NameB + " Runs:" + batsman7runsB + " Balls :"
                            + batsman7ballsB);
                    System.out.println("Team B Batsman 8 Name: " + batsman8NameB + " Runs:" + batsman8runsB + " Balls :"
                            + batsman8ballsB);
                    System.out.println("Team B Batsman 9 Name: " + batsman9NameB + " Runs:" + batsman9runsB + " Balls :"
                            + batsman9ballsB);
                    System.out.println("Team B Batsman 10 Name: " + batsman10NameB + " Runs:" + batsman10runsB
                            + " Balls :" + batsman10ballsB);
                    System.out.println("Team B Batsman 11 Name: " + batsman11NameB + " Runs:" + batsman11runsB
                            + " Balls :" + batsman11ballsB);
                    System.out.println("--------------------------");

                } else {
                    System.out.println("Something's Wrong ...Batsman Missing");
                }
            }
        }

    }

    public void addBowlerWickets(String CurrentBowler, int wickets) {

        String newBowler = CurrentBowler;
        addBowlerRuns(newBowler, 0, 1, 1, 0);

    }

    // int tempBowlerRunsCnt = 0;
    // int totalRunsOfCurrentBowler = 0;
    // Boolean execute = true;
    public void addBowlerRuns(String CurrentBowler, int runsPerBall, int wickets, int ballsCnt, int extras) {
        // tempBowlerRunsCnt+=1;
        String newBowler = CurrentBowler;
        Integer indexOfBowler = 0;

        if (battingTeamName.getText().replaceAll("\\s", "").equals(Team1Name)) {
            if (teamBBowlers.contains(newBowler)) {
                indexOfBowler = teamBBowlers.indexOf(newBowler);
                if (indexOfBowler == 0) {
                    bowler1NameB = CurrentBowler;
                    bowler1runsB += runsPerBall;
                    bowler1wicketsB += wickets;
                    bowler1ballsCountB += ballsCnt;
                    bowler1ExtrasB += extras;
                }
                if (indexOfBowler == 1) {
                    bowler2NameB = CurrentBowler;
                    bowler2runsB += runsPerBall;
                    bowler2wicketsB += wickets;
                    bowler2ballsCountB += ballsCnt;
                    bowler2ExtrasB += extras;
                }
                if (indexOfBowler == 2) {
                    bowler3NameB = CurrentBowler;
                    bowler3runsB += runsPerBall;
                    bowler3wicketsB += wickets;
                    bowler3ballsCountB += ballsCnt;
                    bowler3ExtrasB += extras;
                }
                if (indexOfBowler == 3) {
                    bowler4NameB = CurrentBowler;
                    bowler4runsB += runsPerBall;
                    bowler4wicketsB += wickets;
                    bowler4ballsCountB += ballsCnt;
                    bowler4ExtrasB += extras;
                }
                if (indexOfBowler == 4) {
                    bowler5NameB = CurrentBowler;
                    bowler5runsB += runsPerBall;
                    bowler5wicketsB += wickets;
                    bowler5ballsCountB += ballsCnt;
                    bowler5ExtrasB += extras;
                }
                if (indexOfBowler == 5) {
                    bowler6NameB = CurrentBowler;
                    bowler6runsB += runsPerBall;
                    bowler6wicketsB += wickets;
                    bowler6ballsCountB += ballsCnt;
                    bowler6ExtrasB += extras;
                }
                if (indexOfBowler == 6) {
                    bowler7NameB = CurrentBowler;
                    bowler7runsB += runsPerBall;
                    bowler7wicketsB += wickets;
                    bowler7ballsCountB += ballsCnt;
                    bowler7ExtrasB += extras;
                }
                if (indexOfBowler == 7) {
                    bowler8NameB = CurrentBowler;
                    bowler8runsB += runsPerBall;
                    bowler8wicketsB += wickets;
                    bowler8ballsCountB += ballsCnt;
                    bowler8ExtrasB += extras;
                }
                if (indexOfBowler == 8) {
                    bowler9NameB = CurrentBowler;
                    bowler9runsB += runsPerBall;
                    bowler9wicketsB += wickets;
                    bowler9ballsCountB += ballsCnt;
                    bowler9ExtrasB += extras;
                }
                if (indexOfBowler == 9) {
                    bowler10NameB = CurrentBowler;
                    bowler10runsB += runsPerBall;
                    bowler10wicketsB += wickets;
                    bowler10ballsCountB += ballsCnt;
                    bowler10ExtrasB += extras;
                }
                if (indexOfBowler == 10) {
                    bowler11NameB = CurrentBowler;
                    bowler11runsB += runsPerBall;
                    bowler11wicketsB += wickets;
                    bowler11ballsCountB += ballsCnt;
                    bowler11ExtrasB += extras;
                }

                System.out.println("-----------------------------");
                System.out.println("Name:" + bowler1NameB + " Runs:" + bowler1runsB + " Balls:" + bowler1ballsCountB
                        + " Wickets:" + bowler1wicketsB + " Extras:" + bowler1ExtrasB);
                System.out.println("Name:" + bowler2NameB + " Runs:" + bowler2runsB + " Balls:" + bowler2ballsCountB
                        + " Wickets:" + bowler2wicketsB + " Extras:" + bowler2ExtrasB);
                System.out.println("Name:" + bowler3NameB + " Runs:" + bowler3runsB + " Balls:" + bowler3ballsCountB
                        + " Wickets:" + bowler3wicketsB + " Extras:" + bowler3ExtrasB);
                System.out.println("Name:" + bowler4NameB + " Runs:" + bowler4runsB + " Balls:" + bowler4ballsCountB
                        + " Wickets:" + bowler4wicketsB + " Extras:" + bowler4ExtrasB);
                System.out.println("Name:" + bowler5NameB + " Runs:" + bowler5runsB + " Balls:" + bowler5ballsCountB
                        + " Wickets:" + bowler5wicketsB + " Extras:" + bowler5ExtrasB);
                System.out.println("Name:" + bowler6NameB + " Runs:" + bowler6runsB + " Balls:" + bowler6ballsCountB
                        + " Wickets:" + bowler6wicketsB + " Extras:" + bowler6ExtrasB);
                System.out.println("Name:" + bowler7NameB + " Runs:" + bowler7runsB + " Balls:" + bowler7ballsCountB
                        + " Wickets:" + bowler7wicketsB + " Extras:" + bowler7ExtrasB);
                System.out.println("Name:" + bowler8NameB + " Runs:" + bowler8runsB + " Balls:" + bowler8ballsCountB
                        + " Wickets:" + bowler8wicketsB + " Extras:" + bowler8ExtrasB);
                System.out.println("Name:" + bowler9NameB + " Runs:" + bowler9runsB + " Balls:" + bowler9ballsCountB
                        + " Wickets:" + bowler9wicketsB + " Extras:" + bowler9ExtrasB);
                System.out.println("Name:" + bowler10NameB + " Runs:" + bowler10runsB + " Balls:" + bowler10ballsCountB
                        + " Wickets:" + bowler10wicketsB + " Extras:" + bowler10ExtrasB);
                System.out.println("Name:" + bowler11NameB + " Runs:" + bowler11runsB + " Balls:" + bowler11ballsCountB
                        + " Wickets:" + bowler11wicketsB + " Extras:" + bowler11ExtrasB);
                System.out.println("-----------------------------");
            } else {
                teamBBowlers.add(newBowler);
                indexOfBowler = teamBBowlers.indexOf(newBowler);

                if (indexOfBowler == 0) {
                    bowler1NameB = CurrentBowler;
                    bowler1runsB += runsPerBall;
                    bowler1wicketsB += wickets;
                    bowler1ballsCountB += ballsCnt;
                    bowler1ExtrasB += extras;
                }
                if (indexOfBowler == 1) {
                    bowler2NameB = CurrentBowler;
                    bowler2runsB += runsPerBall;
                    bowler2wicketsB += wickets;
                    bowler2ballsCountB += ballsCnt;
                    bowler2ExtrasB += extras;
                }
                if (indexOfBowler == 2) {
                    bowler3NameB = CurrentBowler;
                    bowler3runsB += runsPerBall;
                    bowler3wicketsB += wickets;
                    bowler3ballsCountB += ballsCnt;
                    bowler3ExtrasB += extras;
                }
                if (indexOfBowler == 3) {
                    bowler4NameB = CurrentBowler;
                    bowler4runsB += runsPerBall;
                    bowler4wicketsB += wickets;
                    bowler4ballsCountB += ballsCnt;
                    bowler4ExtrasB += extras;
                }
                if (indexOfBowler == 4) {
                    bowler5NameB = CurrentBowler;
                    bowler5runsB += runsPerBall;
                    bowler5wicketsB += wickets;
                    bowler5ballsCountB += ballsCnt;
                    bowler5ExtrasB += extras;
                }
                if (indexOfBowler == 5) {
                    bowler6NameB = CurrentBowler;
                    bowler6runsB += runsPerBall;
                    bowler6wicketsB += wickets;
                    bowler6ballsCountB += ballsCnt;
                    bowler6ExtrasB += extras;
                }
                if (indexOfBowler == 6) {
                    bowler7NameB = CurrentBowler;
                    bowler7runsB += runsPerBall;
                    bowler7wicketsB += wickets;
                    bowler7ballsCountB += ballsCnt;
                    bowler7ExtrasB += extras;
                }
                if (indexOfBowler == 7) {
                    bowler8NameB = CurrentBowler;
                    bowler8runsB += runsPerBall;
                    bowler8wicketsB += wickets;
                    bowler8ballsCountB += ballsCnt;
                    bowler8ExtrasB += extras;
                }
                if (indexOfBowler == 8) {
                    bowler9NameB = CurrentBowler;
                    bowler9runsB += runsPerBall;
                    bowler9wicketsB += wickets;
                    bowler9ballsCountB += ballsCnt;
                    bowler9ExtrasB += extras;
                }
                if (indexOfBowler == 9) {
                    bowler10NameB = CurrentBowler;
                    bowler10runsB += runsPerBall;
                    bowler10wicketsB += wickets;
                    bowler10ballsCountB += ballsCnt;
                    bowler10ExtrasB += extras;
                }
                if (indexOfBowler == 10) {
                    bowler11NameB = CurrentBowler;
                    bowler11runsB += runsPerBall;
                    bowler11wicketsB += wickets;
                    bowler11ballsCountB += ballsCnt;
                    bowler11ExtrasB += extras;
                }

                System.out.println("-----------------------------");
                System.out.println("Name:" + bowler1NameB + " Runs:" + bowler1runsB + " Balls:" + bowler1ballsCountB
                        + " Wickets:" + bowler1wicketsB + " Extras:" + bowler1ExtrasB);
                System.out.println("Name:" + bowler2NameB + " Runs:" + bowler2runsB + " Balls:" + bowler2ballsCountB
                        + " Wickets:" + bowler2wicketsB + " Extras:" + bowler2ExtrasB);
                System.out.println("Name:" + bowler3NameB + " Runs:" + bowler3runsB + " Balls:" + bowler3ballsCountB
                        + " Wickets:" + bowler3wicketsB + " Extras:" + bowler3ExtrasB);
                System.out.println("Name:" + bowler4NameB + " Runs:" + bowler4runsB + " Balls:" + bowler4ballsCountB
                        + " Wickets:" + bowler4wicketsB + " Extras:" + bowler4ExtrasB);
                System.out.println("Name:" + bowler5NameB + " Runs:" + bowler5runsB + " Balls:" + bowler5ballsCountB
                        + " Wickets:" + bowler5wicketsB + " Extras:" + bowler5ExtrasB);
                System.out.println("Name:" + bowler6NameB + " Runs:" + bowler6runsB + " Balls:" + bowler6ballsCountB
                        + " Wickets:" + bowler6wicketsB + " Extras:" + bowler6ExtrasB);
                System.out.println("Name:" + bowler7NameB + " Runs:" + bowler7runsB + " Balls:" + bowler7ballsCountB
                        + " Wickets:" + bowler7wicketsB + " Extras:" + bowler7ExtrasB);
                System.out.println("Name:" + bowler8NameB + " Runs:" + bowler8runsB + " Balls:" + bowler8ballsCountB
                        + " Wickets:" + bowler8wicketsB + " Extras:" + bowler8ExtrasB);
                System.out.println("Name:" + bowler9NameB + " Runs:" + bowler9runsB + " Balls:" + bowler9ballsCountB
                        + " Wickets:" + bowler9wicketsB + " Extras:" + bowler9ExtrasB);
                System.out.println("Name:" + bowler10NameB + " Runs:" + bowler10runsB + " Balls:" + bowler10ballsCountB
                        + " Wickets:" + bowler10wicketsB + " Extras:" + bowler10ExtrasB);
                System.out.println("Name:" + bowler11NameB + " Runs:" + bowler11runsB + " Balls:" + bowler11ballsCountB
                        + " Wickets:" + bowler11wicketsB + " Extras:" + bowler11ExtrasB);
                System.out.println("-----------------------------");
            }
        } else if (battingTeamName.getText().replaceAll("\\s", "").equals(Team2Name)) {
            if (teamABowlers.contains(newBowler)) {
                indexOfBowler = teamABowlers.indexOf(newBowler);
                if (indexOfBowler == 0) {
                    bowler1NameA = CurrentBowler;
                    bowler1runsA += runsPerBall;
                    bowler1wicketsA += wickets;
                    bowler1ballsCountA += ballsCnt;
                    bowler1ExtrasA += extras;
                }
                if (indexOfBowler == 1) {
                    bowler2NameA = CurrentBowler;
                    bowler2runsA += runsPerBall;
                    bowler2wicketsA += wickets;
                    bowler2ballsCountA += ballsCnt;
                    bowler2ExtrasA += extras;
                }
                if (indexOfBowler == 2) {
                    bowler3NameA = CurrentBowler;
                    bowler3runsA += runsPerBall;
                    bowler3wicketsA += wickets;
                    bowler3ballsCountA += ballsCnt;
                    bowler3ExtrasA += extras;
                }
                if (indexOfBowler == 3) {
                    bowler4NameA = CurrentBowler;
                    bowler4runsA += runsPerBall;
                    bowler4wicketsA += wickets;
                    bowler4ballsCountA += ballsCnt;
                    bowler4ExtrasA += extras;
                }
                if (indexOfBowler == 4) {
                    bowler5NameA = CurrentBowler;
                    bowler5runsA += runsPerBall;
                    bowler5wicketsA += wickets;
                    bowler5ballsCountA += ballsCnt;
                    bowler5ExtrasA += extras;
                }
                if (indexOfBowler == 5) {
                    bowler6NameA = CurrentBowler;
                    bowler6runsA += runsPerBall;
                    bowler6wicketsA += wickets;
                    bowler6ballsCountA += ballsCnt;
                    bowler6ExtrasA += extras;
                }
                if (indexOfBowler == 6) {
                    bowler7NameA = CurrentBowler;
                    bowler7runsA += runsPerBall;
                    bowler7wicketsA += wickets;
                    bowler7ballsCountA += ballsCnt;
                    bowler7ExtrasA += extras;
                }
                if (indexOfBowler == 7) {
                    bowler8NameA = CurrentBowler;
                    bowler8runsA += runsPerBall;
                    bowler8wicketsA += wickets;
                    bowler8ballsCountA += ballsCnt;
                    bowler8ExtrasA += extras;
                }
                if (indexOfBowler == 8) {
                    bowler9NameA = CurrentBowler;
                    bowler9runsA += runsPerBall;
                    bowler9wicketsA += wickets;
                    bowler9ballsCountA += ballsCnt;
                    bowler9ExtrasA += extras;
                }
                if (indexOfBowler == 9) {
                    bowler10NameA = CurrentBowler;
                    bowler10runsA += runsPerBall;
                    bowler10wicketsA += wickets;
                    bowler10ballsCountA += ballsCnt;
                    bowler10ExtrasA += extras;
                }
                if (indexOfBowler == 10) {
                    bowler11NameA = CurrentBowler;
                    bowler11runsA += runsPerBall;
                    bowler11wicketsA += wickets;
                    bowler11ballsCountA += ballsCnt;
                    bowler11ExtrasA += extras;
                }

                System.out.println("-----------------------------");
                System.out.println("Name:" + bowler1NameA + " Runs:" + bowler1runsA + " Balls:" + bowler1ballsCountA
                        + " Wickets:" + bowler1wicketsA + " Extras:" + bowler1ExtrasA);
                System.out.println("Name:" + bowler2NameA + " Runs:" + bowler2runsA + " Balls:" + bowler2ballsCountA
                        + " Wickets:" + bowler2wicketsA + " Extras:" + bowler2ExtrasA);
                System.out.println("Name:" + bowler3NameA + " Runs:" + bowler3runsA + " Balls:" + bowler3ballsCountA
                        + " Wickets:" + bowler3wicketsA + " Extras:" + bowler3ExtrasA);
                System.out.println("Name:" + bowler4NameA + " Runs:" + bowler4runsA + " Balls:" + bowler4ballsCountA
                        + " Wickets:" + bowler4wicketsA + " Extras:" + bowler4ExtrasA);
                System.out.println("Name:" + bowler5NameA + " Runs:" + bowler5runsA + " Balls:" + bowler5ballsCountA
                        + " Wickets:" + bowler5wicketsA + " Extras:" + bowler5ExtrasA);
                System.out.println("Name:" + bowler6NameA + " Runs:" + bowler6runsA + " Balls:" + bowler6ballsCountA
                        + " Wickets:" + bowler6wicketsA + " Extras:" + bowler6ExtrasA);
                System.out.println("Name:" + bowler7NameA + " Runs:" + bowler7runsA + " Balls:" + bowler7ballsCountA
                        + " Wickets:" + bowler7wicketsA + " Extras:" + bowler7ExtrasA);
                System.out.println("Name:" + bowler8NameA + " Runs:" + bowler8runsA + " Balls:" + bowler8ballsCountA
                        + " Wickets:" + bowler8wicketsA + " Extras:" + bowler8ExtrasA);
                System.out.println("Name:" + bowler9NameA + " Runs:" + bowler9runsA + " Balls:" + bowler9ballsCountA
                        + " Wickets:" + bowler9wicketsA + " Extras:" + bowler9ExtrasA);
                System.out.println("Name:" + bowler10NameA + " Runs:" + bowler10runsA + " Balls:" + bowler10ballsCountA
                        + " Wickets:" + bowler10wicketsA + " Extras:" + bowler10ExtrasA);
                System.out.println("Name:" + bowler11NameA + " Runs:" + bowler11runsA + " Balls:" + bowler11ballsCountA
                        + " Wickets:" + bowler11wicketsA + " Extras:" + bowler11ExtrasA);
                System.out.println("-----------------------------");
            } else {
                teamABowlers.add(newBowler);
                indexOfBowler = teamABowlers.indexOf(newBowler);

                if (indexOfBowler == 0) {
                    bowler1NameA = CurrentBowler;
                    bowler1runsA += runsPerBall;
                    bowler1wicketsA += wickets;
                    bowler1ballsCountA += ballsCnt;
                    bowler1ExtrasA += extras;
                }
                if (indexOfBowler == 1) {
                    bowler2NameA = CurrentBowler;
                    bowler2runsA += runsPerBall;
                    bowler2wicketsA += wickets;
                    bowler2ballsCountA += ballsCnt;
                    bowler2ExtrasA += extras;
                }
                if (indexOfBowler == 2) {
                    bowler3NameA = CurrentBowler;
                    bowler3runsA += runsPerBall;
                    bowler3wicketsA += wickets;
                    bowler3ballsCountA += ballsCnt;
                    bowler3ExtrasA += extras;
                }
                if (indexOfBowler == 3) {
                    bowler4NameA = CurrentBowler;
                    bowler4runsA += runsPerBall;
                    bowler4wicketsA += wickets;
                    bowler4ballsCountA += ballsCnt;
                    bowler4ExtrasA += extras;
                }
                if (indexOfBowler == 4) {
                    bowler5NameA = CurrentBowler;
                    bowler5runsA += runsPerBall;
                    bowler5wicketsA += wickets;
                    bowler5ballsCountA += ballsCnt;
                    bowler5ExtrasA += extras;
                }
                if (indexOfBowler == 5) {
                    bowler6NameA = CurrentBowler;
                    bowler6runsA += runsPerBall;
                    bowler6wicketsA += wickets;
                    bowler6ballsCountA += ballsCnt;
                    bowler6ExtrasA += extras;
                }
                if (indexOfBowler == 6) {
                    bowler7NameA = CurrentBowler;
                    bowler7runsA += runsPerBall;
                    bowler7wicketsA += wickets;
                    bowler7ballsCountA += ballsCnt;
                    bowler7ExtrasA += extras;
                }
                if (indexOfBowler == 7) {
                    bowler8NameA = CurrentBowler;
                    bowler8runsA += runsPerBall;
                    bowler8wicketsA += wickets;
                    bowler8ballsCountA += ballsCnt;
                    bowler8ExtrasA += extras;
                }
                if (indexOfBowler == 8) {
                    bowler9NameA = CurrentBowler;
                    bowler9runsA += runsPerBall;
                    bowler9wicketsA += wickets;
                    bowler9ballsCountA += ballsCnt;
                    bowler9ExtrasA += extras;
                }
                if (indexOfBowler == 9) {
                    bowler10NameA = CurrentBowler;
                    bowler10runsA += runsPerBall;
                    bowler10wicketsA += wickets;
                    bowler10ballsCountA += ballsCnt;
                    bowler10ExtrasA += extras;
                }
                if (indexOfBowler == 10) {
                    bowler11NameA = CurrentBowler;
                    bowler11runsA += runsPerBall;
                    bowler11wicketsA += wickets;
                    bowler11ballsCountA += ballsCnt;
                    bowler11ExtrasA += extras;
                }

                System.out.println("-----------------------------");
                System.out.println("Name:" + bowler1NameA + " Runs:" + bowler1runsA + " Balls:" + bowler1ballsCountA
                        + " Wickets:" + bowler1wicketsA + " Extras:" + bowler1ExtrasA);
                System.out.println("Name:" + bowler2NameA + " Runs:" + bowler2runsA + " Balls:" + bowler2ballsCountA
                        + " Wickets:" + bowler2wicketsA + " Extras:" + bowler2ExtrasA);
                System.out.println("Name:" + bowler3NameA + " Runs:" + bowler3runsA + " Balls:" + bowler3ballsCountA
                        + " Wickets:" + bowler3wicketsA + " Extras:" + bowler3ExtrasA);
                System.out.println("Name:" + bowler4NameA + " Runs:" + bowler4runsA + " Balls:" + bowler4ballsCountA
                        + " Wickets:" + bowler4wicketsA + " Extras:" + bowler4ExtrasA);
                System.out.println("Name:" + bowler5NameA + " Runs:" + bowler5runsA + " Balls:" + bowler5ballsCountA
                        + " Wickets:" + bowler5wicketsA + " Extras:" + bowler5ExtrasA);
                System.out.println("Name:" + bowler6NameA + " Runs:" + bowler6runsA + " Balls:" + bowler6ballsCountA
                        + " Wickets:" + bowler6wicketsA + " Extras:" + bowler6ExtrasA);
                System.out.println("Name:" + bowler7NameA + " Runs:" + bowler7runsA + " Balls:" + bowler7ballsCountA
                        + " Wickets:" + bowler7wicketsA + " Extras:" + bowler7ExtrasA);
                System.out.println("Name:" + bowler8NameA + " Runs:" + bowler8runsA + " Balls:" + bowler8ballsCountA
                        + " Wickets:" + bowler8wicketsA + " Extras:" + bowler8ExtrasA);
                System.out.println("Name:" + bowler9NameA + " Runs:" + bowler9runsA + " Balls:" + bowler9ballsCountA
                        + " Wickets:" + bowler9wicketsA + " Extras:" + bowler9ExtrasA);
                System.out.println("Name:" + bowler10NameA + " Runs:" + bowler10runsA + " Balls:" + bowler10ballsCountA
                        + " Wickets:" + bowler10wicketsA + " Extras:" + bowler10ExtrasA);
                System.out.println("Name:" + bowler11NameA + " Runs:" + bowler11runsA + " Balls:" + bowler11ballsCountA
                        + " Wickets:" + bowler11wicketsA + " Extras:" + bowler11ExtrasA);
                System.out.println("-----------------------------");
            }
        }
        System.out.println("TeamA bowlers as follows");
        System.out.println(teamABowlers);
        System.out.println("TeamB bowlers as follows");
        System.out.println(teamBBowlers);
        System.out.println("-------------------------");
    }

    // public static void main(String[] args) {
    // try {
    // // System.out.println("The program's"+"\t"+" working properly");
    // // new Scoring();
    // Scoring obs3 = new Scoring()
    // obs3.Scoringfunc();

    // } catch (Exception e) {
    // //TODO: handle exception
    // }

    // }
    @Override
    public void actionPerformed(ActionEvent e) {
        String text = l.getText();

        if (e.getSource() == zero) {
            runsShow += 0;
            DisplayRuns.setText(runsShow.toString());
            cnt += 1;
            oversDecimal.setText(cnt.toString());
            System.out.println("No Run");
            text = text + "    " + "0";
            l.setText(text);
            addBatsmanRuns(StrikerBatsman.getText().replaceAll("\\s", ""),
                    nonStrikerBatsman.getText().replaceAll("\\s", ""), 0, 1);
            addBowlerRuns(currentBowler.substring(2).replaceAll("\\s", ""), 0, 0, 1, 0);
            overComplete();
        }
        OneRunAction: if (e.getSource() == one) {
            runsShow += 1;
            DisplayRuns.setText(runsShow.toString());
            cnt += 1;
            oversDecimal.setText(cnt.toString());
            System.out.println("Single Run");
            text = text + "    " + "1";
            l.setText(text);
            addBatsmanRuns(StrikerBatsman.getText().replaceAll("\\s", ""),
                    nonStrikerBatsman.getText().replaceAll("\\s", ""), 1, 1);
            switchBatsman();
            addBowlerRuns(currentBowler.substring(2).replaceAll("\\s", ""), 1, 0, 1, 0);
            if (inningsCnt == 1) {
                if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team2Name)))) {
                    if (runsShow > team1TotalRuns) {
                        team2TotalRuns = runsShow;
                        clearScoringPage();
                        JOptionPane.showMessageDialog(f, "2nd Innings Over");
                        try {
                            calculateMatchSummary(battingTeamName.getText());
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        break OneRunAction;
                    }
                } else if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team1Name)))) {
                    if (runsShow > team2TotalRuns) {
                        team1TotalRuns = runsShow;
                        clearScoringPage();
                        JOptionPane.showMessageDialog(f, "2nd Innings Over");
                        try {
                            calculateMatchSummary(battingTeamName.getText());
                        } catch (Exception e1) {

                            e1.printStackTrace();
                        }
                        break OneRunAction;
                    }
                }
            }

            overComplete();

        }
        TwoRunAction: if (e.getSource() == two) {
            runsShow += 2;
            DisplayRuns.setText(runsShow.toString());

            cnt += 1;
            oversDecimal.setText(cnt.toString());
            System.out.println("Two runs");
            text = text + "    " + "2";
            l.setText(text);
            addBatsmanRuns(StrikerBatsman.getText().replaceAll("\\s", ""),
                    nonStrikerBatsman.getText().replaceAll("\\s", ""), 2, 1);
            addBowlerRuns(currentBowler.substring(2).replaceAll("\\s", ""), 2, 0, 1, 0);
            if (inningsCnt == 1) {
                if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team2Name)))) {
                    if (runsShow > team1TotalRuns) {
                        team2TotalRuns = runsShow;
                        clearScoringPage();
                        JOptionPane.showMessageDialog(f, "2nd Innings Over");
                        try {
                            calculateMatchSummary(battingTeamName.getText());
                        } catch (Exception e1) {

                            e1.printStackTrace();
                        }
                        break TwoRunAction;
                    }
                } else if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team1Name)))) {
                    if (runsShow > team2TotalRuns) {
                        team1TotalRuns = runsShow;
                        clearScoringPage();
                        JOptionPane.showMessageDialog(f, "2nd Innings Over");
                        try {
                            calculateMatchSummary(battingTeamName.getText());
                        } catch (Exception e1) {

                            e1.printStackTrace();
                        }
                        break TwoRunAction;
                    }
                }
            }
            overComplete();

        }
        ThreeRunAction: if (e.getSource() == three) {
            runsShow += 3;
            DisplayRuns.setText(runsShow.toString());
            cnt += 1;
            oversDecimal.setText(cnt.toString());
            System.out.println("Oh three runs");
            text = text + "    " + "3";
            l.setText(text);
            addBatsmanRuns(StrikerBatsman.getText().replaceAll("\\s", ""),
                    nonStrikerBatsman.getText().replaceAll("\\s", ""), 3, 1);
            switchBatsman();
            addBowlerRuns(currentBowler.substring(2).replaceAll("\\s", ""), 3, 0, 1, 0);
            if (inningsCnt == 1) {
                if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team2Name)))) {
                    if (runsShow > team1TotalRuns) {
                        team2TotalRuns = runsShow;
                        clearScoringPage();
                        JOptionPane.showMessageDialog(f, "2nd Innings Over");
                        try {
                            calculateMatchSummary(battingTeamName.getText());
                        } catch (Exception e1) {

                            e1.printStackTrace();
                        }
                        break ThreeRunAction;
                    }
                } else if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team1Name)))) {
                    if (runsShow > team2TotalRuns) {
                        team1TotalRuns = runsShow;
                        clearScoringPage();
                        JOptionPane.showMessageDialog(f, "2nd Innings Over");
                        try {
                            calculateMatchSummary(battingTeamName.getText());
                        } catch (Exception e1) {

                            e1.printStackTrace();
                        }
                        break ThreeRunAction;
                    }
                }
            }
            overComplete();

        }
        FourRunAction: if (e.getSource() == four) {
            runsShow += 4;
            DisplayRuns.setText(runsShow.toString());
            cnt += 1;
            oversDecimal.setText(cnt.toString());
            System.out.println("That's a boundary");
            text = text + "    " + "4";
            l.setText(text);
            addBatsmanRuns(StrikerBatsman.getText().replaceAll("\\s", ""),
                    nonStrikerBatsman.getText().replaceAll("\\s", ""), 4, 1);
            addBowlerRuns(currentBowler.substring(2).replaceAll("\\s", ""), 4, 0, 1, 0);
            if (inningsCnt == 1) {
                if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team2Name)))) {
                    if (runsShow > team1TotalRuns) {
                        team2TotalRuns = runsShow;
                        clearScoringPage();
                        JOptionPane.showMessageDialog(f, "2nd Innings Over");
                        try {
                            calculateMatchSummary(battingTeamName.getText());
                        } catch (Exception e1) {

                            e1.printStackTrace();
                        }
                        break FourRunAction;
                    }
                } else if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team1Name)))) {
                    if (runsShow > team2TotalRuns) {
                        team1TotalRuns = runsShow;
                        clearScoringPage();
                        JOptionPane.showMessageDialog(f, "2nd Innings Over");
                        try {
                            calculateMatchSummary(battingTeamName.getText());
                        } catch (Exception e1) {

                            e1.printStackTrace();
                        }
                        break FourRunAction;
                    }
                }
            }

            overComplete();

        }
        SixRunAction: if (e.getSource() == six) {
            runsShow += 6;
            DisplayRuns.setText(runsShow.toString());
            cnt += 1;
            oversDecimal.setText(cnt.toString());
            System.out.println("Oh! Thats a six");
            text = text + "    " + "6";
            l.setText(text);
            addBatsmanRuns(StrikerBatsman.getText().replaceAll("\\s", ""),
                    nonStrikerBatsman.getText().replaceAll("\\s", ""), 6, 1);
            addBowlerRuns(currentBowler.substring(2).replaceAll("\\s", ""), 6, 0, 1, 0);
            if (inningsCnt == 1) {
                if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team2Name)))) {
                    if (runsShow > team1TotalRuns) {
                        team2TotalRuns = runsShow;
                        clearScoringPage();
                        JOptionPane.showMessageDialog(f, "2nd Innings Over");
                        try {
                            calculateMatchSummary(battingTeamName.getText());
                        } catch (Exception e1) {

                            e1.printStackTrace();
                        }
                        break SixRunAction;
                    }
                } else if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team1Name)))) {
                    if (runsShow > team2TotalRuns) {
                        team1TotalRuns = runsShow;
                        clearScoringPage();
                        JOptionPane.showMessageDialog(f, "2nd Innings Over");
                        try {
                            calculateMatchSummary(battingTeamName.getText());
                        } catch (Exception e1) {

                            e1.printStackTrace();
                        }
                        break SixRunAction;
                    }
                }
            }

            overComplete();

        }
        FiveRunAction: if (e.getSource() == five) {
            runsShow += 5;
            DisplayRuns.setText(runsShow.toString());
            cnt += 1;
            oversDecimal.setText(cnt.toString());
            System.out.println("Five more runs on board");
            text = text + "    " + "5";
            l.setText(text);
            addBatsmanRuns(StrikerBatsman.getText().replaceAll("\\s", ""),
                    nonStrikerBatsman.getText().replaceAll("\\s", ""), 5, 1);
            switchBatsman();
            addBowlerRuns(currentBowler.substring(2).replaceAll("\\s", ""), 5, 0, 1, 0);
            if (inningsCnt == 1) {
                if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team2Name)))) {
                    if (runsShow > team1TotalRuns) {
                        team2TotalRuns = runsShow;
                        clearScoringPage();
                        JOptionPane.showMessageDialog(f, "2nd Innings Over");
                        try {
                            calculateMatchSummary(battingTeamName.getText());
                        } catch (Exception e1) {

                            e1.printStackTrace();
                        }
                        break FiveRunAction;
                    }
                } else if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team1Name)))) {
                    if (runsShow > team2TotalRuns) {
                        team1TotalRuns = runsShow;
                        clearScoringPage();
                        JOptionPane.showMessageDialog(f, "2nd Innings Over");
                        try {
                            calculateMatchSummary(battingTeamName.getText());
                        } catch (Exception e1) {

                            e1.printStackTrace();
                        }
                        break FiveRunAction;
                    }
                }
            }

            overComplete();
        }
        NbRunAction: if (e.getSource() == nb) {
            System.out.println("NO BALL");
            // String run = JOptionPane.showInputDialog(f,"Enter runs");
            Integer runs = Integer.parseInt(JOptionPane.showInputDialog(f, "Enter runs"));
            fontSize -= 3;
            l.setFont(new Font("Calibri", Font.BOLD, fontSize));
            runsShow += runs + 1;
            DisplayRuns.setText(runsShow.toString());
            text = text + "    " + "Nb+" + runs;
            l.setText(text);
            // overComplete();
            if (((battingTeamName.getText().replaceAll("\\s", "")).equals(Team1Name))) {
                // addBowlerRuns(CurrentBowler, runsPerBall, wickets, ballsCnt);
                addBowlerRuns(currentBowler.substring(2).replaceAll("\\s", ""), runs, 0, 0, 1);
                addBatsmanRuns(StrikerBatsman.getText().replaceAll("\\s", ""),
                        nonStrikerBatsman.getText().replaceAll("\\s", ""), runs, 0);
                System.out.println("Team B Extras:" + teamBExtras);
            } else if (((battingTeamName.getText().replaceAll("\\s", "")).equals(Team2Name))) {
                addBowlerRuns(currentBowler.substring(2).replaceAll("\\s", ""), runs, 0, 0, 1);
                addBatsmanRuns(StrikerBatsman.getText().replaceAll("\\s", ""),
                        nonStrikerBatsman.getText().replaceAll("\\s", ""), runs, 0);
                System.out.println("Team A Extras:" + teamAExtras);
            }

            if (runs == 1 || runs == 3 || runs == 5) {
                switchBatsman();
            }

            if (inningsCnt == 1) {
                if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team2Name)))) {
                    if (runsShow > team1TotalRuns) {
                        team2TotalRuns = runsShow;
                        clearScoringPage();
                        JOptionPane.showMessageDialog(f, "2nd Innings Over");
                        try {
                            calculateMatchSummary(battingTeamName.getText());
                        } catch (Exception e1) {

                            e1.printStackTrace();
                        }
                        break NbRunAction;
                    }
                } else if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team1Name)))) {
                    if (runsShow > team2TotalRuns) {
                        team1TotalRuns = runsShow;
                        clearScoringPage();
                        JOptionPane.showMessageDialog(f, "2nd Innings Over");
                        try {
                            calculateMatchSummary(battingTeamName.getText());
                        } catch (Exception e1) {

                            e1.printStackTrace();
                        }
                        break NbRunAction;
                    }
                }
            }
        }
        WdRunAction: if (e.getSource() == wd) {
            System.out.println("WIDE BALL");
            Integer runs = Integer.parseInt(JOptionPane.showInputDialog(f, "Enter runs"));
            fontSize -= 3;
            l.setFont(new Font("Calibri", Font.BOLD, fontSize));
            runsShow += runs + 1;
            DisplayRuns.setText(runsShow.toString());
            text = text + "    " + "Wd+" + runs;
            l.setText(text);

            if (((battingTeamName.getText().replaceAll("\\s", "")).equals(Team1Name))) {
                teamBExtras += runs;
                addBowlerRuns(currentBowler.substring(2).replaceAll("\\s", ""), 0, 0, 0, 1);
                System.out.println("Team B Extras:" + teamBExtras);
            } else if (((battingTeamName.getText().replaceAll("\\s", "")).equals(Team2Name))) {
                teamAExtras += runs;
                addBowlerRuns(currentBowler.substring(2).replaceAll("\\s", ""), 0, 0, 0, 1);
                System.out.println("Team A Extras:" + teamAExtras);
            }

            if (runs == 1 || runs == 3 || runs == 5) {
                switchBatsman();
            }

            if (inningsCnt == 1) {
                if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team2Name)))) {
                    if (runsShow > team1TotalRuns) {
                        team2TotalRuns = runsShow;
                        clearScoringPage();
                        JOptionPane.showMessageDialog(f, "2nd Innings Over");
                        try {
                            calculateMatchSummary(battingTeamName.getText());
                        } catch (Exception e1) {

                            e1.printStackTrace();
                        }
                        break WdRunAction;
                    }
                } else if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team1Name)))) {
                    if (runsShow > team2TotalRuns) {
                        team1TotalRuns = runsShow;
                        clearScoringPage();
                        JOptionPane.showMessageDialog(f, "2nd Innings Over");
                        try {
                            calculateMatchSummary(battingTeamName.getText());
                        } catch (Exception e1) {

                            e1.printStackTrace();
                        }
                        break WdRunAction;
                    }
                }
            }
        }
        ByesRunAction: if (e.getSource() == byes) {
            System.out.println("byes");
            Integer runs = Integer.parseInt(JOptionPane.showInputDialog(f, "Enter runs"));
            fontSize -= 2;
            l.setFont(new Font("Calibri", Font.BOLD, fontSize));
            runsShow += runs;
            DisplayRuns.setText(runsShow.toString());
            cnt += 1;
            oversDecimal.setText(cnt.toString());
            text = text + "    " + "BYE+" + runs;
            l.setText(text);

            if (((battingTeamName.getText().replaceAll("\\s", "")).equals(Team1Name))) {
                teamBExtras += runs;
                addBatsmanRuns(StrikerBatsman.getText().replaceAll("\\s", ""),
                        nonStrikerBatsman.getText().replaceAll("\\s", ""), 0, 1);
                addBowlerRuns(currentBowler.substring(2).replaceAll("\\s", ""), 0, 0, 1, 0);
                System.out.println("Team B Extras:" + teamBExtras);
            } else if (((battingTeamName.getText().replaceAll("\\s", "")).equals(Team2Name))) {
                teamAExtras += runs;
                addBatsmanRuns(StrikerBatsman.getText().replaceAll("\\s", ""),
                        nonStrikerBatsman.getText().replaceAll("\\s", ""), 0, 1);
                addBowlerRuns(currentBowler.substring(2).replaceAll("\\s", ""), 0, 0, 1, 0);
                System.out.println("Team A Extras:" + teamAExtras);
            }

            if (runs == 1 || runs == 3 || runs == 5) {
                switchBatsman();
            }

            if (inningsCnt == 1) {
                if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team2Name)))) {
                    if (runsShow > team1TotalRuns) {
                        team2TotalRuns = runsShow;
                        clearScoringPage();
                        JOptionPane.showMessageDialog(f, "2nd Innings Over");
                        try {
                            calculateMatchSummary(battingTeamName.getText());
                        } catch (Exception e1) {

                            e1.printStackTrace();
                        }
                        break ByesRunAction;
                    }
                } else if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team1Name)))) {
                    if (runsShow > team2TotalRuns) {
                        team1TotalRuns = runsShow;
                        clearScoringPage();
                        JOptionPane.showMessageDialog(f, "2nd Innings Over");
                        try {
                            calculateMatchSummary(battingTeamName.getText());
                        } catch (Exception e1) {

                            e1.printStackTrace();
                        }
                        break ByesRunAction;
                    }
                }
            }
            overComplete();

        }

        LbRunAction: if (e.getSource() == lb) {
            System.out.println("Leg byes");
            Integer runs = Integer.parseInt(JOptionPane.showInputDialog(f, "Enter runs"));
            runsShow += runs;
            DisplayRuns.setText(runsShow.toString());
            cnt += 1;
            oversDecimal.setText(cnt.toString());
            text = text + "    " + "LB+" + runs;
            l.setText(text);

            if (((battingTeamName.getText().replaceAll("\\s", "")).equals(Team1Name))) {
                teamBExtras += runs;
                addBatsmanRuns(StrikerBatsman.getText().replaceAll("\\s", ""),
                        nonStrikerBatsman.getText().replaceAll("\\s", ""), 0, 1);
                addBowlerRuns(currentBowler.substring(2).replaceAll("\\s", ""), 0, 0, 1, 0);
                System.out.println("Team B Extras:" + teamBExtras);
            } else if (((battingTeamName.getText().replaceAll("\\s", "")).equals(Team2Name))) {
                teamAExtras += runs;
                addBatsmanRuns(StrikerBatsman.getText().replaceAll("\\s", ""),
                        nonStrikerBatsman.getText().replaceAll("\\s", ""), 0, 1);
                addBowlerRuns(currentBowler.substring(2).replaceAll("\\s", ""), 0, 0, 1, 0);
                System.out.println("Team A Extras:" + teamAExtras);
            }

            if (runs == 1 || runs == 3 || runs == 5) {
                switchBatsman();
            }

            if (inningsCnt == 1) {
                if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team2Name)))) {
                    if (runsShow > team1TotalRuns) {
                        team2TotalRuns = runsShow;
                        clearScoringPage();
                        JOptionPane.showMessageDialog(f, "2nd Innings Over");
                        try {
                            calculateMatchSummary(battingTeamName.getText());
                        } catch (Exception e1) {

                            e1.printStackTrace();
                        }
                        break LbRunAction;
                    }
                } else if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team1Name)))) {
                    if (runsShow > team2TotalRuns) {
                        team1TotalRuns = runsShow;
                        clearScoringPage();
                        JOptionPane.showMessageDialog(f, "2nd Innings Over");
                        try {
                            calculateMatchSummary(battingTeamName.getText());
                        } catch (Exception e1) {

                            e1.printStackTrace();
                        }
                        break LbRunAction;
                    }
                }
            }
            overComplete();

        }

        WicketAction: if (e.getSource() == wicket) {
            String whoGotOut;
            outs = Integer.parseInt(fallOfWickets.getText());
            if (outs >= 0 && outs < 10) {
                cnt += 1;
                oversDecimal.setText(cnt.toString());
                outs += 1;
                System.out.println("WICKET");
                text = text + "    " + "Wk";
                l.setText(text);
                fallOfWickets.setText(outs.toString());
                addBowlerWickets(currentBowler.substring(2).replaceAll("\\s", ""), 1);

                if (outs == 10) {
                    JOptionPane.showMessageDialog(f, "ALL OUT");
                    inningsCnt += 1;
                    if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team1Name)))) {
                        team1TotalRuns = runsShow;
                        if (StrikerBatsman.isSelected()) {
                            whoGotOut = (StrikerBatsman.getText()).replaceAll("\\s", "");
                            if (whoGotOut.equals(batsman1NameA)) {
                                batsman1ballsA += 1;
                            }
                            if (whoGotOut.equals(batsman2NameA)) {
                                batsman2ballsA += 1;
                            }
                            if (whoGotOut.equals(batsman3NameA)) {
                                batsman3ballsA += 1;
                            }
                            if (whoGotOut.equals(batsman4NameA)) {
                                batsman4ballsA += 1;
                            }
                            if (whoGotOut.equals(batsman5NameA)) {
                                batsman5ballsA += 1;
                            }
                            if (whoGotOut.equals(batsman6NameA)) {
                                batsman6ballsA += 1;
                            }
                            if (whoGotOut.equals(batsman7NameA)) {
                                batsman7ballsA += 1;
                            }
                            if (whoGotOut.equals(batsman8NameA)) {
                                batsman8ballsA += 1;
                            }
                            if (whoGotOut.equals(batsman9NameA)) {
                                batsman9ballsA += 1;
                            }
                            if (whoGotOut.equals(batsman10NameA)) {
                                batsman10ballsA += 1;
                            }
                            if (whoGotOut.equals(batsman11NameA)) {
                                batsman11ballsA += 1;
                            }
                            System.out.println("--------------------------");
                            System.out.println("Team A Batsman 1 Name: " + batsman1NameA + " Runs:" + batsman1runsA
                                    + " Balls :" + batsman1ballsA);
                            System.out.println("Team A Batsman 2 Name: " + batsman2NameA + " Runs:" + batsman2runsA
                                    + " Balls :" + batsman2ballsA);
                            System.out.println("Team A Batsman 3 Name: " + batsman3NameA + " Runs:" + batsman3runsA
                                    + " Balls :" + batsman3ballsA);
                            System.out.println("Team A Batsman 4 Name: " + batsman4NameA + " Runs:" + batsman4runsA
                                    + " Balls :" + batsman4ballsA);
                            System.out.println("Team A Batsman 5 Name: " + batsman5NameA + " Runs:" + batsman5runsA
                                    + " Balls :" + batsman5ballsA);
                            System.out.println("Team A Batsman 6 Name: " + batsman6NameA + " Runs:" + batsman6runsA
                                    + " Balls :" + batsman6ballsA);
                            System.out.println("Team A Batsman 7 Name: " + batsman7NameA + " Runs:" + batsman7runsA
                                    + " Balls :" + batsman7ballsA);
                            System.out.println("Team A Batsman 8 Name: " + batsman8NameA + " Runs:" + batsman8runsA
                                    + " Balls :" + batsman8ballsA);
                            System.out.println("Team A Batsman 9 Name: " + batsman9NameA + " Runs:" + batsman9runsA
                                    + " Balls :" + batsman9ballsA);
                            System.out.println("Team A Batsman 10 Name: " + batsman10NameA + " Runs:" + batsman10runsA
                                    + " Balls :" + batsman10ballsA);
                            System.out.println("Team A Batsman 11 Name: " + batsman11NameA + " Runs:" + batsman11runsA
                                    + " Balls :" + batsman11ballsA);
                            System.out.println("--------------------------");

                        } else if (nonStrikerBatsman.isSelected()) {
                            whoGotOut = (nonStrikerBatsman.getText()).replaceAll("\\s", "");
                            if (whoGotOut.equals(batsman1NameA)) {
                                batsman1ballsA += 1;
                            }
                            if (whoGotOut.equals(batsman2NameA)) {
                                batsman2ballsA += 1;
                            }
                            if (whoGotOut.equals(batsman3NameA)) {
                                batsman3ballsA += 1;
                            }
                            if (whoGotOut.equals(batsman4NameA)) {
                                batsman4ballsA += 1;
                            }
                            if (whoGotOut.equals(batsman5NameA)) {
                                batsman5ballsA += 1;
                            }
                            if (whoGotOut.equals(batsman6NameA)) {
                                batsman6ballsA += 1;
                            }
                            if (whoGotOut.equals(batsman7NameA)) {
                                batsman7ballsA += 1;
                            }
                            if (whoGotOut.equals(batsman8NameA)) {
                                batsman8ballsA += 1;
                            }
                            if (whoGotOut.equals(batsman9NameA)) {
                                batsman9ballsA += 1;
                            }
                            if (whoGotOut.equals(batsman10NameA)) {
                                batsman10ballsA += 1;
                            }
                            if (whoGotOut.equals(batsman11NameA)) {
                                batsman11ballsA += 1;
                            }
                            System.out.println("--------------------------");
                            System.out.println("Team A Batsman 1 Name: " + batsman1NameA + " Runs:" + batsman1runsA
                                    + " Balls :" + batsman1ballsA);
                            System.out.println("Team A Batsman 2 Name: " + batsman2NameA + " Runs:" + batsman2runsA
                                    + " Balls :" + batsman2ballsA);
                            System.out.println("Team A Batsman 3 Name: " + batsman3NameA + " Runs:" + batsman3runsA
                                    + " Balls :" + batsman3ballsA);
                            System.out.println("Team A Batsman 4 Name: " + batsman4NameA + " Runs:" + batsman4runsA
                                    + " Balls :" + batsman4ballsA);
                            System.out.println("Team A Batsman 5 Name: " + batsman5NameA + " Runs:" + batsman5runsA
                                    + " Balls :" + batsman5ballsA);
                            System.out.println("Team A Batsman 6 Name: " + batsman6NameA + " Runs:" + batsman6runsA
                                    + " Balls :" + batsman6ballsA);
                            System.out.println("Team A Batsman 7 Name: " + batsman7NameA + " Runs:" + batsman7runsA
                                    + " Balls :" + batsman7ballsA);
                            System.out.println("Team A Batsman 8 Name: " + batsman8NameA + " Runs:" + batsman8runsA
                                    + " Balls :" + batsman8ballsA);
                            System.out.println("Team A Batsman 9 Name: " + batsman9NameA + " Runs:" + batsman9runsA
                                    + " Balls :" + batsman9ballsA);
                            System.out.println("Team A Batsman 10 Name: " + batsman10NameA + " Runs:" + batsman10runsA
                                    + " Balls :" + batsman10ballsA);
                            System.out.println("Team A Batsman 11 Name: " + batsman11NameA + " Runs:" + batsman11runsA
                                    + " Balls :" + batsman11ballsA);
                            System.out.println("--------------------------");
                        }
                    } else if ((((battingTeamName.getText().replaceAll("\\s", "")).equals(Team2Name)))) {
                        team2TotalRuns = runsShow;
                        if (StrikerBatsman.isSelected()) {
                            whoGotOut = (StrikerBatsman.getText()).replaceAll("\\s", "");
                            if (whoGotOut.equals(batsman1NameB)) {
                                batsman1ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman2NameB)) {
                                batsman2ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman3NameB)) {
                                batsman3ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman4NameB)) {
                                batsman4ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman5NameB)) {
                                batsman5ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman6NameB)) {
                                batsman6ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman7NameB)) {
                                batsman7ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman8NameB)) {
                                batsman8ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman9NameB)) {
                                batsman9ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman10NameB)) {
                                batsman10ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman11NameB)) {
                                batsman11ballsB += 1;
                            }
                            System.out.println("--------------------------");
                            System.out.println("Team B Batsman 1 Name: " + batsman1NameB + " Runs:" + batsman1runsB
                                    + " Balls :" + batsman1ballsB);
                            System.out.println("Team B Batsman 2 Name: " + batsman2NameB + " Runs:" + batsman2runsB
                                    + " Balls :" + batsman2ballsB);
                            System.out.println("Team B Batsman 3 Name: " + batsman3NameB + " Runs:" + batsman3runsB
                                    + " Balls :" + batsman3ballsB);
                            System.out.println("Team B Batsman 4 Name: " + batsman4NameB + " Runs:" + batsman4runsB
                                    + " Balls :" + batsman4ballsB);
                            System.out.println("Team B Batsman 5 Name: " + batsman5NameB + " Runs:" + batsman5runsB
                                    + " Balls :" + batsman5ballsB);
                            System.out.println("Team B Batsman 6 Name: " + batsman6NameB + " Runs:" + batsman6runsB
                                    + " Balls :" + batsman6ballsB);
                            System.out.println("Team B Batsman 7 Name: " + batsman7NameB + " Runs:" + batsman7runsB
                                    + " Balls :" + batsman7ballsB);
                            System.out.println("Team B Batsman 8 Name: " + batsman8NameB + " Runs:" + batsman8runsB
                                    + " Balls :" + batsman8ballsB);
                            System.out.println("Team B Batsman 9 Name: " + batsman9NameB + " Runs:" + batsman9runsB
                                    + " Balls :" + batsman9ballsB);
                            System.out.println("Team B Batsman 10 Name: " + batsman10NameB + " Runs:" + batsman10runsB
                                    + " Balls :" + batsman10ballsB);
                            System.out.println("Team B Batsman 11 Name: " + batsman11NameB + " Runs:" + batsman11runsB
                                    + " Balls :" + batsman11ballsB);
                            System.out.println("--------------------------");
                        } else if (nonStrikerBatsman.isSelected()) {
                            whoGotOut = (nonStrikerBatsman.getText()).replaceAll("\\s", "");
                            if (whoGotOut.equals(batsman1NameB)) {
                                batsman1ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman2NameB)) {
                                batsman2ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman3NameB)) {
                                batsman3ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman4NameB)) {
                                batsman4ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman5NameB)) {
                                batsman5ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman6NameB)) {
                                batsman6ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman7NameB)) {
                                batsman7ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman8NameB)) {
                                batsman8ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman9NameB)) {
                                batsman9ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman10NameB)) {
                                batsman10ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman11NameB)) {
                                batsman11ballsB += 1;
                            }
                            System.out.println("--------------------------");
                            System.out.println("Team B Batsman 1 Name: " + batsman1NameB + " Runs:" + batsman1runsB
                                    + " Balls :" + batsman1ballsB);
                            System.out.println("Team B Batsman 2 Name: " + batsman2NameB + " Runs:" + batsman2runsB
                                    + " Balls :" + batsman2ballsB);
                            System.out.println("Team B Batsman 3 Name: " + batsman3NameB + " Runs:" + batsman3runsB
                                    + " Balls :" + batsman3ballsB);
                            System.out.println("Team B Batsman 4 Name: " + batsman4NameB + " Runs:" + batsman4runsB
                                    + " Balls :" + batsman4ballsB);
                            System.out.println("Team B Batsman 5 Name: " + batsman5NameB + " Runs:" + batsman5runsB
                                    + " Balls :" + batsman5ballsB);
                            System.out.println("Team B Batsman 6 Name: " + batsman6NameB + " Runs:" + batsman6runsB
                                    + " Balls :" + batsman6ballsB);
                            System.out.println("Team B Batsman 7 Name: " + batsman7NameB + " Runs:" + batsman7runsB
                                    + " Balls :" + batsman7ballsB);
                            System.out.println("Team B Batsman 8 Name: " + batsman8NameB + " Runs:" + batsman8runsB
                                    + " Balls :" + batsman8ballsB);
                            System.out.println("Team B Batsman 9 Name: " + batsman9NameB + " Runs:" + batsman9runsB
                                    + " Balls :" + batsman9ballsB);
                            System.out.println("Team B Batsman 10 Name: " + batsman10NameB + " Runs:" + batsman10runsB
                                    + " Balls :" + batsman10ballsB);
                            System.out.println("Team B Batsman 11 Name: " + batsman11NameB + " Runs:" + batsman11runsB
                                    + " Balls :" + batsman11ballsB);
                            System.out.println("--------------------------");
                        }

                    } else {
                        System.out.println("Something's Wrong");
                    }
                    if (inningsCnt == 2) {

                        JOptionPane.showMessageDialog(f, "2nd Innings Over");
                        try {
                            calculateMatchSummary(battingTeamName.getText());
                        } catch (Exception e1) {

                            e1.printStackTrace();
                        }
                        break WicketAction;
                    }
                    if (inningsCnt == 1) {
                        if ((battingTeamName.getText()).equals(Team1Name)) {
                            battingTeamName.setText(Team2Name);
                            tossWonBy.setText(Team2Name + " needs " + (runsShow + 1) + " runs to win the game");
                            clearScoringPage();
                            selectBatsmanAtStart(copyOfTeamB, Team2Name);
                            selectBowler(copyOfTeamA, Team1Name);
                            for (int i = 0; i < copyOfTeamA.length; i++) {
                                TeamA[i] = copyOfTeamA[i];
                            }
                            break WicketAction;
                        } else if ((battingTeamName.getText()).equals(Team2Name)) {
                            battingTeamName.setText(Team1Name);
                            tossWonBy.setText(Team1Name + " needs " + (runsShow + 1) + " runs to win the game");
                            clearScoringPage();
                            selectBatsmanAtStart(copyOfTeamA, Team1Name);
                            selectBowler(copyOfTeamB, Team2Name);
                            for (int i = 0; i < copyOfTeamB.length; i++) {
                                TeamB[i] = copyOfTeamB[i];
                            }
                            break WicketAction;
                        }
                    }
                }

                if ((battingTeamName.getText()).equals(Team1Name)) {

                    if (StrikerBatsman.isSelected()) {
                        whoGotOut = (StrikerBatsman.getText()).replaceAll("\\s", "");
                        ArrayList<String> tempTeamA = new ArrayList<>();
                        for (int i = 0; i < 3; i++) {
                            tempTeamA.add(i, ((TeamA[i]).substring(2)).replaceAll("\\s", ""));
                        }
                        int indexOfWhoGotOut = tempTeamA.indexOf(whoGotOut);
                        TeamA[indexOfWhoGotOut] = "   ----";
                        selectNewBatsman(TeamA, Team1Name);
                        addNewBatsman(StrikerBatsman.getText().replaceAll("\\s", ""));
                        if (teamABatsmans.size() == 3) {
                            batsman3NameA = StrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameA)) {
                                batsman1ballsA += 1;
                            }
                            if (whoGotOut.equals(batsman2NameA)) {
                                batsman2ballsA += 1; // actually this is not possible but to maintain the flow

                            }
                            System.out.println("Team A batsman3 name :" + batsman3NameA);
                        }
                        if (teamABatsmans.size() == 4) {
                            batsman4NameA = StrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameA)) {
                                batsman1ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman2NameA)) {
                                batsman2ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman3NameA)) {
                                batsman3ballsA += 1;

                            }
                            System.out.println("Team A batsman4 name :" + batsman4NameA);
                        }
                        if (teamABatsmans.size() == 5) {
                            batsman5NameA = StrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameA)) {
                                batsman1ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman2NameA)) {
                                batsman2ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman3NameA)) {
                                batsman3ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman4NameA)) {
                                batsman4ballsA += 1;

                            }
                            System.out.println("Team A batsman5 name :" + batsman5NameA);
                        }
                        if (teamABatsmans.size() == 6) {
                            batsman6NameA = StrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameA)) {
                                batsman1ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman2NameA)) {
                                batsman2ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman3NameA)) {
                                batsman3ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman4NameA)) {
                                batsman4ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman5NameA)) {
                                batsman5ballsA += 1;

                            }
                            System.out.println("Team A batsman6 name :" + batsman6NameA);
                        }
                        if (teamABatsmans.size() == 7) {
                            batsman7NameA = StrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameA)) {
                                batsman1ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman2NameA)) {
                                batsman2ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman3NameA)) {
                                batsman3ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman4NameA)) {
                                batsman4ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman5NameA)) {
                                batsman5ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman6NameA)) {
                                batsman6ballsA += 1;

                            }
                            System.out.println("Team A batsman7 name :" + batsman7NameA);
                        }
                        if (teamABatsmans.size() == 8) {
                            batsman8NameA = StrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameA)) {
                                batsman1ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman2NameA)) {
                                batsman2ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman3NameA)) {
                                batsman3ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman4NameA)) {
                                batsman4ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman5NameA)) {
                                batsman5ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman6NameA)) {
                                batsman6ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman7NameA)) {
                                batsman7ballsA += 1;

                            }
                            System.out.println("Team A batsman8 name :" + batsman8NameA);
                        }
                        if (teamABatsmans.size() == 9) {
                            batsman9NameA = StrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameA)) {
                                batsman1ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman2NameA)) {
                                batsman2ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman3NameA)) {
                                batsman3ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman4NameA)) {
                                batsman4ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman5NameA)) {
                                batsman5ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman6NameA)) {
                                batsman6ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman7NameA)) {
                                batsman7ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman8NameA)) {
                                batsman8ballsA += 1;

                            }
                            System.out.println("Team A batsman9 name :" + batsman9NameA);
                        }
                        if (teamABatsmans.size() == 10) {
                            batsman10NameA = StrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameA)) {
                                batsman1ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman2NameA)) {
                                batsman2ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman3NameA)) {
                                batsman3ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman4NameA)) {
                                batsman4ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman5NameA)) {
                                batsman5ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman6NameA)) {
                                batsman6ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman7NameA)) {
                                batsman7ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman8NameA)) {
                                batsman8ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman9NameA)) {
                                batsman9ballsA += 1;

                            }
                            System.out.println("Team A batsman10 name :" + batsman10NameA);
                        }
                        if (teamABatsmans.size() == 11) {
                            batsman11NameA = StrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameA)) {
                                batsman1ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman2NameA)) {
                                batsman2ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman3NameA)) {
                                batsman3ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman4NameA)) {
                                batsman4ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman5NameA)) {
                                batsman5ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman6NameA)) {
                                batsman6ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman7NameA)) {
                                batsman7ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman8NameA)) {
                                batsman8ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman9NameA)) {
                                batsman9ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman10NameA)) {
                                batsman10ballsA += 1;

                            }
                            System.out.println("Team A batsman11 name :" + batsman11NameA);
                        }

                    } else if (nonStrikerBatsman.isSelected()) {
                        whoGotOut = (nonStrikerBatsman.getText()).replaceAll("\\s", "");
                        ArrayList<String> tempTeamA = new ArrayList<>();
                        for (int i = 0; i < 3; i++) {
                            tempTeamA.add(i, ((TeamA[i]).substring(2)).replaceAll("\\s", ""));
                        }
                        int indexOfWhoGotOut = tempTeamA.indexOf(whoGotOut);
                        TeamA[indexOfWhoGotOut] = "   ----";

                        selectNewBatsman(TeamA, Team1Name);
                        addNewBatsman(nonStrikerBatsman.getText().replaceAll("\\s", ""));
                        if (teamABatsmans.size() == 3) {
                            batsman3NameA = nonStrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameA)) {
                                batsman1ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman2NameA)) {
                                batsman2ballsA += 1; // actually this is not possible but to maintain the flow

                            }
                            System.out.println("Team A batsman3 name :" + batsman3NameA);
                        }
                        if (teamABatsmans.size() == 4) {
                            batsman4NameA = nonStrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameA)) {
                                batsman1ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman2NameA)) {
                                batsman2ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman3NameA)) {
                                batsman3ballsA += 1;

                            }
                            System.out.println("Team A batsman4 name :" + batsman4NameA);
                        }
                        if (teamABatsmans.size() == 5) {
                            batsman5NameA = nonStrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameA)) {
                                batsman1ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman2NameA)) {
                                batsman2ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman3NameA)) {
                                batsman3ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman4NameA)) {
                                batsman4ballsA += 1;

                            }
                            System.out.println("Team A batsman5 name :" + batsman5NameA);
                        }
                        if (teamABatsmans.size() == 6) {
                            batsman6NameA = nonStrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameA)) {
                                batsman1ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman2NameA)) {
                                batsman2ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman3NameA)) {
                                batsman3ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman4NameA)) {
                                batsman4ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman5NameA)) {
                                batsman5ballsA += 1;

                            }
                            System.out.println("Team A batsman6 name :" + batsman6NameA);
                        }
                        if (teamABatsmans.size() == 7) {
                            batsman7NameA = nonStrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameA)) {
                                batsman1ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman2NameA)) {
                                batsman2ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman3NameA)) {
                                batsman3ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman4NameA)) {
                                batsman4ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman5NameA)) {
                                batsman5ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman6NameA)) {
                                batsman6ballsA += 1;

                            }
                            System.out.println("Team A batsman7 name :" + batsman7NameA);
                        }
                        if (teamABatsmans.size() == 8) {
                            batsman8NameA = nonStrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameA)) {
                                batsman1ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman2NameA)) {
                                batsman2ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman3NameA)) {
                                batsman3ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman4NameA)) {
                                batsman4ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman5NameA)) {
                                batsman5ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman6NameA)) {
                                batsman6ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman7NameA)) {
                                batsman7ballsA += 1;

                            }
                            System.out.println("Team A batsman8 name :" + batsman8NameA);
                        }
                        if (teamABatsmans.size() == 9) {
                            batsman9NameA = nonStrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameA)) {
                                batsman1ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman2NameA)) {
                                batsman2ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman3NameA)) {
                                batsman3ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman4NameA)) {
                                batsman4ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman5NameA)) {
                                batsman5ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman6NameA)) {
                                batsman6ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman7NameA)) {
                                batsman7ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman8NameA)) {
                                batsman8ballsA += 1;

                            }
                            System.out.println("Team A batsman9 name :" + batsman9NameA);
                        }
                        if (teamABatsmans.size() == 10) {
                            batsman10NameA = nonStrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameA)) {
                                batsman1ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman2NameA)) {
                                batsman2ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman3NameA)) {
                                batsman3ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman4NameA)) {
                                batsman4ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman5NameA)) {
                                batsman5ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman6NameA)) {
                                batsman6ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman7NameA)) {
                                batsman7ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman8NameA)) {
                                batsman8ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman9NameA)) {
                                batsman9ballsA += 1;

                            }
                            System.out.println("Team A batsman10 name :" + batsman10NameA);
                        }
                        if (teamABatsmans.size() == 11) {
                            batsman11NameA = nonStrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameA)) {
                                batsman1ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman2NameA)) {
                                batsman2ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman3NameA)) {
                                batsman3ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman4NameA)) {
                                batsman4ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman5NameA)) {
                                batsman5ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman6NameA)) {
                                batsman6ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman7NameA)) {
                                batsman7ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman8NameA)) {
                                batsman8ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman9NameA)) {
                                batsman9ballsA += 1;

                            }
                            if (whoGotOut.equals(batsman10NameA)) {
                                batsman10ballsA += 1;

                            }
                            System.out.println("Team A batsman11 name :" + batsman11NameA);
                        }
                    }

                } else if ((battingTeamName.getText()).equals(Team2Name)) {
                    if (StrikerBatsman.isSelected()) {
                        whoGotOut = (StrikerBatsman.getText()).replaceAll("\\s", "");
                        ArrayList<String> tempTeamB = new ArrayList<>();
                        for (int i = 0; i < 3; i++) {
                            tempTeamB.add(i, ((TeamB[i]).substring(2)).replaceAll("\\s", ""));
                        }
                        int indexOfWhoGotOut = tempTeamB.indexOf(whoGotOut);
                        TeamB[indexOfWhoGotOut] = "   ----";

                        selectNewBatsman(TeamB, Team2Name);
                        addNewBatsman(StrikerBatsman.getText().replaceAll("\\s", ""));
                        if (teamBBatsmans.size() == 3) {
                            batsman3NameB = StrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameB)) {
                                batsman1ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman2NameB)) {
                                batsman2ballsB += 1;

                            }
                            System.out.println("Team B batsman3 name :" + batsman3NameB);
                        }
                        if (teamBBatsmans.size() == 4) {
                            batsman4NameB = StrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameB)) {
                                batsman1ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman2NameB)) {
                                batsman2ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman3NameB)) {
                                batsman3ballsB += 1;

                            }
                            System.out.println("Team B batsman4 name :" + batsman4NameB);
                        }
                        if (teamBBatsmans.size() == 5) {
                            batsman5NameB = StrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameB)) {
                                batsman1ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman2NameB)) {
                                batsman2ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman3NameB)) {
                                batsman3ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman4NameB)) {
                                batsman4ballsB += 1;

                            }
                            System.out.println("Team B batsman5 name :" + batsman5NameB);
                        }
                        if (teamBBatsmans.size() == 6) {
                            batsman6NameB = StrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameB)) {
                                batsman1ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman2NameB)) {
                                batsman2ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman3NameB)) {
                                batsman3ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman4NameB)) {
                                batsman4ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman5NameB)) {
                                batsman5ballsB += 1;

                            }
                            System.out.println("Team B batsman6 name :" + batsman6NameB);
                        }
                        if (teamBBatsmans.size() == 7) {
                            batsman7NameB = StrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameB)) {
                                batsman1ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman2NameB)) {
                                batsman2ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman3NameB)) {
                                batsman3ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman4NameB)) {
                                batsman4ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman5NameB)) {
                                batsman5ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman6NameB)) {
                                batsman6ballsB += 1;

                            }
                            System.out.println("Team B batsman7 name :" + batsman7NameB);
                        }
                        if (teamBBatsmans.size() == 8) {
                            batsman8NameB = StrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameB)) {
                                batsman1ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman2NameB)) {
                                batsman2ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman3NameB)) {
                                batsman3ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman4NameB)) {
                                batsman4ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman5NameB)) {
                                batsman5ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman6NameB)) {
                                batsman6ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman7NameB)) {
                                batsman7ballsB += 1;

                            }
                            System.out.println("Team B batsman8 name :" + batsman8NameB);
                        }
                        if (teamBBatsmans.size() == 9) {
                            batsman9NameB = StrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameB)) {
                                batsman1ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman2NameB)) {
                                batsman2ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman3NameB)) {
                                batsman3ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman4NameB)) {
                                batsman4ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman5NameB)) {
                                batsman5ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman6NameB)) {
                                batsman6ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman7NameB)) {
                                batsman7ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman8NameB)) {
                                batsman8ballsB += 1;

                            }
                            System.out.println("Team B batsman9 name :" + batsman9NameB);
                        }
                        if (teamBBatsmans.size() == 10) {
                            batsman10NameB = StrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameB)) {
                                batsman1ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman2NameB)) {
                                batsman2ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman3NameB)) {
                                batsman3ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman4NameB)) {
                                batsman4ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman5NameB)) {
                                batsman5ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman6NameB)) {
                                batsman6ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman7NameB)) {
                                batsman7ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman8NameB)) {
                                batsman8ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman9NameB)) {
                                batsman9ballsB += 1;

                            }
                            System.out.println("Team B batsman10 name :" + batsman10NameB);
                        }
                        if (teamBBatsmans.size() == 11) {
                            batsman11NameB = StrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameB)) {
                                batsman1ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman2NameB)) {
                                batsman2ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman3NameB)) {
                                batsman3ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman4NameB)) {
                                batsman4ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman5NameB)) {
                                batsman5ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman6NameB)) {
                                batsman6ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman7NameB)) {
                                batsman7ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman8NameB)) {
                                batsman8ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman9NameB)) {
                                batsman9ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman10NameB)) {
                                batsman10ballsB += 1;

                            }
                            System.out.println("Team B batsman11 name :" + batsman11NameB);
                        }

                    } else if (nonStrikerBatsman.isSelected()) {
                        whoGotOut = (nonStrikerBatsman.getText()).replaceAll("\\s", "");
                        ArrayList<String> tempTeamB = new ArrayList<>();
                        for (int i = 0; i < 3; i++) {
                            tempTeamB.add(i, ((TeamB[i]).substring(2)).replaceAll("\\s", ""));
                        }
                        int indexOfWhoGotOut = tempTeamB.indexOf(whoGotOut);
                        TeamB[indexOfWhoGotOut] = "   ----";

                        selectNewBatsman(TeamB, Team2Name);
                        addNewBatsman(nonStrikerBatsman.getText().replaceAll("\\s", ""));
                        if (teamBBatsmans.size() == 3) {
                            batsman3NameB = nonStrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameB)) {
                                batsman1ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman2NameB)) {
                                batsman2ballsB += 1;

                            }
                            System.out.println("Team B batsman3 name :" + batsman3NameB);
                        }
                        if (teamBBatsmans.size() == 4) {
                            batsman4NameB = nonStrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameB)) {
                                batsman1ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman2NameB)) {
                                batsman2ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman3NameB)) {
                                batsman3ballsB += 1;

                            }
                            System.out.println("Team B batsman4 name :" + batsman4NameB);
                        }
                        if (teamBBatsmans.size() == 5) {
                            batsman5NameB = nonStrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameB)) {
                                batsman1ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman2NameB)) {
                                batsman2ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman3NameB)) {
                                batsman3ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman4NameB)) {
                                batsman4ballsB += 1;

                            }
                            System.out.println("Team B batsman5 name :" + batsman5NameB);
                        }
                        if (teamBBatsmans.size() == 6) {
                            batsman6NameB = nonStrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameB)) {
                                batsman1ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman2NameB)) {
                                batsman2ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman3NameB)) {
                                batsman3ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman4NameB)) {
                                batsman4ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman5NameB)) {
                                batsman5ballsB += 1;

                            }
                            System.out.println("Team B batsman6 name :" + batsman6NameB);
                        }
                        if (teamBBatsmans.size() == 7) {
                            batsman7NameB = nonStrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameB)) {
                                batsman1ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman2NameB)) {
                                batsman2ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman3NameB)) {
                                batsman3ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman4NameB)) {
                                batsman4ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman5NameB)) {
                                batsman5ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman6NameB)) {
                                batsman6ballsB += 1;

                            }
                            System.out.println("Team B batsman7 name :" + batsman7NameB);
                        }
                        if (teamBBatsmans.size() == 8) {
                            batsman8NameB = nonStrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameB)) {
                                batsman1ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman2NameB)) {
                                batsman2ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman3NameB)) {
                                batsman3ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman4NameB)) {
                                batsman4ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman5NameB)) {
                                batsman5ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman6NameB)) {
                                batsman6ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman7NameB)) {
                                batsman7ballsB += 1;

                            }
                            System.out.println("Team B batsman8 name :" + batsman8NameB);
                        }
                        if (teamBBatsmans.size() == 9) {
                            batsman9NameB = nonStrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameB)) {
                                batsman1ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman2NameB)) {
                                batsman2ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman3NameB)) {
                                batsman3ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman4NameB)) {
                                batsman4ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman5NameB)) {
                                batsman5ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman6NameB)) {
                                batsman6ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman7NameB)) {
                                batsman7ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman8NameB)) {
                                batsman8ballsB += 1;

                            }
                            System.out.println("Team B batsman9 name :" + batsman9NameB);
                        }
                        if (teamBBatsmans.size() == 10) {
                            batsman10NameB = nonStrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameB)) {
                                batsman1ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman2NameB)) {
                                batsman2ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman3NameB)) {
                                batsman3ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman4NameB)) {
                                batsman4ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman5NameB)) {
                                batsman5ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman6NameB)) {
                                batsman6ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman7NameB)) {
                                batsman7ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman8NameB)) {
                                batsman8ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman9NameB)) {
                                batsman9ballsB += 1;

                            }
                            System.out.println("Team B batsman10 name :" + batsman10NameB);
                        }
                        if (teamBBatsmans.size() == 11) {
                            batsman11NameB = nonStrikerBatsman.getText().replaceAll("\s", "");
                            if (whoGotOut.equals(batsman1NameB)) {
                                batsman1ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman2NameB)) {
                                batsman2ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman3NameB)) {
                                batsman3ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman4NameB)) {
                                batsman4ballsB += 1;

                            }
                            if (whoGotOut.equals(batsman5NameB)) {
                                batsman5ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman6NameB)) {
                                batsman6ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman7NameB)) {
                                batsman7ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman8NameB)) {
                                batsman8ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman9NameB)) {
                                batsman9ballsB += 1;
                            }
                            if (whoGotOut.equals(batsman10NameB)) {
                                batsman10ballsB += 1;
                            }
                            System.out.println("Team B batsman11 name :" + batsman11NameB);
                        }
                    }
                }
            }

            if (outs < 0 || outs > 10) {
                System.out.println("Something's Wrong");
            }
            overComplete();
        }

        if (e.getSource() == undo) {

            String textString = l.getText();
            int len = textString.length();
            // System.out.println("Before :"+len);

            // System.out.println(len/5);

            String subString = textString.substring(len - 5);
            subString = subString.replaceAll("\\s", ""); // remove all whitespaces
            // System.out.println(subString);

            if (subString.length() == 1) {

                if (Integer.parseInt(subString) == 0) {
                    runsShow -= 0;
                    DisplayRuns.setText(runsShow.toString());
                    // System.out.println(textString);
                    textString = textString.substring(0, textString.length() - 5);
                }
                if (Integer.parseInt(subString) == 1) {
                    runsShow -= 1;
                    DisplayRuns.setText(runsShow.toString());
                    // System.out.println(textString);
                    textString = textString.substring(0, textString.length() - 5);
                    switchBatsman();
                }
                if (Integer.parseInt(subString) == 2) {
                    runsShow -= 2;
                    DisplayRuns.setText(runsShow.toString());
                    // System.out.println(textString);
                    textString = textString.substring(0, textString.length() - 5);
                }
                if (Integer.parseInt(subString) == 3) {
                    runsShow -= 3;
                    DisplayRuns.setText(runsShow.toString());
                    // System.out.println(textString);
                    textString = textString.substring(0, textString.length() - 5);
                    switchBatsman();
                }
                if (Integer.parseInt(subString) == 4) {
                    runsShow -= 4;
                    DisplayRuns.setText(runsShow.toString());
                    // System.out.println(textString);
                    textString = textString.substring(0, textString.length() - 5);
                }
                if (Integer.parseInt(subString) == 5) {
                    runsShow -= 5;
                    DisplayRuns.setText(runsShow.toString());
                    // System.out.println(textString);
                    textString = textString.substring(0, textString.length() - 5);
                    switchBatsman();
                }
                if (Integer.parseInt(subString) == 6) {
                    runsShow -= 6;
                    DisplayRuns.setText(runsShow.toString());
                    // System.out.println(textString);
                    textString = textString.substring(0, textString.length() - 5);
                }
                cnt -= 1;
                oversDecimal.setText(cnt.toString());
                // System.out.println(textString);
                // textString = textString.substring(0, textString.length() - 5);
                // cnt-=1;
            }
            if (subString.length() == 2) {
                Integer outs = Integer.parseInt(fallOfWickets.getText());
                outs -= 1;
                fallOfWickets.setText(outs.toString());
                cnt -= 1;
                oversDecimal.setText(cnt.toString());
                // System.out.println(textString);
                textString = textString.substring(0, textString.length() - 6);
            }

            if (subString.length() == 4) {
                String lastChar = subString.substring(3);

                if (subString.contains("L")) {
                    runsShow -= ((Integer.parseInt(lastChar)));
                    cnt -= 1;
                    oversDecimal.setText(cnt.toString());
                    if ((Integer.parseInt(lastChar)) == 1 || (Integer.parseInt(lastChar)) == 3
                            || (Integer.parseInt(lastChar)) == 5) {
                        switchBatsman();
                    }

                } else {
                    runsShow -= ((Integer.parseInt(lastChar)) + 1);
                    fontSize += 3;
                    if ((Integer.parseInt(lastChar)) == 1 || (Integer.parseInt(lastChar)) == 3
                            || (Integer.parseInt(lastChar)) == 5) {
                        switchBatsman();
                    }
                }

                DisplayRuns.setText(runsShow.toString());
                l.setFont(new Font("Calibri", Font.BOLD, fontSize));
                // System.out.println(textString);
                textString = textString.substring(0, textString.length() - 8);
            }

            if (subString.length() == 5) {
                String lastChar = subString.substring(4);
                runsShow -= ((Integer.parseInt(lastChar)));
                fontSize += 2;
                l.setFont(new Font("Calibri", Font.BOLD, fontSize));
                if ((Integer.parseInt(lastChar)) == 1 || (Integer.parseInt(lastChar)) == 3
                        || (Integer.parseInt(lastChar)) == 5) {
                    switchBatsman();
                }
                DisplayRuns.setText(runsShow.toString());
                cnt -= 1;
                oversDecimal.setText(cnt.toString());
                // System.out.println(textString);
                textString = textString.substring(0, textString.length() - 9);
            }

            len = textString.length();
            // System.out.println(textString);
            l.setText(textString);
            // System.out.println("After :"+len);

        }
        System.out.println("Runs scored :" + runsShow);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        if ((TossWonByStr.equals(Team1Name) && electedTo.equals("Bat")
                || (TossWonByStr.equals(Team2Name) && electedTo.equals("Field")))) {
            battingTeamName.setText(Team1Name);
            selectBatsmanAtStart(TeamA, Team1Name);
            selectBowler(TeamB, Team2Name);
            StrikerBatsman.setSelected(true);
        } else if ((TossWonByStr.equals(Team2Name) && electedTo.equals("Bat")
                || (TossWonByStr.equals(Team1Name) && electedTo.equals("Field")))) {
            battingTeamName.setText(Team2Name);
            selectBatsmanAtStart(TeamB, Team2Name);
            selectBowler(TeamA, Team1Name);
            StrikerBatsman.setSelected(true);
        }
        System.out.println("Window Opened");

    }

    @Override
    public void windowClosing(WindowEvent e) {
        // System.out.println("Window Closing");

    }

    @Override
    public void windowClosed(WindowEvent e) {
        // System.out.println("Window Closed");

    }

    @Override
    public void windowIconified(WindowEvent e) {
        // System.out.println("Window Iconified");

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // System.out.println("Window Deiconified");

    }

    @Override
    public void windowActivated(WindowEvent e) {
        // System.out.println("Window activated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // System.out.println("Window Deactivated");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == StrikerBatsman) {
            System.out.println("Sriker Batsman Radio Clicked");
        }
        if (e.getSource() == nonStrikerBatsman) {
            System.out.println("Non Sriker Batsman Radio Clicked");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
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
}
