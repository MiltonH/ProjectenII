/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import domain.Leerling;
import domain.LeerlingRepo;
import javafx.geometry.HPos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Screen;

/**
 *
 * @author Dries Meert
 */
public class VoegLeerlingToePaneel extends GridPane
{

    private Scene scene;

    public VoegLeerlingToePaneel(InlogPaneel inlogPanel, LeerlingRepo repo) {
        setId("inlogPaneelBG");
        //schermformaat
        Rectangle2D schermformaat = Screen.getPrimary().getVisualBounds();

        //aanmaak grid
        gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0 = new ColumnConstraints();
        kolom0.setPercentWidth(20);
        ColumnConstraints kolom1 = new ColumnConstraints();
        kolom1.setPercentWidth(60);
        ColumnConstraints kolom2 = new ColumnConstraints();
        kolom2.setPercentWidth(20);

        getColumnConstraints().addAll(kolom0, kolom1, kolom2);

        RowConstraints rij0 = new RowConstraints();
        rij0.setPercentHeight(25);
        RowConstraints rij1 = new RowConstraints();
        rij1.setPercentHeight(50);
        RowConstraints rij2 = new RowConstraints();
        rij2.setPercentHeight(25);

        getRowConstraints().addAll(rij0, rij1, rij2);

        //aanmaak naamNummerPane
        GridPane naamNummerPane = new GridPane();
        naamNummerPane.setId("inlogPaneel");
        naamNummerPane.gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0NaamNummerPane = new ColumnConstraints();
        kolom0NaamNummerPane.setPercentWidth(30);
        kolom0NaamNummerPane.setHalignment(HPos.LEFT);
        ColumnConstraints kolom1NaamNummerPane = new ColumnConstraints();
        kolom1NaamNummerPane.setPercentWidth(70);
        kolom1NaamNummerPane.setHalignment(HPos.CENTER);
        naamNummerPane.getColumnConstraints().addAll(kolom0NaamNummerPane, kolom1NaamNummerPane);

        RowConstraints rij0NaamNummerPane = new RowConstraints();
        rij0NaamNummerPane.setPercentHeight(25);
        RowConstraints rij1NaamNummerPane = new RowConstraints();
        rij1NaamNummerPane.setPercentHeight(25);
        RowConstraints rij2NaamNummerPane = new RowConstraints();
        rij2NaamNummerPane.setPercentHeight(25);
        RowConstraints rij3NaamNummerPane = new RowConstraints();
        rij3NaamNummerPane.setPercentHeight(25);
        naamNummerPane.getRowConstraints().addAll(rij0NaamNummerPane, rij1NaamNummerPane, rij2NaamNummerPane, rij3NaamNummerPane);

        add(naamNummerPane, 1, 1);

        //aanmaak naamLabel
        Label naamLabel = new Label("Naam: ");
        naamLabel.setId("inlognaamNummerLabel");
        naamNummerPane.add(naamLabel, 0, 0);

        //aanmaak VoornaamLabel
        Label voorNaamLabel = new Label("Voornaam: ");
        voorNaamLabel.setId("inlognaamNummerLabel");
        naamNummerPane.add(voorNaamLabel, 0, 1);

        //aanmaak nummerLabel
        Label nummerLabel = new Label("Nummer: ");
        nummerLabel.setId("inlognaamNummerLabel");
        naamNummerPane.add(nummerLabel, 0, 2);

        //aanmaak tekstfieldNaam
        TextField naamTextField = new TextField();
        naamTextField.setId("inlogTexfield");
        naamTextField.setPromptText("Voeg de naam in");
        naamNummerPane.add(naamTextField, 1, 0);

        //aanmaak tekstfieldNaam
        TextField voorNaamTextField = new TextField();
        voorNaamTextField.setId("inlogTexfield");
        voorNaamTextField.setPromptText("Voeg de voornaam in");
        naamNummerPane.add(voorNaamTextField, 1, 1);

        //aanmaak tekstfieldNummer
        TextField nummerTextField = new TextField();
        nummerTextField.setId("inlogTexfield");
        nummerTextField.setPromptText("Voeg het nummer in");
        naamNummerPane.add(nummerTextField, 1, 2);

        //GridBox knoppen
        GridPane gridKnopPane = new GridPane();
        gridKnopPane.gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0GridKnopPane = new ColumnConstraints();
        kolom0GridKnopPane.setPercentWidth(100);
        kolom0GridKnopPane.setHalignment(HPos.CENTER);
        ColumnConstraints kolom1GridKnopPane = new ColumnConstraints();
        kolom1GridKnopPane.setPercentWidth(100);
        kolom1GridKnopPane.setHalignment(HPos.CENTER);

        gridKnopPane.getColumnConstraints().addAll(kolom0GridKnopPane, kolom1GridKnopPane);

        RowConstraints rij0GridKnopPane = new RowConstraints();
        rij0GridKnopPane.setPercentHeight(100);

        gridKnopPane.getRowConstraints().addAll(rij0GridKnopPane);

        naamNummerPane.add(gridKnopPane, 1, 3);

        //knoppen
        Button voegToeKnop = new Button("Voeg toe");
        voegToeKnop.setOnAction(event -> {
            boolean naamIngevuld = false;
            boolean voornaamIngevuld = false;
            boolean inschrijfnrIngevuld = false;
            boolean nummerIsUniek = true;
            if (naamTextField.getText().isEmpty()) {
                naamLabel.setId("inlognaamNummerLabelRed");
                naamTextField.setId("inlogGeenNaamIngevult");
                naamTextField.setPromptText("Naam moet ingevuld zijn!");
            } else {
                naamLabel.setId("inlognaamNummerLabel");
                naamIngevuld = true;
            }
            if (voorNaamTextField.getText().isEmpty()) {
                voorNaamLabel.setId("inlognaamNummerLabelRed");
                voorNaamTextField.setId("inlogGeenNaamIngevult");
                voorNaamTextField.setPromptText("Voornaam moet ingevuld zijn!");
            } else {
                voorNaamLabel.setId("inlognaamNummerLabel");
                voornaamIngevuld = true;
            }

            for (Leerling l : repo.getLeerlingList()) {
                if (l.getInschrijvingsNummer().equals(nummerTextField.getText())) {
                    nummerIsUniek = false;
                }
            }

            if (nummerTextField.getText().isEmpty()) {
                nummerLabel.setId("inlognaamNummerLabelRed");
                nummerTextField.setId("inlogGeenNaamIngevult");
                nummerTextField.setPromptText("InschrijvingsNummer moet ingevuld zijn!");
            } else if (!nummerIsUniek) {
                nummerLabel.setId("inlognaamNummerLabelRed");
                nummerTextField.setId("inlogGeenNaamIngevult");
                nummerTextField.clear();
                nummerTextField.setPromptText("Er bestaat al een leerling met dit inschrijvingsNummer!");
                nummerIsUniek = true;
            } else {
                nummerLabel.setId("inlognaamNummerLabel");
                inschrijfnrIngevuld = true;
            }

            if (naamIngevuld && voornaamIngevuld && inschrijfnrIngevuld) {
                Leerling leerling = new Leerling(naamTextField.getText(), voorNaamTextField.getText(), nummerTextField.getText());
                repo.getLeerlingList().add(leerling);
                inlogPanel.refreshList();
                scene.setRoot(inlogPanel);
            }
        });
        voegToeKnop.setId("inlogButtons");

        Button terugKnop = new Button("Terug");
        terugKnop.setOnAction(event -> {
            scene.setRoot(inlogPanel);
        });
        terugKnop.setId("inlogButtons");

        gridKnopPane.add(voegToeKnop, 0, 0);
        gridKnopPane.add(terugKnop, 1, 0);
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
