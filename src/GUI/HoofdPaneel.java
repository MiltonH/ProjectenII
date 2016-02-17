/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author Milton
 */
public class HoofdPaneel extends GridPane
{

    public HoofdPaneel() {
//        setPrefSize(800, 800);//debug

        gridLinesVisibleProperty().set(true);

        ColumnConstraints kolom1 = new ColumnConstraints();
        kolom1.setPercentWidth(12);
        ColumnConstraints kolom2 = new ColumnConstraints();
        kolom2.setPercentWidth(5);
        ColumnConstraints kolom3 = new ColumnConstraints();
        kolom3.setPercentWidth(5);
        ColumnConstraints kolom4 = new ColumnConstraints();
        kolom4.setPercentWidth(5);
        ColumnConstraints kolom5 = new ColumnConstraints();
        kolom5.setPercentWidth(10);
        ColumnConstraints kolom6 = new ColumnConstraints();
        kolom6.setPercentWidth(26);
        ColumnConstraints kolom7 = new ColumnConstraints();
        kolom7.setPercentWidth(10);
        ColumnConstraints kolom8 = new ColumnConstraints();
        kolom8.setPercentWidth(5);
        ColumnConstraints kolom9 = new ColumnConstraints();
        kolom9.setPercentWidth(5);
        ColumnConstraints kolom10 = new ColumnConstraints();
        kolom10.setPercentWidth(5);
        ColumnConstraints kolom11 = new ColumnConstraints();
        kolom11.setPercentWidth(12);

        getColumnConstraints().addAll(kolom1, kolom2, kolom3, kolom4, kolom5, kolom6, kolom7, kolom8, kolom9, kolom10, kolom11);

        RowConstraints rij1 = new RowConstraints();
        rij1.setPercentHeight(18);
        RowConstraints rij2 = new RowConstraints();
        rij2.setPercentHeight(10);
        RowConstraints rij3 = new RowConstraints();
        rij3.setPercentHeight(10);
        RowConstraints rij4 = new RowConstraints();
        rij4.setPercentHeight(36);
        RowConstraints rij5 = new RowConstraints();
        rij5.setPercentHeight(5);
        RowConstraints rij6 = new RowConstraints();
        rij6.setPercentHeight(5);
        RowConstraints rij7 = new RowConstraints();
        rij7.setPercentHeight(5);
        RowConstraints rij8 = new RowConstraints();
        rij8.setPercentHeight(11);

        getRowConstraints().addAll(rij1, rij2, rij3, rij4, rij5, rij6, rij7, rij8);

        Label test = new Label("test");
//        Image test = new Image("Images/TestAfbeelding.jpg",100,200,true,true);
//        ImageView test2 = new ImageView(test);
//        getChildren().add(test2);
//        
//        test2.setX(this.getPrefWidth()/2);
//        test2.setY(20);
    }

}
