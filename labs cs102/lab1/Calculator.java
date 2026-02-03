
import java.util.Scanner;

public class Calculator {
    private static Scanner sc = new Scanner(System.in);
    private static String row = "=========================================";
    public static void main(String[] arguments){
        System.out.println(row);
        Algebraic first = getAlg("Enter Vector or Matrix");
        String text = first instanceof Matrix ? "Determinant" : "Cross Product";
        boolean isCont = true;
        while(isCont){
            System.out.printf("Select an operation: %n" + 
                                "1: Negate %n" + 
                                "2: Add %n" + 
                                "3: Subtract %n" + 
                                "4: Multiply %n" + 
                                "5: %s %n" + 
                                "6: Compare %n" + 
                                "7: Exit %n" + 
                                "Enter your choice: ", text);
            String oper = sc.next().trim();
            sc.nextLine();
            //I check 7 first to enhance the performance
            if(oper.equals("7")){
                isCont = false;
                System.out.println("Exiting...");
            }
            
            else if(oper.equals("1")){
                System.out.println("-" + first + " = " + first.negate());
            }
            
            else if(oper.equals("2")){
                Algebraic second = getAlg("Enter the second vector or matrix:");
                Algebraic result = first.add(second);
                if(result == null){
                    System.err.println("Invalid operation...");
                }else{
                    print(first, second, "+" , result);
                }
            }
            
            else if(oper.equals("3")){
                Algebraic second = getAlg("Enter the second vector or matrix:");
                Algebraic result = first.subtract(second);
                if(result == null){
                    System.err.println("Invalid operation...");
                }else{
                    print(first, second, "-" , result);
                }
            }
            
            else if(oper.equals("4")){
                Algebraic second = getAlg("Enter the second vector or matrix:");
                Algebraic result = first.multiply(second);
                if(result == null){
                    System.err.println("Invalid operation...");
                }else{
                    print(first, second, "*" , result);
                }
            }
            
            else if(oper.equals("6")){
                Algebraic second = getAlg("Enter the second vector or matrix:");
                boolean result = first.equals(second);
                print(first, second, "==" , new Boolean(result));
            }
            
            else if(oper.equals("5") && first instanceof Matrix){
                System.out.println(((Matrix)first).determinant());
            }
            
            else if(oper.equals("5") && first instanceof Vector){
                Algebraic second = getAlg("Enter the second vector or matrix:");
                if(second instanceof Vector){
                    Vector ans = ((Vector)first).crossproduct((Vector)second);
                    if(ans == null){
                        System.out.println("Invalid operation...");
                    }
                    else{
                        print(first, second, "X" , ans);
                    }
                }else{
                    System.out.println("Invalid operation...");
                }        
            }
            
            else{
                System.out.println("Invalid operation... Choose another one");
            }
            System.out.println();
        }
    }

    public static Vector getVec(int dim2){
        System.out.print("Enter the elements of the vector seperated by spaces: ");
            float[] data = new float[dim2];
            for(int i = 0; i < dim2 && sc.hasNextFloat(); i++){
                data[i] = sc.nextFloat();
            }
            Vector v = new Vector(data);
            System.out.println(v);
            System.out.println(row);
            return v;
    }

    public static Matrix getMat(int dim1, int dim2){
        System.out.print("Enter the elements of the matrix seperated by spaces: ");
            float[][] data = new float[dim1][dim2];
            for(int i = 0; i < dim2 * dim1 && sc.hasNextFloat(); i++){
                data[i/dim2][i % dim2] = sc.nextFloat();
            }
            Matrix mat;
            if(LTMatrix.isValidLTM(data)){
                mat = new LTMatrix(data);
            }else{
                mat = new Matrix(data);
            }
            System.out.println(mat);
            System.out.println(row);
            return mat;
    }

    public static Algebraic getAlg(String prompt){
        System.out.println(prompt);
        Algebraic alg = null;
        System.out.print("Enter number of rows and columns (n x m): ");
        int dim1 = 0, dim2 = 0;

        dim1 = sc.nextInt();
        dim2 = sc.nextInt();
        sc.nextLine();

        if(dim1 == 1 || dim2 == 1){
            alg = getVec(Math.max(dim1, dim2));
        }else{
            alg = getMat(dim1, dim2);
        }

        return alg;
    }

    public static void print(Algebraic operand1, Algebraic operand2, String operator, Object result){
            String s1 = (operand1 == null) ? "null" : operand1.toString();
            String s2 = (operand2 == null) ? "null" : operand2.toString();
            String r = (result == null) ? "null" : result.toString();
            
            String[] rows1  = s1.split("\\R");
            String[] rows2  = s2.split("\\R");
            String[] rows3  = r.split("\\R");

            int height1 = rows1.length, height2 = rows2.length, height3 = rows3.length;
            int maxH = Math.max(height1, Math.max(height2, height3));

            int width1 = (height1 > 0) ? rows1[0].length() : 0;
            int width2 = (height2 > 0) ? rows2[0].length() : 0;

            int opRow = maxH / 2;

            String opStr = " " + operator + " "; 
            
            String arrowStr;
            if(operator.equals("==")){
                arrowStr = " ==> "; 
            } else {
                arrowStr = " = ";   
            }

            String currentLine;
            for(int i = 0; i < maxH; i++){
                currentLine = "";
                
                if(i < height1){
                    currentLine += rows1[i];
                }else{
                    currentLine += spaces(width1);
                }
                
                if(i == opRow){
                    currentLine += opStr;
                }else{
                    currentLine += spaces(opStr.length());
                }

                if(i < height2){
                    currentLine += rows2[i];
                }else{
                    currentLine += spaces(width2);
                }

                if(i == opRow){
                    currentLine += arrowStr;
                }else{
                    currentLine += spaces(arrowStr.length());
                }

                if(i < height3){
                    currentLine += rows3[i];
                }

                System.out.println(currentLine);
            }
        }
        
        private static String spaces(int n){
            String ans = "";
            for(int i = 0; i < n ; i++){
                ans += " "; 
            }
            return ans;
    }
}