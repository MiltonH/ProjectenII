package GUI;

import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Screen;

public class InlogPaneel extends GridPane {

    Scene scene;

    public InlogPaneel() {
        setId("inlogPaneelBG");
        //schermformaat
        Rectangle2D schermformaat = Screen.getPrimary().getVisualBounds();

        //aanmaak grid
        gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0 = new ColumnConstraints();
        kolom0.setPercentWidth(25);
        ColumnConstraints kolom1 = new ColumnConstraints();
        kolom1.setPercentWidth(50);
        ColumnConstraints kolom2 = new ColumnConstraints();
        kolom2.setPercentWidth(25);

        getColumnConstraints().addAll(kolom0, kolom1, kolom2);

        RowConstraints rij0 = new RowConstraints();
        rij0.setPercentHeight(25);
        RowConstraints rij1 = new RowConstraints();
        rij1.setPercentHeight(50);
        RowConstraints rij2 = new RowConstraints();
        rij2.setPercentHeight(25);

        getRowConstraints().addAll(rij0, rij1, rij2);

        //aanmaak InlogSchermPane 
        GridPane InlogSchermPane = new GridPane();
        InlogSchermPane.setId("inlogPaneel");
        InlogSchermPane.gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0InlogSchermPane = new ColumnConstraints();
        kolom0InlogSchermPane.setPercentWidth(50);
        kolom0InlogSchermPane.setHalignment(HPos.CENTER);
        ColumnConstraints kolom1InlogSchermPane = new ColumnConstraints();
        kolom1InlogSchermPane.setPercentWidth(50);
        kolom1InlogSchermPane.setHalignment(HPos.CENTER);
        InlogSchermPane.getColumnConstraints().addAll(kolom0InlogSchermPane, kolom1InlogSchermPane);

        RowConstraints rij0InlogSchermPane = new RowConstraints();
        rij0InlogSchermPane.setPercentHeight(50);
        RowConstraints rij1InlogSchermPane = new RowConstraints();
        rij1InlogSchermPane.setPercentHeight(50);
        InlogSchermPane.getRowConstraints().addAll(rij0InlogSchermPane, rij1InlogSchermPane);

        add(InlogSchermPane, 1, 1);

        //aanmaak naamNummerPane
        GridPane naamNummerPane = new GridPane();
        naamNummerPane.gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0NaamNummerPane = new ColumnConstraints();
        kolom0NaamNummerPane.setPercentWidth(50);
        kolom0NaamNummerPane.setHalignment(HPos.RIGHT);
        ColumnConstraints kolom1NaamNummerPane = new ColumnConstraints();
        kolom1NaamNummerPane.setPercentWidth(50);
        kolom1NaamNummerPane.setHalignment(HPos.RIGHT);
        naamNummerPane.getColumnConstraints().addAll(kolom0NaamNummerPane, kolom1NaamNummerPane);

        RowConstraints rij0NaamNummerPane = new RowConstraints();
        rij0NaamNummerPane.setPercentHeight(50);
        RowConstraints rij1NaamNummerPane = new RowConstraints();
        rij1NaamNummerPane.setPercentHeight(50);
        naamNummerPane.getRowConstraints().addAll(rij0NaamNummerPane, rij1NaamNummerPane);

        InlogSchermPane.add(naamNummerPane, 0, 0);

        //aanmaak listViewGrid
        GridPane listViewGrid = new GridPane();
        listViewGrid.gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0ListViewGrid = new ColumnConstraints();
        kolom0ListViewGrid.setPercentWidth(50);
        ColumnConstraints kolom1ListViewGrid = new ColumnConstraints();
        kolom1ListViewGrid.setPercentWidth(50);
        kolom1ListViewGrid.setHalignment(HPos.CENTER);
        listViewGrid.getColumnConstraints().addAll(kolom0ListViewGrid, kolom1ListViewGrid);

        InlogSchermPane.add(listViewGrid, 1, 1);

        //aanmaak naamLabel
        Label naamLabel = new Label("Naam: ");
        naamLabel.setId("inlognaamNummerLabel");
        naamNummerPane.add(naamLabel, 0, 0);

        //aanmaak nummerLabel
        Label nummerLabel = new Label("Nummer: ");
        nummerLabel.setId("inlognaamNummerLabel");
        naamNummerPane.add(nummerLabel, 0, 1);

        //aanmaak tekstfieldNaam
        TextField naamTextField = new TextField();
        naamTextField.setId("inlogTexfield");
        naamTextField.setPromptText("Voeg de naam in");
        naamNummerPane.add(naamTextField, 1, 0);

        //aanmaak tekstfieldNummer
        TextField nummerTextField = new TextField();
        nummerTextField.setId("inlogTexfield");
        nummerTextField.setPromptText("Voeg het nummer in");
        naamNummerPane.add(nummerTextField, 1, 1);
        naamTextField.setOnMousePressed(event -> {
            nummerTextField.clear();
        });

        //knop open
        Button openKnop = new Button("Open");
        openKnop.setId("inlogButtons");
        InlogSchermPane.add(openKnop, 1, 1);

        //knop VoegToe
        Button voegToeKnop = new Button("Voeg Toe");
        voegToeKnop.setId("inlogButtons");
        InlogSchermPane.add(voegToeKnop, 0, 1);

        //afbeelding
        ImageView gebruikersImage = new ImageView(new Image("Images/unknown-user.png", Math.ceil(schermformaat.getWidth() * 0.12), USE_PREF_SIZE, true, true));
        InlogSchermPane.add(gebruikersImage, 1, 0);

        //ListView
        ObservableList<String> namen = FXCollections.observableArrayList();;
        namen.addAll("Dries", "Milton", "Robin", "Cedric");
        Collections.sort(namen);
        ListView<String> zoekView = new ListView<String>(namen);
        listViewGrid.add(zoekView, 0, 0);
        listViewGrid.add(openKnop, 1, 0);

        //knoppen
        openKnop.setOnMouseClicked(event -> {
            if(naamTextField.getText().isEmpty()){
                naamTextField.setPromptText("Geen naam ingevult");
                naamTextField.setId("inlogGeenNaamIngevult");
            } else {
            HoofdPaneel hoofdPanel = new HoofdPaneel(zoekView.getSelectionModel().getSelectedItem());
            hoofdPanel.setScene(scene);
            scene.setRoot(hoofdPanel);
            }
        });

        zoekView.setOnMouseClicked(event -> {
            naamTextField.setText(zoekView.getSelectionModel().getSelectedItem());
            nummerTextField.setText(String.valueOf(zoekView.getSelectionModel().getSelectedIndex() + 1));
            nummerTextField.setEditable(false);
        });

        voegToeKnop.setOnMouseClicked(event -> {
            namen.add(naamTextField.getText());
        });
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
