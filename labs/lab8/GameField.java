import java.util.List;
import java.util.Random;

/**
 * The GameField class manages the core gameplay logic and keeps track of all
 * active entities in the game (SpaceShip, Enemies, and Bullets).
 * It acts as a container for the game's state, handling spawning, movement,
 * and collisions.
 *
 * Responsibilities:
 *  - Spawning new enemies
 *  - Detecting and handling collisions
 *  - Tracking the player’s score
 */
public class GameField {
    /** Reference to the player’s spaceship (controlled by the user). */
    private final SpaceShip spaceShip;

    /** List of all active enemy objects currently on the field. */
    private final List<Enemy> enemies;

    /** List of all bullets currently fired by the spaceship. */
    private final List<Bullet> bullets;

    /** Player’s score, increased whenever an enemy is destroyed. */
    private int score;

    /**
     * Constructs a new GameField with the player’s ship and shared entity lists.
     *
     * @param spaceShip  the player’s spaceship
     * @param enemies    list of all enemy objects
     * @param bullets    list of all bullet objects
     */
    public GameField(SpaceShip spaceShip, List<Enemy> enemies, List<Bullet> bullets) {
        this.spaceShip = spaceShip;
        this.enemies = enemies;
        this.bullets = bullets;
        this.score = 0;
    }

    /**
     * Spawns a fixed number of new enemies at the top of the grid each turn.
     * Enemies are placed in random horizontal positions, but never stacked
     * directly on top of each other in the same column.
     */
    public void spawnEnemies() {
        Random rd = new Random();
        int numberOfEnemies = GameEngine.ENEMY_PER_ROW;
        int[] index = new int[GameEngine.WIDTH];
        for(int i = 0; i < numberOfEnemies; i++){            
             index[i]++;    
        }
        //Randomizing places
        for(int i = 0; i < GameEngine.WIDTH; i++){            
             int nextIdx = rd.nextInt(GameEngine.WIDTH - i) + i;
             int temp = index[nextIdx];
             index[nextIdx] = index[i];
             index[i] = temp;    
        }
        for (int i = 0; i < GameEngine.WIDTH; i++) {
            if(index[i] == 1){
                enemies.add(new Enemy(i, 0));
            }
            
        }
    }

    /**
     * Checks whether any enemy has collided with the player's spaceship.
     * If a collision is detected:
     *  - The enemy is removed.
     *  - The spaceship loses one health point.
     *
     * @return true if a collision occurred; false otherwise
     */
    public boolean checkSpaceShipCollusion() {
        //Will be fixed
        for(Enemy e : enemies){
            if(e.attack(spaceShip)){
                this.spaceShip.setHealth(spaceShip.getHealth()-1);
                return true;                
            }
        }
        return false;
    }

    /**
     * Checks for bullet–enemy collisions.
     * If a bullet hits an enemy:
     *  - Both are removed from the field.
     *  - The player’s score increases by one.
     *
     * @return number of enemies destroyed this turn
     */
    public int checkBulletCollusion() {
        int result = 0;
        for(int i = enemies.size()-1; i >= 0; i--){
            for(int j = bullets.size()-1; j >= 0; j--){
                if(bullets.get(j).collidesWith(enemies.get(i))){
                    bullets.remove(j);
                    enemies.remove(i);
                    this.score++;
                    result++;
                }
            }
        }
        return result;
    }

    /** @return the current player score. */
    public int getScore() {
        return this.score;
    }
    
}
