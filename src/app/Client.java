package app;

import app.view.ServerViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class Client extends Application {

    private Stage primaryStage;
    private AnchorPane serverLayout;
    private AnchorPane mainLayout;
    private String imapAddress;
    private String userName;
    private String password;

    @Override
    public void start(Stage primaryStage) throws Exception{
        imapAddress = "";
        userName = "";
        password = "";
        this.primaryStage = primaryStage;
        // Set title to primaryStage.
        this.primaryStage.setTitle("MailClientFX");
        //инициализируем окно ввода адреса IMAP сервера
        initAddressView();
        onCenter();
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
            serverLayout = (AnchorPane) loader.load();
            // Give the controller access to the main app.
            ServerViewController controller = loader.getController();
            controller.setMainApp(this);
            //часть 2
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(Client.class.getResource("view/MainView.fxml"));
            mainLayout = (AnchorPane) loader2.load();
            // Show the scene containing the root layout.
            Scene scene = new Scene(serverLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void hideAndShowMain(){
        primaryStage.setScene(new Scene(mainLayout));
        onCenter();
    }

    private void onCenter(){
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public String getImapAddress() {
        return imapAddress;
    }

    public void setImapAddress(String imapAddress) {
        this.imapAddress = imapAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
