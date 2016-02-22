package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();

        InlogPaneel inlog = new InlogPaneel();
        Scene scene = new Scene(root, 1000, 1000);
        scene.getStylesheets().add("StyleSheets/Style.css");

        root.getChildren().addAll(inlog);
        primaryStage.setTitle("Rijschool Applicatie");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setFullScreen(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
