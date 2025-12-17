/**
 * Implements a health bonus which increases hero's health on collision
 */
public class HealthBonus extends Bonus {
    private final int PRECEDENCE = 1;

    public HealthBonus(GameGrid grid, int row, int col){
        super(grid, row, col, 'H', 10);
    }

    //Gets the specific number associated with this number
    @Override
    public int getPrecendence(){
        return PRECEDENCE;
    }

    @Override
    public void handleCollision(GameObject obj){
        if(obj.symbol == 'P'){
            this.grid.getHero().setHealth(this.grid.getHero().getHealth() + power);
            this.grid.removeGameObject(this);
        }  
    }
    
    @Override
    public void move(){
        //To be checked
        //A health bonus object cannt move
    }
}