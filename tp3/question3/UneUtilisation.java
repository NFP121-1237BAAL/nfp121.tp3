package question3;

import question1.PolygoneRegulier;

public class UneUtilisation {

    public static void main(String[] args) throws Exception {
        PileI<PolygoneRegulier> p1 = new Pile2<PolygoneRegulier>();
        PileI<PileI<PolygoneRegulier>> p2 = new Pile2<PileI<PolygoneRegulier>>();
        PileI<PolygoneRegulier> p3 = new Pile2<PolygoneRegulier>();
        // p1 est ici une pile de polygones réguliers PolygoneRegulier.java
        try{
        p1.empiler(new PolygoneRegulier(4, 100));
        p1.empiler(new PolygoneRegulier(5, 100));
        p1.empiler(new PolygoneRegulier(7, 50));
        
        p3.empiler(new PolygoneRegulier(4, 100));
        p3.empiler(new PolygoneRegulier(5, 100));
        
        PolygoneRegulier p = (PolygoneRegulier)p1.depiler();
        System.out.println(" p1.depiler = " + p);

        System.out.println(" la pile p1 = " + p1);

        p2.empiler(p1);
        System.out.println(" la pile p2 = " + p2);
        p2.empiler(p3);
        boolean x = p1.equals(p3);
        System.out.println(" la pile p1 est elle egale pile p3 ??  " + x);
        PileI<PolygoneRegulier> y = (PileI<PolygoneRegulier>)p2.sommet();
        System.out.println(" p2.sommet = " + y);}
        
    
    
    
        

        /*try {
            p1.empiler(new PolygoneRegulier(5,100)); 
            // compilation
            // ....
             String s = (String)p1.depiler();} */
             
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}