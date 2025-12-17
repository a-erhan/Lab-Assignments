/**
 * Increments the score on collision with the hero
 */
public class ScoreBonus extends Bonus {
    private final int PRECEDENCE = 1;

    public ScoreBonus(GameGrid grid, int row, int col){
        super(grid, row, col, 'S', 1);
    }

    //Gets the specific number associated with this number
    @Override
    public int getPrecendence(){
        return PRECEDENCE;
    }

    @Override
    public void handleCollision(GameObject obj){
        if(obj.symbol == 'P'){
            this.grid.getHero().setScore(this.grid.getHero().getScore() + power);
            this.grid.removeGameObject(this);
        }else if(obj.getPrecendence() > this.getPrecendence()){
            this.grid.removeGameObject(this);
        }
    }
    
    @Override
    public void move(){
        //To be checked
        //A score bonus object cannot move
    }
}