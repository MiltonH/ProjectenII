package GUI;

import domain.Leerling;
import domain.LeerlingRepo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Screen;

public class InlogPaneel extends GridPane
{

    private Scene scene;

    private ObservableList<Leerling> leerlingen;
    private LeerlingRepo llRepo;

    public InlogPaneel(LeerlingRepo llRepo) {

        this.llRepo = llRepo;
        leerlingen = FXCollections.observableArrayList();
//        leerlingen.add(new Leerling("Hooft", "Milton", "rij0001"));
//        leerlingen.add(new Leerling("Meert", "Dries", "rij0002"));
//        leerlingen.add(new Leerling("Lanneer", "Robin", "rij0003"));
//        leerlingen.add(new Leerling("Debot", "Cédric", "rij0004"));

        setId("inlogPaneelBG");
        //schermformaat
        Rectangle2D schermformaat = Screen.getPrimary().getVisualBounds();

        //aanmaak grid
        gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0 = new ColumnConstraints();
        kolom0.setPercentWidth(20);
        ColumnConstraints kolom1 = new ColumnConstraints();
        kolom1.setPercentWidth(60);
        ColumnConstraints kolom2 = new ColumnConstraints();
        kolom2.setPercentWidth(20);

        getColumnConstraints().addAll(kolom0, kolom1, kolom2);

        RowConstraints rij0 = new RowConstraints();
        rij0.setPercentHeight(25);
        RowConstraints rij1 = new RowConstraints();
        rij1.setPercentHeight(50);
        RowConstraints rij2 = new RowConstraints();
        rij2.setPercentHeight(25);

        getRowConstraints().addAll(rij0, rij1, rij2);

        //aanmaak InlogSchermPane 
        GridPane InlogSchermPane = new GridPane();
        InlogSchermPane.setId("inlogPaneel");
        InlogSchermPane.gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0InlogSchermPane = new ColumnConstraints();
        kolom0InlogSchermPane.setPercentWidth(70);
        kolom0InlogSchermPane.setHalignment(HPos.LEFT);
        ColumnConstraints kolom1InlogSchermPane = new ColumnConstraints();
        kolom1InlogSchermPane.setPercentWidth(30);
        kolom1InlogSchermPane.setHalignment(HPos.CENTER);
        InlogSchermPane.getColumnConstraints().addAll(kolom0InlogSchermPane, kolom1InlogSchermPane);

        RowConstraints rij0InlogSchermPane = new RowConstraints();
        rij0InlogSchermPane.setPercentHeight(50);
        RowConstraints rij1InlogSchermPane = new RowConstraints();
        rij1InlogSchermPane.setPercentHeight(50);
        InlogSchermPane.getRowConstraints().addAll(rij0InlogSchermPane, rij1InlogSchermPane);

        add(InlogSchermPane, 1, 1);

        //aanmaak naamNummerPane
        GridPane naamNummerPane = new GridPane();
        naamNummerPane.gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0NaamNummerPane = new ColumnConstraints();
        kolom0NaamNummerPane.setPercentWidth(30);
        kolom0NaamNummerPane.setHalignment(HPos.LEFT);
        ColumnConstraints kolom1NaamNummerPane = new ColumnConstraints();
        kolom1NaamNummerPane.setPercentWidth(70);
        kolom1NaamNummerPane.setHalignment(HPos.LEFT);
        naamNummerPane.getColumnConstraints().addAll(kolom0NaamNummerPane, kolom1NaamNummerPane);

        RowConstraints rij0NaamNummerPane = new RowConstraints();
        rij0NaamNummerPane.setPercentHeight(50);
        RowConstraints rij1NaamNummerPane = new RowConstraints();
        rij1NaamNummerPane.setPercentHeight(50);
        naamNummerPane.getRowConstraints().addAll(rij0NaamNummerPane, rij1NaamNummerPane);

        InlogSchermPane.add(naamNummerPane, 0, 0);

        //aanmaak listViewGrid
//        GridPane listViewGrid = new GridPane();
//        listViewGrid.gridLinesVisibleProperty().set(true);
//
//        ColumnConstraints kolom0ListViewGrid = new ColumnConstraints();
//        kolom0ListViewGrid.setPercentWidth(50);
//        ColumnConstraints kolom1ListViewGrid = new ColumnConstraints();
//        kolom1ListViewGrid.setPercentWidth(50);
//        kolom1ListViewGrid.setHalignment(HPos.CENTER);
//        listViewGrid.getColumnConstraints().addAll(kolom0ListViewGrid, kolom1ListViewGrid);
//
//        InlogSchermPane.add(listViewGrid, 1, 1);
        //aanmaak naamLabel
        Label naamLabel = new Label("Naam: ");
        naamLabel.setId("inlognaamNummerLabel");
        naamNummerPane.add(naamLabel, 0, 0);

        //aanmaak nummerLabel
        Label nummerLabel = new Label("Nummer: ");
        nummerLabel.setId("inlognaamNummerLabel");
        naamNummerPane.add(nummerLabel, 0, 1);

        //aanmaak tekstfieldNaam
        TextField naamTextField = new TextField();
        naamTextField.setId("inlogTexfield");
        naamTextField.setPromptText("zoek op naam...");
        naamNummerPane.add(naamTextField, 1, 0);

        //aanmaak tekstfieldNummer
        TextField nummerTextField = new TextField();
        nummerTextField.setId("inlogTexfield");
        nummerTextField.setPromptText("zoek op inschrijvingsNummer...");
        naamNummerPane.add(nummerTextField, 1, 1);
        naamTextField.setOnMousePressed(event -> {
            nummerTextField.clear();
        });

        HBox knoppenBox = new HBox();
        knoppenBox.setSpacing(20);
        knoppenBox.setAlignment(Pos.CENTER);

        //knop open
        Button openKnop = new Button("Open");
        openKnop.setId("inlogButtons");
//        InlogSchermPane.add(openKnop, 1, 1);

        //knop VoegToe
        Button voegToeKnop = new Button("Voeg Toe");
        voegToeKnop.setId("inlogButtons");
        //knop VoegToe

        Image syncImg = new Image("Images/sync.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true);
        ImageView syncView = new ImageView(syncImg);

        Image noconImg = new Image("Images/noconnection.png", Math.ceil(schermformaat.getWidth() * 0.03), USE_PREF_SIZE, true, true);
        ImageView noconImgView = new ImageView(noconImg);

        syncView.setOnMouseClicked(event -> {

            llRepo.Synchroniseer(knoppenBox, syncView, this, noconImgView);
            refreshList();
        });

        noconImgView.setOnMouseClicked(event -> {

            llRepo.Synchroniseer(knoppenBox, syncView, this, noconImgView);
            refreshList();
        });

//        InlogSchermPane.add(voegToeKnop, 0, 1);
        knoppenBox.getChildren().addAll(voegToeKnop, openKnop, syncView);
        InlogSchermPane.add(knoppenBox, 0, 1);

        //afbeelding
//        ImageView gebruikersImage = new ImageView(new Image("Images/unknown-user.png", Math.ceil(schermformaat.getWidth() * 0.13), USE_PREF_SIZE, true, true));
//        InlogSchermPane.add(gebruikersImage, 1, 0);
        //ListView
//        ObservableList<String> namen = FXCollections.observableArrayList();
//        List<String> llnamen = new ArrayList<>();//leerlingen.stream().map(l -> l.getFamilienaam() + " " + l.getVoornaam()).collect(Collectors.toList());
//        for (Leerling ll : leerlingen) {
//            llnamen.add(ll.getFamilienaam() + " " + ll.getVoornaam());
//        }
//        namen.addAll(llnamen);
//        Collections.sort(namen);
//        llRepo.laadLijst();
//        llRepo.laadLijst();
//        ObservableList<Leerling> testl = FXCollections.observableArrayList();
        leerlingen.addAll(llRepo.getLeerlingList());

        ListView<Leerling> zoekView = new ListView<Leerling>(leerlingen);
        zoekView.setCellFactory(listView -> new LeerlingCell());
//        listViewGrid.add(zoekView, 0, 0);
//        listViewGrid.add(openKnop, 1, 0);
        InlogSchermPane.add(zoekView, 1, 0, 1, 2);

        FilteredList<Leerling> filteredLeerling = new FilteredList<>(leerlingen, e -> true);
        naamTextField.setOnKeyReleased(e -> {
            naamTextField.textProperty().addListener((ObservableValue, oldValue, newValue) -> {
                filteredLeerling.setPredicate((Predicate<? super Leerling>) leerling -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (leerling.getVoornaam().toLowerCase().startsWith(lowerCaseFilter)) {
                        return true;
                    } else if (leerling.getFamilienaam().toLowerCase().startsWith(lowerCaseFilter)) {
                        return true;
                    }
                    return false;
                });
            });
            SortedList<Leerling> sortedData = new SortedList<>(filteredLeerling);
            zoekView.setItems(sortedData);
        });

        FilteredList<Leerling> filteredLeerlingNummer = new FilteredList<>(leerlingen, e -> true);
        nummerTextField.setOnKeyReleased(e -> {
            nummerTextField.textProperty().addListener((ObservableValue, oldValue, newValue) -> {
                filteredLeerlingNummer.setPredicate((Predicate<? super Leerling>) leerling -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (leerling.getInschrijvingsNummer().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }
                    return false;
                });
            });
            SortedList<Leerling> sortedData = new SortedList<>(filteredLeerlingNummer);
//            sortedData.comparatorProperty().bind(zoekView.comparatorPropterty());
            zoekView.setItems(sortedData);
        });

        //knoppen
        openKnop.setOnMouseClicked(event -> {
//            if (naamTextField.getText().isEmpty()) {
//                naamTextField.setPromptText("Geen naam ingevult");
//                naamTextField.setId("inlogGeenNaamIngevult");
//            } else {
//                Leerling geselecteerdeLeerling = null;
//
//                for (Leerling lin : leerlingen) {
//                    if ((lin.getFamilienaam() + " " + lin.getVoornaam()).equals(zoekView.getSelectionModel().getSelectedItem())) {
//                        geselecteerdeLeerling = lin;
//                        break;
//                    }
//                }
//
//                HoofdPaneel hoofdPanel = new HoofdPaneel(geselecteerdeLeerling); //HoofdPaneel(zoekView.getSelectionModel().getSelectedItem());
//                hoofdPanel.setInlogPaneel(this);
//                hoofdPanel.setScene(scene);
//                scene.setRoot(hoofdPanel);
//            }
            if (zoekView.getSelectionModel().getSelectedItem() != null) {
                HoofdPaneel hoofdPanel = new HoofdPaneel(zoekView.getSelectionModel().getSelectedItem(), schermformaat); //HoofdPaneel(zoekView.getSelectionModel().getSelectedItem());
                hoofdPanel.setInlogPaneel(this);
                hoofdPanel.setScene(scene);
                scene.setRoot(hoofdPanel);
            }
        });

        zoekView.setOnMouseClicked(event -> {
            Leerling geselecteerdeLeerling = null;

            for (Leerling lin : leerlingen) {
                if ((lin.getFamilienaam() + " " + lin.getVoornaam()).equals(zoekView.getSelectionModel().getSelectedItem())) {
                    geselecteerdeLeerling = lin;
                    break;
                }
            }
            if (geselecteerdeLeerling != null) {
                naamTextField.setText(geselecteerdeLeerling.getFamilienaam() + " " + geselecteerdeLeerling.getVoornaam());
                nummerTextField.setText(String.valueOf(geselecteerdeLeerling.getInschrijvingsNummer()));
                nummerTextField.setEditable(false);
            }
        });

        voegToeKnop.setOnMouseClicked(event -> {
//            String famNaam;
//            String voornaam;
//            String inschrijvingsNr;
//            String[] naam;
//            naam = naamTextField.getText().split(" ");
//            famNaam = naam[0];
//            voornaam = naam[1];
//            SecureRandom rand = new SecureRandom();
//            inschrijvingsNr = "rij00" + rand.nextInt(100);
//
//            leerlingen.add(new Leerling(famNaam, voornaam, inschrijvingsNr));
//            namen.add(famNaam + " " + voornaam);

//            llRepo.synchroniseer();
            VoegLeerlingToePaneel voegLeerlingToePaneel = new VoegLeerlingToePaneel(this, this.llRepo, schermformaat);
            voegLeerlingToePaneel.setScene(scene);
            scene.setRoot(voegLeerlingToePaneel);
        });
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void refreshList() {
        leerlingen.clear();
        leerlingen.addAll(llRepo.getLeerlingList());
    }
}
