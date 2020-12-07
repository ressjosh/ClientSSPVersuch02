package my_project.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import my_project.control.ViewControll;

public class Anwendungsstart {
    private JFrame frame01;
    private JButton charakter01;
    private JButton charakter02;
    private JButton charakter03;
    private JButton charakter04;
    private JButton charakter05;
    private JTextField name;
    private JLabel timer;
    private JPanel mainPanel;
    private JLabel ueberschrift;
    private JLabel tipp01;
    private JLabel tipp02;
    private JButton sendenButton;
    private JButton charakter06;
    private Font aufforderung;
    private boolean sichtbar;
    private ImageIcon[] icons;
    private ViewControll vC;
    private Image myImage;
    private String myName;


    public Anwendungsstart(ViewControll vC){
        this.vC = vC;

        icons = new ImageIcon[6];
        icons[0] = new ImageIcon(getClass().getResource("frodo.jpg"));
        icons[1] = new ImageIcon(getClass().getResource("harryPotter.jpg"));
        icons[2] = new ImageIcon(getClass().getResource("jamesBond.jpg"));
        icons[3] = new ImageIcon(getClass().getResource("menInBlack.jpg"));
        icons[4] = new ImageIcon(getClass().getResource("sherlockHolmes.jpg"));
        icons[5] = new ImageIcon(getClass().getResource("yoda.jpg"));
        charakter01.setIcon(icons[0]);
        charakter02.setIcon(icons[1]);
        charakter03.setIcon(icons[2]);
        charakter04.setIcon(icons[3]);
        charakter05.setIcon(icons[4]);
        charakter06.setIcon(icons[5]);
        charakter01.setBackground(Color.white);
        charakter02.setBackground(Color.white);
        charakter03.setBackground(Color.white);
        charakter04.setBackground(Color.white);
        charakter05.setBackground(Color.white);
        charakter06.setBackground(Color.white);

        sichtbar = false;
        aufforderung = new Font("Arial", Font.BOLD, 15);
        ueberschrift.setFont(aufforderung);
        ueberschrift.setForeground(Color.white);

        frame01 = new JFrame("Persönliche Attribute");
        frame01.setContentPane(mainPanel);
        frame01.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame01.pack();
        frame01.setVisible(false);
        frame01.setBounds(300,50,750,700);
        mainPanel.setBackground(Color.darkGray);

        tipp01.setFont(new Font("Arial", Font.ITALIC, 15));
        tipp02.setFont(new Font("Arial", Font.ITALIC, 15));
        timer.setForeground(Color.white);
        timer.setFont(new Font ("Arial", Font.BOLD, 30));

        sendenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!name.getText().equals("") && !(myImage == null)){
                    System.out.println("Die Attribute werden übermittelt");
                    vC.UebermittleWerte(name.getText(), myImage);
                    name.setEnabled(false);
                    charakter01.setEnabled(false);
                    charakter02.setEnabled(false);
                    charakter03.setEnabled(false);
                    charakter04.setEnabled(false);
                    charakter05.setEnabled(false);
                    charakter06.setEnabled(false);
                    sendenButton.setEnabled(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Wählen Sie bitte einen Charakter und setzen Sie einen Namen!");
                }
            }
        });

        charakter01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                charakter01.setBackground(Color.RED);
                charakter02.setBackground(Color.white);
                charakter03.setBackground(Color.white);
                charakter04.setBackground(Color.white);
                charakter05.setBackground(Color.white);
                charakter06.setBackground(Color.white);
                myImage = icons[0].getImage();
            }
        });
        charakter02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                charakter01.setBackground(Color.white);
                charakter02.setBackground(Color.red);
                charakter03.setBackground(Color.white);
                charakter04.setBackground(Color.white);
                charakter05.setBackground(Color.white);
                charakter06.setBackground(Color.white);
                myImage = icons[1].getImage();
            }
        });
        charakter03.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                charakter01.setBackground(Color.white);
                charakter02.setBackground(Color.white);
                charakter03.setBackground(Color.red);
                charakter04.setBackground(Color.white);
                charakter05.setBackground(Color.white);
                charakter06.setBackground(Color.white);
                myImage = icons[2].getImage();
            }
        });
        charakter04.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                charakter01.setBackground(Color.white);
                charakter02.setBackground(Color.white);
                charakter03.setBackground(Color.white);
                charakter04.setBackground(Color.red);
                charakter05.setBackground(Color.white);
                charakter06.setBackground(Color.white);
                myImage = icons[3].getImage();
            }
        });

        charakter05.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                charakter01.setBackground(Color.white);
                charakter02.setBackground(Color.white);
                charakter03.setBackground(Color.white);
                charakter04.setBackground(Color.white);
                charakter05.setBackground(Color.red);
                charakter06.setBackground(Color.white);
                myImage = icons[4].getImage();
            }
        });
        charakter06.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                charakter01.setBackground(Color.white);
                charakter02.setBackground(Color.white);
                charakter03.setBackground(Color.white);
                charakter04.setBackground(Color.white);
                charakter05.setBackground(Color.white);
                charakter06.setBackground(Color.red);
                myImage = icons[5].getImage();
            }
        });
    }

    public void setVisibility(boolean b){
        frame01.setVisible(b);
        sichtbar= b;
    }

    public boolean sichtbar(){
        return sichtbar;
    }

    public void setTimer(String i){
        if(Integer.parseInt(i) < 10) timer.setForeground(Color.RED);
        timer.setText(i);
    }
}
