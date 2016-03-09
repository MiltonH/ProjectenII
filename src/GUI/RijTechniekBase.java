/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;

/**
 *
 * @author Milton
 */
public class RijTechniekBase extends GridPane
{

    HBox contentBox;

    public RijTechniekBase(HoofdPaneel hoofdPanel) {
        //grid indeling
        setId("hoofdPaneelBG");
        gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0 = new ColumnConstraints();
        kolom0.setPercentWidth(65);
        kolom0.setHalignment(HPos.CENTER);
        ColumnConstraints kolom1 = new ColumnConstraints();
        kolom1.setPercentWidth(35);

        getColumnConstraints().addAll(kolom0, kolom1);

        RowConstraints rij0 = new RowConstraints();
        rij0.setPercentHeight(25);
        RowConstraints rij1 = new RowConstraints();
        rij1.setPercentHeight(50);
        RowConstraints rij2 = new RowConstraints();
        rij2.setPercentHeight(25);

        getRowConstraints().addAll(rij0, rij1, rij2);

        //einde grid indeling
        Rectangle2D schermformaat = Screen.getPrimary().getVisualBounds();

        //contentBox
        contentBox = new HBox();
        contentBox.setId("contentBox");
        contentBox.setMaxSize(Math.ceil(schermformaat.getWidth() * 0.62), Math.ceil(schermformaat.getHeight() * 0.8));
        add(contentBox, 0, 0, 1, 3);
        //einde contentBox

        //box met knoppen
        HBox topKnoppenBox = new HBox();
        topKnoppenBox.setSpacing(Math.ceil(schermformaat.getWidth() * 0.02));
        topKnoppenBox.setAlignment(Pos.TOP_CENTER);
        Image verkeerTechImg = new Image("Images/verkeersTechKnop.png", Math.ceil(schermformaat.getWidth() * 0.10), USE_PREF_SIZE, true, true);
        ImageView verkeerTechKnopView = new ImageView(verkeerTechImg);
        Image attitudeKnopImg = new Image("Images/attitudeKnop.png", Math.ceil(schermformaat.getWidth() * 0.10), USE_PREF_SIZE, true, true);
        ImageView attitudeKnopView = new ImageView(attitudeKnopImg);
        topKnoppenBox.getChildren().addAll(attitudeKnopView,verkeerTechKnopView);
        add(topKnoppenBox, 1, 0);
        //center wijzerplaat
        StackPane wijzerStack = new StackPane();
        wijzerStack.setAlignment(Pos.CENTER_RIGHT);
        Image center = new Image("Images/center2Half.png", Math.ceil(schermformaat.getWidth() * 0.14), USE_PREF_SIZE, true, true);
        ImageView centerView = new ImageView(center);

        Image wijzerplaat = new Image("Images/Wijzerplaat.png", Math.ceil(schermformaat.getWidth() * 0.30), USE_PREF_SIZE, true, true);
        ImageView wijzerplaatView = new ImageView(wijzerplaat);

        Image wijzerStand = new Image("Images/WijzerStand1.png", Math.ceil(schermformaat.getWidth() * 0.3), USE_PREF_SIZE, true, true);
        ImageView wijzerplaatStandView = new ImageView(wijzerStand);

        wijzerStack.getChildren().addAll(centerView, wijzerplaatView, wijzerplaatStandView);
        add(wijzerStack, 1, 1);
        //einde center wijzerplaat
        HBox bottomKnoppenBox = new HBox();
        bottomKnoppenBox.setSpacing(Math.ceil(schermformaat.getWidth() * 0.02));
        bottomKnoppenBox.setAlignment(Pos.BOTTOM_CENTER);
        Image homeKnopImg = new Image("Images/homeKnop.png", Math.ceil(schermformaat.getWidth() * 0.10), USE_PREF_SIZE, true, true);
        ImageView homeKnopView = new ImageView(homeKnopImg);
        Image returnKnopImg = new Image("Images/returnKnop.png", Math.ceil(schermformaat.getWidth() * 0.10), USE_PREF_SIZE, true, true);
        ImageView returnKnopView = new ImageView(returnKnopImg);
        bottomKnoppenBox.getChildren().addAll(returnKnopView,homeKnopView);
        add(bottomKnoppenBox, 1, 2);

        homeKnopView.setOnMouseClicked(event -> {
            hoofdPanel.setSceneRoot(hoofdPanel);
        });
        
        returnKnopView.setOnMouseClicked(event -> {
        });
        verkeerTechKnopView.setOnMouseClicked(event -> {
            hoofdPanel.setSceneRoot(new VerkeersTechniekBase(hoofdPanel));
        });
        attitudeKnopView.setOnMouseClicked(event -> {
        });
        //einde box met knoppen
    }

    public void setContent(GridPane grid) {
        this.contentBox.getChildren().clear();
        this.contentBox.getChildren().add(grid);
    }
}
