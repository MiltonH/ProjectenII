package GUI;

import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;

public class RijTechniekStuurKnop extends GridPane {

    int doseringInt = 0;
    int houdingsInt = 0;

    public RijTechniekStuurKnop() {
        setId("rijTechniekHoofdschermPaneel");

        //einde grid indeling
        Rectangle2D schermformaat = Screen.getPrimary().getVisualBounds();
        double maxWidth = schermformaat.getWidth() * 0.62;

        //grid
        gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0 = new ColumnConstraints();
        kolom0.setPercentWidth(2);
        ColumnConstraints kolom1 = new ColumnConstraints();
        kolom1.setPercentWidth(14);
        kolom1.setHalignment(HPos.CENTER);
        ColumnConstraints kolom2 = new ColumnConstraints();
        kolom2.setPercentWidth(42);
        kolom2.setHalignment(HPos.CENTER);
        ColumnConstraints kolom3 = new ColumnConstraints();
        kolom3.setPercentWidth(42);
        kolom3.setHalignment(HPos.CENTER);
        ColumnConstraints kolom4 = new ColumnConstraints();
        kolom4.setPercentWidth(2);

        getColumnConstraints().addAll(kolom0, kolom1, kolom2, kolom3, kolom4);

        RowConstraints rij0 = new RowConstraints();
        rij0.setPercentHeight(2);
        RowConstraints rij1 = new RowConstraints();
        rij1.setPercentHeight(32);
        RowConstraints rij2 = new RowConstraints();
        rij2.setPercentHeight(32);
        RowConstraints rij3 = new RowConstraints();
        rij3.setPercentHeight(32);
        RowConstraints rij4 = new RowConstraints();
        rij4.setPercentHeight(2);

        getRowConstraints().addAll(rij0, rij1, rij2, rij3, rij4);

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

        //Stuur
        Image knopVierkant = new Image("Images/knopVierkant.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true);
        ImageView stuurView = new ImageView(knopVierkant);
        gridKnopPane.add(stuurView, 0, 0);

        HBox stuurBox = new HBox();
        stuurBox.setAlignment(Pos.CENTER);
        stuurBox.setId("rijTechniekHoofdschermBox");

        double grootte = Math.ceil(maxWidth * 0.03);
        Rectangle kotje1 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle kotje2 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle kotje3 = new Rectangle(grootte, grootte, Color.WHITE);

        stuurBox.getChildren().addAll(kotje1, kotje2, kotje3);
        gridKnopPane.add(stuurBox, 0, 1);

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

        //knoppen
        Button dosering = new Button("Dosering");
        dosering.setId("buttons");
        add(dosering, 2, 1);
        dosering.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (doseringInt != 3) {
                    doseringInt++;
                    toggleColor(dosering, doseringInt);
                } else {
                    doseringInt = 0;
                    toggleColor(dosering, doseringInt);
                }
                kleurtjes(kotje1);
            }
        });

        Button houding = new Button("Houding");
        houding.setId("buttons");
        add(houding, 2, 2);
        houding.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (houdingsInt != 3) {
                    houdingsInt++;
                    toggleColor(houding, houdingsInt);
                } else {
                    houdingsInt = 0;
                    toggleColor(houding, houdingsInt);
                }
                kleurtjes(kotje1);
            }
        });

        Button andere = new Button("Andere");
        andere.setId("buttons");
        add(andere, 2, 3);
        andere.setOnMouseClicked(event -> {
            add(invulTextField, 3, 3);
            add(opmerkingenView, 3, 2);
        });
    }

    private void toggleColor(Button button, int integer) {
        if (integer == 1) {
            button.setId("buttonKleurRood");
        } else if (integer == 2) {
            button.setId("buttonKleurOranje");
        } else if (integer == 3) {
            button.setId("buttonKleurGroen");
        } else if (integer == 0) {
            button.setId("buttons");
        }
    }

    private void kleurtjes(Rectangle rect) {
        int vakInt = houdingsInt + doseringInt;
        if (houdingsInt == 0 || doseringInt == 0) {
            rect.setFill(Color.WHITE);
        } else if (vakInt == 2 || vakInt == 3) {
            rect.setFill(Color.RED);
        } else if (vakInt == 4 || vakInt == 5) {
            rect.setFill(Color.ORANGE);
        } else if (vakInt == 6) {
            rect.setFill(Color.LIMEGREEN);
        }
    }
}
