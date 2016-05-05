//package app.view;
//
//import app.Client;
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//
///**
// * Created by L8p on 05.05.2016.
// */
//public class MainViewController {
//    /**
//     * All fields and methods to which fxml is required the access
//     * must be marked with the FXML-annotation. However, this is true
//     * only for private fields and methods.
//     */
//
//    //описываем содержимое окна
//    @FXML
//    private Label addressLabel;
//
//    // Reference to the main application.
//    private Client client;
//
//    /**
//     * The constructor.
//     * The constructor is called before the initialize() method.
//     */
////    public ServerViewController() {
//    }
//
//    /**
//     * Initializes the controller class. This method is automatically called
//     * after the fxml file has been loaded.
//     */
//    @FXML
//    private void initialize() {
//        addressLabel.setText("imap server address:");
//        userNameLabel.setText("username:");
//        passwordLabel.setText("password:");
//        addressTextField.setText("imap.gmail.com");
//        userNameTextField.setText("00x7c0@gmail.com");
//        passwordField.setText("?!cv89erOP");
//    }
//
//    /**
//     * Is called by the main application to give a reference back to itself.
//     *
//     * @param client
//     * */
//    public void setMainApp(Client client) {
//        this.client = client;
//    }
//
//    /**
//     * Called when the user clicks on the submit button.
//     */
//    @FXML
//    private void handleSubmitAddress() {
//        client.setImapAddress(addressTextField.getText());
//        client.setPassword(passwordField.getText());
//        client.setUserName(userNameTextField.getText());
//        //address = address.replaceAll("\\s+","").replaceAll("\n","");
//        if (!client.getImapAddress().equals("")) {
//            //System.out.println(client.getImapAddress() + client.getUserName() + client.getPassword());
//            client.hideAndShowMain();
//        } else {
//            // Nothing selected.
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.initOwner(client.getPrimaryStage());
//            alert.setTitle("No Selection");
//            alert.setHeaderText("No Person Selected");
//            alert.setContentText("Please select a person in the table.");
//            alert.showAndWait();
//        }
//    }
//}
