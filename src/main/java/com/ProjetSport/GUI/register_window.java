package com.ProjetSport.GUI;
import com.ProjetSport.Controller.ActivityController;
import com.ProjetSport.Controller.UserController;
import com.ProjetSport.Controller.UserControllerImpl;
import com.ProjetSport.Connection;
import com.ProjetSport.model.User;
import com.ProjetSport.repository.UserRepositoryImpl;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Slf4j
public class register_window extends JFrame{
    public register_window(ActivityController activityController, UserController userController) {
        setLayout(new BorderLayout());
        JFrame list_activities_frame = new list_activities(activityController);
        list_activities_frame.setSize(600,600);
        list_activities_frame.setLocationRelativeTo(null);
        list_activities_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame frame2 = new JFrame("Inscription");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(600, 400);
        frame2.setLocationRelativeTo(null);
        JButton btn_register = new JButton("Inscription");
        JButton btn_alreadyLogin = new JButton("Deja Inscrit");


        //DEFINITION DE L AFFICHAGE


        GridLayout gridLabel = new GridLayout(5, 1);
        GridLayout gridText = new GridLayout(5, 1);

        JPanel panelLabel = new JPanel(gridLabel);
        JPanel panelText = new JPanel(gridText);
        JPanel panelBouton = new JPanel();
        frame2.getContentPane().add(btn_register);

        JLabel nom = new JLabel("Nom : ");
        JTextField textNom = new JTextField();
        JLabel prenom = new JLabel("Prénom : ");
        JTextField textPrenom = new JTextField();
        JLabel dateNais = new JLabel("Date de naissance : ");
        JTextField textDateNais = new JTextField();
        JLabel sexe = new JLabel("Sexe : ");
        JTextField textSexe = new JTextField();

        panelLabel.add(nom);
        panelLabel.add(prenom);
        panelLabel.add(dateNais);
        panelLabel.add(sexe);

        panelText.add(textNom);
        panelText.add(textPrenom);
        panelText.add(textDateNais);
        panelText.add(textSexe);

        panelBouton.add(btn_register);
        panelBouton.add(btn_alreadyLogin);
        JPanel fieldPanel = new JPanel(new GridLayout(0,2));
        fieldPanel.add(panelLabel);
        fieldPanel.add(panelText);
        frame2.setLayout(new GridLayout(0, 1));
        frame2.add(fieldPanel);
        frame2.add(panelBouton, BorderLayout.CENTER);
        fieldPanel.setBackground(Color.PINK);
        panelBouton.setBackground(Color.PINK);
        frame2.setVisible(true);

        // FONCTION ET ACTION
        btn_register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomValue = textNom.getText();
                String prenomValue = textPrenom.getText();
                String dateNaisValue = textDateNais.getText();
                String sexeValue = textSexe.getText();

                if (!nomValue.isEmpty() && !prenomValue.isEmpty() && !dateNaisValue.isEmpty() && !sexeValue.isEmpty()) {
                    User user = new User(nomValue, prenomValue, dateNaisValue, sexeValue);
                    //Instanciation du controller
                    //Save Activity
                    userController.saveUser(user);
                    //Clear tout les champs
                    textNom.setText("");
                    textPrenom.setText("");
                    textSexe.setText("");
                    textDateNais.setText("");
                    //Met la pop-up quand c'ets validé
                    JOptionPane.showMessageDialog(null, "Inscription réussie !", "Succès", JOptionPane.INFORMATION_MESSAGE);
                    frame2.setVisible(false);
                    list_activities_frame.setVisible(true);
                }
                // Effectuez les opérations de traitement nécessaires avec les valeurs récupérées


            }

        });

        btn_alreadyLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame2.setVisible(false);
                list_activities_frame.setVisible(true);
            }
        });

    }
}
