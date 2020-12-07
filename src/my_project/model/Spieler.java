package my_project.model;

import KAGO_framework.model.abitur.datenstrukturen.Queue;

import java.awt.*;

public class Spieler {
    private String name;
    private String meineAuswahl;
    private String letzteRundeErgebnis;
    private String meinGegener;
    private String auswahlGegner;
    private Queue<String> alleSpieler;
    private Image myImage;

    public Spieler() {
        meineAuswahl = "";
        auswahlGegner = "";
        meinGegener = "";
        letzteRundeErgebnis = "";
        alleSpieler = new Queue<>();
    }


    public void setAlleSpieler(String nameUndPunkte){
        alleSpieler.enqueue(nameUndPunkte);
    }

    public void entferneEinenSpieler(){
        alleSpieler.dequeue();
    }

    public boolean nochSpielerFurRanking(){
        return alleSpieler.isEmpty();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMeineAuswahl(String meineAuswahl) {
        this.meineAuswahl = meineAuswahl;
    }

    public String getName() {
        return name;
    }

    public String getMeineAuswahl() {
        return meineAuswahl;
    }

    public void setMeinGegener(String meinGegener) {
        this.meinGegener = meinGegener;
    }

    public void setAuswahlGegner(String auswahlGegner) {
        this.auswahlGegner = auswahlGegner;
    }

    public String getMeinGegener() {
        return meinGegener;
    }

    public String getAuswahlGegner() {
        return auswahlGegner;
    }

    public void setMyImage(Image image){
        myImage = image;
    }

    public Image getImage(){
        return myImage;
    }

}
