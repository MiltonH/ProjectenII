package GUI;

import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class AttitudePaneel extends GridPane{
    Scene scene;
    
    public AttitudePaneel(){
        //aanmaak grid
        gridLinesVisibleProperty().set(true);

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
        GridPane InlogSchermPane = new GridPane();
        InlogSchermPane.gridLinesVisibleProperty().set(true);

        ColumnConstraints kolom0InlogSchermPane = new ColumnConstraints();
        kolom0InlogSchermPane.setPercentWidth(35);
        kolom0InlogSchermPane.setHalignment(HPos.CENTER);
        ColumnConstraints kolom1InlogSchermPane = new ColumnConstraints();
        kolom1InlogSchermPane.setPercentWidth(65);
        kolom1InlogSchermPane.setHalignment(HPos.CENTER);
        InlogSchermPane.getColumnConstraints().addAll(kolom0InlogSchermPane, kolom1InlogSchermPane);

        RowConstraints rij0InlogSchermPane = new RowConstraints();
        rij0InlogSchermPane.setPercentHeight(100);
        InlogSchermPane.getRowConstraints().addAll(rij0InlogSchermPane);

        add(InlogSchermPane, 1, 1);
        
        //aanmaak invulSchermen
        GridPane naamNummerPane = new GridPane();
        naamNummerPane.gridLinesVisibleProperty().set(true);

        ColumnConstraints kolom0NaamNummerPane = new ColumnConstraints();
        kolom0NaamNummerPane.setPercentWidth(100);
        naamNummerPane.getColumnConstraints().addAll(kolom0NaamNummerPane);

        RowConstraints rij0NaamNummerPane = new RowConstraints();
        rij0NaamNummerPane.setPercentHeight(60);
        RowConstraints rij1NaamNummerPane = new RowConstraints();
        rij1NaamNummerPane.setPercentHeight(20);
        RowConstraints rij2NaamNummerPane = new RowConstraints();
        rij2NaamNummerPane.setPercentHeight(20);
        naamNummerPane.getRowConstraints().addAll(rij0NaamNummerPane, rij1NaamNummerPane, rij2NaamNummerPane);

        InlogSchermPane.add(naamNummerPane, 0, 0);
        
        //aanmaak listViewGrid
        GridPane naamNummerPanes = new GridPane();
        naamNummerPanes.gridLinesVisibleProperty().set(true);

        ColumnConstraints kolom0NaamNummerPanes = new ColumnConstraints();
        kolom0NaamNummerPanes.setPercentWidth(100);
        naamNummerPanes.getColumnConstraints().addAll(kolom0NaamNummerPanes);

        RowConstraints rij0NaamNummerPanes = new RowConstraints();
        rij0NaamNummerPanes.setPercentHeight(20);
        RowConstraints rij1NaamNummerPanes = new RowConstraints();
        rij1NaamNummerPanes.setPercentHeight(60);
        RowConstraints rij2NaamNummerPanes = new RowConstraints();
        rij2NaamNummerPanes.setPercentHeight(20);
        naamNummerPanes.getRowConstraints().addAll(rij0NaamNummerPanes, rij1NaamNummerPanes, rij2NaamNummerPanes);

        InlogSchermPane.add(naamNummerPanes, 1, 0);
    }
    
    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
