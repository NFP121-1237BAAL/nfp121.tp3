package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;
    /** la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
    if (taille<0)
    taille = CAPACITE_PAR_DEFAUT;
    this.capacite=taille;
    this.stk = new Stack();
    stk.ensureCapacity(taille);
    }

    // constructeur fourni
    public Pile2() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (this.estPleine()) throw new PilePleineException();
       Object ob = stk.push(o);
    }

    public Object depiler() throws PileVideException {
        if (this.estVide()) throw new PileVideException();
       return stk.pop();
    }

    public Object sommet() throws PileVideException {
        if (this.estVide()) throw new PileVideException();
       return stk.peek();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
         return stk.empty();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        if (this.capacite()!=stk.size())
      return false;
      return true;
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        String s = "[";
        Stack stk2 = new Stack();
        Stack stk1 = new Stack();
        StringBuffer sb = new StringBuffer();
        int size=stk.size();
        if (size >0)
        {sb.append(stk.peek().toString());
        stk2.push(stk.pop());
        for(int i=0 ; i<size-1;i++)
        {stk2.push(stk.pop());
         stk1.push(stk2.peek());
         sb.append(", "+ stk1.pop().toString());}
        for(int i=0 ; i<size;i++){
            stk.push(stk2.pop());
        }}
        else
        sb.append("");
        return s + sb + "]";
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

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        return stk.size();
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
       return this.capacite;
    }

} // Pile2.java
