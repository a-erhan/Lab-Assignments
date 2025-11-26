package original;

import java.util.ArrayList;

public class GameManager {
    
    private Tower tower = new Tower(TowerDefenseGame.INITIAL_HEALTH,0 , TowerDefenseGame.TOWER_SYMBOL); 
    private ArrayList<EnemyWave> enemyWaves = new ArrayList<EnemyWave>();
    private int enemyWavesLeft = TowerDefenseGame.ENEMY_WAVES;

    /*
     * Initializes the GameManager.
     * Creates a new tower with initial health and score.
     * Prepares an empty map filled with empty enemy waves.
     * Adds the first enemy wave to start the game.
     */
    public GameManager () {
        this.tower = tower;
        this.enemyWavesLeft = enemyWavesLeft;
        this.enemyWaves = enemyWaves;
        this.generateEmptyMap();
        this.addNextEnemyWave();
    }

    /*
     * Fills the map with empty enemy waves.
     */
    private void generateEmptyMap () {
        for(int i = 0; i < TowerDefenseGame.COLUMNS ; i++){
            this.enemyWaves.add(new EnemyWave(0));
        }
    }

    /*
     * Creates a new enemy wave.
     * If hasEnemies is true, a random number of enemies is spawned
     * up to the maximum enemy spawn rate.
     */
    private EnemyWave generateNextEnemyWave (boolean hasEnemies) {
        if(hasEnemies){
            int enemyNumber = (int)(Math.random() * TowerDefenseGame.MAX_ENEMY_SPAWN_RATE);
            this.enemyWavesLeft--;
            return new EnemyWave(enemyNumber);
        }
        else{
            this.enemyWavesLeft--;
            return new EnemyWave(0);
        }
    }

    /*
     * Returns the number of enemies left in the wave at the given column index.
     */
    public int getNumberOfEnemies (int index) {
        return this.enemyWaves.get(index).getNumberOfEnemies();
    }

    /*
     * Removes the oldest enemy wave from the map.
     * Adds a new enemy wave at the end of the map.
     * Decreases the count of remaining waves.
     */
    public void addNextEnemyWave () {
        this.enemyWaves.remove(0);
        this.enemyWaves.add(generateNextEnemyWave(true));
    }

    /*
     * Attempts to hit an enemy at the given column and row index.
     * Returns 1 if an enemy is hit, and 0 otherwise.
     */
    public int hitEnemy (int columnIndex, int rowIndex) {
        return this.enemyWaves.get(columnIndex).hitEnemy(rowIndex);
    }

    /*
     * Returns the tower object used in the game.
     */
    public Tower getTower () {
        return this.tower;
    }

    /*
     * Returns true if there are still enemy waves left to spawn.
     */
    public boolean hasEnemyWavesLeft () {
        return this.enemyWavesLeft > 0;
    }

    /*
     * Checks whether the game is over.
     * The game ends if the tower is destroyed or no enemy waves remain.
     */
    public boolean isGameOver () {
        return (!this.tower.isStanding() || !this.hasEnemyWavesLeft());
    }

    /*
     *  Reduces the tower's health based on enemies that reached the front column.
     *  Each remaining enemy decreases the tower's health by 1.
     */
    public void handleTowerDamage () {
        this.tower.setHealth(this.tower.getHealth() - this.enemyWaves.get(0).getNumberOfEnemies());
    }

    // Getters
    public ArrayList<EnemyWave> getEnemyWaves () {
        return this.enemyWaves;
    }

    public int getEnemyWavesLeft () {
        return this.enemyWavesLeft;
    }
   
}


