package fr.pgah.java.unbrco.model;

import fr.pgah.java.son.MidiSynth;
import java.awt.*;

public class Ovale extends Forme{
    
    private static final Color COULEUR_LIGNE_JOUEE = new Color(230, 158, 60);
 

  public Ovale(Point hautGauche, MidiSynth midiSynth) {
    super(hautGauche, midiSynth);
    instrument = 6;
  }

  public void dessiner(Graphics g) {
    Color saveCouleur = g.getColor();
    if (estSelectionnee) {
      g.setColor(COULEUR_LIGNE_JOUEE);
    } else {
      g.setColor(Color.blue);
    }
    g.fillOval(x, y, longueur, hauteur);
    g.setColor(saveCouleur);
    g.drawOval(x, y, longueur, hauteur);

    if (colonneJouee > 0 && colonneJouee < longueur) {
      g.setColor(Color.red);
      g.drawLine(x + colonneJouee, y, x + colonneJouee, y + hauteur);
      g.setColor(saveCouleur);
    }
  }



}
