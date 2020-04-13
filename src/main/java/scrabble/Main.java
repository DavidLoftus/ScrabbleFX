package scrabble;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static boolean BOT_GAME = true;
    public static int BOT_DELAY = 3; // s

    public static void main(String[] args) throws FileNotFoundException {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, InterruptedException {
        Scrabble scrabble = new Scrabble();
        UserInterface ui = new UserInterface(scrabble);
        Bots bots = new Bots(scrabble, ui, getParameters());
        ui.setBots(bots);
        ui.displayStage(primaryStage);
    }
}
