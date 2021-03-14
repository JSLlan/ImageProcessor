package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class FilterBtns implements AdvancedBtnGroup {
    /**
     * button group, contains all color filter buttons
     */
    HBox ButtonsBox;

    public FilterBtns(double spacing, Pos position) {
        ButtonsBox = new HBox();
        ButtonsBox.setSpacing(spacing);
        ButtonsBox.setAlignment(position);
        initButtons();
    }

    @Override
    public HBox getButtonsBox() {
        return ButtonsBox;
    }

    public void setButtonsBox(HBox buttonsBox) {
        this.ButtonsBox = buttonsBox;
    }


    @Override
    public void initButtons() {
        Button brighter = new Button("Brighter");
        Button darker = new Button("Darker");
        Button grayer = new Button("Greyer");
        Button invert = new Button("Invert Color");
        Button saturated = new Button("More Saturated");
        Button unsaturated = new Button("More Unsaturated");
        Button revert = new Button("Revert");
        addEvent(brighter, darker, grayer, invert, saturated, unsaturated, revert);
        ButtonsBox.getChildren().addAll(saturated, unsaturated, brighter, darker, grayer, invert, revert);
    }

    private void addEvent(Button bright, Button darker, Button gray, Button invert, Button saturate, Button desaturate, Button recover) {
        bright.setOnAction(event -> addColorFilter(1));

        darker.setOnAction(event -> addColorFilter(2));

        gray.setOnAction(event -> addColorFilter(3));

        invert.setOnAction(event -> addColorFilter(4));

        saturate.setOnAction(event -> addColorFilter(5));

        desaturate.setOnAction(event -> addColorFilter(6));

        recover.setOnAction(event -> ImageGroup.imageView.setImage(ImageGroup.image));
    }

    private void addColorFilter(int type) {
        PixelReader pixelReader = ImageGroup.imageView.getImage().getPixelReader();
        Image image = ImageGroup.imageView.getImage();
        // Create WritableImage
        WritableImage wImage = new WritableImage(
                (int) image.getWidth(),
                (int) image.getHeight());
        PixelWriter pixelWriter = wImage.getPixelWriter();

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color color = pixelReader.getColor(x, y);
                switch (type) {
                    case 1:
                        color = color.brighter();
                        break;
                    case 2:
                        color = color.darker();
                        break;
                    case 3:
                        color = color.grayscale();
                        break;
                    case 4:
                        color = color.invert();
                        break;
                    case 5:
                        color = color.saturate();
                        break;
                    case 6:
                        color = color.desaturate();
                        break;
                    default:
                        break;
                }
                pixelWriter.setColor(x, y, color);
            }
        }
        ImageGroup.imageView.setImage(wImage);
    }


}
