package AutoTest;

import model.Auto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AutoTest {

    @Test
    void testDemarrer() {
        Auto auto = new Auto();
        assertFalse(auto.estDemarre(), "Le véhicule doit être arrêté par défaut");
        auto.demarrer();
        assertTrue(auto.estDemarre(), "Le véhicule doit être démarré après demarrer()");
    }

    @Test
    void testAccelerer() {
        Auto auto = new Auto();
        auto.demarrer();
        int vitesseAvant = auto.getVitesse();
        auto.accelerer();
        assertTrue(auto.getVitesse() > vitesseAvant, "La vitesse doit augmenter après accélération");
    }

    @Test
    void testRalentir() {
        Auto auto = new Auto();
        auto.demarrer();
        auto.accelerer(); 
        auto.ralentir();  
        assertEquals(10, auto.getVitesse(), "La vitesse doit avoir ralenti");
    }

    @Test
    void testFreiner() {
        Auto auto = new Auto();
        auto.demarrer();
        auto.accelerer();
        auto.freiner();   
        assertEquals(0, auto.getVitesse(), "La vitesse doit tomber à 0 après freinage");
    }

    @Test
    void testArreter() {
        Auto auto = new Auto();
        auto.demarrer();
        auto.accelerer();
        auto.arreter();
        assertFalse(auto.estDemarre(), "Le véhicule doit être arrêté");
        assertEquals(0, auto.getVitesse(), "La vitesse doit être 0 après arrêt");
    }
}
