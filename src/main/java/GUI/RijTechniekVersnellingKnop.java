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

public class RijTechniekVersnellingKnop extends GridPane implements View
{

    private RijTechniekBase base;
    private EvaluatieFormulier huidigformulier;
    private ObservableList<String> opmerkingenList;
    private ObservableList<String> opmerkingenList2;
    private Rectangle kotje1;
    private Rectangle kotje2;
    private Rectangle kotje3;
    private Hashtable<String, Button> buttons;
    private Boolean andere1Bool;
    private Boolean andere2Bool;

    public RijTechniekVersnellingKnop(RijTechniekBase base) {
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
        rij0.setPercentHeight(2);
        RowConstraints rij1 = new RowConstraints();
        rij1.setPercentHeight(24);
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
        rij6.setPercentHeight(2);

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

        //versnelling
        Image knopVierkant = new Image("Images/knopVierkant.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true);
        ImageView versnellingView = new ImageView(knopVierkant);
        gridKnopPane.add(versnellingView, 0, 0);

        Image afbknop = new Image("Images/pook_1.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        ImageView knopView = new ImageView(afbknop);
        gridKnopPane.add(knopView, 0, 0);

        versnellingView.setOnMouseClicked(event -> {
            huidigformulier.setSchakelRec(base.toggleKleur(huidigformulier.getSchakelRec()));
            update();
        });
        knopView.setOnMouseClicked(event -> {
            huidigformulier.setSchakelRec(base.toggleKleur(huidigformulier.getSchakelRec()));
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
        invulTextField.setId("inlogTexfield");
        invulTextField.setPromptText("Geef een opmerking");
        invulTextField.setId("attitudeTextField");
        invulTextField.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    huidigformulier.getSchakelBedieningAndere().add(invulTextField.getText());
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
            huidigformulier.getSchakelBedieningAndere().remove(opmerkingenView.getSelectionModel().getSelectedItem());
            update();
        });

        HBox invoer = new HBox(20);
        setPadding(new Insets(10));
        invoer.setAlignment(Pos.CENTER);
        invoer.getChildren().addAll(aandacht, invulTextField);

        //Listview
        opmerkingenList2 = FXCollections.observableArrayList();;
        Collections.sort(opmerkingenList2);
        ListView<String> opmerkingenView2 = new ListView<String>(opmerkingenList2);

        //Tekst
        TextField invulTextField2 = new TextField();
        invulTextField2.setId("inlogTexfield");
        invulTextField2.setPromptText("Geef een opmerking");
        invulTextField2.setId("attitudeTextField");
        invulTextField2.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    huidigformulier.getSchakelGebruikAndere().add(invulTextField2.getText());
                    invulTextField2.clear();
                    update();
                }
            }
        });

        Button aandacht2 = new Button("!");
        aandacht2.setId("aandachtButtons");
        aandacht2.setOnAction(event -> {
            if (!huidigformulier.getOpmerkingen().contains(opmerkingenView.getSelectionModel().getSelectedItem())) {
                if (opmerkingenView.getSelectionModel().getSelectedItem() != null) {
                    huidigformulier.getOpmerkingen().add(opmerkingenView.getSelectionModel().getSelectedItem());
                }
            }
            huidigformulier.getSchakelGebruikAndere().remove(opmerkingenView.getSelectionModel().getSelectedItem());
            update();
        });

        HBox invoer2 = new HBox(20);
        setPadding(new Insets(10));
        invoer2.setAlignment(Pos.CENTER);
        invoer2.getChildren().addAll(aandacht2, invulTextField2);

        //knoppen
        Button bediening = new Button("Bediening");
        bediening.setId("buttons");
        bediening.setOnAction(event -> {
            huidigformulier.setSchakelBediening(base.toggleKleur(huidigformulier.getSchakelBediening()));
            update();
        });
        add(bediening, 2, 1);
        buttons.put("bediening", bediening);

        Button gebruik = new Button("Gebruik");
        gebruik.setId("buttons");
        gebruik.setOnAction(event -> {
            huidigformulier.setSchakelGebruik(base.toggleKleur(huidigformulier.getSchakelGebruik()));
            update();
        });
        add(gebruik, 2, 3);
        buttons.put("gebruik", gebruik);

        Button dosering = new Button("Dosering");
        dosering.setId("buttons");
        dosering.setOnAction(event -> {
            huidigformulier.setSchakelDosering(base.toggleKleur(huidigformulier.getSchakelDosering()));
            update();
        });
        add(dosering, 3, 1);
        buttons.put("dosering", dosering);

        andere1Bool = false;
        Button andere = new Button("Andere");
        andere.setId("buttons");
        add(andere, 3, 2);
        andere.setOnMouseClicked(event -> {
            if (!andere1Bool) {
                add(invoer, 4, 2);
                add(opmerkingenView, 4, 1);
                andere1Bool = true;
            }
        });

        Button aangepast = new Button("Aangepast");
        aangepast.setId("buttons");
        aangepast.setOnAction(event -> {
            huidigformulier.setSchakelAangepast(base.toggleKleur(huidigformulier.getSchakelAangepast()));
            update();
        });
        add(aangepast, 3, 3);
        buttons.put("aangepast", aangepast);

        Button motorRem = new Button("Motorrem");
        motorRem.setId("buttons");
        motorRem.setOnAction(event -> {
            huidigformulier.setSchakelMotorRem(base.toggleKleur(huidigformulier.getSchakelMotorRem()));
            update();
        });
        add(motorRem, 3, 4);
        buttons.put("motor", motorRem);

        andere2Bool = false;
        Button andere2 = new Button("Andere");
        andere2.setId("buttons");
        add(andere2, 3, 5);
        andere2.setOnMouseClicked(event -> {
            if (!andere2Bool) {
                add(invoer2, 4, 5);
                add(opmerkingenView2, 4, 4);
                andere2Bool = true;
            }
        });
        update();
    }

    @Override
    public void update() {
        huidigformulier = base.getHoofdpanel().getHuidigeLeerling().getHuidigEvaluatieFormulier();
        opmerkingenList.clear();
        opmerkingenList.addAll(huidigformulier.getSchakelBedieningAndere());
        opmerkingenList2.clear();
        opmerkingenList2.addAll(huidigformulier.getSchakelGebruikAndere());

        //buttons
        base.kleurButton(buttons.get("dosering"), huidigformulier.getSchakelDosering());

        base.kleurButton(buttons.get("aangepast"), huidigformulier.getSchakelAangepast());
        base.kleurButton(buttons.get("motor"), huidigformulier.getSchakelMotorRem());

        base.kleurButton(buttons.get("bediening"), huidigformulier.getSchakelBediening());

        base.kleurButton(buttons.get("gebruik"), huidigformulier.getSchakelGebruik());

        Leerling leerling = base.getHoofdpanel().getHuidigeLeerling();

        for (int i = 0; i < leerling.getEvaluatieFormulieren().size(); i++) {
            EvaluatieFormulier formulier = leerling.getEvaluatieFormulieren().get(i);
            if (i == 0) {
                base.kleurKotje(kotje1, formulier.getSchakelRec());
            }
            if (i == 1) {
                base.kleurKotje(kotje2, formulier.getSchakelRec());
            }
            if (i == 2) {
                base.kleurKotje(kotje3, formulier.getSchakelRec());
            }
        }
    }
}
