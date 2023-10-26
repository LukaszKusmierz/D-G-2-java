package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.dao.GameDatabaseManager;
import com.codecool.dungeoncrawl.dao.PlayerDaoJdbc;
import com.codecool.dungeoncrawl.model.PlayerModel;

import java.sql.SQLException;

public class App {
    public App() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {

        Main.main(args);
        GameDatabaseManager gameDatabaseManager = new GameDatabaseManager();
        PlayerDaoJdbc playerDaoJdbc = new PlayerDaoJdbc(gameDatabaseManager.connect());
//        System.out.println(playerDaoJdbc.get(1));
//        System.out.println(playerDaoJdbc.getAll());
//        PlayerModel playerModel = new PlayerModel("Ela", 12, 15);
//        playerModel.setHp(39);
//        playerModel.setId(2);
//        playerDaoJdbc.update(playerModel);

    }



}
