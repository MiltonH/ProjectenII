/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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

    private Rectangle2D schermformaat;
    private double maxWidth;
    private double maxHeight;
    private int voorrang1Int = 0;
    private int voorrang2Int = 0;
    private int voorrang3Int = 0;
    private VerkeersTechniekBase base;
    private EvaluatieFormulier huidigformulier;
    VectorBuilder veccyb;
//    private Hashtable<String, Group> knopViews;

    private Hashtable<String, Rectangle[]> rectangles;
    private Hashtable<String, ImageView> knopViews;
    private Hashtable<String, EventHandler> eventToggles;
    private Hashtable<String, List<String>> opmerkingLists;
    private Boolean BoxOpen;

    private List<Image> Images;

    public verkeerstechniekHoofdscherm(VerkeersTechniekBase base, Rectangle2D formaat) {
        this.base = base;
        schermformaat = formaat;
        maxWidth = schermformaat.getWidth() * 0.62;
        maxHeight = schermformaat.getHeight() * 0.7;
        base.getHoofdpanel().getHuidigeLeerling().addView(this);
        veccyb = new VectorBuilder(schermformaat);
        Images = new ArrayList<>();
        Images.add(new Image("Images/knopVierkantW.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
        Images.add(new Image("Images/knopVierkantR.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
        Images.add(new Image("Images/knopVierkantO.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
        Images.add(new Image("Images/knopVierkantG.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
        huidigformulier = base.getHoofdpanel().getHuidigeLeerling().getHuidigEvaluatieFormulier();

        rectangles = new Hashtable<>();
        knopViews = new Hashtable<>();
        eventToggles = new Hashtable<>();
        opmerkingLists = new Hashtable<>();
        BoxOpen = false;

        opmerkingLists.put("voorrang", huidigformulier.getVoorrangAndere());
        opmerkingLists.put("verkeerstekens", huidigformulier.getVerkeerstekensAndere());
        opmerkingLists.put("snelheid", huidigformulier.getSnelheidAndere());
        opmerkingLists.put("volgafstand", huidigformulier.getVolgafstandAndere());
        opmerkingLists.put("inhaal", huidigformulier.getInhalenAndere());
        opmerkingLists.put("kruisen", huidigformulier.getKruisenAndere());
        opmerkingLists.put("linksaf", huidigformulier.getLinksafAndere());
        opmerkingLists.put("rechtsaf", huidigformulier.getRechtsafAndere());
        opmerkingLists.put("plaats", huidigformulier.getOpenbareWegAndere());
        opmerkingLists.put("richtingaanwijzers", huidigformulier.getRichtingAanwijzersAndere());

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
        ;
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
        imageDropper(voorrang, 1, 1, "voorrang");

        //verkeerstekens ----
        imageDropper(verkeersTekens, 2, 1, "verkeerstekens");

        //snelheid ----
        imageDropper(snelheid, 3, 1, "snelheid");

        //volgafstand ----
        imageDropper(volgafstand, 4, 1, "volgafstand");

        //inhaal ----
        imageDropper(inhaal, 5, 1, "inhaal");

        //kruisen ----
        imageDropper(kruisen, 1, 5, "kruisen");

        //linksaf ----
        imageDropper(linksAf, 2, 5, "linksaf");

        //rechtsaf ----
        imageDropper(rechtsAf, 3, 5, "rechtsaf");

        //richtingaanwijzer ----
        imageDropper(richtingAanwijzer, 4, 5, "richtingaanwijzers");

        //plaats ----
        imageDropper(plaats, 5, 5, "plaats");

        //opmerkinglists
        //
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

        Rectangle[] kruisenRecs = {kruisenRec1, kruisenRec2, kruisenRec3};
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

        Rectangle[] rechtsafRecs = {rechtsafRec1, rechtsafRec2, rechtsafRec3};
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

    private void imageDropper(Image img, int kolom, int rij, String key) {
        ImageView View = new ImageView(img);
//        Group afbView = veccyb.buildKnop(Color.BLUE, veccyb.rijtechniekG(Color.BLUE));
        ImageView afbView = new ImageView(Images.get(0));
        add(afbView, kolom, rij);
        add(View, kolom, rij);
        View.setOnMouseClicked(eventToggles.get(key));
        afbView.setOnMouseClicked(eventToggles.get(key));

        ObservableList<String> opmerkingen = FXCollections.observableArrayList();
        opmerkingen.addAll(opmerkingLists.get(key));
        HBox opmerkingBox = new HBox();
        opmerkingBox.setAlignment(Pos.CENTER);
        opmerkingBox.setSpacing(20);
        Label opmerkingLbl = new Label("Voeg opmerking toe:");
        opmerkingLbl.setId("verkeerstechniekLabel");
        Label opmerkingToegevoegdLbl = new Label("Uw opmerking is toegevoegd");
        opmerkingToegevoegdLbl.setId("opmerkingToegevoegd");
        TextField opmerkingField = new TextField();
        opmerkingField.setId("opmerkingenTexfield");

        opmerkingField.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    opmerkingLists.get(key).add(opmerkingField.getText());
                    opmerkingField.clear();
                    opmerkingen.addAll(opmerkingLists.get(key));
                    update();
                }
            }
        });

        VBox inputBox = new VBox();
        ListView<String> opmerkingLView = new ListView<>();
        opmerkingLView.setMaxHeight(maxHeight * 0.4);
        opmerkingLView.setItems(opmerkingen);
        inputBox.setAlignment(Pos.CENTER_LEFT);
        inputBox.setSpacing(20);

        Button annuleerBtn = new Button("Sluit");
        annuleerBtn.setId("verkeersTechniekButtons");
        annuleerBtn.setOnAction(event -> {
            afbView.setId("");
            getChildren().remove(opmerkingBox);
            BoxOpen = false;
            inputBox.getChildren().remove(opmerkingToegevoegdLbl);
        });
        HBox knoppen = new HBox();
        knoppen.setAlignment(Pos.CENTER_LEFT);
        knoppen.setSpacing(20);

        Button deleteBtn = new Button("X");
        deleteBtn.setId("verkeersTechniekButtons");
        deleteBtn.setOnAction(event -> {
            opmerkingLists.get(key).remove(opmerkingLView.getSelectionModel().getSelectedItem());
            opmerkingen.clear();
            opmerkingen.addAll(opmerkingLists.get(key));
        });

        Button aandachtBtn = new Button("!");
        aandachtBtn.setId("verkeersTechniekButtons");
        aandachtBtn.setOnAction(event -> {
            if (!huidigformulier.getOpmerkingen().contains(opmerkingLView.getSelectionModel().getSelectedItem())) {
                huidigformulier.getOpmerkingen().add(opmerkingLView.getSelectionModel().getSelectedItem());
            }
            if (!opmerkingLView.getSelectionModel().getSelectedItems().isEmpty()) {
                inputBox.getChildren().add(opmerkingToegevoegdLbl);
            }
            opmerkingLists.get(key).remove(opmerkingLView.getSelectionModel().getSelectedItem());
            opmerkingen.clear();
            opmerkingen.addAll(opmerkingLists.get(key));
//            opmerkingLists.get(key).add(opmerkingField.getText());
//            opmerkingen.clear();
//            opmerkingen.addAll(opmerkingLists.get(key));
        });

        knoppen.getChildren().addAll(deleteBtn, annuleerBtn, aandachtBtn);
        inputBox.getChildren().addAll(opmerkingLbl, opmerkingField, knoppen);
        opmerkingBox.getChildren().addAll(inputBox, opmerkingLView);

        View.setOnMouseDragged(event -> {
            if (!BoxOpen) {
                afbView.setId("imageGlow");
                opmerkingen.clear();
                opmerkingen.addAll(opmerkingLists.get(key));
                getChildren().remove(opmerkingBox);
                add(opmerkingBox, 1, 3, 5, 1);
                BoxOpen = true;
            }
        });
        afbView.setOnMouseDragged(event -> {
            if (!BoxOpen) {
                afbView.setId("imageGlow");
                opmerkingen.clear();
                opmerkingen.addAll(opmerkingLists.get(key));
                getChildren().remove(opmerkingBox);
                add(opmerkingBox, 1, 3, 5, 1);
                BoxOpen = true;
            }
        });

        knopViews.put(key, afbView);
    }

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
//        Group view = knopViews.get(key);
        ImageView view = knopViews.get(key);
        if (Evaluatie.WIT.equals(eval)) {
            view.setImage(Images.get(0));
//            Group view2 = veccyb.buildKnop(Color.WHITE, veccyb.rijtechniekG(Color.WHITE));
//            view.getChildren().clear();
//            view.getChildren().addAll(view2.getChildren());
        } else if (Evaluatie.ROOD.equals(eval)) {
            view.setImage(Images.get(1));
//            Group view2 = veccyb.buildKnop(Color.RED, veccyb.rijtechniekG(Color.RED));
//            view.getChildren().addAll(view2.getChildren());
        } else if (Evaluatie.GROEN.equals(eval)) {
            view.setImage(Images.get(3));
//            Group view2 = veccyb.buildKnop(Color.LIME, veccyb.rijtechniekG(Color.LIME));
//            view.getChildren().addAll(view2.getChildren());
        } else if (Evaluatie.ORANJE.equals(eval)) {
            view.setImage(Images.get(2));
//            Group view2 = veccyb.buildKnop(Color.ORANGE, veccyb.rijtechniekG(Color.ORANGE));
//            view.getChildren().addAll(view2.getChildren());
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
        huidigformulier = base.getHoofdpanel().getHuidigeLeerling().getHuidigEvaluatieFormulier();
        Leerling leerling = base.getHoofdpanel().getHuidigeLeerling();

        EvaluatieFormulier formulierHuidig = leerling.getHuidigEvaluatieFormulier();
        //huidige
        PasKleurAan("verkeerstekens", formulierHuidig.getVerkeerstekens());
        PasKleurAan("snelheid", formulierHuidig.getSnelheid());
        PasKleurAan("inhaal", formulierHuidig.getInhalen());
        PasKleurAan("volgafstand", formulierHuidig.getVolgafstand());
        PasKleurAan("kruisen", formulierHuidig.getKruisen());
        PasKleurAan("richtingaanwijzers", formulierHuidig.getRichtingAanwijzers());
        PasKleurAan("linksaf", formulierHuidig.getLinksaf());
        PasKleurAan("rechtsaf", formulierHuidig.getRechtsaf());
        PasKleurAan("plaats", formulierHuidig.getOpenbareWeg());
        PasKleurAan("voorrang", formulierHuidig.getVoorrang());
        //rectangles
        //1e evaluatie
        for (int i = 0; i < leerling.getEvaluatieFormulieren().size(); i++) {
            EvaluatieFormulier formulier = leerling.getEvaluatieFormulieren().get(i);

            PasRecKleurAan("verkeerstekens", formulier.getVerkeerstekens(), i);
            PasRecKleurAan("snelheid", formulier.getSnelheid(), i);
            PasRecKleurAan("inhaal", formulier.getInhalen(), i);
            PasRecKleurAan("volgafstand", formulier.getVolgafstand(), i);
            PasRecKleurAan("kruisen", formulier.getKruisen(), i);
            PasRecKleurAan("richtingaanwijzers", formulier.getRichtingAanwijzers(), i);
            PasRecKleurAan("linksaf", formulier.getLinksaf(), i);
            PasRecKleurAan("rechtsaf", formulier.getRechtsaf(), i);
            PasRecKleurAan("plaats", formulier.getOpenbareWeg(), i);
            PasRecKleurAan("voorrang", formulier.getVoorrang(), i);
        }
        base.getHoofdpanel().getHuidigeLeerling().updateLastEdit();
    }

}
