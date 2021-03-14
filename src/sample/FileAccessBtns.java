package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileAccessBtns implements AdvancedBtnGroup {
    /**
     * button group, contains upload and download button
     */

    HBox ButtonsBox;
    Stage primaryStage;

    public FileAccessBtns(double spacing, Pos position, Stage primaryStage) {
        ButtonsBox = new HBox();
        ButtonsBox.setSpacing(spacing);
        ButtonsBox.setAlignment(position);
        this.primaryStage = primaryStage;
        initButtons();
    }

    @Override
    public HBox getButtonsBox() {
        return ButtonsBox;
    }

    @Override
    public void initButtons() {
        Button upload = new Button("Upload");
        Button download = new Button("Download");
        ButtonsBox.getChildren().addAll(upload, download);
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("GIF", "*.gif"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp"));
        addEvent(upload, download, fileChooser);
    }

    private void addEvent(Button upload, Button download, FileChooser fileChooser) {
        upload.setOnAction(actionEvent -> {
            File file = fileChooser.showOpenDialog(primaryStage.getOwner());
            String location = file.getAbsolutePath();
            String lastModTime = String.valueOf(new Date(file.lastModified()));
            try {
                ImageGroup.commonUpload(file, location, lastModTime);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        download.setOnAction(event -> {
            File file = fileChooser.showSaveDialog(primaryStage.getOwner());
            if (file != null) {
                try {
                    BufferedImage image = new BufferedImage((int) ImageGroup.imageView.getImage().getWidth(),
                            (int) ImageGroup.imageView.getImage().getHeight(),
                            BufferedImage.TYPE_INT_RGB);
                    for (int x = 0; x < ImageGroup.imageView.getImage().getWidth(); x++) {
                        for (int y = 0; y < ImageGroup.imageView.getImage().getHeight(); y++) {
                            image.setRGB(x, y, ImageGroup.imageView.getImage().getPixelReader().getArgb(x, y));
                        }
                    }
                    ImageIO.write(image, "jpg", file);//default jpg, user can select jpg, png, gif, bmp
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
