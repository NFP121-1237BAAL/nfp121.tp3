package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
    /** la liste des Maillons/Elements */
    private Maillon stk;
    /** la capacité de la pile */
    private int capacite;
    /** le nombre */
    private int nombre;
    private Maillon suiv[] ;
    /**
     * Classe interne "statique" contenant chaque élément de la chaine c'est une
     * proposition, vous pouvez l'ignorer !
     */
    private static class Maillon implements Cloneable {
        private Object element;
        private Maillon suivant;

        public Maillon(Object element, Maillon suivant) {
            this.element = element;
            this.suivant = suivant;
        }

        public Maillon suivant() {
            return this.suivant;
        }

        public Object element() {
            return this.element;
        }

        public Object clone() throws CloneNotSupportedException {
            Maillon m = (Maillon) super.clone();
            m.element = element;
            return m;
        }
    }

    /**
     * Création d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit être > 0
     */
    public Pile4(int taille) {
        if (taille <= 0)
        taille = CAPACITE_PAR_DEFAUT;
        this.capacite = taille;
        this.nombre=0;
        this.stk= new Maillon(null,null);
        suiv = new Maillon[capacite];
    }

    public Pile4() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        
        if (estPleine())
            throw new PilePleineException();
            if (estVide())
            {stk.element = o;
             stk.suivant = suiv[nombre];
             nombre++;
            }
            else
              { nombre++;
                suiv[nombre-2] = new Maillon(o , suiv[nombre-1]);
                
            }
            
        
    }

    public Object depiler() throws PileVideException {
        Object p;
        if (estVide())
            throw new PileVideException();
        else
        if(nombre == 1)
        {nombre --;
        p = stk.element();
        stk.element=null;
        return p;}
        else
        {nombre --;
        return (suiv[nombre-1]).element();}
        
    }

    public Object sommet() throws PileVideException {
        if (estVide())
        throw new PileVideException();
        else 
        if (nombre == 1)
        return stk.element();
        else
        return suiv[nombre-2].element(); 
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return nombre == 0; 
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return capacite == nombre; 
    }

    /**
     * Retourne une représentation en String d'une pile, contenant la
     * représentation en String de chaque élément.
     * 
     * @return une représentation en String d'une pile
     */
    public String toString() {
        String s = "[";
        StringBuffer x = new StringBuffer();
        if (nombre>1)
        {x.append(suiv[nombre-2].element().toString());
        for(int i=2 ; i < nombre ; i++)
        {x.append(", ");
        x.append(suiv[nombre-i-1].element().toString());}
        x.append(", ");
        x.append(stk.element().toString());}
        else 
        if (nombre == 1)
        x.append(stk.element().toString());
        else
        x.append("");
        return s + x + "]";
    }

    public boolean equals(Object o) {
            if (o instanceof PileI) {
      PileI p = (PileI) o;
      return this.capacite() == p.capacite()
          && this.hashCode() == p.hashCode();
    } else
      return false;
    }
    

    public int capacite() {
        return this.capacite;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int taille() {
        return nombre;
    }
}