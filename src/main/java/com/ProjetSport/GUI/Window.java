package com.ProjetSport.GUI;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window() {
        super("Une fenêtre");
        /* OU :
        setLocation(); setSize()
         */

        /* Annule les fonction supérieure pour compacter la fenêtre
        pack();
         */

        GridLayout gridLabel = new GridLayout(5, 1);
        GridLayout gridText = new GridLayout(5, 1);

        Toolkit tk = Toolkit.getDefaultToolkit();
        /* Méthodes utiles : getScreenSize, getScreenResolution,
        getDefaultToolkit, beep, getImage,
        createImage, getSystemEventQueue
        */
        Dimension dimension = tk.getScreenSize();
        // tk.beep();

        setBounds(0, 0, 600, 400);

        // Centre une fenetre
        setLocationRelativeTo(null);

        //On créé le container (ou JPannel)
        Container cp = this.getContentPane();

        JPanel panelLabel = new JPanel(gridLabel);
        JPanel panelText = new JPanel(gridText);
        JPanel panelBouton = new JPanel();

        // panelLabel.setSize(new Dimension(350,350));

        //On créé les composants légers
        JLabel nom = new JLabel("Nom : ");
        JTextField textNom = new JTextField();
        JLabel duration = new JLabel("Durée : ");
        JTextField textDuration = new JTextField();
        JLabel rpe = new JLabel("RPE : ");
        JTextField textRpe = new JTextField();
        JLabel load = new JLabel("Charge : ");
        JTextField textLoad = new JTextField();
        JLabel date = new JLabel("Date : ");
        JTextField textDate = new JTextField();

        JButton b1 = new JButton("Enregistrer");

        // textField1.setSize(new Dimension(50,150));

        //On ajoute les composants légers au container
        panelLabel.add(nom);
        panelLabel.add(duration);
        panelLabel.add(rpe);
        panelLabel.add(load);
        panelLabel.add(date);

        panelText.add(textNom);
        panelText.add(textDuration);
        panelText.add(textRpe);
        panelText.add(textLoad);
        panelText.add(textDate);

        panelBouton.add(b1, BorderLayout.CENTER);

        cp.add(panelLabel, BorderLayout.WEST);
        cp.add(panelText);
        cp.add(panelBouton, BorderLayout.SOUTH);

        setVisible(true);
    }
}