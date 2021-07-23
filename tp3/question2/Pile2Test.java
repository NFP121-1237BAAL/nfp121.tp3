package question2;

/**
 * Classe-test Pile2Test.
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
public class Pile2Test extends junit.framework.TestCase {
    private PileI p1;
    private PileI p2;
    /**
     * Constructeur de la classe-test Pile2Test
     */
    public Pile2Test() {
    }

    /**
     * Met en place les engagements.
     * 
     * Méthode appelée avant chaque appel de méthode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        p1 = new Pile2();
        p2 = new Pile2(6);
    }

    public void test_Pile1_capacite() {
        assertEquals(PileI.CAPACITE_PAR_DEFAUT, p1.capacite());
        assertEquals(6, p1.capacite());
        }
    public void test_Pile_estPleine_taille_sommet() throws Exception {
        PileI p = new Pile2(2);
        p.empiler(new Integer(2));
        assertEquals(1, p.taille());
        assertEquals(new Integer(2), p.sommet());
        p.empiler(new Integer(3));
        assertEquals(2, p.taille());
        assertEquals(new Integer(3), p.sommet());
        assertEquals(true, p.estPleine());
        assertEquals(p.taille(), p.capacite());
        try {
         p.empiler(new Integer(0));
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PilePleineException);
        }
    }
     public void test_Pile_estVide() throws Exception {
        PileI p = new Pile2(3);
        assertEquals(true, p.estVide());
        try {
            Object r = p.depiler();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PileVideException);
        }
    }
    public void test_Pile_toString() throws Exception {
        PileI pile1 = new Pile2(3);
        assertEquals("toString incorrect ? ", "[]", pile1.toString());
        pile1.empiler("a");
        assertEquals("toString incorrect ? ", "[a]", pile1.toString());
        pile1.empiler("b");
        assertEquals("toString incorrect ? ", "[b, a]", pile1.toString());
        pile1.empiler("c");
        assertEquals("toString incorrect ? ", "[c, b, a]", pile1.toString());

    }
       public void test_Pile_TailleNegative() {
        PileI p = new Pile2(-2);
        assertEquals(p.CAPACITE_PAR_DEFAUT, p.capacite());

    }

    public void test_Pile_equals() throws Exception {

        p1.empiler("A");
        p1.empiler(2);
        p1.empiler(1);

        p2.empiler("A");
        p2.empiler(2);
        p2.empiler(1);
        assertEquals(true,p1.equals(p2));
        assertTrue("�galit� de deux piles ? ", p2.equals(p1));
        assertTrue("�galit� de deux piles ? ", p1.equals(p1));

        p2.empiler(1);
        assertFalse("�galit� de deux piles ? ", p1.equals(p2));

    }
    protected void tearDown() // throws java.lang.Exception
    {
       p1=null;
       p2=null;
    }

    /**
     * Il ne vous reste plus qu'à définir une ou plusieurs méthodes de test. Ces
     * méthodes doivent vérifier les résultats attendus à l'aide d'assertions
     * assertTrue(<boolean>). Par convention, leurs noms devraient débuter par
     * "test". Vous pouvez ébaucher le corps grâce au menu contextuel
     * "Enregistrer une méthode de test".
     */

}
