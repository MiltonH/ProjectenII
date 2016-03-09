package GUI;

import java.util.Stack;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application
{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        InlogPaneel inlog = new InlogPaneel();
        primaryStage.setTitle("Rijschool Applicatie");

        Scene scene = new Scene(inlog, 1200, 900);
        scene.getStylesheets().add("StyleSheets/Style.css");
        inlog.setScene(scene);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setFullScreen(true);
    }

}
