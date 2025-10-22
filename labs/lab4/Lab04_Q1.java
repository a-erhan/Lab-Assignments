
import java.util.Scanner;

public class Lab04_Q1 {
    public static void main(String[] arguments){

        boolean status = true;
        
        do{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a valid height: ");
        if(sc.hasNextInt()){
            int height = sc.nextInt();
            if (height <= 0 || height >= 30)
            {
                System.out.println("Invalid input, try again."); 
            }
            else{
                status = false;
                //Nested loops here
                for( int count = 1; count <= height ;count++)
                {
                    for(int x = height - count; x > 0 ; x-- ){
                        System.out.print(" ");
                    }
                    
                    for(int x = 2 * count -1 ; x > 0 ; x-- ){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                
            }
            

        }
        else{
            System.out.println("Invalid input, try again.");

        }
        

        }while(status);
    }
    }
    

