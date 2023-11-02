package com.codecool.dungeoncrawl.inventory;

import com.codecool.dungeoncrawl.inventory.CollectItems;
import com.codecool.dungeoncrawl.logic.cell.Cell;
import com.codecool.dungeoncrawl.logic.map.GameMap;
import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.items.Armour;
import com.codecool.dungeoncrawl.logic.items.Elixir;
import com.codecool.dungeoncrawl.logic.items.KeyClass;
import com.codecool.dungeoncrawl.logic.items.Sword;
import javafx.scene.control.Label;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CollectItemsTest {
    private CollectItems collectItems;
    private GameMap gameMap;
    private Player player;
    private Cell cell;

    @BeforeEach
    void setUp() {
        collectItems = new CollectItems();
        gameMap = mock(GameMap.class);
        player = mock(Player.class);
        cell = mock(Cell.class);
    }

    @Test
    void collectItemsShouldAddArmourToPlayerInventoryAndIncreaseHealth() {
        Armour armour = new Armour(cell);
        when(cell.getActor()).thenReturn(player);
        when(cell.getItem()).thenReturn(armour);
        when(gameMap.getWidth()).thenReturn(1);
        when(gameMap.getHeight()).thenReturn(1);

        collectItems.collectItems(gameMap, player, cell);

        verify(player.getInventory()).addItem(armour);
        verify(player).setHealth(armour.getVALUE());
    }

    @Test
    void collectItemsShouldAddElixirToPlayerInventoryAndIncreaseHealth() {
        Elixir elixir = new Elixir(cell);
        when(cell.getActor()).thenReturn(player);
        when(cell.getItem()).thenReturn(elixir);
        when(gameMap.getWidth()).thenReturn(1);
        when(gameMap.getHeight()).thenReturn(1);

        collectItems.collectItems(gameMap, player, cell);

        verify(player.getInventory()).addItem(elixir);
        verify(player).setHealth(elixir.getVALUE());
    }

    @Test
    void collectItemsShouldAddKeyToPlayerInventoryAndIncreaseHealth() {
        KeyClass key = new KeyClass(cell);
        when(cell.getActor()).thenReturn(player);
        when(cell.getItem()).thenReturn(key);
        when(gameMap.getWidth()).thenReturn(1);
        when(gameMap.getHeight()).thenReturn(1);

        collectItems.collectItems(gameMap, player, cell);

        verify(player.getInventory()).addItem(key);
        verify(player).setHealth(key.getVALUE());
    }

    @Test
    void collectItemsShouldAddSwordToPlayerInventoryAndIncreaseAttackStrength() {
        Sword sword = new Sword(cell);
        when(cell.getActor()).thenReturn(player);
        when(cell.getItem()).thenReturn(sword);
        when(gameMap.getWidth()).thenReturn(1);
        when(gameMap.getHeight()).thenReturn(1);
        when(player.getAttackStrength()).thenReturn(10);

        collectItems.collectItems(gameMap, player, cell);

        verify(player.getInventory()).addItem(sword);
        verify(player).setAttackStrength(sword.getVALUE() + 10);
    }

    @Test
    void collectItemsShouldNotModifyPlayerWhenCellItemIsNull() {
        when(cell.getActor()).thenReturn(player);
        when(cell.getItem()).thenReturn(null);
        when(gameMap.getWidth()).thenReturn(1);
        when(gameMap.getHeight()).thenReturn(1);

        collectItems.collectItems(gameMap, player, cell);

        verify(player, never()).getInventory();
        verify(player, never()).setHealth(anyInt());
        verify(player, never()).setAttackStrength(anyInt());
    }
}
