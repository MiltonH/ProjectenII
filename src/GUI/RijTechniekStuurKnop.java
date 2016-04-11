package GUI;

import domain.Evaluatie;
import domain.EvaluatieFormulier;
import domain.Leerling;
import domain.View;
import java.util.Collections;
import java.util.Hashtable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
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

public class RijTechniekStuurKnop extends GridPane implements View
{

    RijTechniekBase base;
    EvaluatieFormulier huidigformulier;
    ObservableList<String> opmerkingenList;
    Rectangle kotje1;
    Rectangle kotje2;
    Rectangle kotje3;
    Hashtable<String, Button> buttons;

    public RijTechniekStuurKnop(RijTechniekBase base) {
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

        Image afbknop = new Image("Images/Stuur.png", Math.ceil(maxWidth * 0.07), USE_PREF_SIZE, true, true);
        ImageView knopView = new ImageView(afbknop);
        gridKnopPane.add(knopView, 0, 0);

        HBox stuurBox = new HBox();
        stuurBox.setAlignment(Pos.CENTER);
        stuurBox.setId("rijTechniekHoofdschermBox");

        double grootte = Math.ceil(maxWidth * 0.03);
        kotje1 = new Rectangle(grootte, grootte, Color.WHITE);
        kotje2 = new Rectangle(grootte, grootte, Color.WHITE);
        kotje3 = new Rectangle(grootte, grootte, Color.WHITE);

        stuurBox.getChildren().addAll(kotje1, kotje2, kotje3);
        gridKnopPane.add(stuurBox, 0, 1);

        //Listview
        opmerkingenList = FXCollections.observableArrayList();;
        Collections.sort(opmerkingenList);
        ListView<String> opmerkingenView = new ListView<String>(opmerkingenList);

        //Tekst
        TextField invulTextField = new TextField();
        invulTextField.setId("inlogTexfield");
        invulTextField.setPromptText("Geef een opmerking");
        invulTextField.setId("attitudeTextField");
        invulTextField.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    huidigformulier.getStuurAndere().add(invulTextField.getText());
                    invulTextField.clear();
                    update();
                }
            }
        });

        //knoppen
        Button dosering = new Button("Dosering");
        dosering.setId("buttons");
        add(dosering, 2, 1);
        dosering.setOnAction(event -> {
            huidigformulier.setStuurDosering(base.toggleKleur(huidigformulier.getStuurDosering()));
            update();
        });
        buttons.put("dosering", dosering);

        Button houding = new Button("Houding");
        houding.setId("buttons");
        add(houding, 2, 2);
        houding.setOnAction(event -> {
            huidigformulier.setStuurHouding(base.toggleKleur(huidigformulier.getStuurHouding()));
            update();
        });
        buttons.put("houding", houding);

        Button andere = new Button("Andere");
        andere.setId("buttons");
        add(andere, 2, 3);
        andere.setOnMouseClicked(event -> {
            add(invulTextField, 3, 3);
            add(opmerkingenView, 3, 2);
        });
        update();
    }

    @Override
    public void update() {
        huidigformulier = base.getHoofdpanel().getHuidigeLeerling().getHuidigEvaluatieFormulier();
        opmerkingenList.clear();
        opmerkingenList.addAll(huidigformulier.getStuurAndere());

        //buttons
        base.kleurButton(buttons.get("dosering"), huidigformulier.getStuurDosering());
        base.kleurButton(buttons.get("houding"), huidigformulier.getStuurHouding());

        Leerling leerling = base.getHoofdpanel().getHuidigeLeerling();

        for (int i = 0; i < leerling.getEvaluatieFormulieren().size(); i++) {
            EvaluatieFormulier formulier = leerling.getEvaluatieFormulieren().get(i);

            Evaluatie[] kotjeArr = {
                huidigformulier.getStuurDosering(), huidigformulier.getStuurHouding()
            };
            if (i == 0) {
                base.kleurKotje(kotje1, base.berekenComboKleur(kotjeArr));
            }
            if (i == 1) {
                base.kleurKotje(kotje2, base.berekenComboKleur(kotjeArr));
            }
            if (i == 2) {
                base.kleurKotje(kotje3, base.berekenComboKleur(kotjeArr));
            }
        }
    }
}
