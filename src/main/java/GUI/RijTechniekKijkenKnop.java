package GUI;

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

public class RijTechniekKijkenKnop extends GridPane implements View
{

    private RijTechniekBase base;
    private EvaluatieFormulier huidigformulier;
    private ObservableList<String> opmerkingenList;
    private Rectangle kotje1;
    private Rectangle kotje2;
    private Rectangle kotje3;
    private Hashtable<String, Button> buttons;
    private Boolean andereBool;

    public RijTechniekKijkenKnop(RijTechniekBase base,Rectangle2D formaat) {
        setId("rijTechniekHoofdschermPaneel");

        this.base = base;
        base.getHoofdpanel().getHuidigeLeerling().addView(this);
        huidigformulier = base.getHoofdpanel().getHuidigeLeerling().getHuidigEvaluatieFormulier();
        buttons = new Hashtable<>();

        //einde grid indeling
        Rectangle2D schermformaat = formaat;
        double maxWidth = schermformaat.getWidth() * 0.62;

        //grid
        gridLinesVisibleProperty().set(false);

        ColumnConstraints kolom0 = new ColumnConstraints();
        kolom0.setPercentWidth(2);
        ColumnConstraints kolom1 = new ColumnConstraints();
        kolom1.setPercentWidth(14);
        kolom1.setHalignment(HPos.CENTER);
        ColumnConstraints kolom2 = new ColumnConstraints();
        kolom2.setPercentWidth(41);
        kolom2.setHalignment(HPos.CENTER);
        ColumnConstraints kolom3 = new ColumnConstraints();
        kolom3.setPercentWidth(41);
        kolom3.setHalignment(HPos.CENTER);
        ColumnConstraints kolom4 = new ColumnConstraints();
        kolom4.setPercentWidth(2);

        getColumnConstraints().addAll(kolom0, kolom1, kolom2, kolom3, kolom4);

        RowConstraints rij0 = new RowConstraints();
        rij0.setPercentHeight(3);
        RowConstraints rij1 = new RowConstraints();
        rij1.setPercentHeight(24);
        rij1.setValignment(VPos.BOTTOM);
        RowConstraints rij2 = new RowConstraints();
        rij2.setPercentHeight(14);
        RowConstraints rij3 = new RowConstraints();
        rij3.setPercentHeight(14);
        RowConstraints rij4 = new RowConstraints();
        rij4.setPercentHeight(14);
        RowConstraints rij5 = new RowConstraints();
        rij5.setPercentHeight(14);
        RowConstraints rij6 = new RowConstraints();
        rij6.setPercentHeight(14);
        RowConstraints rij7 = new RowConstraints();
        rij7.setPercentHeight(3);

        getRowConstraints().addAll(rij0, rij1, rij2, rij3, rij4, rij5, rij6, rij7);

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
        ImageView kijkenView = new ImageView(knopVierkant);
        Image afbVersnelling = new Image("Images/Kijken.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        ImageView remVersnelling = new ImageView(afbVersnelling);
        gridKnopPane.add(kijkenView, 0, 0);
        gridKnopPane.add(remVersnelling, 0, 0);

        kijkenView.setOnMouseClicked(event -> {
            huidigformulier.setKijkRec(base.toggleKleur(huidigformulier.getKijkRec()));
            update();
        });
        remVersnelling.setOnMouseClicked(event -> {
            huidigformulier.setKijkRec(base.toggleKleur(huidigformulier.getKijkRec()));
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
                    huidigformulier.getKijkAndere().add(invulTextField.getText());
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
            huidigformulier.getKijkAndere().remove(opmerkingenView.getSelectionModel().getSelectedItem());
            update();
        });

        HBox invoer = new HBox(20);
        setPadding(new Insets(10));
        invoer.setAlignment(Pos.CENTER);
        invoer.getChildren().addAll(aandacht, invulTextField);

        //knoppen
        Button beterVergewissen = new Button("Beter Vergewissen");
        beterVergewissen.setId("buttons");
        beterVergewissen.setOnAction(event -> {
            huidigformulier.setKijkVergewis(base.toggleKleur(huidigformulier.getKijkVergewis()));
            update();
        });
        add(beterVergewissen, 2, 1);
        buttons.put("vergewis", beterVergewissen);

        Button spiegels = new Button("Spiegels");
        spiegels.setId("buttons");
        spiegels.setOnAction(event -> {
            huidigformulier.setKijksSpiegels(base.toggleKleur(huidigformulier.getKijksSpiegels()));
            update();
        });
        add(spiegels, 2, 2);
        buttons.put("spiegels", spiegels);

        Button dodeHoek = new Button("Dode Hoek");
        dodeHoek.setId("buttons");
        dodeHoek.setOnAction(event -> {
            huidigformulier.setKijkDodeHoek(base.toggleKleur(huidigformulier.getKijkDodeHoek()));
            update();
        });
        add(dodeHoek, 2, 3);
        buttons.put("dodehoek", dodeHoek);

        Button verGenoeg = new Button("Ver Genoeg");
        verGenoeg.setId("buttons");
        verGenoeg.setOnAction(event -> {
            huidigformulier.setKijkVer(base.toggleKleur(huidigformulier.getKijkVer()));
            update();
        });
        add(verGenoeg, 2, 4);
        buttons.put("ver", verGenoeg);

        Button selecteren = new Button("Selecteren");
        selecteren.setId("buttons");
        selecteren.setOnAction(event -> {
            huidigformulier.setKijkSelecteren(base.toggleKleur(huidigformulier.getKijkSelecteren()));
            update();
        });
        add(selecteren, 2, 5);
        buttons.put("selecteren", selecteren);

        andereBool = false;
        Button andere = new Button("Andere");
        andere.setId("buttons");
        add(andere, 2, 6);
        andere.setOnMouseClicked(event -> {
            if (!andereBool) {
                add(invoer, 3, 6);
                add(opmerkingenView, 3, 4, 1, 2);
                andereBool = true;
            }
        });
        update();
    }

    @Override
    public void update() {
        huidigformulier = base.getHoofdpanel().getHuidigeLeerling().getHuidigEvaluatieFormulier();
        opmerkingenList.clear();
        opmerkingenList.addAll(huidigformulier.getKijkAndere());

        //buttons
        base.kleurButton(buttons.get("vergewis"), huidigformulier.getKijkVergewis());
        base.kleurButton(buttons.get("spiegels"), huidigformulier.getKijksSpiegels());
        base.kleurButton(buttons.get("dodehoek"), huidigformulier.getKijkDodeHoek());
        base.kleurButton(buttons.get("ver"), huidigformulier.getKijkVer());
        base.kleurButton(buttons.get("selecteren"), huidigformulier.getKijkSelecteren());

        Leerling leerling = base.getHoofdpanel().getHuidigeLeerling();

        for (int i = 0; i < leerling.getEvaluatieFormulieren().size(); i++) {
            EvaluatieFormulier formulier = leerling.getEvaluatieFormulieren().get(i);

            if (i == 0) {
                base.kleurKotje(kotje1, formulier.getKijkRec());
            }
            if (i == 1) {
                base.kleurKotje(kotje2, formulier.getKijkRec());
            }
            if (i == 2) {
                base.kleurKotje(kotje3, formulier.getKijkRec());
            }
        }
        base.getHoofdpanel().getHuidigeLeerling().updateLastEdit();
    }
}
