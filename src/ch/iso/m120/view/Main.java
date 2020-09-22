package ch.iso.m120.view;

import ch.iso.m120.model.Database;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        {
            primaryStage.setTitle("Diethylamide");
            RootPane root = new RootPane();
            Scene theScene = new Scene(root);
            theScene.getStylesheets().add("style.css");
            Database.getINSTANCE().loadData();
            primaryStage.setScene( theScene );
            primaryStage.show();

        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
