package GUI;

import java.util.Stack;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application
{
    
    
//    @Override
//    public void start(Stage primaryStage) {
//        int keuze = 0;
//        primaryStage.setTitle("Rijschool Applicatie");
//        primaryStage.setScene(keuze(keuze));
//        primaryStage.show();
//
//        primaryStage.setFullScreen(true);
//    }
//    
//    public Scene keuze(int keuze) {
//        if (keuze == 0){
//        StackPane root = new StackPane();
//        InlogPaneel inlog = new InlogPaneel();
//        Scene scene = new Scene(root, 1000, 1000);
//        scene.getStylesheets().add("StyleSheets/Style.css");
//        root.getChildren().addAll(inlog);
//        return scene;
//        }
//        
//        if (keuze == 1){
//        StackPane root2 = new StackPane();
//        HoofdPaneel hoofdpaneel = new HoofdPaneel();
//        Scene scene2 = new Scene(root2, 1000, 1000);
//        scene2.getStylesheets().add("StyleSheets/Style.css");
//        root2.getChildren().addAll(hoofdpaneel);
//        return scene2;
//        }
//        
//        return null;
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}

    private Stack<Scene> scenes = new Stack<Scene>();
    private Stage primaryStage;
    StackPane root = new StackPane();
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Rijschool Applicatie");
        Scene scene = getScene("INLOG");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public Scene getScene(String choice) {

        Scene scene = null;
        
        if (choice.equals("INLOG")) {
            InlogPaneel inlog = new InlogPaneel();
            scene = createNewScene(inlog);
            scenes.push(scene);
        }
        
        if (choice.equals("HOOFD")) {
            HoofdPaneel hoofd = new HoofdPaneel();
            scene = createNewScene(hoofd);
            scenes.push(scene);
        }    

        return scene;
    }
    
    private Scene createNewScene(Object sceneContent) {
        Scene scene = new Scene(root, 1000, 1000);
        scene.getStylesheets().add("StyleSheets/Style.css");
        return scene;
    }
    
    public void setScene(String choice) {
        primaryStage.setScene(getScene(choice));
        primaryStage.show();
    }
    
    public void returnToPreviousScene() {
        scenes.pop();
        primaryStage.setScene(scenes.peek());
    }
    
//    public void returnToSplashScreen() {
//        //--Clear the scene stack.
//        scenes.clear();
//        //--Bring up the splash screen
//        setScene("SPLASH");
//    }
    
}
