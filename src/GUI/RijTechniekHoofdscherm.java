package GUI;

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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;

public class RijTechniekHoofdscherm extends GridPane {
     RijTechniekBase base;

    public RijTechniekHoofdscherm(RijTechniekBase base) {
        setId("rijTechniekHoofdschermPaneel");
        this.base=base;
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
        rij0.setPercentHeight(1);
        RowConstraints rij1 = new RowConstraints();
        rij1.setPercentHeight(20);
        RowConstraints rij2 = new RowConstraints();
        rij2.setPercentHeight(6);
        rij2.setValignment(VPos.CENTER);
        RowConstraints rij3 = new RowConstraints();
        rij3.setPercentHeight(52);
        RowConstraints rij4 = new RowConstraints();
        rij4.setPercentHeight(20);
        RowConstraints rij5 = new RowConstraints();
        rij5.setPercentHeight(1);

        getRowConstraints().addAll(rij0, rij1, rij2, rij3, rij4, rij5);

        setAlignment(Pos.CENTER);

        //Knoppen boven 
        Image knopVierkant = new Image("Images/knopVierkant.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true);
        
        ImageView remView = new ImageView(knopVierkant);
        add(remView, 1, 1);
        remView.setOnMouseClicked(event -> {
            RijTechniekRemKnop rijTechniekRemKnop = new RijTechniekRemKnop();
            base.setContent(rijTechniekRemKnop);
        });

        ImageView koppelingView = new ImageView(knopVierkant);
        add(koppelingView, 2, 1);
        koppelingView.setOnMouseClicked(event -> {
            RijTechniekKoppelingKnop rijTechniekKoppelingKnop = new RijTechniekKoppelingKnop();
            base.setContent(rijTechniekKoppelingKnop);
        });

        ImageView stuurView = new ImageView(knopVierkant);
        add(stuurView, 3, 1);
        stuurView.setOnMouseClicked(event -> {
            RijTechniekStuurKnop rijTechniekStuurKnop = new RijTechniekStuurKnop();
            base.setContent(rijTechniekStuurKnop);
        });

        ImageView versnellingView = new ImageView(knopVierkant);
        add(versnellingView, 4, 1);
        versnellingView.setOnMouseClicked(event -> {
            RijTechniekVersnellingKnop rijTechniekversnellingKnop = new RijTechniekVersnellingKnop();
            base.setContent(rijTechniekversnellingKnop);
        });

        ImageView kijkenView = new ImageView(knopVierkant);
        add(kijkenView, 5, 1);
        kijkenView.setOnMouseClicked(event -> {
            RijTechniekKijkenKnop rijTechniekKijkenKnop = new RijTechniekKijkenKnop();
            base.setContent(rijTechniekKijkenKnop);
        });

        ImageView pijltjeView = new ImageView(knopVierkant);
        add(pijltjeView, 6, 1);

        ImageView zitHoudingView = new ImageView(knopVierkant);
        add(zitHoudingView, 7, 1);
        
        //knoppen onder
        ImageView achtView = new ImageView(knopVierkant);
        add(achtView, 2, 4);

        ImageView reverseView = new ImageView(knopVierkant);
        add(reverseView, 3, 4);

        ImageView garageView = new ImageView(knopVierkant);
        add(garageView, 4, 4);

        ImageView draaiPijltjeView = new ImageView(knopVierkant);
        add(draaiPijltjeView, 5, 4);

        ImageView parkerenView = new ImageView(knopVierkant);
        add(parkerenView, 6, 4);
        
        
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

        //rectangles rem
        HBox pijltjeBox = new HBox();
        pijltjeBox.setAlignment(Pos.CENTER);
        pijltjeBox.setId("rijTechniekHoofdschermBox");

        Rectangle pijltje1 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle pijltje2 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle pijltje3 = new Rectangle(grootte, grootte, Color.WHITE);

        pijltjeBox.getChildren().addAll(pijltje1, pijltje2, pijltje3);
        add(pijltjeBox, 6, 2);

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
    
}
