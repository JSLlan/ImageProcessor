package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

public class ImageGroup {
    /*
    contains image view and text box for image property
     */
    static ImageView imageView;
    static Image image;
    static Text imagePropertyText;

    public ImageGroup() {
        imageView = new ImageView();
        imageView.setImage(image);
        imagePropertyText = new Text();
        allowDragDrop();
    }

    public ImageView getImageView() {
        return imageView;
    }

    public Image getImage() {
        return image;
    }

    public Text getImagePropertyText() {
        return imagePropertyText;
    }

    private void allowDragDrop() {
        imageView.setSmooth(true);
        imageView.setOnDragOver(event -> {
            if (event.getGestureSource() != imageView) {
                event.acceptTransferModes(TransferMode.ANY);
            }
        });

        imageView.setOnDragDropped(event -> {
            Dragboard dragboard = event.getDragboard();
            List<File> files = dragboard.getFiles();
            if (files.size() == 1) {
                File file = files.get(0);
                String lastModTime = String.valueOf(new Date(file.lastModified()));
                String location = file.getAbsolutePath();
                try {
                    commonUpload(file, location, lastModTime);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    static void commonUpload(File file, String location, String lastModTime) throws FileNotFoundException {
        image = new Image(new FileInputStream(file));
        imageView.setImage(image);
        String height = String.valueOf((int) image.getHeight());
        String width = String.valueOf((int) image.getWidth());
        imagePropertyText.setText("height: " + height + "\n"
                + "width: " + width + "\n"
                + "location: " + location + "\n"
                + "last modified: " + lastModTime);
    }

}
