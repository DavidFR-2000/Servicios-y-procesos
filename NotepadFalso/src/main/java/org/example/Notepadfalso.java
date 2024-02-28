package org.example;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class Notepadfalso extends JFrame implements ActionListener {

    JMenuBar menubar = new JMenuBar();
    JMenu archivo = new JMenu("Archivo");
    JMenuItem ayudaItem = new JMenuItem("Ayuda");

    JMenuItem nuevoArchivo = new JMenuItem("Nuevo");
    JMenuItem abrirArchivo = new JMenuItem("Abrir");
    JMenuItem guardarArchivo = new JMenuItem("Guardar");
    JMenuItem salir = new JMenuItem("Salir");


    JTextArea textArea = new JTextArea();

    Notepadfalso() {
        setTitle("NotePad Falso");
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icono = null;
        try{
            icono = new ImageIcon(getClass().getResource("notepad.png"));
        }catch (NullPointerException e){
            System.err.println("Imagen no encontrada");
            icono = new ImageIcon(getClass().getResource(""));
        }
        setIconImage(icono.getImage());

        setJMenuBar(menubar);
        menubar.add(archivo);
        menubar.add(ayudaItem);

        archivo.add(nuevoArchivo);
        archivo.add(abrirArchivo);
        archivo.add(guardarArchivo);
        archivo.add(salir);

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);
        textArea.setFont((new Font(Font.SANS_SERIF, Font.PLAIN, 20)));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);


        nuevoArchivo.addActionListener(this);
        abrirArchivo.addActionListener(this);
        guardarArchivo.addActionListener(this);
        salir.addActionListener(this);
        ayudaItem.addActionListener(this);

        nuevoArchivo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        abrirArchivo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0, KeyEvent.CTRL_DOWN_MASK));
        guardarArchivo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
        ayudaItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, KeyEvent.CTRL_DOWN_MASK));

    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        new Notepadfalso().setVisible(true);
    }
    private void mostrarAyuda() {
        try {
            File fichero = new File("help/help_set.hs"); // Ruta al archivo HelpSet
            URL hsURL = fichero.toURI().toURL();

            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            HelpBroker hb = helpset.createHelpBroker();

            hb.setDisplayed(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Nuevo")) {
            textArea.setText(null);
        } else if (e.getActionCommand().equalsIgnoreCase("Guardar")) {
            JFileChooser elegirArchivo = new JFileChooser();
            FileNameExtensionFilter filtroTexto = new FileNameExtensionFilter("Solo archivos(.txt)", "txt");
            elegirArchivo.setAcceptAllFileFilterUsed(false);
            elegirArchivo.addChoosableFileFilter(filtroTexto);

            int accion = elegirArchivo.showSaveDialog(null);
            if (accion != JFileChooser.APPROVE_OPTION) {
                return;
            } else {
                String nombreArchivo = elegirArchivo.getSelectedFile().getAbsolutePath().toString();
                if (!nombreArchivo.contains(".txt"))
                    nombreArchivo = nombreArchivo + ".txt";

                try {
                    BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo));
                    textArea.write(escritor);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getActionCommand().equalsIgnoreCase("Abrir")) {
            JFileChooser elegirArchivo = new JFileChooser();
            FileNameExtensionFilter filtroTexto = new FileNameExtensionFilter("Solo archivos(.txt)", "txt");
            elegirArchivo.setAcceptAllFileFilterUsed(false);
            elegirArchivo.addChoosableFileFilter(filtroTexto);

            int accion = elegirArchivo.showSaveDialog(null);
            if (accion != JFileChooser.APPROVE_OPTION) {
                return;
            } else {
                String nombreArchivo = elegirArchivo.getSelectedFile().getAbsolutePath().toString();
                if (!nombreArchivo.contains(".txt"))
                    nombreArchivo = nombreArchivo + ".txt";
                try {
                    BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo));
                    textArea.write(escritor);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        } else if (e.getActionCommand().equalsIgnoreCase("Salir")) {
            System.exit(0);

        } else if (e.getActionCommand().equalsIgnoreCase("Ayuda")) {
            mostrarAyuda();
        }
    }
}
