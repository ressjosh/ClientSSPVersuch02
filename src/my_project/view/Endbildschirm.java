package my_project.view;

import javax.swing.*;
import java.awt.*;

public class Endbildschirm {
    private JLabel First;
    private JLabel Second;
    private JLabel Third;
    private JPanel mainPanel;
    private JLabel ersterPlatz;
    private JLabel zweiterPlatz;
    private JLabel dritterPlatz;
    private JFrame fenster;
    private Font generalFont;

    public Endbildschirm(){
        fenster = new JFrame("Lasst uns spielen");
        fenster.setContentPane(mainPanel);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.pack();
        fenster.setVisible(false);
        fenster.setBounds(200,30,750,650);
        fenster.setBackground(Color.DARK_GRAY);
        mainPanel.setBackground(Color.darkGray);
        generalFont = new Font("Arial", Font.BOLD, 40);
        ersterPlatz.setFont(generalFont);
        zweiterPlatz.setFont(generalFont);
        dritterPlatz.setFont(generalFont);
        ersterPlatz.setForeground(Color.red);
        zweiterPlatz.setForeground(Color.red);
        dritterPlatz.setForeground(Color.red);
        First.setForeground(Color.lightGray);
        Second.setForeground(Color.lightGray);
        Third.setForeground(Color.lightGray);

    }




    public void setVisible(boolean b){
        fenster.setVisible(b);
    }

    public void siegerUebermittlung(String eins, String zwei, String drei){
        First.setText(eins);
        Second.setText(zwei);
        Third.setText(drei);
    }
}
