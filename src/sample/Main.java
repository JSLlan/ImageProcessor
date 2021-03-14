package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(final Stage primaryStage) {
        /*
        Structure:
        scene -> stackPane -> vbox -> imageGroup, btnBuilder (accessBox, filterBox)

        Design Pattern:
        Adapter pattern
        */
        try {
            //1.scene & stackPane
            StackPane stackPane = new StackPane();
            Scene scene = new Scene(stackPane);
            //2.vbox
            VBox vbox = new VBox(20);
            vbox.setAlignment(Pos.CENTER);
            //3.imageGroup, filterBtnGroup, fileAccessBtnGroup
            ImageGroup imageGroup = new ImageGroup();
            BtnGroupBuilder btnBuilder = new BtnGroupBuilder();// Adapter pattern
            HBox accessBox = btnBuilder.getBox("access", 10, Pos.CENTER, primaryStage);// for upload and download
            HBox filterBox = btnBuilder.getBox("filter", 10, Pos.CENTER, primaryStage);//for color filters
            //4.add (accessBox, filterBox, imageGroup) to vbox
            vbox.getChildren().addAll(accessBox,
                    filterBox,
                    imageGroup.getImageView(),
                    imageGroup.getImagePropertyText());
            //5.add vbox to stackPane
            stackPane.getChildren().addAll(vbox);
            //6.add scene to stage
            primaryStage.setTitle("JavaFX Image Processor");
            primaryStage.setScene(scene);
            primaryStage.setWidth(600);
            primaryStage.setHeight(500);
            primaryStage.show();
        } catch (Exception e){
            System.out.println(e.toString());
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
