package fr.pgah.java.unbrco.model;

import fr.pgah.java.son.MidiSynth;
import java.awt.*;


public class Arc extends Forme{
    
    private static final Color COULEUR_LIGNE_JOUEE = new Color(230, 158, 60);
    private int startAngle;
    private int arcAngle;
 

  public Arc(Point hautGauche, MidiSynth midiSynth) {
    super(hautGauche, midiSynth);
    instrument = 45;
    startAngle = 90;
    arcAngle = 180;
  }

  public void dessiner(Graphics g) {
    Color saveCouleur = g.getColor();
    if (estSelectionnee) {
      g.setColor(COULEUR_LIGNE_JOUEE);
    } else {
      g.setColor(Color.green);
    }
    g.fillArc(x, y, longueur, hauteur, startAngle, arcAngle);
    g.setColor(saveCouleur);
    g.drawArc(x, y, longueur, hauteur, startAngle, arcAngle);

    if (colonneJouee > 0 && colonneJouee < longueur) {
      g.setColor(Color.red);
      g.drawLine(x + colonneJouee, y, x + colonneJouee, y + hauteur);
      g.setColor(saveCouleur);
    }
  }



}
