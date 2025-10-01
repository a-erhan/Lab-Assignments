import java.util.Scanner;
public class Lab02_Q1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter the volume of the cone: ");
        double volume = sc.nextDouble();
        System.out.print("Enter the height of the cone: ");
        double height = sc.nextDouble();

        double radius = Math.sqrt(3*volume/(Math.PI*height));
        double area = Math.PI*radius*(radius + height);

        System.out.printf("The radius of the cone is: %20.1f %n", radius);
        System.out.printf("The surface area of the cone is: %14.1f %n" , area);
        
    }
}