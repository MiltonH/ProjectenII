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
import javafx.scene.Group;
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
    private InlogPaneel inlogPaneel;
    private Leerling huidigeLeerling;
    private Rectangle2D schermformaat;

    private Hashtable<String, ImageView> iconViewsTable;
    private Hashtable<String, List> imageListTable;
    private List<ImageView> testImageViews;
    private ImageView niveauCenterView;
    private List<Image> niveauImages;
    private EvaluatieFormulier HuidigFormulier;

    public HoofdPaneel(Leerling leerling) {
        //maingrid indelen
        huidigeLeerling = leerling;
        huidigeLeerling.addView(this);

        iconViewsTable = new Hashtable<>();
        imageListTable = new Hashtable<>();
        testImageViews = new ArrayList<>();
        HuidigFormulier = huidigeLeerling.getHuidigEvaluatieFormulier();

        setId("hoofdPaneelBG");
//        gridLinesVisibleProperty().set(true);

        ColumnConstraints kolom0 = new ColumnConstraints();
        kolom0.setPercentWidth(15);
        ColumnConstraints kolom1 = new ColumnConstraints();
        kolom1.setPercentWidth(28);
        ColumnConstraints kolom2 = new ColumnConstraints();
        kolom2.setPercentWidth(14);
        ColumnConstraints kolom3 = new ColumnConstraints();
        kolom3.setPercentWidth(28);
        ColumnConstraints kolom4 = new ColumnConstraints();
        kolom4.setPercentWidth(15);

        getColumnConstraints().addAll(kolom0, kolom1, kolom2, kolom3, kolom4);

        RowConstraints rij0 = new RowConstraints();
        rij0.setPercentHeight(23);
        RowConstraints rij1 = new RowConstraints();
        rij1.setPercentHeight(0);
        RowConstraints rij2 = new RowConstraints();
        rij2.setPercentHeight(57);
        RowConstraints rij3 = new RowConstraints();
        rij3.setPercentHeight(20);

        getRowConstraints().addAll(rij0, rij1, rij2, rij3);

        //einde grid indeling
        schermformaat = Screen.getPrimary().getVisualBounds();

//        //kap
//        HBox kapBox = new HBox();
//        StackPane kapStack = new StackPane();
//        Image kapImg = new Image("Images/kap.png", Math.ceil(schermformaat.getWidth()), USE_PREF_SIZE, true, true);
//        ImageView kapView = new ImageView(kapImg);
//        kapBox.setAlignment(Pos.TOP_CENTER);
//        kapStack.setAlignment(Pos.TOP_CENTER);
//        kapStack.getChildren().addAll(kapView);
//        kapBox.getChildren().addAll(kapStack);
//
//        add(kapBox, 0, 0, 5, 3);
//
//        kapView.setOnMouseClicked(event -> {
//            System.out.println("kap");
//        });//debug
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
        Image centerImg = new Image("Images/center2.png", Math.ceil(schermformaat.getWidth() * 0.26), USE_PREF_SIZE, true, true);
        ImageView centerView = new ImageView(centerImg);
        Image centerKnopImg = new Image("Images/centerKnopHoofd.png", Math.ceil(schermformaat.getWidth() * 0.10), USE_PREF_SIZE, true, true);
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

        Image wijzerplaat = new Image("Images/Wijzerplaat.png", Math.ceil(schermformaat.getWidth() * 0.28), USE_PREF_SIZE, true, true);
        Image wijzerStand1 = new Image("Images/WijzerStand1.png", Math.ceil(schermformaat.getWidth() * 0.28), USE_PREF_SIZE, true, true);
        Image wijzerStand2 = new Image("Images/WijzerStand2.png", Math.ceil(schermformaat.getWidth() * 0.28), USE_PREF_SIZE, true, true);
        Image wijzerStand3 = new Image("Images/WijzerStand3.png", Math.ceil(schermformaat.getWidth() * 0.28), USE_PREF_SIZE, true, true);
        Image wijzerstuur = new Image("Images/rijTechKnopHoofd.png", Math.ceil(schermformaat.getWidth() * 0.28), USE_PREF_SIZE, true, true);
        Image verkeersTechKnop = new Image("Images/verkeersTechKnopHoofd.png", Math.ceil(schermformaat.getWidth() * 0.28), USE_PREF_SIZE, true, true);
        ImageView wijzeplaat1Stand = new ImageView(wijzerStand1);
        ImageView wijzeplaat2Stand = new ImageView(wijzerStand1);
        ImageView wijzerplaat1View = new ImageView(wijzerplaat);
        ImageView wijzerplaat2View = new ImageView(wijzerplaat);
        ImageView wijzerstuurView = new ImageView(wijzerstuur);
        ImageView verkeersTechKnopView = new ImageView(verkeersTechKnop);

        wijzerplaat1Stack.getChildren().addAll(wijzerplaat1View, wijzerstuurView, wijzeplaat1Stand);
        wijzerplaat2Stack.getChildren().addAll(wijzerplaat2View, verkeersTechKnopView, wijzeplaat2Stand);
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
        wijzerstuurView.setOnMouseClicked(event -> {
            RijTechniekBase rijtechniekenBase = new RijTechniekBase(this);
            scene.setRoot(rijtechniekenBase);
        });//debug
        verkeersTechKnopView.setOnMouseClicked(event -> {
            VerkeersTechniekBase verkeersTechniekBase = new VerkeersTechniekBase(this);
            scene.setRoot(verkeersTechniekBase);
        });//debug

        //eind wijzerplaaten
        //CenterTopBalk
        HBox centerTopBox = new HBox();
        StackPane centerTopStack = new StackPane();
        centerTopBox.setAlignment(Pos.CENTER);
        Image centerTopImg = new Image("Images/CenterTop2.png", Math.ceil(schermformaat.getWidth() * 0.61), USE_PREF_SIZE, true, true);
        ImageView centerTopView = new ImageView(centerTopImg);

        HBox centerTopKnoppen = new HBox();
        centerTopKnoppen.setAlignment(Pos.CENTER);
        centerTopKnoppen.setSpacing(Math.ceil(schermformaat.getWidth() * 0.03));

        List<Image> rijstrokenImages = new ArrayList<>();
        rijstrokenImages.add(new Image("Images/rijstrokenIcoon.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
        rijstrokenImages.add(new Image("Images/rijstrokenRIcoon.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
        rijstrokenImages.add(new Image("Images/rijstrokenGIcoon.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
        ImageView rijstrokenView = new ImageView(rijstrokenImages.get(0));
        iconViewsTable.put("rijstroken", rijstrokenView);
        imageListTable.put("rijstroken", rijstrokenImages);

        rijstrokenView.setOnMouseClicked(event -> {
            HuidigFormulier.setRijstroken(toggleTopIcoon(HuidigFormulier.getRijstroken()));
        });//debug

        List<Image> rotondeImages = new ArrayList<>();
        rotondeImages.add(new Image("Images/rotondeIcoon.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
        rotondeImages.add(new Image("Images/rotondeRIcoon.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
        rotondeImages.add(new Image("Images/rotondeGIcoon.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
        ImageView rotondeView = new ImageView(rotondeImages.get(0));
        iconViewsTable.put("rotonde", rotondeView);
        imageListTable.put("rotonde", rotondeImages);

        rotondeView.setOnMouseClicked(event -> {
            HuidigFormulier.setRotonde(toggleTopIcoon(HuidigFormulier.getRotonde()));
        });//debug

        List<Image> snelwegImages = new ArrayList<>();
        snelwegImages.add(new Image("Images/snelwegIcoon.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
        snelwegImages.add(new Image("Images/snelwegRIcoon.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
        snelwegImages.add(new Image("Images/snelwegGIcoon.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
        ImageView snelwegView = new ImageView(snelwegImages.get(0));
        iconViewsTable.put("snelweg", snelwegView);
        imageListTable.put("snelweg", snelwegImages);

        snelwegView.setOnMouseClicked(event -> {
            HuidigFormulier.setAutosnelweg(toggleTopIcoon(HuidigFormulier.getAutosnelweg()));
        });//debug

        List<Image> stadImages = new ArrayList<>();
        stadImages.add(new Image("Images/stadIcoon.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
        stadImages.add(new Image("Images/stadRIcoon.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
        stadImages.add(new Image("Images/stadGIcoon.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
        ImageView stadView = new ImageView(stadImages.get(0));
        iconViewsTable.put("stad", stadView);
        imageListTable.put("stad", stadImages);

        stadView.setOnMouseClicked(event -> {
            HuidigFormulier.setStad(toggleTopIcoon(HuidigFormulier.getStad()));
        });//debug

        centerTopKnoppen.getChildren().addAll(rotondeView, rijstrokenView, stadView, snelwegView);
        centerTopStack.getChildren().addAll(centerTopView, centerTopKnoppen);
        centerTopBox.getChildren().add(centerTopStack);

        add(centerTopBox, 1, 0, 3, 1);
        //einde CenterTopBalk

        //BottomBox
        HBox bottomBox = new HBox();
        StackPane bottomStack = new StackPane();
        bottomStack.setAlignment(Pos.BOTTOM_CENTER);
        bottomBox.setAlignment(Pos.BOTTOM_CENTER);
        Image bottomBoxImg = new Image("Images/BottomBox.png", Math.ceil(schermformaat.getWidth() * 0.50), USE_PREF_SIZE, true, true);
        ImageView bottomBoxView = new ImageView(bottomBoxImg);
        bottomBox.getChildren().add(bottomStack);

        Image bottomTest = new Image("Images/BottomTest.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true);
        Image bottomTest2 = new Image("Images/BottomTest2.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true);
        Image bottomTest3 = new Image("Images/BottomTest3.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true);
        ImageView bottomTest1View = new ImageView(bottomTest);
        bottomTest1View.setOnMouseClicked(event -> {
            //
        });
        ImageView bottomTest2View = new ImageView(bottomTest2);
        bottomTest2View.setOnMouseClicked(event -> {
            if (huidigeLeerling.getHuidigEvaluatieFormulierNr() == 0) {
                huidigeLeerling.volgendFormulier();
            }
            update();
        });
        ImageView bottomTest3View = new ImageView(bottomTest3);
        bottomTest3View.setOnMouseClicked(event -> {
            if (huidigeLeerling.getHuidigEvaluatieFormulierNr() == 1) {
                huidigeLeerling.volgendFormulier();
            }
            update();
        });
        testImageViews.add(bottomTest1View);
        testImageViews.add(bottomTest2View);
        testImageViews.add(bottomTest3View);

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

        Image niveauBoxImg = new Image("Images/niveauBox.png", Math.ceil(schermformaat.getWidth() * 0.30), USE_PREF_SIZE, true, true);
        ImageView niveauBoxView = new ImageView(niveauBoxImg);

        StackPane niveauStack = new StackPane();
        HBox niveauHbox = new HBox();
        niveauHbox.setAlignment(Pos.CENTER);
        niveauHbox.setSpacing(Math.ceil(schermformaat.getWidth() * 0.01));

        Image niveauMinImg = new Image("Images/niveaumin.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true);
        ImageView niveauMinView = new ImageView(niveauMinImg);

        Image niveauPlusImg = new Image("Images/niveauplus.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true);
        ImageView niveauPlusView = new ImageView(niveauPlusImg);
        niveauImages = new ArrayList<>();
        niveauImages.add(new Image("Images/niveau1.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauImages.add(new Image("Images/niveau2.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauImages.add(new Image("Images/niveau3.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauImages.add(new Image("Images/niveau4.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauImages.add(new Image("Images/niveau5.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauImages.add(new Image("Images/niveau6.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauImages.add(new Image("Images/niveau7.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauImages.add(new Image("Images/niveau8.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauImages.add(new Image("Images/niveau9.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauImages.add(new Image("Images/niveau10.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauImages.add(new Image("Images/niveau11.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauCenterView = new ImageView(niveauImages.get(0));

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
        linksRij0.setPercentHeight(28);
        RowConstraints linksRij1 = new RowConstraints();
        linksRij1.setPercentHeight(20);
        RowConstraints linksRij2 = new RowConstraints();
        linksRij2.setPercentHeight(12);
        RowConstraints linksRij3 = new RowConstraints();
        linksRij3.setPercentHeight(20);
        RowConstraints linksRij4 = new RowConstraints();
        linksRij4.setPercentHeight(12);
        RowConstraints linksRij5 = new RowConstraints();
        linksRij5.setPercentHeight(20);
        RowConstraints linksRij6 = new RowConstraints();
        linksRij6.setPercentHeight(28);

        linksKnoppenGrid.getRowConstraints().addAll(linksRij0, linksRij1, linksRij2, linksRij3, linksRij4, linksRij5, linksRij6);

        ColumnConstraints linksKolom0 = new ColumnConstraints();
        linksKolom0.setPercentWidth(16);
        ColumnConstraints linksKolom1 = new ColumnConstraints();
        linksKolom1.setPercentWidth(10);
        ColumnConstraints linksKolom2 = new ColumnConstraints();
        linksKolom2.setPercentWidth(10);
        ColumnConstraints linksKolom3 = new ColumnConstraints();
        linksKolom3.setPercentWidth(30);
        ColumnConstraints linksKolom4 = new ColumnConstraints();
        linksKolom4.setPercentWidth(34);
        linksKnoppenGrid.getColumnConstraints().addAll(linksKolom0, linksKolom1, linksKolom2, linksKolom3, linksKolom4);

        StackPane linksStack = new StackPane();
        Image linksImg = new Image("Images/links2.png", Math.ceil(schermformaat.getWidth() * 0.14), USE_PREF_SIZE, true, true);
        ImageView linksView = new ImageView(linksImg);

        List<Image> lampImages = new ArrayList<>();
        lampImages.add(new Image("Images/lampIcoon.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true));
        lampImages.add(new Image("Images/lampGIcoon.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true));
        ImageView lampView = new ImageView(lampImages.get(0));
        iconViewsTable.put("lamp", lampView);
        imageListTable.put("lamp", lampImages);

        lampView.setOnMouseClicked(event -> {
            HuidigFormulier.setSchakelaars(toggleRandIcoon(HuidigFormulier.getSchakelaars()));
        });//debug
        linksKnoppenGrid.add(lampView, 2, 1, 3, 1);

        List<Image> druppelImages = new ArrayList<>();
        druppelImages.add(new Image("Images/druppelIcoon.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true));
        druppelImages.add(new Image("Images/druppelGIcoon.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true));
        ImageView druppelView = new ImageView(druppelImages.get(0));
        iconViewsTable.put("druppel", druppelView);
        imageListTable.put("druppel", druppelImages);

        druppelView.setOnMouseClicked(event -> {
            HuidigFormulier.setVloeistoffen(toggleRandIcoon(HuidigFormulier.getVloeistoffen()));
        });//debug
        linksKnoppenGrid.add(druppelView, 1, 3, 3, 1);

        List<Image> bandImages = new ArrayList<>();
        bandImages.add(new Image("Images/bandIcoon.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true));
        bandImages.add(new Image("Images/bandGIcoon.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true));
        ImageView bandView = new ImageView(bandImages.get(0));
        iconViewsTable.put("band", bandView);
        imageListTable.put("band", bandImages);

        bandView.setOnMouseClicked(event -> {
            HuidigFormulier.setBanden(toggleRandIcoon(HuidigFormulier.getBanden()));
        });//debug
        linksKnoppenGrid.add(bandView, 3, 5, 3, 1);

        linksStack.getChildren().addAll(linksView, linksKnoppenGrid);
        linksStack.setAlignment(Pos.CENTER_RIGHT);

        add(linksStack, 0, 2);

        linksView.setOnMouseClicked(event -> {
            System.out.println("linkshoek");
        });//debug
        //einde links

        //hoek rechts
        GridPane rechtsKnoppenGrid = new GridPane();
        rechtsKnoppenGrid.setAlignment(Pos.CENTER_RIGHT);
//        rechtsKnoppenGrid.gridLinesVisibleProperty().setValue(Boolean.TRUE);

        RowConstraints rechtsRij0 = new RowConstraints();
        rechtsRij0.setPercentHeight(28);
        RowConstraints rechtsRij1 = new RowConstraints();
        rechtsRij1.setPercentHeight(20);
        RowConstraints rechtsRij2 = new RowConstraints();
        rechtsRij2.setPercentHeight(12);
        RowConstraints rechtsRij3 = new RowConstraints();
        rechtsRij3.setPercentHeight(20);
        RowConstraints rechtsRij4 = new RowConstraints();
        rechtsRij4.setPercentHeight(12);
        RowConstraints rechtsRij5 = new RowConstraints();
        rechtsRij5.setPercentHeight(20);
        RowConstraints rechtsRij6 = new RowConstraints();
        rechtsRij6.setPercentHeight(28);

        rechtsKnoppenGrid.getRowConstraints().addAll(rechtsRij0, rechtsRij1, rechtsRij2, rechtsRij3, rechtsRij4, rechtsRij5, rechtsRij6);

        ColumnConstraints rechtsKolom1 = new ColumnConstraints();
        rechtsKolom1.setPercentWidth(34);
        ColumnConstraints rechtsKolom2 = new ColumnConstraints();
        rechtsKolom2.setPercentWidth(16);
//        rechtsKolom2.setHalignment(HPos.RIGHT);
        ColumnConstraints rechtsKolom6 = new ColumnConstraints();
        rechtsKolom6.setPercentWidth(14);
        ColumnConstraints rechtsKolom3 = new ColumnConstraints();
        rechtsKolom3.setPercentWidth(10);
        ColumnConstraints rechtsKolom4 = new ColumnConstraints();
        rechtsKolom4.setPercentWidth(10);
        ColumnConstraints rechtsKolom5 = new ColumnConstraints();
        rechtsKolom5.setPercentWidth(16);
        rechtsKnoppenGrid.getColumnConstraints().addAll(rechtsKolom1, rechtsKolom2, rechtsKolom6, rechtsKolom3, rechtsKolom4, rechtsKolom5);

        List<Image> tankImages = new ArrayList<>();
        tankImages.add(new Image("Images/tankIcoon.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true));
        tankImages.add(new Image("Images/tankGIcoon.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true));
        ImageView tankView = new ImageView(tankImages.get(0));
        iconViewsTable.put("tank", tankView);
        imageListTable.put("tank", tankImages);

        tankView.setOnMouseClicked(event -> {
            HuidigFormulier.setTanken(toggleRandIcoon(HuidigFormulier.getTanken()));
        });//debug

        rechtsKnoppenGrid.add(tankView, 1, 1, 3, 1);

        List<Image> gpsImages = new ArrayList<>();
        gpsImages.add(new Image("Images/gpsIcoon.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true));
        gpsImages.add(new Image("Images/gpsGIcoon.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true));
        ImageView gpsView = new ImageView(gpsImages.get(0));
        iconViewsTable.put("gps", gpsView);
        imageListTable.put("gps", gpsImages);

        gpsView.setOnMouseClicked(event -> {
            HuidigFormulier.setGps(toggleRandIcoon(HuidigFormulier.getGps()));
        });//debug

        rechtsKnoppenGrid.add(gpsView, 2, 3, 3, 1);

        List<Image> stopImages = new ArrayList<>();
        stopImages.add(new Image("Images/stopIcoon.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true));
        stopImages.add(new Image("Images/stopGIcoon.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true));
        ImageView stopView = new ImageView(stopImages.get(0));
        iconViewsTable.put("stop", stopView);
        imageListTable.put("stop", stopImages);

        stopView.setOnMouseClicked(event -> {
            HuidigFormulier.setStop(toggleRandIcoon(HuidigFormulier.getStop()));
        });//debug
        rechtsKnoppenGrid.add(stopView, 1, 5, 4, 1);

        StackPane rechtsStack = new StackPane();
        rechtsStack.setPrefWidth(schermformaat.getWidth() * 0.15);
        Image rechtsImg = new Image("Images/rechts2.png", Math.ceil(schermformaat.getWidth() * 0.14), USE_PREF_SIZE, true, true);
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

        if (huidigNiveau < 10) {
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

        //testen
        Image bottomTestBezig = new Image("Images/BottomTestCompleted.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true);
        Image bottomTestDone = new Image("Images/BottomTestDone.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true);
        Image bottomTestBezig2 = new Image("Images/BottomTestCompleted2.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true);
        Image bottomTestDone2 = new Image("Images/BottomTestDone2.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true);
        Image bottomTestBezig3 = new Image("Images/BottomTestCompleted3.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true);
        Image bottomTestDone3 = new Image("Images/BottomTestDone3.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true);

//        for (int i = 0; i < 3; i++) {
//            if (huidigeLeerling.getHuidigEvaluatieFormulierNr() > i) {
//                testImageViews.get(i).setImage(bottomTestDone);
//            }
//            if (huidigeLeerling.getHuidigEvaluatieFormulierNr() == i) {
//                testImageViews.get(i).setImage(bottomTestBezig);
//            }
//        }
        if (huidigeLeerling.getHuidigEvaluatieFormulierNr() == 0) {
            testImageViews.get(0).setImage(bottomTestBezig);
        } else if (huidigeLeerling.getHuidigEvaluatieFormulierNr() == 1) {
            testImageViews.get(0).setImage(bottomTestDone);
            testImageViews.get(1).setImage(bottomTestBezig2);
        } else if (huidigeLeerling.getHuidigEvaluatieFormulierNr() == 2) {
            testImageViews.get(0).setImage(bottomTestDone);
            testImageViews.get(1).setImage(bottomTestDone2);
            testImageViews.get(2).setImage(bottomTestBezig3);
        }
        huidigeLeerling.updateLastEdit();
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
