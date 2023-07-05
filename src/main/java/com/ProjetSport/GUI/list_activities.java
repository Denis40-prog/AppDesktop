package com.ProjetSport.GUI;

import com.ProjetSport.Connection;
import com.ProjetSport.Controller.ActivityController;
import com.ProjetSport.Controller.ActivityControllerImpl;
import com.ProjetSport.Main;
import com.ProjetSport.model.Activity;
import com.ProjetSport.repository.ActivityRepository;
import com.ProjetSport.repository.ActivityRepositoryImpl;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import static java.lang.Integer.parseInt;

@Slf4j
public class list_activities extends JFrame {
    List<Activity> allActivities;

    public list_activities(ActivityController activityController){
        super("Liste d'activitées");

        setLayout(new BorderLayout());
        GridLayout gridButton = new GridLayout(2, 0);

        JPanel panelList = new JPanel(gridButton);
        JPanel top = new JPanel();

        //Bouttons
        JButton addButton = new JButton("Ajouter");
        JButton refresh = new JButton("Rafraichir");

        //Titre de la frame
        JLabel title = new JLabel("Liste d'activitées");

        //Récuperation des données a afficher

        allActivities = activityController.findAll();
        Object[][] data = new Object[allActivities.size()][5];

        data[0][0] = "NOM";
        data[0][1] = "Durée";
        data[0][2] = "Date";
        data[0][3] = "RPE";
        data[0][4] = "Charge";

        for (int i = 1; i < allActivities.size(); i++) {
            Activity activity = allActivities.get(i);
            data[i][0] = activity.getName();
            data[i ][1] = activity.getDuration();
            data[i][2] = activity.getDate();
            data[i][3] = activity.getRpe();
            data[i][4] = activity.getLoad();
        }


        //Partie dialog

        JDialog dialog = new JDialog();
        dialog.setSize(600, 400);

        GridLayout gridLabel = new GridLayout(5, 1);
        GridLayout gridText = new GridLayout(5, 1);
        GridLayout gridDialog = new GridLayout(3,0);

        JPanel panelLabel = new JPanel(gridLabel);
        JPanel panelText = new JPanel(gridText);
        JPanel panelBouton = new JPanel();

        JLabel nom = new JLabel("Nom : ");
        JTextField textNom = new JTextField();
        JLabel duration = new JLabel("Durée : ");
        JTextField textDuration = new JTextField();
        JLabel rpe = new JLabel("RPE : ");
        JTextField textRpe = new JTextField();
        JLabel date = new JLabel("Date : ");
        JTextField textDate = new JTextField();

        JButton ajouter = new JButton("Enregistrer");
        JButton exit = new JButton("Fermer");

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose(); // Fermer la fenêtre
            }
        });

        ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomValue = textNom.getText();
                Integer durationValue = parseInt(textDuration.getText());
                Integer rpeValue = parseInt(textRpe.getText());
                Integer loadValue = durationValue * rpeValue;
                String dateValue = textDate.getText();

                // Effectuez les opérations de traitement nécessaires avec les valeurs récupérées

                if (!nomValue.isEmpty() && durationValue != null && rpeValue != null) {
                    Activity activity = new Activity(nomValue, durationValue, rpeValue, loadValue, new Date(dateValue));
                    //Save Activity
                    activityController.saveActivity(activity);
                    //Clear tout les champs
                    textNom.setText("");
                    textDuration.setText("");
                    textRpe.setText("");
                    textDate.setText("");
                    //Met la pop-up quand c'ets validé
                    JOptionPane.showMessageDialog(null, "Activité créée !", "Succès", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        panelLabel.add(nom);
        panelLabel.add(duration);
        panelLabel.add(rpe);
        panelLabel.add(date);

        panelText.add(textNom);
        panelText.add(textDuration);
        panelText.add(textRpe);
        panelText.add(textDate);

        panelBouton.add(ajouter, BorderLayout.CENTER);
        panelBouton.add(exit, BorderLayout.CENTER);

        dialog.add(panelLabel, BorderLayout.WEST);
        dialog.add(panelText);
        dialog.add(panelBouton, BorderLayout.SOUTH);
        setSize(600, 400);
        setLocationRelativeTo(null);

        setVisible(false);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dialog.setVisible(true);
            }
        });
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                setVisible(false);
            }
        });



        String[] columnNames = {"Nom", "Durée", "Date", "RPE", "Charge"};

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable tableActivities = new JTable(model){
            @Override
            public Dimension getPreferredScrollableViewportSize() {
                Dimension size = super.getPreferredScrollableViewportSize();
                size.height = 10; // Hauteur de l'en-tête fixe
                return size;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Empêche l'édition des cellules
            }

        };
        top.add(title);
        top.add(addButton);
        panelList.add(top);
        panelList.add(tableActivities);
        add(panelList);
        top.setBackground(Color.PINK);
        pack();
    }
}
