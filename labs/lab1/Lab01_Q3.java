import java.util.Scanner;
public class Lab01_Q3 {
    public static void main(String[] args){
    // Constants
    final double CARBOHYDRATE_PERCENTAGE=0.5;
    final double FAT_PERCENTAGE=0.3;
    final double PROTEIN_PERCENTAGE=0.2;

        /*You may assume that the daily calorie requirement to maintain weight is 2000 calories, and to lose 1
    kilogram requires a calorie deficit of 7700.*/
    final double MAINTAIN = 2000;
    final double DEFICIT = 7700;
    final int CARBOHYDRATE_CAL_PER_GRAM = 4;
    final int FAT_CAL_PER_GRAM = 9;
    final int PROTEIN_CAL_PER_GRAM = 4;
     

    //User inputs
    Scanner sc = new Scanner(System.in);
    System.out.print("Kilogram to lose: ");
    int lose = sc.nextInt();
    System.out.print("Days to lose: ");
    int days = sc.nextInt();

    //Calculate the required calorie deficency
    double calDeficencyTotal = DEFICIT*lose;
    double calDeficencyDay = calDeficencyTotal/days; 
    System.out.println("To lose "+lose+" kilograms in "+days+" days you will need a daily deficit of "+calDeficencyDay+" calories.");


    
     
    //Daily diet
    double calDiet = MAINTAIN-calDeficencyDay;
    double carbohydrateDietCal = calDiet * CARBOHYDRATE_PERCENTAGE;
    double carbohydrateDietGram = carbohydrateDietCal / CARBOHYDRATE_CAL_PER_GRAM;
    
    
    double fatDietCal = calDiet * FAT_PERCENTAGE;
    double fatDietGram = fatDietCal / FAT_CAL_PER_GRAM;
    

    double proteinDietCal = calDiet * PROTEIN_PERCENTAGE;
    double proteinDietGram = proteinDietCal / PROTEIN_CAL_PER_GRAM;
    

    System.out.println("RECOMENDED DAILY CALORIES TO LOSE "+lose+" KILOS IN "+days+" DAYS: "+calDiet);
    System.out.printf("%14s%21s %20s%25s%19s \n","MACRO","RECOMENDED PERCENT","CALORIES PER GRAM","RECOMENDED CALORIES", "GRAMS");
    System.out.printf("CARBOHYDRATE %20d%% %20d%25d%20.1f \n", (int)(CARBOHYDRATE_PERCENTAGE*100),CARBOHYDRATE_CAL_PER_GRAM,(int)carbohydrateDietCal,carbohydrateDietGram);
    System.out.printf("FAT          %20d%% %20d%25d%20.1f \n", (int)(FAT_PERCENTAGE*100),FAT_CAL_PER_GRAM,(int)fatDietCal,fatDietGram);
    System.out.printf("PROTEIN      %20d%% %20d%25d%20.1f \n", (int)(PROTEIN_PERCENTAGE*100),PROTEIN_CAL_PER_GRAM,(int)proteinDietCal,proteinDietGram);
    

    sc.close();
    }
    
}
