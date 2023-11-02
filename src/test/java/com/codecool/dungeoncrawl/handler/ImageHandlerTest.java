package com.codecool.dungeoncrawl.handler;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ImageHandlerTest {

    private ImageHandler imageHandler;

    @BeforeEach
    void setUp() {
        imageHandler = new ImageHandler();
    }

    @Test
    void testSetTheImage() throws NoSuchFieldException, IllegalAccessException, FileNotFoundException {
        // Call the method under test
        Group resultGroup = imageHandler.setTheImage();

        // Access the private field 'image' using ReflectionTestUtils
        Field imageField = ImageHandler.class.getDeclaredField("image");
        imageField.setAccessible(true);
        Image image = (Image) imageField.get(imageHandler);

        // Verify that the returned Group contains the expected ImageView with the image
        ImageView imageView = (ImageView) resultGroup.getChildren().get(0);
        assertEquals(image, imageView.getImage());
        assertEquals(0, imageView.getX());
        assertEquals(0, imageView.getY());
        assertEquals(550, imageView.getFitHeight());
        assertEquals(800, imageView.getFitWidth());
    }

//    @Test
//    void testCreateImageToMenu() throws FileNotFoundException {
//        // Call the actual createImageToMenu method
//        Image image = imageHandler.createImageToMenu();
//
//        // Verify that the Image is not null
//        assertNotNull(image);
//
//        // You can also add further assertions for the image properties if needed
//    }
}

