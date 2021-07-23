package question1;
import question2.PileI;
import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer par votre classe Pile .
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile  {
    public final static int TAILLE_PAR_DEFAUT = 5;

    private Object[] zone;
    private int ptr;
    private int capacite;
    /**
     * à compléter
     * 
     */
    public Pile(int taille) {
        if (taille < 0)
            taille = TAILLE_PAR_DEFAUT;
            this.capacite=taille;
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
        this(TAILLE_PAR_DEFAUT);
        this.capacite=TAILLE_PAR_DEFAUT;
    }

    public void empiler(Object i) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = i;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }

    public boolean estVide() {
        return ptr == 0;
    }

    public boolean estPleine() {
        return ptr == zone.length;
    }
    public Object sommet() throws PileVideException{
         if (estVide())
        throw new PileVideException();
        return zone[ptr-1];}
    public int capacite(){
        return capacite;}
    public int taille(){
        return ptr;}
    
    public boolean equals(Object o){ 
     if ( !(o instanceof PileI) || o == null)
      return false;
    if (this.ptr == ((Pile)o).taille() && this.capacite == ((Pile)o).capacite())
      {int x = 0;
     for(int i = 0; i< this.ptr ; i++)
    if( this.zone[i] != ((Pile)o).zone[i])
    x ++;
    if (x == 0)
    return true;}
    return false;}
    
      
    public int hashCode(){
    return toString().hashCode();}
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i].toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}