import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Auto;

class TestAuto {
    @Test
    void testDemarrerDeuxFoisLanceException() {
        Auto auto = new Auto();
        auto.demarrer(); // premier démarrage OK
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            auto.demarrer(); // deuxième démarrage doit lancer l’exception
        });
        assertEquals("Auto est déjà démarré(e)", exception.getMessage());
    }
}