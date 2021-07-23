package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
    if (taille<0)
    taille = 0;
    this.capacite=taille;
    this.stk = new Stack();
    stk.ensureCapacity(taille);
    }

    public Pile2(){
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(T o) throws PilePleineException{
        if (this.estPleine()) throw new PilePleineException();
        T x = stk.push(o);
    }

    public T depiler() throws PileVideException{
         if (this.estVide()) throw new PileVideException();
         return stk.pop();
    }

    public T sommet() throws PileVideException{
        if (this.estVide()) throw new PileVideException();
       return stk.peek();
    }

    public boolean estVide() {
         return stk.empty();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        if (stk.capacity()!=stk.size())
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
        Stack<T> stk2 = new Stack<T>();
        Stack<T> stk1 = new Stack<T>();
        StringBuffer sb = new StringBuffer();
        int size=stk.size();
        if (size >0)
        {sb.append(stk.peek().toString());
        stk2.push(stk.pop());
        for(int i=0 ; i<size-1;i++)
        {stk2.push(stk.pop());
         stk1.push(stk2.peek());
         sb.append(","+ stk1.pop().toString());}
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

}  // Pile2