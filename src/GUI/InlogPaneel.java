package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
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
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class InlogPaneel extends VBox {

    public InlogPaneel() {
        setMaxSize(400, 100);
        setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: blue;"
                + "-fx-background-color: FFFFFF;");
        //informatie
        HBox informatie = new HBox();
        VBox naamNummer = new VBox();
        naamNummer.setSpacing(10);

        //afbeelding
        ImageView afbeelding = new ImageView(new Image("Images/unknown-user.png", 100, 100, true, true));

        //naam
        GridPane naam = new GridPane();
        naam.setMinSize(200, 40);
        Label name = new Label("Naam: ");
        TextField invulName = new TextField();
        invulName.setPromptText("Voeg de naam in");
        naam.add(name, 1, 1);
        naam.add(invulName, 1, 2);

        //nummer
        GridPane nummer = new GridPane();
        nummer.setMinSize(200, 40);
        Label number = new Label("Inschrijvingsnummer: ");
        TextField invulNumber = new TextField();
        invulNumber.setPromptText("Voeg het nummer in");
        nummer.add(number, 1, 1);
        nummer.add(invulNumber, 1, 2);

        //naamFormulier
        GridPane naamFormulier = new GridPane();
        naamFormulier.setMinSize(200, 40);
        Label nameFormulier = new Label("Naam: ");
        TextField invulNameFormulier = new TextField();
        invulNameFormulier.setPromptText("Voeg de naam in");
        naamFormulier.add(nameFormulier, 1, 1);
        naamFormulier.add(invulNameFormulier, 1, 2);

        //nummerFormulier
        GridPane nummerFormulier = new GridPane();
        nummerFormulier.setMinSize(200, 40);
        Label numberFormulier = new Label("Inschrijvingsnummer: ");
        TextField invulNumberFormulier = new TextField();
        invulNumberFormulier.setPromptText("Voeg het nummer in");
        nummerFormulier.add(numberFormulier, 1, 1);
        nummerFormulier.add(invulNumberFormulier, 1, 2);

        //geboortedatum
        GridPane geboortedatum = new GridPane();
        geboortedatum.setMinSize(200, 40);
        Label geboortedate = new Label("Geboortedatum: ");
        invulNumber.setPromptText("Voeg het nummer in");
        TextField invulGeboortedate = new TextField();
        invulGeboortedate.setPromptText("Voeg de geboortedatum in");
        geboortedatum.add(geboortedate, 1, 1);
        geboortedatum.add(invulGeboortedate, 1, 2);

        //woonplaats
        GridPane woonplaats = new GridPane();
        woonplaats.setMinSize(200, 40);
        Label woonplaatsje = new Label("Woonplaats: ");
        TextField invulWoonplaatsje = new TextField();
        invulWoonplaatsje.setPromptText("Voeg de woonplaats in");
        woonplaats.add(woonplaatsje, 1, 1);
        woonplaats.add(invulWoonplaatsje, 1, 2);

        //straat
        GridPane straat = new GridPane();
        straat.setMinSize(200, 40);
        Label street = new Label("Straat: ");
        TextField invulStreet = new TextField();
        invulStreet.setPromptText("Voeg de straat in");
        straat.add(street, 1, 1);
        straat.add(invulStreet, 1, 2);

        //huisnummer
        GridPane huisnummer = new GridPane();
        huisnummer.setMinSize(200, 40);
        Label huisnummertje = new Label("Huisnummer: ");
        TextField invulHuisnummertje = new TextField();
        invulHuisnummertje.setPromptText("Voeg het huisnummer in");
        huisnummer.add(huisnummertje, 1, 1);
        huisnummer.add(invulHuisnummertje, 1, 2);

        //geslacht
        GridPane geslacht = new GridPane();
        geslacht.setMinSize(200, 40);
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
        knoppen.setHgrow(zoek, Priority.ALWAYS);
        knoppen.setHgrow(nieuw, Priority.ALWAYS);
        knoppen.setAlignment(Pos.CENTER);
        knoppen.setSpacing(50);
        knoppen.setPadding(new Insets(0, 20, 10, 20));
        knoppen.getChildren().addAll(zoek, nieuw, open);

        //vboxVoorNieuw(knoppen)
        HBox knoppenInVoegToe = new HBox();
        knoppenInVoegToe.setSpacing(10);
        knoppenInVoegToe.getChildren().addAll(voegToe, terugNieuw);

        //testbox afbeelding
        GridPane afbeeldingske = new GridPane();
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
                setMaxSize(400, 300);
            }
        });

        //Formulier nieuwknop
        nieuw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                knoppen.getChildren().removeAll(zoek, nieuw, open);
                afbeeldingske.add(voegAfbeeldingToe, 1, 2);
                naamNummer.getChildren().removeAll(naam, nummer);
                naamNummer.getChildren().addAll(naamFormulier, nummerFormulier, geboortedatum, woonplaats, straat, huisnummer, geslacht, knoppenInVoegToe);
                setMaxSize(400, 300);
            }
        });

        //TerugKnop
        terugNieuw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                afbeeldingske.getChildren().remove(voegAfbeeldingToe);
                naamNummer.getChildren().removeAll(naamFormulier, nummerFormulier, geboortedatum, woonplaats, straat, huisnummer, geslacht, knoppenInVoegToe);
                naamNummer.getChildren().addAll(naam, nummer);
                knoppen.getChildren().addAll(zoek, nieuw, open);
                setMaxSize(400, 100);
            }
        });

        terugZoek.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                knoppen.getChildren().removeAll(zoekView, kies, terugZoek);
                knoppen.getChildren().addAll(zoek, nieuw, open);
                setMaxSize(400, 100);
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
