package domain;

/**
 * Player class creates a template for the different players.
 */
public class Player {

    // instance fields
    private final String name;
    private final String playerCounter;
    private final String enemyCounter;
    private final String potionCounter;
    private int lives;
    private int enemies;
    private int potions;
    private int[] coordinates;

    // constructor

    public Player(String name, String playerCounter, String enemyCounter) {
        this.name = name;
        this.playerCounter = playerCounter;
        this.enemyCounter = enemyCounter;
        this.potionCounter = "P";
        this.lives = 3;
        this.enemies = 6;
        this.potions = 3;
        this.coordinates = new int[2];
    }

    // getters and setters

    public String getName() { return name; }

    public String getPlayerCounter() {
        return playerCounter;
    }

    public String getEnemyCounter() {
        return enemyCounter;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getEnemies() {
        return enemies;
    }

    public void setEnemies(int enemies) {
        this.enemies = enemies;
    }

    public String getPotionCounter() { return potionCounter; }

    public int getPotions() { return potions; }

    public void setPotions(int potions) { this.potions = potions; }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public int getCoordinateRow() {
        return coordinates[0];
    }

    public int getCoordinatesColumn() {
        return coordinates[1];
    }
}
