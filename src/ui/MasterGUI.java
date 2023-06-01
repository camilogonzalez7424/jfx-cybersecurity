package ui;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.FileEncryptorDecryptor;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class MasterGUI {

    private FileEncryptorDecryptor coreEncryptorDecryptor;

    public MasterGUI() {
        coreEncryptorDecryptor = new FileEncryptorDecryptor();
    }
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
    private JFXTextField nameFileOut;

    @FXML
    private JFXTextField inputTextCifrar;

    @FXML
    private JFXTextField passwordCifrar;

    @FXML
    private JFXTextField nameFileOutDes;

    @FXML
    private JFXTextField passwordDescifrar;


    //Variables
    String inputFile = "";
    String outputFile = "";

    String password = "";


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



    @FXML
    public void findFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar archivo");


        java.io.File archivoSeleccionado = fileChooser.showOpenDialog(paneMainCifrar.getScene().getWindow());


        if (archivoSeleccionado != null) {
            inputFile = archivoSeleccionado.getAbsolutePath();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Diálogo de información...");
            alert.setHeaderText(null);
            alert.setContentText("El archivo seleccionado es: " + inputFile);
            alert.showAndWait();

            inputTextCifrar.setText(inputFile);

        } else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Diálogo de peligro...");
            alert.setHeaderText(null);
            alert.setContentText("No se seleccionó ningún archivo.");
            alert.showAndWait();
        }


    }



    @FXML
    private void cifrarFile(ActionEvent event) {
        outputFile = "src/"+nameFileOut.getText();
        password = passwordCifrar.getText();

        try {
            coreEncryptorDecryptor.encryptFile(inputFile, outputFile, password);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Diálogo de información...");
            alert.setHeaderText(null);
            alert.setContentText("Archivo cifrado correctamente.");
            alert.showAndWait();


            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("assets/main.fxml"));
            fxmlLoader.setController(this);
            Parent root = fxmlLoader.load();

            paneMainCifrar.getChildren().setAll(root);
        }catch (BadPaddingException e) {
            System.out.println("Falta la contraseña y/o es incorrecta");

        }catch (IOException e) {
            System.out.println("IOException");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException");
        } catch (InvalidKeySpecException e) {
            System.out.println("InvalidKeySpecException");

        } catch (NoSuchPaddingException e) {
            System.out.println("NoSuchPaddingException");

        } catch (InvalidKeyException e) {
            System.out.println("InvalidKeyException");

        } catch (IllegalBlockSizeException e) {
            System.out.println("IllegalBlockSizeException");

        } catch (InvalidAlgorithmParameterException e) {
            System.out.println("InvalidAlgorithmParameterException");
        }


    }

    @FXML
    public void descrifrarFile(ActionEvent event) {
        outputFile = "src/"+nameFileOutDes.getText();
        password = passwordDescifrar.getText();

        coreEncryptorDecryptor.decryptFile(inputFile,outputFile,password);





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
