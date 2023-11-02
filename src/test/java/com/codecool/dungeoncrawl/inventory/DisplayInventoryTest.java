package com.codecool.dungeoncrawl.inventory;

import com.codecool.dungeoncrawl.logic.Inventory;
import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.cell.Cell;
import com.codecool.dungeoncrawl.logic.items.Armour;
import com.codecool.dungeoncrawl.logic.items.Elixir;
import com.codecool.dungeoncrawl.logic.items.KeyClass;
import com.codecool.dungeoncrawl.logic.items.Sword;
import javafx.beans.value.ObservableBooleanValue;
import javafx.scene.canvas.GraphicsContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static javafx.beans.binding.Bindings.when;
import static org.mockito.Mockito.*;

class DisplayInventoryTest {

    private DisplayInventory displayInventory;
    private GraphicsContext mockGraphicsContext;
    private Player mockPlayer;
    private Cell cell;

    @BeforeEach
    void setUp() {
        displayInventory = new DisplayInventory();
        mockGraphicsContext = mock(GraphicsContext.class);
        mockPlayer = mock(Player.class);
        when((ObservableBooleanValue) mockPlayer.getInventory()).then(new Inventory());
    }

    @Test
    void testDisplayInventoryWithSword() {
        Sword sword = new Sword(cell);
        mockPlayer.getInventory().addItem(sword);

        displayInventory.displayInventory(mockPlayer, mockGraphicsContext);

        verify(mockGraphicsContext, times(1)).drawImage(any(), anyDouble(), anyDouble());
    }

    @Test
    void testDisplayInventoryWithKey() {
        KeyClass key = new KeyClass(cell);
        mockPlayer.getInventory().addItem(key);

        displayInventory.displayInventory(mockPlayer, mockGraphicsContext);

        verify(mockGraphicsContext, times(1)).drawImage(any(), anyDouble(), anyDouble());
    }

    @Test
    void testDisplayInventoryWithArmour() {
        Armour armour = new Armour(cell);
        mockPlayer.getInventory().addItem(armour);

        displayInventory.displayInventory(mockPlayer, mockGraphicsContext);

        verify(mockGraphicsContext, times(1)).drawImage(any(), anyDouble(), anyDouble());
    }

    @Test
    void testDisplayInventoryWithElixir() {
        Elixir elixir = new Elixir(cell);
        mockPlayer.getInventory().addItem(elixir);

        displayInventory.displayInventory(mockPlayer, mockGraphicsContext);

        verify(mockGraphicsContext, times(1)).drawImage(any(), anyDouble(), anyDouble());
    }
}