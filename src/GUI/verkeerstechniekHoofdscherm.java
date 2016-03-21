/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
public class verkeerstechniekHoofdscherm extends GridPane {

    Rectangle2D schermformaat = Screen.getPrimary().getVisualBounds();
    double maxWidth = schermformaat.getWidth() * 0.62;
    double maxHeight = schermformaat.getHeight() * 0.7;
    int voorrang1Int = 0;
    int voorrang2Int = 0;
    int voorrang3Int = 0;

    public verkeerstechniekHoofdscherm() {
        setId("rijTechniekHoofdschermPaneel");
        //GridPane
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

        //box
        ObservableList<String> VTOpmerkingen = FXCollections.observableArrayList();
        HBox opmerkingBox = new HBox();
        opmerkingBox.setAlignment(Pos.CENTER);
        opmerkingBox.setSpacing(20);
        Label opmerkingLbl = new Label("Voeg opmerking toe:");
        opmerkingLbl.setId("naamLabel");
        TextField opmerkingField = new TextField();
        opmerkingField.setId("opmerkingenTexfield");
        Button voegtoeBtn = new Button("Voeg toe");
        voegtoeBtn.setId("inlogButtons");
        voegtoeBtn.setOnAction(event -> {
            VTOpmerkingen.add(opmerkingField.getText());
            getChildren().remove(opmerkingBox);
        });
        VBox inputBox = new VBox();
        ListView<String> opmerkingLView = new ListView<>();
        opmerkingLView.setMaxHeight(maxHeight * 0.4);
        opmerkingLView.setItems(VTOpmerkingen);
        inputBox.setAlignment(Pos.CENTER_LEFT);
        inputBox.setSpacing(20);
        inputBox.getChildren().addAll(opmerkingLbl, opmerkingField, voegtoeBtn);
        opmerkingBox.getChildren().addAll(inputBox, opmerkingLView);

        //images
        Image voorrang = new Image("Images/Voorrang.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image verkeersTekens = new Image("Images/Verkeerstekens.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image snelheid = new Image("Images/Snelheid.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image volgafstand = new Image("Images/Volgafstand.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image inhaal = new Image("Images/Inhalen.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image kruisen = new Image("Images/Kruisen.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image linksAf = new Image("Images/Linksaf.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image rechtsAf = new Image("Images/Rechtsaf.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image richtingAanwijzer = new Image("Images/Richtingaanwijzers.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image plaats = new Image("Images/Openenbareweg.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);

        //voorrang ----
        imageDropperTwee(voorrang, 1, 1, opmerkingBox);

        //verkeerstekens ----
        imageDropperTwee(verkeersTekens, 2, 1, opmerkingBox);

        //snelheid ----
        imageDropperTwee(snelheid, 3, 1, opmerkingBox);

        //volgafstand ----
        imageDropperTwee(volgafstand, 4, 1, opmerkingBox);

        //inhaal ----
        imageDropperTwee(inhaal, 5, 1, opmerkingBox);

        //kruisen ----
        imageDropper(kruisen, 1, 5, opmerkingBox);

        //linksaf ----
        imageDropper(linksAf, 2, 5, opmerkingBox);

        //rechtsaf ----
        imageDropper(rechtsAf, 3, 5, opmerkingBox);

        //richtingaanwijzer ----
        imageDropper(richtingAanwijzer, 4, 5, opmerkingBox);

        //plaats ----
        imageDropper(plaats, 5, 5, opmerkingBox);

        //rectangles
        //voorrang ----
        HBox voorrangHBox = new HBox();
        voorrangHBox.setAlignment(Pos.CENTER);
        voorrangHBox.setSpacing(maxWidth * 0.01);
        Rectangle voorangRec1 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        voorangRec1.setId("verkeersRec");
        Rectangle voorangRec2 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        voorangRec2.setId("verkeersRec");
        Rectangle voorangRec3 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        voorangRec3.setId("verkeersRec");
        voorrangHBox.getChildren().addAll(voorangRec1, voorangRec2, voorangRec3);
        add(voorrangHBox, 1, 2);
        voorangRec1.setOnMouseClicked(event -> {
            if (voorrang1Int != 3) {
                voorrang1Int++;
                toggleColor(voorangRec1, voorrang1Int);
            } else {
                voorrang1Int = 0;
                toggleColor(voorangRec1, voorrang1Int);
            }
        });
        
        voorangRec2.setOnMouseClicked(event -> {
            if (voorrang2Int != 3) {
                voorrang2Int++;
                toggleColor(voorangRec2, voorrang2Int);
            } else {
                voorrang2Int = 0;
                toggleColor(voorangRec2, voorrang2Int);
            }
        });
        
        voorangRec3.setOnMouseClicked(event -> {
            if (voorrang3Int != 3) {
                voorrang3Int++;
                toggleColor(voorangRec3, voorrang3Int);
            } else {
                voorrang3Int = 0;
                toggleColor(voorangRec3, voorrang3Int);
            }
        });

        //verkeerstekens ----
        HBox verkTekensHBox = new HBox();
        verkTekensHBox.setAlignment(Pos.CENTER);
        verkTekensHBox.setSpacing(maxWidth * 0.01);
        Rectangle verkTekensRec1 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        verkTekensRec1.setId("verkeersRec");
        Rectangle verkTekensRec2 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        verkTekensRec2.setId("verkeersRec");
        Rectangle verkTekensRec3 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        verkTekensRec3.setId("verkeersRec");
        verkTekensHBox.getChildren().addAll(verkTekensRec1, verkTekensRec2, verkTekensRec3);
        add(verkTekensHBox, 2, 2);

        //snelheid ----
        HBox snelheidHBox = new HBox();
        snelheidHBox.setAlignment(Pos.CENTER);
        snelheidHBox.setSpacing(maxWidth * 0.01);
        Rectangle snelheidRec1 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        snelheidRec1.setId("verkeersRec");
        Rectangle snelheidRec2 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        snelheidRec2.setId("verkeersRec");
        Rectangle snelheidRec3 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        snelheidRec3.setId("verkeersRec");
        snelheidHBox.getChildren().addAll(snelheidRec1, snelheidRec2, snelheidRec3);
        add(snelheidHBox, 3, 2);

        //volgafstand ----
        HBox volgafstandHBox = new HBox();
        volgafstandHBox.setAlignment(Pos.CENTER);
        volgafstandHBox.setSpacing(maxWidth * 0.01);
        Rectangle volgafstandRec1 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        volgafstandRec1.setId("verkeersRec");
        Rectangle volgafstandRec2 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        volgafstandRec2.setId("verkeersRec");
        Rectangle volgafstandRec3 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        volgafstandRec3.setId("verkeersRec");
        volgafstandHBox.getChildren().addAll(volgafstandRec1, volgafstandRec2, volgafstandRec3);
        add(volgafstandHBox, 4, 2);

        //inhaal ----
        HBox inhaalHBox = new HBox();
        inhaalHBox.setAlignment(Pos.CENTER);
        inhaalHBox.setSpacing(maxWidth * 0.01);
        Rectangle inhaalRec1 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        inhaalRec1.setId("verkeersRec");
        Rectangle inhaalRec2 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        inhaalRec2.setId("verkeersRec");
        Rectangle inhaalRec3 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        inhaalRec3.setId("verkeersRec");
        inhaalHBox.getChildren().addAll(inhaalRec1, inhaalRec2, inhaalRec3);
        add(inhaalHBox, 5, 2);

        //kruisen ----
        HBox kruisenHBox = new HBox();
        kruisenHBox.setAlignment(Pos.CENTER);
        kruisenHBox.setSpacing(maxWidth * 0.01);
        Rectangle kruisenRec1 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        kruisenRec1.setId("verkeersRec");
        Rectangle kruisenRec2 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        kruisenRec2.setId("verkeersRec");
        Rectangle kruisenRec3 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        kruisenRec3.setId("verkeersRec");
        kruisenHBox.getChildren().addAll(kruisenRec1, kruisenRec2, kruisenRec3);
        add(kruisenHBox, 1, 4);

        //linksaf ----
        HBox linksafHBox = new HBox();
        linksafHBox.setAlignment(Pos.CENTER);
        linksafHBox.setSpacing(maxWidth * 0.01);
        Rectangle linksafRec1 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        linksafRec1.setId("verkeersRec");
        Rectangle linksafRec2 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        linksafRec2.setId("verkeersRec");
        Rectangle linksafRec3 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        linksafRec3.setId("verkeersRec");
        linksafHBox.getChildren().addAll(linksafRec1, linksafRec2, linksafRec3);
        add(linksafHBox, 2, 4);

        //rechtsaf ----
        HBox rechtsafHBox = new HBox();
        rechtsafHBox.setAlignment(Pos.CENTER);
        rechtsafHBox.setSpacing(maxWidth * 0.01);
        Rectangle rechtsafRec1 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        rechtsafRec1.setId("verkeersRec");
        Rectangle rechtsafRec2 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        rechtsafRec2.setId("verkeersRec");
        Rectangle rechtsafRec3 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        rechtsafRec3.setId("verkeersRec");
        rechtsafHBox.getChildren().addAll(rechtsafRec1, rechtsafRec2, rechtsafRec3);
        add(rechtsafHBox, 3, 4);

        //richtingsaanwijzers ----
        HBox richtingAanwHBox = new HBox();
        richtingAanwHBox.setAlignment(Pos.CENTER);
        richtingAanwHBox.setSpacing(maxWidth * 0.01);
        Rectangle richtingAanwRec1 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        richtingAanwRec1.setId("verkeersRec");
        Rectangle richtingAanwRec2 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        richtingAanwRec2.setId("verkeersRec");
        Rectangle richtingAanwRec3 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        richtingAanwRec3.setId("verkeersRec");
        richtingAanwHBox.getChildren().addAll(richtingAanwRec1, richtingAanwRec2, richtingAanwRec3);
        add(richtingAanwHBox, 4, 4);

        //plaats
        HBox plaatsHBox = new HBox();
        plaatsHBox.setAlignment(Pos.CENTER);
        plaatsHBox.setSpacing(maxWidth * 0.01);
        Rectangle plaatsRec1 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        plaatsRec1.setId("verkeersRec");
        Rectangle plaatsRec2 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        plaatsRec2.setId("verkeersRec");
        Rectangle plaatsRec3 = new Rectangle(Math.ceil(maxWidth * 0.03), Math.ceil(maxWidth * 0.03), Color.WHITE);
        plaatsRec3.setId("verkeersRec");
        plaatsHBox.getChildren().addAll(plaatsRec1, plaatsRec2, plaatsRec3);
        add(plaatsHBox, 5, 4);

    }

    private void imageDropper(Image img, int kolom, int rij, HBox hbox) {
        List<Image> Images = new ArrayList<>();
        Images.add(new Image("Images/knopVierkantW.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
        Images.add(new Image("Images/knopVierkantR.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
        Images.add(new Image("Images/knopVierkantO.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
        Images.add(new Image("Images/knopVierkantG.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
        ImageView View = new ImageView(img);
        ImageView afbView = new ImageView(Images.get(0));
        add(afbView, kolom, rij);
        add(View, kolom, rij);
        View.setOnMouseClicked(event -> {
            toggleImg(afbView, Images);
        });
        afbView.setOnMouseClicked(event -> {
            toggleImg(afbView, Images);
        });
        View.setOnMouseDragged(event -> {
            getChildren().remove(hbox);
            add(hbox, 1, 3, 5, 1);
        });
        afbView.setOnMouseDragged(event -> {
            getChildren().remove(hbox);
            add(hbox, 1, 3, 5, 1);
        });
    }

    private void imageDropperTwee(Image img, int kolom, int rij, HBox hbox) {
        ImageView View = new ImageView(img);
        ImageView afbView = new ImageView((new Image("Images/knopVierkant.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true)));
        add(afbView, kolom, rij);
        add(View, kolom, rij);
        View.setOnMouseClicked(event -> {
            getChildren().remove(hbox);
            add(hbox, 1, 3, 5, 1);
        });
        afbView.setOnMouseClicked(event -> {
            getChildren().remove(hbox);
            add(hbox, 1, 3, 5, 1);
        });
    }

    private void toggleImg(ImageView view, List<Image> imgList) {
        int currentIndex = imgList.indexOf(view.getImage());
        if (currentIndex == 0) {
            view.setImage(imgList.get(1));
        } else if (currentIndex == 1) {
            view.setImage(imgList.get(2));
        } else if (currentIndex == 2) {
            view.setImage(imgList.get(3));
        } else if (currentIndex == 3) {
            view.setImage(imgList.get(0));
        }
    }

    private void toggleColor(Rectangle rect, int integer) {
        if (integer == 1) {
            rect.setFill(Color.RED);
        } else if (integer == 2) {
            rect.setFill(Color.ORANGE);
        } else if (integer == 3) {
            rect.setFill(Color.GREEN);
        } else if (integer == 0) {
            rect.setFill(Color.WHITE);
        }
    }
}
