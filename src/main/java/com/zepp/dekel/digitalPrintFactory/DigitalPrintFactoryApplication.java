package com.zepp.dekel.digitalPrintFactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
// Prvo kreiramo springboot aplikaciju i onda dodamo u resources folder foldere css, img, fxml i u njima res. kreiramo neki fxml file sa odgovarajućom veličinom...
// **** staviti extends Application *****
@SpringBootApplication
public class DigitalPrintFactoryApplication  extends Application {
	private ConfigurableApplicationContext springContext;
	private Parent root;

	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(DigitalPrintFactoryApplication.class);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/welcome.fxml"));
		fxmlLoader.setControllerFactory(springContext::getBean);
		root = fxmlLoader.load();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setTitle("Digital Print Factory");
		primaryStage.getIcons().add(
				new Image(
						DigitalPrintFactoryApplication.class.getResourceAsStream( "/images/digitalPrintFactoryIco.png" )));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		springContext.stop();
	}

	public static void main(String[] args) {

		launch(DigitalPrintFactoryApplication.class, args);
	}

}
