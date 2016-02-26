package GUI;

import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class OpmerkingPaneel extends GridPane{
    Scene scene;
    public OpmerkingPaneel(HoofdPaneel hoofdPanel) {
        setId("inlogPaneelBG");
        
        //aanmaak grid
        gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0 = new ColumnConstraints();
        kolom0.setPercentWidth(15);
        ColumnConstraints kolom1 = new ColumnConstraints();
        kolom1.setPercentWidth(70);
        ColumnConstraints kolom2 = new ColumnConstraints();
        kolom2.setPercentWidth(15);
        kolom2.setHalignment(HPos.CENTER);

        getColumnConstraints().addAll(kolom0, kolom1, kolom2);

        RowConstraints rij0 = new RowConstraints();
        rij0.setPercentHeight(15);
        RowConstraints rij1 = new RowConstraints();
        rij1.setPercentHeight(70);
        RowConstraints rij2 = new RowConstraints();
        rij2.setPercentHeight(15);

        getRowConstraints().addAll(rij0, rij1, rij2);
        
        //aanmaak LabelTextareaGrid
        GridPane labelTextAreaGrid = new GridPane();
        labelTextAreaGrid.setId("opmerkingenPaneel");
        labelTextAreaGrid.gridLinesVisibleProperty().set(false);
        
        ColumnConstraints kolom0labelTextAreaGrid = new ColumnConstraints();
        kolom0labelTextAreaGrid.setPercentWidth(100);
        labelTextAreaGrid.getColumnConstraints().addAll(kolom0labelTextAreaGrid);

        RowConstraints rij0labelTextAreaGrid = new RowConstraints();
        rij0labelTextAreaGrid.setPercentHeight(10);
        RowConstraints rij1labelTextAreaGrid = new RowConstraints();
        rij1labelTextAreaGrid.setPercentHeight(90);
        labelTextAreaGrid.getRowConstraints().addAll(rij0labelTextAreaGrid, rij1labelTextAreaGrid);

        add(labelTextAreaGrid, 1, 1);
        
        //label opmerkingen
        Label opmerkingenLabel = new Label("Opmerkingen: ");
        opmerkingenLabel.setId("opmerkingenLabel");
        labelTextAreaGrid.add(opmerkingenLabel, 0, 0);
        
        //textArea opmerkingen
        TextArea opmerkingenArea = new TextArea();
        opmerkingenArea.setId("opmerkingenTexfield");
        labelTextAreaGrid.add(opmerkingenArea, 0, 1);
        
        //terugKnop
        Button terugKnop = new Button("Terug");
        terugKnop.setId("inlogButtons");
        add(terugKnop, 2, 2);
        
        terugKnop.setOnMouseClicked(event -> {
            scene.setRoot(hoofdPanel);
        });
    }
    
    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
