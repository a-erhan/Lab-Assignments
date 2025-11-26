package original;

import java.util.Random;

public class EnemyWave {
    
    // Instance variable
    private String[] enemyWave;
    private final String ENEMY_SYMBOL = "👾";
    private final String EMPTY_SYMBOL = "⬜";
     
    /*
     * Initializes an EnemyWave with a given number of enemies.
     * Enemies are first placed into the array and then shuffled randomly.
     */
    public EnemyWave (int numberOfEnemies) {
        this.enemyWave = new String[6];
        initializeWave(numberOfEnemies);
        shuffleArray();
        //It is ready   
    } 
    
    /*
     * Fills the wave array with enemies for the first 'numberOfEnemies' positions
     * and empty symbols in the remaining positions.
     */
    private void initializeWave (int numberOfEnemies) {
        if(numberOfEnemies <= 6){
            int i;
            for(i = 0; i < numberOfEnemies; i++){
                enemyWave[i] = ENEMY_SYMBOL;
            }
            while(i < 6){
                enemyWave[i] = EMPTY_SYMBOL;
                i++;
            }
        }
        else{
            System.out.println("Number of enemies exceeds the column length");
        }
    }

    /*
     * Randomly shuffles the positions of enemies and empty symbols
     * using Fisher–Yates shuffle algorithm.
     */
    private void shuffleArray() {
        Random rd = new Random();
        int randomIdx;
        for(int idx = this.enemyWave.length - 1; idx > 0; idx--){
            randomIdx = rd.nextInt(idx + 1);
            String temp = this.enemyWave[randomIdx];
            this.enemyWave[randomIdx] = this.enemyWave[idx];
            this.enemyWave[idx] = temp;
        }

    }    

    /*
     * Attempts to hit an enemy at the given index.
     * If an enemy is present, it is replaced with an empty symbol and the method returns 1. 
     * Otherwise, it returns 0.
     */
    public int hitEnemy (int index) {
        if(this.enemyWave[index].equals(ENEMY_SYMBOL)){
            this.enemyWave[index] = EMPTY_SYMBOL;
            return 1;
        }
        else{
            return 0;
        }
    }

    /*
     * Counts and returns the number of enemies still alive in this wave.
     */
    public int getNumberOfEnemies () {
        int result = 0;
        for (int i = 0; i < this.enemyWave.length; i++) {
            if(this.enemyWave[i].equals(ENEMY_SYMBOL)){
                result++;
            }
        }
        return result;
    }

    // Getter
    public String[] getEnemyWave () {
        return this.enemyWave;
    }
    
}

