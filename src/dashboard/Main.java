package dashboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.net.InetAddress;

import dashboard.tcp.server;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("IP Address:- " + inetAddress.getHostAddress());
        //TODO enter here your team number
        Thread t = new server(14872);
        t.start();


        File logoFile = new File("images/logo.png");
        Image logoImage = new Image(logoFile.toURI().toString());
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("FTC dashboard");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(logoImage);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
