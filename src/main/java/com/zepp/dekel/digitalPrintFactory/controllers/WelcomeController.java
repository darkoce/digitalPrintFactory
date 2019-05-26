package com.zepp.dekel.digitalPrintFactory.controllers;

import com.sun.javafx.charts.ChartLayoutAnimator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class WelcomeController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    private Label label;

    @FXML
    private ImageView image;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        FadeTransition fadeTransition=new FadeTransition(Duration.millis(5000),image);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0);

        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Stage loginScreen=new Stage();
                Parent root=null;

                try {
                    root=FXMLLoader.load(getClass().getResource("/fxml/loginScreen.fxml"));
                } catch (Exception e) {
                }

                Stage current=(Stage)image.getScene().getWindow();
                Scene scene=new Scene(root,720,600);

                loginScreen.setScene(scene);
                loginScreen.initStyle(StageStyle.TRANSPARENT);
                current.hide();
                loginScreen.show();

            }
        });
        fadeTransition.play();

    }
}
