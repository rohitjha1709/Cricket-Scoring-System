import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

class ScoreCard3 implements ActionListener {
        JFrame f2Frame;
        JScrollPane jp;
        JLabel img;
        JLabel sr, batsmanName, runs, ball, srate;
        JLabel one, two, thr, four, five, six, sev, eig, nine, ten, ele;
        JLabel btone, bttwo, btthr, btfour, btfive, btsix, btsev, bteig, btnine, btten, btele;
        JLabel rone, rtwo, rthr, rfour, rfive, rsix, rsev, reig, rnine, rten, rele;
        JLabel bone, btwo, bthr, bfour, bfive, bsix, bsev, beig, bnine, bten, bele;
        JComboBox<String> cb;
        String TeamA;
        String TeamB;
        int matchesPlayed;

        JLabel strone, strtwo, strthr, strfour, strfive, strsix, strsev, streig, strnine, strten, strele;

        JLabel srno, bwname, over, wick, bwrun, eco;
        JLabel srone, srtwo, srthr, srfour, srfive, srsix, srsev, sreig, srnine, srten, srele;
        JLabel bwone, bwtwo, bwthr, bwfour, bwfive, bwsix, bwsev, bweig, bwnine, bwten, bwele;
        JLabel ovone, ovtwo, ovthr, ovfour, ovfive, ovsix, ovsev, oveig, ovnine, ovten, ovele;
        JLabel wkone, wktwo, wkthr, wkfour, wkfive, wksix, wksev, wkeig, wknine, wkten, wkele;
        JLabel bwrone, bwrtwo, bwrthr, bwrfour, bwrfive, bwrsix, bwrsev, bwreig, bwrnine, bwrten, bwrele;
        JLabel eone, etwo, ethr, efour, efive, esix, esev, eeig, enine, eten, eele;

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
                        batsman7ballsA = 0, batsman8ballsA = 0, batsman9ballsA = 0, batsman10ballsA = 0,
                        batsman11ballsA = 0;

        String batsman1SrA, batsman2SrA, batsman3SrA, batsman4SrA, batsman5SrA,
                        batsman6SrA, batsman7SrA, batsman8SrA, batsman9SrA, batsman10SrA, batsman11SrA;

        Integer batsman1runsB = 0, batsman2runsB = 0, batsman3runsB = 0, batsman4runsB = 0, batsman5runsB = 0,
                        batsman6runsB = 0,
                        batsman7runsB = 0, batsman8runsB = 0, batsman9runsB = 0, batsman10runsB = 0, batsman11runsB = 0;

        Integer batsman1ballsB = 0, batsman2ballsB = 0, batsman3ballsB = 0, batsman4ballsB = 0, batsman5ballsB = 0,
                        batsman6ballsB = 0,
                        batsman7ballsB = 0, batsman8ballsB = 0, batsman9ballsB = 0, batsman10ballsB = 0,
                        batsman11ballsB = 0;

        String batsman1SrB, batsman2SrB, batsman3SrB, batsman4SrB, batsman5SrB,
                        batsman6SrB, batsman7SrB, batsman8SrB, batsman9SrB, batsman10SrB, batsman11SrB;

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
                        bowler7wicketsA = 0, bowler8wicketsA = 0, bowler9wicketsA = 0, bowler10wicketsA = 0,
                        bowler11wicketsA = 0;

        Integer bowler1wicketsB = 0, bowler2wicketsB = 0, bowler3wicketsB = 0, bowler4wicketsB = 0, bowler5wicketsB = 0,
                        bowler6wicketsB = 0,
                        bowler7wicketsB = 0, bowler8wicketsB = 0, bowler9wicketsB = 0, bowler10wicketsB = 0,
                        bowler11wicketsB = 0;

        Integer bowler1runsA = 0, bowler2runsA = 0, bowler3runsA = 0, bowler4runsA = 0, bowler5runsA = 0,
                        bowler6runsA = 0,
                        bowler7runsA = 0, bowler8runsA = 0, bowler9runsA = 0, bowler10runsA = 0, bowler11runsA = 0;

        Integer bowler1runsB = 0, bowler2runsB = 0, bowler3runsB = 0, bowler4runsB = 0, bowler5runsB = 0,
                        bowler6runsB = 0,
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
                        bowler7ExtrasA = 0, bowler8ExtrasA = 0, bowler9ExtrasA = 0, bowler10ExtrasA = 0,
                        bowler11ExtrasA = 0;

        Integer bowler1ExtrasB = 0, bowler2ExtrasB = 0, bowler3ExtrasB = 0, bowler4ExtrasB = 0, bowler5ExtrasB = 0,
                        bowler6ExtrasB = 0,
                        bowler7ExtrasB = 0, bowler8ExtrasB = 0, bowler9ExtrasB = 0, bowler10ExtrasB = 0,
                        bowler11ExtrasB = 0;

        String bowler1EconomyA = "----", bowler2EconomyA = "----", bowler3EconomyA = "----", bowler4EconomyA = "----",
                        bowler5EconomyA = "----",
                        bowler6EconomyA = "----", bowler7EconomyA = "----", bowler8EconomyA = "----",
                        bowler9EconomyA = "----", bowler10EconomyA = "----", bowler11EconomyA = "----";

        String bowler1EconomyB = "----", bowler2EconomyB = "----", bowler3EconomyB = "----", bowler4EconomyB = "----",
                        bowler5EconomyB = "----",
                        bowler6EconomyB = "----", bowler7EconomyB = "----", bowler8EconomyB = "----",
                        bowler9EconomyB = "----", bowler10EconomyB = "----", bowler11EconomyB = "----";

        public void scorecard69(String team1Name, String team2Name, int matchesPlayedCnt) throws Exception {
                f2Frame = new JFrame("Match Summary");
                TeamA = team1Name;
                TeamB = team2Name;
                matchesPlayed = matchesPlayedCnt;

                String teams[] = { TeamA, TeamB };
                cb = new JComboBox<>(teams);
                cb.setBounds(50, 50, 90, 20);
                cb.addActionListener(this);
                sr = new JLabel("  Sr no"); // First row
                batsmanName = new JLabel("       Batsman Name");
                runs = new JLabel("   Runs");
                ball = new JLabel("   Balls");

                srate = new JLabel("   Str Rate");

                sr.setBounds(50, 100, 50, 30);
                borderThemAll(sr);
                // sr.setText();
                batsmanName.setBounds(100, 100, 190, 30);
                // changeFont(batsmanName);
                borderThemAll(batsmanName);
                runs.setBounds(290, 100, 80, 30);
                borderThemAll(runs);
                ball.setBounds(370, 100, 80, 30);
                borderThemAll(ball);

                srate.setBounds(450, 100, 100, 30);
                borderThemAll(srate);

                one = new JLabel("  1"); // first coloum(Sr.nos)
                two = new JLabel("  2");
                thr = new JLabel("  3");
                four = new JLabel("  4");
                five = new JLabel("  5");
                six = new JLabel("  6");
                sev = new JLabel("  7");
                eig = new JLabel("  8");
                nine = new JLabel("  9");
                ten = new JLabel("  10");
                ele = new JLabel("  11");

                one.setBounds(50, 130, 50, 30); // Sr.nos setBounds
                borderThemAll(one);
                two.setBounds(50, 160, 50, 30);
                borderThemAll(two);
                thr.setBounds(50, 190, 50, 30);
                borderThemAll(thr);
                four.setBounds(50, 220, 50, 30);
                borderThemAll(four);
                five.setBounds(50, 250, 50, 30);
                borderThemAll(five);
                six.setBounds(50, 280, 50, 30);
                borderThemAll(six);
                sev.setBounds(50, 310, 50, 30);
                borderThemAll(sev);
                eig.setBounds(50, 340, 50, 30);
                borderThemAll(eig);
                nine.setBounds(50, 370, 50, 30);
                borderThemAll(nine);
                ten.setBounds(50, 400, 50, 30);
                borderThemAll(ten);
                ele.setBounds(50, 430, 50, 30);
                borderThemAll(ele);

                btone = new JLabel(); // Batsman Names
                bttwo = new JLabel();
                btthr = new JLabel();
                btfour = new JLabel();
                btfive = new JLabel();
                btsix = new JLabel();
                btsev = new JLabel();
                bteig = new JLabel();
                btnine = new JLabel();
                btten = new JLabel();
                btele = new JLabel();

                btone.setBounds(100, 130, 190, 30);// Bname setBounds
                borderThemAll(btone);
                bttwo.setBounds(100, 160, 190, 30);
                borderThemAll(bttwo);
                btthr.setBounds(100, 190, 190, 30);
                borderThemAll(btthr);
                btfour.setBounds(100, 220, 190, 30);
                borderThemAll(btfour);
                btfive.setBounds(100, 250, 190, 30);
                borderThemAll(btfive);
                btsix.setBounds(100, 280, 190, 30);
                borderThemAll(btsix);
                btsev.setBounds(100, 310, 190, 30);
                borderThemAll(btsev);
                bteig.setBounds(100, 340, 190, 30);
                borderThemAll(bteig);
                btnine.setBounds(100, 370, 190, 30);
                borderThemAll(btnine);
                btten.setBounds(100, 400, 190, 30);
                borderThemAll(btten);
                btele.setBounds(100, 430, 190, 30);
                borderThemAll(btele);

                rone = new JLabel(); // Batsman runs
                rtwo = new JLabel();
                rthr = new JLabel();
                rfour = new JLabel();
                rfive = new JLabel();
                rsix = new JLabel();
                rsev = new JLabel();
                reig = new JLabel();
                rnine = new JLabel();
                rten = new JLabel();
                rele = new JLabel();

                rone.setBounds(290, 130, 80, 30); // Btman run setBound
                borderThemAll(rone);
                rtwo.setBounds(290, 160, 80, 30);
                borderThemAll(rtwo);
                rthr.setBounds(290, 190, 80, 30);
                borderThemAll(rthr);
                rfour.setBounds(290, 220, 80, 30);
                borderThemAll(rfour);
                rfive.setBounds(290, 250, 80, 30);
                borderThemAll(rfive);
                rsix.setBounds(290, 280, 80, 30);
                borderThemAll(rsix);
                rsev.setBounds(290, 310, 80, 30);
                borderThemAll(rsev);
                reig.setBounds(290, 340, 80, 30);
                borderThemAll(reig);
                rnine.setBounds(290, 370, 80, 30);
                borderThemAll(rnine);
                rten.setBounds(290, 400, 80, 30);
                borderThemAll(rten);
                rele.setBounds(290, 430, 80, 30);
                borderThemAll(rele);

                bone = new JLabel(); // Balls played by batsman
                btwo = new JLabel();
                bthr = new JLabel();
                bfour = new JLabel();
                bfive = new JLabel();
                bsix = new JLabel();
                bsev = new JLabel();
                beig = new JLabel();
                bnine = new JLabel();
                bten = new JLabel();
                bele = new JLabel();

                bone.setBounds(370, 130, 80, 30); // Balls setBounds
                borderThemAll(bone);
                btwo.setBounds(370, 160, 80, 30);
                borderThemAll(btwo);
                bthr.setBounds(370, 190, 80, 30);
                borderThemAll(bthr);
                bfour.setBounds(370, 220, 80, 30);
                borderThemAll(bfour);
                bfive.setBounds(370, 250, 80, 30);
                borderThemAll(bfive);
                bsix.setBounds(370, 280, 80, 30);
                borderThemAll(bsix);
                bsev.setBounds(370, 310, 80, 30);
                borderThemAll(bsev);
                beig.setBounds(370, 340, 80, 30);
                borderThemAll(beig);
                bnine.setBounds(370, 370, 80, 30);
                borderThemAll(bnine);
                bten.setBounds(370, 400, 80, 30);
                borderThemAll(bten);
                bele.setBounds(370, 430, 80, 30);
                borderThemAll(bele);

                strone = new JLabel(); // Strike rate of batsman
                strtwo = new JLabel();
                strthr = new JLabel();
                strfour = new JLabel();
                strfive = new JLabel();
                strsix = new JLabel();
                strsev = new JLabel();
                streig = new JLabel();
                strnine = new JLabel();
                strten = new JLabel();
                strele = new JLabel();

                strone.setBounds(450, 130, 100, 30); // Str rate setBounds
                borderThemAll(strone);
                strtwo.setBounds(450, 160, 100, 30);
                borderThemAll(strtwo);
                strthr.setBounds(450, 190, 100, 30);
                borderThemAll(strthr);
                strfour.setBounds(450, 220, 100, 30);
                borderThemAll(strfour);
                strfive.setBounds(450, 250, 100, 30);
                borderThemAll(strfive);
                strsix.setBounds(450, 280, 100, 30);
                borderThemAll(strsix);
                strsev.setBounds(450, 310, 100, 30);
                borderThemAll(strsev);
                streig.setBounds(450, 340, 100, 30);
                borderThemAll(streig);
                strnine.setBounds(450, 370, 100, 30);
                borderThemAll(strnine);
                strten.setBounds(450, 400, 100, 30);
                borderThemAll(strten);
                strele.setBounds(450, 430, 100, 30);
                borderThemAll(strele);

                srno = new JLabel("  Sr no"); // Bowler coloum
                bwname = new JLabel("  Bowler Name");
                over = new JLabel("  Balls");
                wick = new JLabel("  Wickets");
                bwrun = new JLabel("  Runs");
                eco = new JLabel("  Economy");

                srno.setBounds(50, 510, 50, 30);// Bowler coloumnsetBounds
                borderThemAll(srno);
                bwname.setBounds(100, 510, 190, 30);
                borderThemAll(bwname);
                over.setBounds(290, 510, 80, 30);
                borderThemAll(over);
                wick.setBounds(370, 510, 80, 30);
                borderThemAll(wick);
                bwrun.setBounds(450, 510, 80, 30);
                borderThemAll(bwrun);
                eco.setBounds(530, 510, 80, 30);
                borderThemAll(eco);

                srone = new JLabel("  1"); // Bowler Sr no
                srtwo = new JLabel("  2");
                srthr = new JLabel("  3");
                srfour = new JLabel("  4");
                srfive = new JLabel("  5");
                srsix = new JLabel("  6");
                srsev = new JLabel("  7");
                sreig = new JLabel("  8");
                srnine = new JLabel("  9");
                srten = new JLabel("  10");
                srele = new JLabel("  11");

                srone.setBounds(50, 540, 50, 30); // Sr no setBounds
                borderThemAll(srone);
                srtwo.setBounds(50, 570, 50, 30);
                borderThemAll(srtwo);
                srthr.setBounds(50, 600, 50, 30);
                borderThemAll(srthr);
                srfour.setBounds(50, 630, 50, 30);
                borderThemAll(srfour);
                srfive.setBounds(50, 660, 50, 30);
                borderThemAll(srfive);
                srsix.setBounds(50, 690, 50, 30);
                borderThemAll(srsix);
                srsev.setBounds(50, 720, 50, 30);
                borderThemAll(srsev);
                sreig.setBounds(50, 750, 50, 30);
                borderThemAll(sreig);
                srnine.setBounds(50, 780, 50, 30);
                borderThemAll(srnine);
                srten.setBounds(50, 810, 50, 30);
                borderThemAll(srten);
                srele.setBounds(50, 840, 50, 30);
                borderThemAll(srele);

                bwone = new JLabel(); // Bowler Name
                bwtwo = new JLabel();
                bwthr = new JLabel();
                bwfour = new JLabel();
                bwfive = new JLabel();
                bwsix = new JLabel();
                bwsev = new JLabel();
                bweig = new JLabel();
                bwnine = new JLabel();
                bwten = new JLabel();
                bwele = new JLabel();

                bwone.setBounds(100, 540, 190, 30);// BwName setBounds
                // changeFont(bwone);
                borderThemAll(bwone);
                bwtwo.setBounds(100, 570, 190, 30);
                // changeFont(bwtwo);
                borderThemAll(bwtwo);
                bwthr.setBounds(100, 600, 190, 30);
                // changeFont(bwthr);
                borderThemAll(bwthr);
                bwfour.setBounds(100, 630, 190, 30);
                // changeFont(bwfour);
                borderThemAll(bwfour);
                bwfive.setBounds(100, 660, 190, 30);
                // changeFont(bwfive);
                borderThemAll(bwfive);
                bwsix.setBounds(100, 690, 190, 30);
                // changeFont(bwsix);
                borderThemAll(bwsix);
                bwsev.setBounds(100, 720, 190, 30);
                // changeFont(bwsev);
                borderThemAll(bwsev);
                bweig.setBounds(100, 750, 190, 30);
                // changeFont(bweig);
                borderThemAll(bweig);
                bwnine.setBounds(100, 780, 190, 30);
                // changeFont(bwnine);
                borderThemAll(bwnine);
                bwten.setBounds(100, 810, 190, 30);
                // changeFont(bwten);
                borderThemAll(bwten);
                bwele.setBounds(100, 840, 190, 30);
                // changeFont(bwele);
                borderThemAll(bwele);

                ovone = new JLabel(); // Overs
                ovtwo = new JLabel();
                ovthr = new JLabel();
                ovfour = new JLabel();
                ovfive = new JLabel();
                ovsix = new JLabel();
                ovsev = new JLabel();
                oveig = new JLabel();
                ovnine = new JLabel();
                ovten = new JLabel();
                ovele = new JLabel();

                ovone.setBounds(290, 540, 80, 30);
                // changeFont(ovone);
                borderThemAll(ovone);
                ovtwo.setBounds(290, 570, 80, 30);
                // changeFont(ovtwo);
                borderThemAll(ovtwo);
                ovthr.setBounds(290, 600, 80, 30);
                // changeFont(ovthr);
                borderThemAll(ovthr);
                ovfour.setBounds(290, 630, 80, 30);
                // changeFont(ovfour);
                borderThemAll(ovfour);
                ovfive.setBounds(290, 660, 80, 30);
                // changeFont(ovfive);
                borderThemAll(ovfive);
                ovsix.setBounds(290, 690, 80, 30);
                // changeFont(ovsix);
                borderThemAll(ovsix);
                ovsev.setBounds(290, 720, 80, 30);
                // changeFont(ovsev);
                borderThemAll(ovsev);
                oveig.setBounds(290, 750, 80, 30);
                // changeFont(oveig);
                borderThemAll(oveig);
                ovnine.setBounds(290, 780, 80, 30);
                // changeFont(ovnine);
                borderThemAll(ovnine);
                ovten.setBounds(290, 810, 80, 30);
                // changeFont(ovten);
                borderThemAll(ovten);
                ovele.setBounds(290, 840, 80, 30);
                // changeFont(ovele);
                borderThemAll(ovele);

                wkone = new JLabel(); // wickets
                wktwo = new JLabel();
                wkthr = new JLabel();
                wkfour = new JLabel();
                wkfive = new JLabel();
                wksix = new JLabel();
                wksev = new JLabel();
                wkeig = new JLabel();
                wknine = new JLabel();
                wkten = new JLabel();
                wkele = new JLabel();

                wkone.setBounds(370, 540, 80, 30);
                // changeFont(wkone);
                borderThemAll(wkone);
                wktwo.setBounds(370, 570, 80, 30);
                // changeFont(wktwo);
                borderThemAll(wktwo);
                wkthr.setBounds(370, 600, 80, 30);
                // changeFont(wkthr);
                borderThemAll(wkthr);
                wkfour.setBounds(370, 630, 80, 30);
                // changeFont(wkfour);
                borderThemAll(wkfour);
                wkfive.setBounds(370, 660, 80, 30);
                // changeFont(wkfive);
                borderThemAll(wkfive);
                wksix.setBounds(370, 690, 80, 30);
                // changeFont(wksix);
                borderThemAll(wksix);
                wksev.setBounds(370, 720, 80, 30);
                // changeFont(wksev);
                borderThemAll(wksev);
                wkeig.setBounds(370, 750, 80, 30);
                // changeFont(wkeig);
                borderThemAll(wkeig);
                wknine.setBounds(370, 780, 80, 30);
                // changeFont(wknine);
                borderThemAll(wknine);
                wkten.setBounds(370, 810, 80, 30);
                // changeFont(wkten);
                borderThemAll(wkten);
                wkele.setBounds(370, 840, 80, 30);
                // changeFont(wkele);
                borderThemAll(wkele);

                bwrone = new JLabel(); // Bowler runs
                bwrtwo = new JLabel();
                bwrthr = new JLabel();
                bwrfour = new JLabel();
                bwrfive = new JLabel();
                bwrsix = new JLabel();
                bwrsev = new JLabel();
                bwreig = new JLabel();
                bwrnine = new JLabel();
                bwrten = new JLabel();
                bwrele = new JLabel();

                bwrone.setBounds(450, 540, 80, 30);// Bowler run setBounds
                // changeFont(bwrone);
                borderThemAll(bwrone);
                bwrtwo.setBounds(450, 570, 80, 30);
                // changeFont(bwrtwo);
                borderThemAll(bwrtwo);
                bwrthr.setBounds(450, 600, 80, 30);
                // changeFont(bwrthr);
                borderThemAll(bwrthr);
                bwrfour.setBounds(450, 630, 80, 30);
                // changeFont(bwrfour);
                borderThemAll(bwrfour);
                bwrfive.setBounds(450, 660, 80, 30);
                // changeFont(bwrfive);
                borderThemAll(bwrfive);
                bwrsix.setBounds(450, 690, 80, 30);
                // changeFont(bwrsix);
                borderThemAll(bwrsix);
                bwrsev.setBounds(450, 720, 80, 30);
                // changeFont(bwrsev);
                borderThemAll(bwrsev);
                bwreig.setBounds(450, 750, 80, 30);
                // changeFont(bwreig);
                borderThemAll(bwreig);
                bwrnine.setBounds(450, 780, 80, 30);
                // changeFont(bwrnine);
                borderThemAll(bwrnine);
                bwrten.setBounds(450, 810, 80, 30);
                // changeFont(bwrten);
                borderThemAll(bwrten);
                bwrele.setBounds(450, 840, 80, 30);
                // changeFont(bwrele);
                borderThemAll(bwrele);

                eone = new JLabel(); // Economy
                etwo = new JLabel();
                ethr = new JLabel();
                efour = new JLabel();
                efive = new JLabel();
                esix = new JLabel();
                esev = new JLabel();
                eeig = new JLabel();
                enine = new JLabel();
                eten = new JLabel();
                eele = new JLabel();

                eone.setBounds(530, 540, 80, 30); // Economy setBounds
                // changeFont(eone);
                borderThemAll(eone);
                etwo.setBounds(530, 570, 80, 30);
                // changeFont(etwo);
                borderThemAll(etwo);
                ethr.setBounds(530, 600, 80, 30);
                // changeFont(ethr);
                borderThemAll(ethr);
                efour.setBounds(530, 630, 80, 30);
                // changeFont(efour);
                borderThemAll(efour);
                efive.setBounds(530, 660, 80, 30);
                // changeFont(efive);
                borderThemAll(efive);
                esix.setBounds(530, 690, 80, 30);
                // changeFont(esix);
                borderThemAll(esix);
                esev.setBounds(530, 720, 80, 30);
                // changeFont(esev);
                borderThemAll(esev);
                eeig.setBounds(530, 750, 80, 30);
                // changeFont(eeig);
                borderThemAll(eeig);
                enine.setBounds(530, 780, 80, 30);
                // changeFont(enine);
                borderThemAll(enine);
                eten.setBounds(530, 810, 80, 30);
                // changeFont(eten);
                borderThemAll(eten);
                eele.setBounds(530, 840, 80, 30);
                // changeFont(eele);
                borderThemAll(eele);

                btone.setHorizontalAlignment(JLabel.CENTER);
                bttwo.setHorizontalAlignment(JLabel.CENTER);
                btthr.setHorizontalAlignment(JLabel.CENTER);
                btfour.setHorizontalAlignment(JLabel.CENTER);
                btfive.setHorizontalAlignment(JLabel.CENTER);
                btsix.setHorizontalAlignment(JLabel.CENTER);
                btsev.setHorizontalAlignment(JLabel.CENTER);
                bteig.setHorizontalAlignment(JLabel.CENTER);
                btnine.setHorizontalAlignment(JLabel.CENTER);
                btten.setHorizontalAlignment(JLabel.CENTER);
                btele.setHorizontalAlignment(JLabel.CENTER);
                rone.setHorizontalAlignment(JLabel.CENTER);
                rtwo.setHorizontalAlignment(JLabel.CENTER);
                rthr.setHorizontalAlignment(JLabel.CENTER);
                rfour.setHorizontalAlignment(JLabel.CENTER);
                rfive.setHorizontalAlignment(JLabel.CENTER);
                rsix.setHorizontalAlignment(JLabel.CENTER);
                rsev.setHorizontalAlignment(JLabel.CENTER);
                reig.setHorizontalAlignment(JLabel.CENTER);
                rnine.setHorizontalAlignment(JLabel.CENTER);
                rten.setHorizontalAlignment(JLabel.CENTER);
                rele.setHorizontalAlignment(JLabel.CENTER);
                bone.setHorizontalAlignment(JLabel.CENTER);
                btwo.setHorizontalAlignment(JLabel.CENTER);
                bthr.setHorizontalAlignment(JLabel.CENTER);
                bfour.setHorizontalAlignment(JLabel.CENTER);
                bfive.setHorizontalAlignment(JLabel.CENTER);
                bsix.setHorizontalAlignment(JLabel.CENTER);
                bsev.setHorizontalAlignment(JLabel.CENTER);
                beig.setHorizontalAlignment(JLabel.CENTER);
                bnine.setHorizontalAlignment(JLabel.CENTER);
                bten.setHorizontalAlignment(JLabel.CENTER);
                bele.setHorizontalAlignment(JLabel.CENTER);
                strone.setHorizontalAlignment(JLabel.CENTER);
                strtwo.setHorizontalAlignment(JLabel.CENTER);
                strthr.setHorizontalAlignment(JLabel.CENTER);
                strfour.setHorizontalAlignment(JLabel.CENTER);
                strfive.setHorizontalAlignment(JLabel.CENTER);
                strsix.setHorizontalAlignment(JLabel.CENTER);
                strsev.setHorizontalAlignment(JLabel.CENTER);
                streig.setHorizontalAlignment(JLabel.CENTER);
                strnine.setHorizontalAlignment(JLabel.CENTER);
                strten.setHorizontalAlignment(JLabel.CENTER);
                strele.setHorizontalAlignment(JLabel.CENTER);
                bwone.setHorizontalAlignment(JLabel.CENTER);
                bwtwo.setHorizontalAlignment(JLabel.CENTER);
                bwthr.setHorizontalAlignment(JLabel.CENTER);
                bwfour.setHorizontalAlignment(JLabel.CENTER);
                bwfive.setHorizontalAlignment(JLabel.CENTER);
                bwsix.setHorizontalAlignment(JLabel.CENTER);
                bwsev.setHorizontalAlignment(JLabel.CENTER);
                bweig.setHorizontalAlignment(JLabel.CENTER);
                bwnine.setHorizontalAlignment(JLabel.CENTER);
                bwten.setHorizontalAlignment(JLabel.CENTER);
                bwele.setHorizontalAlignment(JLabel.CENTER);
                ovone.setHorizontalAlignment(JLabel.CENTER);
                ovtwo.setHorizontalAlignment(JLabel.CENTER);
                ovthr.setHorizontalAlignment(JLabel.CENTER);
                ovfour.setHorizontalAlignment(JLabel.CENTER);
                ovfive.setHorizontalAlignment(JLabel.CENTER);
                ovsix.setHorizontalAlignment(JLabel.CENTER);
                ovsev.setHorizontalAlignment(JLabel.CENTER);
                oveig.setHorizontalAlignment(JLabel.CENTER);
                ovnine.setHorizontalAlignment(JLabel.CENTER);
                ovten.setHorizontalAlignment(JLabel.CENTER);
                ovele.setHorizontalAlignment(JLabel.CENTER);
                wkone.setHorizontalAlignment(JLabel.CENTER);
                wktwo.setHorizontalAlignment(JLabel.CENTER);
                wkthr.setHorizontalAlignment(JLabel.CENTER);
                wkfour.setHorizontalAlignment(JLabel.CENTER);
                wkfive.setHorizontalAlignment(JLabel.CENTER);
                wksix.setHorizontalAlignment(JLabel.CENTER);
                wksev.setHorizontalAlignment(JLabel.CENTER);
                wkeig.setHorizontalAlignment(JLabel.CENTER);
                wknine.setHorizontalAlignment(JLabel.CENTER);
                wkten.setHorizontalAlignment(JLabel.CENTER);
                wkele.setHorizontalAlignment(JLabel.CENTER);
                bwrone.setHorizontalAlignment(JLabel.CENTER);
                bwrtwo.setHorizontalAlignment(JLabel.CENTER);
                bwrthr.setHorizontalAlignment(JLabel.CENTER);
                bwrfour.setHorizontalAlignment(JLabel.CENTER);
                bwrfive.setHorizontalAlignment(JLabel.CENTER);
                bwrsix.setHorizontalAlignment(JLabel.CENTER);
                bwrsev.setHorizontalAlignment(JLabel.CENTER);
                bwreig.setHorizontalAlignment(JLabel.CENTER);
                bwrnine.setHorizontalAlignment(JLabel.CENTER);
                bwrten.setHorizontalAlignment(JLabel.CENTER);
                bwrele.setHorizontalAlignment(JLabel.CENTER);
                eone.setHorizontalAlignment(JLabel.CENTER);
                etwo.setHorizontalAlignment(JLabel.CENTER);
                ethr.setHorizontalAlignment(JLabel.CENTER);
                efour.setHorizontalAlignment(JLabel.CENTER);
                efive.setHorizontalAlignment(JLabel.CENTER);
                esix.setHorizontalAlignment(JLabel.CENTER);
                esev.setHorizontalAlignment(JLabel.CENTER);
                eeig.setHorizontalAlignment(JLabel.CENTER);
                enine.setHorizontalAlignment(JLabel.CENTER);
                eten.setHorizontalAlignment(JLabel.CENTER);
                eele.setHorizontalAlignment(JLabel.CENTER);

                /*
                 * f.add(bwone);f.add(bwtwo);
                 * 
                 * f.add(ovone);f.add(ovtwo);
                 */

                JPanel batsmansPanel;
                batsmansPanel = new JPanel();
                batsmansPanel.setLayout(null);
                batsmansPanel.setBackground(new Color(150, 150, 150));
                batsmansPanel.setBounds(30, 80, 650, 900);
                // JLabel name = new JLabel("CRICKET CHAMPIONSHIP");
                // name.setForeground(Color.WHITE);
                // name.setBounds(150, 25, 400, 50);
                // batsmansPanel.add(name);

                batsmansPanel.add(sr);
                batsmansPanel.add(batsmanName);

                batsmansPanel.add(runs);
                batsmansPanel.add(ball);
                batsmansPanel.add(srate);

                batsmansPanel.add(one);
                batsmansPanel.add(two);
                batsmansPanel.add

                (thr);
                batsmansPanel.add(four);
                batsmansPanel.add(five);
                batsmansPanel.add

                (six);
                batsmansPanel.add(sev);
                batsmansPanel.add(eig);
                batsmansPanel.add

                (nine);
                batsmansPanel.add(ten);
                batsmansPanel.add(ele);

                batsmansPanel.add(btone);
                batsmansPanel.add(bttwo);
                batsmansPanel.add

                (btthr);
                batsmansPanel.add(btfour);
                batsmansPanel.add(btfive);
                batsmansPanel.add

                (btsix);
                batsmansPanel.add(btsev);
                batsmansPanel.add(bteig);
                batsmansPanel.add

                (btnine);
                batsmansPanel.add(btten);
                batsmansPanel.add(btele);

                batsmansPanel.add(rone);
                batsmansPanel.add(rtwo);
                batsmansPanel.add

                (rthr);
                batsmansPanel.add(rfour);
                batsmansPanel.add(rfive);
                batsmansPanel.add

                (rsix);
                batsmansPanel.add(rsev);
                batsmansPanel.add(reig);
                batsmansPanel.add

                (rnine);
                batsmansPanel.add(rten);
                batsmansPanel.add(rele);

                batsmansPanel.add(bone);
                batsmansPanel.add(btwo);
                batsmansPanel.add

                (bthr);
                batsmansPanel.add(bfour);
                batsmansPanel.add(bfive);
                batsmansPanel.add

                (bsix);
                batsmansPanel.add(bsev);
                batsmansPanel.add(beig);
                batsmansPanel.add

                (bnine);
                batsmansPanel.add(bten);
                batsmansPanel.add(bele);

                batsmansPanel.add(strone);
                batsmansPanel.add(strtwo);
                batsmansPanel.add

                (strthr);
                batsmansPanel.add(strfour);
                batsmansPanel.add

                (strfive);
                batsmansPanel.add(strsix);
                batsmansPanel.add

                (strsev);
                batsmansPanel.add(streig);
                batsmansPanel.add

                (strnine);
                batsmansPanel.add(strten);
                batsmansPanel.add(strele);

                batsmansPanel.add(srno);
                batsmansPanel.add(bwname);
                batsmansPanel.add

                (over);
                batsmansPanel.add(wick);
                batsmansPanel.add(bwrun);
                batsmansPanel.add

                (eco);

                batsmansPanel.add(srone);
                batsmansPanel.add(srtwo);
                batsmansPanel.add

                (srthr);
                batsmansPanel.add(srfour);
                batsmansPanel.add(srfive);
                batsmansPanel.add

                (srsix);
                batsmansPanel.add(srsev);
                batsmansPanel.add(sreig);
                batsmansPanel.add

                (srnine);
                batsmansPanel.add(srten);
                batsmansPanel.add(srele);

                batsmansPanel.add(bwone);
                batsmansPanel.add(bwtwo);
                batsmansPanel.add

                (bwthr);
                batsmansPanel.add(bwfour);
                batsmansPanel.add(bwfive);
                batsmansPanel.add

                (bwsix);
                batsmansPanel.add(bwsev);
                batsmansPanel.add(bweig);
                batsmansPanel.add

                (bwnine);
                batsmansPanel.add(bwten);
                batsmansPanel.add(bwele);

                batsmansPanel.add(ovone);
                batsmansPanel.add(ovtwo);
                batsmansPanel.add

                (ovthr);
                batsmansPanel.add(ovfour);
                batsmansPanel.add(ovfive);
                batsmansPanel.add

                (ovsix);
                batsmansPanel.add(ovsev);
                batsmansPanel.add(oveig);
                batsmansPanel.add

                (ovnine);
                batsmansPanel.add(ovten);
                batsmansPanel.add(ovele);

                batsmansPanel.add(wkone);
                batsmansPanel.add(wktwo);
                batsmansPanel.add

                (wkthr);
                batsmansPanel.add(wkfour);
                batsmansPanel.add(wkfive);
                batsmansPanel.add

                (wksix);
                batsmansPanel.add(wksev);
                batsmansPanel.add(wkeig);
                batsmansPanel.add

                (wknine);
                batsmansPanel.add(wkten);
                batsmansPanel.add(wkele);

                batsmansPanel.add(bwrone);
                batsmansPanel.add(bwrtwo);
                batsmansPanel.add

                (bwrthr);
                batsmansPanel.add(bwrfour);
                batsmansPanel.add

                (bwrfive);
                batsmansPanel.add(bwrsix);
                batsmansPanel.add

                (bwrsev);
                batsmansPanel.add(bwreig);
                batsmansPanel.add

                (bwrnine);
                batsmansPanel.add(bwrten);
                batsmansPanel.add(bwrele);

                batsmansPanel.add(eone);
                batsmansPanel.add(etwo);
                batsmansPanel.add(ethr);
                batsmansPanel.add(efour);
                batsmansPanel.add

                (efive);
                batsmansPanel.add(esix);
                batsmansPanel.add(esev);
                batsmansPanel.add

                (eeig);
                batsmansPanel.add(enine);
                batsmansPanel.add(eten);
                batsmansPanel.add

                (eele);

                img = new JLabel(new ImageIcon("D:\\Programs\\Java\\JavaProject\\PlainImg2.jpg"));
                jp = new JScrollPane();
                img.add(batsmansPanel);
                img.add(cb);
                jp.setViewportView(img);
                f2Frame.add(jp);

                try {
                        getData();
                } catch (Exception e) {
                        e.printStackTrace();
                }

                f2Frame.setSize(800, 700);
                // f.setLayout(null);
                f2Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f2Frame.setVisible(true);
                f2Frame.setResizable(false);
                f2Frame.setLocationRelativeTo(null);
        }

        public void borderThemAll(JLabel obj) {
                Border border = BorderFactory.createLineBorder(Color.BLACK);
                obj.setBorder(border);
        }

        public void changeFont(JLabel obj) {
                obj.setFont(new Font("Calibri", Font.BOLD, 16));
                obj.setForeground(Color.WHITE);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if (cb.getSelectedItem().equals(TeamA)) {
                        System.out.println(TeamA + " Selected");
                        btone.setText(batsman1NameA); // Batsman name setText
                        bttwo.setText(batsman2NameA);
                        btthr.setText(batsman3NameA);
                        btfour.setText(batsman4NameA);
                        btfive.setText(batsman5NameA);
                        btsix.setText(batsman6NameA);
                        btsev.setText(batsman7NameA);
                        bteig.setText(batsman8NameA);
                        btnine.setText(batsman9NameA);
                        btten.setText(batsman10NameA);
                        btele.setText(batsman11NameA);

                        rone.setText(batsman1runsA.toString()); // Batsman Runs setText
                        rtwo.setText(batsman2runsA.toString());
                        rthr.setText(batsman3runsA.toString());
                        rfour.setText(batsman4runsA.toString());
                        rfive.setText(batsman5runsA.toString());
                        rsix.setText(batsman6runsA.toString());
                        rsev.setText(batsman7runsA.toString());
                        reig.setText(batsman8runsA.toString());
                        rnine.setText(batsman9runsA.toString());
                        rten.setText(batsman10runsA.toString());
                        rele.setText(batsman11runsA.toString());

                        bone.setText(batsman1ballsA.toString()); // Batsman balls played setText
                        btwo.setText(batsman2ballsA.toString());
                        bthr.setText(batsman3ballsA.toString());
                        bfour.setText(batsman4ballsA.toString());
                        bfive.setText(batsman5ballsA.toString());
                        bsix.setText(batsman6ballsA.toString());
                        bsev.setText(batsman7ballsA.toString());
                        beig.setText(batsman8ballsA.toString());
                        bnine.setText(batsman9ballsA.toString());
                        bten.setText(batsman10ballsA.toString());
                        bele.setText(batsman11ballsA.toString());

                        strone.setText(batsman1SrA); // Batsman strike rate setText
                        strtwo.setText(batsman2SrA);
                        strthr.setText(batsman3SrA);
                        strfour.setText(batsman4SrA);
                        strfive.setText(batsman5SrA);
                        strsix.setText(batsman6SrA);
                        strsev.setText(batsman7SrA);
                        streig.setText(batsman8SrA);
                        strnine.setText(batsman9SrA);
                        strten.setText(batsman10SrA);
                        strele.setText(batsman11SrA);

                        bwone.setText(bowler1NameB); // Bowler Name setText
                        bwtwo.setText(bowler2NameB);
                        bwthr.setText(bowler3NameB);
                        bwfour.setText(bowler4NameB);
                        bwfive.setText(bowler5NameB);
                        bwsix.setText(bowler6NameB);
                        bwsev.setText(bowler7NameB);
                        bweig.setText(bowler8NameB);
                        bwnine.setText(bowler9NameB);
                        bwten.setText(bowler10NameB);
                        bwele.setText(bowler11NameB);

                        ovone.setText("" + bowler1ballsCountB); // Overs setText
                        ovtwo.setText("" + bowler2ballsCountB);
                        ovthr.setText("" + bowler3ballsCountB);
                        ovfour.setText("" + bowler4ballsCountB);
                        ovfive.setText("" + bowler5ballsCountB);
                        ovsix.setText("" + bowler6ballsCountB);
                        ovsev.setText("" + bowler7ballsCountB);
                        oveig.setText("" + bowler8ballsCountB);
                        ovnine.setText("" + bowler9ballsCountB);
                        ovten.setText("" + bowler10ballsCountB);
                        ovele.setText("" + bowler11ballsCountB);

                        wkone.setText("" + bowler1wicketsB); // Wicket setText
                        wktwo.setText("" + bowler2wicketsB);
                        wkthr.setText("" + bowler3wicketsB);
                        wkfour.setText("" + bowler4wicketsB);
                        wkfive.setText("" + bowler5wicketsB);
                        wksix.setText("" + bowler6wicketsB);
                        wksev.setText("" + bowler7wicketsB);
                        wkeig.setText("" + bowler8wicketsB);
                        wknine.setText("" + bowler9wicketsB);
                        wkten.setText("" + bowler10wicketsB);
                        wkele.setText("" + bowler11wicketsB);

                        bwrone.setText("" + bowler1runsB); // Bowler run setText
                        bwrtwo.setText("" + bowler2runsB);
                        bwrthr.setText("" + bowler3runsB);
                        bwrfour.setText("" + bowler4runsB);
                        bwrfive.setText("" + bowler5runsB);
                        bwrsix.setText("" + bowler6runsB);
                        bwrsev.setText("" + bowler7runsB);
                        bwreig.setText("" + bowler8runsB);
                        bwrnine.setText("" + bowler9runsB);
                        bwrten.setText("" + bowler10runsB);
                        bwrele.setText("" + bowler11runsB);

                        eone.setText(bowler1EconomyB); // Economy setText
                        etwo.setText(bowler2EconomyB);
                        ethr.setText(bowler3EconomyB);
                        efour.setText(bowler4EconomyB);
                        efive.setText(bowler5EconomyB);
                        esix.setText(bowler6EconomyB);
                        esev.setText(bowler7EconomyB);
                        eeig.setText(bowler8EconomyB);
                        enine.setText(bowler9EconomyB);
                        eten.setText(bowler10EconomyB);
                        eele.setText(bowler11EconomyB);
                } else {
                        System.out.println(TeamB + " Selected");
                        btone.setText(batsman1NameB); // Batsman name setText
                        bttwo.setText(batsman2NameB);
                        btthr.setText(batsman3NameB);
                        btfour.setText(batsman4NameB);
                        btfive.setText(batsman5NameB);
                        btsix.setText(batsman6NameB);
                        btsev.setText(batsman7NameB);
                        bteig.setText(batsman8NameB);
                        btnine.setText(batsman9NameB);
                        btten.setText(batsman10NameB);
                        btele.setText(batsman11NameB);

                        rone.setText(batsman1runsB.toString()); // Batsman Runs setText
                        rtwo.setText(batsman2runsB.toString());
                        rthr.setText(batsman3runsB.toString());
                        rfour.setText(batsman4runsB.toString());
                        rfive.setText(batsman5runsB.toString());
                        rsix.setText(batsman6runsB.toString());
                        rsev.setText(batsman7runsB.toString());
                        reig.setText(batsman8runsB.toString());
                        rnine.setText(batsman9runsB.toString());
                        rten.setText(batsman10runsB.toString());
                        rele.setText(batsman11runsB.toString());

                        bone.setText(batsman1ballsB.toString()); // Batsman balls played setText
                        btwo.setText(batsman2ballsB.toString());
                        bthr.setText(batsman3ballsB.toString());
                        bfour.setText(batsman4ballsB.toString());
                        bfive.setText(batsman5ballsB.toString());
                        bsix.setText(batsman6ballsB.toString());
                        bsev.setText(batsman7ballsB.toString());
                        beig.setText(batsman8ballsB.toString());
                        bnine.setText(batsman9ballsB.toString());
                        bten.setText(batsman10ballsB.toString());
                        bele.setText(batsman11ballsB.toString());

                        strone.setText(batsman1SrB); // Batsman strike rate setText
                        strtwo.setText(batsman2SrB);
                        strthr.setText(batsman3SrB);
                        strfour.setText(batsman4SrB);
                        strfive.setText(batsman5SrB);
                        strsix.setText(batsman6SrB);
                        strsev.setText(batsman7SrB);
                        streig.setText(batsman8SrB);
                        strnine.setText(batsman9SrB);
                        strten.setText(batsman10SrB);
                        strele.setText(batsman11SrB);

                        bwone.setText(bowler1NameA); // Bowler Name setText
                        bwtwo.setText(bowler2NameA);
                        bwthr.setText(bowler3NameA);
                        bwfour.setText(bowler4NameA);
                        bwfive.setText(bowler5NameA);
                        bwsix.setText(bowler6NameA);
                        bwsev.setText(bowler7NameA);
                        bweig.setText(bowler8NameA);
                        bwnine.setText(bowler9NameA);
                        bwten.setText(bowler10NameA);
                        bwele.setText(bowler11NameA);

                        ovone.setText("" + bowler1ballsCountA); // Overs setText
                        ovtwo.setText("" + bowler2ballsCountA);
                        ovthr.setText("" + bowler3ballsCountA);
                        ovfour.setText("" + bowler4ballsCountA);
                        ovfive.setText("" + bowler5ballsCountA);
                        ovsix.setText("" + bowler6ballsCountA);
                        ovsev.setText("" + bowler7ballsCountA);
                        oveig.setText("" + bowler8ballsCountA);
                        ovnine.setText("" + bowler9ballsCountA);
                        ovten.setText("" + bowler10ballsCountA);
                        ovele.setText("" + bowler11ballsCountA);

                        wkone.setText("" + bowler1wicketsA); // Wicket setText
                        wktwo.setText("" + bowler2wicketsA);
                        wkthr.setText("" + bowler3wicketsA);
                        wkfour.setText("" + bowler4wicketsA);
                        wkfive.setText("" + bowler5wicketsA);
                        wksix.setText("" + bowler6wicketsA);
                        wksev.setText("" + bowler7wicketsA);
                        wkeig.setText("" + bowler8wicketsA);
                        wknine.setText("" + bowler9wicketsA);
                        wkten.setText("" + bowler10wicketsA);
                        wkele.setText("" + bowler11wicketsA);

                        bwrone.setText("" + bowler1runsA); // Bowler run setText
                        bwrtwo.setText("" + bowler2runsA);
                        bwrthr.setText("" + bowler3runsA);
                        bwrfour.setText("" + bowler4runsA);
                        bwrfive.setText("" + bowler5runsA);
                        bwrsix.setText("" + bowler6runsA);
                        bwrsev.setText("" + bowler7runsA);
                        bwreig.setText("" + bowler8runsA);
                        bwrnine.setText("" + bowler9runsA);
                        bwrten.setText("" + bowler10runsA);
                        bwrele.setText("" + bowler11runsA);

                        eone.setText(bowler1EconomyA); // Economy setText
                        etwo.setText(bowler2EconomyA);
                        ethr.setText(bowler3EconomyA);
                        efour.setText(bowler4EconomyA);
                        efive.setText(bowler5EconomyA);
                        esix.setText(bowler6EconomyA);
                        esev.setText(bowler7EconomyA);
                        eeig.setText(bowler8EconomyA);
                        enine.setText(bowler9EconomyA);
                        eten.setText(bowler10EconomyA);
                        eele.setText(bowler11EconomyA);

                }
        }

        public void getData() throws Exception {
                String batsmansData = "SELECT * FROM " + TeamA + "_VS_" + TeamB + "_M" + (matchesPlayed + 1)
                                + "T1 ORDER BY SrNo ASC";
                System.out.println(batsmansData);
                String bowlersData = "SELECT * FROM " + TeamA + "_VS_" + TeamB + "_M" + (matchesPlayed + 1)
                                + "T2 ORDER BY SrNo ASC";
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject?" +
                                "user=root&password=rohitjha");
                Statement st = conn.createStatement();
                ResultSet rs1 = st.executeQuery(batsmansData);

                rs1.next();
                batsman1NameA = rs1.getString(2);
                batsman1runsA = rs1.getInt(3);
                batsman1ballsA = rs1.getInt(4);
                batsman1SrA = rs1.getString(5);
                rs1.next();
                batsman2NameA = rs1.getString(2);
                batsman2runsA = rs1.getInt(3);
                batsman2ballsA = rs1.getInt(4);
                batsman2SrA = rs1.getString(5);
                rs1.next();
                batsman3NameA = rs1.getString(2);
                batsman3runsA = rs1.getInt(3);
                batsman3ballsA = rs1.getInt(4);
                batsman3SrA = rs1.getString(5);
                rs1.next();
                batsman4NameA = rs1.getString(2);
                batsman4runsA = rs1.getInt(3);
                batsman4ballsA = rs1.getInt(4);
                batsman4SrA = rs1.getString(5);
                rs1.next();
                batsman5NameA = rs1.getString(2);
                batsman5runsA = rs1.getInt(3);
                batsman5ballsA = rs1.getInt(4);
                batsman5SrA = rs1.getString(5);
                rs1.next();
                batsman6NameA = rs1.getString(2);
                batsman6runsA = rs1.getInt(3);
                batsman6ballsA = rs1.getInt(4);
                batsman6SrA = rs1.getString(5);
                rs1.next();
                batsman7NameA = rs1.getString(2);
                batsman7runsA = rs1.getInt(3);
                batsman7ballsA = rs1.getInt(4);
                batsman7SrA = rs1.getString(5);
                rs1.next();
                batsman8NameA = rs1.getString(2);
                batsman8runsA = rs1.getInt(3);
                batsman8ballsA = rs1.getInt(4);
                batsman8SrA = rs1.getString(5);
                rs1.next();
                batsman9NameA = rs1.getString(2);
                batsman9runsA = rs1.getInt(3);
                batsman9ballsA = rs1.getInt(4);
                batsman9SrA = rs1.getString(5);
                rs1.next();
                batsman10NameA = rs1.getString(2);
                batsman10runsA = rs1.getInt(3);
                batsman10ballsA = rs1.getInt(4);
                batsman10SrA = rs1.getString(5);
                rs1.next();
                batsman11NameA = rs1.getString(2);
                batsman11runsA = rs1.getInt(3);
                batsman11ballsA = rs1.getInt(4);
                batsman11SrA = rs1.getString(5);
                rs1.next();
                batsman1NameB = rs1.getString(2);
                batsman1runsB = rs1.getInt(3);
                batsman1ballsB = rs1.getInt(4);
                batsman1SrB = rs1.getString(5);
                rs1.next();
                batsman2NameB = rs1.getString(2);
                batsman2runsB = rs1.getInt(3);
                batsman2ballsB = rs1.getInt(4);
                batsman2SrB = rs1.getString(5);
                rs1.next();
                batsman3NameB = rs1.getString(2);
                batsman3runsB = rs1.getInt(3);
                batsman3ballsB = rs1.getInt(4);
                batsman3SrB = rs1.getString(5);
                rs1.next();
                batsman4NameB = rs1.getString(2);
                batsman4runsB = rs1.getInt(3);
                batsman4ballsB = rs1.getInt(4);
                batsman4SrB = rs1.getString(5);
                rs1.next();
                batsman5NameB = rs1.getString(2);
                batsman5runsB = rs1.getInt(3);
                batsman5ballsB = rs1.getInt(4);
                batsman5SrB = rs1.getString(5);
                rs1.next();
                batsman6NameB = rs1.getString(2);
                batsman6runsB = rs1.getInt(3);
                batsman6ballsB = rs1.getInt(4);
                batsman6SrB = rs1.getString(5);
                rs1.next();
                batsman7NameB = rs1.getString(2);
                batsman7runsB = rs1.getInt(3);
                batsman7ballsB = rs1.getInt(4);
                batsman7SrB = rs1.getString(5);
                rs1.next();
                batsman8NameB = rs1.getString(2);
                batsman8runsB = rs1.getInt(3);
                batsman8ballsB = rs1.getInt(4);
                batsman8SrB = rs1.getString(5);
                rs1.next();
                batsman9NameB = rs1.getString(2);
                batsman9runsB = rs1.getInt(3);
                batsman9ballsB = rs1.getInt(4);
                batsman9SrB = rs1.getString(5);
                rs1.next();
                batsman10NameB = rs1.getString(2);
                batsman10runsB = rs1.getInt(3);
                batsman10ballsB = rs1.getInt(4);
                batsman10SrB = rs1.getString(5);
                rs1.next();
                batsman11NameB = rs1.getString(2);
                batsman11runsB = rs1.getInt(3);
                batsman11ballsB = rs1.getInt(4);
                batsman11SrB = rs1.getString(5);

                rs1.close();

                ResultSet rs2 = st.executeQuery(bowlersData);

                rs2.next();
                bowler1NameA = rs2.getString(2);
                bowler1ballsCountA = rs2.getInt(3);
                bowler1wicketsA = rs2.getInt(4);
                bowler1runsA = rs2.getInt(5);
                bowler1EconomyA = rs2.getString(6);
                bowler1ExtrasA = rs2.getInt(7);
                rs2.next();
                bowler2NameA = rs2.getString(2);
                bowler2ballsCountA = rs2.getInt(3);
                bowler2wicketsA = rs2.getInt(4);
                bowler2runsA = rs2.getInt(5);
                bowler2EconomyA = rs2.getString(6);
                bowler2ExtrasA = rs2.getInt(7);
                rs2.next();
                bowler3NameA = rs2.getString(2);
                bowler3ballsCountA = rs2.getInt(3);
                bowler3wicketsA = rs2.getInt(4);
                bowler3runsA = rs2.getInt(5);
                bowler3EconomyA = rs2.getString(6);
                bowler3ExtrasA = rs2.getInt(7);
                rs2.next();
                bowler4NameA = rs2.getString(2);
                bowler4ballsCountA = rs2.getInt(3);
                bowler4wicketsA = rs2.getInt(4);
                bowler4runsA = rs2.getInt(5);
                bowler4EconomyA = rs2.getString(6);
                bowler4ExtrasA = rs2.getInt(7);
                rs2.next();
                bowler5NameA = rs2.getString(2);
                bowler5ballsCountA = rs2.getInt(3);
                bowler5wicketsA = rs2.getInt(4);
                bowler5runsA = rs2.getInt(5);
                bowler5EconomyA = rs2.getString(6);
                bowler5ExtrasA = rs2.getInt(7);
                rs2.next();
                bowler6NameA = rs2.getString(2);
                bowler6ballsCountA = rs2.getInt(3);
                bowler6wicketsA = rs2.getInt(4);
                bowler6runsA = rs2.getInt(5);
                bowler6EconomyA = rs2.getString(6);
                bowler6ExtrasA = rs2.getInt(7);
                rs2.next();
                bowler7NameA = rs2.getString(2);
                bowler7ballsCountA = rs2.getInt(3);
                bowler7wicketsA = rs2.getInt(4);
                bowler7runsA = rs2.getInt(5);
                bowler7EconomyA = rs2.getString(6);
                bowler7ExtrasA = rs2.getInt(7);
                rs2.next();
                bowler8NameA = rs2.getString(2);
                bowler8ballsCountA = rs2.getInt(3);
                bowler8wicketsA = rs2.getInt(4);
                bowler8runsA = rs2.getInt(5);
                bowler8EconomyA = rs2.getString(6);
                bowler8ExtrasA = rs2.getInt(7);
                rs2.next();
                bowler9NameA = rs2.getString(2);
                bowler9ballsCountA = rs2.getInt(3);
                bowler9wicketsA = rs2.getInt(4);
                bowler9runsA = rs2.getInt(5);
                bowler9EconomyA = rs2.getString(6);
                bowler9ExtrasA = rs2.getInt(7);
                rs2.next();
                bowler10NameA = rs2.getString(2);
                bowler10ballsCountA = rs2.getInt(3);
                bowler10wicketsA = rs2.getInt(4);
                bowler10runsA = rs2.getInt(5);
                bowler10EconomyA = rs2.getString(6);
                bowler10ExtrasA = rs2.getInt(7);
                rs2.next();
                bowler11NameA = rs2.getString(2);
                bowler11ballsCountA = rs2.getInt(3);
                bowler11wicketsA = rs2.getInt(4);
                bowler11runsA = rs2.getInt(5);
                bowler11EconomyA = rs2.getString(6);
                bowler11ExtrasA = rs2.getInt(7);
                rs2.next();
                bowler1NameB = rs2.getString(2);
                bowler1ballsCountB = rs2.getInt(3);
                bowler1wicketsB = rs2.getInt(4);
                bowler1runsB = rs2.getInt(5);
                bowler1EconomyB = rs2.getString(6);
                bowler1ExtrasB = rs2.getInt(7);
                rs2.next();
                bowler2NameB = rs2.getString(2);
                bowler2ballsCountB = rs2.getInt(3);
                bowler2wicketsB = rs2.getInt(4);
                bowler2runsB = rs2.getInt(5);
                bowler2EconomyB = rs2.getString(6);
                bowler2ExtrasB = rs2.getInt(7);
                rs2.next();
                bowler3NameB = rs2.getString(2);
                bowler3ballsCountB = rs2.getInt(3);
                bowler3wicketsB = rs2.getInt(4);
                bowler3runsB = rs2.getInt(5);
                bowler3EconomyB = rs2.getString(6);
                bowler3ExtrasB = rs2.getInt(7);
                rs2.next();
                bowler4NameB = rs2.getString(2);
                bowler4ballsCountB = rs2.getInt(3);
                bowler4wicketsB = rs2.getInt(4);
                bowler4runsB = rs2.getInt(5);
                bowler4EconomyB = rs2.getString(6);
                bowler4ExtrasB = rs2.getInt(7);
                rs2.next();
                bowler5NameB = rs2.getString(2);
                bowler5ballsCountB = rs2.getInt(3);
                bowler5wicketsB = rs2.getInt(4);
                bowler5runsB = rs2.getInt(5);
                bowler5EconomyB = rs2.getString(6);
                bowler5ExtrasB = rs2.getInt(7);
                rs2.next();
                bowler6NameB = rs2.getString(2);
                bowler6ballsCountB = rs2.getInt(3);
                bowler6wicketsB = rs2.getInt(4);
                bowler6runsB = rs2.getInt(5);
                bowler6EconomyB = rs2.getString(6);
                bowler6ExtrasB = rs2.getInt(7);
                rs2.next();
                bowler7NameB = rs2.getString(2);
                bowler7ballsCountB = rs2.getInt(3);
                bowler7wicketsB = rs2.getInt(4);
                bowler7runsB = rs2.getInt(5);
                bowler7EconomyB = rs2.getString(6);
                bowler7ExtrasB = rs2.getInt(7);
                rs2.next();
                bowler8NameB = rs2.getString(2);
                bowler8ballsCountB = rs2.getInt(3);
                bowler8wicketsB = rs2.getInt(4);
                bowler8runsB = rs2.getInt(5);
                bowler8EconomyB = rs2.getString(6);
                bowler8ExtrasB = rs2.getInt(7);
                rs2.next();
                bowler9NameB = rs2.getString(2);
                bowler9ballsCountB = rs2.getInt(3);
                bowler9wicketsB = rs2.getInt(4);
                bowler9runsB = rs2.getInt(5);
                bowler9EconomyB = rs2.getString(6);
                bowler9ExtrasB = rs2.getInt(7);
                rs2.next();
                bowler10NameB = rs2.getString(2);
                bowler10ballsCountB = rs2.getInt(3);
                bowler10wicketsB = rs2.getInt(4);
                bowler10runsB = rs2.getInt(5);
                bowler10EconomyB = rs2.getString(6);
                bowler10ExtrasB = rs2.getInt(7);
                rs2.next();
                bowler11NameB = rs2.getString(2);
                bowler11ballsCountB = rs2.getInt(3);
                bowler11wicketsB = rs2.getInt(4);
                bowler11runsB = rs2.getInt(5);
                bowler11EconomyB = rs2.getString(6);
                bowler11ExtrasB = rs2.getInt(7);

                rs2.close();

                System.out.println("team A batsman1 :" + batsman1NameA);
                System.out.println("team A batsman2 :" + batsman2NameA);
                System.out.println("team A batsman3 :" + batsman3NameA);
                System.out.println("team A batsman4 :" + batsman4NameA);
                System.out.println("team A batsman5 :" + batsman5NameA);
                System.out.println("team A batsman6 :" + batsman6NameA);
                System.out.println("team A batsman7 :" + batsman7NameA);
                System.out.println("team A batsman8 :" + batsman8NameA);
                System.out.println("team A batsman9 :" + batsman9NameA);
                System.out.println("team A batsman10 :" + batsman10NameA);
                System.out.println("team A batsman11 :" + batsman11NameA);
                System.out.println("team B batsman1 :" + batsman1NameB);
                System.out.println("team B batsman2 :" + batsman2NameB);
                System.out.println("team B batsman3 :" + batsman3NameB);
                System.out.println("team B batsman4 :" + batsman4NameB);
                System.out.println("team B batsman5 :" + batsman5NameB);
                System.out.println("team B batsman6 :" + batsman6NameB);
                System.out.println("team B batsman7 :" + batsman7NameB);
                System.out.println("team B batsman8 :" + batsman8NameB);
                System.out.println("team B batsman9 :" + batsman9NameB);
                System.out.println("team B batsman10 :" + batsman10NameB);
                System.out.println("team B batsman11 :" + batsman11NameB);

                System.out.println("team A bowler1 :" + bowler1NameA);
                System.out.println("team A bowler2 :" + bowler2NameA);
                System.out.println("team A bowler3 :" + bowler3NameA);
                System.out.println("team A bowler4 :" + bowler4NameA);
                System.out.println("team A bowler5 :" + bowler5NameA);
                System.out.println("team A bowler6 :" + bowler6NameA);
                System.out.println("team A bowler7 :" + bowler7NameA);
                System.out.println("team A bowler8 :" + bowler8NameA);
                System.out.println("team A bowler9 :" + bowler9NameA);
                System.out.println("team A bowler10 :" + bowler10NameA);
                System.out.println("team A bowler11 :" + bowler11NameA);
                System.out.println("team B bowler12 :" + bowler1NameB);
                System.out.println("team B bowler13 :" + bowler2NameB);
                System.out.println("team B bowler14 :" + bowler3NameA);
                System.out.println("team B bowler15 :" + bowler4NameA);
                System.out.println("team B bowler16 :" + bowler5NameA);
                System.out.println("team B bowler17 :" + bowler6NameA);
                System.out.println("team B bowler18 :" + bowler7NameA);
                System.out.println("team B bowler19 :" + bowler8NameA);
                System.out.println("team B bowler20 :" + bowler9NameA);
                System.out.println("team B bowler21 :" + bowler10NameA);
                System.out.println("team B bowler22 :" + bowler11NameA);

        }

        public static void main(String[] args) {
                ScoreCard3 ob69 = new ScoreCard3();
                try {
                        ob69.scorecard69("Team1", "Team2", 0);
                } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }
}