/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.sun.glass.ui.Window;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;
import javafx.stage.Screen;

/**
 *
 * @author Milton
 */
public class HoofdPaneel extends GridPane
{

    public HoofdPaneel() {
//        setId("hoofdPaneelBG");
//
//        //gridpane indelen
//        gridLinesVisibleProperty().set(true);
//
//        ColumnConstraints kolom0 = new ColumnConstraints();
//        kolom0.setPercentWidth(12);
//        ColumnConstraints kolom1 = new ColumnConstraints();
//        kolom1.setPercentWidth(5);
//        ColumnConstraints kolom2 = new ColumnConstraints();
//        kolom2.setPercentWidth(5);
//        ColumnConstraints kolom3 = new ColumnConstraints();
//        kolom3.setPercentWidth(5);
//        ColumnConstraints kolom4 = new ColumnConstraints();
//        kolom4.setPercentWidth(10);
//        ColumnConstraints kolom5 = new ColumnConstraints();
//        kolom5.setPercentWidth(26);
//        ColumnConstraints kolom6 = new ColumnConstraints();
//        kolom6.setPercentWidth(10);
//        ColumnConstraints kolom7 = new ColumnConstraints();
//        kolom7.setPercentWidth(5);
//        ColumnConstraints kolom8 = new ColumnConstraints();
//        kolom8.setPercentWidth(5);
//        ColumnConstraints kolom9 = new ColumnConstraints();
//        kolom9.setPercentWidth(5);
//        ColumnConstraints kolom10 = new ColumnConstraints();
//        kolom10.setPercentWidth(12);
//
//        getColumnConstraints().addAll(kolom0, kolom1, kolom2, kolom3, kolom4, kolom5, kolom6, kolom7, kolom8, kolom9, kolom10);
//
//        RowConstraints rij0 = new RowConstraints();
//        rij0.setPercentHeight(18);
//        RowConstraints rij1 = new RowConstraints();
//        rij1.setPercentHeight(10);
//        RowConstraints rij2 = new RowConstraints();
//        rij2.setPercentHeight(10);
//        RowConstraints rij3 = new RowConstraints();
//        rij3.setPercentHeight(36);
//        RowConstraints rij4 = new RowConstraints();
//        rij4.setPercentHeight(5);
//        RowConstraints rij5 = new RowConstraints();
//        rij5.setPercentHeight(5);
//        RowConstraints rij6 = new RowConstraints();
//        rij6.setPercentHeight(5);
//        RowConstraints rij7 = new RowConstraints();
//        rij7.setPercentHeight(11);
//
//        getRowConstraints().addAll(rij0, rij1, rij2, rij3, rij4, rij5, rij6, rij7);
//
//        //einde indeling
//        //knoppen center bovenaan
//        HBox centerTopKnoppen = new HBox();
//        centerTopKnoppen.setAlignment(Pos.CENTER);
//        Image centerTop = new Image("Images/CenterTop.png");
//        ImageView centerTopView = new ImageView(centerTop);
//        setColumnIndex(centerTopKnoppen, 4);
//        setColumnSpan(centerTopKnoppen, 3);
//        setRowIndex(centerTopKnoppen, 1);
//        setRowSpan(centerTopKnoppen, 2);
//
//        rij1.setValignment(VPos.TOP);
//        centerTopKnoppen.getChildren().add(centerTopView);
//        getChildren().add(centerTopKnoppen);
//
//        centerTopView.preserveRatioProperty().setValue(Boolean.TRUE);
//        centerTopView.setFitWidth(widthProperty().get()/3);
//        centerTopView.setFitHeight(heightProperty().get()/2);
//        centerTopView.fitWidthProperty().bind(widthProperty().divide(3));
//        centerTopView.fitHeightProperty().bind(heightProperty().divide(2));
//        //einde knoppen center bovenaan
//
//        Label StudentLbl = new Label("Naam Student");
//        add(StudentLbl, 5, 0);
//
//        rij3.setValignment(VPos.BOTTOM);
//        kolom4.setHalignment(HPos.RIGHT);
//        rij0.setValignment(VPos.CENTER);
//        kolom7.setHalignment(HPos.RIGHT);
//
//        Image wijzerplaat1 = new Image("Images/Wijzerplaat.png");
//        ImageView wijzerplaat1View = new ImageView(wijzerplaat1);
//        wijzerplaat1View.preserveRatioProperty().setValue(Boolean.TRUE);
//        wijzerplaat1View.setFitWidth(widthProperty().get()/4);
//        wijzerplaat1View.setFitHeight(heightProperty().get()/2);
//        wijzerplaat1View.fitWidthProperty().bind(widthProperty().divide(4));
//        wijzerplaat1View.fitHeightProperty().bind(heightProperty().divide(2));
//
//        Image wijzerplaat2 = new Image("Images/Wijzerplaat.png");
//        ImageView wijzerplaat2View = new ImageView(wijzerplaat1);
//        wijzerplaat2View.preserveRatioProperty().setValue(Boolean.TRUE);
//        wijzerplaat2View.setFitWidth(widthProperty().get()/4);
//        wijzerplaat2View.setFitHeight(heightProperty().get()/2);
//        wijzerplaat2View.fitWidthProperty().bind(widthProperty().divide(4));
//        wijzerplaat2View.fitHeightProperty().bind(heightProperty().divide(2));
//
//        add(wijzerplaat1View, 2, 3, 2, 2);
//
//        add(wijzerplaat2View, 7, 3, 2, 2);
//        


    //maingrid indelen
        gridLinesVisibleProperty().set(true);

        ColumnConstraints kolom0 = new ColumnConstraints();
        kolom0.setPercentWidth(17);
        ColumnConstraints kolom1 = new ColumnConstraints();
        kolom1.setPercentWidth(26);
        ColumnConstraints kolom2 = new ColumnConstraints();
        kolom2.setPercentWidth(14);
        ColumnConstraints kolom3 = new ColumnConstraints();
        kolom3.setPercentWidth(26);
        ColumnConstraints kolom4 = new ColumnConstraints();
        kolom4.setPercentWidth(17);
        
        getColumnConstraints().addAll(kolom0, kolom1, kolom2, kolom3, kolom4);
        
        RowConstraints rij0 = new RowConstraints();
        rij0.setPercentHeight(15);
        RowConstraints rij1 = new RowConstraints();
        rij1.setPercentHeight(15);
        RowConstraints rij2 = new RowConstraints();
        rij2.setPercentHeight(50);
        RowConstraints rij3 = new RowConstraints();
        rij3.setPercentHeight(20);

        getRowConstraints().addAll(rij0, rij1, rij2, rij3);    
        
        //einde grid indeling
        Rectangle2D schermformaat = Screen.getPrimary().getVisualBounds();
        
        //wijzerplaaten
        Image wijzerplaat = new Image("Images/Wijzerplaat.png",Math.ceil(schermformaat.getWidth()*0.26), USE_PREF_SIZE, true, true);
        ImageView wijzerplaat1View = new ImageView(wijzerplaat);  
        ImageView wijzerplaat2View = new ImageView(wijzerplaat);
        add(wijzerplaat1View, 1, 2);
        add(wijzerplaat2View,3,2);
        
       //eind wijzerplaaten
       //
        
    }

}
