package sample;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BtnGroupBuilder implements BtnGroup {
    /*
    call by main program, use adpter class
     */
    BtnGroupAdapter adpter;

    @Override
    public HBox getBox(String type, double spacing, Pos position, Stage primaryStage) throws Exception {
        if(!type.equals("filter") && !type.equals("access")) throw new Exception("invalid type");
        adpter = new BtnGroupAdapter(type, spacing, position, primaryStage);
        return adpter.getButtonsBox();
    }
}
