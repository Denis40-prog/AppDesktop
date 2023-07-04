package com.ProjetSport.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

import com.ProjetSport.Controller.ActivityControllerImpl;
import com.ProjetSport.model.Activity;
import com.ProjetSport.Connection;
import com.ProjetSport.repository.ActivityRepository;
import com.ProjetSport.repository.ActivityRepositoryImpl;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;

@Slf4j
public class Window extends JFrame {

    ActivityControllerImpl activityController;

    public Window(Connection connexion) {
        super("Une fenêtre");


        setLayout(new BorderLayout());
        URL url = getClass().getResource("/doge.jpg");
        JLabel background=new JLabel(new ImageIcon(url));
        add(background);
        background.setLayout(new BorderLayout());
        background.setBackground(Color.BLACK);



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
        //Container cp = this.getContentPane();

        JPanel panelLabel = new JPanel(gridLabel);
        JPanel panelText = new JPanel(gridText);
        JPanel panelBouton = new JPanel();

        /*
        cp.add(backgroundLabel, BorderLayout.CENTER);
        cp.add(panelLabel, BorderLayout.WEST);
        cp.add(panelText);
        cp.add(panelBouton, BorderLayout.SOUTH);
        */
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
        JButton exit = new JButton("Fermer");

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fermer la fenêtre
            }
        });

        panelBouton.add(exit, BorderLayout.CENTER);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomValue = textNom.getText();
                String durationValue = textDuration.getText();
                String rpeValue = textRpe.getText();
                String loadValue = textLoad.getText();
                String dateValue = textDate.getText();

                // Effectuez les opérations de traitement nécessaires avec les valeurs récupérées

                if (!nomValue.isEmpty() && !durationValue.isEmpty() && !rpeValue.isEmpty() && !loadValue.isEmpty()) {
                    Activity activity = new Activity(nomValue,Integer.parseInt(durationValue), rpeValue, loadValue, new Date(dateValue));
                    //Connexion
                    connexion.connect();
                    //Instanciation du controller
                    ActivityRepositoryImpl activityRepo = new ActivityRepositoryImpl(connexion.getMongoClient());
                    activityController = new ActivityControllerImpl(activityRepo);
                    //Save Activity
                    activityController.saveActivity(activity);
                    //Clear tout les champs
                    textNom.setText("");
                    textDuration.setText("");
                    textRpe.setText("");
                    textLoad.setText("");
                    textDate.setText("");
                    //Met la pop-up quand c'ets validé
                    JOptionPane.showMessageDialog(null, "Inscription réussie !", "Succès", JOptionPane.INFORMATION_MESSAGE);
                    connexion.close();
                }
            }
        });
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

        background.add(panelLabel, BorderLayout.WEST);
        background.add(panelText);
        background.add(panelBouton, BorderLayout.SOUTH);
        setSize(400, 400);

        setVisible(true);
    }
}