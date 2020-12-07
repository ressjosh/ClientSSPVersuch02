package my_project.control;

import my_project.model.SpielClient;
import my_project.model.Spieler;

import java.awt.*;

public class GameControll {

    private SpielClient spielClient;
    private ViewControll vC;
    private Spieler spieler;

    public GameControll(){
        vC = new ViewControll(this);
    }

    public void erstelleClient(String serverIP, int serverPort){
        try {
            spielClient = new SpielClient(serverIP, serverPort, this);
        }catch(Exception e){
            System.out.println("Dieser Server existiert leider nicht");
        }
   }

   public void uebergebeGegner(){
        vC.uebergebeGegner();
   }

   public void uebergebeGegnerischeAuswahl(String s){
        vC.uebergebeGegnerischeAuswahl(s);
   }

   public void nameKannGesendetWerden(){
        vC.nameFensterStart();
   }

   public void auswahlKannGesendetWerden(){
        vC.auswahlKannGesendetWerden();
   }

   public void draussen(String grund){
        vC.draussen(grund);
   }

   public void aussetzen(){
        vC.aussetzen();
   }

   public void zeitUpdate(String zeit){
        vC.zeitUpdate(zeit);
   }

   public void setSpieler(Spieler spieler){
        this.spieler = spieler;
        vC.setSpieler(spieler);
   }

   public void sendeNamen(String name){
        spielClient.send("name$" + name);
   }

   public void setName(String name){
        spieler.setName(name);
   }

   public void setImage(Image myImage){
        spieler.setMyImage(myImage);
   }

   public void rankingAktualisieren(String ranking){
        vC.ranking(ranking);
   }

   public void sendeAuswahl(String auswahl){
        spielClient.send("spiele$" + auswahl);
   }

   public void spielende(){
        spielClient.setSpielbeginn(true);

   }

   public void uebergebeAusgang(String s){
        vC.uebergebeAusgabe(s);
   }
}