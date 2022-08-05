package edu.school21.app;

import com.diogonunes.jcdp.color.api.Ansi.*;

import java.util.Properties;

public class MapConfig {

    public static MapConfig getInstance(){
        return instance;
    }

    public void loadConfig(Properties properties){
        enemyChar = properties.getProperty("enemy.char").charAt(0);
        playerChar = properties.getProperty("player.char").charAt(0);
        wallChar = properties.getProperty("wall.char").charAt(0);
        goalChar = properties.getProperty("goal.char").charAt(0);
        emptyChar = properties.getProperty("empty.char").charAt(0);
        enemyColor = BColor.valueOf(properties.getProperty("enemy.color"));
        playerColor = BColor.valueOf(properties.getProperty("player.color"));
        wallColor = BColor.valueOf(properties.getProperty("wall.color"));
        goalColor = BColor.valueOf(properties.getProperty("goal.color"));
        emptyColor = BColor.valueOf(properties.getProperty("empty.color"));
    }

    public char getEnemyChar(){
        return enemyChar;
    }

    public char getPlayerChar(){
        return playerChar;
    }

    public char getWallChar(){
        return wallChar;
    }

    public char getGoalChar(){
        return goalChar;
    }

    public char getEmptyChar(){
        return emptyChar;
    }

    public BColor getEnemyColor(){
        return enemyColor;
    }

    public BColor getPlayerColor(){
        return playerColor;
    }

    public BColor getWallColor(){
        return wallColor;
    }

    public BColor getGoalColor(){
        return goalColor;
    }

    public BColor getEmptyColor(){
        return emptyColor;
    }


    private char enemyChar;
    private char playerChar;
    private char wallChar;
    private char goalChar;
    private char emptyChar;
    private BColor enemyColor;
    private BColor playerColor;
    private BColor wallColor;
    private BColor goalColor;
    private BColor emptyColor;

    private static final MapConfig instance = new MapConfig();

    private MapConfig() {
    }
}
