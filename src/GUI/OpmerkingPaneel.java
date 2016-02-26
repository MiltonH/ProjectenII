package GUI;

import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class OpmerkingPaneel extends GridPane{
    Scene scene;
    public OpmerkingPaneel() {
        gridLinesVisibleProperty().set(true);

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
    }
    
    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
