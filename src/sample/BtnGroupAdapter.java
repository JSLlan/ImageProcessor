package sample;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BtnGroupAdapter{
    /*
    the real Adapter, provide proper button group instance for each type
     */
    AdvancedBtnGroup advBtnGrp;

    public BtnGroupAdapter(String type, double spacing, Pos position, Stage primaryStage) {
        if (type.equals("filter")) {
            advBtnGrp = new FilterBtns(spacing, position);
        } else if (type.equals("access")) {
            advBtnGrp = new FileAccessBtns(spacing, position, primaryStage);
        } else System.out.println("invalid type");
    }

    public HBox getButtonsBox() {
        return advBtnGrp.getButtonsBox();
    }
}
