package avivn.mmn12.q2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameOfLifeApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameOfLifeApplication.class.getResource("gol-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MMN 12 Q 2: Conway's Game of Life");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}