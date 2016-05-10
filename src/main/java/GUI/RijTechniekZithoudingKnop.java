/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import domain.Evaluatie;
import domain.EvaluatieFormulier;
import domain.Leerling;
import domain.View;
import java.util.Collections;
import java.util.Hashtable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
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

/**
 *
 * @author Dries Meert
 */
public class RijTechniekZithoudingKnop extends GridPane implements View
{

    private RijTechniekBase base;
    private EvaluatieFormulier huidigformulier;
    private ObservableList<String> opmerkingenList;
    private Rectangle kotje1;
    private Rectangle kotje2;
    private Rectangle kotje3;
    private Hashtable<String, Button> buttons;
    private Boolean andereBool;

    public RijTechniekZithoudingKnop(RijTechniekBase base) {
        setId("rijTechniekHoofdschermPaneel");

        this.base = base;
        base.getHoofdpanel().getHuidigeLeerling().addView(this);
        huidigformulier = base.getHoofdpanel().getHuidigeLeerling().getHuidigEvaluatieFormulier();
        buttons = new Hashtable<>();

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
        rij1.setPercentHeight(23);
        rij1.setValignment(VPos.BOTTOM);
        RowConstraints rij2 = new RowConstraints();
        rij2.setPercentHeight(18);
        RowConstraints rij3 = new RowConstraints();
        rij3.setPercentHeight(18);
        RowConstraints rij4 = new RowConstraints();
        rij4.setPercentHeight(18);
        RowConstraints rij5 = new RowConstraints();
        rij5.setPercentHeight(18);
        RowConstraints rij6 = new RowConstraints();
        rij6.setPercentHeight(3);

        getRowConstraints().addAll(rij0, rij1, rij2, rij3, rij4, rij5, rij6);

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

        Image afbknop = new Image("Images/zithouding.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        ImageView knopView = new ImageView(afbknop);
        gridKnopPane.add(knopView, 0, 0);

        remView.setOnMouseClicked(event -> {
            huidigformulier.setZithoudingRec(base.toggleKleur(huidigformulier.getZithoudingRec()));
            update();
        });
        knopView.setOnMouseClicked(event -> {
            huidigformulier.setZithoudingRec(base.toggleKleur(huidigformulier.getZithoudingRec()));
            update();
        });

        HBox remBox = new HBox();
        remBox.setAlignment(Pos.CENTER);
        remBox.setId("rijTechniekHoofdschermBox");

        double grootte = Math.ceil(maxWidth * 0.03);
        kotje1 = new Rectangle(grootte, grootte, Color.WHITE);
        kotje2 = new Rectangle(grootte, grootte, Color.WHITE);
        kotje3 = new Rectangle(grootte, grootte, Color.WHITE);

        remBox.getChildren().addAll(kotje1, kotje2, kotje3);
        gridKnopPane.add(remBox, 0, 1);

        //Listview
        opmerkingenList = FXCollections.observableArrayList();;
        Collections.sort(opmerkingenList);
        ListView<String> opmerkingenView = new ListView<String>(opmerkingenList);

        //Tekst
        Label opmerkingToegevoegdLbl = new Label("Uw opmerking\nis toegevoegd");
        opmerkingToegevoegdLbl.setId("opmerkingToegevoegd");
        TextField invulTextField = new TextField();
        invulTextField.setId("rijtechniekTexfield");
        invulTextField.setPromptText("Geef een opmerking");
        invulTextField.setId("attitudeTextField");
        invulTextField.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    huidigformulier.getZithoudingAndere().add(invulTextField.getText());
                    invulTextField.clear();
                    update();
                }
            }
        });

        Button aandacht = new Button("!");
        aandacht.setId("aandachtButtons");
        aandacht.setOnAction(event -> {
            if (!huidigformulier.getOpmerkingen().contains(opmerkingenView.getSelectionModel().getSelectedItem())) {
                if (opmerkingenView.getSelectionModel().getSelectedItem() != null) {
                    huidigformulier.getOpmerkingen().add(opmerkingenView.getSelectionModel().getSelectedItem());
                }
            }
            add(opmerkingToegevoegdLbl, 1, 2);
            huidigformulier.getZithoudingAndere().remove(opmerkingenView.getSelectionModel().getSelectedItem());
            update();
        });

        HBox invoer = new HBox(20);
        setPadding(new Insets(10));
        invoer.setAlignment(Pos.CENTER);
        invoer.getChildren().addAll(aandacht, invulTextField);

        //knoppen
        Button zithouding = new Button("Zithouding");
        zithouding.setId("buttons");
        zithouding.setOnAction(event -> {
            huidigformulier.setZithoudingZithouding(base.toggleKleur(huidigformulier.getZithoudingZithouding()));
            update();
        });
        add(zithouding, 2, 1);
        buttons.put("zithouding", zithouding);

        Button gordel = new Button("Gordel");
        gordel.setId("buttons");
        gordel.setOnAction(event -> {
            huidigformulier.setZithoudingGordel(base.toggleKleur(huidigformulier.getZithoudingGordel()));
            update();
        });
        add(gordel, 2, 2);
        buttons.put("gordel", gordel);

        Button spiegels = new Button("Spiegels");
        spiegels.setId("buttons");
        spiegels.setOnAction(event -> {
            huidigformulier.setZithoudingSpiegels(base.toggleKleur(huidigformulier.getZithoudingSpiegels()));
            update();
        });
        add(spiegels, 2, 3);
        buttons.put("spiegels", spiegels);

        Button handrem = new Button("Handrem");
        handrem.setId("buttons");
        handrem.setOnAction(event -> {
            huidigformulier.setZithoudingHandrem(base.toggleKleur(huidigformulier.getZithoudingHandrem()));
            update();
        });
        add(handrem, 2, 4);
        buttons.put("handrem", handrem);

        andereBool = false;
        Button andere = new Button("Andere");
        andere.setId("buttons");
        add(andere, 2, 5);
        andere.setOnMouseClicked(event -> {
            if (!andereBool) {
                add(invoer, 3, 5);
                add(opmerkingenView, 3, 3, 1, 2);
                andereBool = true;
            }
        });
        update();
    }

    @Override
    public void update() {
        huidigformulier = base.getHoofdpanel().getHuidigeLeerling().getHuidigEvaluatieFormulier();
        opmerkingenList.clear();
        opmerkingenList.addAll(huidigformulier.getZithoudingAndere());

        //buttons
        base.kleurButton(buttons.get("zithouding"), huidigformulier.getZithoudingZithouding());
        base.kleurButton(buttons.get("gordel"), huidigformulier.getZithoudingGordel());
        base.kleurButton(buttons.get("spiegels"), huidigformulier.getZithoudingSpiegels());
        base.kleurButton(buttons.get("handrem"), huidigformulier.getZithoudingHandrem());

        Leerling leerling = base.getHoofdpanel().getHuidigeLeerling();

        for (int i = 0; i < leerling.getEvaluatieFormulieren().size(); i++) {
            EvaluatieFormulier formulier = leerling.getEvaluatieFormulieren().get(i);
            if (i == 0) {
                base.kleurKotje(kotje1, formulier.getZithoudingRec());
            }
            if (i == 1) {
                base.kleurKotje(kotje2, formulier.getZithoudingRec());
            }
            if (i == 2) {
                base.kleurKotje(kotje3, formulier.getZithoudingRec());
            }
        }
        base.getHoofdpanel().getHuidigeLeerling().updateLastEdit();
    }
}
