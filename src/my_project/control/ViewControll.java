package my_project.control;

import my_project.model.SpielClient;
import my_project.model.Spieler;
import my_project.view.Anwendungsstart;
import my_project.view.Endbildschirm;
import my_project.view.SpielInterface;
import my_project.view.Verbindungsaufbau;

import javax.swing.*;
import java.awt.*;

public class ViewControll {

    private SpielClient spielClient;
    private Spieler spieler;
    private GameControll gC;
    private Verbindungsaufbau verbindungsaufbau;
    private Anwendungsstart anwendungsstart;
    private SpielInterface spielInterface;
    private Endbildschirm endbildschirm;

    public ViewControll(GameControll gameControll) {
        verbindungsaufbau = new Verbindungsaufbau(this);
        anwendungsstart = new Anwendungsstart(this);
        spielInterface = new SpielInterface(this);
        endbildschirm = new Endbildschirm();
        gC = gameControll;
    }

    public void verbindungZumServerSuchen(String ip, int port){
        gC.erstelleClient(ip, port);
    }

    public void setSpieler(Spieler spieler) {
        this.spieler = spieler;
    }

    public void nameFensterStart(){
        verbindungsaufbau.setFensterVisible(false);
        anwendungsstart.setVisibility(true);
    }

    public void auswahlKannGesendetWerden(){
        spielInterface.absendeBereit(true);
    }

    public void draussen(String grund){
        verbindungsaufbau.setFensterVisible(true);
        spielInterface.setFensterVisible(false);
        anwendungsstart.setVisibility(false);
        JOptionPane.showMessageDialog(null,grund);
    }

    public void aussetzen(){
        spielInterface.setzeGegnerName("aussetzen");
        JOptionPane.showMessageDialog(null,"Diese Runde musst du leider aussetzen, gedulde dich, gleich geht es weiter!");
    }

    public void zeitUpdate(String zeit){
        if (anwendungsstart.sichtbar()) anwendungsstart.setTimer(zeit);
        if(spielInterface.sichtbar()){
            spielInterface.setTimer(zeit);
        }
        if(spielInterface.sichtbar() && Integer.parseInt(zeit) <= 1){
            spielInterface.timerAblauf();
        }
        if(anwendungsstart.sichtbar() && Integer.parseInt(zeit) <= 1){
            anwendungsstart.setVisibility(false);
            spielInterface.setFensterVisible(true);
        }
    }

    public void UebermittleWerte(String name, Image myImage){
        gC.sendeNamen(name);
        gC.setName(name);
        gC.setImage(myImage);
        spielInterface.meineAttribute();
    }

    public void ranking(String ranking){
        spielInterface.setRanking(ranking);
    }

    public String getMeinName(){
        return spieler.getName();
    }

    public Image getMyImage(){
        return spieler.getImage();
    }

    public void setMeineAuswahl(String auswahl){
        spieler.setMeineAuswahl(auswahl);
    }

    public void sendeMeineAuswahl(){
        if(!spieler.getMeineAuswahl().equals("")){
            gC.sendeAuswahl(spieler.getMeineAuswahl());
        }
    }

    public String getMeineAuswahl(){
        return spieler.getMeineAuswahl();
    }

    public void uebergebeGegner(){
        spielInterface.setzeGegnerName(spieler.getMeinGegener());
    }

    public void uebergebeGegnerischeAuswahl(String s){
        spielInterface.gegnerischeAuswahl(s);
    }

    public void uebergebeAusgabe(String s){
        spielInterface.setzeAusgang(s);
    }

    public void spielZuEnde(String first, String second, String third){
        spielInterface.setFensterVisible(false);
        endbildschirm.setVisible(true);
        endbildschirm.siegerUebermittlung(first, second, third);
    }

}
