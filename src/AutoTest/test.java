package AutoTest;

import org.junit.jupiter.api.Test;

import model.Auto;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {
@Test
void testDemarrer() {
    Auto auto = new Auto();
    assertFalse(auto.estDemarre());
    auto.demarrer();
    assertTrue(auto.estDemarre());
}
  
}
