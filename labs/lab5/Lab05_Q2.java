package lab5;

import java.util.Scanner;

public class Lab05_Q2 {
    static boolean isLowerCase(char ch){
        if(ch == Lab05_Q1.toLower(ch)){
            return true;
        }
        else{ return false;}
    }
    
    public static String reverseText(String text) {
    String result = "";
    for (int i = text.length() - 1; i >= 0; i--) {
        result += text.charAt(i);
    }
    return result;
    }
    public static String atbashCipher(String text){
        String result = "";
        int length = text.length();
        for (int i = 0; i < length; i++) {
            char currentCharacter = text.charAt(i);
            if(Lab05_Q1.isLetter(currentCharacter)){
                if(isLowerCase(currentCharacter)){
                    result+=(char)('z'-(currentCharacter -'a'));
                }
                else{
                    result+=(char)('Z'-(currentCharacter -'A'));
                }
            }
            else{
                result+=currentCharacter;
            }
        }
        return result;
    }

    public static String caesarCipher(String text,int shift,boolean encode){
        int actualShift = encode ? shift : -shift ;
            String result = "";
            for (int i = 0; i < text.length(); i++) {
                result += shifter(text.charAt(i), actualShift);
            }
            return result;
        }
    
    static char shifter(char ch, int shift){
        if(Lab05_Q1.isLetter(ch)){
            if(isLowerCase(ch)){
                int val = ch - 'a';
                val+=shift;
                val = val % 32;
                val = (val > 0) ? val : -val ;
                val += 'a';
                return (char)val;
            }
            else{
                int val = ch - 'A';
                val+=shift;
                val = val % 26;
                val = val > 0 ? val : -val ;
                val += 'A';
                return (char)val;
            }
        }
        return ch;
    }

    public static void main( String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("=== Cipher toolkit ===");
            System.out.println("1) Caesar Cipher");
            System.out.println("2) Atbash Cipher");
            System.out.println("3) Reverse Text");
            System.out.println("4) Exit");
        
            System.out.print("Choose an option (1-4): ");
            int operation = sc.nextInt();
            sc.nextLine();
            if(operation == 1){
                System.out.print("Enter text: ");
                String str = sc.nextLine();
                System.out.print("Enter shift amount (1-25):");
                int shift = sc.nextInt();
                System.out.print("Type 'e' to encode or 'd' to decode: ");
                String oper = sc.next();
                if(oper.equals("e")) {
                    String result = caesarCipher(str, shift, true);
                    System.out.print("Result: "+result);
                }
                else if(oper.equals("d")){
                    String result = caesarCipher(str, shift, false);
                    System.out.println("Result: "+result);
                }
                else{
                    System.out.println("No operation found!");
                }
                
                
            }
            else if (operation == 2) {
                System.out.print("Enter the text: ");
                String str = sc.nextLine();
                System.out.println("Result: "+atbashCipher(str));
                
            }
            else if (operation == 3) {
                System.out.print("Enter the text: ");
                String str = sc.nextLine();
                System.out.println("Reversed text: "+reverseText(str));
            }
            else if (operation == 4) {
                System.out.println("Goodbye");
            }
            else{
                System.out.println("No operation found");
                main(args);
            }
        }
    }
    
