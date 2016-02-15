package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

        //afbeelding
//        ImageView afbeelding = new ImageView(new Image(getClass().getResourceAsStream("images/TestAfbeelding.jpg")));
        ImageView afbeelding = new ImageView();

        //naam
        HBox naam = new HBox();
        naam.setMinSize(200, 40);
        Label name = new Label("Naam: ");
        TextField invulName = new TextField();
        naam.getChildren().addAll(name, invulName);

        //nummer
        HBox nummer = new HBox();
        nummer.setMinSize(200, 40);
        Label number = new Label("Inschrijvingsnummer: ");
        TextField invulNumber = new TextField();
        nummer.getChildren().addAll(number, invulNumber);

        //knoppen
        HBox knoppen = new HBox();
        Button zoek = new Button("zoek");
        Button nieuw = new Button("nieuw");
        knoppen.setHgrow(zoek, Priority.ALWAYS);
        knoppen.setHgrow(nieuw, Priority.ALWAYS);
        knoppen.setAlignment(Pos.CENTER);
        zoek.setMaxWidth(100);
        nieuw.setMaxWidth(100);
        knoppen.setSpacing(50);
        knoppen.setPadding(new Insets(0, 20, 10, 20));
        knoppen.getChildren().addAll(zoek, nieuw);

        //boxen
        naamNummer.getChildren().addAll(naam, nummer);
        informatie.getChildren().addAll(naamNummer, afbeelding);
        informatie.setSpacing(10);
        informatie.setPadding(new Insets(0, 20, 10, 20));
        getChildren().addAll(informatie, knoppen);
    }

}
