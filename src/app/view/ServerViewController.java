package app.view;

import app.Client;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

/**
 * Created by G0DZ on 04.05.2016.
 */
public class ServerViewController {
    /**
     * All fields and methods to which fxml is required the access
     * must be marked with the FXML-annotation. However, this is true
     * only for private fields and methods.
     */

    //описываем содержимое окна
    @FXML
    private Label addressLabel;

    @FXML
    private Button submit;

    @FXML
    private TextField addressTextField;

    // Reference to the main application.
    private Client client;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public ServerViewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        addressLabel.setText("imap server address:");
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param client
     * */
    public void setMainApp(Client client) {
        this.client = client;
    }

    /**
     * Called when the user clicks on the submit button.
     */
    @FXML
    private void handleSubmitAddress() {
        String address = addressTextField.getText();
        //address = address.replaceAll("\\s+","").replaceAll("\n","");
        if (!address.equals("")) {
            System.out.println(address);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(client.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
        }
    }
}
