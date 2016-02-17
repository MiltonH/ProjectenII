package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

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
        naam.add(name, 1, 1);
        naam.add(invulName, 1, 2);

        //nummer
        GridPane nummer = new GridPane();
        nummer.setMinSize(200, 40);
        Label number = new Label("Inschrijvingsnummer: ");
        TextField invulNumber = new TextField();
        nummer.add(number, 1,1);
        nummer.add(invulNumber, 1,2);

        //knoppen
        HBox knoppen = new HBox();
        Button zoek = new Button("zoek");
        Button nieuw = new Button("nieuw");
        Button kies = new Button("kies");
        knoppen.setHgrow(zoek, Priority.ALWAYS);
        knoppen.setHgrow(nieuw, Priority.ALWAYS);
        knoppen.setAlignment(Pos.CENTER);
        zoek.setMaxWidth(100);
        nieuw.setMaxWidth(100);
        kies.setMaxWidth(100);
        knoppen.setSpacing(50);
        knoppen.setPadding(new Insets(0, 20, 10, 20));
        knoppen.getChildren().addAll(zoek, nieuw);
        
        //ListView
        ObservableList<String> namen = FXCollections.observableArrayList();;  
        namen.addAll("Dries", "Milton", "Robin", "Cedric"); 
        ListView<String> zoekView = new ListView<String>(namen); 
        zoekView.setPrefWidth(100);
        zoekView.setPrefHeight(200);
    
        zoek.setOnAction(new EventHandler<ActionEvent>() {  
            @Override  
            public void handle(ActionEvent arg0) {  
                knoppen.getChildren().removeAll(zoek, nieuw);
                knoppen.getChildren().addAll(zoekView, kies);
                setMaxSize(400, 300);
            }  
        });  
        
        //boxen
        naamNummer.getChildren().addAll(naam, nummer);
        informatie.getChildren().addAll(naamNummer, afbeelding);
        informatie.setSpacing(10);
        informatie.setPadding(new Insets(0, 20, 10, 20));
        getChildren().addAll(informatie, knoppen);
    }
}
