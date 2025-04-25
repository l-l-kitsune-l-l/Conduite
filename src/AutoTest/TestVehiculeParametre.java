package AutoTest;

import model.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVehiculeParametre {

    @ParameterizedTest
    @CsvSource({
        "Auto, 180",
        "Moto, 220",
        "Velo, 40"
    })
    void testVitesseMax(String typeVehicule, int vitesseMaxAttendue) {
        Vehicule v;
        switch (typeVehicule) {
            case "Auto": v = new Auto(); break;
            case "Moto": v = new Moto(); break;
            default: v = new Velo(); break;
        }

        v.demarrer();
        for (int i = 0; i < 20; i++) {
            v.accelerer(); 
        }

        assertEquals(vitesseMaxAttendue, v.getVitesse(),
            "La vitesse ne doit pas dépasser la vitesse max");
    }
}
