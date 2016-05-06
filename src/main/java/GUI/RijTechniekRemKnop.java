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

public class RijTechniekRemKnop extends GridPane implements View
{

    RijTechniekBase base;
    EvaluatieFormulier huidigformulier;
    ObservableList<String> opmerkingenList;
    Rectangle kotje1;
    Rectangle kotje2;
    Rectangle kotje3;
    Hashtable<String, Button> buttons;
    Boolean andereBool;

    public RijTechniekRemKnop(RijTechniekBase base) {
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
        Image afbRem = new Image("Images/rem.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        ImageView remAfbView = new ImageView(afbRem);
        gridKnopPane.add(remView, 0, 0);
        gridKnopPane.add(remAfbView, 0, 0);

        remView.setOnMouseClicked(event -> {
            huidigformulier.setRemRec(base.toggleKleur(huidigformulier.getRemRec()));
            update();
        });
        remAfbView.setOnMouseClicked(event -> {
            huidigformulier.setRemRec(base.toggleKleur(huidigformulier.getRemRec()));
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
        opmerkingenList = FXCollections.observableArrayList();
        Collections.sort(opmerkingenList);
        ListView<String> opmerkingenView = new ListView<>(opmerkingenList);

        //Tekst
        Label opmerkingToegevoegdLbl = new Label("Uw opmerking\nis toegevoegd");
        opmerkingToegevoegdLbl.setId("opmerkingToegevoegd");
        TextField invulTextField = new TextField();
        invulTextField.setId("inlogTexfield");
        invulTextField.setPromptText("Geef een opmerking");
        invulTextField.setId("attitudeTextField");
        invulTextField.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    huidigformulier.getRemGebruikAndere().add(invulTextField.getText());
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
            huidigformulier.getRemGebruikAndere().remove(opmerkingenView.getSelectionModel().getSelectedItem());
            update();
        });

        HBox invoer = new HBox(20);
        setPadding(new Insets(10));
        invoer.setAlignment(Pos.CENTER);
        invoer.getChildren().addAll(aandacht, invulTextField);

        //knoppen
        Button bediening = new Button("Bediening");
        bediening.setId("buttons");
        bediening.setOnAction(event -> {
            huidigformulier.setRemBediening(base.toggleKleur(huidigformulier.getRemBediening()));
            update();
        });
        add(bediening, 2, 1);
        buttons.put("bediening", bediening);

        Button gebruik = new Button("Gebruik");
        gebruik.setId("buttons");
        gebruik.setOnAction(event -> {
            huidigformulier.setRemGebruik(base.toggleKleur(huidigformulier.getRemGebruik()));
            update();
        });
        add(gebruik, 2, 3);
        buttons.put("gebruik", gebruik);

        Button dosering = new Button("Dosering");
        dosering.setId("buttons");
        dosering.setOnAction(event -> {
            huidigformulier.setRemDosering(base.toggleKleur(huidigformulier.getRemDosering()));
            update();
        });
        add(dosering, 3, 1);
        buttons.put("dosering", dosering);

        Button volgorde = new Button("Volledig");
        volgorde.setId("buttons");
        volgorde.setOnAction(event -> {
            huidigformulier.setRemVolgorde(base.toggleKleur(huidigformulier.getRemVolgorde()));
            update();
        });
        add(volgorde, 3, 2);
        buttons.put("volgorde", volgorde);

        Button teLaat = new Button("Te laat");
        teLaat.setId("buttons");
        teLaat.setOnAction(event -> {
            huidigformulier.setRemTeLaat(base.toggleKleur(huidigformulier.getRemTeLaat()));
            update();
        });
        add(teLaat, 3, 3);
        buttons.put("telaat", teLaat);

        andereBool = false;
        Button andere = new Button("Andere");
        andere.setId("buttons");
        add(andere, 3, 4);
        andere.setOnMouseClicked(event -> {
            if (!andereBool) {
                add(invoer, 4, 4);
                add(opmerkingenView, 4, 3);
                andereBool = true;
            }
        });
        update();
    }

    @Override
    public void update() {
        huidigformulier = base.getHoofdpanel().getHuidigeLeerling().getHuidigEvaluatieFormulier();
        opmerkingenList.clear();
        opmerkingenList.addAll(huidigformulier.getRemGebruikAndere());

        //buttons
        base.kleurButton(buttons.get("dosering"), huidigformulier.getRemDosering());
        base.kleurButton(buttons.get("volgorde"), huidigformulier.getRemVolgorde());
        base.kleurButton(buttons.get("telaat"), huidigformulier.getRemTeLaat());

        base.kleurButton(buttons.get("bediening"), huidigformulier.getRemBediening());

        base.kleurButton(buttons.get("gebruik"), huidigformulier.getRemGebruik());

        Leerling leerling = base.getHoofdpanel().getHuidigeLeerling();

        for (int i = 0; i < leerling.getEvaluatieFormulieren().size(); i++) {
            EvaluatieFormulier formulier = leerling.getEvaluatieFormulieren().get(i);

            if (i == 0) {
                base.kleurKotje(kotje1, formulier.getRemRec());
            }
            if (i == 1) {
                base.kleurKotje(kotje2, formulier.getRemRec());
            }
            if (i == 2) {
                base.kleurKotje(kotje3, formulier.getRemRec());
            }
        }
    }
}
