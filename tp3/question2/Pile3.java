package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;
    public Pile3() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public Pile3(int taille) {
       if (taille<0)
       taille = CAPACITE_PAR_DEFAUT;
       this.v = new Vector(taille);
    }

    public void empiler(Object o) throws PilePleineException {
         if (this.estPleine()) throw new PilePleineException();
       Object ob = v.add(o);
    }

    public Object depiler() throws PileVideException {
         if (v.size()==0)
        throw new PileVideException();
        Object o = v.get(v.size()-1);
        v.remove(v.size()-1);
        return o;
    }

    public Object sommet() throws PileVideException {
        if (v.size()==0) throw new PileVideException();
        return v.elementAt(v.size()-1);
    }

    public int taille() {
        return v.size();
    }

    public int capacite() {
           return v.capacity();
    }

    public boolean estVide() {
        return v.isEmpty();
    }

    public boolean estPleine() {
         if (v.capacity() != v.size())
      return false;
      return true;
    }

    public String toString() {
        Vector ve = new Vector();
        for(int i=1;i<=v.size();i++)
        ve.add(v.get(v.size()-i));
        return ve.toString();
    }

    public boolean equals(Object o) {
        if (o instanceof PileI) {
      PileI p = (PileI) o;
      return this.capacite() == p.capacite()
          && this.hashCode() == p.hashCode();
    } else
      return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
