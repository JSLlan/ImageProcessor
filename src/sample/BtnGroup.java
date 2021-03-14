package sample;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public interface BtnGroup {
    /*
    interface for Adapter pattern
     */
    HBox getBox(String type, double spacing, Pos position, Stage primaryStage) throws Exception;
}
