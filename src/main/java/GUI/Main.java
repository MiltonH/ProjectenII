package GUI;

import domain.LeerlingRepo;
import java.util.Stack;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application
{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        LeerlingRepo llrepo = new LeerlingRepo();
        InlogPaneel inlog = new InlogPaneel(llrepo);
        primaryStage.setTitle("Rijschool Applicatie");
        Rectangle2D schermformaat = Screen.getPrimary().getVisualBounds();

        Scene scene = new Scene(inlog, schermformaat.getWidth(), schermformaat.getHeight());
        scene.getStylesheets().add("StyleSheets/Style.css");
        inlog.setScene(scene);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setFullScreen(false);
        primaryStage.setOnCloseRequest(event -> {
            llrepo.shutdown();
        });
    }

}
