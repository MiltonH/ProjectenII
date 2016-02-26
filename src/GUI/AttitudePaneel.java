package GUI;

import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Screen;

public class AttitudePaneel extends GridPane {

    Scene scene;

    public AttitudePaneel(HoofdPaneel hoofdPanel) {
        setId("inlogPaneelBG");
        //schermformaat
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
        rij1invulSchermenPane.setPercentHeight(20);
        RowConstraints rij2invulSchermenPane = new RowConstraints();
        rij2invulSchermenPane.setPercentHeight(20);
        invulSchermenPane.getRowConstraints().addAll(rij0invulSchermenPane, rij1invulSchermenPane, rij2invulSchermenPane);

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
        ObservableList<String> opmerkingen = FXCollections.observableArrayList();;
        opmerkingen.addAll("Zenuwachtig", "Concentratie", "Schrik", "Asociaal", "Verkeersgevaarlijk", "Ongeduldig", "Agressief rijgedrag", "Inzet", "Verstrooid", "Eigenwijs");
        Collections.sort(opmerkingen);
        ListView<String> opmerkingenView = new ListView<String>(opmerkingen);
        opmerkingenView.setId("attitudeListView");
        invulSchermenPane.add(opmerkingenView, 0, 0);

        //TextField
        TextField invulTextField = new TextField();
        invulTextField.setId("inlogTexfield");
        invulTextField.setPromptText("Geef een opmerking");
        invulTextField.setId("attitudeTextField");
        invulSchermenPane.add(invulTextField, 0, 1);

        //Label
        Label attitudeLabel = new Label("Attitude");
        attitudeLabel.setId("inlognaamNummerLabel");
        attitudeLabel.setId("attitudeLabel");
        textAreaPane.add(attitudeLabel, 0, 0);

        //TextArea ListView
        ObservableList<String> opmerkingenText = FXCollections.observableArrayList();;
        Collections.sort(opmerkingenText);
        ListView<String> opmerkingenTextView = new ListView<String>(opmerkingenText);
        opmerkingenTextView.setId("attitudeListViewOpmerkingen");
        textAreaPane.add(opmerkingenTextView, 0, 1);
        
        //image uitroepingsteken
//        Image uitroepingstekenImg = new Image("Images/uitroepingsteken.png.png", Math.ceil(schermformaat.getWidth()*0.03), USE_PREF_SIZE, true, true);
//        ImageView uitroepingstekenView = new ImageView(uitroepingstekenImg);
        
        //Knoppen
        Button voegToe = new Button("Voeg Toe");
        voegToe.setId("inlogButtons");
        invulSchermenPane.add(voegToe, 0, 2);

        voegToe.setOnMouseClicked(event -> {
            if (invulTextField.getText().trim().isEmpty() == false) {
                opmerkingenView.getSelectionModel().clearSelection();
                opmerkingenText.add(invulTextField.getText() + "\n");
                invulTextField.clear();
            } else if (opmerkingenView.getSelectionModel().getSelectedItem() != null) {
                opmerkingenText.add(opmerkingenView.getSelectionModel().getSelectedItem() + "\n");
                opmerkingenView.getSelectionModel().clearSelection();
            }
        });

        //
        Button verwijder = new Button("Verwijder");
        verwijder.setId("inlogButtons");
        knopPane.add(verwijder, 0, 0);

        verwijder.setOnMouseClicked(event -> {
            opmerkingenText.remove(opmerkingenTextView.getSelectionModel().getSelectedItem());
        });

        //
        Button terug = new Button("Terug");
        terug.setId("inlogButtons");
        add(terug, 2, 2);

        terug.setOnMouseClicked(event -> {
            scene.setRoot(hoofdPanel);
        });
        
        //
        Button aandacht = new Button("Aandacht");
        aandacht.setId("inlogButtons");
        knopPane.add(aandacht, 1, 0);

        aandacht.setOnMouseClicked(event -> {
//            Collections.replaceAll(opmerkingenText, opmerkingenTextView.getSelectionModel().getSelectedItem(), opmerkingenTextView.getSelectionModel().getSelectedItem() + "!");
//            String item = opmerkingenTextView.getSelectionModel().getSelectedItem();
//            opmerkingenText.remove(opmerkingenTextView.getSelectionModel().getSelectedItem());
//            opmerkingenText.add(item + "!" + "\n");
        });

    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
