package my_project.model;

import KAGO_framework.model.abitur.netz.Client;
import my_project.control.GameControll;

public class SpielClient extends Client {

    private Spieler meinSpieler;
    private GameControll myControll;
    private String[] aktuelleKommandos;
    private boolean spielbeginn;

    public SpielClient(String serverIP, int serverPort, GameControll controll){
        super(serverIP,serverPort);
        myControll = controll;
        meinSpieler = new Spieler();
        myControll.setSpieler(meinSpieler);
        spielbeginn = true;
    }

    @Override
    //Hier kommt die Nachricht an, muss aufgesplittet werden
    public void processMessage(String pMessage) {
        aktuelleKommandos = pMessage.split("\\$");
        System.out.println("AktuelleNachricht vom Server: ");
        System.out.println(pMessage);
        arbeiteKommandoAb();
    }

    public void arbeiteKommandoAb(){
        if(aktuelleKommandos[0].equals("sende")){
            if(aktuelleKommandos[1].equals("name")){
                myControll.nameKannGesendetWerden();
            }else if(aktuelleKommandos[1].equals("auswahl")){
                myControll.auswahlKannGesendetWerden();
            }else if(aktuelleKommandos[1].equals("weiterMachen")){

            }
        }else if(aktuelleKommandos[0].equals("punkte")){
            punkteAnzeigen(aktuelleKommandos);
        }else if(aktuelleKommandos[0].equals("gegner")){
            if(aktuelleKommandos[1].equals("name")){
                meinSpieler.setMeinGegener(aktuelleKommandos[2]);
                myControll.uebergebeGegner();
            }else if(aktuelleKommandos[1].equals("auswahl")){
                meinSpieler.setAuswahlGegner(aktuelleKommandos[2]);
                myControll.uebergebeGegnerischeAuswahl(aktuelleKommandos[2]);
            }
        }else if(aktuelleKommandos[0].equals("status")){
            if(aktuelleKommandos[1].equals("rausgeworfen")){
                myControll.draussen(aktuelleKommandos[2]);
            }else if(aktuelleKommandos[1].equals("aussetzen")){
                myControll.aussetzen();
            }else if(aktuelleKommandos[1].equals("spielende")){
                myControll.spielende();
            }else if(aktuelleKommandos[1].equals("ausgang")){
                myControll.uebergebeAusgang(aktuelleKommandos[2]);
            }
        }else if(aktuelleKommandos[0].equals("zeit")){
            myControll.zeitUpdate(aktuelleKommandos[1]);
        }
    }

    private void punkteAnzeigen(String[] aktuelleKommandos){
        if(spielbeginn){
            String tmp = "<html><body>Rangfolge:  <br/><br/";
            for(int i = 1; i < aktuelleKommandos.length; i++){
                if(i<=3) tmp+= ">"+ i + ". <";
                meinSpieler.setAlleSpieler(aktuelleKommandos[i] + "§" + 0);
                tmp += ">   "+aktuelleKommandos[i] + "  " + 0 + "<br/";
            }
            tmp+= "</body></html>";
            System.out.println(tmp);
            myControll.rankingAktualisieren(tmp);
            spielbeginn = false;
        }else{
            String tmp = "<html><body>Rangfolge:  <br/><br/";
            for(int i = 2; i < aktuelleKommandos.length; i= i +2){
                if(i<=6) tmp+= ">"+ i/2 + ". <";
                meinSpieler.setAlleSpieler(aktuelleKommandos[i-1] + "§" + aktuelleKommandos[i]);
                tmp += ">   "+aktuelleKommandos[i-1] + "  " + aktuelleKommandos[i] + "<br/";
            }
            tmp+= "</body></html>";
            System.out.println(tmp);
            myControll.rankingAktualisieren(tmp);
        }

    }

    public void setSpielbeginn(boolean b){
        spielbeginn = b;
    }

}
