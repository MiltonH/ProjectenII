package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InlogPaneel extends VBox {

    public InlogPaneel() {
        setMaxSize(800, 400);
        Label toegevoegd = new Label("Persoon is toegevoegd");
        toegevoegd.setId("speciaalLabel");
        
        //informatie
        HBox informatie = new HBox();
        informatie.setMinHeight(150);
        VBox naamNummer = new VBox();
        naamNummer.setMinHeight(150);
        naamNummer.setSpacing(20);

        //afbeelding
        ImageView afbeelding = new ImageView(new Image("Images/unknown-user.png", 100, 100, true, true));

        //naam
        GridPane naam = new GridPane();
        naam.setMinSize(400, 40);
        Label name = new Label("Naam: ");
        TextField invulName = new TextField();
        invulName.setPromptText("Voeg de naam in");
        naam.add(name, 1, 1);
        naam.add(invulName, 1, 2);

        //nummer
        GridPane nummer = new GridPane();
        nummer.setMinSize(400, 40);
        Label number = new Label("Inschrijvingsnummer: ");
        TextField invulNumber = new TextField();
        invulNumber.setPromptText("Voeg het nummer in");
        nummer.add(number, 1, 1);
        nummer.add(invulNumber, 1, 2);

        //naamFormulier
        GridPane naamFormulier = new GridPane();
        naamFormulier.setMinSize(400, 40);
        Label nameFormulier = new Label("Naam: ");
        TextField invulNameFormulier = new TextField();
        invulNameFormulier.setPromptText("Voeg de naam in");
        naamFormulier.add(nameFormulier, 1, 1);
        naamFormulier.add(invulNameFormulier, 1, 2);

        //nummerFormulier
        GridPane nummerFormulier = new GridPane();
        nummerFormulier.setMinSize(400, 40);
        Label numberFormulier = new Label("Inschrijvingsnummer: ");
        TextField invulNumberFormulier = new TextField();
        invulNumberFormulier.setPromptText("Voeg het nummer in");
        nummerFormulier.add(numberFormulier, 1, 1);
        nummerFormulier.add(invulNumberFormulier, 1, 2);

        //geboortedatum
        GridPane geboortedatum = new GridPane();
        geboortedatum.setMinSize(400, 40);
        Label geboortedate = new Label("Geboortedatum: ");
        invulNumber.setPromptText("Voeg het nummer in");
        TextField invulGeboortedate = new TextField();
        invulGeboortedate.setPromptText("Voeg de geboortedatum in");
        geboortedatum.add(geboortedate, 1, 1);
        geboortedatum.add(invulGeboortedate, 1, 2);

        //woonplaats
        GridPane woonplaats = new GridPane();
        woonplaats.setMinSize(400, 40);
        Label woonplaatsje = new Label("Woonplaats: ");
        TextField invulWoonplaatsje = new TextField();
        invulWoonplaatsje.setPromptText("Voeg de woonplaats in");
        woonplaats.add(woonplaatsje, 1, 1);
        woonplaats.add(invulWoonplaatsje, 1, 2);

        //straat
        GridPane straat = new GridPane();
        straat.setMinSize(400, 40);
        Label street = new Label("Straat: ");
        TextField invulStreet = new TextField();
        invulStreet.setPromptText("Voeg de straat in");
        straat.add(street, 1, 1);
        straat.add(invulStreet, 1, 2);

        //huisnummer
        GridPane huisnummer = new GridPane();
        huisnummer.setMinSize(400, 40);
        Label huisnummertje = new Label("Huisnummer: ");
        TextField invulHuisnummertje = new TextField();
        invulHuisnummertje.setPromptText("Voeg het huisnummer in");
        huisnummer.add(huisnummertje, 1, 1);
        huisnummer.add(invulHuisnummertje, 1, 2);

        //geslacht
        GridPane geslacht = new GridPane();
        geslacht.setMinSize(400, 40);
        Label geslachtje = new Label("Geslacht: ");
        TextField invulGeslachtje = new TextField();
        invulGeslachtje.setPromptText("Voeg het geslacht in");
        geslacht.add(geslachtje, 1, 1);
        geslacht.add(invulGeslachtje, 1, 2);

        //knoppen
        HBox knoppen = new HBox();
        Button zoek = new Button("Zoek");
        Button nieuw = new Button("Nieuw");
        Button kies = new Button("Kies");
        Button voegToe = new Button("Voeg toe");
        Button voegAfbeeldingToe = new Button("Voeg afbeelding in");
        Button terugNieuw = new Button("Terug");
        Button terugZoek = new Button("Terug");
        Button open = new Button("Open");
        knoppen.setAlignment(Pos.CENTER);
        knoppen.setSpacing(50);
        knoppen.setPadding(new Insets(0, 20, 10, 20));
        knoppen.setMinHeight(200);
        knoppen.getChildren().addAll(zoek, nieuw, open);

        //vboxVoorNieuw(knoppen)
        HBox knoppenInVoegToe = new HBox();
        knoppenInVoegToe.setSpacing(10);
        knoppenInVoegToe.getChildren().addAll(voegToe, terugNieuw);

        //testbox afbeelding
        GridPane afbeeldingske = new GridPane();
        afbeeldingske.setMinWidth(400);
        afbeeldingske.setAlignment(Pos.CENTER);
        afbeeldingske.setVgap(10);
        afbeeldingske.add(afbeelding, 1, 1);

        //ListView zoekknop
        ObservableList<String> namen = FXCollections.observableArrayList();;
        namen.addAll("Dries", "Milton", "Robin", "Cedric");
        ListView<String> zoekView = new ListView<String>(namen);
        zoekView.setPrefWidth(100);
        zoekView.setPrefHeight(200);

        kies.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                invulName.setText(zoekView.getSelectionModel().getSelectedItem());
            }
        });
        
        zoek.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                knoppen.getChildren().removeAll(zoek, nieuw, open);
                knoppen.getChildren().addAll(zoekView, kies, terugZoek);
                setPrefSize(800, 400);
            }
        });

        //voegToeknop 
        voegToe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                namen.add(invulNameFormulier.getText());
                invulName.setText(invulNameFormulier.getText());
                afbeeldingske.add(toegevoegd, 1, 3);
                afbeeldingske.setHalignment(toegevoegd, HPos.CENTER);
            }
        });
        
        //Formulier nieuwknop
        nieuw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                knoppen.getChildren().removeAll(zoek, nieuw, open);
                afbeeldingske.add(voegAfbeeldingToe, 1, 2);
                afbeeldingske.setHalignment(afbeelding, HPos.CENTER);
                naamNummer.getChildren().removeAll(naam, nummer);
                naamNummer.getChildren().addAll(naamFormulier, nummerFormulier, geboortedatum, woonplaats, straat, huisnummer, geslacht, knoppenInVoegToe);
                naamNummer.setMinHeight(550);
                informatie.setMinHeight(550);
                setMinHeight(600);
            }
        });

        //TerugKnop
        terugNieuw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                afbeeldingske.getChildren().removeAll(voegAfbeeldingToe, toegevoegd);
                naamNummer.getChildren().removeAll(naamFormulier, nummerFormulier, geboortedatum, woonplaats, straat, huisnummer, geslacht, knoppenInVoegToe);
                naamNummer.getChildren().addAll(naam, nummer);
                knoppen.getChildren().addAll(zoek, nieuw, open);
                afbeeldingske.setMinWidth(325);
                informatie.setMinHeight(150);
                naamNummer.setMinHeight(150);
                setMinSize(800, 400);
            }
        });

        terugZoek.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                knoppen.getChildren().removeAll(zoekView, kies, terugZoek);
                knoppen.getChildren().addAll(zoek, nieuw, open);
                informatie.setMinHeight(150);
                naamNummer.setMinHeight(150);
                setMaxSize(800, 400);
            }
        });

        //boxen
        naamNummer.getChildren().addAll(naam, nummer);
        informatie.getChildren().addAll(naamNummer, afbeeldingske);
        informatie.setSpacing(10);
        informatie.setPadding(new Insets(0, 20, 10, 20));
        getChildren().addAll(informatie, knoppen);
    }
}
