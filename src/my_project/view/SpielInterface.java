package my_project.view;

import my_project.control.ViewControll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpielInterface {
    private JFrame fenster;
    private JPanel mainPanel;
    private JLabel ranking;
    private JButton auswahlAbschickenButton;
    private JButton laserschwert;
    private JButton pistoleButton;
    private JButton wissenschaftButton;
    private JButton giftButton;
    private JButton dolchButton;
    private JLabel timer;
    private JLabel myName;
    private JLabel laserschwertWertung;
    private JLabel pistoleWertung;
    private JLabel wissenschaftWertung;
    private JLabel giftWertung;
    private JLabel dolchWertung;
    private JLabel myImage;
    private JButton sendButton;
    private JLabel derGegner;
    private JPanel panel01;
    private JPanel panel02;
    private JPanel panel04;
    private JPanel panel05;
    private JPanel panel06;
    private JPanel timerPanel;
    private JLabel ausgang;
    private JButton startButton;
    private JTextPane textPane1;
    private ViewControll vC;
    private ImageIcon v;
    private boolean sichtbar;
    private ImageIcon[] icons;
    private ImageIcon kreuz;
    private ImageIcon krone;
    private boolean auswahlbereit;



    public SpielInterface(ViewControll vC){
        this.vC = vC;
        sichtbar = false;
        auswahlbereit = true;

        icons = new ImageIcon[5];
        icons[0] = new ImageIcon(getClass().getResource("laserschwert.jpg"));
        icons[1] = new ImageIcon(getClass().getResource("waltherPPK.jpg"));
        icons[2] = new ImageIcon(getClass().getResource("wissenschaft.jpg"));
        icons[3] = new ImageIcon(getClass().getResource("gift.jpg"));
        icons[4] = new ImageIcon(getClass().getResource("dolch.jpg"));
        laserschwert.setIcon(icons[0]);
        pistoleButton.setIcon(icons[1]);
        wissenschaftButton.setIcon(icons[2]);
        giftButton.setIcon(icons[3]);
        dolchButton.setIcon(icons[4]);

        laserschwertWertung.setVisible(false);
        pistoleWertung.setVisible(false);
        wissenschaftWertung.setVisible(false);
        giftWertung.setVisible(false);
        dolchWertung.setVisible(false);
        dolchButton.setBackground(Color.white);
        giftButton.setBackground(Color.white);
        laserschwert.setBackground(Color.white);
        pistoleButton.setBackground(Color.white);
        wissenschaftButton.setBackground(Color.white);

        krone = new ImageIcon(getClass().getResource("krone.png"));
        kreuz = new ImageIcon(getClass().getResource("x.jpg"));

        ImageIcon iimage = new ImageIcon(getClass().getResource("sendenButton.jpg"));
        auswahlAbschickenButton.setIcon(iimage);

        timer.setFont(new Font("Arial", Font.BOLD, 60));
        timer.setForeground(Color.white);
        fenster = new JFrame("Lasst uns spielen");
        fenster.setContentPane(mainPanel);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.pack();
        fenster.setVisible(false);
        fenster.setBounds(200,30,750,650);
        fenster.setBackground(Color.DARK_GRAY);
        mainPanel.setBackground(Color.darkGray);
        panel01.setBackground(Color.darkGray);
        panel02.setBackground(Color.darkGray);
        panel04.setBackground(Color.darkGray);
        panel05.setBackground(Color.darkGray);
        panel06.setBackground(Color.darkGray);
        timerPanel.setBackground(Color.red);


        Font universalFont = new Font("Arial", Font.BOLD, 20);
        ranking.setForeground(Color.white);
        ranking.setFont(universalFont);
        myName.setForeground(Color.white);
        myName.setFont(universalFont);
        derGegner.setForeground(Color.white);
        derGegner.setFont(universalFont);

        ausgang.setForeground(Color.white);
        ausgang.setFont(universalFont);

        auswahlAbschickenButton.setEnabled(false);

        pistoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAllWertungenVisible(false);
                laserschwertWertung.setIcon(kreuz);
                dolchWertung.setIcon(kreuz);
                giftWertung.setIcon(krone);
                wissenschaftWertung.setIcon(krone);
                setAllWertungenVisible(true);
                pistoleWertung.setVisible(false);
                if(auswahlbereit)vC.setMeineAuswahl("A");
            }
        });
        laserschwert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAllWertungenVisible(false);
                pistoleWertung.setIcon(krone);
                dolchWertung.setIcon(kreuz);
                giftWertung.setIcon(krone);
                wissenschaftWertung.setIcon(kreuz);
                setAllWertungenVisible(true);
                laserschwertWertung.setVisible(false);
                if(auswahlbereit)vC.setMeineAuswahl("B");
            }
        });
        wissenschaftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAllWertungenVisible(false);
                laserschwertWertung.setIcon(krone);
                pistoleWertung.setIcon(kreuz);
                dolchWertung.setIcon(kreuz);
                giftWertung.setIcon(krone);
                setAllWertungenVisible(true);
                wissenschaftWertung.setVisible(false);
                if(auswahlbereit)vC.setMeineAuswahl("C");
            }
        });
        giftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAllWertungenVisible(false);
                laserschwertWertung.setIcon(kreuz);
                dolchWertung.setIcon(krone);
                pistoleWertung.setIcon(krone);
                wissenschaftWertung.setIcon(kreuz);
                setAllWertungenVisible(true);
                giftWertung.setVisible(false);
                if(auswahlbereit)vC.setMeineAuswahl("D");
            }
        });
        dolchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAllWertungenVisible(false);
                laserschwertWertung.setIcon(kreuz);
                pistoleWertung.setIcon(krone);
                giftWertung.setIcon(kreuz);
                wissenschaftWertung.setIcon(krone);
                setAllWertungenVisible(true);
                dolchWertung.setVisible(false);
                if(auswahlbereit)vC.setMeineAuswahl("E");
            }
        });
        auswahlAbschickenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!vC.getMeineAuswahl().equals("")){
                    vC.sendeMeineAuswahl();
                    auswahlAbschickenButton.setEnabled(false);
                    auswahlbereit = false;
                }else{
                    JOptionPane.showMessageDialog(null, "Bitte tätige eine Auswahl");
                }
            }
        });
    }

    public void setFensterVisible(boolean b){
        fenster.setVisible(b);
        sichtbar = b;
    }

    public void setDerGegner(String s) {
        derGegner.setText(s);
    }

    public void setRanking(String s){
        ranking.setText(s);
    }

    public void meineAttribute(){
        myName.setText(vC.getMeinName());
        ImageIcon image = new ImageIcon();
        image.setImage(vC.getMyImage());
        myImage.setIcon(image);
    }

    public boolean sichtbar(){
        return sichtbar;
    }

    public void setTimer(String zeit){
        timer.setText(zeit);
        if(Integer.parseInt(zeit) < 10){
             timer.setForeground(Color.black);
        }
    }

    private void setAllWertungenVisible(boolean b){
        laserschwertWertung.setVisible(b);
        pistoleWertung.setVisible(b);
        wissenschaftWertung.setVisible(b);
        giftWertung.setVisible(b);
        dolchWertung.setVisible(b);
    }

    public void absendeBereit(boolean bereit){
        auswahlAbschickenButton.setEnabled(bereit);
    }

    public void setzeGegnerName(String name){
        derGegner.setText("gegen " + name);
    }

    public void gegnerischeAuswahl(String auswahl){
        if(!auswahl.equals(vC.getMeineAuswahl())){
            if(vC.getMeineAuswahl().equals("A")){
                setAllWertungenVisible(false);
                laserschwertWertung.setIcon(kreuz);
                dolchWertung.setIcon(kreuz);
                giftWertung.setIcon(krone);
                wissenschaftWertung.setIcon(krone);
                setAllWertungenVisible(true);
                pistoleWertung.setVisible(false);
                vC.setMeineAuswahl("A");
            }else if(vC.getMeineAuswahl().equals("B")){
                setAllWertungenVisible(false);
                pistoleWertung.setIcon(krone);
                dolchWertung.setIcon(kreuz);
                giftWertung.setIcon(krone);
                wissenschaftWertung.setIcon(kreuz);
                setAllWertungenVisible(true);
                laserschwertWertung.setVisible(false);
                if(auswahlbereit)vC.setMeineAuswahl("B");
            }else if(vC.getMeineAuswahl().equals("C")){
                setAllWertungenVisible(false);
                laserschwertWertung.setIcon(krone);
                pistoleWertung.setIcon(kreuz);
                dolchWertung.setIcon(kreuz);
                giftWertung.setIcon(krone);
                setAllWertungenVisible(true);
                wissenschaftWertung.setVisible(false);
                if(auswahlbereit)vC.setMeineAuswahl("C");
            }else if(vC.getMeineAuswahl().equals("D")){
                setAllWertungenVisible(false);
                laserschwertWertung.setIcon(kreuz);
                dolchWertung.setIcon(krone);
                pistoleWertung.setIcon(krone);
                wissenschaftWertung.setIcon(kreuz);
                setAllWertungenVisible(true);
                giftWertung.setVisible(false);
                if(auswahlbereit)vC.setMeineAuswahl("D");
            }else if(vC.getMeineAuswahl().equals("E")){
                setAllWertungenVisible(false);
                laserschwertWertung.setIcon(kreuz);
                pistoleWertung.setIcon(krone);
                giftWertung.setIcon(kreuz);
                wissenschaftWertung.setIcon(krone);
                setAllWertungenVisible(true);
                dolchWertung.setVisible(false);
                if(auswahlbereit)vC.setMeineAuswahl("E");
            }

            if(auswahl.equals("A")){
                pistoleButton.setBackground(Color.RED);
            }else if(auswahl.equals("B")){
                laserschwert.setBackground(Color.RED);
            }else if(auswahl.equals("C")){
                wissenschaftButton.setBackground(Color.red);
            }else if(auswahl.equals("D")){
                giftButton.setBackground(Color.red);
            }else if(auswahl.equals("E")){
                dolchButton.setBackground(Color.red);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ohh, das war ein unentschieden");
        }
    }

    public void timerAblauf(){
        auswahlbereit = true;
        setAllWertungenVisible(false);
        derGegner.setText("gegen....");
        dolchButton.setBackground(Color.white);
        giftButton.setBackground(Color.white);
        laserschwert.setBackground(Color.white);
        pistoleButton.setBackground(Color.white);
        wissenschaftButton.setBackground(Color.white);
        timer.setForeground(Color.white);
    }

    public void setzeAusgang(String s){
        ausgang.setText("Letzte Runde: " + s);
    }

}
