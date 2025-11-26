package original;

public class Tower {
    
    // Instance variables
    private  int health;
    private int score;
    private String symbol = TowerDefenseGame.TOWER_SYMBOL;

    /*
     * Initializes the Tower with a specified health, score and symbol.
     * When initializing the health variable, call setHealth to prevent negative values.
     */
    public Tower (int health, int score, String symbol) {
        this.health = health;
        this.setHealth(health);
        this.score = score;
        this.symbol = symbol;
    }

    /*
     * Returns true if the tower's health is greater than zero, otherwise false.
     */
    public boolean isStanding () {
        return this.health > 0;
    }

    /*
     * Takes a damage value and decreases the tower's health by that amount.
     * The health value should never go below zero.
     */
    public void takeDamage (int damage) {
        this.health = Math.max(this.health - damage, 0);
    }

    /*
     * Increases the tower's score by the given value.
     */
    public void incrementScore (int score) {
       this.score += score;
    }

    /*
     * Returns a string representation of the tower,
     * including its symbol, health, and score.
     */
    @Override
    public String toString () {
        return "Current symbol: "+this.symbol+" Health: "+this.health + " Score: "+this.score;
    }

    // Getters & Setters
    public String getSymbol () {
        return this.symbol; 
    }

    public int getScore () {
        return this.score; 
    }

    public void setScore (int score) {
        this.score = score;
    }

    public int getHealth () {
        return this.health;
    } 

    /*
     * Sets the tower's health to the given value.
     * The health value must not be negative.
     */
    public void setHealth (int health) {
        if(health >= 0){
            this.health = health;
        } 
        else{
            System.out.println("Health cannot take negative values");
            this.health = 0;
        }
    }

}
