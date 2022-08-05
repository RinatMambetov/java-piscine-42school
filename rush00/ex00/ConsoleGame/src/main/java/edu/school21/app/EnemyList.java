package edu.school21.app;

import java.util.ArrayList;
import java.util.List;

public class EnemyList {

    public void add(Coordinates coordinates){
        enemies.add(new Enemy(coordinates));
    }

    public void clear(){
        enemies.clear();
    }

    public boolean isEnemy(Coordinates coordinates){
        for (Enemy item : enemies){
            if (item.coordinates.equals(coordinates))
                return true;
        }
        return false;
    }

    public Enemy getEnemy(Coordinates coordinates){
        if (coordinates != null) {
            for (Enemy item : enemies) {
                if (item.coordinates.equals(coordinates))
                    return item;
            }
        }
        return null;
    }

    public void deleteEnemy(Coordinates coordinates){
        if (coordinates != null){
            Enemy enemy = getEnemy(coordinates);
            enemies.remove(enemy);
        }
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    private final List<Enemy> enemies = new ArrayList<>();

    public static EnemyList getInstance(){
        return instance;
    }
    private static final EnemyList instance = new EnemyList();

    private EnemyList() {
    }
}
