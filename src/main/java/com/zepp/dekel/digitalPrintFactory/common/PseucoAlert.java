package com.zepp.dekel.digitalPrintFactory.common;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class PseucoAlert extends Alert {

    /**
     * The stylesheet for this class.
     */
    private static final String STYLESHEET = PseucoAlert.class.getResource("/css/alert.css").toExternalForm();

    /**
     * Creates a new alert with custom settings.
     *
     * @param alertType The underlying alert type.
     * @see Alert
     * @see javafx.scene.control.Alert.AlertType
     */
    public PseucoAlert(Alert.AlertType alertType) {
        super(alertType);

        super.getDialogPane().getStylesheets().add(STYLESHEET);

        if (alertType == AlertType.NONE) {
            return;
        }

        final Label icon;
        switch (alertType) {
            case CONFIRMATION:
                icon = new Label("\uf058");
                icon.getStyleClass().add("custom-confirmation-graphic");
                break;
            case ERROR:
                icon = new Label("\uf057");
                icon.getStyleClass().add("custom-error-graphic");
                break;
            case INFORMATION:
                icon = new Label("\uf05a");
                icon.getStyleClass().add("custom-information-graphic");
                break;
            case WARNING:
                icon = new Label("\uf06a");
                icon.getStyleClass().add("custom-warning-graphic");
                break;
            default:
                icon = null; // Never happens.
        }

        // Already set by stylesheet, but overwritten by general label style.
        icon.setStyle("-fx-font-family: 'FontAwesome'");

        super.setGraphic(icon);
    }
}

