package app;

import app.view.ServerViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Client extends Application {

    private Stage primaryStage;
    private AnchorPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        // Set title to primaryStage.
        this.primaryStage.setTitle("MailClientFX");
        //инициализируем окно ввода адреса IMAP сервера
        initAddressView();

        //Parent root = FXMLLoader.load(getClass().getResource("ServerView.fxml"));
        //primaryStage.setTitle("Hello World");
        //primaryStage.setScene(new Scene(root));
        //primaryStage.show();
    }


    /**
     * Initializes address view
     */
    public void initAddressView() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Client.class.getResource("view/ServerView.fxml"));
            rootLayout = (AnchorPane) loader.load();
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

            // Give the controller access to the main app.
            ServerViewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
