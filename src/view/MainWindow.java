package view;

import javax.swing.*;
import model.*;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JComboBox<String> vehicleSelector;
    private Vehicule[] vehicules = { new model.Auto(), new model.Moto(), new model.Velo() };

    public MainWindow() {
        super("Contrôle de véhicules");
        setupUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(793, 130);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void setupUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JLabel label = new JLabel("Choisir un véhicule:");
        label.setBounds(10, 16, 154, 13);
        mainPanel.add(label);

        vehicleSelector = new JComboBox<>(new String[]{"Auto", "Moto", "Vélo"});
        vehicleSelector.setBounds(174, 13, 96, 19);
        mainPanel.add(vehicleSelector);

        ControlPanel controlPanel = new ControlPanel(vehicules, vehicleSelector);
        controlPanel.setBounds(10, 42, 742, 41);
        mainPanel.add(controlPanel);

        getContentPane().add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainWindow().setVisible(true));
    }
}
