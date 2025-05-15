class Person{
  private String name;
  private Karte[] hand;
  private int punkteStand;
  private boolean istBlackjack;
  
  public Person(String name) {
    this.name = name;
    this.hand = new Karte[0];  
    this.punkteStand = 0;
    this.istBlackjack = false;
  }
  
  public String getName(){
    return this.name;
  }
  
  public void setName(String name){
    this.name=name;
  }
  
  public Karte[] getHand(){
    return this.hand;
  }
  
  public void setHand(Karte[] hand){
    this.hand=hand;
  }
  
  public int getPunkteStand(){
    return this.punkteStand;
  }

  public void setPunkteStand(int punkteStand){
    this.punkteStand=punkteStand;
  }

  public boolean getIstBlackjack(){
    return this.istBlackjack;
  }
  
  public void setIstBlackjack(boolean istBlackjack){
    this.istBlackjack=istBlackjack;
  }
  
  public void kartenHinzufuegen(Karte[] karten){ 
    Karte[] neueHand=newKarte[this.hand.length+karten.length];
    System.arraycopy(this.hand, 0, neueHand, 0, this.hand.length);
    System.arraycopy(karten, 0, neueHand, this.hand.length, karten.length);
    setHand(neueHand);
  }
  
  public void berechnePunkteStand() {
        int punkte = 0;
        int anzahlAsse = 0;

        for (Karte karte : getHand()) {
            if (karte != null) {
                punkte += karte.getWert();

                if (karte.istAss()) { //Asse zaehlen
                    anzahlAsse++;
                }
            }
        }

        // Wenn es Asse gibt, prüfe, ob sie als 11 oder 1 gewertet werden sollten
        for (int i = 0; i < anzahlAsse; i++) {
            if (punkte > 21) { // Wenn der Punktestand mehr als 21 beträgt, wandle ein Ass von 11 auf 1 um
                punkte -= 10;  // Das Ass wird von 11 auf 1 umgestellt
            }
        }
        setPunkteStand(punkte);  
        if (punkte == 21 && getHand().length == 2) { // Prüfe, ob der Spieler oder Dealer Blackjack hat 
            setIstBlackjack(true);
        } else {
            setIstBlackjack(false);
        }
    }
}
