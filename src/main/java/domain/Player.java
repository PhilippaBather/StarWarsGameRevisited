package domain;

public abstract class Player {

    // instance fields
    private String name;
    private String playerCounter;
    private String enemyCounter;
    private int lives;
    private int enemies;
    // private int potions;     // TODO
    private int[][] coordinates;
    private boolean isWinner;

    // constructor

    public Player(String name, String playerCounter, String enemyCounter) {
        this.name = name;
        this.playerCounter = playerCounter;
        this.enemyCounter = enemyCounter;
        this.lives = 3;
        this.enemies = 5;
        this.coordinates = new int[1][1];
        this.isWinner = false;
    }

    // getters and setters


    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerCounter() {
        return playerCounter;
    }

    public void setPlayerCounter(String playerCounter) {
        this.playerCounter = playerCounter;
    }

    public String getEnemyCounter() {
        return enemyCounter;
    }

    public void setEnemyCounter(String enemyCounter) {
        this.enemyCounter = enemyCounter;
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

    public int[][] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[][] coordinates) {
        this.coordinates = coordinates;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }
}
