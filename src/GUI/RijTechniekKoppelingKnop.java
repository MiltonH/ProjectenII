package GUI;

import java.util.Collections;
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

public class RijTechniekKoppelingKnop extends GridPane {

    int bedieningInt = 0;
    int gebruikInt = 0;
    int doseringInt = 0;
    int volledigInt = 0;
    int voetAfInt = 0;
    int onnodigInt = 0;
    int bochtInt = 0;

    public RijTechniekKoppelingKnop() {
        setId("rijTechniekHoofdschermPaneel");

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
        Rectangle kotje1 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle kotje2 = new Rectangle(grootte, grootte, Color.WHITE);
        Rectangle kotje3 = new Rectangle(grootte, grootte, Color.WHITE);

        remBox.getChildren().addAll(kotje1, kotje2, kotje3);
        gridKnopPane.add(remBox, 0, 1);

        //Listview
        ObservableList<String> opmerkingenList = FXCollections.observableArrayList();;
        Collections.sort(opmerkingenList);
        ListView<String> opmerkingenView = new ListView<String>(opmerkingenList);

        //Tekst
        TextField invulTextField = new TextField();
        invulTextField.setId("inlogTexfield");
        invulTextField.setPromptText("Geef een opmerking");
        invulTextField.setId("attitudeTextField");
        invulTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    opmerkingenList.add(invulTextField.getText());
                    invulTextField.clear();
                }
            }
        });

        //Listview
        ObservableList<String> opmerkingenList2 = FXCollections.observableArrayList();;
        Collections.sort(opmerkingenList2);
        ListView<String> opmerkingenView2 = new ListView<String>(opmerkingenList2);

        //Tekst
        TextField invulTextField2 = new TextField();
        invulTextField2.setId("inlogTexfield");
        invulTextField2.setPromptText("Geef een opmerking");
        invulTextField2.setId("attitudeTextField");
        invulTextField2.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    opmerkingenList2.add(invulTextField2.getText());
                    invulTextField2.clear();
                }
            }
        });

        //knoppen
        Button bediening = new Button("Bediening");
        bediening.setId("inlogButtons");
        add(bediening, 2, 1);

        Button gebruik = new Button("Gebruik");
        gebruik.setId("inlogButtons");
        add(gebruik, 2, 5);

        Button dosering = new Button("Dosering");
        dosering.setId("inlogButtons");
        add(dosering, 3, 1);
        dosering.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (doseringInt != 3) {
                    doseringInt++;
                    toggleColor(dosering, doseringInt);
                } else {
                    doseringInt = 0;
                    toggleColor(dosering, doseringInt);
                }
                kleurtjesBediening(bediening, bedieningInt);
            }
        });

        Button volledig = new Button("Volledig");
        volledig.setId("inlogButtons");
        add(volledig, 3, 2);
        volledig.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (volledigInt != 3) {
                    volledigInt++;
                    toggleColor(volledig, volledigInt);
                } else {
                    volledigInt = 0;
                    toggleColor(volledig, volledigInt);
                }
                kleurtjesBediening(bediening, bedieningInt);
            }
        });

        Button voetAf = new Button("Voet af");
        voetAf.setId("inlogButtons");
        add(voetAf, 3, 3);
        voetAf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (voetAfInt != 3) {
                    voetAfInt++;
                    toggleColor(voetAf, voetAfInt);
                } else {
                    voetAfInt = 0;
                    toggleColor(voetAf, voetAfInt);
                }
                kleurtjesBediening(bediening, bedieningInt);
            }
        });

        Button andere1 = new Button("Andere");
        andere1.setId("inlogButtons");
        add(andere1, 3, 4);
        andere1.setOnMouseClicked(event -> {
            add(invulTextField, 4, 4);
            add(opmerkingenView, 4, 2, 1, 2);
        });

        Button onNodig = new Button("Onnodig");
        onNodig.setId("inlogButtons");
        add(onNodig, 3, 5);
        onNodig.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (onnodigInt != 3) {
                    onnodigInt++;
                    toggleColor(onNodig, onnodigInt);
                } else {
                    onnodigInt = 0;
                    toggleColor(onNodig, onnodigInt);
                }
                kleurtjesGebruik(gebruik, gebruikInt);
            }
        });

        Button Bocht = new Button("Bocht");
        Bocht.setId("inlogButtons");
        add(Bocht, 3, 6);
        Bocht.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (bochtInt != 3) {
                    bochtInt++;
                    toggleColor(Bocht, bochtInt);
                } else {
                    bochtInt = 0;
                    toggleColor(Bocht, bochtInt);
                }
                kleurtjesGebruik(gebruik, gebruikInt);
            }
        });

        Button andere2 = new Button("Andere");
        andere2.setId("inlogButtons");
        add(andere2, 3, 7);
        andere2.setOnMouseClicked(event -> {
            add(invulTextField2, 4, 7);
            add(opmerkingenView2, 4, 5, 1, 2);
        });
        
        int vakInt = gebruikInt + bedieningInt;
        if (gebruikInt == 0 || bedieningInt == 0) {
            kotje1.setFill(Color.WHITE);
        } else if (vakInt == 2 || vakInt == 3) {
            kotje1.setFill(Color.RED);
        } else if (vakInt == 4 || vakInt == 5) {
            kotje1.setFill(Color.ORANGE);
        } else if (vakInt == 6) {
            kotje1.setFill(Color.GREENYELLOW);
        }
    }

    private void toggleColor(Button button, int integer) {
        if (integer == 1) {
            button.setId("buttonKleurRood");
        } else if (integer == 2) {
            button.setId("buttonKleurOranje");
        } else if (integer == 3) {
            button.setId("buttonKleurGroen");
        } else if (integer == 0) {
            button.setId("inlogButtons");
        }
    }
    
    private void kleurtjesGebruik(Button button, int integer) {
        int buttonInt = onnodigInt + bochtInt;
        if (onnodigInt == 0 || bochtInt == 0) {
            button.setId("inlogButtons");
            integer = 0;
        } else if (buttonInt == 2 || buttonInt == 3) {
            button.setId("buttonKleurRood");
            integer = 1;
        } else if (buttonInt == 4 || buttonInt == 5) {
            button.setId("buttonKleurOranje");
            integer = 2;
        } else if (buttonInt == 6) {
            button.setId("buttonKleurGroen");
            integer = 3;
        }
    }

    private void kleurtjesBediening(Button button, int integer) {
        int buttonInt = doseringInt + volledigInt + voetAfInt;
        if (doseringInt == 0 || volledigInt == 0 || voetAfInt == 0) {
            button.setId("inlogButtons");
            integer = 0;
        } else if (buttonInt == 3 || buttonInt == 4 || buttonInt == 5) {
            button.setId("buttonKleurRood");
            integer = 1;
        } else if (buttonInt == 5 || buttonInt == 6 || buttonInt == 7 || buttonInt == 8) {
            button.setId("buttonKleurOranje");
            integer = 2;
        } else if (buttonInt == 9) {
            button.setId("buttonKleurGroen");
            integer = 3;
        }
    }
    
//    private void kleurtjes(Rectangle rect) {
//        int vakInt = gebruikInt + bedieningInt;
//        if (gebruikInt == 0 || bedieningInt == 0) {
//            rect.setFill(Color.WHITE);
//        } else if (vakInt == 2 || vakInt == 3) {
//            rect.setFill(Color.RED);
//        } else if (vakInt == 4 || vakInt == 5) {
//            rect.setFill(Color.ORANGE);
//        } else if (vakInt == 6) {
//            rect.setFill(Color.GREENYELLOW);
//        }
//    }
}