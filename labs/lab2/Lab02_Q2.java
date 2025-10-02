import java.util.Scanner;
public class Lab02_Q2 {
    public static void main( String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the mass of the first object(kg): "); 
        double mass_1= sc.nextInt();
        System.out.print("Enter the mass of the second object(kg): "); 
        double mass_2= sc.nextInt();
        
        final double GRAVSTANDART = 9.80665;
        final double GRAV10 = 9.77594;
        final double GRAV100 = 9.5059;
        final double GRAV1000 = 7.32628;

        double gravOneStandart = GRAVSTANDART * mass_1;
        double gravOne10 = GRAV10 * mass_1;
        double gravOne100 = GRAV100 * mass_1;
        double gravOne1000 = GRAV1000 * mass_1;
        double gravTwoStandart = GRAVSTANDART * mass_2;
        double gravTwo10 = GRAV10 * mass_2;
        double gravTwo100 = GRAV100 * mass_2;
        double gravTwo1000 = GRAV1000 * mass_2;
        
        


        System.out.printf("%41dkm\t%dkm\t%dkm\t%dkm %n",0,10,100,1000);
        System.out.printf("OBJECT ONE(%f)\t%21.1f\t%.1f\t%.1f\t%.1f%n",mass_1,gravOneStandart,gravOne10,gravOne100,gravOne1000);
        System.out.printf("OBJECT ONE(%f)\t%21.1f\t%.1f\t%.1f\t%.1f%n",mass_2,gravTwoStandart,gravTwo10,gravTwo100,gravTwo1000);






    }
}
