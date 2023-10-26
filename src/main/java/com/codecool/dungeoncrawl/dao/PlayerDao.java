package com.codecool.dungeoncrawl.dao;

import com.codecool.dungeoncrawl.model.PlayerModel;

import java.sql.SQLException;
import java.util.List;

public interface PlayerDao {
    void add(PlayerModel player);
    void update(PlayerModel player);
    PlayerModel get(int id) throws SQLException;


    List<PlayerModel> getAll();
}
