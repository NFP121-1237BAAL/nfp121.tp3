package question2;

/**
 * Classe-test Pile3Test.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 * 
 *          Les classes-test sont documentées ici :
 *          http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 *          et sont basées sur le document © 2002 Robert A. Ballance intitulé
 *          «JUnit: Unit Testing Framework».
 * 
 *          Les objets Test (et TestSuite) sont associés aux classes à tester
 *          par la simple relation yyyTest (e.g. qu'un Test de la classe
 *          Name.java se nommera NameTest.java); les deux se retrouvent dans le
 *          même paquetage. Les "engagements" (anglais : "fixture") forment un
 *          ensemble de conditions qui sont vraies pour chaque méthode Test à
 *          exécuter. Il peut y avoir plus d'une méthode Test dans une classe
 *          Test; leur ensemble forme un objet TestSuite. BlueJ découvrira
 *          automatiquement (par introspection) les méthodes Test de votre
 *          classe Test et générera la TestSuite conséquente. Chaque appel d'une
 *          méthode Test sera précédé d'un appel de setUp(), qui réalise les
 *          engagements, et suivi d'un appel à tearDown(), qui les détruit.
 */
public class Pile3Test extends junit.framework.TestCase {
    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).

    private PileI p1;
    private PileI p2;
    /**
     * Constructeur de la classe-test Pile3Test
     */
    public Pile3Test() {
    }

    /**
     * Met en place les engagements.
     * 
     * Méthode appelée avant chaque appel de méthode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        p1 = new Pile3();
        p2 = new Pile3(10);
    }

    public void test_Pile3_capacite() {
        assertEquals(p1.CAPACITE_PAR_DEFAUT, p1.capacite());
        assertEquals(10, p2.capacite());
        }
    public void test_Pile3_estPleine_taille_sommet() throws Exception {
        PileI p = new Pile3(2);
        p.empiler("A");
        assertEquals(1, p.taille());
        assertEquals("A", p.sommet());
        p.empiler("B");
        assertEquals(2, p.taille());
        assertEquals("B", p.sommet());
        assertEquals(true, p.estPleine());
        assertEquals(p.taille(), p.capacite());
        try {
            p.empiler("c");
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PilePleineException);
        }
    }
     public void test_Pile3_estVide() throws Exception {
        PileI p = new Pile3(4);
        assertTrue(p.estVide());
        try {
            Object v = p.depiler();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PileVideException);
        }
    }
    public void test_Pile_toString() throws Exception {
        PileI pile1 = new Pile3(3);
        assertEquals("toString incorrect ? ", "[]", pile1.toString());
        pile1.empiler("a");
        assertEquals("toString incorrect ? ", "[a]", pile1.toString());
        pile1.empiler("b");
        assertEquals("toString incorrect ? ", "[b, a]", pile1.toString());
        pile1.empiler("c");
        assertEquals("toString incorrect ? ", "[c, b, a]", pile1.toString());

    }
       public void test_Pile3_TailleNegative() {
        PileI p = new Pile2(-1);
        assertEquals(p.CAPACITE_PAR_DEFAUT, p.capacite());

    }

    public void test_Pile3_equals() throws Exception {
        PileI pile1 = new Pile3();
        pile1.empiler("A");
        pile1.empiler("b");
        pile1.empiler(1);

        p1.empiler("A");
        p1.empiler("b");
        assertFalse(pile1.equals(p1));
        p1.empiler(1);
        assertEquals(true,pile1.equals(p1));
        assertTrue("�galit� de deux piles ? ", p1.equals(pile1));
        assertTrue("�galit� de deux piles ? ", pile1.equals(p1));

        p1.empiler(1);
        assertFalse("�galit� de deux piles ? ", pile1.equals(p1));

    }
    protected void tearDown() // throws java.lang.Exception
    {
       p1=null;
       p2=null;
    }
}
