package GUI;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
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
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;

public class RijTechniekHoofdscherm extends GridPane {

    RijTechniekBase base;
    int integer = 0;

    public RijTechniekHoofdscherm(RijTechniekBase base) {
        setId("rijTechniekHoofdschermPaneel");
        this.base = base;
        //einde grid indeling
        Rectangle2D schermformaat = Screen.getPrimary().getVisualBounds();
        double maxWidth = schermformaat.getWidth() * 0.62;

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
        
        //aanmaak Box helling 
        GridPane hellingBox = new GridPane();
        hellingBox.gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0hellingBox = new ColumnConstraints();
        kolom0hellingBox.setPercentWidth(14);
        kolom0hellingBox.setHalignment(HPos.CENTER);
        ColumnConstraints kolom1hellingBox = new ColumnConstraints();
        kolom1hellingBox.setPercentWidth(24);
        kolom1hellingBox.setHalignment(HPos.CENTER);
        ColumnConstraints kolom2hellingBox = new ColumnConstraints();
        kolom2hellingBox.setPercentWidth(24);
        kolom2hellingBox.setHalignment(HPos.CENTER);
        ColumnConstraints kolom3hellingBox = new ColumnConstraints();
        kolom3hellingBox.setPercentWidth(24);
        kolom3hellingBox.setHalignment(HPos.CENTER);
        ColumnConstraints kolom4hellingBox = new ColumnConstraints();
        kolom4hellingBox.setPercentWidth(14);
        kolom4hellingBox.setHalignment(HPos.CENTER);
        hellingBox.getColumnConstraints().addAll(kolom0hellingBox, kolom1hellingBox, kolom2hellingBox, kolom3hellingBox, kolom4hellingBox);

        RowConstraints rij0hellingBox = new RowConstraints();
        rij0hellingBox.setPercentHeight(100);
        rij0hellingBox.setValignment(VPos.CENTER);
        hellingBox.getRowConstraints().addAll(rij0hellingBox);

        //Knoppen boven 
        Image knopVierkant = new Image("Images/knopVierkant.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true);
        Image afbRem = new Image("Images/rem.png", Math.ceil(maxWidth * 0.11), USE_PREF_SIZE, true, true);
        Image afbKoppeling = new Image("Images/koppeling.png", Math.ceil(maxWidth * 0.11), USE_PREF_SIZE, true, true);
        Image afbStuur = new Image("Images/Stuur.png", Math.ceil(maxWidth * 0.11), USE_PREF_SIZE, true, true);
        Image afbVersnelling = new Image("Images/pook_1.png", Math.ceil(maxWidth * 0.11), USE_PREF_SIZE, true, true);
        Image afbKijken = new Image("Images/Kijken.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image afbPijl = new Image("Images/pijl.png", Math.ceil(maxWidth * 0.09), USE_PREF_SIZE, true, true);
        Image afbZithouding = new Image("Images/zithouding.png", Math.ceil(maxWidth * 0.08), USE_PREF_SIZE, true, true);

        ImageView remView = new ImageView(knopVierkant);
        ImageView afbRemView = new ImageView(afbRem);
        add(remView, 1, 1);
        add(afbRemView, 1, 1);
        afbRemView.setOnMouseDragged(event -> {
            RijTechniekRemKnop rijTechniekRemKnop = new RijTechniekRemKnop();
            base.setContent(rijTechniekRemKnop);
        });
        remView.setOnMouseDragged(event -> {
            RijTechniekRemKnop rijTechniekRemKnop = new RijTechniekRemKnop();
            base.setContent(rijTechniekRemKnop);
        });

        ImageView koppelingView = new ImageView(knopVierkant);
        ImageView afbKoppelingView = new ImageView(afbKoppeling);
        add(koppelingView, 2, 1);
        add(afbKoppelingView, 2, 1);
        koppelingView.setOnMouseDragged(event -> {
            RijTechniekKoppelingKnop rijTechniekKoppelingKnop = new RijTechniekKoppelingKnop();
            base.setContent(rijTechniekKoppelingKnop);
        });
        afbKoppelingView.setOnMouseDragged(event -> {
            RijTechniekKoppelingKnop rijTechniekKoppelingKnop = new RijTechniekKoppelingKnop();
            base.setContent(rijTechniekKoppelingKnop);
        });

        ImageView stuurView = new ImageView(knopVierkant);
        ImageView afbStuurView = new ImageView(afbStuur);
        add(stuurView, 3, 1);
        add(afbStuurView, 3, 1);
        stuurView.setOnMouseDragged(event -> {
            RijTechniekStuurKnop rijTechniekStuurKnop = new RijTechniekStuurKnop();
            base.setContent(rijTechniekStuurKnop);
        });
        afbStuurView.setOnMouseDragged(event -> {
            RijTechniekStuurKnop rijTechniekStuurKnop = new RijTechniekStuurKnop();
            base.setContent(rijTechniekStuurKnop);
        });

        ImageView versnellingView = new ImageView(knopVierkant);
        ImageView afbVersnellingView = new ImageView(afbVersnelling);
        add(versnellingView, 4, 1);
        add(afbVersnellingView, 4, 1);
        versnellingView.setOnMouseDragged(event -> {
            RijTechniekVersnellingKnop rijTechniekversnellingKnop = new RijTechniekVersnellingKnop();
            base.setContent(rijTechniekversnellingKnop);
        });
        afbVersnellingView.setOnMouseDragged(event -> {
            RijTechniekVersnellingKnop rijTechniekversnellingKnop = new RijTechniekVersnellingKnop();
            base.setContent(rijTechniekversnellingKnop);
        });

        List<Image> kijkenImages = new ArrayList<>();
        kijkenImages.add(new Image("Images/knopVierkantW.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
        kijkenImages.add(new Image("Images/knopVierkantR.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
        kijkenImages.add(new Image("Images/knopVierkantO.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
        kijkenImages.add(new Image("Images/knopVierkantG.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
        ImageView kijkenView = new ImageView(afbKijken);
        ImageView afbKijkenView = new ImageView(kijkenImages.get(0));
        add(afbKijkenView, 5, 1);
        add(kijkenView, 5, 1);
        kijkenView.setOnMouseClicked(event -> {
            toggleImgTop(afbKijkenView, kijkenImages);
        });
        afbKijkenView.setOnMouseClicked(event -> {
            toggleImgTop(afbKijkenView, kijkenImages);
        });
        kijkenView.setOnMouseDragged(event -> {
            RijTechniekZithoudingKnop rijTechniekZithoudingKnop = new RijTechniekZithoudingKnop();
            base.setContent(rijTechniekZithoudingKnop);
        });
        afbKijkenView.setOnMouseDragged(event -> {
            RijTechniekZithoudingKnop rijTechniekZithoudingKnop = new RijTechniekZithoudingKnop();
            base.setContent(rijTechniekZithoudingKnop);
        });

        ImageView pijltjeView = new ImageView(knopVierkant);
        ImageView afbPijltjeView = new ImageView(afbPijl);
        add(pijltjeView, 6, 1);
        add(afbPijltjeView, 6, 1);

        List<Image> zithoudingImages = new ArrayList<>();
        zithoudingImages.add(new Image("Images/zithouding.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true));
        zithoudingImages.add(new Image("Images/zithoudingR.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true));
        zithoudingImages.add(new Image("Images/zithoudingO.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true));
        zithoudingImages.add(new Image("Images/zithoudingG.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true));
        ImageView zithoudingView = new ImageView(knopVierkant);
        ImageView afbZithoudingView = new ImageView(zithoudingImages.get(0));
        add(zithoudingView, 7, 1);
        add(afbZithoudingView, 7, 1);
        zithoudingView.setOnMouseClicked(event -> {
            toggleImgTop(afbZithoudingView, zithoudingImages);
        });
        afbZithoudingView.setOnMouseClicked(event -> {
            toggleImgTop(afbZithoudingView, zithoudingImages);
        });
        zithoudingView.setOnMouseDragged(event -> {
            RijTechniekZithoudingKnop rijTechniekZithoudingKnop = new RijTechniekZithoudingKnop();
            base.setContent(rijTechniekZithoudingKnop);
        });
        afbZithoudingView.setOnMouseDragged(event -> {
            RijTechniekZithoudingKnop rijTechniekZithoudingKnop = new RijTechniekZithoudingKnop();
            base.setContent(rijTechniekZithoudingKnop);
        });

        //knoppen onder
        List<Image> achtImages = new ArrayList<>();
        achtImages.add(new Image("Images/achtje.png", Math.ceil(schermformaat.getWidth() * 0.04), USE_PREF_SIZE, true, true));
//        achtImages.add(new Image("Images/achtjeR.png", Math.ceil(schermformaat.getWidth() * 0.04), USE_PREF_SIZE, true, true));
        achtImages.add(new Image("Images/achtjeO.png", Math.ceil(schermformaat.getWidth() * 0.04), USE_PREF_SIZE, true, true));
        achtImages.add(new Image("Images/achtjeG.png", Math.ceil(schermformaat.getWidth() * 0.04), USE_PREF_SIZE, true, true));
        ImageView achtView = new ImageView(knopVierkant);
        ImageView afbAchtView = new ImageView(achtImages.get(0));
        add(achtView, 2, 4);
        add(afbAchtView, 2, 4);
        achtView.setOnMouseClicked(event -> {
            toggleImg(afbAchtView, achtImages);
        });
        afbAchtView.setOnMouseClicked(event -> {
            toggleImg(afbAchtView, achtImages);
        });

        List<Image> reverseImages = new ArrayList<>();
        reverseImages.add(new Image("Images/achteruitrijden.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
//        reverseImages.add(new Image("Images/achteruitrijdenR.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
        reverseImages.add(new Image("Images/achteruitrijdenO.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
        reverseImages.add(new Image("Images/achteruitrijdenG.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
        ImageView reverseView = new ImageView(knopVierkant);
        ImageView afbReverseView = new ImageView(reverseImages.get(0));
        add(reverseView, 3, 4);
        add(afbReverseView, 3, 4);
        reverseView.setOnMouseClicked(event -> {
            toggleImg(afbReverseView, reverseImages);
        });
        afbReverseView.setOnMouseClicked(event -> {
            toggleImg(afbReverseView, reverseImages);
        });

        List<Image> garageImages = new ArrayList<>();
        garageImages.add(new Image("Images/garage.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
//        garageImages.add(new Image("Images/GarageR.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
        garageImages.add(new Image("Images/GarageO.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
        garageImages.add(new Image("Images/GarageG.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
        ImageView garageView = new ImageView(knopVierkant);
        ImageView afbGarageView = new ImageView(garageImages.get(0));
        add(garageView, 4, 4);
        add(afbGarageView, 4, 4);
        garageView.setOnMouseClicked(event -> {
            toggleImg(afbGarageView, garageImages);
        });
        afbGarageView.setOnMouseClicked(event -> {
            toggleImg(afbGarageView, garageImages);
        });

        List<Image> draaiPijltjeImages = new ArrayList<>();
        draaiPijltjeImages.add(new Image("Images/draaipijl.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
//        draaiPijltjeImages.add(new Image("Images/draaipijlR.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
        draaiPijltjeImages.add(new Image("Images/draaipijlO.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
        draaiPijltjeImages.add(new Image("Images/draaipijlG.png", Math.ceil(schermformaat.getWidth() * 0.06), USE_PREF_SIZE, true, true));
        ImageView draaiPijltjeView = new ImageView(knopVierkant);
        ImageView afbDraaiPijltjeView = new ImageView(draaiPijltjeImages.get(0));
        add(draaiPijltjeView, 5, 4);
        add(afbDraaiPijltjeView, 5, 4);
        draaiPijltjeView.setOnMouseClicked(event -> {
            toggleImg(afbDraaiPijltjeView, draaiPijltjeImages);
        });
        afbDraaiPijltjeView.setOnMouseClicked(event -> {
            toggleImg(afbDraaiPijltjeView, draaiPijltjeImages);
        });

        List<Image> parkerenImages = new ArrayList<>();
        parkerenImages.add(new Image("Images/parkeren.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true));
//        parkerenImages.add(new Image("Images/parkerenR.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true));
        parkerenImages.add(new Image("Images/parkerenO.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true));
        parkerenImages.add(new Image("Images/parkerenG.png", Math.ceil(schermformaat.getWidth() * 0.05), USE_PREF_SIZE, true, true));
        ImageView parkerenView = new ImageView(knopVierkant);
        ImageView afbParkerenView = new ImageView(parkerenImages.get(0));
        add(parkerenView, 6, 4);
        add(afbParkerenView, 6, 4);
        parkerenView.setOnMouseClicked(event -> {
            toggleImg(afbParkerenView, parkerenImages);
        });
        afbParkerenView.setOnMouseClicked(event -> {
            toggleImg(afbParkerenView, parkerenImages);
        });

        //rect variable
        double grootte = Math.ceil(maxWidth * 0.03);

        //rectangles rem
        HBox remBox = new HBox();
        remBox.setAlignment(Pos.CENTER);
        remBox.setId("rijTechniekHoofdschermBox");

        Rectangle rem1 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle rem2 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle rem3 = new Rectangle(grootte, grootte, Color.WHITE);

        remBox.getChildren().addAll(rem1, rem2, rem3);
        add(remBox, 1, 2);

        //rectangles koppeling
        HBox koppelingBox = new HBox();
        koppelingBox.setAlignment(Pos.CENTER);
        koppelingBox.setId("rijTechniekHoofdschermBox");

        Rectangle koppeling1 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle koppeling2 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle koppeling3 = new Rectangle(grootte, grootte, Color.WHITE);

        koppelingBox.getChildren().addAll(koppeling1, koppeling2, koppeling3);
        add(koppelingBox, 2, 2);

        //rectangles stuur
        HBox stuurBox = new HBox();
        stuurBox.setAlignment(Pos.CENTER);
        stuurBox.setId("rijTechniekHoofdschermBox");

        Rectangle stuur1 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle stuur2 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle stuur3 = new Rectangle(grootte, grootte, Color.WHITE);

        stuurBox.getChildren().addAll(stuur1, stuur2, stuur3);
        add(stuurBox, 3, 2);

        //rectangles versnelling
        HBox versnellingBox = new HBox();
        versnellingBox.setAlignment(Pos.CENTER);
        versnellingBox.setId("rijTechniekHoofdschermBox");

        Rectangle versnelling1 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle versnelling2 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle versnelling3 = new Rectangle(grootte, grootte, Color.WHITE);

        versnellingBox.getChildren().addAll(versnelling1, versnelling2, versnelling3);
        add(versnellingBox, 4, 2);

        //rectangles kijken
        HBox kijkenBox = new HBox();
        kijkenBox.setAlignment(Pos.CENTER);
        kijkenBox.setId("rijTechniekHoofdschermBox");

        Rectangle kijken1 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle kijken2 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle kijken3 = new Rectangle(grootte, grootte, Color.WHITE);

        kijkenBox.getChildren().addAll(kijken1, kijken2, kijken3);
        add(kijkenBox, 5, 2);

        //rectangles pijltje
        HBox pijltjeBox = new HBox();
        pijltjeBox.setAlignment(Pos.CENTER);
        pijltjeBox.setId("rijTechniekHoofdschermBox");

        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(grootte, grootte, Color.WHITE));
        rectangles.add(new Rectangle(grootte, grootte, Color.WHITE));
        rectangles.add(new Rectangle(grootte, grootte, Color.WHITE));

        pijltjeBox.getChildren().addAll(rectangles.get(0), rectangles.get(1), rectangles.get(2));
        add(pijltjeBox, 6, 2);
        
        

        Label v = new Label("V");
        v.setId("inlognaamNummerLabel");
        v.setPadding(new Insets(0, 15, 0, 5));
        Label h = new Label("H");
        h.setId("inlognaamNummerLabel");
        h.setPadding(new Insets(0, 18, 0, 0));
        Label b = new Label("B");
        b.setId("inlognaamNummerLabel");
        add(hellingBox, 6, 2);
        
        hellingBox.setOnMouseClicked(event -> {
            integer++;
            if (integer == 1) {
                hellingBox.add(v, 1, 0);
            } else if (integer == 2) {
                hellingBox.add(h, 2, 0);
            } else if (integer == 3) {
                hellingBox.add(b, 3, 0);
            } else if (integer == 4) {
                integer = 0;
                hellingBox.getChildren().removeAll(v, h, b);
            }
        });

        //rectangles zitHouding
        HBox zitHoudingBox = new HBox();
        zitHoudingBox.setAlignment(Pos.CENTER);
        zitHoudingBox.setId("rijTechniekHoofdschermBox");

        Rectangle zitHouding1 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle zitHouding2 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle zitHouding3 = new Rectangle(grootte, grootte, Color.WHITE);

        zitHoudingBox.getChildren().addAll(zitHouding1, zitHouding2, zitHouding3);
        add(zitHoudingBox, 7, 2);
    }

    private void toggleImg(ImageView view, List<Image> imgList) {
        int currentIndex = imgList.indexOf(view.getImage());
        if (currentIndex == 0) {
            view.setImage(imgList.get(1));
        } else if (currentIndex == 1) {
            view.setImage(imgList.get(2));
        } else if (currentIndex == 2) {
            view.setImage(imgList.get(0));
        }
    }
    
    private void toggleImgTop(ImageView view, List<Image> imgList) {
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
}
