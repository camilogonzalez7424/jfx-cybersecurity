package ui;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MasterGUI {

    @FXML
    private BorderPane boderPaneMain;

    @FXML
    private AnchorPane paneMain;


    @FXML
    private AnchorPane paneMainCifrar;

    @FXML
    private Pane imgPaneMain;

    @FXML
    private JFXTextArea textWelcome;

    @FXML
    private JFXTextArea textExplain;



    @FXML
    public void cifrarBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource( "assets/cifrar.fxml"));
        fxmlLoader.setController(this);
        Parent view = fxmlLoader.load();
        paneMain.getChildren().setAll(view);

    }

    @FXML
    public void descrifrarBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource( "assets/descifrar.fxml"));
        fxmlLoader.setController(this);
        Parent view = fxmlLoader.load();
        paneMain.getChildren().setAll(view);
    }

    @FXML
    public void backBtnCifrar(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource( "assets/main.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();

        paneMainCifrar.getChildren().setAll(root);


    }




    public BorderPane getBorderPane() {
        return boderPaneMain;
    }

    public AnchorPane getAnchorPane(){
        return paneMain;
    }

    public void setBorderPane(BorderPane boderPane) {
        this.boderPaneMain = boderPane;
    }





}
