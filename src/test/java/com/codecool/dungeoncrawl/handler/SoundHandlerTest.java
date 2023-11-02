package com.codecool.dungeoncrawl.handler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.Clip;

import static org.junit.jupiter.api.Assertions.*;

class SoundHandlerTest {

    private SoundHandler soundHandler;

    @BeforeEach
    void setUp() {
        soundHandler = new SoundHandler();
    }

    @Test
    void testPlayStepSound() {
        Clip clip = soundHandler.playSound(soundHandler.STEP_SOUND);
        assertNotNull(clip);
        assertTrue(clip.isRunning());
    }

    @Test
    void testPlayElixirSound() {
        Clip clip = soundHandler.playSound(soundHandler.ELIXIR_SOUND);
        assertNotNull(clip);
        assertTrue(clip.isRunning());
    }

    @Test
    void testPlayFightSound() {
        Clip clip = soundHandler.playSound(soundHandler.FIGHT_SOUND);
        assertNotNull(clip);
        assertTrue(clip.isRunning());
    }

    @Test
    void testPlaySwordSound() {
        Clip clip = soundHandler.playSound(soundHandler.SWORD_SOUND);
        assertNotNull(clip);
        assertTrue(clip.isRunning());
    }

    @Test
    void testPlayKeysSound() {
        Clip clip = soundHandler.playSound(soundHandler.KEYS_SOUND);
        assertNotNull(clip);
        assertTrue(clip.isRunning());
    }

    @Test
    void testPlayCheatSound() {
        Clip clip = soundHandler.playSound(soundHandler.CHEAT_SOUND);
        assertNotNull(clip);
        assertTrue(clip.isRunning());
    }

    @Test
    void testPlayInvalidSound() {
        Clip clip = soundHandler.playSound("nonexistent.wav");
        assertNull(clip);
    }
}
