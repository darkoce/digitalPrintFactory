package com.zepp.dekel.digitalPrintFactory.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
//import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.zepp.dekel.digitalPrintFactory.common.PseucoAlert;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
//import org.controlsfx.control.Notifications;
//import org.controlsfx.control.action.Action;
import org.springframework.stereotype.Component;



@Component
public class LoginScreenController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField password;
    @FXML
    private StackPane stackPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void cancelButton(MouseEvent event) {

        /*JFXDialogLayout dialogLayout=new JFXDialogLayout();
        dialogLayout.setHeading(new Text("Close"));
        dialogLayout.setBody(new Text("Do You want to exit !"));

        JFXButton ok=new JFXButton("Ok");
        JFXButton Cancel=new JFXButton("Cancel");

        JFXDialog dialog = new JFXDialog(stackPane, dialogLayout, JFXDialog.DialogTransition.CENTER);

        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        Cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });

        dialogLayout.setActions(ok,Cancel);
        dialog.show();*/
        PseucoAlert alert = new PseucoAlert(Alert.AlertType.CONFIRMATION);
        //Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Izađi iz aplikacije");
        alert.setHeaderText("Da li želite da izađete iz aplikacije?");
        //alert.
        alert.setContentText("Izaberite opciju.");

        ButtonType buttonTypeOne = new ButtonType("Izađi");
        ButtonType buttonTypeTwo = new ButtonType("Odustani");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            // ... user chose "One"
            System.exit(0);
        } else if (result.get() == buttonTypeTwo) {
            return;
        } else {
            return;
        }

    }

    @FXML
    private void loginButton(MouseEvent event) {
            // logika za login za sada samo da se loguje
        }
}
