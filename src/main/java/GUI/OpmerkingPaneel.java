package GUI;

import domain.View;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

public class OpmerkingPaneel extends GridPane implements View
{

    private Scene scene;
    private HoofdPaneel hp;
    private ListView opmerkingenLV;
    private ObservableList<String> opmList;

    public OpmerkingPaneel(HoofdPaneel hoofdPanel) {
        hp = hoofdPanel;
        setId("inlogPaneelBG");

        Rectangle2D schermformaat = Screen.getPrimary().getVisualBounds();
        //aanmaak grid
        gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0 = new ColumnConstraints();
        kolom0.setPercentWidth(15);
        ColumnConstraints kolom1 = new ColumnConstraints();
        kolom1.setPercentWidth(70);
        ColumnConstraints kolom2 = new ColumnConstraints();
        kolom2.setPercentWidth(15);
        kolom2.setHalignment(HPos.CENTER);

        getColumnConstraints().addAll(kolom0, kolom1, kolom2);

        RowConstraints rij0 = new RowConstraints();
        rij0.setPercentHeight(15);
        RowConstraints rij1 = new RowConstraints();
        rij1.setPercentHeight(70);
        RowConstraints rij2 = new RowConstraints();
        rij2.setPercentHeight(15);

        getRowConstraints().addAll(rij0, rij1, rij2);

        //aanmaak LabelTextareaGrid
        GridPane labelTextAreaGrid = new GridPane();
        labelTextAreaGrid.setId("opmerkingenPaneel");
        labelTextAreaGrid.gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0labelTextAreaGrid = new ColumnConstraints();
        kolom0labelTextAreaGrid.setPercentWidth(100);
        labelTextAreaGrid.getColumnConstraints().addAll(kolom0labelTextAreaGrid);

        RowConstraints rij0labelTextAreaGrid = new RowConstraints();
        rij0labelTextAreaGrid.setPercentHeight(10);
        RowConstraints rij1labelTextAreaGrid = new RowConstraints();
        rij1labelTextAreaGrid.setPercentHeight(90);
        labelTextAreaGrid.getRowConstraints().addAll(rij0labelTextAreaGrid, rij1labelTextAreaGrid);

        add(labelTextAreaGrid, 1, 1);

        //label opmerkingen
        Label opmerkingenLabel = new Label("Opmerkingen: ");
        opmerkingenLabel.setId("naamLabel");
        labelTextAreaGrid.add(opmerkingenLabel, 0, 0);

        //textArea opmerkingen
        VBox areaBox = new VBox();
        areaBox.setSpacing(20);
        opmList = FXCollections.observableArrayList();
        opmerkingenLV = new ListView();
        opmerkingenLV.setPrefHeight(schermformaat.getHeight() * 0.6);
        opmerkingenLV.setId("opmerkingenTexfield");

        HBox invoerbox = new HBox(40);

        Button verwijderButton = new Button("verwijder");
        verwijderButton.setOnAction(event -> {
            List<String> deList = hp.getHuidigeLeerling().getHuidigEvaluatieFormulier().getOpmerkingen();
            deList.remove(opmerkingenLV.getSelectionModel().getSelectedItem());
            update();
        });
        verwijderButton.setId("buttons");

        TextField invulTextField = new TextField();
        invulTextField.setId("attitudeTextField");
        invulTextField.setPromptText("Opmerking toevoegen");
        invulTextField.setPrefWidth(schermformaat.getWidth() * 0.5);

        invoerbox.getChildren().addAll(verwijderButton, invulTextField);
        areaBox.getChildren().addAll(opmerkingenLV, invoerbox);

        labelTextAreaGrid.add(areaBox, 0, 1);
        opmerkingenLV.setItems(opmList);

        invulTextField.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    if (invulTextField.getText().trim().isEmpty() == false) {
                        List<String> deList = hp.getHuidigeLeerling().getHuidigEvaluatieFormulier().getOpmerkingen();
                        if (!deList.contains(invulTextField.getText())) {
                            deList.add(invulTextField.getText());
                            update();
                        }
                    }
                }
            }
        });

        //terugKnop
        Button terugKnop = new Button("Terug");
        terugKnop.setId("inlogButtons");
        add(terugKnop, 2, 2);

        terugKnop.setOnMouseClicked(event -> {
            scene.setRoot(hoofdPanel);
        });
        update();
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void update() {
        List<String> opmerkingen = hp.getHuidigeLeerling().getHuidigEvaluatieFormulier().getOpmerkingen();
        opmList.clear();
        opmList.addAll(opmerkingen);
    }
}
