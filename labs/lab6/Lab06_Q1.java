import java.util.ArrayList;
import java.util.Scanner;

public class Lab06_Q1 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        sc.nextLine();
        
        System.out.printf("Enter the groups for %d rows and %d columns: ", rows, cols);
        ArrayList<Integer> groupSizes= new ArrayList<>();
        int row = 1;
        boolean isContinue = true;
        String inputs = sc.nextLine();
        int idx;

        while ((idx = inputs.indexOf(',')) != -1 && isContinue) {
            int currentInt = Integer.parseInt(inputs.substring(0, idx).trim());
            groupSizes.add(currentInt);
            if(currentInt > cols){
                System.out.printf("Error: Group size %d exceeds columns %d in row %d.%n",currentInt, cols, groupSizes.size());
                isContinue = false;
            }
            inputs = inputs.substring(idx + 1); 
        }
        if (inputs.length() != 0) {
                groupSizes.add(Integer.parseInt(inputs.trim()));
            }
            
            if(rows != groupSizes.size()){
                System.out.printf("Error: expected %d group sizes but got %d.%n",rows,groupSizes.size());
                isContinue = false;
            }
        //If there is no error
        if(isContinue){
            
            for(int i = 0; i < rows; i++){
                int k = groupSizes.get(i);

                if(k == 1){
                    System.out.print('x');
                    for(int j = 1; j < cols; j++) System.out.print('-');
                    System.out.println();
                }
                else{
                    int g = (cols - k) / (k - 1);
                    int remainder = (cols - k) % (k - 1);

                    System.out.print('x');
                    
                    for(int j = 1; j < k; j++){
                        int gap;
                        if(j <= remainder){
                            gap = g+1;
                        } 
                        else{
                            gap = g;
                        }
                        for(int s = 0; s < gap; s++) System.out.print('-');
                        System.out.print('x');
                    }
                    System.out.println();
                }


            }  
        }
    }
}
