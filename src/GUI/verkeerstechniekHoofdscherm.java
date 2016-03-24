/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.sun.javafx.font.freetype.HBGlyphLayout;
import domain.Evaluatie;
import domain.EvaluatieFormulier;
import domain.Leerling;
import domain.View;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;

/**
 *
 * @author Milton
 */
public class verkeerstechniekHoofdscherm extends GridPane implements View
{

    Rectangle2D schermformaat = Screen.getPrimary().getVisualBounds();
    double maxWidth = schermformaat.getWidth() * 0.62;
    double maxHeight = schermformaat.getHeight() * 0.7;
    int voorrang1Int = 0;
    int voorrang2Int = 0;
    int voorrang3Int = 0;
    VerkeersTechniekBase base;
    EvaluatieFormulier huidigformulier;

    Hashtable<String, Rectangle[]> rectangles;
    Hashtable<String, ImageView> knopViews;
    Hashtable<String, EventHandler> eventToggles;
    ObservableList<String> richtingAanwijzerOpmerkingen;
    ObservableList<String> voorrangOpmerkingen;
    ObservableList<String> verkeerstekensOpmerkingen;
    ObservableList<String> snelheidOpmerkingen;
    ObservableList<String> volgafstandOpmerkingen;

    List<Image> Images;

    public verkeerstechniekHoofdscherm(VerkeersTechniekBase base) {
        this.base = base;
        base.getHoofdpanel().getHuidigeLeerling().addView(this);
        Images = new ArrayList<>();
        Images.add(new Image("Images/knopVierkantW.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
        Images.add(new Image("Images/knopVierkantR.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
        Images.add(new Image("Images/knopVierkantO.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
        Images.add(new Image("Images/knopVierkantG.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
        huidigformulier = base.getHoofdpanel().getHuidigeLeerling().getHuidigEvaluatieFormulier();

        rectangles = new Hashtable<>();
        knopViews = new Hashtable<>();
        eventToggles = new Hashtable<>();
        eventToggles.put("verkeerstekens", event -> {
            huidigformulier.setVerkeerstekens(toggleCirkel(huidigformulier.getVerkeerstekens()));
        });
        eventToggles.put("voorrang", event -> {
            huidigformulier.setVoorrang(toggleCirkel(huidigformulier.getVoorrang()));
        });
        eventToggles.put("snelheid", event -> {
            huidigformulier.setSnelheid(toggleCirkel(huidigformulier.getSnelheid()));
        });
        eventToggles.put("volgafstand", event -> {
            huidigformulier.setVolgafstand(toggleCirkel(huidigformulier.getVolgafstand()));
        });
        eventToggles.put("inhaal", event -> {
            huidigformulier.setInhalen(toggleCirkel(huidigformulier.getInhalen()));
        });
        eventToggles.put("kruisen", event -> {
            huidigformulier.setKruisen(toggleCirkel(huidigformulier.getKruisen()));
        });
        eventToggles.put("linksaf", event -> {
            huidigformulier.setLinksaf(toggleCirkel(huidigformulier.getLinksaf()));
        });
        eventToggles.put("rechtsaf", event -> {
            huidigformulier.setRechtsaf(toggleCirkel(huidigformulier.getRechtsaf()));
        });
        eventToggles.put("plaats", event -> {
            huidigformulier.setOpenbareWeg(toggleCirkel(huidigformulier.getOpenbareWeg()));
        });
        eventToggles.put("richtingaanwijzers", event -> {
            huidigformulier.setRichtingAanwijzers(toggleCirkel(huidigformulier.getRichtingAanwijzers()));
        });

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

        //richtingAanw
        richtingAanwijzerOpmerkingen = FXCollections.observableArrayList();
        HBox richtingAanwijzeropmerkingBox = new HBox();
        richtingAanwijzeropmerkingBox.setAlignment(Pos.CENTER);
        richtingAanwijzeropmerkingBox.setSpacing(20);
        Label richtingAanwijzerOpmerkingLbl = new Label("Voeg opmerking toe:");
        richtingAanwijzerOpmerkingLbl.setId("naamLabel");
        TextField richtingAanwijzerOpmerkingField = new TextField();
        richtingAanwijzerOpmerkingField.setId("opmerkingenTexfield");
        Button richtingAanwijzerVoegtoeBtn = new Button("Voeg toe");
        richtingAanwijzerVoegtoeBtn.setId("inlogButtons");
        richtingAanwijzerVoegtoeBtn.setOnAction(event -> {
            huidigformulier.getRichtingAanwijzersAndere().add(richtingAanwijzerOpmerkingField.getText());
            getChildren().remove(richtingAanwijzeropmerkingBox);
            update();
        });
        VBox richtingAanwijzerinputBox = new VBox();
        ListView<String> richtingAanwijzerOpmerkingLView = new ListView<>();
        richtingAanwijzerOpmerkingLView.setMaxHeight(maxHeight * 0.4);
        richtingAanwijzerOpmerkingLView.setItems(richtingAanwijzerOpmerkingen);
        richtingAanwijzerinputBox.setAlignment(Pos.CENTER_LEFT);
        richtingAanwijzerinputBox.setSpacing(20);
        Button richtingAanwijzerCancelBtn = new Button("X");
        richtingAanwijzerCancelBtn.setOnAction(event -> {
            getChildren().remove(richtingAanwijzeropmerkingBox);
        });
        HBox richtingAanwijzerKnoppen = new HBox();
        richtingAanwijzerKnoppen.getChildren().addAll(richtingAanwijzerVoegtoeBtn, richtingAanwijzerCancelBtn);
        richtingAanwijzerKnoppen.setAlignment(Pos.CENTER_LEFT);
        richtingAanwijzerKnoppen.setSpacing(20);
        richtingAanwijzerinputBox.getChildren().addAll(richtingAanwijzerOpmerkingLbl, richtingAanwijzerKnoppen);
        richtingAanwijzeropmerkingBox.getChildren().addAll(richtingAanwijzerinputBox, richtingAanwijzerOpmerkingLView);

        //voorrang
        voorrangOpmerkingen = FXCollections.observableArrayList();
        HBox voorrangopmerkingBox = new HBox();
        voorrangopmerkingBox.setAlignment(Pos.CENTER);
        voorrangopmerkingBox.setSpacing(20);
        Label voorrangOpmerkingLbl = new Label("Voeg opmerking toe:");
        voorrangOpmerkingLbl.setId("naamLabel");
        TextField voorrangOpmerkingField = new TextField();
        voorrangOpmerkingField.setId("opmerkingenTexfield");
        Button voorrangVoegtoeBtn = new Button("Voeg toe");
        voorrangVoegtoeBtn.setId("inlogButtons");
        voorrangVoegtoeBtn.setOnAction(event -> {
            huidigformulier.getVoorrangAndere().add(voorrangOpmerkingField.getText());
            getChildren().remove(voorrangopmerkingBox);
            update();
        });

        Button voorrangCancelBtn = new Button("X");
        voorrangCancelBtn.setId("inlogButtons");
        voorrangCancelBtn.setOnAction(event -> {
            getChildren().remove(voorrangopmerkingBox);
        });
        VBox voorranginputBox = new VBox();
        HBox voorrangKnoppen = new HBox();
        ListView<String> voorrangOpmerkingLView = new ListView<>();
        voorrangOpmerkingLView.setMaxHeight(maxHeight * 0.4);
        voorrangOpmerkingLView.setItems(voorrangOpmerkingen);
        voorranginputBox.setAlignment(Pos.CENTER_LEFT);
        voorranginputBox.setSpacing(20);
        voorrangKnoppen.getChildren().addAll(voorrangVoegtoeBtn, voorrangCancelBtn);
        voorrangKnoppen.setAlignment(Pos.CENTER_LEFT);
        voorrangKnoppen.setSpacing(20);
        voorranginputBox.getChildren().addAll(voorrangOpmerkingLbl, voorrangOpmerkingField, voorrangKnoppen);
        voorrangopmerkingBox.getChildren().addAll(voorranginputBox, voorrangOpmerkingLView);

        //verkeerstekens
        verkeerstekensOpmerkingen = FXCollections.observableArrayList();
        HBox verkeerstekensopmerkingBox = new HBox();
        verkeerstekensopmerkingBox.setAlignment(Pos.CENTER);
        verkeerstekensopmerkingBox.setSpacing(20);
        Label verkeerstekensOpmerkingLbl = new Label("Voeg opmerking toe:");
        verkeerstekensOpmerkingLbl.setId("naamLabel");
        TextField verkeerstekensOpmerkingField = new TextField();
        verkeerstekensOpmerkingField.setId("opmerkingenTexfield");
        Button verkeerstekensVoegtoeBtn = new Button("Voeg toe");
        verkeerstekensVoegtoeBtn.setId("inlogButtons");
        verkeerstekensVoegtoeBtn.setOnAction(event -> {
            huidigformulier.getVerkeerstekensAndere().add(verkeerstekensOpmerkingField.getText());
            getChildren().remove(verkeerstekensopmerkingBox);
            update();
        });

        Button verkeerstekensCancelBtn = new Button("X");
        verkeerstekensCancelBtn.setId("inlogButtons");
        verkeerstekensCancelBtn.setOnAction(event -> {
            getChildren().remove(verkeerstekensopmerkingBox);
        });
        VBox verkeerstekensinputBox = new VBox();
        HBox verkeerstekensKnoppen = new HBox();
        ListView<String> verkeerstekensOpmerkingLView = new ListView<>();
        verkeerstekensOpmerkingLView.setMaxHeight(maxHeight * 0.4);
        verkeerstekensOpmerkingLView.setItems(verkeerstekensOpmerkingen);
        verkeerstekensinputBox.setAlignment(Pos.CENTER_LEFT);
        verkeerstekensinputBox.setSpacing(20);
        verkeerstekensKnoppen.getChildren().addAll(verkeerstekensVoegtoeBtn, verkeerstekensCancelBtn);
        verkeerstekensKnoppen.setAlignment(Pos.CENTER_LEFT);
        verkeerstekensKnoppen.setSpacing(20);
        verkeerstekensinputBox.getChildren().addAll(verkeerstekensOpmerkingLbl, verkeerstekensOpmerkingField, verkeerstekensKnoppen);
        verkeerstekensopmerkingBox.getChildren().addAll(verkeerstekensinputBox, verkeerstekensOpmerkingLView);

        //snelheid
        snelheidOpmerkingen = FXCollections.observableArrayList();
        HBox snelheidopmerkingBox = new HBox();
        snelheidopmerkingBox.setAlignment(Pos.CENTER);
        snelheidopmerkingBox.setSpacing(20);
        Label snelheidOpmerkingLbl = new Label("Voeg opmerking toe:");
        snelheidOpmerkingLbl.setId("naamLabel");
        TextField snelheidOpmerkingField = new TextField();
        snelheidOpmerkingField.setId("opmerkingenTexfield");
        Button snelheidVoegtoeBtn = new Button("Voeg toe");
        snelheidVoegtoeBtn.setId("inlogButtons");
        snelheidVoegtoeBtn.setOnAction(event -> {
            huidigformulier.getSnelheidAndere().add(snelheidOpmerkingField.getText());
            getChildren().remove(snelheidopmerkingBox);
            update();
        });

        Button snelheidCancelBtn = new Button("X");
        snelheidCancelBtn.setId("inlogButtons");
        snelheidCancelBtn.setOnAction(event -> {
            getChildren().remove(snelheidopmerkingBox);
        });
        VBox snelheidinputBox = new VBox();
        HBox snelheidKnoppen = new HBox();
        ListView<String> snelheidOpmerkingLView = new ListView<>();
        snelheidOpmerkingLView.setMaxHeight(maxHeight * 0.4);
        snelheidOpmerkingLView.setItems(snelheidOpmerkingen);
        snelheidinputBox.setAlignment(Pos.CENTER_LEFT);
        snelheidinputBox.setSpacing(20);
        snelheidKnoppen.getChildren().addAll(snelheidVoegtoeBtn, snelheidCancelBtn);
        snelheidKnoppen.setAlignment(Pos.CENTER_LEFT);
        snelheidKnoppen.setSpacing(20);
        snelheidinputBox.getChildren().addAll(snelheidOpmerkingLbl, snelheidOpmerkingField, snelheidKnoppen);
        snelheidopmerkingBox.getChildren().addAll(snelheidinputBox, snelheidOpmerkingLView);
        //volgafstand
        volgafstandOpmerkingen = FXCollections.observableArrayList();
        HBox volgafstandopmerkingBox = new HBox();
        volgafstandopmerkingBox.setAlignment(Pos.CENTER);
        volgafstandopmerkingBox.setSpacing(20);
        Label volgafstandOpmerkingLbl = new Label("Voeg opmerking toe:");
        volgafstandOpmerkingLbl.setId("naamLabel");
        TextField volgafstandOpmerkingField = new TextField();
        volgafstandOpmerkingField.setId("opmerkingenTexfield");
        Button volgafstandVoegtoeBtn = new Button("Voeg toe");
        volgafstandVoegtoeBtn.setId("inlogButtons");
        volgafstandVoegtoeBtn.setOnAction(event -> {
            huidigformulier.getVolgafstandAndere().add(volgafstandOpmerkingField.getText());
            getChildren().remove(volgafstandopmerkingBox);
            update();
        });

        Button volgafstandCancelBtn = new Button("X");
        volgafstandCancelBtn.setId("inlogButtons");
        volgafstandCancelBtn.setOnAction(event -> {
            getChildren().remove(volgafstandopmerkingBox);
        });
        VBox volgafstandinputBox = new VBox();
        HBox volgafstandKnoppen = new HBox();
        ListView<String> volgafstandOpmerkingLView = new ListView<>();
        volgafstandOpmerkingLView.setMaxHeight(maxHeight * 0.4);
        volgafstandOpmerkingLView.setItems(volgafstandOpmerkingen);
        volgafstandinputBox.setAlignment(Pos.CENTER_LEFT);
        volgafstandinputBox.setSpacing(20);
        volgafstandKnoppen.getChildren().addAll(volgafstandVoegtoeBtn, volgafstandCancelBtn);
        volgafstandKnoppen.setAlignment(Pos.CENTER_LEFT);
        volgafstandKnoppen.setSpacing(20);
        volgafstandinputBox.getChildren().addAll(volgafstandOpmerkingLbl, volgafstandOpmerkingField, volgafstandKnoppen);
        volgafstandopmerkingBox.getChildren().addAll(volgafstandinputBox, volgafstandOpmerkingLView);
        //inhaal
        //kruisen
        //linksaf
        //rechtsaf
        //plaats

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
        imageDropper(voorrang, 1, 1, volgafstandopmerkingBox, "voorrang");

        //verkeerstekens ----
        imageDropper(verkeersTekens, 2, 1, volgafstandopmerkingBox, "verkeerstekens");

        //snelheid ----
        imageDropper(snelheid, 3, 1, volgafstandopmerkingBox, "snelheid");

        //volgafstand ----
        imageDropper(volgafstand, 4, 1, volgafstandopmerkingBox, "volgafstand");

        //inhaal ----
        imageDropper(inhaal, 5, 1, opmerkingBox, "inhaal");

        //kruisen ----
        imageDropper(kruisen, 1, 5, opmerkingBox, "kruisen");

        //linksaf ----
        imageDropper(linksAf, 2, 5, opmerkingBox, "linksaf");

        //rechtsaf ----
        imageDropper(rechtsAf, 3, 5, opmerkingBox, "rechtsaf");

        //richtingaanwijzer ----
        imageDropper(richtingAanwijzer, 4, 5, volgafstandopmerkingBox, "richtingaanwijzers");

        //plaats ----
        imageDropper(plaats, 5, 5, opmerkingBox, "plaats");

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
        Rectangle[] voorrangRecs = {voorangRec1, voorangRec2, voorangRec3};
        rectangles.put("voorrang", voorrangRecs);

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

        Rectangle[] verkeerstekensRecs = {verkTekensRec1, verkTekensRec2, verkTekensRec3};
        rectangles.put("verkeerstekens", verkeerstekensRecs);

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

        Rectangle[] snelheidRecs = {snelheidRec1, snelheidRec2, snelheidRec3};
        rectangles.put("snelheid", snelheidRecs);
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

        Rectangle[] volgafstandRecs = {volgafstandRec1, volgafstandRec2, volgafstandRec3};
        rectangles.put("volgafstand", volgafstandRecs);

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

        Rectangle[] inhaalRecs = {inhaalRec1, inhaalRec2, inhaalRec3};
        rectangles.put("inhaal", inhaalRecs);

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

        Rectangle[] kruisenRecs = {kruisenRec1, kruisenRec1, kruisenRec1};
        rectangles.put("kruisen", kruisenRecs);

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

        Rectangle[] linksafRecs = {linksafRec1, linksafRec2, linksafRec3};
        rectangles.put("linksaf", linksafRecs);

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

        Rectangle[] rechtsafRecs = {rechtsafRec1, rechtsafRec1, rechtsafRec1};
        rectangles.put("rechtsaf", rechtsafRecs);

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

        Rectangle[] richtingsaanwijzersRecs = {richtingAanwRec1, richtingAanwRec2, richtingAanwRec3};
        rectangles.put("richtingaanwijzers", richtingsaanwijzersRecs);

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

        Rectangle[] plaatsRecs = {plaatsRec1, plaatsRec2, plaatsRec3};
        rectangles.put("plaats", plaatsRecs);
        update();
    }

    private void imageDropper(Image img, int kolom, int rij, HBox hbox, String key) {
        ImageView View = new ImageView(img);
        ImageView afbView = new ImageView(Images.get(0));
        add(afbView, kolom, rij);
        add(View, kolom, rij);
        View.setOnMouseClicked(eventToggles.get(key));
        afbView.setOnMouseClicked(eventToggles.get(key));
        View.setOnMouseDragged(event -> {
            getChildren().remove(hbox);
            add(hbox, 1, 3, 5, 1);
        });
        afbView.setOnMouseDragged(event -> {
            getChildren().remove(hbox);
            add(hbox, 1, 3, 5, 1);
        });
        knopViews.put(key, afbView);
    }
//
//    private void imageDropperTwee(Image img, int kolom, int rij, HBox hbox) {
//        ImageView View = new ImageView(img);
//        ImageView afbView = new ImageView((new Image("Images/knopVierkant.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true)));
//        add(afbView, kolom, rij);
//        add(View, kolom, rij);
//        View.setOnMouseClicked(event -> {
//            getChildren().remove(hbox);
//            add(hbox, 1, 3, 5, 1);
//        });
//        afbView.setOnMouseClicked(event -> {
//            getChildren().remove(hbox);
//            add(hbox, 1, 3, 5, 1);
//        });
//    }

//    private void toggleImg(ImageView view, List<Image> imgList) {
//        int currentIndex = imgList.indexOf(view.getImage());
//        if (currentIndex == 0) {
//            view.setImage(imgList.get(1));
//        } else if (currentIndex == 1) {
//            view.setImage(imgList.get(2));
//        } else if (currentIndex == 2) {
//            view.setImage(imgList.get(3));
//        } else if (currentIndex == 3) {
//            view.setImage(imgList.get(0));
//        }
//    }
//
//    private void toggleColor(Rectangle rect, int integer) {
//        if (integer == 1) {
//            rect.setFill(Color.RED);
//        } else if (integer == 2) {
//            rect.setFill(Color.ORANGE);
//        } else if (integer == 3) {
//            rect.setFill(Color.GREEN);
//        } else if (integer == 0) {
//            rect.setFill(Color.WHITE);
//        }
//    }
    private Evaluatie toggleCirkel(Evaluatie eval) {
        if (Evaluatie.WIT.equals(eval)) {
            return Evaluatie.ROOD;
        } else if (Evaluatie.ROOD.equals(eval)) {
            return Evaluatie.ORANJE;
        } else if (Evaluatie.ORANJE.equals(eval)) {
            return Evaluatie.GROEN;
        } else if (Evaluatie.GROEN.equals(eval)) {
            return Evaluatie.WIT;
        } else {
            return Evaluatie.WIT;
        }
    }

    private void PasKleurAan(String key, Evaluatie eval) {
        ImageView view = knopViews.get(key);;

        if (Evaluatie.WIT.equals(eval)) {
            view.setImage(Images.get(0));
        } else if (Evaluatie.ROOD.equals(eval)) {
            view.setImage(Images.get(1));
        } else if (Evaluatie.GROEN.equals(eval)) {
            view.setImage(Images.get(3));
        } else if (Evaluatie.ORANJE.equals(eval)) {
            view.setImage(Images.get(2));
        }
    }

    private void PasRecKleurAan(String key, Evaluatie eval, int evalNR) {
        Rectangle rec = rectangles.get(key)[evalNR];

        if (Evaluatie.WIT.equals(eval)) {
            rec.setId("verkeersRec");
        } else if (Evaluatie.ROOD.equals(eval)) {
            rec.setId("verkeersRecROOD");
        } else if (Evaluatie.GROEN.equals(eval)) {
            rec.setId("verkeersRecGROEN");
        } else if (Evaluatie.ORANJE.equals(eval)) {
            rec.setId("verkeersRecORANJE");
        }
    }

    @Override
    public void update() {
        Leerling leerling = base.getHoofdpanel().getHuidigeLeerling();

        EvaluatieFormulier formulierHuidig = leerling.getHuidigEvaluatieFormulier();
        //huidige
        PasKleurAan("verkeerstekens", formulierHuidig.getVerkeerstekens());
        verkeerstekensOpmerkingen.clear();
        verkeerstekensOpmerkingen.addAll(formulierHuidig.getVerkeerstekensAndere());
        PasKleurAan("snelheid", formulierHuidig.getSnelheid());
        snelheidOpmerkingen.clear();
        snelheidOpmerkingen.addAll(formulierHuidig.getSnelheidAndere());
        PasKleurAan("inhaal", formulierHuidig.getInhalen());
        PasKleurAan("volgafstand", formulierHuidig.getVolgafstand());
        volgafstandOpmerkingen.clear();
        volgafstandOpmerkingen.addAll(formulierHuidig.getVolgafstandAndere());
        PasKleurAan("kruisen", formulierHuidig.getKruisen());
        PasKleurAan("richtingaanwijzers", formulierHuidig.getRichtingAanwijzers());
        richtingAanwijzerOpmerkingen.clear();
        richtingAanwijzerOpmerkingen.addAll(formulierHuidig.getRichtingAanwijzersAndere());
        PasKleurAan("linksaf", formulierHuidig.getLinksaf());
        PasKleurAan("rechtsaf", formulierHuidig.getRechtsaf());
        PasKleurAan("plaats", formulierHuidig.getOpenbareWeg());
        PasKleurAan("voorrang", formulierHuidig.getVoorrang());
        voorrangOpmerkingen.clear();
        voorrangOpmerkingen.addAll(formulierHuidig.getVoorrangAndere());

        //rectangles
        //1e evaluatie
        EvaluatieFormulier formulier1 = leerling.getEvaluatieFormulieren().get(0);

        PasRecKleurAan("verkeerstekens", formulier1.getVerkeerstekens(), 0);
        PasRecKleurAan("snelheid", formulier1.getSnelheid(), 0);
        PasRecKleurAan("inhaal", formulier1.getInhalen(), 0);
        PasRecKleurAan("volgafstand", formulier1.getVolgafstand(), 0);
        PasRecKleurAan("kruisen", formulier1.getKruisen(), 0);
        PasRecKleurAan("richtingaanwijzers", formulier1.getRichtingAanwijzers(), 0);
        PasRecKleurAan("linksaf", formulier1.getLinksaf(), 0);
        PasRecKleurAan("rechtsaf", formulier1.getRechtsaf(), 0);
        PasRecKleurAan("plaats", formulier1.getOpenbareWeg(), 0);
        PasRecKleurAan("voorrang", formulier1.getVoorrang(), 0);

    }
}
