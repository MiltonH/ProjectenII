package GUI;

import domain.EvaluatieFormulier;
import domain.View;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Screen;

public class AttitudePaneel extends GridPane implements View
{

    private Scene scene;
    private HoofdPaneel hp;
    private EvaluatieFormulier huidigformulier;
    private ObservableList<String> opmerkingenTextAreaList;

    public AttitudePaneel(HoofdPaneel hoofdPanel) {
        setId("inlogPaneelBG");
        //schermformaat
        Rectangle2D schermformaat = Screen.getPrimary().getVisualBounds();
        this.hp = hoofdPanel;
        huidigformulier = hp.getHuidigeLeerling().getHuidigEvaluatieFormulier();

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

        //aanmaak AttitudePane 
        GridPane AttitudePane = new GridPane();
        AttitudePane.setId("opmerkingenPaneel");
        AttitudePane.gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0AttitudePane = new ColumnConstraints();
        kolom0AttitudePane.setPercentWidth(35);
        kolom0AttitudePane.setHalignment(HPos.CENTER);
        ColumnConstraints kolom1AttitudePane = new ColumnConstraints();
        kolom1AttitudePane.setPercentWidth(65);
        kolom1AttitudePane.setHalignment(HPos.CENTER);
        AttitudePane.getColumnConstraints().addAll(kolom0AttitudePane, kolom1AttitudePane);

        RowConstraints rij0AttitudePane = new RowConstraints();
        rij0AttitudePane.setPercentHeight(100);
        AttitudePane.getRowConstraints().addAll(rij0AttitudePane);

        add(AttitudePane, 1, 1);

        //aanmaak invulSchermen
        GridPane invulSchermenPane = new GridPane();
        invulSchermenPane.gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0invulSchermenPane = new ColumnConstraints();
        kolom0invulSchermenPane.setPercentWidth(100);
        kolom0invulSchermenPane.setHalignment(HPos.CENTER);
        invulSchermenPane.getColumnConstraints().addAll(kolom0invulSchermenPane);

        RowConstraints rij0invulSchermenPane = new RowConstraints();
        rij0invulSchermenPane.setPercentHeight(60);
        RowConstraints rij1invulSchermenPane = new RowConstraints();
        rij1invulSchermenPane.setPercentHeight(10);
        rij1invulSchermenPane.setValignment(VPos.BOTTOM);
        RowConstraints rij2invulSchermenPane = new RowConstraints();
        rij2invulSchermenPane.setPercentHeight(10);
        rij2invulSchermenPane.setValignment(VPos.CENTER);
        RowConstraints rij3invulSchermenPane = new RowConstraints();
        rij3invulSchermenPane.setPercentHeight(20);
        invulSchermenPane.getRowConstraints().addAll(rij0invulSchermenPane, rij1invulSchermenPane, rij2invulSchermenPane, rij3invulSchermenPane);

        AttitudePane.add(invulSchermenPane, 0, 0);

        //aanmaak textAreaPane
        GridPane textAreaPane = new GridPane();
        textAreaPane.gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0listViewPane = new ColumnConstraints();
        kolom0listViewPane.setPercentWidth(100);
        kolom0listViewPane.setHalignment(HPos.CENTER);
        textAreaPane.getColumnConstraints().addAll(kolom0listViewPane);

        RowConstraints rij0listViewPane = new RowConstraints();
        rij0listViewPane.setPercentHeight(20);
        RowConstraints rij1listViewPane = new RowConstraints();
        rij1listViewPane.setPercentHeight(60);
        RowConstraints rij2listViewPane = new RowConstraints();
        rij2listViewPane.setPercentHeight(20);
        textAreaPane.getRowConstraints().addAll(rij0listViewPane, rij1listViewPane, rij2listViewPane);

        AttitudePane.add(textAreaPane, 1, 0);

        //aanmaak KnopGrid
        GridPane knopPane = new GridPane();
        knopPane.gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0KnopPane = new ColumnConstraints();
        kolom0KnopPane.setPercentWidth(50);
        kolom0KnopPane.setHalignment(HPos.CENTER);
        ColumnConstraints kolom1KnopPane = new ColumnConstraints();
        kolom1KnopPane.setPercentWidth(50);
        kolom1KnopPane.setHalignment(HPos.CENTER);
        knopPane.getColumnConstraints().addAll(kolom0KnopPane, kolom1KnopPane);

        RowConstraints rij0KnopPane = new RowConstraints();
        rij0KnopPane.setPercentHeight(100);
        knopPane.getRowConstraints().addAll(rij0KnopPane);

        textAreaPane.add(knopPane, 0, 2);

        //ListView
        ObservableList<String> opmerkingenList = FXCollections.observableArrayList();
        opmerkingenList.addAll("Zenuwachtig", "Concentratie", "Schrik", "Asociaal", "Verkeersgevaarlijk", "Ongeduldig", "Agressief rijgedrag", "Inzet", "Verstrooid", "Eigenwijs");
        Collections.sort(opmerkingenList);
        ListView<String> opmerkingenView = new ListView<String>(opmerkingenList);
        opmerkingenView.setId("attitudeListView");
        invulSchermenPane.add(opmerkingenView, 0, 0);

        //TextField
        TextField invulTextField = new TextField();
        invulTextField.setId("inlogTexfield");
        invulTextField.setPromptText("Geef een opmerking");
        invulTextField.setId("attitudeTextField");
        invulSchermenPane.add(invulTextField, 0, 1);

        //AttitudeLabel
        Label attitudeLabel = new Label("Attitude");
        attitudeLabel.setId("attitudeLabel");
        textAreaPane.add(attitudeLabel, 0, 0);

        //FoutLabel
        Label foutLabel = new Label();
        foutLabel.setId("attitudeFout");
        invulSchermenPane.add(foutLabel, 0, 2);

        //TextArea ListView
        opmerkingenTextAreaList = FXCollections.observableArrayList();
        ListView<String> opmerkingenTextAreaView = new ListView<String>(opmerkingenTextAreaList);
        opmerkingenTextAreaView.setId("attitudeListViewOpmerkingen");
        textAreaPane.add(opmerkingenTextAreaView, 0, 1);

        //List voor opmerkingen
        ObservableList<String> opmerkingenDoorgeefList = FXCollections.observableArrayList();

        //Knoppen   
        Button voegToe = new Button("Voeg Toe");
        voegToe.setId("inlogButtons");
        invulSchermenPane.add(voegToe, 0, 3);

        voegToe.setOnMouseClicked(event -> {
            if (invulTextField.getText().trim().isEmpty() == false) {
                if (opmerkingenTextAreaList.contains(invulTextField.getText().substring(0, 1).toUpperCase() + invulTextField.getText().substring(1)) || opmerkingenTextAreaList.contains(invulTextField.getText().substring(0, 1).toUpperCase() + invulTextField.getText().substring(1) + "!")) {
                    foutLabel.setText("Deze opmerking is al toegevoegd");
                } else if (invulTextField.getText().indexOf("!") == -1) {
                    opmerkingenView.getSelectionModel().clearSelection();
                    huidigformulier.getAttitude().add(invulTextField.getText().substring(0, 1).toUpperCase() + invulTextField.getText().substring(1));
                    invulTextField.clear();
                    foutLabel.setText("");
                    update();
                } else {
                    foutLabel.setText("Een uitroepingsteken mag niet worden toegevoegd");
                }
            } else if (opmerkingenView.getSelectionModel().getSelectedItem() != null) {
                if (opmerkingenTextAreaList.contains(opmerkingenView.getSelectionModel().getSelectedItem()) || opmerkingenTextAreaList.contains(opmerkingenView.getSelectionModel().getSelectedItem() + "!")) {
                    foutLabel.setText("Deze opmerking is al toegevoegd");
                } else {
                    huidigformulier.getAttitude().add(opmerkingenView.getSelectionModel().getSelectedItem());
                    opmerkingenView.getSelectionModel().clearSelection();
                    foutLabel.setText("");
                    update();
                }
            }
        });

        //
        Button verwijder = new Button("Verwijder");
        verwijder.setId("inlogButtons");
        knopPane.add(verwijder, 0, 0);

        verwijder.setOnMouseClicked(event -> {
            huidigformulier.getAttitude().remove(opmerkingenTextAreaView.getSelectionModel().getSelectedItem());
            update();
        });

        //
        Button terug = new Button("Terug");
        terug.setId("inlogButtons");
        add(terug, 2, 2);

        terug.setOnMouseClicked(event -> {
            hoofdPanel.setSceneRoot(hoofdPanel);
        });

        //
        Button aandacht = new Button("Aandacht");
        aandacht.setId("inlogButtons");
        knopPane.add(aandacht, 1, 0);

        aandacht.setOnMouseClicked(event -> {
            if (opmerkingenTextAreaView.getSelectionModel().getSelectedItem() != null) {
                if (opmerkingenTextAreaView.getSelectionModel().getSelectedItem().indexOf('!') == -1) {
                    if (!huidigformulier.getOpmerkingen().contains(opmerkingenTextAreaView.getSelectionModel().getSelectedItem())) {
                        huidigformulier.getOpmerkingen().add(opmerkingenTextAreaView.getSelectionModel().getSelectedItem());
                    }
                    huidigformulier.getAttitude().remove(opmerkingenTextAreaView.getSelectionModel().getSelectedItem());
//                    opmerkingenDoorgeefList.add(opmerkingenTextAreaView.getSelectionModel().getSelectedItem());
//                    Collections.replaceAll(opmerkingenTextAreaList, opmerkingenTextAreaView.getSelectionModel().getSelectedItem(), opmerkingenTextAreaView.getSelectionModel().getSelectedItem() + "!");
                    foutLabel.setText("Opmerking toegevoegd");
                    update();

                } else {
                    foutLabel.setText("U heeft meermaals aandacht aangedrukt");
                }
            }
        });

        invulTextField.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    if (invulTextField.getText().trim().isEmpty() == false) {
                        if (opmerkingenTextAreaList.contains(invulTextField.getText().substring(0, 1).toUpperCase() + invulTextField.getText().substring(1)) || opmerkingenTextAreaList.contains(invulTextField.getText().substring(0, 1).toUpperCase() + invulTextField.getText().substring(1) + "!")) {
                            foutLabel.setText("Deze opmerking is al toegevoegd");
                        } else if (invulTextField.getText().indexOf("!") == -1) {
                            opmerkingenView.getSelectionModel().clearSelection();
                            huidigformulier.getAttitude().add(invulTextField.getText().substring(0, 1).toUpperCase() + invulTextField.getText().substring(1));
                            invulTextField.clear();
                            foutLabel.setText("");
                            update();
                        } else {
                            foutLabel.setText("Een uitroepingsteken mag niet worden toegevoegd");
                        }
                    }
                }
            }
        });
        update();
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void update() {
        huidigformulier = hp.getHuidigeLeerling().getHuidigEvaluatieFormulier();
        opmerkingenTextAreaList.clear();
        opmerkingenTextAreaList.addAll(huidigformulier.getAttitude());

    }
}
