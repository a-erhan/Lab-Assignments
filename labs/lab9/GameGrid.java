import java.util.*;

/**
 * Implements a grid for the maze in our game.
 */
public class GameGrid {
    // constants
    public static String HERO_SYMBOL = "😍";
    public static String RANDOM_MONSTER_SYMBOL = "👿";
    public static String CHASING_MONSTER_SYMBOL = "👹";
    public static String HEALTH_BONUS_SYMBOL = "💛";
    public static String SCORE_BONUS_SYMBOL = "💰";
    public static String FINISH_SYMBOL = "🏁";
    public static String WINNER_SYMBOL = "🥳";
    public static String LOSER_SYMBOL = "🥴️";

    // instance variables
    private int width, height; // dimensions of grid: # of columns & rows, resp.
    private ArrayList<GameObject> objects; // first one is always the hero
    private ArrayList<GameObject> queuedObjectsForRemoval;

    public GameGrid(int width, int height) {
        this.width = width;
        this.height = height;
        this.objects = new ArrayList<>();
        this.objects.add(new Hero(this, 0, 0));
        this.queuedObjectsForRemoval = new ArrayList<>();
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public Hero getHero() { return (Hero)this.objects.get(0); }
    public boolean isAtTarget(int row, int col) {
        return row == height-1 && col == width-1;
    }

    public void removeGameObject(GameObject obj) {
        this.queuedObjectsForRemoval.add(obj);
    }

    private void addGameObject(GameObject obj) {
        objects.add(obj);
    }

    public void spawnMonster(int row, int col) {
        Monster monster;
        if (Math.random() < 0.5) {
            monster = new RandomMonster(this, row, col);
        }
        else {
            monster = new ChasingMonster(this, row, col);
        }
        addGameObject(monster);
    }

    public void spawnBonus(int row, int col) {
        Bonus bonus;
        if (Math.random() < 0.5) {
            bonus = new HealthBonus(this, row, col);
        }
        else {
            bonus = new ScoreBonus(this, row, col);
        }
        addGameObject(bonus);
    }

    public void spawnGameObject() {
        int row, col;

        do {
            row = (int)(Math.random() * height);
            col = (int)(Math.random() * width);
        } while (isOccupied(row,col));

        if (Math.random() < 0.5) {
            spawnMonster(row, col);
        }
        else {
            spawnBonus(row, col);
        }
    }

    public boolean isOccupied(int row, int col) {
        for (GameObject obj : objects) {
            if (obj.getRow() == row && obj.getCol() == col) {
                return true;
            }
        }
        return false;
    }

    public void draw() {
        for (int j = 0; j < width; j++) {
                System.out.print("____");
            }
        System.out.println();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                String cell = "|";
                int count = 0;
                if(i == height -1 && j == width -1){
                    cell = "|"+FINISH_SYMBOL;
                    count+=2;
                }
                for (GameObject elem : objects) {
                    if(elem.getRow() == i && elem.getCol() == j){
                        cell+=turnPretty(elem.getSymbol());
                        count+=2;
                    }
                }
                for (int n = 0; n < 3 - count; n++) { // 3 is the cell size
                    cell+=" ";
                }
                System.out.print(cell);
            }
            System.out.println("|");

            for (int j = 0; j < width; j++) {
                System.out.print("____");
            }
            System.out.println();
        }
        System.out.println("Health: "+ ((Hero)objects.get(0)).getHealth() + " Score: "+ ((Hero)objects.get(0)).getScore());
    }

    public static String turnPretty(char c) {
        if (c == 'P') return HERO_SYMBOL;
        else if (c == 'R') return RANDOM_MONSTER_SYMBOL;
        else if (c == 'C') return CHASING_MONSTER_SYMBOL;
        else if (c == 'H') return HEALTH_BONUS_SYMBOL;
        else if (c == 'S') return SCORE_BONUS_SYMBOL;
        return Character.toString(c);
    }
    //To be checked
    public void update(){ 
        for(GameObject obj : objects){
            obj.move();
        }
    }

    //Should be fixed
    public void checkAndHandleCollisions() { 
            for(int i = 0; i < this.objects.size(); i++){
                for (int j = i+1 ; j < this.objects.size(); j++) {
                    if(objects.get(i).collidesWith(objects.get(j)))
                        objects.get(i).handleCollision(objects.get(j));
                }
            }
            this.removeQueuedObjects();
       }

    public void removeQueuedObjects() {
        for (GameObject obj : queuedObjectsForRemoval) {
            this.objects.remove(obj);
        }
        queuedObjectsForRemoval.clear();
    }
}