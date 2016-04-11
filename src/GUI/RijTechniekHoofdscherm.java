package GUI;

import domain.View;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
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

public class RijTechniekHoofdscherm extends GridPane  implements View{

    RijTechniekBase base;
    int integer = 0;
    Rectangle2D schermformaat = Screen.getPrimary().getVisualBounds();
    double maxWidth = schermformaat.getWidth() * 0.62;

    public RijTechniekHoofdscherm(RijTechniekBase base) {
        setId("rijTechniekHoofdschermPaneel");
        this.base = base;
        base.getHoofdpanel().getHuidigeLeerling().addView(this);
        //einde grid indeling
//        Rectangle2D schermformaat = Screen.getPrimary().getVisualBounds();
//        double maxWidth = schermformaat.getWidth() * 0.62;

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
        RijTechniekStuurKnop rijTechniekStuurKnop = new RijTechniekStuurKnop();
        imageDropperBoven(afbStuur, 3, 1, rijTechniekStuurKnop);

        //versnelling ----
        RijTechniekVersnellingKnop rijTechniekVersnellingKnop = new RijTechniekVersnellingKnop();
        imageDropperBoven(afbVersnelling, 4, 1, rijTechniekVersnellingKnop);
        

        //kijken ----
        RijTechniekKijkenKnop rijTechniekKijkenKnop = new RijTechniekKijkenKnop(this.base);
        imageDropperBoven(afbKijken, 5, 1, rijTechniekKijkenKnop);

        //helling ----
        imageDropperBoven(afbPijl, 6, 1, this);

        //zithouding ----
        RijTechniekZithoudingKnop rijTechniekZithoudingKnop = new RijTechniekZithoudingKnop();
        imageDropperBoven(afbZithouding, 7, 1, rijTechniekZithoudingKnop);

        //knoppen onder
        Image afbAcht = new Image("Images/achtje.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image afbReverse = new Image("Images/achteruitrijden.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image afbGarage = new Image("Images/garage.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image afbDraaiPijltje = new Image("Images/draaipijl.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        Image afbParkeren = new Image("Images/parkeren.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        
        //acht ----
        imageDropperOnder(afbAcht, 2, 4);
        
        //reverse ----
        imageDropperOnder(afbReverse, 3, 4);
        
        //garage ----
        imageDropperOnder(afbGarage, 4, 4);
        
        //draaipijltje ----
        imageDropperOnder(afbDraaiPijltje, 5, 4);
        
        //parkeren ----
        imageDropperOnder(afbParkeren, 6, 4);

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

        Text textB = new Text("B");
        StackPane stackB = new StackPane();
        stackB.getChildren().addAll(rectangles.get(0), textB);
        Text textV = new Text("V");
        StackPane stackV = new StackPane();
        stackV.getChildren().addAll(rectangles.get(1), textV);
        Text textH = new Text("H");
        StackPane stackH = new StackPane();
        stackH.getChildren().addAll(rectangles.get(2), textH);
        
        pijltjeBox.getChildren().addAll(stackB, stackV, stackH);
        add(pijltjeBox, 6, 2);
        
        stackB.setOnMouseClicked(event -> {
                if (integer != 3) {
                    integer++;
                    toggleColor(rectangles.get(0), integer);
                } else {
                    integer = 0;
                    toggleColor(rectangles.get(0), integer);
                }
        });
        
        stackV.setOnMouseClicked(event -> {
                if (integer != 3) {
                    integer++;
                    toggleColor(rectangles.get(1), integer);
                } else {
                    integer = 0;
                    toggleColor(rectangles.get(1), integer);
                }
        });
        
        stackH.setOnMouseClicked(event -> {
                if (integer != 3) {
                    integer++;
                    toggleColor(rectangles.get(2), integer);
                } else {
                    integer = 0;
                    toggleColor(rectangles.get(2), integer);
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

//    private void toggleImgTop(ImageView view, List<Image> imgList) {
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
    
    private void imageDropperBoven(Image img, int kolom, int rij, GridPane pane){
//        List<Image> Images = new ArrayList<>();
//        Images.add(new Image("Images/knopVierkantW.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
//        Images.add(new Image("Images/knopVierkantR.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
//        Images.add(new Image("Images/knopVierkantO.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
//        Images.add(new Image("Images/knopVierkantG.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
        ImageView View = new ImageView(img);
        ImageView afbView = new ImageView((new Image("Images/knopVierkant.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true)));
        add(afbView, kolom, rij);
        add(View, kolom, rij);
//        View.setOnMouseClicked(event -> {
//            toggleImgTop(afbView, Images);
//        });
//        afbView.setOnMouseClicked(event -> {
//            toggleImgTop(afbView, Images);
//        });
        View.setOnMouseClicked(event -> {
            base.setContent(pane);
        });
        afbView.setOnMouseClicked(event -> {
            base.setContent(pane);
        });
    }
    
    private void imageDropperOnder(Image img, int kolom, int rij){
        List<Image> Images = new ArrayList<>();
        Images.add(new Image("Images/knopVierkantW.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true));
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

    @Override
    public void update() {
        
    }
}
