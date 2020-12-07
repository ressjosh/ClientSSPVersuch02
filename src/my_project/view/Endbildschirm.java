package my_project.view;

import javax.swing.*;
import java.awt.*;

public class Endbildschirm {
    private JButton möchtenSieErneutSpielenButton;
    private JLabel First;
    private JLabel Second;
    private JLabel Third;
    private JPanel mainPanel;
    private JFrame fenster;

    public Endbildschirm(){
        fenster = new JFrame("Lasst uns spielen");
        fenster.setContentPane(mainPanel);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.pack();
        fenster.setVisible(false);
        fenster.setBounds(200,30,750,650);
        fenster.setBackground(Color.DARK_GRAY);
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
