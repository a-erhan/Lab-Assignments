import java.util.Scanner;
public class Lab04_Q2 {
    public static void main(String[] arguments) {
        Scanner sc = new Scanner(System.in);
        boolean status = true;
        do { 
            System.out.print("Enter a positive integer (0 to quit):");
            if(sc.hasNextInt()){
                int number = sc.nextInt();
                if(number > 0){
                    String numString = Integer.toString(number);
                    int len = numString.length();
                    boolean isPalindrome = true;
                    for( int idx = 0; idx < len/2; idx++){
                        if(!(numString.charAt(idx) == numString.charAt(len-idx-1)))
                        {
                            isPalindrome = false;
                        }
                    }
                    if (isPalindrome){
                        System.out.printf("%d is a palindrome%n", number);
                    }
                    else{
                        System.out.printf("%d is not a palindrome%n", number);
                    }
                }
                else if (number == 0 ) {
                    status = false;
                    System.out.println("Program ended.");
                    
                }
                else{
                    
                    System.out.println("Only positive integers are allowed.");
                }

            }
            else{
                status = false;
                System.out.println("Only positive integers are allowed.");
            }

            
        } while (status);

        
    }
    
}
