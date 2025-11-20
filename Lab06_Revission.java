import java.util.ArrayList;
import java.util.Scanner;

public class Lab06_Revission {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        sc.nextLine();

        boolean[] validRows = new boolean[rows];  

        
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
        
        //Taking blocked inputs
        ArrayList<int[]> seats = new ArrayList<>();
        for(int ind = 0; ind < rows; ind++){
            System.out.printf("Enter the blocked seat indices for row %d :",ind + 1);
            String blockedSeatsRow = sc.nextLine();
            boolean cont = true;
            int[] blockedRowArray = new int[cols];
            while (cont && (idx = blockedSeatsRow.indexOf(',')) != -1 ) {
                int currentInt = Integer.parseInt(blockedSeatsRow.substring(0, idx).trim());                
                if(currentInt > cols){
                    System.out.printf("Seat index %d exceeds columns %d in row %d.%n",currentInt, cols, ind);
                    cont = false;
                }
                else{
                    blockedRowArray[currentInt] = 1;
                    
                }
                blockedSeatsRow = blockedSeatsRow.substring(idx + 1); 
                
            }
            seats.add(blockedRowArray);
        }
        //If there is no error yet



        for (int n = 0; n < rows; n++) {
            for(int l = 0; l < seats.get(n).length; l++){
                System.out.print(seats.get(n)[l]);
            }
            System.out.println();
            
        }
        
        if(isContinue){
            
            for(int i = 0; i < rows; i++){
                
                int k = groupSizes.get(i);

                int[] consecutiveRanges = new int[2];
                int endOfFirstRange = -1;
                int midOfFirstRange = -1 ;
                int startOfLastRange = -1;
                int midOfLastRange = -1;
                boolean searchingFirst = true;
                for(int j = 0 ; j < seats.get(i).length; j++){
                    if(searchingFirst && seats.get(i)[j] == 1){
                        consecutiveRanges[0] = j;
                        endOfFirstRange = j-1;
                        midOfFirstRange = endOfFirstRange / 2;
                        searchingFirst = false;
                    }
                    if(!searchingFirst &&  seats.get(i)[j] == 0){
                        consecutiveRanges[1] = cols - j +1 ; 
                        startOfLastRange = j;
                        midOfLastRange = (4 + cols)/2;
                    }
                }
                if(consecutiveRanges[0] < k && consecutiveRanges[1] < k){
                    validRows[i] = false;
                }

                int colMidIdx = (cols -1)/2;

                int activeSide = Math.abs(midOfFirstRange - colMidIdx) < Math.abs(midOfLastRange - colMidIdx) ? 1 : 0;

                if(activeSide == 0 && consecutiveRanges[0] < groupSizes.get(i)){
                    activeSide = 1;
                }
                if(activeSide == 1 && consecutiveRanges[1] < groupSizes.get(i)){
                    validRows[i] = false;
                }
                if( activeSide == 0){
                    for(int l = endOfFirstRange; l >= 0; l--){
                        seats.get(i)[l] = 2;
                    }
                }
                else{
                    for(int l = startOfLastRange; l < cols ; l++){
                        seats.get(i)[l] = 2;
                    }
                }
                

                


            }  
        }
    }
    public static int arraySum(int[] arr){
        int result = 0;
        for(int a : arr){
            result += a;
        }
        return result;
    }
}
