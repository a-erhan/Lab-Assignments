import javax.swing.ImageIcon;
import javax.swing.JOptionPane; //CHANGED

public class Calc_GUI {
    private static String row = "=========================================";
    private static ImageIcon customIcon = new ImageIcon("logo.png"); //CHANGED

    public static void main(String[] arguments){
        Algebraic first = getAlg("Enter Vector or Matrix");
        if (first == null) return; 

        String text = first instanceof Matrix ? "Determinant" : "Cross Product";
        boolean isCont = true;
        while(isCont){
            String menu = String.format("Select an operation: %n" + 
                                "1: Negate %n" + 
                                "2: Add %n" + 
                                "3: Subtract %n" + 
                                "4: Multiply %n" + 
                                "5: %s %n" + 
                                "6: Compare %n" + 
                                "7: Exit %n" + 
                                "Enter your choice: ", text);
            
            String oper = (String) JOptionPane.showInputDialog(null, menu, "Calculator", JOptionPane.PLAIN_MESSAGE, customIcon, null, null); //CHANGED
            
            if(oper == null || oper.equals("7")){ 
                isCont = false;
                JOptionPane.showMessageDialog(null, "Exiting...", "Exit", JOptionPane.INFORMATION_MESSAGE, customIcon); //CHANGED
            }
            
            else if(oper.equals("1")){
                JOptionPane.showMessageDialog(null, "-" + first + " = " + first.negate(), "Result", JOptionPane.INFORMATION_MESSAGE, customIcon); //CHANGED
            }
            
            else if(oper.equals("2")){
                Algebraic second = getAlg("Enter the second vector or matrix:");
                Algebraic result = first.add(second);
                if(result == null){
                    JOptionPane.showMessageDialog(null, "Invalid operation...", "Error", JOptionPane.ERROR_MESSAGE, customIcon); //CHANGED
                }else{
                    JOptionPane.showMessageDialog(null, first + " + " + second + " = " + result, "Result", JOptionPane.INFORMATION_MESSAGE, customIcon); //CHANGED
                }
            }
            
            else if(oper.equals("3")){
                Algebraic second = getAlg("Enter the second vector or matrix:");
                Algebraic result = first.subtract(second);
                if(result == null){
                    JOptionPane.showMessageDialog(null, "Invalid operation...", "Error", JOptionPane.ERROR_MESSAGE, customIcon); //CHANGED
                }else{
                    JOptionPane.showMessageDialog(null, first + " - " + second + " = " + result, "Result", JOptionPane.INFORMATION_MESSAGE, customIcon); //CHANGED
                }
            }
            
            else if(oper.equals("4")){
                Algebraic second = getAlg("Enter the second vector or matrix:");
                Algebraic result = first.multiply(second);
                if(result == null){
                    JOptionPane.showMessageDialog(null, "Invalid operation...", "Error", JOptionPane.ERROR_MESSAGE, customIcon); //CHANGED
                }else{
                    JOptionPane.showMessageDialog(null, first + " * " + second + " = " + result, "Result", JOptionPane.INFORMATION_MESSAGE, customIcon); //CHANGED
                }
            }
            
            else if(oper.equals("6")){
                Algebraic second = getAlg("Enter the second vector or matrix:");
                boolean result = first.equals(second);
                JOptionPane.showMessageDialog(null, first + " == " + second + " ==> " + result, "Comparison", JOptionPane.INFORMATION_MESSAGE, customIcon); //CHANGED
            }
            
            else if(oper.equals("5") && first instanceof Matrix){
                JOptionPane.showMessageDialog(null, "Determinant: " + ((Matrix)first).determinant(), "Determinant", JOptionPane.INFORMATION_MESSAGE, customIcon); //CHANGED
            }
            
            else if(oper.equals("5") && first instanceof Vector){
                Algebraic second = getAlg("Enter the second vector:");
                if(second instanceof Vector){
                    Vector ans = ((Vector)first).crossproduct((Vector)second);
                    if(ans == null){
                        JOptionPane.showMessageDialog(null, "Invalid operation...", "Error", JOptionPane.ERROR_MESSAGE, customIcon); //CHANGED
                    }
                    else{
                        JOptionPane.showMessageDialog(null, first + " x " + second + " = " + ans, "Cross Product", JOptionPane.INFORMATION_MESSAGE, customIcon); //CHANGED
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid operation...", "Error", JOptionPane.ERROR_MESSAGE, customIcon); //CHANGED
                }        
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Invalid operation... Choose another one", "Warning", JOptionPane.WARNING_MESSAGE, customIcon); //CHANGED
            }
        }
    }

    public static Vector getVec(int dim2){
        String input = (String) JOptionPane.showInputDialog(null, "Enter " + dim2 + " elements:", "Vector Input", JOptionPane.PLAIN_MESSAGE, customIcon, null, null); //CHANGED
        if (input == null) return null;
        String[] parts = input.trim().split("\\s+"); 
        float[] data = new float[dim2];
        for(int i = 0; i < dim2 && i < parts.length; i++){ 
            data[i] = Float.parseFloat(parts[i]); 
        }
        return new Vector(data);
    }

    public static Matrix getMat(int dim1, int dim2){
        String input = (String) JOptionPane.showInputDialog(null, "Enter elements for " + dim1 + "x" + dim2 + ":", "Matrix Input", JOptionPane.PLAIN_MESSAGE, customIcon, null, null); //CHANGED
        if (input == null) return null;
        String[] parts = input.trim().split("\\s+"); 
        float[][] data = new float[dim1][dim2];
        for(int i = 0; i < dim1 * dim2 && i < parts.length; i++){ 
            data[i/dim2][i % dim2] = Float.parseFloat(parts[i]); 
        }
        return new Matrix(data);
    }

    public static Algebraic getAlg(String prompt){
        String input = (String) JOptionPane.showInputDialog(null, prompt + "\nEnter dimensions (n m):", "Dimensions", JOptionPane.PLAIN_MESSAGE, customIcon, null, null); //CHANGED
        if (input == null) return null; 
        String[] dims = input.trim().split("\\s+"); 
        int dim1 = Integer.parseInt(dims[0]); 
        int dim2 = Integer.parseInt(dims[1]); 

        if(dim1 == 1) return getVec(dim2);
        else return getMat(dim1, dim2);
    }
}