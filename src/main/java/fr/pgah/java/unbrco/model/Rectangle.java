package fr.pgah.java.unbrco.model;

import fr.pgah.java.son.MidiSynth;
import java.awt.*;

public class Rectangle  extends Forme{

    private static final Color COULEUR_LIGNE_JOUEE = new Color(230, 158, 60);


    public Rectangle(Point hautGauche, MidiSynth midiSynth) {
        super(hautGauche, midiSynth);
        instrument = 1;
    }

    public void dessiner(Graphics g) {
        Color saveCouleur = g.getColor();
        if (estSelectionnee) {
          g.setColor(COULEUR_LIGNE_JOUEE);
        } else {
        g.setColor(Color.white);
        }
        g.fillRect(x, y, longueur, hauteur);
        g.setColor(saveCouleur);
        g.drawRect(x, y, longueur, hauteur);
    
        if (colonneJouee > 0 && colonneJouee < longueur) {
        g.setColor(Color.red);
        g.drawLine(x + colonneJouee, y, x + colonneJouee, y + hauteur);
        g.setColor(saveCouleur);
        }
    }
    
}
