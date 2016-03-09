/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.stage.Screen;

/**
 *
 * @author Milton
 */
public class verkeerstechniekHoofdscherm extends GridPane
{

    public verkeerstechniekHoofdscherm() {
        Rectangle2D schermformaat = Screen.getPrimary().getVisualBounds();
        double maxwidth = schermformaat.getWidth() * 0.62;
        double maxHeight = schermformaat.getHeight() * 0.7;

        gridLinesVisibleProperty().set(false);
        setAlignment(Pos.CENTER);

        ColumnConstraints kolom0 = new ColumnConstraints();
        kolom0.setPercentWidth(15);
        ColumnConstraints kolom1 = new ColumnConstraints();
        kolom1.setPercentWidth(14);
        kolom1.setHalignment(HPos.CENTER);
        ColumnConstraints kolom2 = new ColumnConstraints();
        kolom2.setPercentWidth(14);
        kolom2.setHalignment(HPos.CENTER);
        ColumnConstraints kolom3 = new ColumnConstraints();
        kolom3.setPercentWidth(14);
        kolom3.setHalignment(HPos.CENTER);
        ColumnConstraints kolom4 = new ColumnConstraints();
        kolom4.setPercentWidth(14);
        kolom4.setHalignment(HPos.CENTER);
        ColumnConstraints kolom5 = new ColumnConstraints();
        kolom5.setPercentWidth(14);
        kolom5.setHalignment(HPos.CENTER);
        ColumnConstraints kolom6 = new ColumnConstraints();
        kolom6.setPercentWidth(15);

        getColumnConstraints().addAll(kolom0, kolom1, kolom2, kolom3, kolom4, kolom5, kolom6);

        RowConstraints rij0 = new RowConstraints();
        rij0.setPercentHeight(2);
        RowConstraints rij1 = new RowConstraints();
        rij1.setPercentHeight(20);
        rij1.setValignment(VPos.CENTER);
        RowConstraints rij2 = new RowConstraints();
        rij2.setPercentHeight(5);
        rij2.setValignment(VPos.CENTER);
        RowConstraints rij3 = new RowConstraints();
        rij3.setPercentHeight(44);
        RowConstraints rij4 = new RowConstraints();
        rij4.setPercentHeight(5);
        rij4.setValignment(VPos.CENTER);
        RowConstraints rij5 = new RowConstraints();
        rij5.setPercentHeight(20);
        rij5.setValignment(VPos.CENTER);
        RowConstraints rij6 = new RowConstraints();
        rij6.setPercentHeight(2);

        getRowConstraints().addAll(rij0, rij1, rij2, rij3, rij4, rij5, rij6);

        Image tijdelijkeKnop = new Image("Images/knopVierkant.png", Math.ceil(maxwidth * 0.14), USE_PREF_SIZE, true, true);

        ImageView voorrangView = new ImageView(tijdelijkeKnop);
        add(voorrangView, 1, 1);
        //voorloping mousedragged voor demo , later touchstationairy of swipe voor tablet
        voorrangView.setOnMouseDragged(event -> {
            Label derpLbl = new Label("derpy");
            add(derpLbl,3,3);
        });
        ImageView verkeersTekensView = new ImageView(tijdelijkeKnop);
        add(verkeersTekensView, 2, 1);
        ImageView snelheidView = new ImageView(tijdelijkeKnop);
        add(snelheidView, 3, 1);
        ImageView volgafstandView = new ImageView(tijdelijkeKnop);
        add(volgafstandView, 4, 1);
        ImageView inhaalView = new ImageView(tijdelijkeKnop);
        add(inhaalView, 5, 1);

        ImageView kruisenView = new ImageView(tijdelijkeKnop);
        add(kruisenView, 1, 5);
        ImageView linksafView = new ImageView(tijdelijkeKnop);
        add(linksafView, 2, 5);
        ImageView rechtsafView = new ImageView(tijdelijkeKnop);
        add(rechtsafView, 3, 5);
        ImageView richtingAanwView = new ImageView(tijdelijkeKnop);
        add(richtingAanwView, 4, 5);
        ImageView plaatsView = new ImageView(tijdelijkeKnop);
        add(plaatsView, 5, 5);

        HBox voorrangHBox = new HBox();
        voorrangHBox.setAlignment(Pos.CENTER);
        voorrangHBox.setSpacing(maxwidth * 0.01);
        Rectangle voorangRec1 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        voorangRec1.setId("verkeersRec");
        Rectangle voorangRec2 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        voorangRec2.setId("verkeersRec");
        Rectangle voorangRec3 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        voorangRec3.setId("verkeersRec");
        voorrangHBox.getChildren().addAll(voorangRec1, voorangRec2, voorangRec3);
        add(voorrangHBox, 1, 2);

        HBox verkTekensHBox = new HBox();
        verkTekensHBox.setAlignment(Pos.CENTER);
        verkTekensHBox.setSpacing(maxwidth * 0.01);
        Rectangle verkTekensRec1 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        verkTekensRec1.setId("verkeersRec");
        Rectangle verkTekensRec2 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        verkTekensRec2.setId("verkeersRec");
        Rectangle verkTekensRec3 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        verkTekensRec3.setId("verkeersRec");
        verkTekensHBox.getChildren().addAll(verkTekensRec1, verkTekensRec2, verkTekensRec3);
        add(verkTekensHBox, 2, 2);

        HBox snelheidHBox = new HBox();
        snelheidHBox.setAlignment(Pos.CENTER);
        snelheidHBox.setSpacing(maxwidth * 0.01);
        Rectangle snelheidRec1 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        snelheidRec1.setId("verkeersRec");
        Rectangle snelheidRec2 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        snelheidRec2.setId("verkeersRec");
        Rectangle snelheidRec3 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        snelheidRec3.setId("verkeersRec");
        snelheidHBox.getChildren().addAll(snelheidRec1, snelheidRec2, snelheidRec3);
        add(snelheidHBox, 3, 2);

        HBox volgafstandHBox = new HBox();
        volgafstandHBox.setAlignment(Pos.CENTER);
        volgafstandHBox.setSpacing(maxwidth * 0.01);
        Rectangle volgafstandRec1 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        volgafstandRec1.setId("verkeersRec");
        Rectangle volgafstandRec2 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        volgafstandRec2.setId("verkeersRec");
        Rectangle volgafstandRec3 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        volgafstandRec3.setId("verkeersRec");
        volgafstandHBox.getChildren().addAll(volgafstandRec1, volgafstandRec2, volgafstandRec3);
        add(volgafstandHBox, 4, 2);

        HBox inhaalHBox = new HBox();
        inhaalHBox.setAlignment(Pos.CENTER);
        inhaalHBox.setSpacing(maxwidth * 0.01);
        Rectangle inhaalRec1 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        inhaalRec1.setId("verkeersRec");
        Rectangle inhaalRec2 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        inhaalRec2.setId("verkeersRec");
        Rectangle inhaalRec3 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        inhaalRec3.setId("verkeersRec");
        inhaalHBox.getChildren().addAll(inhaalRec1, inhaalRec2, inhaalRec3);
        add(inhaalHBox, 5, 2);

        HBox kruisenHBox = new HBox();
        kruisenHBox.setAlignment(Pos.CENTER);
        kruisenHBox.setSpacing(maxwidth * 0.01);
        Rectangle kruisenRec1 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        kruisenRec1.setId("verkeersRec");
        Rectangle kruisenRec2 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        kruisenRec2.setId("verkeersRec");
        Rectangle kruisenRec3 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        kruisenRec3.setId("verkeersRec");
        kruisenHBox.getChildren().addAll(kruisenRec1, kruisenRec2, kruisenRec3);
        add(kruisenHBox, 1, 4);

        HBox linksafHBox = new HBox();
        linksafHBox.setAlignment(Pos.CENTER);
        linksafHBox.setSpacing(maxwidth * 0.01);
        Rectangle linksafRec1 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        linksafRec1.setId("verkeersRec");
        Rectangle linksafRec2 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        linksafRec2.setId("verkeersRec");
        Rectangle linksafRec3 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        linksafRec3.setId("verkeersRec");
        linksafHBox.getChildren().addAll(linksafRec1, linksafRec2, linksafRec3);
        add(linksafHBox, 2, 4);

        HBox rechtsafHBox = new HBox();
        rechtsafHBox.setAlignment(Pos.CENTER);
        rechtsafHBox.setSpacing(maxwidth * 0.01);
        Rectangle rechtsafRec1 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        rechtsafRec1.setId("verkeersRec");
        Rectangle rechtsafRec2 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        rechtsafRec2.setId("verkeersRec");
        Rectangle rechtsafRec3 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        rechtsafRec3.setId("verkeersRec");
        rechtsafHBox.getChildren().addAll(rechtsafRec1, rechtsafRec2, rechtsafRec3);
        add(rechtsafHBox, 3, 4);

        HBox richtingAanwHBox = new HBox();
        richtingAanwHBox.setAlignment(Pos.CENTER);
        richtingAanwHBox.setSpacing(maxwidth * 0.01);
        Rectangle richtingAanwRec1 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        richtingAanwRec1.setId("verkeersRec");
        Rectangle richtingAanwRec2 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        richtingAanwRec2.setId("verkeersRec");
        Rectangle richtingAanwRec3 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        richtingAanwRec3.setId("verkeersRec");
        richtingAanwHBox.getChildren().addAll(richtingAanwRec1, richtingAanwRec2, richtingAanwRec3);
        add(richtingAanwHBox, 4, 4);

        HBox plaatsHBox = new HBox();
        plaatsHBox.setAlignment(Pos.CENTER);
        plaatsHBox.setSpacing(maxwidth * 0.01);
        Rectangle plaatsRec1 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        plaatsRec1.setId("verkeersRec");
        Rectangle plaatsRec2 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        plaatsRec2.setId("verkeersRec");
        Rectangle plaatsRec3 = new Rectangle(Math.ceil(maxwidth * 0.03), Math.ceil(maxwidth * 0.03), Color.RED);
        plaatsRec3.setId("verkeersRec");
        plaatsHBox.getChildren().addAll(plaatsRec1, plaatsRec2, plaatsRec3);
        add(plaatsHBox, 5, 4);
        
    }

}
