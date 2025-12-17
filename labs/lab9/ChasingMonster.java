/**
 * Implements a monster following the hero with a certain probability on each round
 */
public class ChasingMonster extends Monster {
    private final int precedence = 2;

    public ChasingMonster(GameGrid grid, int row, int col){
        super(grid, row, col, 'C', 10);
    }
    @Override
    public int getPrecendence(){
        return this.precedence;
    }
    @Override
    /** The  chasing 
        * monster  moves  towards  the  hero  two-thirds  of  the  time  (with  67%  probability)  and  stays  put  at  other 
        * times.  When  moving  towards  the  hero,  whether  to  move  closer  to  the  hero  by  one  location  horizontally  or 
        * vertically is decided randomly with an equal probability.  */
    public void move(){
        if(Math.random() < 0.67){
            // Fetching the info of the 'hero'
            int colHero = this.grid.getHero().getCol();
            int rowHero = this.grid.getHero().getRow();
            if(Math.random() < 0.5){ //Decide the direction; vertical or horizontal
                this.col += this.col < colHero ? 1 : -1;
            }else{
                this.row += this.row < rowHero ? 1 : -1;
            }
        }
        // No operations otherwise
        
    }
    @Override
    public void handleCollision(GameObject obj){
        if(obj.getSymbol() == 'P')
            //Decrements the health of hero by 'damage'
            this.grid.getHero().setHealth(Math.max(0, this.grid.getHero().getHealth() - damage));
    }
}