/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;

/**
 *
 * @author Dries Meert
 */
public class RijTechniekZithoudingKnop extends GridPane{

    public RijTechniekZithoudingKnop() {
    setId("rijTechniekHoofdschermPaneel");

        //einde grid indeling
        Rectangle2D schermformaat = Screen.getPrimary().getVisualBounds();
        double maxWidth = schermformaat.getWidth() * 0.62;

        //grid
        gridLinesVisibleProperty().set(true);

        ColumnConstraints kolom0 = new ColumnConstraints();
        kolom0.setPercentWidth(2);
        ColumnConstraints kolom1 = new ColumnConstraints();
        kolom1.setPercentWidth(14);
        ColumnConstraints kolom2 = new ColumnConstraints();
        kolom2.setPercentWidth(28);
        kolom2.setHalignment(HPos.CENTER);
        ColumnConstraints kolom3 = new ColumnConstraints();
        kolom3.setPercentWidth(28);
        kolom3.setHalignment(HPos.CENTER);
        ColumnConstraints kolom4 = new ColumnConstraints();
        kolom4.setPercentWidth(28);
        ColumnConstraints kolom5 = new ColumnConstraints();
        kolom5.setPercentWidth(2);

        getColumnConstraints().addAll(kolom0, kolom1, kolom2, kolom3, kolom4, kolom5);

        RowConstraints rij0 = new RowConstraints();
        rij0.setPercentHeight(1);
        RowConstraints rij1 = new RowConstraints();
        rij1.setPercentHeight(23);
        rij1.setValignment(VPos.BOTTOM);
        RowConstraints rij2 = new RowConstraints();
        rij2.setPercentHeight(25);
        RowConstraints rij3 = new RowConstraints();
        rij3.setPercentHeight(25);
        RowConstraints rij4 = new RowConstraints();
        rij4.setPercentHeight(25);
        RowConstraints rij5 = new RowConstraints();
        rij5.setPercentHeight(1);

        getRowConstraints().addAll(rij0, rij1, rij2, rij3, rij4, rij5);

        //gridKnop
        GridPane gridKnopPane = new GridPane();
        gridKnopPane.gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0GridKnopPane = new ColumnConstraints();
        kolom0GridKnopPane.setPercentWidth(100);
        kolom0GridKnopPane.setHalignment(HPos.CENTER);

        gridKnopPane.getColumnConstraints().addAll(kolom0GridKnopPane);

        RowConstraints rij0GridKnopPane = new RowConstraints();
        rij0GridKnopPane.setPercentHeight(80);
        RowConstraints rij1GridKnopPane = new RowConstraints();
        rij1GridKnopPane.setPercentHeight(20);

        gridKnopPane.getRowConstraints().addAll(rij0GridKnopPane, rij1GridKnopPane);

        add(gridKnopPane, 1, 1);

        //rem
        Image knopVierkant = new Image("Images/knopVierkant.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true);
        ImageView remView = new ImageView(knopVierkant);
        gridKnopPane.add(remView, 0, 0);

        HBox remBox = new HBox();
        remBox.setAlignment(Pos.CENTER);
        remBox.setId("rijTechniekHoofdschermBox");

        double grootte = Math.ceil(maxWidth * 0.03);
        Rectangle kotje1 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle kotje2 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle kotje3 = new Rectangle(grootte, grootte, Color.WHITE);

        remBox.getChildren().addAll(kotje1, kotje2, kotje3);
        gridKnopPane.add(remBox, 0, 1);

        //Listview
        ObservableList<String> opmerkingenList = FXCollections.observableArrayList();;
        Collections.sort(opmerkingenList);
        ListView<String> opmerkingenView = new ListView<String>(opmerkingenList);

        //Tekst
        TextField invulTextField = new TextField();
        invulTextField.setId("inlogTexfield");
        invulTextField.setPromptText("Geef een opmerking");
        invulTextField.setId("attitudeTextField");
        invulTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    opmerkingenList.add(invulTextField.getText());
                    invulTextField.clear();
                }
            }
        });

        //Listview
        ObservableList<String> opmerkingenList2 = FXCollections.observableArrayList();;
        Collections.sort(opmerkingenList2);
        ListView<String> opmerkingenView2 = new ListView<String>(opmerkingenList2);

        //Tekst
        TextField invulTextField2 = new TextField();
        invulTextField2.setId("inlogTexfield");
        invulTextField2.setPromptText("Geef een opmerking");
        invulTextField2.setId("attitudeTextField");
        invulTextField2.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    opmerkingenList2.add(invulTextField2.getText());
                    invulTextField2.clear();
                }
            }
        });

        //knoppen
        Button bediening = new Button("Bediening");
        bediening.setId("inlogButtons");
        add(bediening, 2, 1);

        Button gebruik = new Button("Gebruik");
        gebruik.setId("inlogButtons");
        add(gebruik, 2, 3);

        Button dosering = new Button("Dosering");
        dosering.setId("inlogButtons");
        add(dosering, 3, 1);

        Button volgorde = new Button("Volledig");
        volgorde.setId("inlogButtons");
        add(volgorde, 3, 2);

        Button teLaat = new Button("Te laat");
        teLaat.setId("inlogButtons");
        add(teLaat, 3, 3);

        Button andere = new Button("Andere");
        andere.setId("inlogButtons");
        add(andere, 3, 4); 
        andere.setOnMouseClicked(event -> {
            add(invulTextField, 4, 4);
            add(opmerkingenView, 4, 3);
        });
    }
}
