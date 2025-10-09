import java.util.Scanner;

public class Lab02_Q1_Revision{
    //For part 1, input the surface area of the base circle and height of the cone instead of the volume and height, and use them to
    //calculate the radius, volume, and surface area of the cone:
        public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter the surface area of the base circle: ");
        double surfaceBase = sc.nextDouble();
        System.out.print("Enter the height of the cone: ");
        double height = sc.nextDouble();
        double volume = height * surfaceBase /3;

        double radius = Math.sqrt(surfaceBase/Math.PI);
        double area = Math.PI*radius*(radius + Math.sqrt(Math.pow(height,2) + Math.pow(radius,2)));

        System.out.printf("The radius of the cone is: %20.1f %n", radius);
        System.out.printf("The surface area of the cone is: %14.1f %n" , area);
        System.out.printf("The volume of the cone is: %20.1f %n" , volume);
        sc.close();
        
}
}