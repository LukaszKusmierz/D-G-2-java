package com.codecool.dungeoncrawl.handler;

import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.cell.Cell;
import com.codecool.dungeoncrawl.logic.items.Item;
import com.codecool.dungeoncrawl.logic.items.KeyClass;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class KeyHandlerTest {
    private KeyHandler keyHandler;
    private Player player;
    private Canvas canvasInventory;
    private GraphicsContext contextInventory;
    private Cell cell;

    @BeforeEach
    void setUp() {
        keyHandler = new KeyHandler();
        player = new Player();
        canvasInventory = mock(Canvas.class);
        contextInventory = mock(GraphicsContext.class);
    }

    @Test
    void testHasKeyShouldReturnTrueWhenPlayerHasKey() {
        // Arrange
        Item key = new KeyClass(cell);
        player.getInventory().addItem(key);

        // Act
        boolean hasKey = keyHandler.hasKey(player);

        // Assert
        assertTrue(hasKey);
    }

    @Test
    void testHasKeyShouldReturnFalseWhenPlayerDoesNotHaveKey() {
        // Act
        boolean hasKey = keyHandler.hasKey(player);

        // Assert
        assertFalse(hasKey);
    }

    @Test
    void testDeleteKeyShouldRemoveKeyFromPlayerInventory() {
        // Arrange
        Item key = new KeyClass(cell);
        player.getInventory().addItem(key);

        // Act
        keyHandler.deleteKey(player, contextInventory, canvasInventory);

        // Assert
        assertFalse(keyHandler.hasKey(player));
    }

    @Test
    void testDeleteKeyShouldNotAffectInventoryWhenPlayerDoesNotHaveKey() {
        // Act
        keyHandler.deleteKey(player, contextInventory, canvasInventory);

        // Assert
        assertTrue(player.getInventory().getItems().isEmpty());
    }
}
