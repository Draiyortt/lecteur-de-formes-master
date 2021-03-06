package fr.pgah.java.unbrco.model;

import fr.pgah.java.son.MidiSynth;
import java.awt.*;

public abstract class Forme {

  protected int x;
  protected int y;
  protected int longueur;
  protected int hauteur;
  protected boolean estSelectionnee;
  protected MidiSynth midiSynth;
  protected int instrument;

  protected int colonneJouee;

  public Forme(Point hautGauche, MidiSynth midiSynth) {
    
    x = (int) hautGauche.getX()  ;
    y = (int) hautGauche.getY();
    longueur = 0;
    longueur = 0;
    estSelectionnee = false;
    this.midiSynth = midiSynth;
    colonneJouee = 0;
  }

  public boolean contientX(int x) {

    // À COMPLÉTER
    // renvoyer vrai si le x donné est dans l'espace horizontal de la forme
    // renvoyer faux sinon

    if(x >= this.x && x<= this.x + longueur){
      return true;
    }
    else if(x <= this.x && x>= this.x + longueur){
      return true;
    }

    return false;
  }

  public boolean contientY(int y) {

    // À COMPLÉTER
    // renvoyer vrai si le y donné est dans l'espace vertical de la forme
    // renvoyer faux sinon

    if(y >= this.y && y<= this.y + hauteur){
      return true;
    }
    else if(y <= this.y && y>= this.y + hauteur){
      return true;
    }

    return false;
  }

  public boolean contient(Point pt) {

    // À COMPLÉTER
    // renvoyer vrai si le point donné est dans l'espace occupé par la forme
    // renvoyer faux sinon

    if(contientX((int) pt.getX()) && contientY((int) pt.getY())){
      return true;
    }


    return false;
  }

  public void setLimites(Point basDroite) {
    longueur = basDroite.x - x;
    hauteur = basDroite.y - y;
  }

  public abstract void dessiner(Graphics g) ;

  

  public void deplacer(int dx, int dy) {
    boolean changementNote;
    changementNote = (convertirCoordVersNote(y) != convertirCoordVersNote(y + dy));
    if (changementNote) {
      stopper();
    }
    x += dx;
    y += dy;
    if (changementNote) {
      jouer();
    }
  }

  public void selectionnerEtJouer() {
    if (!estSelectionnee) {
      estSelectionnee = true;
      jouer();
    }
  }

  public void deselectionnerEtStopper() {
    if (estSelectionnee) {
      estSelectionnee = false;
      stopper();
    }
  }

  public int getColonneJouee(){
    return colonneJouee;
  }

  private void jouer() {
    int volume = convertirZoneVersVelocite(longueur * hauteur);
    midiSynth.play(instrument, convertirCoordVersNote(y), volume);
  }

  private void stopper() {
    midiSynth.stop(instrument, convertirCoordVersNote(y));
  }

  protected int convertirZoneVersVelocite(int zone) {
    return Math.max(60, Math.min(127, zone / 30));
  }

  protected int convertirCoordVersNote(int y) {
    return 70 - y / 12;
  }

  public void setColonneJouee(int colonneCourante) {
  }

public int getLongueur() {
    return 0;
}


}
