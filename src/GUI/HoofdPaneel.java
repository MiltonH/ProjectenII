/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.sun.glass.ui.Window;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;
import javafx.stage.Screen;

/**
 *
 * @author Milton
 */
public class HoofdPaneel extends GridPane
{

    int niveau = 1;//dit is testcode

    public HoofdPaneel() {
        //maingrid indelen
        setId("hoofdPaneelBG");
        gridLinesVisibleProperty().set(true);

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
        //einde kap       
        //centerBox
        HBox centerBox = new HBox();
        StackPane centerStack = new StackPane();
        Image centerImg = new Image("Images/center2.png", Math.ceil(schermformaat.getWidth() * 0.24), USE_PREF_SIZE, true, true);
        ImageView centerView = new ImageView(centerImg);
        Image centerKnopImg = new Image("Images/centerKnop.png", Math.ceil(schermformaat.getWidth() * 0.10), USE_PREF_SIZE, true, true);
        ImageView centerKnopView = new ImageView(centerKnopImg);
        centerBox.setAlignment(Pos.CENTER);
        centerStack.getChildren().addAll(centerView, centerKnopView);
        centerBox.getChildren().addAll(centerStack);
        add(centerBox, 1, 2, 3, 1);

        centerKnopView.setOnMouseClicked(event -> {
            System.out.println("middel");
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
            System.out.println("links");
        });//debug
        wijzerplaat2View.setOnMouseClicked(event -> {
            System.out.println("rechts");
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
        
        Image rijstrokenImg = new Image("Images/rijstrokenIcoon.png", Math.ceil(schermformaat.getWidth() * 0.04), USE_PREF_SIZE, true, true);
        ImageView rijstrokenView = new ImageView(rijstrokenImg);
        
        rijstrokenView.setOnMouseClicked(event -> {
            System.out.println("rijstroken");
        });//debug
        
        Image rotondeImg = new Image("Images/rotondeIcoon.png", Math.ceil(schermformaat.getWidth() * 0.04), USE_PREF_SIZE, true, true);
        ImageView rotondeView = new ImageView(rotondeImg);
        
        rotondeView.setOnMouseClicked(event -> {
            System.out.println("rotonde");
        });//debug
        
        Image snelwegImg = new Image("Images/snelwegIcoon.png", Math.ceil(schermformaat.getWidth() * 0.04), USE_PREF_SIZE, true, true);
        ImageView snelwegView = new ImageView(snelwegImg);
        
        snelwegView.setOnMouseClicked(event -> {
            System.out.println("snelweg");
        });//debug
        
        Image stadImg = new Image("Images/stadIcoon.png", Math.ceil(schermformaat.getWidth() * 0.04), USE_PREF_SIZE, true, true);
        ImageView stadView = new ImageView(stadImg);
        
        stadView.setOnMouseClicked(event -> {
            System.out.println("stad");
        });//debug
        
        centerTopKnoppen.getChildren().addAll(rotondeView,rijstrokenView,stadView,snelwegView);
        centerTopStack.getChildren().addAll(centerTopView,centerTopKnoppen);
        centerTopBox.getChildren().add(centerTopStack);
        
        add(centerTopBox, 1, 1, 3, 1);        
        //einde CenterTopBalk
      
        //BottomBox
        HBox bottomBox = new HBox();
        StackPane bottomStack = new StackPane();
        bottomStack.setAlignment(Pos.CENTER);
        bottomBox.setAlignment(Pos.CENTER);
        Image bottomBoxImg = new Image("Images/BottomBox.png", Math.ceil(schermformaat.getWidth() * 0.40), USE_PREF_SIZE, true, true);
        ImageView bottomBoxView = new ImageView(bottomBoxImg);
        bottomBox.getChildren().add(bottomStack);

        Image bottomTest = new Image("Images/BottomTest.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true);
        ImageView bottomTest1View = new ImageView(bottomTest);
        bottomTest1View.setOnMouseClicked(event -> {
            wijzeplaat1Stand.setImage(wijzerStand2);
        });
        ImageView bottomTest2View = new ImageView(bottomTest);
        bottomTest2View.setOnMouseClicked(event -> {
            wijzeplaat1Stand.setImage(wijzerStand3);
        });
        ImageView bottomTest3View = new ImageView(bottomTest);
        bottomTest3View.setOnMouseClicked(event -> {
            wijzeplaat1Stand.setImage(wijzerStand1);
        });

        GridPane bottomBoxGrid = new GridPane();
        bottomBoxGrid.setAlignment(Pos.CENTER);
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
        List<Image> niveauImages = new ArrayList<>();
        niveauImages.add(new Image("Images/niveau1.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauImages.add(new Image("Images/niveau2.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauImages.add(new Image("Images/niveau3.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauImages.add(new Image("Images/niveau4.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauImages.add(new Image("Images/niveau5.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauImages.add(new Image("Images/niveau6.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        niveauImages.add(new Image("Images/niveau7.png", Math.ceil(schermformaat.getWidth() * 0.15), USE_PREF_SIZE, true, true));
        ImageView niveauCenterView = new ImageView(niveauImages.get(niveau - 1));

        niveauHbox.getChildren().addAll(niveauMinView, niveauCenterView, niveauPlusView);

        niveauStack.getChildren().addAll(niveauBoxView, niveauHbox);
        bottomBoxGrid.add(niveauStack, 0, 1);

        niveauMinView.setOnMouseClicked(event -> {
            niveauMin();
            niveauCenterView.setImage(niveauImages.get(niveau - 1));

        });
        niveauPlusView.setOnMouseClicked(event -> {
            niveauPlus();
            niveauCenterView.setImage(niveauImages.get(niveau - 1));
        });
        //eind niveau
        bottomStack.getChildren().addAll(bottomBoxView, bottomBoxGrid);

        add(bottomBox, 1, 3, 3, 1);
        //einde BottomBox
        //hoeklinks
        StackPane linksStack = new StackPane();            
        Image linksImg = new Image("Images/links.png", Math.ceil(schermformaat.getWidth() * 0.10), USE_PREF_SIZE, true, true);
        ImageView linksView = new ImageView(linksImg);
        linksStack.getChildren().addAll(linksView);
        linksStack.setAlignment(Pos.CENTER_RIGHT);
        add(linksStack, 0, 2);
        linksView.setOnMouseClicked(event -> {
            System.out.println("linkshoek");
        });//debug
        //einde links

        //hoek rechts
        StackPane rechtsStack = new StackPane();            
        Image rechtsImg = new Image("Images/rechts.png", Math.ceil(schermformaat.getWidth() * 0.10), USE_PREF_SIZE, true, true);
        ImageView rechtsView = new ImageView(rechtsImg);
        rechtsStack.getChildren().addAll(rechtsView);
        rechtsStack.setAlignment(Pos.CENTER_LEFT);
        add(rechtsStack, 4, 2);
        rechtsView.setOnMouseClicked(event -> {
            System.out.println("rechtshoek");
        });//debug
        //einde rechts
        //home en opmerkingen
        HBox homeBox = new HBox();
        homeBox.setAlignment(Pos.CENTER);
        Image homeKnopImg = new Image("Images/homeKnop.png", Math.ceil(schermformaat.getWidth() * 0.10), USE_PREF_SIZE, true, true);
        ImageView homeKnopView = new ImageView(homeKnopImg);
        homeBox.getChildren().addAll(homeKnopView);
        add(homeBox,4,3);
        
        HBox opmerkingBox = new HBox();
        opmerkingBox.setAlignment(Pos.CENTER);
        Image opmerkingKnopImg = new Image("Images/opmerkingenKnop.png", Math.ceil(schermformaat.getWidth() * 0.10), USE_PREF_SIZE, true, true);
        ImageView opmerkingKnopView = new ImageView(opmerkingKnopImg);
        opmerkingBox.getChildren().addAll(opmerkingKnopView);
        add(opmerkingBox,0,3);
        //einde home en opmerkingen
        
    }

    private void niveauMin() {
        if (niveau > 1) {
            niveau -= 1;
        }
    }

    private void niveauPlus() {
        if (niveau < 7) {
            niveau += 1;
        }
    }

}
