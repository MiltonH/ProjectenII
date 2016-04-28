package GUI;

import domain.Evaluatie;
import domain.EvaluatieFormulier;
import domain.Leerling;
import domain.View;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class RijTechniekHoofdscherm extends GridPane implements View
{

    RijTechniekBase base;
    int integer = 0;
    Rectangle2D schermformaat = Screen.getPrimary().getVisualBounds();
    double maxWidth = schermformaat.getWidth() * 0.62;

    Hashtable<String, EventHandler> eventToggles;
    Hashtable<String, Rectangle[]> rectangles;
    Hashtable<String, ImageView> knopViews;
    EvaluatieFormulier huidigformulier;

    List<Image> Images;

    public RijTechniekHoofdscherm(RijTechniekBase base) {
        setId("rijTechniekHoofdschermPaneel");
        this.base = base;
        base.getHoofdpanel().getHuidigeLeerling().addView(this);
        huidigformulier = base.getHoofdpanel().getHuidigeLeerling().getHuidigEvaluatieFormulier();

        eventToggles = new Hashtable<>();
        rectangles = new Hashtable<>();
        knopViews = new Hashtable<>();

        eventToggles.put("hellingB", event -> {
            huidigformulier.setHellingB(toggleCirkel(huidigformulier.getHellingB()));
        });
        eventToggles.put("hellingH", event -> {
            huidigformulier.setHellingH(toggleCirkel(huidigformulier.getHellingH()));
        });
        eventToggles.put("hellingV", event -> {
            huidigformulier.setHellingV(toggleCirkel(huidigformulier.getHellingV()));
        });
        eventToggles.put("stuuroefeningen", event -> {
            huidigformulier.setStuurOefeningen(toggleGGCirkel(huidigformulier.getStuurOefeningen()));
        });
        eventToggles.put("achteruitrijden", event -> {
            huidigformulier.setAchteruit(toggleGGCirkel(huidigformulier.getAchteruit()));
        });
        eventToggles.put("garage", event -> {
            huidigformulier.setGarageEen(toggleGGCirkel(huidigformulier.getGarageEen()));
        });
        eventToggles.put("keren", event -> {
            huidigformulier.setKeren(toggleGGCirkel(huidigformulier.getKeren()));
        });
        eventToggles.put("parkeren", event -> {
            huidigformulier.setParkerenLinks(toggleGGCirkel(huidigformulier.getParkerenLinks()));
        });

        Images = new ArrayList<>();
        Images.add(new Image("Images/knopVierkantW.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
        Images.add(new Image("Images/knopVierkantO.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
        Images.add(new Image("Images/knopVierkantG.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));

        //einde grid indeling

        //GridPane
        gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0 = new ColumnConstraints();
        kolom0.setPercentWidth(1);
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
        kolom6.setPercentWidth(14);
        kolom6.setHalignment(HPos.CENTER);
        ColumnConstraints kolom7 = new ColumnConstraints();
        kolom7.setPercentWidth(14);
        kolom7.setHalignment(HPos.CENTER);
        ColumnConstraints kolom8 = new ColumnConstraints();
        kolom8.setPercentWidth(1);

        getColumnConstraints().addAll(kolom0, kolom1, kolom2, kolom3, kolom4, kolom5, kolom6, kolom7, kolom8);

        RowConstraints rij0 = new RowConstraints();
        rij0.setPercentHeight(20);
        RowConstraints rij1 = new RowConstraints();
        rij1.setPercentHeight(20);
        RowConstraints rij2 = new RowConstraints();
        rij2.setPercentHeight(6);
        rij2.setValignment(VPos.CENTER);
        RowConstraints rij3 = new RowConstraints();
        rij3.setPercentHeight(14);
        RowConstraints rij4 = new RowConstraints();
        rij4.setPercentHeight(20);
        RowConstraints rij5 = new RowConstraints();
        rij5.setPercentHeight(20);

        getRowConstraints().addAll(rij0, rij1, rij2, rij3, rij4, rij5);

        setAlignment(Pos.CENTER);

        //Knoppen boven 
        Image knopVierkant = new Image("Images/knopVierkant.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true);
        Image afbRem = new Image("Images/rem.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image afbKoppeling = new Image("Images/koppeling.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image afbStuur = new Image("Images/Stuur.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image afbVersnelling = new Image("Images/pook_1.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image afbKijken = new Image("Images/Kijken.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image afbPijl = new Image("Images/pijl.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image afbZithouding = new Image("Images/zithouding.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);

        //rem ----
        RijTechniekRemKnop rijTechniekRemKnop = new RijTechniekRemKnop(this.base);
        imageDropperBoven(afbRem, 1, 1, rijTechniekRemKnop);

        //koppeling ----
        RijTechniekKoppelingKnop rijTechniekKoppelingKnop = new RijTechniekKoppelingKnop(this.base);
        imageDropperBoven(afbKoppeling, 2, 1, rijTechniekKoppelingKnop);

        //stuur ----
        RijTechniekStuurKnop rijTechniekStuurKnop = new RijTechniekStuurKnop(this.base);
        imageDropperBoven(afbStuur, 3, 1, rijTechniekStuurKnop);

        //versnelling ----
        RijTechniekVersnellingKnop rijTechniekVersnellingKnop = new RijTechniekVersnellingKnop(this.base);
        imageDropperBoven(afbVersnelling, 4, 1, rijTechniekVersnellingKnop);

        //kijken ----
        RijTechniekKijkenKnop rijTechniekKijkenKnop = new RijTechniekKijkenKnop(this.base);
        imageDropperBoven(afbKijken, 5, 1, rijTechniekKijkenKnop);

        //helling ----
        imageDropperBoven(afbPijl, 6, 1, this);

        //zithouding ----
        RijTechniekZithoudingKnop rijTechniekZithoudingKnop = new RijTechniekZithoudingKnop(this.base);
        imageDropperBoven(afbZithouding, 7, 1, rijTechniekZithoudingKnop);

        //knoppen onder
        Image afbAcht = new Image("Images/achtje.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image afbReverse = new Image("Images/achteruitrijden.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image afbGarage = new Image("Images/garage.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image afbDraaiPijltje = new Image("Images/draaipijl.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image afbParkeren = new Image("Images/parkeren.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);

        //acht ----
        imageDropperOnder(afbAcht, 2, 4, "stuuroefeningen");

        //reverse ----
        imageDropperOnder(afbReverse, 3, 4, "achteruitrijden");

        //garage ----
        imageDropperOnder(afbGarage, 4, 4, "garage");

        //draaipijltje ----
        imageDropperOnder(afbDraaiPijltje, 5, 4, "keren");

        //parkeren ----
        imageDropperOnder(afbParkeren, 6, 4, "parkeren");

        //rect variable
        double grootte = Math.ceil(maxWidth * 0.03);

        //rectangles rem
        HBox remBox = new HBox();
        remBox.setAlignment(Pos.CENTER);
        remBox.setId("rijTechniekHoofdschermBox");

        Rectangle rem1 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle rem2 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle rem3 = new Rectangle(grootte, grootte, Color.WHITE);

        Rectangle[] remRectangles = {rem1, rem2, rem3};
        rectangles.put("rem", remRectangles);

        remBox.getChildren().addAll(rem1, rem2, rem3);
        add(remBox, 1, 2);

        //rectangles koppeling
        HBox koppelingBox = new HBox();
        koppelingBox.setAlignment(Pos.CENTER);
        koppelingBox.setId("rijTechniekHoofdschermBox");

        Rectangle koppeling1 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle koppeling2 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle koppeling3 = new Rectangle(grootte, grootte, Color.WHITE);

        Rectangle[] koppelingRectangles = {koppeling1, koppeling2, koppeling3};
        rectangles.put("koppeling", koppelingRectangles);

        koppelingBox.getChildren().addAll(koppeling1, koppeling2, koppeling3);
        add(koppelingBox, 2, 2);

        //rectangles stuur
        HBox stuurBox = new HBox();
        stuurBox.setAlignment(Pos.CENTER);
        stuurBox.setId("rijTechniekHoofdschermBox");

        Rectangle stuur1 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle stuur2 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle stuur3 = new Rectangle(grootte, grootte, Color.WHITE);

        Rectangle[] stuurRectangles = {stuur1, stuur2, stuur3};
        rectangles.put("stuur", stuurRectangles);

        stuurBox.getChildren().addAll(stuur1, stuur2, stuur3);
        add(stuurBox, 3, 2);

        //rectangles versnelling
        HBox versnellingBox = new HBox();
        versnellingBox.setAlignment(Pos.CENTER);
        versnellingBox.setId("rijTechniekHoofdschermBox");

        Rectangle versnelling1 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle versnelling2 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle versnelling3 = new Rectangle(grootte, grootte, Color.WHITE);

        Rectangle[] versnellingRectangles = {versnelling1, versnelling2, versnelling3};
        rectangles.put("versnelling", versnellingRectangles);

        versnellingBox.getChildren().addAll(versnelling1, versnelling2, versnelling3);
        add(versnellingBox, 4, 2);

        //rectangles kijken
        HBox kijkenBox = new HBox();
        kijkenBox.setAlignment(Pos.CENTER);
        kijkenBox.setId("rijTechniekHoofdschermBox");

        Rectangle kijken1 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle kijken2 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle kijken3 = new Rectangle(grootte, grootte, Color.WHITE);

        Rectangle[] kijkenRectangles = {kijken1, kijken2, kijken3};
        rectangles.put("kijken", kijkenRectangles);

        kijkenBox.getChildren().addAll(kijken1, kijken2, kijken3);
        add(kijkenBox, 5, 2);

        //rectangles pijltje
        HBox pijltjeBox = new HBox();
        pijltjeBox.setAlignment(Pos.CENTER);
        pijltjeBox.setId("rijTechniekHoofdschermBox");

        Rectangle[] HellingRectangles = new Rectangle[3];
        HellingRectangles[0] = new Rectangle(grootte, grootte, Color.WHITE);
        HellingRectangles[1] = new Rectangle(grootte, grootte, Color.WHITE);
        HellingRectangles[2] = new Rectangle(grootte, grootte, Color.WHITE);
        rectangles.put("helling", HellingRectangles);

        Text textB = new Text("B");
        StackPane stackB = new StackPane();
        stackB.getChildren().addAll(HellingRectangles[0], textB);
        Text textV = new Text("V");
        StackPane stackV = new StackPane();
        stackV.getChildren().addAll(HellingRectangles[2], textV);
        Text textH = new Text("H");
        StackPane stackH = new StackPane();
        stackH.getChildren().addAll(HellingRectangles[1], textH);

        pijltjeBox.getChildren().addAll(stackB, stackV, stackH);
        add(pijltjeBox, 6, 2);

        stackB.setOnMouseClicked(eventToggles.get("hellingB"));

        stackV.setOnMouseClicked(eventToggles.get("hellingV"));

        stackH.setOnMouseClicked(eventToggles.get("hellingH"));

        //rectangles zitHouding
        HBox zitHoudingBox = new HBox();
        zitHoudingBox.setAlignment(Pos.CENTER);
        zitHoudingBox.setId("rijTechniekHoofdschermBox");

        Rectangle zitHouding1 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle zitHouding2 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle zitHouding3 = new Rectangle(grootte, grootte, Color.WHITE);

        Rectangle[] zithoudingRectangles = {zitHouding1, zitHouding2, zitHouding3};
        rectangles.put("zithouding", zithoudingRectangles);

        zitHoudingBox.getChildren().addAll(zitHouding1, zitHouding2, zitHouding3);
        add(zitHoudingBox, 7, 2);

        update();
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

    private Evaluatie toggleGGCirkel(Evaluatie eval) {
        if (Evaluatie.WIT.equals(eval)) {
            return Evaluatie.ORANJE;
        } else if (Evaluatie.ORANJE.equals(eval)) {
            return Evaluatie.GROEN;
        } else if (Evaluatie.GROEN.equals(eval)) {
            return Evaluatie.WIT;
        } else {
            return Evaluatie.WIT;
        }
    }

    private void imageDropperBoven(Image img, int kolom, int rij, GridPane pane) {

        ImageView View = new ImageView(img);
        ImageView afbView = new ImageView((new Image("Images/knopVierkant.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true)));
        add(afbView, kolom, rij);
        add(View, kolom, rij);

        View.setOnMouseClicked(event -> {
            base.setContent(pane);
        });
        afbView.setOnMouseClicked(event -> {
            base.setContent(pane);
        });
    }

    private void imageDropperOnder(Image img, int kolom, int rij, String key) {
        ImageView View = new ImageView(img);
        ImageView afbView = new ImageView(Images.get(0));
        add(afbView, kolom, rij);
        add(View, kolom, rij);
        View.setOnMouseClicked(eventToggles.get(key));
        afbView.setOnMouseClicked(eventToggles.get(key));

        knopViews.put(key, afbView);
    }

    private void PasKleurAan(String key, Evaluatie eval) {
        ImageView view = knopViews.get(key);
        if (Evaluatie.WIT.equals(eval)) {
            view.setImage(Images.get(0));
        } else if (Evaluatie.ORANJE.equals(eval)) {
            view.setImage(Images.get(1));
        } else if (Evaluatie.GROEN.equals(eval)) {
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
        huidigformulier = base.getHoofdpanel().getHuidigeLeerling().getHuidigEvaluatieFormulier();
        Leerling leerling = base.getHoofdpanel().getHuidigeLeerling();

        EvaluatieFormulier formulierHuidig = leerling.getHuidigEvaluatieFormulier();
        //huidige
        PasKleurAan("stuuroefeningen", formulierHuidig.getStuurOefeningen());
        PasKleurAan("achteruitrijden", formulierHuidig.getAchteruit());
        PasKleurAan("garage", formulierHuidig.getGarageEen());
        PasKleurAan("keren", formulierHuidig.getKeren());
        PasKleurAan("parkeren", formulierHuidig.getParkerenLinks());
        //rectangles
        //1e evaluatie
        for (int i = 0; i < leerling.getEvaluatieFormulieren().size(); i++) {
            EvaluatieFormulier formulier = leerling.getEvaluatieFormulieren().get(i);

            PasRecKleurAan("helling", formulier.getHellingB(), 0);
            PasRecKleurAan("helling", formulier.getHellingH(), 1);
            PasRecKleurAan("helling", formulier.getHellingV(), 2);
            PasRecKleurAan("rem", formulier.getRemRec(), i);
            PasRecKleurAan("koppeling", formulier.getKoppelingRec(), i);
            PasRecKleurAan("stuur", formulier.getStuurRec(), i);
            PasRecKleurAan("kijken", formulier.getKijkRec(), i);
            PasRecKleurAan("zithouding", formulier.getZithoudingRec(), i);
            PasRecKleurAan("versnelling", formulier.getSchakelRec(), i);
        }
    }
}
