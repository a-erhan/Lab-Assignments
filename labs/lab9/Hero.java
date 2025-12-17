/**
 * Implements the hero (the player) of the game. Can move in one of four
 * directions in each round. Aims to reach the target location on the grid.
 */
public class Hero extends GameObject {
    private int health = 100;
    private int score = 0;
    private char direction;
    private final int precedence = 2;

    public Hero(GameGrid grid, int row, int col) {
        super(grid, row, col, 'P');
    }
    //Possible error
    public boolean isTargetReached(){
    return this.row == this.grid.getHeight()-1 && this.col == this.grid.getWidth()-1;
    }
    public boolean isAlive(){
        return this.health > 0;
    }
    //Getter
    public int getHealth(){
        return this.health;
    }
    public int getScore(){
        return this.score;
    }
    @Override
    public int getPrecendence(){
        return this.precedence;
    }

    //Setter 
    public void setScore(int newHealth){
        this.score = newHealth;
    }
    public void setHealth(int newHealth){
        this.health = newHealth;
    }
    public void setDirection(char dir){
        this.direction = dir;
    }
    
    @Override
    public void handleCollision(GameObject obj){
        if(obj.symbol == this.symbol){
            return;
        }else{
            obj.handleCollision(this);
        }
        
    }

    @Override
    public void move(){
        switch (direction) {
            case 'w':
                if (this.row > 0) this.row--; // Yukarı gitmek için index azalmalı
                break;
            case 'a':
                if (this.col > 0) this.col--;
                break;
            case 's':
                if (this.row < this.grid.getHeight() - 1) this.row++; // Aşağı gitmek için index artmalı
                break;
            case 'd':
                if (this.col < this.grid.getWidth() - 1) this.col++;
                break;
        }
    }
}