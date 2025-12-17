import java.util.Random;

/**
 * Implements a monster that moves randomly on the grid
 */
public class RandomMonster extends Monster {

    private final Random rng = new Random();
    private final int precedence = 1;

    public RandomMonster(GameGrid grid, int row, int col){
        super(grid, row, col, 'R', 10);
    }
    @Override
    public int getPrecendence(){
        return this.precedence;
    }
    @Override
    public void move(){
        int direction = rng.nextInt(3);
        switch(direction) {
            case 0:
                if(this.row < this.grid.getHeight()-1)
                    this.row++;
                break;
            case 1:
                if(this.row > 0)
                    this.row--;
                break;
            case 2:
                if(this.col < this.grid.getWidth()-1)
                    this.col++;
                break;
            case 3:
                if(this.col > 0)
                    this.col--;
                break;
        }
    }
    @Override
    public void handleCollision(GameObject obj){
        if(obj.getSymbol() == 'P')
            //Decrements the health of hero by 'damage'
            this.grid.getHero().setHealth(Math.max(0, this.grid.getHero().getHealth() - damage));
        else if(obj.getPrecendence() < this.getPrecendence()){
            this.grid.removeGameObject(obj);
        }
    }
    
}