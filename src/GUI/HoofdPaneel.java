package GUI;

import domain.Evaluatie;
import domain.EvaluatieFormulier;
import domain.Leerling;
import domain.View;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;

public class HoofdPaneel extends GridPane implements View
{

    private Scene scene;
    InlogPaneel inlogPaneel;
    private int niveau = 1;//dit is testcode
    private Leerling huidigeLeerling;

    Hashtable<String, ImageView> iconViewsTable;
    Hashtable<String, List> imageListTable;
    ImageView niveauCenterView;
    List<Image> niveauImages;
    EvaluatieFormulier HuidigFormulier;

    public HoofdPaneel(Leerling leerling) {
        //maingrid indelen
        huidigeLeerling = leerling;
        huidigeLeerling.addView(this);

        iconViewsTable = new Hashtable<>();
        imageListTable = new Hashtable<>();
        HuidigFormulier = huidigeLeerling.getHuidigEvaluatieFormulier();

        setId("hoofdPaneelBG");
        gridLinesVisibleProperty().set(false);

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

        //kap
        HBox kapBox = new HBox();
        StackPane kapStack = new StackPane();
        Image kapImg = new Image("Images/kap.png", Math.ceil(schermformaat.getWidth()), USE_PREF_SIZE, true, true);
        ImageView kapView = new ImageView(kapImg);
        kapBox.setAlignment(Pos.TOP_CENTER);
        kapStack.setAlignment(Pos.TOP_CENTER);
        kapStack.getChildren().addAll(kapView);
        kapBox.getChildren().addAll(kapStack);

        add(kapBox, 0, 0, 5, 3);

        kapView.setOnMouseClicked(event -> {
            System.out.println("kap");
        });//debug

        //student naam
        Label studentNaam = new Label(huidigeLeerling.getVoornaam());
        studentNaam.setId("naamLabel");
        setHalignment(studentNaam, HPos.CENTER);
        add(studentNaam, 4, 0);
        //einde studnet naam
        //einde kap       
        //centerBox
        HBox centerBox = new HBox();
        StackPane centerStack = new StackPane();
        Image centerImg = new Image("Images/center2.png", Math.ceil(schermformaat.getWidth() * 0.24), USE_PREF_SIZE, true, true);
        ImageView centerView = new ImageView(centerImg);
        Image centerKnopImg = new Image("Images/centerKnop2.png", Math.ceil(schermformaat.getWidth() * 0.10), USE_PREF_SIZE, true, true);
        ImageView centerKnopView = new ImageView(centerKnopImg);
        centerBox.setAlignment(Pos.CENTER);
        centerStack.getChildren().addAll(centerView, centerKnopView);
        centerBox.getChildren().addAll(centerStack);
        add(centerBox, 1, 2, 3, 1);

        centerKnopView.setOnMouseClicked(event -> {
            AttitudePaneel attitudePaneel = new AttitudePaneel(this);
            attitudePaneel.setScene(scene);
            scene.setRoot(attitudePaneel);
        });//debug
        //einde centerBox

        //wijzerplaaten
        StackPane wijzerplaat1Stack = new StackPane();
        StackPane wijzerplaat2Stack = new StackPane();

        Image wijzerplaat = new Image("Images/Wijzerplaat.png", Math.ceil(schermformaat.getWidth() * 0.26), USE_PREF_SIZE, true, true);
        Image wijzerStand1 = new Image("Images/WijzerStand1.png", Math.ceil(schermformaat.getWidth() * 0.26), USE_PREF_SIZE, true, true);
        Image wijzerStand2 = new Image("Images/WijzerStand2.png", Math.ceil(schermformaat.getWidth() * 0.26), USE_PREF_SIZE, true, true);
        Image wijzerStand3 = new Image("Images/WijzerStand3.png", Math.ceil(schermformaat.getWidth() * 0.26), USE_PREF_SIZE, true, true);
        ImageView wijzeplaat1Stand = new ImageView(wijzerStand1);
        ImageView wijzeplaat2Stand = new ImageView(wijzerStand1);
        ImageView wijzerplaat1View = new ImageView(wijzerplaat);
        ImageView wijzerplaat2View = new ImageView(wijzerplaat);

        wijzerplaat1Stack.getChildren().addAll(wijzerplaat1View, wijzeplaat1Stand);
        wijzerplaat2Stack.getChildren().addAll(wijzerplaat2View, wijzeplaat2Stand);
        add(wijzerplaat1Stack, 1, 2);
        add(wijzerplaat2Stack, 3, 2);
        wijzerplaat1View.setOnMouseClicked(event -> {
            RijTechniekBase rijtechniekenBase = new RijTechniekBase(this);
            scene.setRoot(rijtechniekenBase);
        });//debug
        wijzerplaat2View.setOnMouseClicked(event -> {
            VerkeersTechniekBase verkeersTechniekBase = new VerkeersTechniekBase(this);
            scene.setRoot(verkeersTechniekBase);
        });//debug

        //eind wijzerplaaten
        //CenterTopBalk
        HBox centerTopBox = new HBox();
        StackPane centerTopStack = new StackPane();
        centerTopBox.setAlignment(Pos.CENTER);
        Image centerTopImg = new Image("Images/CenterTop.png", Math.ceil(schermformaat.getWidth() * 0.40), USE_PREF_SIZE, true, true);
        ImageView centerTopView = new ImageView(centerTopImg);

        HBox centerTopKnoppen = new HBox();
        centerTopKnoppen.setAlignment(Pos.CENTER);
        centerTopKnoppen.setSpacing(Math.ceil(schermformaat.getWidth() * 0.02));

        List<Image> rijstrokenImages = new ArrayList<>();
        rijstrokenImages.add(new Image("Images/rijstrokenIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        rijstrokenImages.add(new Image("Images/rijstrokenRIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        rijstrokenImages.add(new Image("Images/rijstrokenGIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        ImageView rijstrokenView = new ImageView(rijstrokenImages.get(0));
        iconViewsTable.put("rijstroken", rijstrokenView);
        imageListTable.put("rijstroken", rijstrokenImages);

        rijstrokenView.setOnMouseClicked(event -> {
            HuidigFormulier.setRijstroken(toggleTopIcoon(HuidigFormulier.getRijstroken()));
        });//debug

        List<Image> rotondeImages = new ArrayList<>();
        rotondeImages.add(new Image("Images/rotondeIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        rotondeImages.add(new Image("Images/rotondeRIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        rotondeImages.add(new Image("Images/rotondeGIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        ImageView rotondeView = new ImageView(rotondeImages.get(0));
        iconViewsTable.put("rotonde", rotondeView);
        imageListTable.put("rotonde", rotondeImages);

        rotondeView.setOnMouseClicked(event -> {
            HuidigFormulier.setRotonde(toggleTopIcoon(HuidigFormulier.getRotonde()));
        });//debug

        List<Image> snelwegImages = new ArrayList<>();
        snelwegImages.add(new Image("Images/snelwegIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        snelwegImages.add(new Image("Images/snelwegRIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        snelwegImages.add(new Image("Images/snelwegGIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        ImageView snelwegView = new ImageView(snelwegImages.get(0));
        iconViewsTable.put("snelweg", snelwegView);
        imageListTable.put("snelweg", snelwegImages);

        snelwegView.setOnMouseClicked(event -> {
            HuidigFormulier.setAutosnelweg(toggleTopIcoon(HuidigFormulier.getAutosnelweg()));
        });//debug

        List<Image> stadImages = new ArrayList<>();
        stadImages.add(new Image("Images/stadIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        stadImages.add(new Image("Images/stadRIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        stadImages.add(new Image("Images/stadGIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        ImageView stadView = new ImageView(stadImages.get(0));
        iconViewsTable.put("stad", stadView);
        imageListTable.put("stad", stadImages);

        stadView.setOnMouseClicked(event -> {
            HuidigFormulier.setStad(toggleTopIcoon(HuidigFormulier.getStad()));
        });//debug

        centerTopKnoppen.getChildren().addAll(rotondeView, rijstrokenView, stadView, snelwegView);
        centerTopStack.getChildren().addAll(centerTopView, centerTopKnoppen);
        centerTopBox.getChildren().add(centerTopStack);

        add(centerTopBox, 1, 1, 3, 1);
        //einde CenterTopBalk

        //BottomBox
        HBox bottomBox = new HBox();
        StackPane bottomStack = new StackPane();
        bottomStack.setAlignment(Pos.BOTTOM_CENTER);
        bottomBox.setAlignment(Pos.BOTTOM_CENTER);
        Image bottomBoxImg = new Image("Images/BottomBox.png", Math.ceil(schermformaat.getWidth() * 0.40), USE_PREF_SIZE, true, true);
        ImageView bottomBoxView = new ImageView(bottomBoxImg);
        bottomBox.getChildren().add(bottomStack);

        Image bottomTest = new Image("Images/BottomTest.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true);
        ImageView bottomTest1View = new ImageView(bottomTest);
        bottomTest1View.setOnMouseClicked(event -> {
            //
        });
        ImageView bottomTest2View = new ImageView(bottomTest);
        bottomTest2View.setOnMouseClicked(event -> {
            if (huidigeLeerling.getHuidigEvaluatieFormulierNr() == 0) {
                huidigeLeerling.volgendFormulier();
            }
        });
        ImageView bottomTest3View = new ImageView(bottomTest);
        bottomTest3View.setOnMouseClicked(event -> {
            if (huidigeLeerling.getHuidigEvaluatieFormulierNr() == 1) {
                huidigeLeerling.volgendFormulier();
            }
        });

        GridPane bottomBoxGrid = new GridPane();
        bottomBoxGrid.setAlignment(Pos.BOTTOM_CENTER);
//        bottomBoxGrid.gridLinesVisibleProperty().set(true);

        RowConstraints bottomRij0 = new RowConstraints();
        bottomRij0.setMaxHeight(schermformaat.getHeight() * 0.08);

        RowConstraints bottomRij1 = new RowConstraints();
        bottomRij1.setPrefHeight(schermformaat.getHeight() * 0.12);
        bottomBoxGrid.getRowConstraints().addAll(bottomRij0, bottomRij1);
        HBox TestKnoppen = new HBox();
        TestKnoppen.setAlignment(Pos.CENTER);
        TestKnoppen.setSpacing(Math.ceil(schermformaat.getWidth() * 0.03));

        TestKnoppen.getChildren().addAll(bottomTest1View, bottomTest2View, bottomTest3View);

        bottomBoxGrid.add(TestKnoppen, 0, 0);
        //niveau

        Image niveauBoxImg = new Image("Images/niveauBox.png", Math.ceil(schermformaat.getWidth() * 0.24), USE_PREF_SIZE, true, true);
        ImageView niveauBoxView = new ImageView(niveauBoxImg);

        StackPane niveauStack = new StackPane();
        HBox niveauHbox = new HBox();
        niveauHbox.setAlignment(Pos.CENTER);
        niveauHbox.setSpacing(Math.ceil(schermformaat.getWidth() * 0.01));

        Image niveauMinImg = new Image("Images/niveaumin.png", Math.ceil(schermformaat.getWidth() * 0.02), USE_PREF_SIZE, true, true);
        ImageView niveauMinView = new ImageView(niveauMinImg);

        Image niveauPlusImg = new Image("Images/niveauplus.png", Math.ceil(schermformaat.getWidth() * 0.02), USE_PREF_SIZE, true, true);
        ImageView niveauPlusView = new ImageView(niveauPlusImg);
        niveauImages = new ArrayList<>();
        niveauImages.add(new Image("Images/niveau1.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauImages.add(new Image("Images/niveau2.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauImages.add(new Image("Images/niveau3.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauImages.add(new Image("Images/niveau4.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauImages.add(new Image("Images/niveau5.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauImages.add(new Image("Images/niveau6.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauImages.add(new Image("Images/niveau7.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauCenterView = new ImageView(niveauImages.get(niveau - 1));

        niveauHbox.getChildren().addAll(niveauMinView, niveauCenterView, niveauPlusView);

        niveauStack.getChildren().addAll(niveauBoxView, niveauHbox);
        bottomBoxGrid.add(niveauStack, 0, 1);

        niveauMinView.setOnMouseClicked(event -> {
            niveauMin();
//            niveauCenterView.setImage(niveauImages.get(niveau - 1));

        });
        niveauPlusView.setOnMouseClicked(event -> {
            niveauPlus();
//            niveauCenterView.setImage(niveauImages.get(niveau - 1));
        });
        //eind niveau
        bottomStack.getChildren().addAll(bottomBoxView, bottomBoxGrid);

        add(bottomBox, 1, 3, 3, 1);
        //einde BottomBox

        double HoekenratioFix = 0.05;
        if (schermformaat.getWidth() / schermformaat.getHeight() < 1.77) {
            HoekenratioFix = 0.03;
        }
        //hoeklinks
        GridPane linksKnoppenGrid = new GridPane();
        linksKnoppenGrid.setAlignment(Pos.CENTER);
//        linksKnoppenGrid.gridLinesVisibleProperty().setValue(Boolean.TRUE);

        RowConstraints linksRij0 = new RowConstraints();
        linksRij0.setPrefHeight(schermformaat.getHeight() * 0.03);
        RowConstraints linksRij1 = new RowConstraints();
        linksRij1.setPrefHeight(schermformaat.getHeight() * 0.04);
        RowConstraints linksRij2 = new RowConstraints();
        linksRij2.setPrefHeight(schermformaat.getHeight() * HoekenratioFix);
        RowConstraints linksRij3 = new RowConstraints();
        linksRij3.setPrefHeight(schermformaat.getHeight() * 0.04);
        RowConstraints linksRij4 = new RowConstraints();
        linksRij4.setPrefHeight(schermformaat.getHeight() * HoekenratioFix);
        RowConstraints linksRij5 = new RowConstraints();
        linksRij5.setPrefHeight(schermformaat.getHeight() * 0.04);
        RowConstraints linksRij6 = new RowConstraints();
        linksRij6.setPrefHeight(schermformaat.getHeight() * 0.03);

        linksKnoppenGrid.getRowConstraints().addAll(linksRij0, linksRij1, linksRij2, linksRij3, linksRij4, linksRij5, linksRij6);

        ColumnConstraints linksKolom0 = new ColumnConstraints();
        linksKolom0.setPrefWidth(schermformaat.getWidth() * 0.05);
        ColumnConstraints linksKolom1 = new ColumnConstraints();
        linksKolom1.setPrefWidth(schermformaat.getWidth() * 0.01);
        ColumnConstraints linksKolom2 = new ColumnConstraints();
        linksKolom2.setPrefWidth(schermformaat.getWidth() * 0.02);
        ColumnConstraints linksKolom3 = new ColumnConstraints();
        linksKolom3.setPrefWidth(schermformaat.getWidth() * 0.02);
        linksKnoppenGrid.getColumnConstraints().addAll(linksKolom0, linksKolom1, linksKolom2, linksKolom3);

        StackPane linksStack = new StackPane();
        Image linksImg = new Image("Images/links.png", Math.ceil(schermformaat.getWidth() * 0.10), USE_PREF_SIZE, true, true);
        ImageView linksView = new ImageView(linksImg);

        List<Image> lampImages = new ArrayList<>();
        lampImages.add(new Image("Images/lampIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        lampImages.add(new Image("Images/lampGIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        ImageView lampView = new ImageView(lampImages.get(0));
        iconViewsTable.put("lamp", lampView);
        imageListTable.put("lamp", lampImages);

        lampView.setOnMouseClicked(event -> {
            HuidigFormulier.setSchakelaars(toggleRandIcoon(HuidigFormulier.getSchakelaars()));
        });//debug
        linksKnoppenGrid.add(lampView, 2, 1, 2, 1);

        List<Image> druppelImages = new ArrayList<>();
        druppelImages.add(new Image("Images/druppelIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        druppelImages.add(new Image("Images/druppelGIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        ImageView druppelView = new ImageView(druppelImages.get(0));
        iconViewsTable.put("druppel", druppelView);
        imageListTable.put("druppel", druppelImages);

        druppelView.setOnMouseClicked(event -> {
            HuidigFormulier.setVloeistoffen(toggleRandIcoon(HuidigFormulier.getVloeistoffen()));
        });//debug
        linksKnoppenGrid.add(druppelView, 1, 3, 2, 1);

        List<Image> bandImages = new ArrayList<>();
        bandImages.add(new Image("Images/bandIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        bandImages.add(new Image("Images/bandGIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        ImageView bandView = new ImageView(bandImages.get(0));
        iconViewsTable.put("band", bandView);
        imageListTable.put("band", bandImages);

        bandView.setOnMouseClicked(event -> {
            HuidigFormulier.setBanden(toggleRandIcoon(HuidigFormulier.getBanden()));
        });//debug
        linksKnoppenGrid.add(bandView, 2, 5, 2, 1);

        linksStack.getChildren().addAll(linksView, linksKnoppenGrid);
        linksStack.setAlignment(Pos.CENTER_RIGHT);

        add(linksStack, 0, 2);

        linksView.setOnMouseClicked(event -> {
            System.out.println("linkshoek");
        });//debug
        //einde links

        //hoek rechts
        GridPane rechtsKnoppenGrid = new GridPane();
        rechtsKnoppenGrid.setAlignment(Pos.CENTER);
//        rechtsKnoppenGrid.gridLinesVisibleProperty().setValue(Boolean.TRUE);

        RowConstraints rechtsRij0 = new RowConstraints();
        rechtsRij0.setPrefHeight(schermformaat.getHeight() * 0.03);
        RowConstraints rechtsRij1 = new RowConstraints();
        rechtsRij1.setPrefHeight(schermformaat.getHeight() * 0.04);
        RowConstraints rechtsRij2 = new RowConstraints();
        rechtsRij2.setPrefHeight(schermformaat.getHeight() * HoekenratioFix);
        RowConstraints rechtsRij3 = new RowConstraints();
        rechtsRij3.setPrefHeight(schermformaat.getHeight() * 0.04);
        RowConstraints rechtsRij4 = new RowConstraints();
        rechtsRij4.setPrefHeight(schermformaat.getHeight() * HoekenratioFix);
        RowConstraints rechtsRij5 = new RowConstraints();
        rechtsRij5.setPrefHeight(schermformaat.getHeight() * 0.04);
        RowConstraints rechtsRij6 = new RowConstraints();
        rechtsRij6.setPrefHeight(schermformaat.getHeight() * 0.03);

        rechtsKnoppenGrid.getRowConstraints().addAll(rechtsRij0, rechtsRij1, rechtsRij2, rechtsRij3, rechtsRij4, rechtsRij5, rechtsRij6);

        ColumnConstraints rechtsKolom1 = new ColumnConstraints();
        rechtsKolom1.setPrefWidth(schermformaat.getWidth() * 0.01);
        ColumnConstraints rechtsKolom2 = new ColumnConstraints();
        rechtsKolom2.setPrefWidth(schermformaat.getWidth() * 0.02);
        ColumnConstraints rechtsKolom3 = new ColumnConstraints();
        rechtsKolom3.setPrefWidth(schermformaat.getWidth() * 0.05);
        rechtsKnoppenGrid.getColumnConstraints().addAll(rechtsKolom1, rechtsKolom2, rechtsKolom3);

        List<Image> tankImages = new ArrayList<>();
        tankImages.add(new Image("Images/tankIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        tankImages.add(new Image("Images/tankGIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        ImageView tankView = new ImageView(tankImages.get(0));
        iconViewsTable.put("tank", tankView);
        imageListTable.put("tank", tankImages);

        tankView.setOnMouseClicked(event -> {
            HuidigFormulier.setTanken(toggleRandIcoon(HuidigFormulier.getTanken()));
        });//debug

        rechtsKnoppenGrid.add(tankView, 0, 1, 2, 1);

        List<Image> gpsImages = new ArrayList<>();
        gpsImages.add(new Image("Images/gpsIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        gpsImages.add(new Image("Images/gpsGIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        ImageView gpsView = new ImageView(gpsImages.get(0));
        iconViewsTable.put("gps", gpsView);
        imageListTable.put("gps", gpsImages);

        gpsView.setOnMouseClicked(event -> {
            HuidigFormulier.setGps(toggleRandIcoon(HuidigFormulier.getGps()));
        });//debug

        rechtsKnoppenGrid.add(gpsView, 1, 3, 2, 1);

        List<Image> stopImages = new ArrayList<>();
        stopImages.add(new Image("Images/stopIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        stopImages.add(new Image("Images/stopGIcoon.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true));
        ImageView stopView = new ImageView(stopImages.get(0));
        iconViewsTable.put("stop", stopView);
        imageListTable.put("stop", stopImages);

        stopView.setOnMouseClicked(event -> {
            HuidigFormulier.setStop(toggleRandIcoon(HuidigFormulier.getStop()));
        });//debug
        rechtsKnoppenGrid.add(stopView, 0, 5, 2, 1);

        StackPane rechtsStack = new StackPane();
        Image rechtsImg = new Image("Images/rechts.png", Math.ceil(schermformaat.getWidth() * 0.10), USE_PREF_SIZE, true, true);
        ImageView rechtsView = new ImageView(rechtsImg);
        rechtsStack.getChildren().addAll(rechtsView, rechtsKnoppenGrid);
        rechtsStack.setAlignment(Pos.CENTER_LEFT);
        add(rechtsStack, 4, 2);

        //einde rechts
        //home en opmerkingen
        HBox homeBox = new HBox();
        homeBox.setAlignment(Pos.CENTER);
        Image homeKnopImg = new Image("Images/homeKnop.png", Math.ceil(schermformaat.getWidth() * 0.10), USE_PREF_SIZE, true, true);
        ImageView homeKnopView = new ImageView(homeKnopImg);
        homeBox.getChildren().addAll(homeKnopView);
        add(homeBox, 4, 3);
        homeKnopView.setOnMouseClicked(event -> {
//            System.exit(0);
            scene.setRoot(inlogPaneel);
        });

        HBox opmerkingBox = new HBox();
        opmerkingBox.setAlignment(Pos.CENTER);
        Image opmerkingKnopImg = new Image("Images/opmerkingenKnop.png", Math.ceil(schermformaat.getWidth() * 0.10), USE_PREF_SIZE, true, true);
        ImageView opmerkingKnopView = new ImageView(opmerkingKnopImg);
        opmerkingBox.getChildren().addAll(opmerkingKnopView);
        add(opmerkingBox, 0, 3);
        opmerkingKnopView.setOnMouseClicked(event -> {
            OpmerkingPaneel opmerkingPaneel = new OpmerkingPaneel(this);
            opmerkingPaneel.setScene(scene);
            scene.setRoot(opmerkingPaneel);
        });
        //einde home en opmerkingen
        update();
    }

    private void niveauMin() {
        EvaluatieFormulier HuidigFormulier = huidigeLeerling.getHuidigEvaluatieFormulier();
        int huidigNiveau = HuidigFormulier.getNiveau();

        if (huidigNiveau > 0) {
            HuidigFormulier.setNiveau(huidigNiveau - 1);
        }
    }

    private void niveauPlus() {
        EvaluatieFormulier HuidigFormulier = huidigeLeerling.getHuidigEvaluatieFormulier();
        int huidigNiveau = HuidigFormulier.getNiveau();

        if (huidigNiveau < 6) {
            HuidigFormulier.setNiveau(huidigNiveau + 1);
        }
    }

    private void toggleImg(ImageView view, List<Image> imgList) {
        int currentIndex = imgList.indexOf(view.getImage());
        if (currentIndex == 0) {
            view.setImage(imgList.get(1));
        } else if (currentIndex == 1) {
            view.setImage(imgList.get(2));
        } else {
            view.setImage(imgList.get(0));
        }
    }

    private void toggleImgRand(ImageView view, List<Image> imgList) {
        int currentIndex = imgList.indexOf(view.getImage());
        if (currentIndex == 0) {
            view.setImage(imgList.get(1));
        } else {
            view.setImage(imgList.get(0));
        }
    }

    private Evaluatie toggleRandIcoon(Evaluatie eval) {
        if (Evaluatie.WIT.equals(eval)) {
            return Evaluatie.GROEN;
        } else {
            return Evaluatie.WIT;
        }
    }

    private Evaluatie toggleTopIcoon(Evaluatie eval) {
        if (Evaluatie.WIT.equals(eval)) {
            return Evaluatie.ROOD;
        } else if (Evaluatie.ROOD.equals(eval)) {
            return Evaluatie.GROEN;
        } else if (Evaluatie.GROEN.equals(eval)) {
            return Evaluatie.WIT;
        } else {
            return Evaluatie.WIT;
        }
    }

    private void PasTopKleurAan(String key, Evaluatie eval) {
        ImageView view = iconViewsTable.get(key);
        List<Image> lijst = imageListTable.get(key);

        if (Evaluatie.WIT.equals(eval)) {
            view.setImage(lijst.get(0));
        } else if (Evaluatie.ROOD.equals(eval)) {
            view.setImage(lijst.get(1));
        } else if (Evaluatie.GROEN.equals(eval)) {
            view.setImage(lijst.get(2));
        }
    }

    private void PasRandKleurAan(String key, Evaluatie eval) {
        ImageView view = iconViewsTable.get(key);
        List<Image> lijst = imageListTable.get(key);

        if (Evaluatie.WIT.equals(eval)) {
            view.setImage(lijst.get(0));
        } else if (Evaluatie.GROEN.equals(eval)) {
            view.setImage(lijst.get(1));
        }
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setSceneRoot(Parent par) {
        this.scene.setRoot(par);
    }

    @Override
    public void update() {
        HuidigFormulier = huidigeLeerling.getHuidigEvaluatieFormulier();
        EvaluatieFormulier formulier = huidigeLeerling.getHuidigEvaluatieFormulier();
        //top
        PasTopKleurAan("stad", formulier.getStad());
        PasTopKleurAan("rotonde", formulier.getRotonde());
        PasTopKleurAan("rijstroken", formulier.getRijstroken());
        PasTopKleurAan("snelweg", formulier.getAutosnelweg());
        //links
        PasRandKleurAan("lamp", formulier.getSchakelaars());
        PasRandKleurAan("druppel", formulier.getVloeistoffen());
        PasRandKleurAan("band", formulier.getBanden());

        //rechts
        PasRandKleurAan("gps", formulier.getGps());
        PasRandKleurAan("stop", formulier.getStop());
        PasRandKleurAan("tank", formulier.getTanken());
        //niveau
        niveauCenterView.setImage(niveauImages.get(formulier.getNiveau()));
    }

    public InlogPaneel getInlogPaneel() {
        return inlogPaneel;
    }

    public void setInlogPaneel(InlogPaneel inlogPaneel) {
        this.inlogPaneel = inlogPaneel;
    }

    public Leerling getHuidigeLeerling() {
        return huidigeLeerling;
    }

    public void setHuidigeLeerling(Leerling huidigeLeerling) {
        this.huidigeLeerling = huidigeLeerling;
    }

}
