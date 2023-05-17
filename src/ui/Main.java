package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    //Relationship.

    private MasterGUI masterGUI;

    public Main() {
        masterGUI = new MasterGUI();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("assets/main.fxml"));

        fxmlLoader.setController(masterGUI);
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Jfx-Cybersecurity");
        primaryStage.setResizable(false);
        primaryStage.show();




    }
}
