package model;

public abstract class Vehicule {
    protected int vitesse = 0;
    protected int vitesseMax;
    protected int deltaAcceleration;
    protected int deltaFreinage;
    protected int deltaRalentir;
    protected boolean demarre = false;

    public Vehicule(int vitesseMax, int deltaAcceleration, int deltaFreinage, int deltaRalentir) {
        this.vitesseMax = vitesseMax;
        this.deltaAcceleration = deltaAcceleration;
        this.deltaFreinage = deltaFreinage;
        this.deltaRalentir = deltaRalentir;
    }

    public void demarrer() {
        if (!demarre) {
            demarre = true;
            System.out.println(getClass().getSimpleName() + " démarré(e)");
        } else {
            System.out.println(getClass().getSimpleName() + " est déjà démarré(e)");
        }
    }

    public void arreter() {
        if (demarre) {
            demarre = false;
            vitesse = 0;
            System.out.println(getClass().getSimpleName() + " arrêté(e)");
        } else {
            System.out.println(getClass().getSimpleName() + " est déjà arrêté(e)");
        }
    }

    public void accelerer() {
        if (demarre) {
            vitesse += deltaAcceleration;
            if (vitesse > vitesseMax) vitesse = vitesseMax;
            System.out.println("Vitesse accélérée à " + vitesse + " km/h");
        } else {
            System.out.println("Démarrez le véhicule avant d'accélérer");
        }
    }

    public void ralentir() {
        if (demarre && vitesse > 0) {
            vitesse -= deltaRalentir;
            if (vitesse < 0) vitesse = 0;
            System.out.println("Vitesse ralentie à " + vitesse + " km/h");
        } else {
            System.out.println("Le véhicule est à l'arrêt ou non démarré");
        }
    }

    public void freiner() {
        if (demarre && vitesse > 0) {
            vitesse -= deltaFreinage;
            if (vitesse < 0) vitesse = 0;
            System.out.println("Freinage, vitesse à " + vitesse + " km/h");
        } else {
            System.out.println("Le véhicule est à l'arrêt ou non démarré");
        }
    }

    public int getVitesse() {
        return vitesse;
    }

    public boolean estDemarre() {
        return demarre;
    }
}
