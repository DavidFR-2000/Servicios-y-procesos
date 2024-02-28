package org.example;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.*;
import java.io.File;
import java.net.URL;

public class Ayuda extends JFrame {

    private JFrame principal;
    private JMenuItem ayudaItem;

    public Ayuda() {
        creaVentanaPrincipal();
        ponLaAyuda();
        visualizaVentanaPrincipal();
    }

    private void visualizaVentanaPrincipal() {
        principal.pack();
        principal.setVisible(true);
        principal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void ponLaAyuda() {
        try {
            File fichero = new File("help/help_set.hs"); // Ubicación del archivo HelpSet
            URL hsURL = fichero.toURI().toURL();

            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            HelpBroker hb = helpset.createHelpBroker();

            hb.enableHelpOnButton(ayudaItem, "aplicacion", helpset); // Habilita ayuda en el JMenuItem
            hb.enableHelpKey(principal.getContentPane(), "ventana_principal", helpset);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void creaVentanaPrincipal() {
        principal = new JFrame("Ventana principal");
        JMenuBar menuBar = new JMenuBar();
        ayudaItem = new JMenuItem("Ayuda");
        menuBar.add(ayudaItem);
        principal.setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ayuda());
    }
}
