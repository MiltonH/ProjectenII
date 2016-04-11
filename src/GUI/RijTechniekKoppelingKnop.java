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
import javafx.geometry.VPos;
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

public class RijTechniekKoppelingKnop extends GridPane implements View
{

    int bedieningInt = 0;
    int gebruikInt = 0;
    int doseringInt = 0;
    int volledigInt = 0;
    int voetAfInt = 0;
    int onnodigInt = 0;
    int bochtInt = 0;

    RijTechniekBase base;
    EvaluatieFormulier huidigformulier;
    ObservableList<String> opmerkingenList;
    ObservableList<String> opmerkingenList2;
    Rectangle kotje1;
    Rectangle kotje2;
    Rectangle kotje3;
    Hashtable<String, Button> buttons;

    public RijTechniekKoppelingKnop(RijTechniekBase base) {
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
        rij1.setPercentHeight(26);
        rij1.setValignment(VPos.BOTTOM);
        RowConstraints rij2 = new RowConstraints();
        rij2.setPercentHeight(12);
        RowConstraints rij3 = new RowConstraints();
        rij3.setPercentHeight(12);
        RowConstraints rij4 = new RowConstraints();
        rij4.setPercentHeight(12);
        RowConstraints rij5 = new RowConstraints();
        rij5.setPercentHeight(12);
        RowConstraints rij6 = new RowConstraints();
        rij6.setPercentHeight(12);
        RowConstraints rij7 = new RowConstraints();
        rij7.setPercentHeight(12);
        RowConstraints rij8 = new RowConstraints();
        rij8.setPercentHeight(1);

        getRowConstraints().addAll(rij0, rij1, rij2, rij3, rij4, rij5, rij6, rij7, rij8);

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

        //koppeling
        Image knopVierkant = new Image("Images/knopVierkant.png", Math.ceil(maxWidth * 0.14), USE_PREF_SIZE, true, true);
        ImageView koppelingView = new ImageView(knopVierkant);
        gridKnopPane.add(koppelingView, 0, 0);

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
        TextField invulTextField = new TextField();
        invulTextField.setId("inlogTexfield");
        invulTextField.setPromptText("Geef een opmerking");
        invulTextField.setId("attitudeTextField");
        invulTextField.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    huidigformulier.getKoppelingBedieningAndere().add(invulTextField.getText());
                    invulTextField.clear();
                    update();
                }
            }
        });

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
                    huidigformulier.getKoppelingGebruikAndere().add(invulTextField2.getText());
                    invulTextField2.clear();
                    update();
                }
            }
        });

        //knoppen
        Button bediening = new Button("Bediening");
        bediening.setId("buttons");
        add(bediening, 2, 1);
        buttons.put("bediening", bediening);

        Button gebruik = new Button("Gebruik");
        gebruik.setId("buttons");
        add(gebruik, 2, 5);
        buttons.put("gebruik", gebruik);

        Button dosering = new Button("Dosering");
        dosering.setId("buttons");
        add(dosering, 3, 1);
        dosering.setOnAction(event -> {
            huidigformulier.setKoppelingDosering(toggleKleur(huidigformulier.getKoppelingDosering()));
            update();
        });
        buttons.put("dosering", dosering);

        Button volledig = new Button("Volledig");
        volledig.setId("buttons");
        add(volledig, 3, 2);
        volledig.setOnAction(event -> {
            huidigformulier.setKoppelingVolledig(toggleKleur(huidigformulier.getKoppelingVolledig()));
            update();
        });
        buttons.put("volledig", volledig);

        Button voetAf = new Button("Voet af");
        voetAf.setId("buttons");
        add(voetAf, 3, 3);
        voetAf.setOnAction(event -> {
            huidigformulier.setKoppelingVoetaf(toggleKleur(huidigformulier.getKoppelingVoetaf()));
            update();
        });
        buttons.put("voetaf", voetAf);

        Button andere1 = new Button("Andere");
        andere1.setId("buttons");
        add(andere1, 3, 4);
        andere1.setOnMouseClicked(event -> {
            add(invulTextField, 4, 4);
            add(opmerkingenView, 4, 2, 1, 2);
        });

        Button onNodig = new Button("Onnodig");
        onNodig.setId("buttons");
        add(onNodig, 3, 5);
        onNodig.setOnAction(event -> {
            huidigformulier.setKoppelingOnnodig(toggleKleur(huidigformulier.getKoppelingOnnodig()));
            update();
        });
        buttons.put("onnodig", onNodig);

        Button bocht = new Button("Bocht");
        bocht.setId("buttons");
        add(bocht, 3, 6);
        bocht.setOnAction(event -> {
            huidigformulier.setKoppelingBocht(toggleKleur(huidigformulier.getKoppelingBocht()));
            update();
        });
        buttons.put("bocht", bocht);

        Button andere2 = new Button("Andere");
        andere2.setId("buttons");
        add(andere2, 3, 7);
        andere2.setOnMouseClicked(event -> {
            add(invulTextField2, 4, 7);
            add(opmerkingenView2, 4, 5, 1, 2);
        });

        update();
    }

//    private void toggleColor(Button button, int integer) {
//        if (integer == 1) {
//            button.setId("buttonKleurRood");
//        } else if (integer == 2) {
//            button.setId("buttonKleurOranje");
//        } else if (integer == 3) {
//            button.setId("buttonKleurGroen");
//        } else if (integer == 0) {
//            button.setId("buttons");
//        }
//    }
    private Evaluatie toggleKleur(Evaluatie eval) {
        if (Evaluatie.WIT.equals(eval)) {
            return Evaluatie.ROOD;
        } else if (Evaluatie.ROOD.equals(eval)) {
            return Evaluatie.ORANJE;
        } else if (Evaluatie.ORANJE.equals(eval)) {
            return Evaluatie.GROEN;
        } else if (Evaluatie.GROEN.equals(eval)) {
            return Evaluatie.WIT;
        } else {
            return Evaluatie.WIT;
        }
    }

//    private void kleurtjesGebruik(Button button, int integer) {
//        int buttonInt = onnodigInt + bochtInt;
//        if (onnodigInt == 0 || bochtInt == 0) {
//            button.setId("buttons");
//            integer = 0;
//        } else if (buttonInt == 2 || buttonInt == 3) {
//            button.setId("buttonKleurRood");
//            integer = 1;
//        } else if (buttonInt == 4 || buttonInt == 5) {
//            button.setId("buttonKleurOranje");
//            integer = 2;
//        } else if (buttonInt == 6) {
//            button.setId("buttonKleurGroen");
//            integer = 3;
//        }
//    }
//
//    private void kleurtjesBediening(Button button, int integer) {
//        int buttonInt = doseringInt + volledigInt + voetAfInt;
//        if (doseringInt == 0 || volledigInt == 0 || voetAfInt == 0) {
//            button.setId("buttons");
//            integer = 0;
//        } else if (buttonInt == 3 || buttonInt == 4 || buttonInt == 5) {
//            button.setId("buttonKleurRood");
//            integer = 1;
//        } else if (buttonInt == 5 || buttonInt == 6 || buttonInt == 7 || buttonInt == 8) {
//            button.setId("buttonKleurOranje");
//            integer = 2;
//        } else if (buttonInt == 9) {
//            button.setId("buttonKleurGroen");
//            integer = 3;
//        }
//    }
    private void kleurButton(Button button, Evaluatie eval) {
        if (Evaluatie.WIT.equals(eval)) {
            button.setId("buttons");
        } else if (Evaluatie.ROOD.equals(eval)) {
            button.setId("buttonKleurRood");
        } else if (Evaluatie.ORANJE.equals(eval)) {
            button.setId("buttonKleurOranje");
        } else if (Evaluatie.GROEN.equals(eval)) {
            button.setId("buttonKleurGroen");
        } else {
            button.setId("buttons");
        }
    }

    public Evaluatie berekenComboKleur(Evaluatie[] evals) {
        int tot = evals.length * 3;
        int aantal = 0;

        for (Evaluatie ev : evals) {
            if (Evaluatie.WIT.equals(ev)) {
                aantal += 0;
            } else if (Evaluatie.ROOD.equals(ev)) {
                aantal += 1;
            } else if (Evaluatie.ORANJE.equals(ev)) {
                aantal += 2;
            } else if (Evaluatie.GROEN.equals(ev)) {
                aantal += 3;
            } else {
                aantal += 0;
            }
        }

        if (aantal == 0) {
            return Evaluatie.WIT;
        } else if (aantal == tot) {
            return Evaluatie.GROEN;
        } else if (aantal > (tot / 2) && aantal < tot) {
            return Evaluatie.ORANJE;
        } else if (aantal > 0 && aantal <= (tot / 2)) {
            return Evaluatie.ROOD;
        } else {
            return Evaluatie.WIT;
        }
    }

    private void kleurKotje(Rectangle rect, Evaluatie eval) {
        if (Evaluatie.WIT.equals(eval)) {
            rect.setFill(Color.WHITE);
        } else if (Evaluatie.ROOD.equals(eval)) {
            rect.setFill(Color.RED);
        } else if (Evaluatie.ORANJE.equals(eval)) {
            rect.setFill(Color.ORANGE);
        } else if (Evaluatie.GROEN.equals(eval)) {
            rect.setFill(Color.LIME);
        } else {
            rect.setFill(Color.WHITE);
        }
    }

    @Override
    public void update() {
        huidigformulier = base.getHoofdpanel().getHuidigeLeerling().getHuidigEvaluatieFormulier();
        opmerkingenList.clear();
        opmerkingenList.addAll(huidigformulier.getKoppelingBedieningAndere());
        opmerkingenList2.clear();
        opmerkingenList2.addAll(huidigformulier.getKoppelingGebruikAndere());

        //buttons
        kleurButton(buttons.get("dosering"), huidigformulier.getKoppelingDosering());
        kleurButton(buttons.get("volledig"), huidigformulier.getKoppelingVolledig());
        kleurButton(buttons.get("voetaf"), huidigformulier.getKoppelingVoetaf());
        kleurButton(buttons.get("onnodig"), huidigformulier.getKoppelingOnnodig());
        kleurButton(buttons.get("bocht"), huidigformulier.getKoppelingBocht());
        Evaluatie[] bedieningArr = {huidigformulier.getKoppelingDosering(), huidigformulier.getKoppelingVoetaf(), huidigformulier.getKoppelingVolledig()};
        kleurButton(buttons.get("bediening"), berekenComboKleur(bedieningArr));
        Evaluatie[] gebruikArr = {huidigformulier.getKoppelingOnnodig(), huidigformulier.getKoppelingBocht()};
        kleurButton(buttons.get("gebruik"), berekenComboKleur(gebruikArr));

        Leerling leerling = base.getHoofdpanel().getHuidigeLeerling();

        for (int i = 0; i < leerling.getEvaluatieFormulieren().size(); i++) {
            EvaluatieFormulier formulier = leerling.getEvaluatieFormulieren().get(i);

            Evaluatie[] kotjeArr = {
                formulier.getKoppelingDosering(), formulier.getKoppelingVoetaf(), formulier.getKoppelingVolledig(), formulier.getKoppelingOnnodig(), formulier.getKoppelingBocht()
            };
            if (i == 0) {
                kleurKotje(kotje1, berekenComboKleur(kotjeArr));
            }
            if (i == 1) {
                kleurKotje(kotje2, berekenComboKleur(kotjeArr));
            }
            if (i == 2) {
                kleurKotje(kotje3, berekenComboKleur(kotjeArr));
            }
        }
    }
}
