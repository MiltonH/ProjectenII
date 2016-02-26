package GUI;

import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class AttitudePaneel extends GridPane{
    Scene scene;
    
    public AttitudePaneel(HoofdPaneel hoofdPanel){
        setId("inlogPaneelBG");
        //aanmaak grid
        gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0 = new ColumnConstraints();
        kolom0.setPercentWidth(5);
        ColumnConstraints kolom1 = new ColumnConstraints();
        kolom1.setPercentWidth(90);
        ColumnConstraints kolom2 = new ColumnConstraints();
        kolom2.setPercentWidth(5);

        getColumnConstraints().addAll(kolom0, kolom1, kolom2);

        RowConstraints rij0 = new RowConstraints();
        rij0.setPercentHeight(5);
        RowConstraints rij1 = new RowConstraints();
        rij1.setPercentHeight(90);
        RowConstraints rij2 = new RowConstraints();
        rij2.setPercentHeight(5);

        getRowConstraints().addAll(rij0, rij1, rij2);

        //aanmaak AttitudePane 
        GridPane AttitudePane = new GridPane();
        AttitudePane.setId("opmerkingenPaneel");
        AttitudePane.gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0AttitudePane = new ColumnConstraints();
        kolom0AttitudePane.setPercentWidth(35);
        kolom0AttitudePane.setHalignment(HPos.CENTER);
        ColumnConstraints kolom1AttitudePane = new ColumnConstraints();
        kolom1AttitudePane.setPercentWidth(65);
        kolom1AttitudePane.setHalignment(HPos.CENTER);
        AttitudePane.getColumnConstraints().addAll(kolom0AttitudePane, kolom1AttitudePane);

        RowConstraints rij0AttitudePane = new RowConstraints();
        rij0AttitudePane.setPercentHeight(100);
        AttitudePane.getRowConstraints().addAll(rij0AttitudePane);

        add(AttitudePane, 1, 1);
        
        //aanmaak invulSchermen
        GridPane invulSchermenPane = new GridPane();
        invulSchermenPane.gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0invulSchermenPane = new ColumnConstraints();
        kolom0invulSchermenPane.setPercentWidth(100);
        kolom0invulSchermenPane.setHalignment(HPos.CENTER);
        invulSchermenPane.getColumnConstraints().addAll(kolom0invulSchermenPane);

        RowConstraints rij0invulSchermenPane = new RowConstraints();
        rij0invulSchermenPane.setPercentHeight(60);
        RowConstraints rij1invulSchermenPane = new RowConstraints();
        rij1invulSchermenPane.setPercentHeight(20);
        RowConstraints rij2invulSchermenPane = new RowConstraints();
        rij2invulSchermenPane.setPercentHeight(20);
        invulSchermenPane.getRowConstraints().addAll(rij0invulSchermenPane, rij1invulSchermenPane, rij2invulSchermenPane);

        AttitudePane.add(invulSchermenPane, 0, 0);
        
        //aanmaak textAreaPane
        GridPane textAreaPane = new GridPane();
        textAreaPane.gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0listViewPane = new ColumnConstraints();
        kolom0listViewPane.setPercentWidth(100);
        textAreaPane.getColumnConstraints().addAll(kolom0listViewPane);

        RowConstraints rij0listViewPane = new RowConstraints();
        rij0listViewPane.setPercentHeight(20);
        RowConstraints rij1listViewPane = new RowConstraints();
        rij1listViewPane.setPercentHeight(60);
        RowConstraints rij2listViewPane = new RowConstraints();
        rij2listViewPane.setPercentHeight(20);
        textAreaPane.getRowConstraints().addAll(rij0listViewPane, rij1listViewPane, rij2listViewPane);

        AttitudePane.add(textAreaPane, 1, 0);
        
        //aanmaak KnopGrid
        GridPane knopPane = new GridPane();
        knopPane.gridLinesVisibleProperty().set(false);
        
        ColumnConstraints kolom0KnopPane = new ColumnConstraints();
        kolom0KnopPane.setPercentWidth(50);
        kolom0KnopPane.setHalignment(HPos.CENTER);
        ColumnConstraints kolom1KnopPane = new ColumnConstraints();
        kolom1KnopPane.setPercentWidth(50);
        kolom1KnopPane.setHalignment(HPos.CENTER);
        knopPane.getColumnConstraints().addAll(kolom0KnopPane, kolom1KnopPane);
        
        RowConstraints rij0KnopPane = new RowConstraints();
        rij0KnopPane.setPercentHeight(100);
        knopPane.getRowConstraints().addAll(rij0KnopPane);
        
        textAreaPane.add(knopPane, 0, 2);
        
        //ListView
        ObservableList<String> opmerkingen = FXCollections.observableArrayList();;
        opmerkingen.addAll("Zenuwachtig", "Concentratie", "Schrik", "Asociaal", "Verkeersgevaarlijk", "Ongeduldig", "Agressief rijgedrag" , "Inzet", "Verstrooid", "Eigenwijs");
        Collections.sort(opmerkingen);
        ListView<String> zoekView = new ListView<String>(opmerkingen);
        invulSchermenPane.add(zoekView, 0, 0);
        
        //TextField
        TextField invulTextField = new TextField();
        invulTextField.setId("inlogTexfield");
        invulTextField.setPromptText("Geef een opmerking");
        invulSchermenPane.add(invulTextField, 0, 1);
        
        //Label
        Label attitudeLabel = new Label("Attitude");
        attitudeLabel.setId("inlognaamNummerLabel");
        textAreaPane.add(attitudeLabel, 0, 0);
        
        //TextArea
        TextArea opmerkingenArea = new TextArea();
        opmerkingenArea.setId("opmerkingenTexfield");
        textAreaPane.add(opmerkingenArea, 0, 1);
        
        //Knoppen
        Button voegToe = new Button("Voeg Toe");
        voegToe.setId("inlogButtons");
        invulSchermenPane.add(voegToe, 0, 2);
        
        voegToe.setOnMouseClicked(event -> {
            
        });
        
        //
        Button verwijder = new Button("Verwijder");
        verwijder.setId("inlogButtons");
        knopPane.add(verwijder, 0, 0);
        
        verwijder.setOnMouseClicked(event -> {
            
        });
        
        //
        Button terug = new Button("Terug");
        terug.setId("inlogButtons");
        knopPane.add(terug, 1, 0);
        
        terug.setOnMouseClicked(event -> {
            scene.setRoot(hoofdPanel);
        });
        
    }
    
    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
