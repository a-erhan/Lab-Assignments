import java.util.Scanner;

public class Lab02_Q2_Revision {
    
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
        double diffOne10 = gravOneStandart - gravOne10;
        double gravOne100 = GRAV100 * mass_1;
        double diffOne100 = gravOneStandart - gravOne100;
        double gravOne1000 = GRAV1000 * mass_1;
        double diffOne1000 = gravOneStandart - gravOne1000;
        double gravTwoStandart = GRAVSTANDART * mass_2;
        double gravTwo10 = GRAV10 * mass_2;
        double diffTwo10 = gravTwoStandart - gravTwo10;
        double gravTwo100 = GRAV100 * mass_2;
        double diffTwo100 = gravTwoStandart - gravTwo100;
        double gravTwo1000 = GRAV1000 * mass_2;
        double diffTwo1000 = gravTwoStandart - gravTwo1000;
        
        


        System.out.printf("%45dkm\t\t%dkm\t\t%dkm\t\t%dkm %n",0,10,100,1000);
        System.out.printf("OBJECT ONE(%.1f)\t%25.1f\t%.1f(%.1f)\t%.1f(%.1f)\t%.1f(%.1f)%n",mass_1,gravOneStandart,gravOne10,diffOne10,gravOne100,diffOne100,gravOne1000,diffOne1000);
        System.out.printf("OBJECT ONE(%.1f)\t%25.1f\t%.1f(%.1f)\t%.1f(%.1f)\t%.1f(%.1f)%n",mass_2,gravTwoStandart,gravTwo10,diffTwo10,gravTwo100,diffTwo100,gravTwo1000,diffTwo1000);

        sc.close();
    
}
}
