package Main.view;

import javafx.application.Application;
import javafx.stage.Stage;

public class DisplayView extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tax Calculator");
        primaryStage.show();
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to the Tax Calculator");
    }

}
