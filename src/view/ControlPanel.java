package view;

import javax.swing.*;
import java.awt.event.*;
import model.Vehicule;

public class ControlPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final JLabel speedLabel = new JLabel("Vitesse: 0 km/h");

    public ControlPanel(Vehicule[] vehicules, JComboBox<String> selector) {
        setLayout(null);

        JButton btnDemarrer = new JButton("Démarrer");
        btnDemarrer.setBounds(10, 5, 90, 30);
        JButton btnAccelerer = new JButton("Accélérer");
        btnAccelerer.setBounds(110, 5, 90, 30);
        JButton btnRalentir = new JButton("Ralentir");
        btnRalentir.setBounds(210, 5, 90, 30);
        JButton btnFreiner = new JButton("Freiner");
        btnFreiner.setBounds(310, 5, 90, 30);
        JButton btnArreter = new JButton("Arrêter");
        btnArreter.setBounds(410, 5, 90, 30);

        speedLabel.setBounds(510, 10, 150, 20);

        add(btnDemarrer);
        add(btnAccelerer);
        add(btnRalentir);
        add(btnFreiner);
        add(btnArreter);
        add(speedLabel);

        btnDemarrer.addActionListener(e -> {
            Vehicule v = vehicules[selector.getSelectedIndex()];
            v.demarrer();
            updateStatus(v);
        });

        btnAccelerer.addActionListener(e -> {
            Vehicule v = vehicules[selector.getSelectedIndex()];
            v.accelerer();
            updateStatus(v);
        });

        btnRalentir.addActionListener(e -> {
            Vehicule v = vehicules[selector.getSelectedIndex()];
            v.ralentir();
            updateStatus(v);
        });

        btnFreiner.addActionListener(e -> {
            Vehicule v = vehicules[selector.getSelectedIndex()];
            v.freiner();
            updateStatus(v);
        });

        btnArreter.addActionListener(e -> {
            Vehicule v = vehicules[selector.getSelectedIndex()];
            v.arreter();
            updateStatus(v);
        });
    }

    private void updateStatus(Vehicule v) {
        speedLabel.setText(String.format("Vitesse: %d km/h - %s",
                v.getVitesse(),
                v.estDemarre() ? "Démarré" : "Arrêté"));
    }
}
